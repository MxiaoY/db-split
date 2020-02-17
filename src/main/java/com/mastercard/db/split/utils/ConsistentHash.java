package com.mastercard.db.split.utils;

import com.mastercard.db.split.dto.Node;
import com.mastercard.db.split.service.HashService;
import com.mastercard.db.split.service.impl.HashServiceImpl;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class ConsistentHash {

    // Hash函数接口
    private static HashService hashService = new HashServiceImpl();

    // 每个机器节点关联的虚拟节点数量
    private static int numberOfReplicas = 500;
    // 环形虚拟节点
    private static final SortedMap<Long, Node> circle = new TreeMap<Long, Node>();

    public static void setNodes(Collection<Node> nodes){
        for (Node node : nodes) {
            add(node);
        }
    }

    /**
     * 增加真实机器节点
     *
     * @param node T
     */
    public static void add(Node node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            circle.put(hashService.hash(node.toString() + i), node);
        }
    }

    /**
     * 删除真实机器节点
     *
     * @param node T
     */
    public static void remove(Node node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            circle.remove(hashService.hash(node.toString() + i));
        }
    }

    public static Node get(String key) {
        if (circle.isEmpty()) return null;

        long hash = hashService.hash(key);

        // 沿环的顺时针找到一个虚拟节点
        if (!circle.containsKey(hash)) {
            SortedMap<Long, Node> tailMap = circle.tailMap(hash);
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hash);
    }

    public static void main(String[] args) {

        HashMap<Node, Integer> nodeCount = new HashMap<>();
        for (int i = 0;i < 10; i++){
            Node node = new Node();
            node.setName("ds"+i);
            ConsistentHash.add(node);
            nodeCount.put(node,0);
        }

        for (int i=0;i<500000;i++){
            String uuid = UUID.randomUUID().toString();
            Node node = ConsistentHash.get(uuid);
//            log.info("数据当前节点【{}】",node.getName());
//            ConsistentHash.remove(node);
//            Node node2 = ConsistentHash.get(uuid);
//            log.info("数据下游节点【{}】",node2.getName());
//            ConsistentHash.add(node);
            nodeCount.put(node,nodeCount.get(node)+1);
        }

        Set<Map.Entry<Node, Integer>> entries = nodeCount.entrySet();
        for (Map.Entry<Node, Integer> e:entries
             ) {
            log.info("节点名称为【{}】的数量为【{}】",e.getKey().getName(),e.getValue());
        }

    }

}
