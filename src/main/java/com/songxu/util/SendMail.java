package com.songxu.util;


import org.codemonkey.simplejavamail.Mailer;
import org.codemonkey.simplejavamail.TransportStrategy;
import org.codemonkey.simplejavamail.email.Email;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.util.Properties;

/**
 * 发邮件工具类
 * Created by songxu on 2016/5/10.
 */
public class SendMail implements Runnable {
    private final String host;
    private final String userName;
    private final String password;
    private final String mailTo;
    private final String person;
    public  SendMail(String host,String userName,String password,String mailTo,String person){
        this.host=host;
        this.userName=userName;
        this.password=password;
        this.mailTo=mailTo;
        this.person=person;
    }

    public void run() {
        try{
            Properties props=new Properties();
            props.put("mail.smtp.host", this.host);
            props.put("mail.smtp.auth", true);
            Session mailConnection=Session.getInstance(props,null);
            Message msg=new MimeMessage(mailConnection);
            //设置发送人和接受人
            Address sender=new InternetAddress(this.userName);
            Address receiver=new InternetAddress(this.mailTo);
            msg.setFrom(sender);
            msg.setRecipient(Message.RecipientType.TO, receiver);
            msg.setSubject("你有新的留言啦！");
            Multipart mtp=new MimeMultipart();

            BodyPart mdp=new MimeBodyPart();
            //给BodyPart对象设置内容和格式/编码方式
            mdp.setContent("嗨 亲爱的李欢！<br> "+this.person+"给你留言啦！" +
                            "<a href='http://www.melinda0722.com/#/saysomething'>" +
                            "点击这里去看看</a>或打开下面网址：<br>" +
                            "http://www.melinda0722.com/#/saysomething"
                    ,"text/html;charset=gb2312");
            //将含有信件内容的BodyPart加入到MimeMultipart对象中
            mtp.addBodyPart(mdp);
            //把mtp作为消息对象的内容
            msg.setContent(mtp);
            msg.saveChanges();
            javax.mail.Transport trans=mailConnection.getTransport("smtp");
            //邮件服务器名,用户名，密码
            trans.connect(this.host, this.userName, this.password);
            trans.sendMessage(msg, msg.getAllRecipients());
            trans.close();
        }catch(Exception e)
        {
            System.err.println(e);
        }


    }
}
