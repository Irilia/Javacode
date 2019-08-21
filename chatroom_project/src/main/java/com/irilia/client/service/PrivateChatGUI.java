package com.irilia.client.service;

import com.irilia.client.vo.MessageVo;
import com.irilia.util.CommUtil;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class PrivateChatGUI {
    private JPanel PrivateChatPanel;
    private JTextArea ReadFromServer;
    private JTextField SendtoServer;
    private JFrame frame;
    private String friendName;
    private String myName;
    private ConnecteToServer connecteToServer;

    //type:2
    //content:senderName-msg
    //to:friendName


    public PrivateChatGUI(String friendName,String myName,ConnecteToServer connecteToServer){
        this.friendName = friendName;
        this.myName = myName;
        this.connecteToServer = connecteToServer;
        frame = new JFrame("与"+friendName+"私聊中。。");
        frame.setContentPane(PrivateChatPanel);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(400,400);
        frame.setVisible(true);
        //添加一个输入框事件，敲回车发送消息
        SendtoServer.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                StringBuilder sb = new StringBuilder();
                sb.append(SendtoServer.getText());
                //当按下回车键是发生文本信息
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    String str = sb.toString();
                    MessageVo messageVo = new MessageVo();
                    messageVo.setType(2);
                    messageVo.setContent(myName+"-"+str);
                    messageVo.setTo(friendName);
                    try {
                        PrintStream out = new PrintStream(connecteToServer.getOut(),true,"UTF-8");
                        out.println(CommUtil.objectToJson(messageVo));
                        //刷新自己的信息读取框
                        ReadFromServer.append(myName+"说："+str+"\n");
                        //清空输入框
                        SendtoServer.setText("");
                    } catch (UnsupportedEncodingException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }
    //信息接收方收到信息后要展示信息
    public void readFromServer(String msg){
        ReadFromServer.append(msg+"\n");
    }
    public JFrame getFrame(){
        return frame;
    }

}
