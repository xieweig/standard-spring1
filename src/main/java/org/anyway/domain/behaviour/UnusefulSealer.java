package org.anyway.domain.behaviour;

import java.time.LocalDateTime;

import org.anyway.domain.TrainingMember;
import org.springframework.stereotype.Service;

@Service
public class UnusefulSealer implements Sealer<TrainingMember> {

	@Override
	public TrainingMember seal(TrainingMember trainingMember) {
		// TODO Auto-generated method stub
		if (trainingMember.getUseful() == true) {
			
			trainingMember.setUseful(false);
			trainingMember.setLastModifyTime(LocalDateTime.now());
			return trainingMember;
		}
		else {
			throw new RuntimeException(this.getClass().getName());
		}
	}

}
