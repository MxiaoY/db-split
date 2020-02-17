package com.mastercard.db.split.rule;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;
@Slf4j
public class TableShardingAlgorithm implements PreciseShardingAlgorithm {

    @Override
    public String doSharding(Collection collection, PreciseShardingValue preciseShardingValue) {
        int i = Math.abs(preciseShardingValue.getValue().hashCode() % collection.size());
        log.info("==============【{}】=================",collection.size());
        String s = String.valueOf(collection.toArray()[i]);
        log.info("值为【{}】路由到的表为【{}】",preciseShardingValue.getValue(),s);
        return s;
    }
}
