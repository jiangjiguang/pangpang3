package com.pangpang3.utils;

/**
 * Created by root on 17-3-2.
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(HelloWorld.class);
        logger.error("Hello World", new Exception("111"));
    }
}