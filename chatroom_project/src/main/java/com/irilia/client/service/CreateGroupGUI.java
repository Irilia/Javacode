package com.irilia.client.service;

import com.irilia.client.vo.MessageVo;
import com.irilia.util.CommUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CreateGroupGUI {
    private JPanel createCroupPanel;
    private JPanel FriendLablePanel;
    private JTextField groupNameTest;
    private JButton conformBtn;
    //在线好友
    private Set<String> friends;
    private String myName;
    private ConnecteToServer connecteToServer;
    //好友列表
    private FriendList friendList;

    public CreateGroupGUI(Set<String> friends,String myName,ConnecteToServer connecteToServer,FriendList friendList){
        this.friends = friends;
        this.myName = myName;
        this.connecteToServer = connecteToServer;
        this.friendList = friendList;
        JFrame frame = new JFrame("创建群组");
        frame.setContentPane(createCroupPanel);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        //1.动态的添加checkBox
        //设置布局为垂直展示
        FriendLablePanel.setLayout(new BoxLayout(FriendLablePanel,BoxLayout.Y_AXIS));
        Iterator<String> iterator = friends.iterator();
        while(iterator.hasNext()){
            String labelName = iterator.next();
            JCheckBox checkBox = new JCheckBox(labelName);
            FriendLablePanel.add(checkBox);
        }

        //2.提交信息按键
        conformBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //1.获取群名称
                //2.获取选中的好友名称
                Set<String> selectedFriends = new HashSet<>();
                //3.获取checkBoxPanel下的所有组件
                Component[] components = FriendLablePanel.getComponents();
                for(Component component : components){
                    //向下转型
                    JCheckBox checkBox = (JCheckBox) component;
                    //如果被勾选了
                    if(checkBox.isSelected()){
                        String labelName = checkBox.getText();
                        selectedFriends.add(checkBox.getText());
                    }
                }
                selectedFriends.add(myName);
                String groupName = groupNameTest.getText();
                //4.将群名称与选择的好友发送到服务端
                //type:3注册群
                //content:groupName
                //to:[]群里包含了呢些人
                MessageVo messageVo = new MessageVo();
                messageVo.setType(3);
                messageVo.setContent(groupName);
                messageVo.setTo(CommUtil.objectToJson(selectedFriends));
                try {
                    //发送到服务端
                    PrintStream out = new PrintStream(connecteToServer.getOut(),true,"UTF-8");
                    out.println(CommUtil.objectToJson(messageVo));
                } catch (UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                }

                frame.setVisible(false);
                //返回好友列表界面，展示当前群名
                friendList.addGroupInfo(groupName,selectedFriends);
                friendList.reloadFriendList();

            }
        });
    }


}
