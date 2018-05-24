package org.anyway.domain.vo;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.anyway.infrastructure.enmus.TrainingGrade;
import org.anyway.infrastructure.enmus.TrainingRole;
@Embeddable
public class TeamRole {
	
	@Enumerated(EnumType.STRING)
	private TrainingRole trainingRole;
	
	@Enumerated(EnumType.STRING)
	private TrainingGrade trainingGrade;
	/*
	 ** note:可以补充调班 留级 等特殊信息*/
	private String remarks;
	public TrainingRole getTrainingRole() {
		return trainingRole;
	}
	public void setTrainingRole(TrainingRole trainingRole) {
		this.trainingRole = trainingRole;
	}
	public TrainingGrade getTrainingGrade() {
		return trainingGrade;
	}
	public void setTrainingGrade(TrainingGrade trainingGrade) {
		this.trainingGrade = trainingGrade;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "TeamRole [trainingRole=" + trainingRole + ", trainingGrade=" + trainingGrade + ", remarks=" + remarks
				+ "]";
	}
	
	
}
