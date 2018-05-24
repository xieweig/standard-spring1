package org.anyway.tails;

import org.anyway.domain.TrainingMember;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
@Service
public class SpringMemberListener {
	
	@EventListener()
	@Async
	public void continues(TrainingMember trainingMember) {
		System.out.println("======="+Thread.currentThread().getName());
		System.out.println(trainingMember);

	}

}
