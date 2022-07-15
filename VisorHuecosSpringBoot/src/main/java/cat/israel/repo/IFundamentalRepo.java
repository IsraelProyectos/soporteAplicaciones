package cat.israel.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cat.israel.model.Fundamental;

@Repository
@Transactional
public interface IFundamentalRepo extends JpaRepository<Fundamental, Integer> {
	

	
	@Query(nativeQuery = true, value="SELECT cddescriptor, fechainicio, count(*) cdperiodo FROM US_FUN.V_FUNDAMENTAL_LASTVERSION "
			+ "WHERE FECHAINICIO BETWEEN TRUNC(SYSDATE -31) "
			+ "AND TRUNC(SYSDATE-1) AND CDDESCRIPTOR in ?1 "
			+ "group by fechainicio, cddescriptor "
			+ "order by cddescriptor ")
	List<Fundamental> findByCountFunda(List<String> descriptores);
}
