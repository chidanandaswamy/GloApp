package com.GloQoura.gloquorapostapp.service;

import com.GloQoura.gloquorapostapp.model.GloQuoraPost;

import java.util.List;

public interface GloQuoraService {

    GloQuoraPost addPost(GloQuoraPost gloQuoraPost);

    List<GloQuoraPost> getAllPost();


    GloQuoraPost updatePost(int pId , GloQuoraPost gloQuoraPost);


    String deletePost(int id);


}
