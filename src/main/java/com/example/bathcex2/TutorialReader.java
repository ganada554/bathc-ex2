package com.example.bathcex2;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class TutorialReader implements ItemReader<OrgVO> {

    OrgVO org1 = new OrgVO("Incheon",1);


    @Override
    public OrgVO read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        System.out.println("TutoralReader : Reading Ddata : "+ org1.getOrgCode()+org1.getOrgId());
        return org1;
    }
}
