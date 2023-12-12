package org.chinacalcweb.webgui.config;

import org.chinacalcweb.webgui.service.util.MessagePublisher;
import org.chinacalcweb.webgui.service.util.Implementations.MessagePublisherImplementation;
import org.chinacalcweb.webgui.service.util.Implementations.MessageSubscriber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@Configuration
public class RedisConfig {

  @Bean
  JedisConnectionFactory jedisConnectionFactory() {

    return new JedisConnectionFactory();

  }

  @Bean
  public RedisTemplate<String, Object> redisTemplate() {

    final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();

    template.setConnectionFactory(jedisConnectionFactory());
    template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));

    return template;

  }

  @Bean
  MessagePublisher redisPublisher() {
    return new MessagePublisherImplementation(redisTemplate(), topic());
  }

  @Bean
  ChannelTopic topic() {

    return new ChannelTopic("pubsub:queue");

  }

  @Bean
  MessageListenerAdapter messageListener() {

    return new MessageListenerAdapter(new MessageSubscriber());

  }

}
