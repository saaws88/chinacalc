package com.saaws88.chinacalc.infrastructure.util.redisbrocker.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class MessageSubscriber implements MessageListener {

  public final static List<String> messageList = new ArrayList<String>();

  public void onMessage(final Message message, final byte[] pattern) {

    messageList.add(message.toString());
    
    System.out.println("Message received: " + new String(message.getBody()));
  
  }
  
}
