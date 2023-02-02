package com.GloQoura.userdetails.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.GloQoura.userdetails.excepation.UserNameAlreadyExist;
import com.GloQoura.userdetails.excepation.UserNotFound;
import com.GloQoura.userdetails.model.Address;
import com.GloQoura.userdetails.model.Company;
import com.GloQoura.userdetails.model.Geo;
import com.GloQoura.userdetails.model.UserDetails;
import com.GloQoura.userdetails.repo.UserRepository;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    /**
     * Method under test: {@link UserServiceImpl#addUser(UserDetails)}
     */
    @Test
    void testAddUser() throws UserNameAlreadyExist {
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
        when(userRepository.save((UserDetails) any())).thenReturn(userDetails);

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
        assertSame(userDetails, userServiceImpl.addUser(userDetails1));
        verify(userRepository).save((UserDetails) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#getSpecificUser(int)}
     */
    @Test
    void testGetSpecificUser() throws UserNotFound {
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
        Optional<UserDetails> ofResult = Optional.of(userDetails);
        when(userRepository.findById((Integer) any())).thenReturn(ofResult);
        assertSame(userDetails, userServiceImpl.getSpecificUser(123));
        verify(userRepository, atLeast(1)).findById((Integer) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#getSpecificUser(int)}
     */
    @Test
    void testGetSpecificUser2() throws UserNotFound {
        when(userRepository.findById((Integer) any())).thenReturn(Optional.empty());
        assertThrows(UserNotFound.class, () -> userServiceImpl.getSpecificUser(123));
        verify(userRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#updateUser(int, UserDetails)}
     */
    @Test
    void testUpdateUser() {
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
        Optional<UserDetails> ofResult = Optional.of(userDetails);

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
        when(userRepository.save((UserDetails) any())).thenReturn(userDetails1);
        when(userRepository.findById((Integer) any())).thenReturn(ofResult);

        Address address2 = new Address();
        address2.setAddId(123);
        address2.setCity("Oxford");
        address2.setStreet("Street");

        Company company2 = new Company();
        company2.setCId(123);
        company2.setLocation("Location");
        company2.setName("Name");

        Geo geo2 = new Geo();
        geo2.setGepId(123);
        geo2.setLatitude("Latitude");
        geo2.setLongitude("Longitude");

        UserDetails userDetails2 = new UserDetails();
        userDetails2.setAddress(address2);
        userDetails2.setCompany(company2);
        userDetails2.setEmail("jane.doe@example.org");
        userDetails2.setGeo(geo2);
        userDetails2.setName("Name");
        userDetails2.setPhone("4105551212");
        userDetails2.setUserId(123);
        userDetails2.setUserName("janedoe");
        assertNull(userServiceImpl.updateUser(123, userDetails2));
        verify(userRepository).save((UserDetails) any());
        verify(userRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#updateUser(int, UserDetails)}
     */
    @Test
    void testUpdateUser2() {
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
        when(userRepository.save((UserDetails) any())).thenReturn(userDetails);
        when(userRepository.findById((Integer) any())).thenReturn(Optional.empty());

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
        assertNull(userServiceImpl.updateUser(123, userDetails1));
        verify(userRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#DeleteUser(int)}
     */
    @Test
    void testDeleteUser() throws UserNotFound {
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
        Optional<UserDetails> ofResult = Optional.of(userDetails);
        doNothing().when(userRepository).deleteById((Integer) any());
        when(userRepository.findById((Integer) any())).thenReturn(ofResult);
        assertEquals("User Delete Successfully..", userServiceImpl.DeleteUser(123));
        verify(userRepository).findById((Integer) any());
        verify(userRepository).deleteById((Integer) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#DeleteUser(int)}
     */
    @Test
    void testDeleteUser2() throws UserNotFound {
        doNothing().when(userRepository).deleteById((Integer) any());
        when(userRepository.findById((Integer) any())).thenReturn(Optional.empty());
        assertThrows(UserNotFound.class, () -> userServiceImpl.DeleteUser(123));
        verify(userRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#getAllUser()}
     */
    @Test
    void testGetAllUser() {
        ArrayList<UserDetails> userDetailsList = new ArrayList<>();
        when(userRepository.findAll()).thenReturn(userDetailsList);
        List<UserDetails> actualAllUser = userServiceImpl.getAllUser();
        assertSame(userDetailsList, actualAllUser);
        assertTrue(actualAllUser.isEmpty());
        verify(userRepository).findAll();
    }
}

