package cat.israel.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cat.israel.configuraciones.ConfiguradorPropiedades;
import cat.israel.model.Cotiz;
import cat.israel.model.Fundamental;
import cat.israel.repo.ICotizRepo;
import cat.israel.repo.IFundamentalRepo;
import cat.israel.servicios.VisorHuecosServicio;

@Controller
@RequestMapping("/user")
public class FundController {
	
	@Autowired
	private IFundamentalRepo fundamentalRepo;
	
	@Autowired
	private ICotizRepo cotizRepo;
	
	@Autowired
	private ConfiguradorPropiedades configuradorPropiedades;
	
	
	

	@RequestMapping("/listar")
	public String index(@RequestParam("esquema") String tabla, Model model) throws ParseException, IOException {

		//Aqui miramos cual de los botones ha sido clicado, en el parametro de numero
		switch (tabla) {
		case "funda":
			Map<Integer, Integer> periodosCorrectosFunda = configuradorPropiedades.getPeriodosCorrectosFunda();
			List<Fundamental> datosBBDDfunda = fundamentalRepo.findByCountFunda(configuradorPropiedades.getDescriptoresFunda());
			VisorHuecosServicio visorHuecosServicioFunda = new VisorHuecosServicio();
			TreeMap<Integer, HashMap<LocalDate, HashMap<Integer, String>>> mapaFinalFunda = visorHuecosServicioFunda.gestionHuecosFunda(datosBBDDfunda, periodosCorrectosFunda);
			model.addAttribute("descriptores", mapaFinalFunda);
			model.addAttribute("esquema", "HUECOS DE FUNDAMENTA");
			model.addAttribute("columnas", cabecera());
			model.addAttribute("mostrarDatos", 1);
			break;
		case "cotiz":
			Map<Integer, Integer> periodosCorrectosCotiz = configuradorPropiedades.getPeriodosCorrectosCotiz();
			List<Cotiz> datosBBDDcotiz = cotizRepo.findByCountCotiz(configuradorPropiedades.getDescriptoresCotiz());
			VisorHuecosServicio visorHuecosServicioCotiz = new VisorHuecosServicio();
			TreeMap<Integer, HashMap<LocalDate, HashMap<Integer, String>>> mapaFinalCotiz = visorHuecosServicioCotiz.gestionHuecosCotiz(datosBBDDcotiz, periodosCorrectosCotiz);
			model.addAttribute("descriptores", mapaFinalCotiz);
			model.addAttribute("esquema", "HUECOS DE COTIZACIONES");
			model.addAttribute("columnas", cabecera());
			model.addAttribute("mostrarDatos", 1);
			break;
		default:
			break;
		}
		
		return "index";
		
	}
	
	private ArrayList<LocalDate> cabecera(){
		LocalDate fechaInicio = LocalDate.now();
		LocalDate fechaFinal = fechaInicio.plusDays(-31);
		ArrayList<LocalDate> columnasDias = new ArrayList<LocalDate>();
		for (int i = 0; i < 31; i++) {
			columnasDias.add(fechaFinal.plusDays(i));
		}
		return columnasDias;
	}
}
