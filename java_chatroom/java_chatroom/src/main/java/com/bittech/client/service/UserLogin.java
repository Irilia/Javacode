package com.bittech.client.service;

import com.bittech.client.dao.AccountDao;
import com.bittech.client.entity.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author: yuisama
 * @Date: 2019-08-16 11:36
 * @Description:
 */
public class UserLogin {
    private JPanel loginPanel;
    private JPanel labelPanel;
    private JPanel userNamePanel;
    private JTextField userNameText;
    private JPanel passwordPanel;
    private JPanel btnPanel;
    private JButton regBtn;
    private JButton loginBtn;
    private JPasswordField passwordText;
    private AccountDao accountDao = new AccountDao();

    public UserLogin() {
        // 点击注册按钮，弹出注册页面
        regBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserReg();
            }
        });
        // 点击登录按钮，验证用户输入信息是否正确
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取用户输入
                String userName = userNameText.getText();
                String password = String.valueOf(
                        passwordText.getPassword());
                User user = accountDao.userLogin(userName,password);
                if (user != null) {
                    // 登录成功
                    JOptionPane.showMessageDialog(null,"登录成功",
                            "提示信息",JOptionPane.INFORMATION_MESSAGE);
                    // 跳转到用户列表界面
                }else {
                    JOptionPane.showMessageDialog(null,"登录失败",
                            "错误信息",JOptionPane.ERROR_MESSAGE);
                    // 保留当前登录界面
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("用户登录");
        frame.setContentPane(new UserLogin().loginPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // 居中显示
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
