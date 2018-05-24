package org.anyway.domain.vo;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.anyway.infrastructure.enmus.Sex;

@Embeddable
public class IndividualPrivacy {
	
	private String chineseName;
	
	private String englishName;
	
	@Enumerated(EnumType.STRING)
	private Sex sex;

	private LocalDate birthday;
	
	
	private String placeOfBirth;
	
	private String placeOfLiving;
	
	@Column(length=22)
	private String mobilephone;
		
	@Column(length=50)
	private String weChatCode;
	
	private String QQCode;
	
	private String Intrests;
	

	
	public String getChineseName() {
		return chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	public Sex getSex() {
		return sex;
	}


	public void setSex(Sex sex) {
		this.sex = sex;
	}


	public LocalDate getBirthday() {
		return birthday;
	}


	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}


	public String getPlaceOfBirth() {
		return placeOfBirth;
	}


	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}


	public String getWeChatCode() {
		return weChatCode;
	}


	public void setWeChatCode(String weChatCode) {
		this.weChatCode = weChatCode;
	}


	public String getQQCode() {
		return QQCode;
	}


	public void setQQCode(String qQCode) {
		QQCode = qQCode;
	}

	public String getPlaceOfLiving() {
		return placeOfLiving;
	}

	public void setPlaceOfLiving(String placeOfLiving) {
		this.placeOfLiving = placeOfLiving;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}
	

	public String getIntrests() {
		return Intrests;
	}

	public void setIntrests(String intrests) {
		Intrests = intrests;
	}

	@Override
	public String toString() {
		return "IndividualPrivacy [chineseName=" + chineseName + ", englishName=" + englishName + ", sex=" + sex
				+ ", birthday=" + birthday + ", placeOfBirth=" + placeOfBirth + ", placeOfLiving=" + placeOfLiving
				+ ", mobilephone=" + mobilephone + ", weChatCode=" + weChatCode + ", QQCode=" + QQCode + "]";
	}

	
	
	
	

}
