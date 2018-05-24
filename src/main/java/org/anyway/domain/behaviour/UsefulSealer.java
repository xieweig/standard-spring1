package org.anyway.domain.behaviour;

import java.time.LocalDateTime;

import org.anyway.domain.TrainingMember;
import org.springframework.stereotype.Service;
@Service
public class UsefulSealer implements Sealer<TrainingMember>{

	@Override
	public TrainingMember seal(TrainingMember trainingMember) {
		// TODO Auto-generated method stub
		if (trainingMember.getUseful() == false) {
			
			trainingMember.setUseful(true);
			trainingMember.setLastModifyTime(LocalDateTime.now());
			return trainingMember;
		}
		throw new RuntimeException(this.getClass().getName());
	}
	
	

}
