package com.GloQoura.gloquorapostapp.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

import com.GloQoura.gloquorapostapp.model.GloQuoraPost;
import com.GloQoura.gloquorapostapp.service.GloQuoraService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {GloPostDriver.class})
@ExtendWith(SpringExtension.class)
class GloPostDriverTest {
    @Autowired
    private GloPostDriver gloPostDriver;

    @MockBean
    private GloQuoraService gloQuoraService;

    /**
     * Method under test: {@link GloPostDriver#addPost(GloQuoraPost)}
     */
    @Test
    void testAddPost() throws Exception {
        when(gloQuoraService.addPost((GloQuoraPost) any()))
                .thenReturn(new GloQuoraPost(1, 1, "Dr", "Not all who wander are lost"));

        GloQuoraPost gloQuoraPost = new GloQuoraPost();
        gloQuoraPost.setBody("Not all who wander are lost");
        gloQuoraPost.setPost_id(1);
        gloQuoraPost.setTitle("Dr");
        gloQuoraPost.setUserid(1);
        String content = (new ObjectMapper()).writeValueAsString(gloQuoraPost);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addglopost")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(gloPostDriver)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"userid\":1,\"post_id\":1,\"title\":\"Dr\",\"body\":\"Not all who wander are lost\"}"));
    }

    /**
     * Method under test: {@link GloPostDriver#getalldata()}
     */
    @Test
    void testGetalldata() throws Exception {
        when(gloQuoraService.getAllPost()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getallpost");
        MockMvcBuilders.standaloneSetup(gloPostDriver)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link GloPostDriver#getalldata()}
     */
    @Test
    void testGetalldata2() throws Exception {
        when(gloQuoraService.getAllPost()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/getallpost");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(gloPostDriver)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link GloPostDriver#updateData(int)}
     */
    @Test
    void testUpdateData() throws Exception {
        when(gloQuoraService.deletePost(anyInt())).thenReturn("Delete Post");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/deletedata/{id}", 1);
        MockMvcBuilders.standaloneSetup(gloPostDriver)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Delete Post"));
    }

    /**
     * Method under test: {@link GloPostDriver#updateData(int)}
     */
    @Test
    void testUpdateData2() throws Exception {
        when(gloQuoraService.deletePost(anyInt())).thenReturn("Delete Post");
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/deletedata/{id}", 1);
        deleteResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(gloPostDriver)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Delete Post"));
    }

    /**
     * Method under test: {@link GloPostDriver#updateData(int, GloQuoraPost)}
     */
    @Test
    void testUpdateData3() throws Exception {
        when(gloQuoraService.updatePost(anyInt(), (GloQuoraPost) any()))
                .thenReturn(new GloQuoraPost(1, 1, "Dr", "Not all who wander are lost"));

        GloQuoraPost gloQuoraPost = new GloQuoraPost();
        gloQuoraPost.setBody("Not all who wander are lost");
        gloQuoraPost.setPost_id(1);
        gloQuoraPost.setTitle("Dr");
        gloQuoraPost.setUserid(1);
        String content = (new ObjectMapper()).writeValueAsString(gloQuoraPost);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/updatedata/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(gloPostDriver)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"userid\":1,\"post_id\":1,\"title\":\"Dr\",\"body\":\"Not all who wander are lost\"}"));
    }
}

