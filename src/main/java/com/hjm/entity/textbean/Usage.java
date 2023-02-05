package com.hjm.entity.textbean;

import lombok.Data;

/**
 * 文本对象中的Usage
 */
@Data
public class Usage {
    private int prompt_tokens;
    private int completion_tokens;
    private int total_tokens;
}
