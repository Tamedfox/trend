package com.cf.trend.config;

import com.cf.trend.job.IndexDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConofiguration {

    @Bean
    public JobDetail weatherDataSyncJobDetail(){
        return JobBuilder.newJob(IndexDataSyncJob.class)
                .withIdentity("indexDataSyncJob").storeDurably().build();
    }

    @Bean
    public Trigger weatherDataSyncTrigger(){
        SimpleScheduleBuilder schedule = SimpleScheduleBuilder.simpleSchedule().withIntervalInMinutes(1).repeatForever();

        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail())
                .withIdentity("indexDataSyncTrigger").withSchedule(schedule).build();
    }


}
