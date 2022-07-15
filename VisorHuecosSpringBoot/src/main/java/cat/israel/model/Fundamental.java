package cat.israel.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(ComposityKey.class)
public class Fundamental {

	@Id
	private int cddescriptor;
	
	@Id
	@Column (name="fechainicio")
	private Date fechaInicio;
	
	@Column(name="cdperiodo")
	private int periodosCount;

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

	public int getPeriodosCount() {
		return periodosCount;
	}

	public void setPeriodosCount(int periodosCount) {
		this.periodosCount = periodosCount;
	}

		
}
