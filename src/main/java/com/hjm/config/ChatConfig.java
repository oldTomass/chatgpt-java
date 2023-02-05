package com.hjm.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "chatconf")
public class ChatConfig {
    // openAI：api-key
    private String APIKEY;
}
