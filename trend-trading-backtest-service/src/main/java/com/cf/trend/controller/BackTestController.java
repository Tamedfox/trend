package com.cf.trend.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.cf.trend.pojo.IndexData;
import com.cf.trend.service.BackTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class BackTestController {

    @Autowired
    private BackTestService backTestService;

    @RequestMapping("/simulate/{code}/{startDate}/{endDate}")
    public Map<String, Object> backTest(@PathVariable("code") String code
            , @PathVariable("startDate") String strStartDate
            , @PathVariable("endDate") String strEndDate) {
        List<IndexData> allIndexDatas = backTestService.listIndexData(code);

        String indexStartDate = allIndexDatas.get(0).getDate();
        String indexEndDate = allIndexDatas.get(allIndexDatas.size()).getDate();

        allIndexDatas = filterByDateRange(allIndexDatas, strStartDate, strEndDate);

        Map<String, Object> map = new HashMap<>();
        map.put("indexStartDate", indexStartDate);
        map.put("indexEndDate", indexEndDate);
        map.put("indexDatas", allIndexDatas);
        return map;
    }

    private List<IndexData> filterByDateRange(List<IndexData> allIndexDatas, String strStartDate, String strEndDate) {

        if (StrUtil.isBlankOrUndefined(strStartDate) || StrUtil.isBlankOrUndefined(strEndDate)) {
            return allIndexDatas;
        }

        List<IndexData> result = new ArrayList<>();
        Date startDate = DateUtil.parse(strStartDate);
        Date endDate = DateUtil.parse(strEndDate);

        for (IndexData indexData : allIndexDatas) {
            Date date = DateUtil.parse(indexData.getDate());
            if (date.getTime() >= startDate.getTime() && date.getTime() <= endDate.getTime()) {
                result.add(indexData);
            }
        }
        return result;
    }


}
