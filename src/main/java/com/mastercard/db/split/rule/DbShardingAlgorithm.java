package com.mastercard.db.split.rule;

import com.mastercard.db.split.dto.Node;
import com.mastercard.db.split.service.impl.HashServiceImpl;
import com.mastercard.db.split.utils.ConsistentHash;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.ShardingValue;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Slf4j
public class DbShardingAlgorithm implements PreciseShardingAlgorithm {


    @Override
    public String doSharding(Collection collection, PreciseShardingValue preciseShardingValue) {
        int i = Math.abs(preciseShardingValue.getValue().hashCode() %1331% collection.size());
        log.info("==============【{}】=================",collection.size());
        String s = String.valueOf(collection.toArray()[i]);
        log.info("值为【{}】路由到的库为【{}】",preciseShardingValue.getValue(),s);
        return s;
    }


}
