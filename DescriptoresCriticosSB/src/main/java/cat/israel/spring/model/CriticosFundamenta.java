package cat.israel.spring.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;


@Entity
@IdClass(ComposityKey.class)
public class CriticosFundamenta {
	
	@Id
	private int cddescriptor;
	
	@Id
	@Column (name="fechainicio")
	private Date fechaInicio;

	@Column (name="NOMPAIS")
	private String nomPais;
	
	@Column (name="NOMORIGEN")
	private String nomOrigen;
	
	@Column (name="DIA")
	private String dia;
	
	@Column (name="CARGA_DEL_DESCRIPTOR")
	private String cargaDescriptor;

	public int getCddescriptor() {
		return cddescriptor;
	}

	public void setCddescriptor(int cddescriptor) {
		this.cddescriptor = cddescriptor;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getNomPais() {
		return nomPais;
	}

	public void setNomPais(String nomPais) {
		this.nomPais = nomPais;
	}

	public String getNomOrigen() {
		return nomOrigen;
	}

	public void setNomOrigen(String nomOrigen) {
		this.nomOrigen = nomOrigen;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getCargaDescriptor() {
		return cargaDescriptor;
	}

	public void setCargaDescriptor(String cargaDescriptor) {
		this.cargaDescriptor = cargaDescriptor;
	}
	
	
}
