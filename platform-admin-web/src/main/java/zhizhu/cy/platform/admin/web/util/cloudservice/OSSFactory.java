package zhizhu.cy.platform.admin.web.util.cloudservice;

import zhizhu.cy.platform.admin.web.constant.Constant;
import zhizhu.cy.platform.admin.web.util.SpringContextUtils;

/**
 * 文件上传Factory
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-26 10:18
 */
public final class OSSFactory {
    private static CloudStorageConfig config;

    static {
        OSSFactory.config = (CloudStorageConfig) SpringContextUtils.getBean("cloudStorageConfig");
        System.out.println("static invoked "+config.getType());
//        OSSFactory.config = new CloudStorageConfig();
    }

    public static CloudStorageService build(){
        //获取云存储配置信息
        if(Integer.valueOf(config.getType()) == Constant.CloudService.QINIU.getValue()){
//            return new QiniuCloudStorageService(config);
        }else if(Integer.valueOf(config.getType())  == Constant.CloudService.ALIYUN.getValue()){
//            return new AliyunCloudStorageService(config);
        }else if(Integer.valueOf(config.getType())  == Constant.CloudService.QCLOUD.getValue()){
            return new QcloudCloudStorageService(config);
        }

        return null;
    }

}
