package com.card.Dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter

@ConfigurationProperties(prefix = "cards")
public class CardsContactInfoDto
{
    private String message;
    private  Map<String,String>contactDetails;
    private  List<String> onContactSupport;

}
