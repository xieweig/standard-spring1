package org.anyway.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.anyway.config.RandomUtil;
import org.anyway.domain.MultiMedia;
import org.anyway.domain.TrainingClass;
import org.anyway.domain.TrainingMember;
import org.anyway.domain.vo.IndividualPrivacy;
import org.anyway.domain.vo.TeamRole;
import org.anyway.infrastructure.TrainingMemberRepo;
import org.anyway.infrastructure.dto.TrainingMemberDto;
import org.anyway.infrastructure.enmus.TrainingRole;
import org.anyway.infrastructure.enmus.TrainingSubject;
import org.anyway.manager.MemberManager;
import org.anyway.infrastructure.enmus.Sex;
import org.anyway.infrastructure.enmus.TrainingGrade;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(value="/JsonAccess", tags= "此时相望")
@RestController
public class TryMapping {
	@Resource
	private MemberManager manager;
	@Resource
	private TrainingMemberRepo repo;
	@Resource 
	private RedisTemplate<String, TrainingMember> redisRepo;
	@Resource
	private Random random;
	@Resource
	private RandomUtil randomUtil;
	@ApiOperation(value="展示首页信息", notes = "all notes")
	@RequestMapping(value ="/first", method=RequestMethod.POST)
	public TrainingMember firstApp() {
		//模拟流水线上一个叫Lucy的角色点击保存
		TrainingMemberDto member =this.born(2);
		System.out.println(member);
	TrainingMember trainingMember =  manager.LucySave2(born(2));
	System.out.println(trainingMember);
	 

	 return trainingMember;
	}
	@ApiOperation(value="展示首页信息", notes = "展示信息notes")
	@RequestMapping(value="/second",method=RequestMethod.POST)
	public List<String> secondApp(){
		
		List<String> codes = new ArrayList<>();
		repo.findAll().stream().forEach(x ->codes.add(x.getMemberCode()));
		return codes;
		
	}
	@ApiOperation("数组查询，请模拟数组输入")
	 @ApiImplicitParam(name="codes", value="codes to query", required = true,dataType="list")
	@RequestMapping(value="/third",method=RequestMethod.POST)
	public List<TrainingMember> thirdApp(@RequestBody List<String> codes){
		return repo.findByMemberCodeIn(codes);
	}
	
	
	private TrainingMemberDto born(Integer listSize) {
		TrainingMemberDto dto = new TrainingMemberDto();
		//TrainingMember trainingMember = new TrainingMember();
		IndividualPrivacy individualPrivacy = new IndividualPrivacy();
		
		individualPrivacy.setBirthday(LocalDate.now().minusYears(random.nextInt(5)+15));
		individualPrivacy.setChineseName("zhang"+random.nextInt());
		individualPrivacy.setEnglishName("Tommy"+random.nextInt(200));
		individualPrivacy.setMobilephone("13911110"+(random.nextInt(900)+100));
		individualPrivacy.setPlaceOfBirth("shandongProvince"+random.nextInt(10)+"city");
		individualPrivacy.setSex(Sex.values()[random.nextInt(Sex.values().length)]);
		individualPrivacy.setWeChatCode("weixin"+random.nextInt(1000));
		individualPrivacy.setIntrests("nongyao");
		individualPrivacy.setPlaceOfLiving("room:"+random.nextInt(800)+100);
		individualPrivacy.setQQCode("888"+(random.nextInt(8900)+1000));
		
		
		TeamRole teamRole = new TeamRole();
		teamRole.setRemarks("hello kitty");
		teamRole.setTrainingRole(TrainingRole.values()[random.nextInt(TrainingRole.values().length)]);
		teamRole.setTrainingGrade(TrainingGrade.values()[random.nextInt(TrainingGrade.values().length)]);
		
		
		dto.setTeamRole(teamRole);
		dto.setIndividualPrivacy(individualPrivacy);
		
		TrainingClass trainingClass = new TrainingClass();
		trainingClass.setClassCode("111"+randomUtil.random4Number());
		trainingClass.setClassName("class"+random.nextInt(10));
		trainingClass.setTrainingGrade(TrainingGrade.values()[random.nextInt(TrainingGrade.values().length)]);
		trainingClass.setTrainingSubject(TrainingSubject.values()[random.nextInt(TrainingSubject.values().length)]);
		trainingClass.setFrozen(false);
		trainingClass.setRemark("no_remarks");
		
		
		dto.setTrainingClass(trainingClass);
		//dto.setMemberCode();
		for (int i = 0; i < listSize; i++) {
			MultiMedia media =this.mediaBorn();
			dto.getMultiMedias().add(media);
		}
		
		return dto;
	}
	private MultiMedia mediaBorn() {
		MultiMedia media = new MultiMedia();
		
		media.setMediaCode("030"+randomUtil.random4Number());
		media.setPath("goto"+randomUtil.random4Number());
		media.setUploadDate(LocalDate.now());
		media.setDescription("no_used");
		return media;
	}
	private TrainingMemberDto modify() {
		TrainingMemberDto dto = new TrainingMemberDto();
		//TrainingMember trainingMember = new TrainingMember();
		IndividualPrivacy individualPrivacy = new IndividualPrivacy();
		
		individualPrivacy.setBirthday(LocalDate.now().minusYears(random.nextInt(5)+15));
		individualPrivacy.setChineseName("zhang"+random.nextInt());
		individualPrivacy.setEnglishName("Tommy"+random.nextInt(200));
		individualPrivacy.setMobilephone("13911110"+(random.nextInt(900)+100));
		individualPrivacy.setPlaceOfBirth("shandongProvince"+random.nextInt(10)+"city");
		individualPrivacy.setSex(Sex.values()[random.nextInt(Sex.values().length)]);
		individualPrivacy.setWeChatCode("weixin"+random.nextInt(1000));
		individualPrivacy.setIntrests("nongyao");
		individualPrivacy.setPlaceOfLiving("room:"+random.nextInt(800)+100);
		individualPrivacy.setQQCode("888"+(random.nextInt(8900)+1000));
		
		TeamRole teamRole = new TeamRole();
		teamRole.setRemarks("hello kitty");
		teamRole.setTrainingRole(TrainingRole.values()[random.nextInt(TrainingRole.values().length)]);
		teamRole.setTrainingGrade(TrainingGrade.values()[random.nextInt(TrainingGrade.values().length)]);
		
		dto.setTeamRole(teamRole);
		dto.setIndividualPrivacy(individualPrivacy);
		dto.setId(100l);
		dto.setMemberCode("1111");
		//dto.setMemberCode();
		
		return dto;
	}
}
