package zhizhu.cy.platform.common.api;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import zhizhu.cy.platform.common.utils.RandomHelper;

/**
 * 数据Entity类
 *
 * @author zhangxd
 */
@SuppressWarnings("serial")
public abstract class DataEntity extends BaseEntity {

	/**
     * 删除标记0：正常
     */
    public static final Integer DEL_FLAG_NORMAL = 0;
    /**
     * 删除标记1：删除
     */
    public static final Integer DEL_FLAG_DELETE = 1;

    /**
     * 创建日期
     */
    private Date createTime;
    /**
     * 更新日期
     */
    private Date updateTime;
    /**
     * 删除标记(0:正常;1:删除;)
     */
    private Integer dataStatus;

    public DataEntity() {
        super();
        this.dataStatus = DEL_FLAG_NORMAL;
    }

    public DataEntity(String id) {
        super(id);
    }

    /**
     * 插入之前执行方法，需要手动调用
     */
    @Override
    public void preInsert() {
        // 不限制ID为UUID，调用setIsNewRecord()使用自定义ID
        if (this.getIsNewRecord()) {
            setId(RandomHelper.uuid());
        }
        this.updateTime = new Date();
        this.createTime = this.updateTime;
    }

    /**
     * 更新之前执行方法，需要手动调用
     */
    @Override
    public void preUpdate() {
        this.updateTime = new Date();
    }

    public Date getCreateTime() {
        return createTime == null ? null : (Date) createTime.clone();
    }

    public void setCreateTime(Date createDate) {
        this.createTime = createDate == null ? null : (Date) createDate.clone();
    }

    public Date getUpdateTime() {
        return updateTime == null ? null : (Date) updateTime.clone();
    }

    public void setUpdateTime(Date updateDate) {
        this.updateTime = updateDate == null ? null : (Date) updateDate.clone();
    }

    @JsonIgnore
    @Length(min = 1, max = 1)
    public Integer getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(Integer dataStatus) {
        this.dataStatus = dataStatus;
    }

}
