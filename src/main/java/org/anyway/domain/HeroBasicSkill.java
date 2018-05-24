package org.anyway.domain;

import java.io.Serializable;

import org.anyway.infrastructure.dto.Assistant;
/*
 ** note:H represents hero , means domain
 *			A represents assistant, means Dto*/
public interface HeroBasicSkill<H> extends Serializable {
	/*
	 ** note: store self into JpaRepository, like Data Access Object save T ,means enrich the repository;
	 **/
	enum RepoType{
		JPA, REDIS, MONGODB;
	}
	
	H enrichRepo(RepoType repoType);
	/*
	 ** note: publish_consume mode , observer mode*/
	
	H noticeOthers();
	
	H acceptDataFrom(Assistant<H> a);

}
