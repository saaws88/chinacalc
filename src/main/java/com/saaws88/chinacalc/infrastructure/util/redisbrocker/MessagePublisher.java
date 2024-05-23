package com.saaws88.chinacalc.infrastructure.util.redisbrocker;

public interface MessagePublisher {

  void publish(final String message);
  
}
