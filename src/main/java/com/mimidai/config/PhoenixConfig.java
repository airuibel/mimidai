package com.mimidai.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by 苦苦奋斗的渣渣 on 2017/5/25.
 */
@Configuration
public class PhoenixConfig {


    public BasicDataSource phoenixDataSourceForquery() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.apache.phoenix.jdbc.PhoenixDriver");
        dataSource.setUrl("jdbc:phoenix:hb-2zet660v1d26yk9b6-001.hbase.rds.aliyuncs.com,hb-2zet660v1d26yk9b6-002.hbase.rds.aliyuncs.com,hb-2zet660v1d26yk9b6-004.hbase.rds.aliyuncs.com");
//        dataSource.setUrl("jdbc:phoenix:hb-proxy-pub-2zet660v1d26yk9b6-001.hbase.rds.aliyuncs.com:2181 \n" +
//                "\n" +
//                ",hb-proxy-pub-2zet660v1d26yk9b6-002.hbase.rds.aliyuncs.com:2181 \n" +
//                "\n" +
//                ",hb-proxy-pub-2zet660v1d26yk9b6-004.hbase.rds.aliyuncs.com:2181");
        return dataSource;
    }
//
//    public BasicDataSource phoenixDataSourceForUpdate() {
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName("org.apache.phoenix.jdbc.PhoenixDriver");
//        dataSource.setUrl("jdbc:phoenix:192.168.1.63");
//        return dataSource;
//    }

    @Bean
    public JdbcTemplate phoenixJdbcTemplateForQuery() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(phoenixDataSourceForquery());
        return jdbcTemplate;
    }

//    @Bean
//    public JdbcTemplate phoenixJdbcTemplateForUpdate() {
//        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//        jdbcTemplate.setDataSource(phoenixDataSourceForUpdate());
//        return jdbcTemplate;
//    }
    //jdbc:phoenix:hb-2ze8gec60j46x5toa-001.hbase.rds.aliyuncs.com,hb-2ze8gec60j46x5toa-002.hbase.rds.aliyuncs.com,hb-2ze8gec60j46x5toa-004.hbase.rds.aliyuncs.com

}
