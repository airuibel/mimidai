/*
package com.mimidai.config;


import com.mimidai.utils.Page;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.*;
import org.apache.solr.common.params.GroupParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

*/
/**
 * 封装Solr创建、删除、更新、检索等索引操作
 *
 * @author Boya
 *//*

@Service
public class SolrTemplate {

    private static Logger logger = LoggerFactory.getLogger(SolrTemplate.class);
    private SolrServer server;

    public SolrTemplate() {
        this.server = SolrServerFactory.getCommonsHttpSolrServer();
    }

    public SolrTemplate(String coreName) {
        this.server = SolrServerFactory.getCloudSolrServer(coreName);
    }

//    public SolrTemplate(String coreName, String prefix) {
//        this.server = SolrServerFactory.getCommonsHttpSolrServer(coreName, prefix);
//    }

    */
/**
     * 索引设置唯一主键ID，已存在对象默认为更新操作，覆盖原索引
     *
     * @param object
     *//*

    public void add(Object object) {
        try {
            server.addBean(object);
//            server.commit(false, false);
        } catch (Exception e) {
            logger.error("添加索引失败", e);
            throw new RuntimeException("添加索引失败：" + e);
        }
    }

    public void add(Collection<?> beans) {
        try {
            server.addBeans(beans);
//            server.commit(false, false);
        } catch (Exception e) {
            logger.error("添加索引失败", e);
            throw new RuntimeException("添加索引失败：" + e);
        }
    }

    public <T> Page<T> query(String keyword, Class<T> entityClass, Page page) {
        SolrQuery query = new SolrQuery();
        query.setQuery("q:" + keyword);
        return this.query(query, entityClass, page);
    }

    public <T> List<T> query(SolrQuery query, Class<T> entityClass, boolean sort) {
        if (sort){
            query.addSort("callTimes", SolrQuery.ORDER.desc);
        }
        return query(query, entityClass);
    }

    public <T> List<T> query(SolrQuery query, Class<T> entityClass) {
        QueryResponse response = null;
        try {
//            int count = this.count(query).intValue();

//            synchronized (server) {
//                query.setStart(0);
////                query.setRows(count);
//                query.setRows(80000);
//                response = server.query(query);
//            }
            query.setStart(0);
//                query.setRows(count);
            query.setRows(80000);
            response = server.query(query);
        } catch (Exception e) {
            logger.error("检索索引失败：" + e);
            return null;
        }
        return response.getBeans(entityClass);
    }

    public <T> List<T> queryExtraInfo(SolrQuery query, Class<T> entityClass) {
        QueryResponse response = null;
        try {
//            synchronized (server) {
//                query.setStart(0);
//                response = server.query(query);
//            }
            query.setStart(0);
            response = server.query(query);
        } catch (Exception e) {
            logger.error("检索索引失败：" + e);
            return null;
        }
        return response.getBeans(entityClass);
    }

    public <T> List<T> simpleQuery(SolrQuery query, Class<T> entityClass) {
        QueryResponse response = null;
        try {
//            synchronized (server) {
//                query.setStart(0);
//                query.setRows(2000);
//                response = server.query(query);
//            }
            query.setStart(0);
            query.setRows(2000);
            response = server.query(query);
        } catch (Exception e) {
            logger.error("检索索引失败：" + e);
            return null;
        }
        return response.getBeans(entityClass);
    }

    public Long count(SolrQuery query) {
        QueryResponse response = null;
        try {
//            synchronized (server) {
//                response = server.query(query);
//
//            }
            response = server.query(query);
        } catch (Exception e) {
            logger.error("检索索引失败：", e);
            return null;
        }
        return response.getResults().getNumFound();
    }

    public <T> Page<T> query(SolrQuery query, Class<T> entityClass, Page page) {
        query.setStart(page.getOffset());
        query.setRows(page.getPageSize());

        if (StringUtils.isNotBlank(page.getOrderBy()) && StringUtils.isNotBlank(page.getOrderDir())) {
            List<Page.Sort> sortList = page.getSort();
            for (Page.Sort sort : sortList) {
                query.addSort(sort.getProperty(), SolrQuery.ORDER.valueOf(sort.getDir()));
            }
        }

        QueryResponse response = null;
        try {
            response = server.query(query);
        } catch (SolrServerException e) {
            logger.error("检索索引失败：" + e);
            return null;
        }

        List<T> result = response.getBeans(entityClass);
        long totalCount = response.getResults().getNumFound();
        page.setTotalCount(totalCount);
        page.setResult(result);

        return page;
    }

    public Map<String, Integer> facet(SolrQuery query, String groupField) {
        Map<String, Integer> rmap = new LinkedHashMap<String, Integer>();
        try {
            query.setIncludeScore(false);// 是否按每组数量高低排序
            query.setFacet(true);// 是否分组查询
            query.addFacetField(groupField);// 增加分组字段
            // query.set(FacetParams.FACET_OFFSET,(pageNum-1)*pageSize);//当前结果起始位置
//            Long num=this.count(query);
            query.setFacetLimit(80000);// 限制每次返回结果数
            QueryResponse response = server.query(query*/
