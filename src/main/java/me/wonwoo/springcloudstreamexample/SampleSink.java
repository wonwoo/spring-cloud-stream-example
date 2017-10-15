package me.wonwoo.springcloudstreamexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class SampleSink {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @StreamListener(Sink.INPUT)
  public void receive(Foo foo) {
    logger.info("********************");
    logger.info("Received message {}", foo.getValue());
    logger.info("********************");
  }
}