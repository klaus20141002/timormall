/******************************************************************************
 * @File name   :      SolrServiceImpl.java
 *
 * @Author      :      niklaus
 *
 * @Date        :      2017年10月9日
 *
 * @Copyright Notice: 
 * Copyright (c) 2017 TimorJun, Inc. All  Rights Reserved.
 * This software is published under the terms of TimorJun
 * License version 1.0, a copy of which has been included with this
 * distribution in the LICENSE.txt file.
 * 
 * 
 * ----------------------------------------------------------------------------
 * Date                   Who         Version        Comments
 * 2017年10月9日 下午11:43:18        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.klauting.timormall.system.provider.serviceimpl;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klauting.timormall.system.api.service.ISolrService;

/**
 * @author niklaus mikaelson
 */
@Service("solrService")
public class SolrServiceImpl implements ISolrService {
	@Autowired
	private SolrClient  solrClient ;
	
	private static final Logger logger = LoggerFactory.getLogger( SolrServiceImpl.class );
	

	/**
	 * {@inheritDoc} 
	 * overridden:
	 * @Date        :      2017年10月9日
	 * @see com.klauting.timormall.system.api.service.ISolrService#pushDataIntoSolr(java.lang.String, org.apache.solr.common.SolrInputDocument)
	**/
	@Override
	public boolean pushDataIntoSolr(String coreName, SolrInputDocument input) {
		boolean flag = false;    
        try { 
        	solrClient.add(input);    
        	solrClient.commit();    
            flag = true;    
        } catch (Exception e) {    
            e.printStackTrace();    
            logger.error(e.getMessage());    
        } finally {    
            try {    
            	solrClient.close();    
            } catch (IOException e) {    
                e.printStackTrace();    
                logger.error(e.getMessage());    
            }    
        }    
		return flag;
	}

	/**
	 * {@inheritDoc} 
	 * overridden:
	 * @Date        :      2017年10月9日
	 * @see com.klauting.timormall.system.api.service.ISolrService#querySolrIndex(java.lang.String, java.lang.String)
	**/
	@Override
	public SolrDocumentList querySolrIndex(String coreName, String query) {
		SolrDocumentList list = null;
		try {
			QueryResponse rsp = null;
			SolrQuery queryStr = new SolrQuery("*:*");
			queryStr.addFilterQuery(query);
			rsp = solrClient.query(queryStr);
			list = rsp.getResults();
		} catch (Exception e) {
			logger.error("QuerySolrIndex Error {}", e.getMessage());
		} finally {
			try {
				solrClient.close();
			} catch (IOException e) {
				e.printStackTrace();
				logger.error(e.getMessage());
			}
		}
		return list;
	}

}
