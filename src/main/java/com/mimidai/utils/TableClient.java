package com.mimidai.utils;

import com.alicloud.openservices.tablestore.ClientConfiguration;
import com.alicloud.openservices.tablestore.SyncClient;
import com.alicloud.openservices.tablestore.model.AlwaysRetryStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhangyu on 2017/9/6.
 */

@Configuration
//@PropertySource("classpath:application-develop.properties")
public class TableClient {

    private static Logger logger = LoggerFactory.getLogger("log.hbase.TableClientConfig");
    //  @Value("${TableClientConfig.endPoint}")
    //  private String endPoint;
    //  @Value("${TableClientConfig.accessId}")
    //  private String accessId;
    //  @Value("${TableClientConfig.accessKey}")
    //  private String accessKey;
    //  @Value("${TableClientConfig.instanceName}")
    //  private String instanceName;

    //生产配置  start
    // private String endPoint = "http://192.168.3.17:80/";
    // private String accessId = "LTAIpWvk9Q74F7lw";
    // private String accessKey = "n7KTus6rgJSxQga6MxWuKANKfrdGUx";
    // private String instanceName = "mimidai-archival";
    //生产配置  end

    //测试 环境 start
    // private String endPoint = "http://192.168.3.18:80/";
    // private static final String endPoint = "http://mimidai-test.cn-beijing.ots.aliyuncs.com";
    // private String accessId = "LTAIpWvk9Q74F7lw";
    // private String accessKey = "n7KTus6rgJSxQga6MxWuKANKfrdGUx";
    // private String instanceName = "mimidai-test";

    private static final String endPoint = "http://192.168.3.17:80/";
    private static final String accessId = "LTAIpWvk9Q74F7lw";
    private static final String accessKey = "n7KTus6rgJSxQga6MxWuKANKfrdGUx";
    private static final String instanceName = "mimidai-archival";

    //测试  换将 end
    @Bean
    public SyncClient createClient() {
        try {
            logger.info("开始调用createClient方法");
            // ClientConfiguration提供了很多配置项，以下只列举部分。
            ClientConfiguration clientConfiguration = new ClientConfiguration();
            // 设置建立连接的超时时间。
            clientConfiguration.setConnectionTimeoutInMillisecond(5000);
            // 设置socket超时时间。
            clientConfiguration.setSocketTimeoutInMillisecond(5000);
            // 设置重试策略，若不设置，采用默认的重试策略。
            clientConfiguration.setRetryStrategy(new AlwaysRetryStrategy());
            logger.info("返回创建表格存储cleint");
            return new SyncClient(endPoint, accessId, accessKey, instanceName, clientConfiguration);
        } catch (Exception e) {
            logger.warn("----------------------表格存储client初始化失败");
        }
        return null;

    }

}

