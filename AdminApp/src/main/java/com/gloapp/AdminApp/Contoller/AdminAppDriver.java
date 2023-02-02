package com.gloapp.AdminApp.Contoller;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gloapp.AdminApp.model.GloQuoraPost;
import com.gloapp.AdminApp.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class AdminAppDriver {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/userspost/{uid}")
    public List<GloQuoraPost> getSinglePost(@PathVariable ("uid") int id) {

        ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:9092/getallpost", List.class);
        ObjectMapper objectMapper = new ObjectMapper();
        List<GloQuoraPost> driverlocationsList = objectMapper.convertValue(response.getBody(), new TypeReference<>() { });
       List<GloQuoraPost> getSingleUserData =  driverlocationsList.stream().filter(a -> a.getUserid() == id).collect(Collectors.toList());
       return getSingleUserData;
    }


    @RequestMapping(value = "/usersallpost")
    public List<GloQuoraPost> getAllPost() {

        ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:9092/getallpost", List.class);
        ObjectMapper objectMapper = new ObjectMapper();
        List<GloQuoraPost> driverlocationsList = objectMapper.convertValue(response.getBody(), new TypeReference<>() { });
       System.out.println();
        return driverlocationsList;
    }

    @RequestMapping(value = "/postcount/{uid}")
    public Map<String ,String > postCount(@PathVariable ("uid") long id) {

        ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:9092/getallpost", List.class);
        ObjectMapper objectMapper = new ObjectMapper();
        List<GloQuoraPost> driverlocationsList = objectMapper.convertValue(response.getBody(), new TypeReference<>() { });

        Map<Integer ,Long > map = driverlocationsList.stream()
                .collect( Collectors.groupingBy(c ->c.getUserid() , Collectors.counting()));

        Map<String ,String > map1 = new HashMap<>();

        map.forEach(   (k , v ) ->{
                    if(v >= id){

                        HttpHeaders headers = new HttpHeaders();
                        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
                        HttpEntity<UserDetails> entity = new HttpEntity<UserDetails>(headers);
                        UserDetails u =  restTemplate.exchange("http://localhost:9091/getuser/"+k, HttpMethod.GET, entity, UserDetails.class).getBody();
                        map1.put("User Name : "+u.getName(), "Total Post : "+v);
                    }
                }
               );
        return map1;
    }
}
