package com.cf.trend.job;

import cn.hutool.core.date.DateUtil;
import com.cf.pojo.Index;
import com.cf.trend.service.IndexDataService;
import com.cf.trend.service.IndexService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

public class IndexDataSyncJob extends QuartzJobBean {

    @Autowired
    private IndexService indexService;

    @Autowired
    private IndexDataService indexDataService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("定时器启动"+ DateUtil.now());
        List<Index> indexList = indexService.fresh();
        for (Index index : indexList) {
            indexDataService.fresh(index.getCode());
        }
        System.out.println("定时任务结束" + DateUtil.now());

    }
}
