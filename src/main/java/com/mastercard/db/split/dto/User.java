package com.mastercard.db.split.dto;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

@Data
public class User implements Serializable {

    @Id
    private String userId;

    private String username;

}
