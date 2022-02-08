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

@Configuration
public class EmailQueueConfiguration {

    @Autowired
    private RabbitMQConfig rabbitMQConfig;

    @Bean(name = "emailQueue")
    public Queue queue() {
        return new Queue(this.rabbitMQConfig.getEmailQueue().getQueue(), true);
    }

    @Bean(name = "emailExchange")
    public DirectExchange exchange() {
        return new DirectExchange(this.rabbitMQConfig.getEmailQueue().getExchange());
    }

    @Bean(name = "emailBinding")
    public Binding binding(final @Qualifier("emailQueue") Queue queue,
                           final @Qualifier("emailExchange") DirectExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(this.rabbitMQConfig.getEmailQueue().getRoutingKey());
    }

}
