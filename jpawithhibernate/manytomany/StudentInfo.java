package com.tyss.jpawithhibernate.manytomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "st_infos")
public class StudentInfo {
	@Id
	@Column
	private int s_id;
	@Column
	private String s_name;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "stinfo_courses", joinColumns = @JoinColumn(name = "s_id"), inverseJoinColumns = @JoinColumn(name = "c_id"))
	private List<CoursesInfo> courses;

}
