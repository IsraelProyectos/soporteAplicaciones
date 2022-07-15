package cat.israel.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cat.israel.model.Cotiz;

@Repository
@Transactional
public interface ICotizRepo extends JpaRepository<Cotiz, Integer> {
	
	@Query(nativeQuery = true, value="SELECT cddescriptor, fecha, count(*) cdperiodo FROM US_COT.COTIZ "
			+ "WHERE FECHA BETWEEN TRUNC(SYSDATE -31) "
			+ "AND TRUNC(SYSDATE-1) AND CDDESCRIPTOR in ?1 "
			+ "group by fecha, cddescriptor "
			+ "order by cddescriptor ")
	List<Cotiz> findByCountCotiz(List<String> descriptores);
}
