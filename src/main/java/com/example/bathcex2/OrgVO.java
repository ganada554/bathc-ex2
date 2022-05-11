package com.example.bathcex2;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class OrgVO {
    private String orgCode;
    private Integer orgId;

    public OrgVO(String orgCode, Integer orgId) {
        this.orgCode = orgCode;
        this.orgId = orgId;
    }
}
