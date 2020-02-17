package com.mastercard.db.split.rule;

import com.mastercard.db.split.dto.Node;
import com.mastercard.db.split.utils.ConsistentHash;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Slf4j
public class ConsistentHashShardingAlgorithm implements ComplexKeysShardingAlgorithm {

    @Override
    public Collection<String> doSharding(Collection availableTargetNames, ComplexKeysShardingValue shardingValue) {
        List<Node> modes = new ArrayList<Node>();
        Map map = shardingValue.getColumnNameAndShardingValuesMap();
        String value = String.valueOf(map.get("user_id"));
        for (Object node:availableTargetNames
        ) {
            Node node1 = new Node();
            node1.setName(String.valueOf(node));
            modes.add(node1);
        }
        ConsistentHash.setNodes(modes);
        Node currentNode = ConsistentHash.get(value);
        ConsistentHash.remove(currentNode);
        Node nextNode = ConsistentHash.get(value);
        List<String> targets = new ArrayList<>();
        targets.add(currentNode.getName());
        targets.add(nextNode.getName());
        log.info("路由到的数据库节点为【{}】【{}】",currentNode.getName(),nextNode.getName());
        return targets;
    }
}
