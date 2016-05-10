package com.songxu.test;


import sun.plugin2.message.transport.Transport;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by songxu on 2016/5/10.
 */
public class Sava {
    public static void main(String[] args) {

        String name="";
        try{
            Properties props=new Properties();
            props.put("mail.smtp.host", "smtp.163.com");
            props.put("mail.smtp.auth", true);
            Session mailConnection=Session.getInstance(props,null);
            Message msg=new MimeMessage(mailConnection);
            //设置发送人和接受人
            Address sender=new InternetAddress("songxu9185@163.com");
            Address receiver=new InternetAddress("408119545@qq.com");
            msg.setFrom(sender);
            msg.setRecipient(Message.RecipientType.TO, receiver);
            msg.setSubject("你有新的留言啦！");
            Multipart mtp=new MimeMultipart();

            BodyPart mdp=new MimeBodyPart();
            //给BodyPart对象设置内容和格式/编码方式
            mdp.setContent("嗨 亲爱的李欢！<br> "+name+"给你留言啦！" +
                    "<a href='www.melinda0722.com/#/saysomething'>" +
                    "点击这里去看看</a>或打开下面网址：<br>" +
                    "www.melinda0722.com/#/saysomething"
                    ,"text/html;charset=gb2312");
            //将含有信件内容的BodyPart加入到MimeMultipart对象中
            mtp.addBodyPart(mdp);
            //把mtp作为消息对象的内容
            msg.setContent(mtp);
            msg.saveChanges();
            javax.mail.Transport trans=mailConnection.getTransport("smtp");
            String username="songxu9185@163.com";
            String pw="sx910805";
            //邮件服务器名,用户名，密码
            trans.connect("smtp.163.com", username,  pw);
            trans.sendMessage(msg, msg.getAllRecipients());
            trans.close();
        }catch(Exception e)
        {
            System.err.println(e);
        }

    }
}
