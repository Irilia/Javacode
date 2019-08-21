package com.irilia.client.service;

import com.irilia.client.dao.AccountDao;
import com.irilia.client.entity.User;
import com.irilia.client.vo.MessageVo;
import com.irilia.util.CommUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.Set;

public class UserLogin {
    private JPanel loginPanel;
    private JPanel labelPanel;
    private JPanel UserNamePanel;
    private JTextField userNameText;
    private JPasswordField passwordTest;
    private JPanel btnPanel;
    private JButton regbtn;
    private JButton loginButton;
    private AccountDao accountDao = new AccountDao();

    public UserLogin() {
        //界面的展现
        JFrame frame = new JFrame("用户登录");
        frame.setContentPane(loginPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置居中显示
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

        //点击注册按钮，弹出注册页面
        regbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //new就会调用UserReg的无参构造，就会弹出页面。
                new UserReg();
            }
        });
        //点击登录按钮，验证用户的输入信息是否正确
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //登录界面获取用户的输入
                String userName = userNameText.getText();
                String passWord = String.valueOf(passwordTest.getPassword());
                //查询一下用户登录的名字和密码与数据库中的是否一致，导入数据库连接对象
                User user = accountDao.userLogin(userName,passWord);
                if(user != null){
                    //在数据库中查到了这个用户，登录成功,弹出提示框提示用户登录成功
                    JOptionPane.showMessageDialog(null,"登录成功",
                            "提示信息",JOptionPane.INFORMATION_MESSAGE);
                    //与服务端建立连接,连接后要有输入输出流,将用户名注册到用户端缓存
                    ConnecteToServer connecteToServer = new ConnecteToServer();
                    MessageVo messageVo = new MessageVo();
                    messageVo.setType(1);
                    messageVo.setContent(userName);
                    String msgJson = CommUtil.objectToJson(messageVo);

                    try {
                        //发送信息
                        PrintStream out = new PrintStream(connecteToServer.getOut(),
                                true,"UTF-8");
                        out.println(msgJson);
                        //读取服务端发回的响应，读取到所有的在线好友信息
                        Scanner in = new Scanner(connecteToServer.getIn());
                        if(in.hasNextLine()){
                            String jsonStr = in.nextLine();
                            MessageVo msgFromServer = (MessageVo) CommUtil.jsonToObject(jsonStr,MessageVo.class);
                            Set<String> names = (Set<String>) CommUtil.jsonToObject(msgFromServer.getContent(),Set.class);
                            System.out.println("在线好友为"+names);
                            //加载好友列表界面，登录界面不可见
                            frame.setVisible(false);
                            //跳转到好友列表界面需要传递用户名，与服务器建立的连接也需要传过去，所有在线的好友信息
                            new FriendList(userName,connecteToServer,names);
                        }



                    } catch (UnsupportedEncodingException e1) {
                        e1.printStackTrace();
                    }
                    //跳转到用户列表

                }else {
                    //登录失败，弹出提示框告知用户登录失败
                    JOptionPane.showMessageDialog(null,"登录失败",
                            "提示信息",JOptionPane.ERROR_MESSAGE);
                    //保留当前的登录界面
                }
            }
        });
    }

    public static void main(String[] args) {
        new UserLogin();
    }
}
