package com.suny.association.controller;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.InputStream;
import java.util.UUID;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/20 13:41
 */
public class MemberControllerTest extends TestCase {
    
    @Test
    public void test(){
        UUID randomUUID = UUID.randomUUID();
        String uuid = randomUUID.toString();
        System.out.println(uuid);
        
    }

    @Test
    public void getTemplateDir(){
        ClassLoader classLoader = MemberController.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("/");
    }














    
}