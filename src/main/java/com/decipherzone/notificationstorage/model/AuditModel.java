package com.decipherzone.notificationstorage.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter

public abstract class AuditModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Temporal(TemporalType.TIME)
    @CreatedDate
    private Date timeCreated;

    @Temporal(TemporalType.DATE)
    @CreatedDate
    private Date dateCreated;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date lastUpdated;
}
