package com.memberdetails.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memberdetails.Exception.Resourcenotfoundexception;
import com.memberdetails.Repo.Memberrepo;
//import com.memberdetails.Repo.MemebrRepo;
import com.memberdetails.Service.MemberService;
import com.memberdetails.entity.Member;





@Service
public class Memberserviceimpl  implements MemberService{

	
	@Autowired
	private Memberrepo memberrepo;
	public Memberserviceimpl(Memberrepo memberrepo) {
		super();
		this.memberrepo = memberrepo;
	}

	
	
	@Override
	public Member savemember(Member member) {
		return memberrepo.save(member);
	}



	@Override
	public List<Member> getallmember() {
		return memberrepo.findAll();
	}



	@Override
	public Member getmemberbyid(int id) {
		 Optional<Member>  member = memberrepo.findById(id);
		 
		if(member.isPresent()) {
			return member.get();
		}
		else {
			throw new Resourcenotfoundexception("Member", "Id",id);
		
		}
		//by usimg lamda exp
	//return memberrepo.findById(id).orElseThrow(    ()-> new Resourcenotfoundexception("Member", "Id", id));
		
		
	}


//update
	@Override
	public Member updatemember(Member member, int id) {
		
		//we are checking id is existing in db or not
		Member existingmember=memberrepo.findById(id).orElseThrow(  ()-> new Resourcenotfoundexception("Member", "Id",id));
		existingmember.setName(member.getName());
		existingmember.setId(member.getId());
		existingmember.setKyclevel(member.getKyclevel());
		existingmember.setMobilenoverified(member.getMobilenoverified());
		existingmember.setMobileno(member.getMobileno());
		existingmember.setDate(member.getDate());
		//saving
		memberrepo.save(existingmember);
		
		return existingmember;
		
	}


//delete
	@Override
	public void deletemember(int id) {
		
		//checking member exist or not
		memberrepo.findById(id).orElseThrow(    ()->new Resourcenotfoundexception("Member", "Id", id));
		memberrepo.deleteById(id);
		
	}
	



}
