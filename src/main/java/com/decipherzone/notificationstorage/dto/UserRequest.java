package com.decipherzone.notificationstorage.dto;

import com.decipherzone.notificationstorage.model.Notification;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class UserRequest {

    private String name;
    private String phone;
    private String email;
    private Notification notification;
    private Date lastUpdated;


}
