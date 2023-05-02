package com.memberdetails.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.memberdetails.Service.MemberService;
import com.memberdetails.entity.Member;

@RestController
@RequestMapping("/api/members")
public class MemberController {
	
	@Autowired
	private MemberService memberservice;

	//build creating member rest api
	
	
	

	@PostMapping("/members")
	public ResponseEntity<Member> savemember(@RequestBody Member member){
		return new ResponseEntity<Member>(memberservice.savemember(member), HttpStatus.CREATED);
	}
	
	//build get all members
	
	@GetMapping("/members")
	public List<Member> getallmember(){
		return memberservice.getallmember();
		
	}
	
	//getmember by id api
	@GetMapping("{id}")
	public ResponseEntity<Member> getmemberbyid(@PathVariable("id") int id){
		return new  ResponseEntity<Member>(memberservice.getmemberbyid(id), HttpStatus.OK);
		
		
	}
	
//update member
	
	@PutMapping("/{id}")
	public ResponseEntity<Member> updatemember(@PathVariable("id") int id  ,@RequestBody Member member){
		//json into jAVA object
		return new ResponseEntity<Member>(memberservice.updatemember(member, id),HttpStatus.OK);
		
		
		
	}
	
	//delete
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletemember(@PathVariable("id") int id){
		memberservice.deletemember(id);
		return new ResponseEntity<String>("member deleted succesfully",HttpStatus.OK);
	}
	
	   
}
