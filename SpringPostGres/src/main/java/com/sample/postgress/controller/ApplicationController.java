package com.sample.postgress.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.postgress.entity.Follower;
import com.sample.postgress.entity.Tweet;
import com.sample.postgress.entity.Users;
import com.sample.postgress.service.FollowerService;
import com.sample.postgress.service.TweetService;
import com.sample.postgress.service.UserService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/twitterApp")
public class ApplicationController {

    @Resource
    UserService userService;
    
    @Resource
    TweetService tweetService;
    
    @Resource
    FollowerService followerService;
    

    @PostMapping(value = "/createUser")
    public ResponseEntity<String> createUser(@RequestBody Users user) {
        userService.insertUser(user);
        
        return  new ResponseEntity<String>("Data inserted", HttpStatus.OK);
    }
    
    @PutMapping(value = "/updateUser")
    public ResponseEntity<String> updateUser(@RequestBody Users user) {
        userService.updateUser(user);
        
        return  new ResponseEntity<String>("Data updated", HttpStatus.OK);
    }
    
    @GetMapping(value = "/userList")
    public ResponseEntity<JSONObject> getAllUsers() {
    	JSONObject responseDetailsJson = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<Users> user=userService.findAll();
        
        user.forEach((temp) -> {
			jsonArray.add(temp);
		});
        
        responseDetailsJson.put("Users",jsonArray);
        
    	return  new ResponseEntity<JSONObject>(responseDetailsJson, HttpStatus.OK);

    }
    
    @PostMapping(value = "/addTweet")
    public ResponseEntity<String> addTweet(@RequestBody Tweet tw) {
        tweetService.createTweet(tw);
        
        return  new ResponseEntity<String>("Data inserted", HttpStatus.OK);
    }
    
    @PutMapping(value = "/updateTweet")
    public ResponseEntity<String> updateTweet(@RequestBody Tweet tw) {
        tweetService.updateTweet(tw);
        
        return  new ResponseEntity<String>("Data updated", HttpStatus.OK);
    }
    
    @GetMapping(value = "/allTweet")
    public ResponseEntity<JSONObject> getAllTweet() {
    	JSONObject responseDetailsJson = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<Tweet> tw=tweetService.findAll();
        
        tw.forEach((temp) -> {
			jsonArray.add(temp);
		});
        
        responseDetailsJson.put("Tweet",jsonArray);
        
    	return  new ResponseEntity<JSONObject>(responseDetailsJson, HttpStatus.OK);

    }
    
    @PostMapping(value = "/followPerson")
    public ResponseEntity<String> followPerson(@RequestBody Follower fw) {
        followerService.addFollower(fw);
        
        return  new ResponseEntity<String>("Data inserted", HttpStatus.OK);
    }

    @GetMapping(value = "/followerList/{userName}")
    public ResponseEntity<JSONObject> getFollowerList(@PathVariable String userName) {
        JSONObject responseDetailsJson = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<Follower> fw=followerService.findAll(userName);
        
        fw.forEach((temp) -> {
			System.out.println(temp);
			jsonArray.add(temp);
		});
        
        responseDetailsJson.put("Follower", jsonArray);
        
    	return  new ResponseEntity<JSONObject>(responseDetailsJson, HttpStatus.OK);

    }
    
    @GetMapping(value = "/allFollowerTweet/{userName}")
    public ResponseEntity<JSONObject> getAllFollowerTweet(@PathVariable String userName) {
    	JSONObject responseDetailsJson = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<Tweet> tw=tweetService.findAllFolllowerTweet(userName);
        
        tw.forEach((temp) -> {
			jsonArray.add(temp);
		});
        
        responseDetailsJson.put("Tweet",jsonArray);
        
    	return  new ResponseEntity<JSONObject>(responseDetailsJson, HttpStatus.OK);

    }
}
