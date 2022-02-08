package com.santosh.springjmsrabbitmq.controller;

import com.santosh.springjmsrabbitmq.dto.FCMMessageDTO;
import com.santosh.springjmsrabbitmq.service.queue.FCMQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FcmController {

    @Autowired
    private FCMQueueService fcmQueueService;

    @PostMapping(value = "send/fcm")
    public ResponseEntity<String> sendFCM(@RequestBody FCMMessageDTO fcmMessageDTO) {

        fcmQueueService.send(fcmMessageDTO);

        return ResponseEntity.ok("FCM sent successfully !");
    }

}
