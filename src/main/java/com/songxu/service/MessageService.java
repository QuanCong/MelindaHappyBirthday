package com.songxu.service;

import com.songxu.entity.Message;

import java.util.List;

/**
 * Created by songxu on 2016/5/9.
 */

public interface MessageService {

    public List<Message> getMgs();

    public Message saveMsg(Message message);

}
