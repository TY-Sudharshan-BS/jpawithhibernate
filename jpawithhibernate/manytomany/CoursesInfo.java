package com.tyss.jpawithhibernate.manytomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "c_infos")
public class CoursesInfo {
	@Id
	@Column
	private int c_id;
	@Column
	private String c_name;

}
