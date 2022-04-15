package com.gs.console.service;

import com.gs.dao.test.TestDAO;
import com.gs.dao.test.TestDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

/**
 * @User远
 * @Date2022/4/13
 */
@Service
public class TestService {

    @Autowired
    private TestDAO testDAO;

    @PostConstruct
    public void init(){
        List<TestDO> select = testDAO.select(new HashMap<>());
        System.out.println(select.toString());
    }
}
