package com.GloQoura.gloquorapostapp.service;

import com.GloQoura.gloquorapostapp.model.GloQuoraPost;
import com.GloQoura.gloquorapostapp.repo.GloQuoraRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GloQuoraPostServiceImpl implements GloQuoraService {

    @Autowired
    private GloQuoraRepo gloQuoraRepo;
    @Override
    public GloQuoraPost addPost(GloQuoraPost gloQuoraPost) {
        return gloQuoraRepo.save(gloQuoraPost);
    }

    @Override
    public List<GloQuoraPost> getAllPost() {
        return gloQuoraRepo.findAll();
    }

    @Override
    public GloQuoraPost updatePost(int pId, GloQuoraPost gloQuoraPost) {

        Optional<GloQuoraPost> byId = gloQuoraRepo.findById(pId);
        if (byId.isPresent()) {
            GloQuoraPost foundGloData = byId.get();
            foundGloData.setUserid(gloQuoraPost.getUserid());
            foundGloData.setPost_id(gloQuoraPost.getPost_id());
            foundGloData.setTitle(gloQuoraPost.getTitle());
            foundGloData.setTitle(gloQuoraPost.getTitle());
            return gloQuoraRepo.save(foundGloData);
        }return null;
    }

    @Override
    public String deletePost(int id) {
        Optional<GloQuoraPost> byId = gloQuoraRepo.findById(id);
        if(byId.isPresent())
            gloQuoraRepo.deleteById(id);

        return "Delete";
    }
}
