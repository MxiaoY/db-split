package com.mastercard.db.split.dto;

import lombok.Data;

@Data
public class Node {

    private String ip;
    private String name;
    private Integer port;
    private String next;

}
