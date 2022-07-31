package cat.israel.spring.controller;

import java.io.IOException;
import java.util.List;

import cat.israel.spring.servicios.AgregarBorrarDescriptor;
import cat.israel.spring.servicios.LlenarTXT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

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
	
	@Autowired
	private AgregarBorrarDescriptor ab;
	 

	@GetMapping("/")
    public String index(Model model) throws IOException {
		LlenarTXT gestionTXT = new LlenarTXT();
		gestionTXT.reiniciarTXT();
		model.addAttribute("txt", gestionTXT.mostrarTXT());
        return "index";
    }
	
	@RequestMapping(value="/listar", method = RequestMethod.POST)
	public String listarDescriptores(@RequestParam("esquema") String tabla, Model model) throws StreamReadException, DatabindException, IOException {

		switch (tabla) {
		case "funda":
			System.out.println(cp.getFUNDAMENTA_D_2());
			
			List<CriticosFundamenta> datosBBDDfunda = fundamentaRepo.findByCountFunda(cp.getFUNDAMENTA_D_1(),cp.getFUNDAMENTA_D_2());
			LlenarTXT lTXT = new LlenarTXT();
			lTXT.llenarTXTfunda(datosBBDDfunda);
			model.addAttribute("txt", lTXT.mostrarTXT());
			model.addAttribute("mostrar", "1");
			model.addAttribute("basededatos", 1);
			model.addAttribute("descriptores", datosBBDDfunda);
			break;
		case "cotiz":
			System.out.println("descriptores d-2 cotiz: "+cp.getCOTIZ_D_MENOS_2_DIARIOS());
			
			//System.out.println(cp.getDescriptoresCotizDmenos2Diarios().substring(1, cp.getDescriptoresCotizDmenos2Diarios().size() - 1));
			List<CriticosCotiz> datosBBDDcotiz = cotizRepo.findByCountCotiz(cp.getCOTIZ_D_MENOS_1_LABORABLES(), 
														                    cp.getCOTIZ_D_MENOS_1_DIARIOS(), 
														                    cp.getCOTIZ_D_MAS_1_DIARIOS(), 
														                    cp.getCOTIZ_D_MENOS_2_DIARIOS(), 
														                    cp.getCOTIZ_MENSUAL());
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
	public String AñadirBorrarDescriptor(@RequestParam("descriptor") String descriptor, @RequestParam(name="diaCarga") String diaCarga, @RequestParam("accion") String tipoAccion, Model model) throws StreamReadException, DatabindException, IOException {
		switch (tipoAccion) {
		case "guardar":
			String [] mensajeGuardar = ab.guardar(descriptor, diaCarga, cp).split(";");
			model.addAttribute("mensajeIntroduccion", mensajeGuardar[0]);
			model.addAttribute("colorMensaje", mensajeGuardar[1]);
			break;
		case "borrar":
			String [] mensajeBorrar = ab.borrar(descriptor, diaCarga, cp).split(";");
			model.addAttribute("mensajeIntroduccion", mensajeBorrar[0]);
			model.addAttribute("colorMensaje", mensajeBorrar[1]);
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
