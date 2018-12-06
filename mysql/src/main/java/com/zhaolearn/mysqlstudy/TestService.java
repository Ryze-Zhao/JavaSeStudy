package com.zhaolearn.mysqlstudy;

import com.zhaolearn.mysqlstudy.entity.Human;
import com.zhaolearn.mysqlstudy.service.HumanService;


/**
 * Hello world!
 */
public class TestService {

    public static void main(String[] args) throws Exception {
        HumanService humanService = new HumanService();
        for (int i = 0; i < 100; i++) {
            Human hehe = new Human("human" + i, i);
            humanService.addHuman(hehe);
        }

    }
}
