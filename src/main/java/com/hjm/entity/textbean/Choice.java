package com.hjm.entity.textbean;


import lombok.Data;

/**
 * 文本对象中的数据对象
 */

@Data
public class Choice {
    private String text;
    private int index;
    private String logprobs;
    private String finish_reason;

}
