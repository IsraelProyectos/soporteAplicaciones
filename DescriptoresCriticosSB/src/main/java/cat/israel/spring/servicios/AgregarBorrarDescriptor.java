package cat.israel.spring.servicios;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class AgregarBorrarDescriptor {

	@SuppressWarnings("unchecked")
	public String guardar (String descriptor, String diaCarga) throws StreamReadException, DatabindException, IOException {
		String mensaje = null;
		ObjectMapper objectMapper = new YAMLMapper();
		
		Map<String, Object> user = objectMapper.readValue(new File("src/main/resources/application.yaml"),
	            new TypeReference<Map<String, Object>>() { });
		Map<String, Object> descriptores = (Map<String, Object>) user.get("descriptoresFundaD1");
		
		System.out.println(descriptores);
		objectMapper.writeValue(new File("user-modified.yaml"), user);
		return mensaje;
	}
	
	public String borrar (String descriptor, String diaCarga) {
		String mensaje = null;
		
		return mensaje;
	}
}
