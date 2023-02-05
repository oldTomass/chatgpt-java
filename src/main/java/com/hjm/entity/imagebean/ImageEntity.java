package com.hjm.entity.imagebean;

import lombok.Data;
import java.util.List;

@Data
public class ImageEntity {
    private long created;
    private List<ImgUrl> data;

}
