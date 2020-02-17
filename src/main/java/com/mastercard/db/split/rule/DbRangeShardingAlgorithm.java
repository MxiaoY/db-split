package com.mastercard.db.split.rule;

import com.mastercard.db.split.config.MapperConfig;
import com.mastercard.db.split.config.data.GroupDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.util.Collection;
import java.util.Map;

@Slf4j
public class DbRangeShardingAlgorithm implements ComplexKeysShardingAlgorithm {


    @Override
    public Collection<String> doSharding(Collection collection, ComplexKeysShardingValue complexKeysShardingValue) {
        Map map = complexKeysShardingValue.getColumnNameAndShardingValuesMap();
        return null;
    }
}
