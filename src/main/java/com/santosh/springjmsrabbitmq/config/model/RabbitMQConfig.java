package com.santosh.springjmsrabbitmq.config.model;

import com.santosh.springjmsrabbitmq.helper.YamlPropertyLoaderFactory;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Setter
@ToString
@Configuration
@PropertySource(value = "classpath:rabbitmq.yml", factory = YamlPropertyLoaderFactory.class)
@ConfigurationProperties(prefix = "rabbitmq")
public class RabbitMQConfig {
    private String host;
    private int port;
    private String username;
    private String password;
    private QueueConfig emailQueue;
    private QueueConfig fcmQueue;

    @Getter
    @Setter
    @ToString
    public static class QueueConfig {
        private String exchange;
        private String queue;
        private String routingKey;
    }
}
