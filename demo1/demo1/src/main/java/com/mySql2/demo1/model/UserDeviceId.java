package com.mySql2.demo1.model;

import com.mySql2.demo1.model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_device_id_map")
@Getter
@Setter
public class UserDeviceId {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "user_id_fk")
    private User user;
    @Column(name = "device_id")
    private String deviceId;

}
