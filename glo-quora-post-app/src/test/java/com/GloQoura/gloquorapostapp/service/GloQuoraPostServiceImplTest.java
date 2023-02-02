package com.GloQoura.gloquorapostapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.GloQoura.gloquorapostapp.model.GloQuoraPost;
import com.GloQoura.gloquorapostapp.repo.GloQuoraRepo;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {GloQuoraPostServiceImpl.class})
@ExtendWith(SpringExtension.class)
class GloQuoraPostServiceImplTest {
    @Autowired
    private GloQuoraPostServiceImpl gloQuoraPostServiceImpl;

    @MockBean
    private GloQuoraRepo gloQuoraRepo;

    /**
     * Method under test: {@link GloQuoraPostServiceImpl#addPost(GloQuoraPost)}
     */
    @Test
    void testAddPost() {
        GloQuoraPost gloQuoraPost = new GloQuoraPost(1, 1, "Dr", "Not all who wander are lost");

        when(gloQuoraRepo.save((GloQuoraPost) any())).thenReturn(gloQuoraPost);
        assertSame(gloQuoraPost,
                gloQuoraPostServiceImpl.addPost(new GloQuoraPost(1, 1, "Dr", "Not all who wander are lost")));
        verify(gloQuoraRepo).save((GloQuoraPost) any());
    }

    /**
     * Method under test: {@link GloQuoraPostServiceImpl#getAllPost()}
     */
    @Test
    void testGetAllPost() {
        ArrayList<GloQuoraPost> gloQuoraPostList = new ArrayList<>();
        when(gloQuoraRepo.findAll()).thenReturn(gloQuoraPostList);
        List<GloQuoraPost> actualAllPost = gloQuoraPostServiceImpl.getAllPost();
        assertSame(gloQuoraPostList, actualAllPost);
        assertTrue(actualAllPost.isEmpty());
        verify(gloQuoraRepo).findAll();
    }

    /**
     * Method under test: {@link GloQuoraPostServiceImpl#updatePost(int, GloQuoraPost)}
     */
    @Test
    void testUpdatePost() {
        GloQuoraPost gloQuoraPost = new GloQuoraPost(1, 1, "Dr", "Not all who wander are lost");

        when(gloQuoraRepo.save((GloQuoraPost) any())).thenReturn(gloQuoraPost);
        when(gloQuoraRepo.findById((Integer) any()))
                .thenReturn(Optional.of(new GloQuoraPost(1, 1, "Dr", "Not all who wander are lost")));
        assertSame(gloQuoraPost,
                gloQuoraPostServiceImpl.updatePost(123, new GloQuoraPost(1, 1, "Dr", "Not all who wander are lost")));
        verify(gloQuoraRepo).save((GloQuoraPost) any());
        verify(gloQuoraRepo).findById((Integer) any());
    }

    /**
     * Method under test: {@link GloQuoraPostServiceImpl#updatePost(int, GloQuoraPost)}
     */
    @Test
    void testUpdatePost2() {
        when(gloQuoraRepo.save((GloQuoraPost) any()))
                .thenReturn(new GloQuoraPost(1, 1, "Dr", "Not all who wander are lost"));
        when(gloQuoraRepo.findById((Integer) any())).thenReturn(Optional.empty());
        assertNull(gloQuoraPostServiceImpl.updatePost(123, new GloQuoraPost(1, 1, "Dr", "Not all who wander are lost")));
        verify(gloQuoraRepo).findById((Integer) any());
    }

    /**
     * Method under test: {@link GloQuoraPostServiceImpl#updatePost(int, GloQuoraPost)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdatePost3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.GloQoura.gloquorapostapp.model.GloQuoraPost.getUserid()" because "gloQuoraPost" is null
        //       at com.GloQoura.gloquorapostapp.service.GloQuoraPostServiceImpl.updatePost(GloQuoraPostServiceImpl.java:32)
        //   See https://diff.blue/R013 to resolve this issue.

        when(gloQuoraRepo.save((GloQuoraPost) any()))
                .thenReturn(new GloQuoraPost(1, 1, "Dr", "Not all who wander are lost"));
        when(gloQuoraRepo.findById((Integer) any()))
                .thenReturn(Optional.of(new GloQuoraPost(1, 1, "Dr", "Not all who wander are lost")));
        gloQuoraPostServiceImpl.updatePost(123, null);
    }

    /**
     * Method under test: {@link GloQuoraPostServiceImpl#deletePost(int)}
     */
    @Test
    void testDeletePost() {
        doNothing().when(gloQuoraRepo).deleteById((Integer) any());
        when(gloQuoraRepo.findById((Integer) any()))
                .thenReturn(Optional.of(new GloQuoraPost(1, 1, "Dr", "Not all who wander are lost")));
        assertEquals("Delete", gloQuoraPostServiceImpl.deletePost(1));
        verify(gloQuoraRepo).findById((Integer) any());
        verify(gloQuoraRepo).deleteById((Integer) any());
    }

    /**
     * Method under test: {@link GloQuoraPostServiceImpl#deletePost(int)}
     */
    @Test
    void testDeletePost2() {
        doNothing().when(gloQuoraRepo).deleteById((Integer) any());
        when(gloQuoraRepo.findById((Integer) any())).thenReturn(Optional.empty());
        assertEquals("Delete", gloQuoraPostServiceImpl.deletePost(1));
        verify(gloQuoraRepo).findById((Integer) any());
    }
}

