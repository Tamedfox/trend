package com.cf.trend.controller;

import com.cf.pojo.Index;
import com.cf.trend.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexController {

    @Autowired
    private IndexService indexService;

    //  http://127.0.0.1:8001/freshCodes
//  http://127.0.0.1:8001/getCodes
//  http://127.0.0.1:8001/removeCodes

    @GetMapping("/freshCodes")
    public List<Index> fresh() throws Exception {
        return indexService.fresh();
    }
    @GetMapping("/getCodes")
    public List<Index> get() throws Exception {
        return indexService.get();
    }
    @GetMapping("/removeCodes")
    public String remove() throws Exception {
        indexService.remove();
        return "remove codes successfully";
    }


}
