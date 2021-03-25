package com.tyss.jpawithhibernate.onetomany;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;

@Data
@Entity
@Table(name = "pencils_info")
public class Pencils {
	@Id
	@Column
	private int pid;
	@Column
	private String color;

	@Exclude
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "boxid")
	private PencilBox box;
}
