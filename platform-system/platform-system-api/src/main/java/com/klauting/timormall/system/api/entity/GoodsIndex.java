package com.klauting.timormall.system.api.entity;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName="goods") // Solr collection name
public class GoodsIndex {
    @Id
    @Field
    private String id;   // platform_id+goods_id
    @Field
    private String name;  //goods_title
//    @Field
//    private List<String> category; //分类
    @Field
    private double price;  //价格
    @Field
    private long volume; //销量
    @Field
    private long comment;//评论数
    @Field
    private int coupon;// 是否有优惠券
    
      
    private String brand ; //品牌

//    public List<String> getCategory() {
//		return category;
//	}
//
//	public void setCategory(List<String> category) {
//		this.category = category;
//	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getComment() {
        return comment;
    }

    public void setComment(long comment) {
        this.comment = comment;
    }

	public long getVolume() {
		return volume;
	}

	public void setVolume(long volume) {
		this.volume = volume;
	}

	public int getCoupon() {
		return coupon;
	}

	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}
    
}
