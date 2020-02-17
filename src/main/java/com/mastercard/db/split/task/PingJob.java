package com.mastercard.db.split.task;

import com.mastercard.db.split.service.PingService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.apache.shardingsphere.shardingjdbc.jdbc.core.datasource.ShardingDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Component
@Slf4j
public class PingJob {

    @Autowired
    private PingService pingService;

//    @Scheduled(fixedRate = 2000)
    public void PingJobScheduled(){
//        log.info("database connect monitor start");
//        String ping = null;
//        try {
//            ping = pingService.ping();
//        }catch (Exception e){
//            log.info("database connect fail ");
//        }
//
//        if(ping == null){
//            log.info("database connect fail ");
//        }
    }
}
