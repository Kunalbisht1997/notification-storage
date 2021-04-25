package com.decipherzone.notificationstorage.repository;

import com.decipherzone.notificationstorage.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Integer> {
}
