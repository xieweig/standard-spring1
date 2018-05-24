package org.anyway.infrastructure.dto;

import java.util.LinkedList;
import java.util.List;

import org.anyway.domain.MultiMedia;
import org.anyway.domain.TrainingClass;
import org.anyway.domain.TrainingMember;
import org.anyway.domain.vo.IndividualPrivacy;
import org.anyway.domain.vo.TeamRole;
import org.springframework.util.StringUtils;

import net.bytebuddy.dynamic.Nexus;

public class TrainingMemberDto implements Assistant<TrainingMember>{
	//id==null? save : update
	private Long id;
	
	private String memberCode;
	
	private IndividualPrivacy individualPrivacy;
	
	private TeamRole teamRole;
	
	private List<MultiMedia> multiMedias = new LinkedList<MultiMedia>();
	
	private TrainingClass trainingClass;
	
	
	public void validate() {
		if (id == null || id == 0 ) {
			if (!StringUtils.isEmpty(memberCode)) {
				throw new RuntimeException(this.getClass().getName());
			}
		}
		else {
		//	if (StringUtils.isEmpty(memberCode)) {
		//		throw new RuntimeException(this.getClass().getName());
		//	}
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public IndividualPrivacy getIndividualPrivacy() {
		return individualPrivacy;
	}

	public void setIndividualPrivacy(IndividualPrivacy individualPrivacy) {
		this.individualPrivacy = individualPrivacy;
	}

	public TeamRole getTeamRole() {
		return teamRole;
	}

	public void setTeamRole(TeamRole teamRole) {
		this.teamRole = teamRole;
	}


	@Override
	public Class<TrainingMember> getHeroClass() {
		// TODO Auto-generated method stub
		return TrainingMember.class;
	}

	public List<MultiMedia> getMultiMedias() {
		return multiMedias;
	}

	public void setMultiMedias(List<MultiMedia> multiMedias) {
		this.multiMedias = multiMedias;
	}

	public TrainingClass getTrainingClass() {
		return trainingClass;
	}

	public void setTrainingClass(TrainingClass trainingClass) {
		this.trainingClass = trainingClass;
	}
	
	

}
