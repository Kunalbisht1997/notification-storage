package com.decipherzone.notificationstorage.repository;

import com.decipherzone.notificationstorage.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
