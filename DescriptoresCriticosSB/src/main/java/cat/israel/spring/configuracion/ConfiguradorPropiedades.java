package cat.israel.spring.configuracion;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix="datos")
public class ConfiguradorPropiedades {
	
	private List<String> descriptoresFundaD1;
	private List<String> descriptoresFundaD2;
	private List<String> descriptoresCotizDDiarios;
	private List<String> descriptoresCotizDmenos1Laborables;
	private List<String> descriptoresCotizDmenos1Diarios;
	private List<String> descriptoresCotizDmenos2Diarios;
	private List<String> descriptoresCotizMensual;
	
	public List<String> getDescriptoresFundaD1() {
		return descriptoresFundaD1;
	}
	public void setDescriptoresFundaD1(List<String> descriptoresFundaD1) {
		this.descriptoresFundaD1 = descriptoresFundaD1;
	}
	public List<String> getDescriptoresFundaD2() {
		return descriptoresFundaD2;
	}
	public void setDescriptoresFundaD2(List<String> descriptoresFundaD2) {
		this.descriptoresFundaD2 = descriptoresFundaD2;
	}
	public List<String> getDescriptoresCotizDDiarios() {
		return descriptoresCotizDDiarios;
	}
	public void setDescriptoresCotizDDiarios(List<String> descriptoresCotizDDiarios) {
		this.descriptoresCotizDDiarios = descriptoresCotizDDiarios;
	}
	public List<String> getDescriptoresCotizDmenos1Laborables() {
		return descriptoresCotizDmenos1Laborables;
	}
	public void setDescriptoresCotizDmenos1Laborables(List<String> descriptoresCotizDmenos1Laborables) {
		this.descriptoresCotizDmenos1Laborables = descriptoresCotizDmenos1Laborables;
	}
	public List<String> getDescriptoresCotizDmenos1Diarios() {
		return descriptoresCotizDmenos1Diarios;
	}
	public void setDescriptoresCotizDmenos1Diarios(List<String> descriptoresCotizDmenos1Diarios) {
		this.descriptoresCotizDmenos1Diarios = descriptoresCotizDmenos1Diarios;
	}
	public List<String> getDescriptoresCotizDmenos2Diarios() {
		return descriptoresCotizDmenos2Diarios;
	}
	public void setDescriptoresCotizDmenos2Diarios(List<String> descriptoresCotizDmenos2Diarios) {
		this.descriptoresCotizDmenos2Diarios = descriptoresCotizDmenos2Diarios;
	}
	public List<String> getDescriptoresCotizMensual() {
		return descriptoresCotizMensual;
	}
	public void setDescriptoresCotizMensual(List<String> descriptoresCotizMensual) {
		this.descriptoresCotizMensual = descriptoresCotizMensual;
	}
	
	
}

