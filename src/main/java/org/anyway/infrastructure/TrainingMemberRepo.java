package org.anyway.infrastructure;

import java.util.List;

import org.anyway.domain.TrainingMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface TrainingMemberRepo extends JpaRepository<TrainingMember, Long> ,JpaSpecificationExecutor<TrainingMember>{
	
	TrainingMember findByMemberCode(String memberCode);
	
	//@Query("from training_member a where a.member_code id in ?1")
			
	List<TrainingMember> findByMemberCodeIn( List<String> memberCodes);

}
