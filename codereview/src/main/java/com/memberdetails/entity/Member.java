package com.memberdetails.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Entity
@Table(name="member")
public class Member {
	
	
	public Member() {
		
	}
	
		public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKyclevel() {
		return kyclevel;
	}

	public void setKyclevel(String kyclevel) {
		this.kyclevel = kyclevel;
	}

	public int getMobileno() {
		return mobileno;
	}

	public void setMobileno(int mobileno) {
		this.mobileno = mobileno;
	}

	public String getMobilenoverified() {
		return mobilenoverified;
	}

	public void setMobilenoverified(String mobilenoverified) {
		this.mobilenoverified = mobilenoverified;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		
		@Column(name="name",length=20)
		private String name;
		
		@Column(name="kyclevel")
		private String kyclevel;
		
		@Column(name="mobileno")
		private int mobileno;
		@Column(name="mobilenoverified")
		private String mobilenoverified;
		
		@Column(name="date")
		@JsonFormat(pattern="yyyy-MM-dd",shape=Shape.STRING)
		private String date;
		

	}



