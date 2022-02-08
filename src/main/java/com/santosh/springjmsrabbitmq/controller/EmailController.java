package com.santosh.springjmsrabbitmq.controller;

import com.santosh.springjmsrabbitmq.dto.EmailDTO;
import com.santosh.springjmsrabbitmq.service.queue.EmailQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailQueueService emailQueueService;

    @PostMapping(value = "send/mail")
    public ResponseEntity<String> sendEmail(@RequestBody EmailDTO emailDTO) {

        emailQueueService.sendMail(emailDTO);

        return ResponseEntity.ok("Mail sent successfully !");
    }

}
