package cat.israel.spring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cat.israel.spring.model.CriticosFundamenta;





@Repository
@Transactional
public interface ICriticosFundamentaRepo extends JpaRepository<CriticosFundamenta, Integer>{
	
	@Query(nativeQuery = true, value = "SELECT CDDESCRIPTOR, "
			+ "       FECHAINICIO, "
			+ "       NOMPAIS, "
			+ "       NOMORIGEN, "
			+ "       'D - 1' DIA, "
			+ "       '-' CARGA_DEL_DESCRIPTOR "
			+ "  FROM (  SELECT FUN.CDDESCRIPTOR, "
			+ "                 MAX (FUN.FECHAINICIO) AS FECHAINICIO,"
			+ "                 PA.NOMPAIS, "
			+ "                 ORI.NOMORIGEN "
			+ "            FROM US_FUN.FUNDAMENTAL FUN, "
			+ "                 US_FUN.DESCRIPTOR DES, "
			+ "                 US_FUN.PAIS       PA, "
			+ "                 US_FUN.ORIGEN     ORI "
			+ "           WHERE     FUN.CDDESCRIPTOR IN ?1 "
			+ "                 AND FUN.CDDESCRIPTOR = DES.CDDESCRIPTOR "
			+ "                 AND DES.CDPAIS = PA.CDPAIS "
			+ "                 AND DES.CDORIGEN = ORI.CDORIGEN "
			+ "        GROUP BY FUN.CDDESCRIPTOR, PA.NOMPAIS, ORI.NOMORIGEN) "
			+ "WHERE FECHAINICIO < "
			+ "       (CASE\r\n"
			+ "            WHEN TO_CHAR (TO_DATE (TRUNC (SYSDATE)), 'D') IN ('1') "
			+ "            THEN "
			+ "                TRUNC (SYSDATE - 3) "
			+ "            ELSE "
			+ "                TRUNC (SYSDATE - 1) "
			+ "        END) "
			+ "UNION ALL "
			+ "SELECT CDDESCRIPTOR, "
			+ "       FECHAINICIO, "
			+ "       NOMPAIS, "
			+ "       NOMORIGEN, "
			+ "       'D - 2' DIA, "
			+ "       '-' CARGA_DEL_DESCRIPTOR "
			+ "  FROM (  SELECT FUN.CDDESCRIPTOR, "
			+ "                 MAX (FUN.FECHAINICIO) AS FECHAINICIO, "
			+ "                 PA.NOMPAIS, "
			+ "                 ORI.NOMORIGEN "
			+ "            FROM US_FUN.FUNDAMENTAL FUN, "
			+ "                 US_FUN.DESCRIPTOR DES, "
			+ "                 US_FUN.PAIS       PA, "
			+ "                 US_FUN.ORIGEN     ORI "
			+ "           WHERE     FUN.CDDESCRIPTOR IN ?2 "
			+ "                 AND FUN.CDDESCRIPTOR = DES.CDDESCRIPTOR "
			+ "                 AND DES.CDPAIS = PA.CDPAIS "
			+ "                 AND DES.CDORIGEN = ORI.CDORIGEN "
			+ "        GROUP BY FUN.CDDESCRIPTOR, PA.NOMPAIS, ORI.NOMORIGEN) "
			+ "WHERE FECHAINICIO < "
			+ "       (CASE "
			+ "            WHEN TO_CHAR (TO_DATE (TRUNC (SYSDATE)), 'D') IN ('1') "
			+ "            THEN\r\n"
			+ "                TRUNC (SYSDATE - 3) "
			+ "            ELSE\r\n"
			+ "                TRUNC (SYSDATE - 2) "
			+ "        END)\r\n"
			+ "ORDER BY CDDESCRIPTOR ASC ")
	List<CriticosFundamenta> findByCountFunda(List<String> funda_D_1, List<String> funda_D_2);

}
