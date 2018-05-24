package org.anyway.manager;

import javax.annotation.Resource;

import org.anyway.domain.HeroBasicSkill.RepoType;
import org.anyway.domain.TrainingMember;
import org.anyway.domain.behaviour.Sealer;
import org.anyway.infrastructure.dto.TrainingMemberDto;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class MemberManager extends CommandManager<TrainingMember>{
	@Resource
	private ApplicationContext context;
	@Resource
	private Sealer<TrainingMember> usefulSealer;
	@Resource
	private Sealer<TrainingMember> unusefulSealer;
	
	/*
	 ** note: Core Method */
	protected TrainingMember normalSave(TrainingMemberDto dto, Sealer<TrainingMember> sealer) {
		
		return context.getBean(dto.getHeroClass())
								.acceptDataFrom(dto)
								.statesTransition(sealer)
								.enrichRepo(RepoType.REDIS)
								.noticeOthers();
	}
	public TrainingMember LucySave(TrainingMemberDto dto) {
		
		return this.normalSave(dto, usefulSealer);
	}
	public TrainingMember LucySave2(TrainingMemberDto dto) {
		
		return this.staticModelSave(dto, usefulSealer);
	}
	public TrainingMember LilySave(TrainingMemberDto dto) {
		
		return this.normalSave(dto, unusefulSealer);
	}

}
