package cat.israel.spring.controller;

import java.util.List;
import cat.israel.spring.servicios.LlenarTXT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

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
	
	@Autowired
	private ConfiguradorPropiedades cp;

	@RequestMapping(value="/listar", method = RequestMethod.POST)
	public String listarDescriptores(@RequestParam("esquema") String tabla, Model model) {

		switch (tabla) {
		case "funda":
			List<CriticosFundamenta> datosBBDDfunda = fundamentaRepo.findByCountFunda(cp.getDescriptoresFundaD1(),cp.getDescriptoresFundaD2());
			LlenarTXT lTXT = new LlenarTXT();
			lTXT.llenarTXTfunda(datosBBDDfunda);
			model.addAttribute("txt", lTXT.mostrarTXT());
			model.addAttribute("mostrar", "1");
			model.addAttribute("basededatos", 1);
			model.addAttribute("descriptores", datosBBDDfunda);
			break;
		case "cotiz":
			List<CriticosCotiz> datosBBDDcotiz = cotizRepo.findByCountCotiz(cp.getDescriptoresCotizDmenos1Laborables(), 
														                    cp.getDescriptoresCotizDmenos1Diarios(), 
														                    cp.getDescriptoresCotizDDiarios(), 
														                    cp.getDescriptoresCotizDmenos2Diarios(), 
														                    cp.getDescriptoresCotizMensual());

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
	
	@RequestMapping(value="/mostrar", method = RequestMethod.POST)
	public String mostrarTXT(Model model) {
		LlenarTXT ltxt = new LlenarTXT();
		model.addAttribute("txt", ltxt.mostrarTXT());
		return "index";
	}
	
	@RequestMapping(value="/anadir_borrar_descriptor", method = RequestMethod.POST)
	public String ABdescri(@RequestParam("descriptor") String descriptor, @RequestParam(name="diaCarga", required = false, defaultValue = "vacio") String diaCarga, Model model) {
		if (!descriptor.equals("") || diaCarga.equals("")) {
			model.addAttribute("mensajeIntroduccion", "correcto");
		} else {
			model.addAttribute("mensajeIntroduccion", "INcorrecto");
		}
		model.addAttribute("primero", true);
		return "index";
	}
	
	@RequestMapping(value="/borrarVariables")
	public String borrarVar(Model model) {
		model.addAttribute("mensajeIntroduccion", "");
		return "index";
	}
}
