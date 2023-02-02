package com.GloQoura.gloquorapostapp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class GloQuoraPost {

    private int Userid;
    private int Post_id;
    private String Title;
    private String Body;

}
