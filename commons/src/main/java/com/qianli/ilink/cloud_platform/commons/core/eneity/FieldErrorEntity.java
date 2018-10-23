package com.qianli.ilink.cloud_platform.commons.core.eneity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FieldErrorEntity implements BaseEntity {

    private String defaultMessage;
    private String field;
    private Object rejectedValue;


}
