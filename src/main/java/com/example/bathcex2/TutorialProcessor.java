package com.example.bathcex2;

import oracle.jdbc.OracleConnectionBuilder;

import java.util.HashMap;

public class TutorialProcessor implements org.springframework.batch.item.ItemProcessor<OrgVO, OrgVO> {

    @Override
    public OrgVO process(OrgVO orgVO) throws Exception {
        System.out.println("process");
        return orgVO;
    }



    /*@Override
    public String process(String data) throws Exception {
        System.out.println("TutoralProcessor : Processing data : "+data);
        return data;
    }*/
}