/*, SolrRequest.METHOD.POST*//*
);

            List<FacetField.Count> countList = response.getFacetField(groupField).getValues();

            for (FacetField.Count count : countList) {
                if (count.getCount() > 0)
                    rmap.put(count.getName(), (int) count.getCount());
            }
        } catch (Exception e) {
            logger.error("solr分组查询出错query:" + query.getQuery(), e);
        }
        return rmap;
    }

    public List<Group> group(SolrQuery query, String groupField) {
        Map<String, Integer> rmap = new LinkedHashMap<String, Integer>();
        try {
            query.setParam(GroupParams.GROUP, true);
            query.setParam(GroupParams.GROUP_FIELD, groupField);
            query.setParam(GroupParams.GROUP_MAIN, false);
            query.setStart(0);
//            Long num = this.count(query);
//            query.setRows(num.intValue());
            query.setRows(80000);
            QueryResponse response = server.query(query);

            if (response != null) {
                GroupResponse groupResponse = response.getGroupResponse();
                if (groupResponse != null) {
                    List<GroupCommand> groupList = groupResponse.getValues();
                    for (GroupCommand groupCommand : groupList) {
                        List<Group> groups = groupCommand.getValues();
//						for(Group group : groups) {
//							System.out.println("group查询...电话,"+group.getGroupValue()+"数量："+group.getResult().getNumFound());
//						}
                        return groups;
                    }
                }
            }
        } catch (Exception e) {
            logger.error("solr分组查询出错Query--" + query.getQuery(), e);
        }
        return null;
    }

    public void deleteById(Object id) {
        try {
            server.deleteById(id.toString());
//            server.commit(false, false);
        } catch (Exception e) {
            logger.error("删除索引(id：" + id + ")失败", e);
            throw new RuntimeException("删除索引(id：" + id + ")失败：" + e);
        }
    }

    public void deleteAll() {
        try {
            server.deleteByQuery("*:*");
//            server.commit(false, false);
        } catch (Exception e) {
            logger.error("删除索引失败", e);
            throw new RuntimeException("删除索引失败：" + e);
        }
    }

    public void deleteByCondition(String condition) {
        try {
            server.deleteByQuery(condition);
//            server.commit(false, false);
        } catch (Exception e) {
            logger.error("删除索引失败", e);
            throw new RuntimeException("删除索引失败：" + e);
        }
    }

    public void optimize() {
        try {
            server.optimize();
        } catch (Exception e) {
            logger.error("优化索引失败：", e);
            throw new RuntimeException("优化索引失败：" + e);
        }
    }

    public void shutdown() {
        try {
            SolrServerFactory.shutdown();
        } catch (Exception e) {
            logger.error("SolrServer关闭异常", e);
            throw new RuntimeException("SolrServer关闭异常：" + e);
        }
    }

//	public static void main(String args[]) throws Exception {
//		Connection con = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		try {
//			SolrTemplate solrTemplate = new SolrTemplate();
//			con = DriverManager.getConnection("jdbc:mysql://192.168.1.10:3306/mimidai?characterEncoding=utf-8", "root",
//					"root");
//			stmt = con.createStatement();
//			rs = stmt.executeQuery("select * from user_phone_contacts where id>1940296");
//			List<UserPhoneContacts> list = new ArrayList<UserPhoneContacts>();
//			int count = 0;
//			while (rs.next()) {
//				UserPhoneContacts pc = new UserPhoneContacts();
//				pc.setId(rs.getString("id"));
//				pc.setUserId(rs.getLong("user_id"));
//				pc.setPhone(rs.getString("phone"));
//				pc.setImei(rs.getString("imei"));
//				pc.setImsi(rs.getString("imsi"));
//				pc.setName(rs.getString("name"));
//				pc.setCallTimes(rs.getLong("call_times"));
//				pc.setLastCall(rs.getDate("last_call"));
//				pc.setSensitive(rs.getString("sensitive"));
//				list.add(pc);
//				if (list.size() >= 5000) {
//					try {
//						solrTemplate.add(list);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//					list = new ArrayList<UserPhoneContacts>();
//					count += 5000;
//					System.out.println("==========时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
//							+ "--写入记录数：" + count + "---最后记录id：" + pc.getId());
//				}
//			}
//			try {
//				solrTemplate.add(list);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			list = new ArrayList<UserPhoneContacts>();
//			count += list.size();
//			System.out.println("==========时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
//					+ "--写入记录数：" + count + "---最后记录id：" + list.get(list.size() - 1).getId());
//
//			// BeanFactory beanFactory = new
//			// ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
//
//			// ProductService productService =
//			// beanFactory.getBean("productService", ProductService.class);
//			// SolrTemplate solrTemplate =
//			// beanFactory.getBean("videoSolrTemplate", SolrTemplate.class);
//			// Page<Video> page = solrTemplate.query("*", Video.class, new
//			// Page());
//			// for (Video v : page.getResult()) {
//			// System.out.println(v.getId());
//			// }
//			// long totalCount = productService.count(new Query());
//			// int pageSize = 2000;
//			// int totalPages = (int) Math.ceil((double) totalCount / (double)
//			// pageSize);
//			// logger.error("==========totalCount:"+totalCount+";totalPages:"+totalPages);
//			// for (int i=0;i < totalPages;i++) {
//			// Query query = new Query();
//			// query.skip(i*pageSize).limit(pageSize);
//			// query.sort().on("_id", Order.ASCENDING);
//			// List<Product> productList = productService.find(query);
//			// solrTemplate.add(productList);
//			// logger.error("=====index:"+i);
//			// }
//			//
//			// Page<Book> page = solrTemplate.query("*", Book.class, new
//			// Page(1,100));
//			// System.out.println("====total index:"+page.getTotalCount());
//
//			// 删除索引
//			// solrTemplate.deleteAll();
//
//			// 检索索引
//			// SolrQuery query = new SolrQuery();
//			// //query.setQuery("q:哈雷 AND prodPriceList:\\\"shopId\\\"\\:7");
//			// query.setQuery("(id:636612 or id:694929 or id:702383)");
//			//
//			// Page<Book> page = solrTemplate.query(query, Book.class, new
//			// Page(1,10));
//			//
//			// System.out.println(page.getTotalCount());
//			//
//			// for (Product td : page.getResult()) {
//			// System.out.println(td);
//			// }
//
//			// 分组检索
//			// SolrQuery query = new SolrQuery();
//			// query.setQuery("q:*");
//			// Map<String, Integer> map = solrTemplate.group(query,
//			// "categoryId");
//			// System.out.println(map.size());
//			// Set<String> set = map.keySet();
//			// for (String key : set) {
//			// System.out.println(key+":"+map.get(key));
//			// }
//			// solrTemplate.shutdown();
//		} catch (Exception e) {
//
//			if (rs != null)
//				rs.close();
//			if (stmt != null)
//				stmt.close();
//			if (con != null) {
//				con.close();
//			}
//		}
//
//	}

}
*/
