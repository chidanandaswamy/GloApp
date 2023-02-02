package com.gloapp.AdminApp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class UserDetails {


    private  int userId;
    private String name;
    private String userName;
    private String email;
    private String phone;


//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id", referencedColumnName = "id")
//    private Address  address;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "geo_id", referencedColumnName = "gid")
//    private  Geo geo;

}
