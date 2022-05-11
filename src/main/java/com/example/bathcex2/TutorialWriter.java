package com.example.bathcex2;

import org.springframework.batch.item.ItemWriter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class TutorialWriter implements ItemWriter<OrgVO> {
    @Override
    public void write(List<? extends OrgVO> list) throws Exception {
        System.out.println("write");
    }




    /* @Override
    public void write(List<? extends String> list) throws Exception {
        for (String data: list) {
            System.out.println("TutoralWriter : Writing data : "+data);
        }
        System.out.println("TutorialWriter : Writing data : completed");
    }*/
}
