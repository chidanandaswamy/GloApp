package com.gloapp.AdminApp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Geo {

    private int gepId;
private  String latitude;


private  String longitude;

//    @OneToOne(mappedBy = "geo")
//    private UserDetails userDetails;

}
