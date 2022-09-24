package com.notfound.crm.sys.domain;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Fees {
    private Integer id;
    private String ite;
    private BigDecimal enroll;//注册费
    private BigDecimal guide;//指导费
    private BigDecimal other;//其他
    private BigDecimal heji;
}
