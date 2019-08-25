package com.irilia.client.vo;
//服务端与客户端通信载体协议
public class MessageVo {
    //告知服务端要进行的操作：
    //1.表示新用户的注册
    //2.表示私聊
    //3.表示群聊
    private Integer type;
    //服务端与客户端聊天具体的内容
    private String content;
    //聊天信息发送的目标客户端名称
    private String to;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
