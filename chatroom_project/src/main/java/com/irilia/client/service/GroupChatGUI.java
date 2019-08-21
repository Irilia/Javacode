package com.irilia.client.service;

import com.irilia.client.vo.MessageVo;
import com.irilia.util.CommUtil;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Set;

public class GroupChatGUI {
    private JTextArea readFromServer;
    private JPanel groupChatPanel;
    private JTextField sendToServer;
    private JPanel friendList;
    private JFrame frame;
    private Set<String> friends;
    private ConnecteToServer connecteToServer;
    private String myName;
    //传入群名
    private String groupName;
    public GroupChatGUI(String groupName, Set<String> friends,ConnecteToServer connecteToServer,String myName){
        this.connecteToServer = connecteToServer;
        this.myName = myName;
        this.friends = friends;
        this.groupName = groupName;
        frame = new JFrame(groupName);
        frame.setContentPane(groupChatPanel);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        //1.好友列表的更新
        friendList.setLayout(new BoxLayout(friendList,BoxLayout.Y_AXIS));
        Iterator<String> iterator = friends.iterator();
        while(iterator.hasNext()){
            String friendName = iterator.next();
            JLabel label = new JLabel(friendName);
            friendList.add(label);
        }
        //2.enter发送信息的监听
        sendToServer.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
               StringBuilder sb = new StringBuilder();
               sb.append(sendToServer.getText());
               if(e.getKeyCode() == KeyEvent.VK_ENTER){
                   //把信息发到服务端
                   //type:4
                   //content:senderName-msg
                   //to:groupNAme
                   //获取要发的字符串
                   String str = sb.toString();
                   MessageVo messageVo = new MessageVo();
                   messageVo.setType(4);
                   messageVo.setContent(myName+"-"+str);
                   messageVo.setTo(groupName);
                   try {
                       PrintStream out = new PrintStream(connecteToServer.getOut(),true,"UTF-8");
                       out.println(CommUtil.objectToJson(messageVo));
                       //吧文本置为空
                       sendToServer.setText("");
                   } catch (UnsupportedEncodingException e1) {
                       e1.printStackTrace();
                   }


               }
            }
        });
    }
    public void readFormServer(String msg){
        readFromServer.append(msg+"\n");
    }
    public JFrame getFrame(){
        return frame;
    }


}
