package com.klauting.timormall.admin.web.util.cloudservice;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * 云存储配置信息
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-25 16:12
 */
@Component(value="cloudStorageConfig")
public class CloudStorageConfig implements Serializable {
    private static final long serialVersionUID = 1L;

    //类型 1：七牛  2：阿里云  3：腾讯云
    
    
    @Value("${oss.type}")
    private String type;

   /* //七牛绑定的域名
    @NotBlank(message="七牛绑定的域名不能为空", groups = QiniuGroup.class)
    @URL(message = "七牛绑定的域名格式不正确", groups = QiniuGroup.class)
    private String qiniuDomain;
    //七牛路径前缀
    private String qiniuPrefix;
    //七牛ACCESS_KEY
    @NotBlank(message="七牛AccessKey不能为空", groups = QiniuGroup.class)
    private String qiniuAccessKey;
    //七牛SECRET_KEY
    @NotBlank(message="七牛SecretKey不能为空", groups = QiniuGroup.class)
    private String qiniuSecretKey;
    //七牛存储空间名
    @NotBlank(message="七牛空间名不能为空", groups = QiniuGroup.class)
    private String qiniuBucketName;

    //阿里云绑定的域名
    @NotBlank(message="阿里云绑定的域名不能为空", groups = AliyunGroup.class)
    @URL(message = "阿里云绑定的域名格式不正确", groups = AliyunGroup.class)
    private String aliyunDomain;
    //阿里云路径前缀
    private String aliyunPrefix;
    //阿里云EndPoint
    @NotBlank(message="阿里云EndPoint不能为空", groups = AliyunGroup.class)
    private String aliyunEndPoint;
    //阿里云AccessKeyId
    @NotBlank(message="阿里云AccessKeyId不能为空", groups = AliyunGroup.class)
    private String aliyunAccessKeyId;
    //阿里云AccessKeySecret
    @NotBlank(message="阿里云AccessKeySecret不能为空", groups = AliyunGroup.class)
    private String aliyunAccessKeySecret;
    //阿里云BucketName
    @NotBlank(message="阿里云BucketName不能为空", groups = AliyunGroup.class)
    private String aliyunBucketName;*/

    //腾讯云绑定的域名
    @Value("${oss.qcloud-domain}")
    private String qcloudDomain;
    //腾讯云路径前缀
    @Value("${oss.qcloud-prefix}")
    private String qcloudPrefix;
    //腾讯云AppId
    @Value("${oss.qcloud-app-id}")
    private String qcloudAppId;
    //腾讯云SecretId
    @Value("${oss.qcloud-secret-id}")
    private String qcloudSecretId;
    //腾讯云SecretKey
    @Value("${oss.qcloud-secret-key}")
    private String qcloudSecretKey;
    //腾讯云BucketName
    @Value("${oss.qcloud-bucket-name}")
    private String qcloudBucketName;
    //腾讯云COS所属地区
    @Value("${oss.qcloud-region}")
    private String qcloudRegion;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getQcloudDomain() {
        return qcloudDomain;
    }

    public void setQcloudDomain(String qcloudDomain) {
        this.qcloudDomain = qcloudDomain;
    }

    public String getQcloudPrefix() {
        return qcloudPrefix;
    }

    public void setQcloudPrefix(String qcloudPrefix) {
        this.qcloudPrefix = qcloudPrefix;
    }

    public String getQcloudAppId() {
        return qcloudAppId;
    }

    public void setQcloudAppId(String qcloudAppId) {
        this.qcloudAppId = qcloudAppId;
    }

    public String getQcloudSecretId() {
        return qcloudSecretId;
    }

    public void setQcloudSecretId(String qcloudSecretId) {
        this.qcloudSecretId = qcloudSecretId;
    }

    public String getQcloudSecretKey() {
        return qcloudSecretKey;
    }

    public void setQcloudSecretKey(String qcloudSecretKey) {
        this.qcloudSecretKey = qcloudSecretKey;
    }

    public String getQcloudBucketName() {
        return qcloudBucketName;
    }

    public void setQcloudBucketName(String qcloudBucketName) {
        this.qcloudBucketName = qcloudBucketName;
    }

	public String getQcloudRegion() {
		return qcloudRegion;
	}

	public void setQcloudRegion(String qcloudRegion) {
		this.qcloudRegion = qcloudRegion;
	}
}
