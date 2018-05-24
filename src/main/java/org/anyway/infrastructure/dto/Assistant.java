package org.anyway.infrastructure.dto;

public interface Assistant<H>{
	

	
	void validate();
	/*
	 ** note: if you follow one domain has its dto, and name the dto as : domain.getClass.getName()+"Dto" 
	 *			then you can use this method to attach to its relative domain
	 **/
	
	Class<H> getHeroClass();
	

}
