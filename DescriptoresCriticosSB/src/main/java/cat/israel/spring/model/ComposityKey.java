package cat.israel.spring.model;

import java.io.Serializable;
import java.sql.Date;

public class ComposityKey implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cddescriptor;
    private Date fechaInicio;
    
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
    
    
}
