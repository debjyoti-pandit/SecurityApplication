package com.example.security.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.beans.AdminBean;

@RestController
@RequestMapping(value="/admin", produces = "application/json")
public class AdminAPI {

	@GetMapping("/getAllAdmins")
	@ResponseBody
	public ResponseEntity<List<AdminBean>> getAllAdmins(){
		List<AdminBean> adminBeans = new ArrayList<>();
		ResponseEntity<List<AdminBean>> responseEntity = new ResponseEntity<List<AdminBean>>(adminBeans, HttpStatus.BAD_GATEWAY);
		return responseEntity;
	}
}
