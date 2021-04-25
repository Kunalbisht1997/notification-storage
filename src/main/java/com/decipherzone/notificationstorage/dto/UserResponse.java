package com.decipherzone.notificationstorage.dto;

import com.decipherzone.notificationstorage.model.Notification;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class UserResponse {
    private Integer id;
    private String name;
    private String phone;
    private String email;
    private List<NotificationResponse> notification;

}
