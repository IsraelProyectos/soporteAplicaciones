package cat.israel.spring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cat.israel.spring.model.Usuarios;

@Repository
@Transactional
public interface IUsuarios extends JpaRepository<Usuarios, String>{
	
	@Query(nativeQuery = true, value ="SELECT NOMBRE, PASSWORD, TIPO_USUARIO_FK FROM USUARIOS "
									+ "WHERE NOMBRE = ?1 AND PASSWORD = ?2 ")
	List<Usuarios> findByUsuario(String nombre, String password);

}
