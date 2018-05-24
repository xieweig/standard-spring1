package org.anyway.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MultiMedia {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(unique =true, updatable=false)
	private String mediaCode;
	
//	private String memberCode;
	//todo
	private String description;
	@Column
	private String path;
	
	private LocalDate uploadDate;
	/*
	@ManyToOne()
	@JoinColumn(name="memberCode")
	private TrainingMember trainingMember;
*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public LocalDate getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(LocalDate uploadDate) {
		this.uploadDate = uploadDate;
	}
	
	public String getMediaCode() {
		return mediaCode;
	}

	public void setMediaCode(String mediaCode) {
		this.mediaCode = mediaCode;
	}
/*
	public TrainingMember getTrainingMember() {
		return trainingMember;
	}

	public void setTrainingMember(TrainingMember trainingMember) {
		this.trainingMember = trainingMember;
	}
*/
	@Override
	public String toString() {
		return "MultiMedia [id=" + id + ", mediaCode=" + mediaCode + ", description=" + description + ", path=" + path
				+ ", uploadDate=" + uploadDate + ", trainingMember="  + "]";
	}


	
	
	
}
