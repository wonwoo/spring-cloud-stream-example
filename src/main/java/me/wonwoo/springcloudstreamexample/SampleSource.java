package me.wonwoo.springcloudstreamexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageHeaders;

@EnableBinding(Source.class)
public class SampleSource {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Bean
  @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "1000", maxMessagesPerPoll = "1"))
  public MessageSource<String> timerMessageSource() {
    return () -> {
      String value = "{\"value\":\"hi\"}";
      logger.info("********************");
      logger.info("sending value {} ", value);
      logger.info("********************");
      return MessageBuilder.withPayload(value).setHeader(MessageHeaders.CONTENT_TYPE, "application/json").build();
    };
  }

}