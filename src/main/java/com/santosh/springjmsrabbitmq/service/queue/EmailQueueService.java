package com.santosh.springjmsrabbitmq.service.queue;

import com.santosh.springjmsrabbitmq.config.model.RabbitMQConfig;
import com.santosh.springjmsrabbitmq.dto.EmailDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailQueueService {

    @Autowired
    private RabbitMQConfig rabbitMQConfig;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMail(EmailDTO emailDTO) {

        rabbitTemplate.convertAndSend(this.rabbitMQConfig.getEmailQueue().getExchange(),
                this.rabbitMQConfig.getEmailQueue().getRoutingKey(), emailDTO);
    }
}
