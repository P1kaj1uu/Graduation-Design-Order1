package com.notfound.crm.sys.domain;

import lombok.*;

import static com.notfound.crm.sys.domain.Item.STATUS_SUCCESS;

@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Personal {
    private Integer id;
    private String ite;
    private String name;
    private String clas;
    private String major;
    private String phone;
   // private Integer rank;//1:一等奖2：二等奖3：三等奖
    private String rankk;
}
