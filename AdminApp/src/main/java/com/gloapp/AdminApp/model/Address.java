package com.gloapp.AdminApp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Address {


    private int addId;

   private String street;


   private String city;

//    @OneToOne(mappedBy = "address")
//    private UserDetails userDetails;

}
