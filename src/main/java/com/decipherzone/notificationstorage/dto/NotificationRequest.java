package com.decipherzone.notificationstorage.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class NotificationRequest {

    private String name;

    private Date lastUpdated;
    //private Notification notification;

}
