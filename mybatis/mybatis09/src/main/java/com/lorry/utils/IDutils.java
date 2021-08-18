package com.lorry.utils;


import org.junit.jupiter.api.Test;

import java.util.UUID;

public class IDutils {
    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    @Test
    public void Test(){
        System.out.println(IDutils.getId());
    }
}
