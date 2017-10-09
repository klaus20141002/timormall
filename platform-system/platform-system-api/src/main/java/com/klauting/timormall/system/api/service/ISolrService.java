/******************************************************************************
 * @File name   :      ISolrService.java
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
 * 2017年10月9日 下午11:38:55        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.klauting.timormall.system.api.service;

import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

/**
 *
 */
public interface ISolrService {
    /**
     * @Date        :      2017年10月9日
     * @param coreName
     * @param input
     * @return
     */
    public boolean pushDataIntoSolr(String coreName ,SolrInputDocument input);  
      
    /**
     * @Date        :      2017年10月9日
     * @param coreName
     * @param query
     * @return
     */
    public SolrDocumentList querySolrIndex(String coreName, String query);  
}
