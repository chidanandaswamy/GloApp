package com.GloQoura.userdetails.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.lang.annotation.Documented;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "User_Details")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int userId;
    private String name;
    private String userName;
    private String email;
    private String phone;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address  address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "geo_id", referencedColumnName = "gid")
    private  Geo geo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "c_id", referencedColumnName = "cid")
    private Company company;

}
