package com.GloQoura.gloquorapostapp.controller;


import com.GloQoura.gloquorapostapp.model.GloQuoraPost;
import com.GloQoura.gloquorapostapp.service.GloQuoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RestController
public class GloPostDriver {

    @Autowired
    private GloQuoraService gloQuoraService;


    @PostMapping("/addglopost")
    public GloQuoraPost addPost(@RequestBody GloQuoraPost gloQuoraPost) {

        return gloQuoraService.addPost(gloQuoraPost);
    }


    @GetMapping("/getallpost")
    public List<GloQuoraPost> getalldata() {

        return gloQuoraService.getAllPost();
    }

    @PutMapping("/updatedata/{id}")
    public GloQuoraPost updateData(@PathVariable("id") int id, @RequestBody GloQuoraPost gloQuoraPost) {

        return gloQuoraService.updatePost(id, gloQuoraPost);
    }

    @DeleteMapping("/deletedata/{id}")
    public String updateData(@PathVariable("id") int id) {

        return gloQuoraService.deletePost(id);
    }

}
