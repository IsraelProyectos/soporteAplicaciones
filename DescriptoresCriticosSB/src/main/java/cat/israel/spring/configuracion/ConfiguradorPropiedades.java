package cat.israel.spring.configuracion;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@ConfigurationProperties
@Component
@PropertySource(value= {"file:/C://Users/israe/Desktop/descriptores.properties"})
@RefreshScope
public class ConfiguradorPropiedades {
	
	private List<Integer> FUNDAMENTA_D_1;
	private List<Integer> FUNDAMENTA_D_2;
	private List<Integer> COTIZ_D_MAS_1_DIARIOS;
	private List<Integer> COTIZ_D_MENOS_1_LABORABLES;
	private List<Integer> COTIZ_D_MENOS_1_DIARIOS;
	private List<Integer> COTIZ_D_MENOS_2_DIARIOS;
	private List<Integer> COTIZ_MENSUAL;
	
	public List<Integer> getFUNDAMENTA_D_1() {
		return FUNDAMENTA_D_1;
	}
	public void setFUNDAMENTA_D_1(List<Integer> fUNDAMENTA_D_1) {
		FUNDAMENTA_D_1 = fUNDAMENTA_D_1;
	}
	public List<Integer> getFUNDAMENTA_D_2() {
		return FUNDAMENTA_D_2;
	}
	public void setFUNDAMENTA_D_2(List<Integer> fUNDAMENTA_D_2) {
		FUNDAMENTA_D_2 = fUNDAMENTA_D_2;
	}
	public List<Integer> getCOTIZ_D_MAS_1_DIARIOS() {
		return COTIZ_D_MAS_1_DIARIOS;
	}
	public void setCOTIZ_D_MAS_1_DIARIOS(List<Integer> cOTIZ_D_MAS_1_DIARIOS) {
		COTIZ_D_MAS_1_DIARIOS = cOTIZ_D_MAS_1_DIARIOS;
	}
	public List<Integer> getCOTIZ_D_MENOS_1_LABORABLES() {
		return COTIZ_D_MENOS_1_LABORABLES;
	}
	public void setCOTIZ_D_MENOS_1_LABORABLES(List<Integer> cOTIZ_D_MENOS_1_LABORABLES) {
		COTIZ_D_MENOS_1_LABORABLES = cOTIZ_D_MENOS_1_LABORABLES;
	}
	public List<Integer> getCOTIZ_D_MENOS_1_DIARIOS() {
		return COTIZ_D_MENOS_1_DIARIOS;
	}
	public void setCOTIZ_D_MENOS_1_DIARIOS(List<Integer> cOTIZ_D_MENOS_1_DIARIOS) {
		COTIZ_D_MENOS_1_DIARIOS = cOTIZ_D_MENOS_1_DIARIOS;
	}
	public List<Integer> getCOTIZ_D_MENOS_2_DIARIOS() {
		return COTIZ_D_MENOS_2_DIARIOS;
	}
	public void setCOTIZ_D_MENOS_2_DIARIOS(List<Integer> cOTIZ_D_MENOS_2_DIARIOS) {
		COTIZ_D_MENOS_2_DIARIOS = cOTIZ_D_MENOS_2_DIARIOS;
	}
	public List<Integer> getCOTIZ_MENSUAL() {
		return COTIZ_MENSUAL;
	}
	public void setCOTIZ_MENSUAL(List<Integer> cOTIZ_MENSUAL) {
		COTIZ_MENSUAL = cOTIZ_MENSUAL;
	}
	
	
}

