package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.UserProfile;

@RestController
public class UserProfileController {
	private Map<String, UserProfile> userMap;
	
	@PostConstruct
	public void init() {
		userMap = new HashMap<String, UserProfile>();
		userMap.put("1", new UserProfile("1", "홍길동", "111-1111", "서울시 강남구 대치1동"));
		userMap.put("2", new UserProfile("2", "홍길자", "111-1112", "서울시 강남구 대치2동"));
		userMap.put("3", new UserProfile("3", "홍길순", "111-1113", "서울시 강남구 대치3동"));
	}
	
	// id를 인자로 받아서 해당 유저 프로필의 정보를 json형태로 전달하는 API
	
	@GetMapping("/user/{id}")
	public UserProfile getUserProfile(@PathVariable("id") String id) {
		return userMap.get(id);		// UserProfile 객체를 리턴 (json형태로 자동 매핑)
		
	}
	@GetMapping("/user/all")
	public List<UserProfile> getUserProfileList() {
		return new ArrayList<UserProfile>(userMap.values());
	}
}
