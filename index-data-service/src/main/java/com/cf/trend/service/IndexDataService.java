package com.cf.trend.service;

import java.util.List;

import com.cf.trend.pojo.IndexData;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cn.hutool.core.collection.CollUtil;

@Service
@CacheConfig(cacheNames="indexes-data")
public class IndexDataService {

    @Cacheable(key="'indexData-code-'+ #p0")
    public List<IndexData> get(String code){
        return CollUtil.toList();
    }
}