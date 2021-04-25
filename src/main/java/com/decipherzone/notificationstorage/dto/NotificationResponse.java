package com.decipherzone.notificationstorage.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class NotificationResponse {
    private Integer id;
    private String name;
    private Date timeCreated;
    private Date dateCreated;
    private Date lastUpdated;
}
