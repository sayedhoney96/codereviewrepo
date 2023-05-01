package com.memberdetails.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.memberdetails.entity.Member;

public interface Memberrepo extends JpaRepository<Member, Integer> {

}
