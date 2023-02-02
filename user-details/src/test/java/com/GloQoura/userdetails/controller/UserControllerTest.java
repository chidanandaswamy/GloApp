package com.GloQoura.userdetails.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

import com.GloQoura.userdetails.excepation.UserNameAlreadyExist;
import com.GloQoura.userdetails.excepation.UserNotFound;
import com.GloQoura.userdetails.model.Address;
import com.GloQoura.userdetails.model.Company;
import com.GloQoura.userdetails.model.Geo;
import com.GloQoura.userdetails.model.UserDetails;
import com.GloQoura.userdetails.service.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {UserController.class})
@ExtendWith(SpringExtension.class)
class UserControllerTest {
    @Autowired
    private UserController userController;

    @MockBean
    private UserServiceImpl userServiceImpl;

    /**
     * Method under test: {@link UserController#addUser(UserDetails)}
     */
    @Test
    void testAddUser() throws Exception {
        Address address = new Address();
        address.setAddId(123);
        address.setCity("Oxford");
        address.setStreet("Street");

        Company company = new Company();
        company.setCId(123);
        company.setLocation("Location");
        company.setName("Name");

        Geo geo = new Geo();
        geo.setGepId(123);
        geo.setLatitude("Latitude");
        geo.setLongitude("Longitude");

        UserDetails userDetails = new UserDetails();
        userDetails.setAddress(address);
        userDetails.setCompany(company);
        userDetails.setEmail("jane.doe@example.org");
        userDetails.setGeo(geo);
        userDetails.setName("Name");
        userDetails.setPhone("4105551212");
        userDetails.setUserId(123);
        userDetails.setUserName("janedoe");
        when(userServiceImpl.addUser((UserDetails) any())).thenReturn(userDetails);

        Address address1 = new Address();
        address1.setAddId(123);
        address1.setCity("Oxford");
        address1.setStreet("Street");

        Company company1 = new Company();
        company1.setCId(123);
        company1.setLocation("Location");
        company1.setName("Name");

        Geo geo1 = new Geo();
        geo1.setGepId(123);
        geo1.setLatitude("Latitude");
        geo1.setLongitude("Longitude");

        UserDetails userDetails1 = new UserDetails();
        userDetails1.setAddress(address1);
        userDetails1.setCompany(company1);
        userDetails1.setEmail("jane.doe@example.org");
        userDetails1.setGeo(geo1);
        userDetails1.setName("Name");
        userDetails1.setPhone("4105551212");
        userDetails1.setUserId(123);
        userDetails1.setUserName("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(userDetails1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userController).build().perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"userId\":123,\"name\":\"Name\",\"userName\":\"janedoe\",\"email\":\"jane.doe@example.org\",\"phone\":\"4105551212\""
                                        + ",\"address\":{\"addId\":123,\"street\":\"Street\",\"city\":\"Oxford\"},\"geo\":{\"gepId\":123,\"latitude\":\"Latitude\","
                                        + "\"longitude\":\"Longitude\"},\"company\":{\"name\":\"Name\",\"location\":\"Location\",\"cid\":123}}"));
    }

    /**
     * Method under test: {@link UserController#addUser(UserDetails)}
     */
    @Test
    void testAddUser2() throws Exception {
        when(userServiceImpl.addUser((UserDetails) any()))
                .thenThrow(new UserNameAlreadyExist("Not all who wander are lost"));

        Address address = new Address();
        address.setAddId(123);
        address.setCity("Oxford");
        address.setStreet("Street");

        Company company = new Company();
        company.setCId(123);
        company.setLocation("Location");
        company.setName("Name");

        Geo geo = new Geo();
        geo.setGepId(123);
        geo.setLatitude("Latitude");
        geo.setLongitude("Longitude");

        UserDetails userDetails = new UserDetails();
        userDetails.setAddress(address);
        userDetails.setCompany(company);
        userDetails.setEmail("jane.doe@example.org");
        userDetails.setGeo(geo);
        userDetails.setName("Name");
        userDetails.setPhone("4105551212");
        userDetails.setUserId(123);
        userDetails.setUserName("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(userDetails);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(409))
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Not all who wander are lost"));
    }

    /**
     * Method under test: {@link UserController#updateUser(int, UserDetails)}
     */
    @Test
    void testUpdateUser() throws Exception {
        Address address = new Address();
        address.setAddId(123);
        address.setCity("Oxford");
        address.setStreet("Street");

        Company company = new Company();
        company.setCId(123);
        company.setLocation("Location");
        company.setName("Name");

        Geo geo = new Geo();
        geo.setGepId(123);
        geo.setLatitude("Latitude");
        geo.setLongitude("Longitude");

        UserDetails userDetails = new UserDetails();
        userDetails.setAddress(address);
        userDetails.setCompany(company);
        userDetails.setEmail("jane.doe@example.org");
        userDetails.setGeo(geo);
        userDetails.setName("Name");
        userDetails.setPhone("4105551212");
        userDetails.setUserId(123);
        userDetails.setUserName("janedoe");
        when(userServiceImpl.updateUser(anyInt(), (UserDetails) any())).thenReturn(userDetails);

        Address address1 = new Address();
        address1.setAddId(123);
        address1.setCity("Oxford");
        address1.setStreet("Street");

        Company company1 = new Company();
        company1.setCId(123);
        company1.setLocation("Location");
        company1.setName("Name");

        Geo geo1 = new Geo();
        geo1.setGepId(123);
        geo1.setLatitude("Latitude");
        geo1.setLongitude("Longitude");

        UserDetails userDetails1 = new UserDetails();
        userDetails1.setAddress(address1);
        userDetails1.setCompany(company1);
        userDetails1.setEmail("jane.doe@example.org");
        userDetails1.setGeo(geo1);
        userDetails1.setName("Name");
        userDetails1.setPhone("4105551212");
        userDetails1.setUserId(123);
        userDetails1.setUserName("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(userDetails1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/updateuser/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"userId\":123,\"name\":\"Name\",\"userName\":\"janedoe\",\"email\":\"jane.doe@example.org\",\"phone\":\"4105551212\""
                                        + ",\"address\":{\"addId\":123,\"street\":\"Street\",\"city\":\"Oxford\"},\"geo\":{\"gepId\":123,\"latitude\":\"Latitude\","
                                        + "\"longitude\":\"Longitude\"},\"company\":{\"name\":\"Name\",\"location\":\"Location\",\"cid\":123}}"));
    }

    /**
     * Method under test: {@link UserController#deleteUser(int)}
     */
    @Test
    void testDeleteUser() throws Exception {
        when(userServiceImpl.DeleteUser(anyInt())).thenReturn("Delete User");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/deleteuser/{id}", 1);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Delete User"));
    }

    /**
     * Method under test: {@link UserController#deleteUser(int)}
     */
    @Test
    void testDeleteUser2() throws Exception {
        when(userServiceImpl.DeleteUser(anyInt())).thenThrow(new UserNotFound("Not all who wander are lost"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/deleteuser/{id}", 1);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(409))
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Not all who wander are lost"));
    }

    /**
     * Method under test: {@link UserController#getSingleUser(int)}
     */
    @Test
    void testGetSingleUser() throws Exception {
        Address address = new Address();
        address.setAddId(123);
        address.setCity("Oxford");
        address.setStreet("Street");

        Company company = new Company();
        company.setCId(123);
        company.setLocation("Location");
        company.setName("Name");

        Geo geo = new Geo();
        geo.setGepId(123);
        geo.setLatitude("Latitude");
        geo.setLongitude("Longitude");

        UserDetails userDetails = new UserDetails();
        userDetails.setAddress(address);
        userDetails.setCompany(company);
        userDetails.setEmail("jane.doe@example.org");
        userDetails.setGeo(geo);
        userDetails.setName("Name");
        userDetails.setPhone("4105551212");
        userDetails.setUserId(123);
        userDetails.setUserName("janedoe");
        when(userServiceImpl.getSpecificUser(anyInt())).thenReturn(userDetails);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getuser/{id}", 1);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"userId\":123,\"name\":\"Name\",\"userName\":\"janedoe\",\"email\":\"jane.doe@example.org\",\"phone\":\"4105551212\""
                                        + ",\"address\":{\"addId\":123,\"street\":\"Street\",\"city\":\"Oxford\"},\"geo\":{\"gepId\":123,\"latitude\":\"Latitude\","
                                        + "\"longitude\":\"Longitude\"},\"company\":{\"name\":\"Name\",\"location\":\"Location\",\"cid\":123}}"));
    }

    /**
     * Method under test: {@link UserController#getSingleUser(int)}
     */
    @Test
    void testGetSingleUser2() throws Exception {
        when(userServiceImpl.getSpecificUser(anyInt())).thenThrow(new UserNotFound("Not all who wander are lost"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getuser/{id}", 1);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(409))
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Not all who wander are lost"));
    }

    /**
     * Method under test: {@link UserController#getallUserDetails()}
     */
    @Test
    void testGetallUserDetails() throws Exception {
        when(userServiceImpl.getAllUser()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getalluser");
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link UserController#getallUserDetails()}
     */
    @Test
    void testGetallUserDetails2() throws Exception {
        when(userServiceImpl.getAllUser()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/getalluser");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

