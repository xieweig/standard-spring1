package org.anyway.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.anyway.infrastructure.enmus.TrainingGrade;
import org.anyway.infrastructure.enmus.TrainingSubject;

/*
 ** note:训练班级的信息 与member基本的 一对多 双向关联 多方维护*/
@Entity
public class TrainingClass {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(updatable=false, unique=true, nullable=false)
	private String classCode;
	
	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	private String className;
	
	private TrainingGrade trainingGrade;
	
	private TrainingSubject trainingSubject;
	/*
	 ** note:生命周期暂时先用一个boolean，正规要用enum*/
	private Boolean frozen;
	
	private String remark;
	@OneToMany(mappedBy="trainingClass",cascade = CascadeType.ALL)
	private List<TrainingMember> trainingMembers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public TrainingGrade getTrainingGrade() {
		return trainingGrade;
	}

	public void setTrainingGrade(TrainingGrade trainingGrade) {
		this.trainingGrade = trainingGrade;
	}

	public TrainingSubject getTrainingSubject() {
		return trainingSubject;
	}

	public void setTrainingSubject(TrainingSubject trainingSubject) {
		this.trainingSubject = trainingSubject;
	}

	public Boolean getFrozen() {
		return frozen;
	}

	public void setFrozen(Boolean frozen) {
		this.frozen = frozen;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<TrainingMember> getTrainingMembers() {
		return trainingMembers;
	}

	public void setTrainingMembers(List<TrainingMember> trainingMembers) {
		this.trainingMembers = trainingMembers;
	}

	@Override
	public String toString() {
		return "TrainingClass [id=" + id + ", classCode=" + classCode + ", className=" + className + ", trainingGrade="
				+ trainingGrade + ", trainingSubject=" + trainingSubject + ", frozen=" + frozen + ", remark=" + remark
				+ "]";
	}


	
	
	

}
