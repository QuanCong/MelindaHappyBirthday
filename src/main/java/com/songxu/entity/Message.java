package com.songxu.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Exchanger;

/**
 * Created by songxu on 2016/5/9.
 */
public class Message implements  Comparable<Message> {

    private String timeString;
    private String name;
    private String msg;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Date date;


    public String getTimeString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  simpleDateFormat.format(this.date);
    }

    public void setTimeString(String timeString) {
        this.timeString = timeString;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 保存至文件
     * @return
     */
    public String toLogString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()+"&");
        sb.append(this.getMsg()+"&");
        sb.append(this.getDate().getTime());
        return  sb.toString();
    }

    public static Message fromString(String timeString) {
        try {
            String[] strs = timeString.split("&");
            Message message = new Message();
            message.setName(strs[0]);
            message.setMsg(strs[1]);
            message.setDate(new Date(Long.parseLong(strs[2])));
            return message;

        } catch (Exception e) {
            return  null;
        }

    }

    public int compareTo(Message o) {
        return 0;
    }
}
