package com.mycompany.hibernate_one_to_one.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="instructor_details")
public class InstructorDetails implements Serializable {/**
	 * 
	 */
	
/**
	 * 
	 */
	private static final long serialVersionUID = 5768414818005284992L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="youtube_channel")
	private String youtubeChannel;
	
	@Column(name="hobby")
	private String hobby;
	
	@OneToOne(mappedBy="instructorDetail",cascade=CascadeType.ALL)
	private Instructor instructor;
	
	public InstructorDetails() {
		
	}

	public InstructorDetails(String youtubeChannel, String hobby) {
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}

	

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
	}
	
	
	
	

}
