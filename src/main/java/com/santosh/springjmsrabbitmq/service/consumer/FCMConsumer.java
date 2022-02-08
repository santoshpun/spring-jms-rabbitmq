package com.santosh.springjmsrabbitmq.service.consumer;

import com.santosh.springjmsrabbitmq.dto.FCMMessageDTO;
import com.santosh.springjmsrabbitmq.helper.ThreadUtil;
import com.santosh.springjmsrabbitmq.helper.YamlPropertyLoaderFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@PropertySource(value = "classpath:rabbitmq.yml", factory = YamlPropertyLoaderFactory.class)
public class FCMConsumer {

    @RabbitListener(queues = "${rabbitmq.fcm-queue.queue}")
    public void receiveEmail(final FCMMessageDTO fcmMessageDTO) {
        log.info("===== Receiving FCM sending request ======");
        ThreadUtil.halt(5);
        log.info("FCM request : {}", fcmMessageDTO);
    }
}
