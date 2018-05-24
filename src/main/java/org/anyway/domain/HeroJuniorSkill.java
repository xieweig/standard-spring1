package org.anyway.domain;

import org.anyway.domain.behaviour.Sealer;

public interface HeroJuniorSkill<H> extends HeroBasicSkill<H> {
		
		/**
		 ** note: for dynamic entity ,there must be some Enumerate properties to transition states
		 * */
		H statesTransition(Sealer<H> sealer);

}
