package com.lorry.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private int user_id;
    private String user_name;
    private String user_pwd;
}
