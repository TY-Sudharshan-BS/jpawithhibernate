package com.tyss.jpawithhibernate.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString.Exclude;

@Data
@Entity
@Table(name = "person_infos")
public class Persons {
	@Id
	@Column
	private int pid;
	@Column
	private String pname;

	@Exclude 
	@javax.persistence.OneToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name = "aid")
	private Aadhar aadhar;
}
