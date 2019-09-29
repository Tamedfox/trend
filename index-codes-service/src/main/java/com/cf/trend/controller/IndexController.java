package com.cf.trend.controller;

import com.cf.pojo.Index;
import com.cf.trend.config.IpConfiguration;
import com.cf.trend.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexController {

    @Autowired
    private IndexService indexService;

    @Autowired
    private IpConfiguration ipConfiguration;

    @CrossOrigin
    @RequestMapping(value = "/codes",method = RequestMethod.GET)
    public List<Index> codes(){
        System.out.println("current instance's port is:" + ipConfiguration.getPort());
        return indexService.get();
    }

}
