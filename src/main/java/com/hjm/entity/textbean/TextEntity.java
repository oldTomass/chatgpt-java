package com.hjm.entity.textbean;


import com.hjm.entity.textbean.Choice;
import com.hjm.entity.textbean.Usage;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * 文本对象
 */

@Data
public class TextEntity {

    private String id;
    private String object;
    private long created;
    private String model;
    private List<Choice> choices;
    private Usage usage;

}
