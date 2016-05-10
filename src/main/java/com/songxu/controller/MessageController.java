package com.songxu.controller;

import com.alibaba.fastjson.JSON;
import com.songxu.entity.Message;
import com.songxu.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by songxu on 2016/5/9.
 */

@Controller
@RequestMapping("/msg")
public class MessageController {

    @Resource
    private MessageService messageService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public String getMsgs() {
        List<Message> messages=messageService.getMgs();
        if (messages != null && messages.size() > 0) {
            return JSON.toJSONString(messages);
        } else {
            return JSON.toJSONString("null");
        }

    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public String addMsgs(@RequestBody Message message) {

        message.setDate(new Date());
        Message messageNew=messageService.saveMsg(message);
        return JSON.toJSONString(messageNew);

    }





}
