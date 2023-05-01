package com.memberdetails.Service;

import java.util.List;

import com.memberdetails.entity.Member;

public interface MemberService {

	
	Member savemember(Member member); 
	
     List<Member> getallmember();
     Member getmemberbyid(int id);
     
     Member updatemember(Member member,int id);
     
     void deletemember(int id);
}


