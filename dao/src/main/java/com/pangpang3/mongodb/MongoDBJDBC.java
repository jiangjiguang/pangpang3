package com.pangpang3.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * Created by jiangjg on 2017/2/15.
 */
public class MongoDBJDBC {
    public static void main( String args[] ){
        try{
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient( "10.32.11.11" , 27017 );
            for(String name : mongoClient.listDatabaseNames()){
                System.out.println(name);
            }

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");
            mongoDatabase.createCollection("test");
            String dbname = mongoDatabase.getName();
            System.out.println(dbname);
            System.out.println("Connect to database successfully");

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
}
