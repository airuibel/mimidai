/*
package com.mimidai.config;

import com.mimidai.utils.Constants;
import com.mimidai.utils.PropertiesLoader;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.embedded.EmbeddedSolrServer;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.core.CoreContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

*/
/**
 * SolrServer工厂类
 *
 * @author Boya
 *//*

public class SolrServerFactory {

	private static Logger logger = LoggerFactory.getLogger(SolrServerFactory.class);

	private static final String defaultSolrName = "mimidai";
	private static final String defaultSolrCore = "core0";
	private static String zkHost = null;
	private static Map<String, SolrServer> solrServerMap = Collections.synchronizedMap(new HashMap<String, SolrServer>());

	private static CoreContainer container;

	public static SolrServer getCloudSolrServer(String coreName){
		if (!solrServerMap.containsKey(coreName)) {
			try {
				if (zkHost == null) {
					PropertiesLoader p = new PropertiesLoader("classpath:/application-" + Constants.PROJECT_NAME + ".properties");
					zkHost =  p.getProperty("solr.zkHost");
				}
                CloudSolrServer solrServer = new CloudSolrServer(zkHost);
				solrServer.setDefaultCollection(coreName);
				solrServer.connect();
				solrServerMap.put(coreName, solrServer);
			} catch (Exception e) {
				logger.error("创建CloudSolrServer失败！coreName:"+coreName, e);
			}
		}
		return solrServerMap.get(coreName);
//		return getCommonsHttpSolrServer(coreName);
	}

	public static List<SolrServer> getAllCloudSolrServers(){
		List<SolrServer> solrServerList = null;
		if (solrServerMap != null && solrServerMap.size() > 0) {
			solrServerList = (List<SolrServer>) solrServerMap.values();
		}
		return solrServerList;
	}

	public synchronized static SolrServer getEmbeddedSolrServer() {
		return getEmbeddedSolrServer(defaultSolrName);
	}

	public synchronized static SolrServer getEmbeddedSolrServer(String solrName) {
		if (!solrServerMap.containsKey(solrName)) {
			try {
				if (container == null) {
					PropertiesLoader p = new PropertiesLoader("classpath:/application-" + Constants.PROJECT_NAME + ".properties");
					String solrServerHome = p.getProperty("solr.solr.home");

					File configFile = new File(solrServerHome + "solr.xml");
					container = CoreContainer.createAndLoad(solrServerHome, configFile);
				}
				SolrServer solrServer = new EmbeddedSolrServer(container, solrName);
				if (solrServer != null)
					solrServerMap.put(solrName, solrServer);
			} catch (Exception e) {
				logger.error("创建EmbeddedSolrServer失败！name:"+solrName, e);
			}
		}
		return solrServerMap.get(solrName);
	}

	public static SolrServer getCommonsHttpSolrServer() {
		return getCommonsHttpSolrServer(defaultSolrCore);
	}

	public static SolrServer getCommonsHttpSolrServer(String coreName) {
		if (!solrServerMap.containsKey(coreName)) {
			PropertiesLoader p = new PropertiesLoader("classpath:/application-" + Constants.PROJECT_NAME + ".properties");
			String urlPrifix = p.getProperty("solr.url.prefix");
			String solrUrl = urlPrifix + coreName;
			SolrServer solrServer = new HttpSolrServer(solrUrl);
			if (solrServer != null) {
				solrServerMap.put(coreName, solrServer);
				logger.info("服务 " + solrUrl + " 加载完毕");
			}
		}
		return solrServerMap.get(coreName);
	}

	public static SolrServer getCommonsHttpSolrServer(String coreName, String urlPrifix) {
		String wCoreName = "w" + coreName;
		if (!solrServerMap.containsKey(wCoreName)) {
			PropertiesLoader p = new PropertiesLoader("classpath:/application-" + Constants.PROJECT_NAME + ".properties");
			String solrUrl = urlPrifix + coreName;
			SolrServer solrServer = new HttpSolrServer(solrUrl);
			if (solrServer != null) {
				solrServerMap.put(wCoreName, solrServer);
				logger.info("URL : " + urlPrifix + "服务 " + solrUrl + " 加载完毕");
			}
		}
		return solrServerMap.get(wCoreName);
	}

	public static void shutdown() throws SolrServerException {
		if (container == null)
			throw new SolrServerException("不能关闭搜索server,server容器为空!!!");
		container.shutdown();
	}

}
*/
