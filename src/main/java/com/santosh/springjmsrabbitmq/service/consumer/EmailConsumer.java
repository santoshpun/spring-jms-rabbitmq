package com.santosh.springjmsrabbitmq.service.consumer;

import com.santosh.springjmsrabbitmq.dto.EmailDTO;
import com.santosh.springjmsrabbitmq.helper.YamlPropertyLoaderFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@PropertySource(value = "classpath:rabbitmq.yml", factory = YamlPropertyLoaderFactory.class)
public class EmailConsumer {

    @RabbitListener(queues = "${rabbitmq.email-queue.queue}")
    public void receiveEmail(final EmailDTO emailDTO) {
        log.info("===== Receiving email sending request ======");
        log.info("Email request : {}", emailDTO);
    }
}
