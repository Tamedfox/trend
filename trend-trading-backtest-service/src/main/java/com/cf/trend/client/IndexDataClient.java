package com.cf.trend.client;

import com.cf.trend.pojo.IndexData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "INDEX-DATA-SERVICE",fallback = IndexDataClientFeignHystrix.class)
public interface IndexDataClient {

    @RequestMapping("/data/{code}")
    public List<IndexData> getIndexData(@PathVariable("code") String code);

}
