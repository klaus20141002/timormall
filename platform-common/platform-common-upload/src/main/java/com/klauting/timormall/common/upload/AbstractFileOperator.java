package com.klauting.timormall.common.upload;


import com.klauting.timormall.common.utils.FileHelper;
import com.klauting.timormall.common.utils.StringHelper;

/**
 * 文件处理器.
 *
 * @author zhangxd
 */
public abstract class AbstractFileOperator implements FileOperator {

    /**
     * 文件服务器地址
     */
    private String accessUrl;

    public AbstractFileOperator() {
    }

    public AbstractFileOperator(String accessUrl) {
        this.accessUrl = accessUrl;
    }

    @Override
    public String getFileUrl(String realPath) {
        if (StringHelper.isEmpty(accessUrl)) {
            throw new NullPointerException("文件服务器访问地址为空.");
        }
        return StringHelper.isEmpty(realPath) ? "" : FileHelper.addEndSlash(accessUrl) + realPath;
    }

    public String getAccessUrl() {
        return accessUrl;
    }

    public void setAccessUrl(String accessUrl) {
        this.accessUrl = accessUrl;
    }
}


