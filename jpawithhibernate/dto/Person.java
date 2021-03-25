package com.tyss.jpawithhibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "person_info")
public class Person {
	@Id
	@Column
	private int pid;
	@Column
	private String pname;
	@Column
	private int psal;

	/**
	 * @return the pid
	 */
	public int getPid() {
		return pid;
	}

	/**
	 * @param pid the pid to set
	 */
	public void setPid(int pid) {
		this.pid = pid;
	}

	/**
	 * @return the pname
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * @param pname the pname to set
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}

	/**
	 * @return the psal
	 */
	public int getPsal() {
		return psal;
	}

	/**
	 * @param psal the psal to set
	 */
	public void setPsal(int psal) {
		this.psal = psal;
	}

}
