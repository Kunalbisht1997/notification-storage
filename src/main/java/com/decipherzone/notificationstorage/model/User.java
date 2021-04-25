package com.decipherzone.notificationstorage.model;



import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Size(min = 2, message = "Name Should contain atleast 2 words ")
    private String name;
    @NotNull
    @Size(min = 0,max=10, message = "Enter at Full Number")
    private String phone;
    @NotBlank
    @Email
    private String email;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user",cascade = CascadeType.ALL)
    private List <Notification> notification;

}
