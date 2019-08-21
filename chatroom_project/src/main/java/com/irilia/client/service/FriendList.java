package com.irilia.client.service;

import com.irilia.client.vo.MessageVo;
import com.irilia.util.CommUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class FriendList {
    private JPanel FriendListPanel;
    private JScrollPane friendPanel;
    private JButton CreateGroupButton;
    //放所有的群聊信息
    private JScrollPane groupPanel;

    private String myName;
    private ConnecteToServer connecteToServer;
    private Set<String> names;

    //缓存所有的私聊界面map<私聊的对象名称，私聊界面>
    private Map<String,PrivateChatGUI> privateChatGUIMap = new ConcurrentHashMap<>();
    //客户端缓存所有群聊信息
    private Map<String,Set<String>> groupInfo = new ConcurrentHashMap<>();
    //缓存当前客户端群聊界面
    private Map<String,GroupChatGUI> groupChatGUIMap = new ConcurrentHashMap<>();
    //后台线程
    private class DaemonTask implements Runnable{
        //获取到连接的输入流
        private Scanner scanner = new Scanner(connecteToServer.getIn());
        @Override
        public void run() {
            while(true){
                if(scanner.hasNextLine()){
                    //发的是json字符串
                    String strFromServer = scanner.nextLine();
                    //得知这是一个好友上线
                    if(strFromServer.startsWith("newLogin:")){
                        //发送好友提醒
                        String newFrind = strFromServer.split(":")[1];
                        JOptionPane.showMessageDialog(null,
                                newFrind+"上线了！","上线提醒",JOptionPane.INFORMATION_MESSAGE);
                        names.add(newFrind);
                        //再次刷新好友列表
                        reloadFriendList();
                    }
                    if(strFromServer.startsWith("{")){
                        //此时是个json串
                        MessageVo messageVoFromClient = (MessageVo) CommUtil.
                                jsonToObject(strFromServer,MessageVo.class);
                        if(messageVoFromClient.getType().equals(2)){
                            //私聊信息
                            String senderName = messageVoFromClient.getContent().split("-")[0];
                            String msg = messageVoFromClient.getContent().split("-")[1];
                            //如果缓存中有界面，唤醒界面
                            if(privateChatGUIMap.containsKey(senderName)){
                                PrivateChatGUI privateChatGUI = privateChatGUIMap.get(senderName);
                                privateChatGUI.getFrame().setVisible(true);
                                privateChatGUI.readFromServer(senderName+"说"+msg);
                            }else {
                                //缓存中没有界面就新建一个界面，并且保存到缓存中
                                PrivateChatGUI privateChatGUI = new PrivateChatGUI(senderName,myName,connecteToServer);
                                privateChatGUIMap.put(senderName,privateChatGUI);
                                privateChatGUI.readFromServer(senderName+"说:"+msg+"\n");
                            }
                        }else if(messageVoFromClient.getType().equals(4)){
                            //群聊信息
                            String senderName = messageVoFromClient.getContent().split("-")[0];
                            String groupMsg = messageVoFromClient.getContent().split("-")[1];
                            String groupName = messageVoFromClient.getTo().split("-")[0];
                            if(groupInfo.containsKey(groupName)){
                                //判断一下界面存不存在
                                if(groupChatGUIMap.containsKey(groupName)){
                                    GroupChatGUI groupChatGUI = groupChatGUIMap.get(groupName);
                                    groupChatGUI.getFrame().setVisible(true);
                                    groupChatGUI.readFormServer(senderName+"说："+groupMsg+"\n");
                                }else{
                                    //没有界面，创建界面
                                    Set<String> friends = groupInfo.get(groupName);
                                    GroupChatGUI groupChatGUI = new GroupChatGUI(groupName,friends,connecteToServer,myName);
                                    //添加到缓存中
                                    groupChatGUIMap.put(groupName,groupChatGUI);
                                    groupChatGUI.readFormServer(senderName+"说："+groupMsg+"\n");
                                }
                            }else{
                                //1.将群信息和群成员添加到本客户端群聊列表
                                Set<String> friends = (Set<String>) CommUtil.
                                        jsonToObject(messageVoFromClient.getTo().split("-")[1],Set.class);
                                addGroupInfo(groupName,friends);
                                reloadGroupList();
                                //2.没有群聊界面，new一个
                                GroupChatGUI groupChatGUI = new GroupChatGUI(groupName,friends,connecteToServer,myName);
                                //添加到缓存中
                                groupChatGUIMap.put(groupName,groupChatGUI);
                                groupChatGUI.readFormServer(senderName+"说："+groupMsg+"\n");

                            }
                        }
                    }
                }
            }
        }
    }
    //私聊的标签事件
    private class PrivateLabelAction implements MouseListener{
        //标签的点击事件
        //传入标签的名字
        private String labelName;
        public PrivateLabelAction(String labelName){
            this.labelName = labelName;
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            //判断缓存中是否有指定的私聊界面，没有就new一个，有就从缓存中取出
            if(privateChatGUIMap.containsKey(labelName)){
                PrivateChatGUI privateChatGUI = privateChatGUIMap.get(labelName);
                //唤醒界面
                privateChatGUI.getFrame().setVisible(true);
            }else{
                PrivateChatGUI privateChatGUI = new PrivateChatGUI(labelName,myName,connecteToServer);
                privateChatGUIMap.put(labelName,privateChatGUI);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    //群聊的标签事件
    private class GroupLabelAction implements MouseListener{
        //群名
        private String groupName;

        public GroupLabelAction(String groupName) {
            this.groupName = groupName;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            //如果已经有这个界面，将这个界面唤醒
            if(groupChatGUIMap.containsKey(groupName)){
                GroupChatGUI groupChatGUI = groupChatGUIMap.get(groupName);
                groupChatGUI.getFrame().setVisible(true);
            }else{
                Set<String> friends = groupInfo.get(groupName);
                GroupChatGUI groupChatGUI = new GroupChatGUI(groupName,friends,connecteToServer,myName);
                groupChatGUIMap.put(groupName,groupChatGUI);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    public FriendList(String myName,ConnecteToServer connecteToServer,Set<String> names){
        this.myName = myName;
        this.connecteToServer = connecteToServer;
        this.names = names;
        //界面的展现
        JFrame frame = new JFrame(myName);
        frame.setContentPane(FriendListPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //窗体大小
        frame.setSize(400,400);
        //居中显示
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        //加载好友列表
        reloadFriendList();
        //新启动一个后台线程不断监听服务器发来的信息
        Thread daemonThread = new Thread(new DaemonTask());
        //设置线程为后台线程
        daemonThread.setDaemon(true);
        daemonThread.start();
        //点击创建群组，弹出创建界面
            //匿名内部类，在调用当前对象时要调用外部类的对象
        CreateGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreateGroupGUI(names,myName,connecteToServer,FriendList.this);
            }
        });
    }

    //动态展示窗口
    public void reloadFriendList(){
        JPanel friendLablePanel = new JPanel();
        JLabel[] labels = new JLabel[names.size()];
        //迭代遍历set集合
        Iterator<String> iterator = names.iterator();
        //调整布局设置标签为纵向对其
        friendLablePanel.setLayout(new BoxLayout(friendLablePanel,BoxLayout.Y_AXIS));
        int i = 0;
        while(iterator.hasNext()){
            //创建好所欲标签并设置好了名字
            String labelName = iterator.next();
            labels[i] = new JLabel(labelName);
            //给每个标签附加按钮的点击事件
            labels[i].addMouseListener(new PrivateLabelAction(labelName));
            //吧创建好的标签放进盘子里
            friendLablePanel.add(labels[i]);
            i++;
        }
        this.friendPanel.setViewportView(friendLablePanel);
        //设置滚动条竖向滚动
        this.friendPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.friendPanel.revalidate();
    }

    //刷新群聊列表的群聊信息
    //保存了多少个群就遍历多少次
    public void reloadGroupList(){
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));
        Set<String> groupNames = groupInfo.keySet();
        Iterator<String> iterator = groupNames.iterator();
        while(iterator.hasNext()){
            String groupName = iterator.next();
            JLabel label = new JLabel(groupName);
            label.addMouseListener(new GroupLabelAction(groupName));
            jPanel.add(label);
        }
        groupPanel.setViewportView(jPanel);
        //设置滚动方式为垂直滚动
        groupPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        groupPanel.revalidate();
    }

    //点击按钮之后有添加，添加方法
    public void addGroupInfo(String groupName,Set<String> friends){
        groupInfo.put(groupName,friends);
    }



}
