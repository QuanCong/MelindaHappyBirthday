package com.songxu.service.impl;

import com.songxu.entity.Message;
import com.songxu.service.MessageService;
import com.songxu.util.MessageComparator;
import com.songxu.util.SendMail;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by songxu on 2016/5/9.
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {

    private static ExecutorService executorService = Executors.newFixedThreadPool(4);

    private String filePath;
    private String emailSendName;
    private String emailSendPassWord;
    private String emailTo;
    private String emailHost;
    private final static String EOL = System.getProperty("line.separator");

    public List<Message> getMgs() {
        List<Message> messages = new ArrayList<Message>();
        messages=getMessages();
        Collections.sort(messages,new MessageComparator());
        return messages;
    }

    public Message saveMsg(Message message) {
        if (saveMsg(message.toLogString())) {
            sendEmail(message.getName());
            return message;
        } else {
            return null;
        }
    }

    private List<Message> getMessages() {
        List<Message> lists = new ArrayList<Message>();
        try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw

            /* 读入TXT文件 */
            File filename = new File(filePath); // 要读取以上路径的input。txt文件
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(filename),"UTF-8"); // 建立一个输入流对象reader
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line = "";
            line = br.readLine();
            while (line != null) {
                Message message=Message.fromString(line);
                if (message != null) {
                    lists.add(message);
                }
                line = br.readLine(); // 一次读入一行数据
            }
            br.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return  lists;
    }

    private boolean saveMsg(String msg) {
        try {
             /* 写入Txt文件 */
            File writename = new File(filePath); // 相对路径，如果没有则要建立一个新的output。txt文件
            Writer out = new OutputStreamWriter(new FileOutputStream(writename,true), "UTF-8");
            //out.newLine();
            out.write(msg+ EOL); // 即为换行
            out.flush(); // 把缓存区内容压入文件
            out.close(); // 最后记得关闭文件
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 发送邮件通知
     *
     * @param name
     */
    private void sendEmail(String name) {
        executorService.submit(new SendMail(this.emailHost,this.emailSendName,this.emailSendPassWord,this.getEmailTo(),name));
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getEmailSendName() {
        return emailSendName;
    }

    public void setEmailSendName(String emailSendName) {
        this.emailSendName = emailSendName;
    }

    public String getEmailSendPassWord() {
        return emailSendPassWord;
    }

    public void setEmailSendPassWord(String emailSendPassWord) {
        this.emailSendPassWord = emailSendPassWord;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }
    public String getEmailHost() {
        return emailHost;
    }

    public void setEmailHost(String emailHost) {
        this.emailHost = emailHost;
    }


}
