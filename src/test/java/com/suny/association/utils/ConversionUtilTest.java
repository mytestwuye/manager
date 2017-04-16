package com.suny.association.utils;

import com.suny.association.controller.AccountController;
import junit.framework.TestCase;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/04/16 8:33
 */
public class ConversionUtilTest extends TestCase {
    public void testDynamicCriteriaMap() throws Exception {
       ConversionUtil.dynamicCriteriaMap(AccountController.class);
    }

}