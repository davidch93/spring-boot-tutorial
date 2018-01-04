package com.dch.tutorial.thymeleaf.common.dataaccess;

import com.dch.tutorial.thymeleaf.enums.DataStatus;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * Class that defined common field that exist in every model and mapped as
 * superclass.
 *
 * @author David.Christianto
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 3413927315317624024L;

    @Convert(converter = DataStatusConverter.class)
    @Column(name = "status")
    protected DataStatus status;

    @Column(name = "created_by", updatable = false)
    @CreatedBy
    protected String createdBy;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    protected Date createdDate;

    @Column(name = "modified_by")
    @LastModifiedBy
    protected String modifiedBy;

    @Column(name = "modified_date")
    @LastModifiedDate
    protected Date modifiedDate;

    /**
     * @return the status
     */
    public DataStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(DataStatus status) {
        this.status = status;
    }

    /**
     * @return the createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return the modifiedBy
     */
    public String getModifiedBy() {
        return modifiedBy;
    }

    /**
     * @param modifiedBy the modifiedBy to set
     */
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    /**
     * @return the modifiedDate
     */
    public Date getModifiedDate() {
        return modifiedDate;
    }

    /**
     * @param modifiedDate the modifiedDate to set
     */
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
