package com.gloapp.AdminApp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class GloQuoraPost {

    private int Userid;
    private int Post_id;
    private String Title;
    private String Body;

}
