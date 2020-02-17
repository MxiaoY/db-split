package com.mastercard.db.split.config;

import com.mastercard.db.split.plugin.PreShardingPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;


@Configuration
@MapperScan("com.mastercard.db.split.dao")
public class MapperConfig {

    @Bean
    public PreShardingPlugin preShardingPlugin(){
        return new PreShardingPlugin();
    }
}
