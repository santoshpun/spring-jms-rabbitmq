package com.santosh.springjmsrabbitmq.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class EmailDTO {
    private String recipient;
    private List<String> recipients;
    private String subject;
    private String content;
}
