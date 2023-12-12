package org.chinacalcweb.webgui.service.util.Implementations;

import org.chinacalcweb.webgui.service.util.MessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class MessagePublisherImplementation implements MessagePublisher {
  
  @Autowired
  private RedisTemplate<String, Object> redisTemplate;
  @Autowired
  private ChannelTopic topic;
  
  public MessagePublisherImplementation(final RedisTemplate<String, Object> redisTemplate, final ChannelTopic topic) {
    this.redisTemplate = redisTemplate;
    this.topic = topic;

  }
  public void publish(final String message) {
    
    redisTemplate.convertAndSend(topic.getTopic(), message);

  }
}
