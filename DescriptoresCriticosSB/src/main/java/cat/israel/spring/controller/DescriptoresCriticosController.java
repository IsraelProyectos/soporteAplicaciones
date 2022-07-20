package cat.israel.spring.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import cat.israel.spring.servicios.AgregarBorrarDescriptor;
import cat.israel.spring.servicios.LlenarTXT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import cat.israel.spring.configuracion.ConfiguradorPropiedades;
import cat.israel.spring.model.CriticosCotiz;
import cat.israel.spring.model.CriticosFundamenta;
import cat.israel.spring.repo.ICriticosCotizRepo;
import cat.israel.spring.repo.ICriticosFundamentaRepo;

@Controller
public class DescriptoresCriticosController {

	@Autowired()
	private ICriticosFundamentaRepo fundamentaRepo;
	
	@Autowired
	private ICriticosCotizRepo cotizRepo;
	
	/*
	 * @Autowired private ConfiguradorPropiedades cp;
	 */

	@RequestMapping(value="/listar", method = RequestMethod.POST)
	public String listarDescriptores(@RequestParam("esquema") String tabla, Model model) {

		switch (tabla) {
		case "funda":
			//TODO viene nulo el configurador de propiedades
			final ConfiguradorPropiedades cp = new ConfiguradorPropiedades();
			System.out.println(cp.getDescriptoresFundaD1()+" "+cp.getDescriptoresFundaD2());
			List<CriticosFundamenta> datosBBDDfunda = fundamentaRepo.findByCountFunda(cp.getDescriptoresFundaD1(),cp.getDescriptoresFundaD2());
			LlenarTXT lTXT = new LlenarTXT();
			lTXT.llenarTXTfunda(datosBBDDfunda);
			model.addAttribute("txt", lTXT.mostrarTXT());
			model.addAttribute("mostrar", "1");
			model.addAttribute("basededatos", 1);
			model.addAttribute("descriptores", datosBBDDfunda);
			break;
		case "cotiz":
			final ConfiguradorPropiedades cp2 = new ConfiguradorPropiedades();
			List<CriticosCotiz> datosBBDDcotiz = cotizRepo.findByCountCotiz(cp2.getDescriptoresCotizDmenos1Laborables(), 
														                    cp2.getDescriptoresCotizDmenos1Diarios(), 
														                    cp2.getDescriptoresCotizDDiarios(), 
														                    cp2.getDescriptoresCotizDmenos2Diarios(), 
														                    cp2.getDescriptoresCotizMensual());

			LlenarTXT lTXT2 = new LlenarTXT();
			lTXT2.llenarTXTcotiz(datosBBDDcotiz);
			model.addAttribute("txt", lTXT2.mostrarTXT());
			model.addAttribute("mostrar", "1");
			model.addAttribute("basededatos", 2);
			model.addAttribute("descriptores", datosBBDDcotiz);
			break;
		default:
			break;
		}
		return "index";

	}
	
	@RequestMapping(value="/anadir_borrar_descriptor", method = RequestMethod.POST)
	public String ABdescri(@RequestParam("descriptor") String descriptor, @RequestParam(name="diaCarga", required = false, defaultValue = "vacio") String diaCarga, @RequestParam("accion") String tipoAccion, Model model) throws StreamReadException, DatabindException, IOException {
		AgregarBorrarDescriptor aab = new AgregarBorrarDescriptor();
		switch (tipoAccion) {
		case "guardar":
			final ConfiguradorPropiedades cp = new ConfiguradorPropiedades();
			String mensaje = null;
			ObjectMapper objectMapper = new YAMLMapper();
			
			Map<String, Object> user = objectMapper.readValue(new File("yaml/application.yaml"),
		            new TypeReference<Map<String, Object>>() { });
			@SuppressWarnings("unchecked") Map<String, Object> des = (Map<String, Object>) user.get("datos");
			String datosArray = cp.getDescriptoresCotizDmenos2Diarios().toString();
			des.put("descriptoresCotizDmenos2Diarios", datosArray.substring(1, datosArray.length() - 1)+","+descriptor);

			
			System.out.println(user);
			objectMapper.writeValue(new File("yaml/application.yaml"), user);
			break;
		case "borrar":
			model.addAttribute("mensajeGuardarBorrar", aab.borrar(descriptor, diaCarga));
			break;
		default:
			break;
		}
		model.addAttribute("primeraCargaPagina", true);
		return "index";
	}
	
	@RequestMapping(value="/borrarVariables")
	public String borrarVar(Model model) {
		model.addAttribute("mensajeIntroduccion", "");
		return "index";
	}
}
