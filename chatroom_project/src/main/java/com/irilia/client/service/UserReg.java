package com.irilia.client.service;

import com.irilia.client.dao.AccountDao;
import com.irilia.client.entity.User;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//用户注册界面的信息，控件，及操作
public class UserReg {
    private JPanel regPanel;
    private JTextField userNametext;
    private JPasswordField passwordTest;
    private JTextField briefText;
    private JButton configButton;

    //user层需要dao层的方法，传入对象
    private AccountDao accountDao = new AccountDao();
    //注册构造方法
    public UserReg() {
        //点击注册就会弹出注册界面
        JFrame frame = new JFrame("用户的注册");
        frame.setContentPane(regPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设计居中显示界面
        frame.setLocationRelativeTo(null);
        frame.pack();
        //提示框可见，置为true
        frame.setVisible(true);

        //点击提交按钮触发此方法，和数据库连接
        configButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //1.获取界面上三个控件的内容
                String userName = userNametext.getText();
                String passWord = String.valueOf(passwordTest.getPassword());
                String brief = briefText.getText();
                //2.调用dao层方法，将信息持久化到数据库
                User user  = new User();
                user.setUserName(userName);
                user.setPassword(passWord);
                user.setBrief(brief);
                System.out.println(user);
                //如果注册成功，弹出提示框，提示用户信息注册成功，返回登录界面
                //如果注册失败，弹出提示框告知用户注册失败，保留当前注册页面
                if(accountDao.userReg(user)){
                    JOptionPane.showMessageDialog(null,"注册成功",
                            "成功信息",JOptionPane.INFORMATION_MESSAGE);
                    //提示完后提示框消失，置为false
                    frame.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"注册失败","错误信息", JOptionPane.ERROR_MESSAGE);

                }
            }
        });
    }

}
