package com.notfound.crm.sys.domain;

import lombok.*;

import static com.notfound.crm.sys.domain.Item.STATUS_SUCCESS;

@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Team {
    private Integer id;
    private String ite;
    private String name;
    private String phone;
    private String rankk;
}
