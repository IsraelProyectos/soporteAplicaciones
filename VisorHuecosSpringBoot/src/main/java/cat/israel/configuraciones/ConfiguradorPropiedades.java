package cat.israel.configuraciones;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix="datos")
public class ConfiguradorPropiedades {
	
	private List<String> descriptoresFunda;
	private Map<Integer, Integer> periodosCorrectosFunda;
	private List<String> descriptoresCotiz;
	private Map<Integer, Integer> periodosCorrectosCotiz;
	
	public List<String> getDescriptoresFunda() {
		return descriptoresFunda;
	}
	public void setDescriptoresFunda(List<String> descriptoresFunda) {
		this.descriptoresFunda = descriptoresFunda;
	}
	public Map<Integer, Integer> getPeriodosCorrectosFunda() {
		return periodosCorrectosFunda;
	}
	public void setPeriodosCorrectosFunda(Map<Integer, Integer> periodosCorrectosFunda) {
		this.periodosCorrectosFunda = periodosCorrectosFunda;
	}
	public List<String> getDescriptoresCotiz() {
		return descriptoresCotiz;
	}
	public void setDescriptoresCotiz(List<String> descriptoresCotiz) {
		this.descriptoresCotiz = descriptoresCotiz;
	}
	public Map<Integer, Integer> getPeriodosCorrectosCotiz() {
		return periodosCorrectosCotiz;
	}
	public void setPeriodosCorrectosCotiz(Map<Integer, Integer> periodosCorrectosCotiz) {
		this.periodosCorrectosCotiz = periodosCorrectosCotiz;
	}
	
	
	
	
}
