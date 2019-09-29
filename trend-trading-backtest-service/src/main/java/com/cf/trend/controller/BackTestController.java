package com.cf.trend.controller;

import com.cf.trend.pojo.IndexData;
import com.cf.trend.service.BackTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BackTestController {

    @Autowired
    private BackTestService backTestService;

    @RequestMapping("/simulate/{code}")
    public Map<String ,Object> backTest(@PathVariable("code") String code){
        List<IndexData> indexDatas = backTestService.listIndexData(code);
        Map<String,Object> map = new HashMap<>();
        map.put("indexDatas",indexDatas);
        return map;
    }


}
