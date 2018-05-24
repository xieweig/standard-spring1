package org.anyway.domain.behaviour;



public interface Sealer<H> {
	
	public enum LifeCircle{
		ANEWBORN,ADVANCED,ABANDONED;
	}
	
	H seal(H h);

}
