package com.mastercard.db.split.config.data;

import lombok.Data;

import java.util.List;

@Data
public class GroupDto {

    private long start;
    private long end;
    private List<String> ds;
}
