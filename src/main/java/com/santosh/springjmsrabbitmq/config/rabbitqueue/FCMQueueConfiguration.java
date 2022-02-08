package com.santosh.springjmsrabbitmq.config.rabbitqueue;

import com.santosh.springjmsrabbitmq.config.model.RabbitMQConfig;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class FCMQueueConfiguration {

    @Autowired
    private RabbitMQConfig rabbitMQConfig;

    @Bean(name = "fcmQueue")
    public Queue queue() {
        Map<String, Object> args = new HashMap<>();
        // TTL 40 seconds
        args.put("x-message-ttl", 40 * 1000);

        return new Queue(this.rabbitMQConfig.getFcmQueue().getQueue(), true, false, false, args);
    }

    @Bean(name = "fcmExchange")
    public DirectExchange exchange() {
        return new DirectExchange(this.rabbitMQConfig.getFcmQueue().getExchange());
    }

    @Bean(name = "fcmBinding")
    public Binding binding(final @Qualifier("fcmQueue") Queue queue,
                           final @Qualifier("fcmExchange") DirectExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(this.rabbitMQConfig.getFcmQueue().getRoutingKey());
    }

}
