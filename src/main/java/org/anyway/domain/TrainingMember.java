package org.anyway.domain;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.anyway.config.NullSkip;
import org.anyway.config.RandomUtil;
import org.anyway.domain.behaviour.Sealer;
import org.anyway.domain.vo.IndividualPrivacy;
import org.anyway.domain.vo.TeamRole;
import org.anyway.infrastructure.TrainingMemberRepo;
import org.anyway.infrastructure.dto.Assistant;




/*
 * 教师和学生基本信息实体
 * 
 * */
@Component
@Scope(value="prototype")
@Entity
public class TrainingMember implements HeroJuniorSkill<TrainingMember> {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	/*
	 ** note:作为业务主键 特别提供findOneByCode findAllInCodes
	 **/
	@Column(unique=true, updatable=false,nullable =false)
	private String memberCode;
	@Transient
	@Resource
	private RedisTemplate<String, TrainingMember> redisRepo;
	@Transient
	@Resource
	private ApplicationContext context;
	@Transient
	@Resource
	private TrainingMemberRepo jpaRepo;
	private static final long serialVersionUID = 1L;
	/*
	 ** note:个人隐私 包含了一些未参加本课程或培训就拥有的属性*/
	private IndividualPrivacy  individualPrivacy;
	/*
	 ** note:团队角色　包含了参加课程和培训后拥有的属性*/
	private TeamRole teamRole ;
	/*
	 ** note:多媒体信息　表关联*/

	//@OneToMany(mappedBy ="trainingMember",cascade=CascadeType.ALL)
	//oneToMany manyToOne 以中间表的形式创建关系；   麻烦在于：关系创建后要维护 ，维护权在哪一方是个问题，不然要维护两遍。物以稀为贵，原则上维护关系让贱的一方完成
	//Many方主动向One方敬酒，维护关系 使用mappedBy由One方同意并指定Many方来维护
	//@JoinColumn(name="memberCode")
	//joinColumn消除中间表 为Many方创建外键字段
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name ="memberCode",referencedColumnName="memberCode")
	private List<MultiMedia> multiMedias = new LinkedList<MultiMedia>();
	
	@ManyToOne(fetch=FetchType.LAZY,cascade =CascadeType.ALL)
	@JoinColumn(name="classCode",referencedColumnName="classCode")
	private TrainingClass trainingClass;
	/*
	 *
	 ** note:后端状态　并非前端保存　涉及到领域状态集的改变　一般用ｅｎｕｍ表示　例如单据审核状态出库状态*/
	@Column
	private LocalDateTime lastModifyTime ;
	private Boolean useful = false;
	@Transient
	@Resource
	private StringRedisTemplate stringRedisTemplate;

	@Transient
	@Resource
	private RandomUtil randomUtil;
	
	@Override
	@NullSkip("gotry")
	public TrainingMember statesTransition(Sealer<TrainingMember> sealer) {
		return sealer.seal(this);
	}
	
	@Override
	public TrainingMember enrichRepo(RepoType repoType) {
		switch (repoType) {
		case JPA:
			System.out.println(RepoType.JPA);
			return this.jpaRepo.save(this);
		case REDIS:
			System.out.println(RepoType.REDIS);
			stringRedisTemplate.opsForValue().set("hi", "good");
			System.out.println(stringRedisTemplate.opsForValue().get("hi"));
			redisRepo.opsForValue().set(this.memberCode, this);
			System.out.println("save over");
			return this;
		case MONGODB:
			return null;
		}
		return null;
	}
	@Override
	public TrainingMember noticeOthers() {
		context.publishEvent(this);
		return this;
	}
	@Override
	public TrainingMember acceptDataFrom(Assistant<TrainingMember> dto) {
		dto.validate();
		BeanUtils.copyProperties(dto, this);
		if (StringUtils.isEmpty(this.memberCode)) this.memberCode = randomUtil.randomId();
		return this;
	}
	
	public List<TrainingMember> displayAccordingTo(Specification<TrainingMember> spec) {
		return jpaRepo.findAll(spec);
	}
	public Page<TrainingMember> displayAccordingTo(Specification<TrainingMember> spec, Pageable pageable) {
		return jpaRepo.findAll(spec, pageable);
	}
	
	
	public Long getId() {
		return id;
	}
	/*
	public void setId(Long id) {
		this.id = id;
	}
	*/
	
	public String getMemberCode() {
		return memberCode;
	}

	public TrainingClass getTrainingClass() {
		return trainingClass;
	}

	public void setTrainingClass(TrainingClass trainingClass) {
		this.trainingClass = trainingClass;
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

	public LocalDateTime getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(LocalDateTime lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public Boolean getUseful() {
		return useful;
	}

	public void setUseful(Boolean useful) {
		this.useful = useful;
	}

	public TeamRole getTeamRole() {
		return teamRole;
	}

	public void setTeamRole(TeamRole teamRole) {
		this.teamRole = teamRole;
	}

	public List<MultiMedia> getMultiMedias() {
		return multiMedias;
	}

	public void setMultiMedias(List<MultiMedia> multiMedias) {
		this.multiMedias = multiMedias;
	}

	@Override
	public String toString() {
		return "TrainingMember [id=" + id + ", memberCode=" + memberCode + ", individualPrivacy=" + individualPrivacy
				+ ", teamRole=" + teamRole + ", multiMedias=" + multiMedias + ", trainingClass=" + trainingClass
				+ ", lastModifyTime=" + lastModifyTime + ", useful=" + useful + "]";
	}

	
	
	









	
	
	
	
	


	
	
}
