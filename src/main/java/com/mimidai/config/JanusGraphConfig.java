package com.mimidai.config;

import org.apache.commons.configuration.BaseConfiguration;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.janusgraph.core.JanusGraph;
import org.janusgraph.core.JanusGraphFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class JanusGraphConfig {
//
//    @Bean
//    public GraphTraversalSource janusGraph(){
//        BaseConfiguration baseConfiguration = new BaseConfiguration();
//        baseConfiguration.setProperty("storage.backend","hbase");
//        baseConfiguration.setProperty("storage.hbase.table","janusgraph");
//        baseConfiguration.setProperty("storage.hostname","192.168.3.20:2181");
//        baseConfiguration.setProperty("gremlin.graph", "org.janusgraph.core.JanusGraphFactory");
//        JanusGraph janusGraph = JanusGraphFactory.open(baseConfiguration);
//        GraphTraversalSource graphTraversalSource = janusGraph.traversal();
//        return graphTraversalSource;
//    }
//
//
//}