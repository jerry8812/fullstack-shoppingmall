package dev.jerry.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Images {

    private String imageId;
    private String imgType;
    private String imgName;
    private Integer imgWidth;
    private Integer imgHeight;
    private Date dateOfUpload;
    private Integer isDelete;
    private String tag;
}
