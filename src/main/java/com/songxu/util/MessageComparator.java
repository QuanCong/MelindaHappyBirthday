package com.songxu.util;



import com.songxu.entity.Message;

import java.util.Comparator;


/**
 * Created by songxu on 2016/5/10.
 */
public class MessageComparator implements Comparator<Message> {

    public int compare(Message o1, Message o2) {
        return (o1.getDate().getTime() - o2.getDate().getTime())>0?-1:1;
    }
}
