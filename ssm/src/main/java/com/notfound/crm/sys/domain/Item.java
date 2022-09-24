package com.notfound.crm.sys.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Item {
    private Integer id;
    private String name;
    private Integer type;//类型 1：个人赛，2：团体赛
    private String company;//负责单位
    private String person;//负责人
    private String phone;
    @DateTimeFormat(pattern="yyyy-MM-dd")
//    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private String start;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private String end;

//    private Integer status;//0：未审核，1：同意，2：拒绝
    private int status=STATUS_SUCCESS;
    public static final int STATUS_SUCCESS=1;
    public static final int STATUS_FALI=2;
    public static final int STATUS_wei=0;

}
