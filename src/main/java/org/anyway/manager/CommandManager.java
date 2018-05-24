package org.anyway.manager;
/*
 ** note: 基类待继承　此处本应设置为抽象类　本人原则上不用抽象类*/

import javax.annotation.Resource;

import org.anyway.domain.HeroBasicSkill.RepoType;
import org.anyway.domain.HeroJuniorSkill;
import org.anyway.domain.behaviour.Sealer;
import org.anyway.infrastructure.dto.Assistant;
import org.springframework.context.ApplicationContext;

public class CommandManager<H extends HeroJuniorSkill<H>>{
	@Resource
	private ApplicationContext applicationContext;
	@Resource
	private Sealer<H> usefulSealer;
	@Resource
	private Sealer<H> unusefulSealer;
	/*
	 ** note:考虑到　sealer 的可变性相对强　采取了一般的策略模式　添加更改容易　只涉及到实现类和ｍａｎａｇｅｒ
	 *　而仓库一共就那么几种　采取的ｅｎｕｍ的方式　耦合度很强　调用容易而更改难
	 *	对于可变性更强的情况请直接采用ｌａｍｂｄａ表达式
	 **/
	
	protected H staticModelSave(Assistant<H> dto, Sealer<H> sealer) {

		return applicationContext.getBean(dto.getHeroClass())
							.acceptDataFrom(dto)
							.statesTransition(usefulSealer)
							.enrichRepo(RepoType.JPA)
							.noticeOthers();			
	}

}
