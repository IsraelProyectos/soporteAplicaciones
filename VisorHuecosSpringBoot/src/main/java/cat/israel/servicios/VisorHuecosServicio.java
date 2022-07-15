package cat.israel.servicios;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import cat.israel.model.Cotiz;
import cat.israel.model.Fundamental;

public class VisorHuecosServicio {

	public TreeMap<Integer, HashMap<LocalDate, HashMap<Integer, String>>> gestionHuecosFunda(List<Fundamental> datosBBDD, Map<Integer, Integer> periodosCorrectosFunda) {

		Map<Integer, HashMap<LocalDate, Integer>> mapaDatosBBDD = new HashMap<Integer, HashMap<LocalDate, Integer>>();
		HashMap<LocalDate, Integer> fechaTotalPeriodos = new HashMap<LocalDate, Integer>();

		LocalDate fechaInicio = LocalDate.now();
		LocalDate fechaFinal = fechaInicio.plusDays(-31);
		ArrayList<LocalDate> columnasDias = new ArrayList<LocalDate>();

		for (int i = 0; i < 31; i++) {
			columnasDias.add(fechaFinal.plusDays(i));
		}

		if (!datosBBDD.isEmpty()) {
			// Metemos los datos del List, que nos llega de la query que se ha ejecutado
			// contra el esquema, en un HashMap
			for (Fundamental fundamental : datosBBDD) {

				Integer key = fundamental.getCddescriptor();
				LocalDate localDate = fundamental.getFechaInicio().toLocalDate();
				if (!mapaDatosBBDD.containsKey(key)) {
					fechaTotalPeriodos = new HashMap<LocalDate, Integer>();
					fechaTotalPeriodos.put(localDate, fundamental.getPeriodosCount());
					mapaDatosBBDD.put(key, (HashMap<LocalDate, Integer>) fechaTotalPeriodos);
				} else {
					fechaTotalPeriodos.put(localDate, fundamental.getPeriodosCount());
				}
			}
		}

		//Volvemos a recorrer el HashMap creado para ver los descriptores que no han traido valores e insertarlos todos
		//con 0 periodos
		for (Map.Entry<Integer, Integer> entry : periodosCorrectosFunda.entrySet()) {

			Integer key = entry.getKey();
			if (!mapaDatosBBDD.containsKey(key)) {
				fechaTotalPeriodos = new HashMap<LocalDate, Integer>();
				for (LocalDate localDate : columnasDias) {
					fechaTotalPeriodos.put(localDate, 0);
				}
				mapaDatosBBDD.put(key, fechaTotalPeriodos);
			}
		}
		
		for (Map.Entry<Integer, HashMap<LocalDate, Integer>> entry : mapaDatosBBDD.entrySet()) {
			System.out.println("descriptor -> " + entry);

		}
		try {
			return proceso(mapaDatosBBDD, periodosCorrectosFunda);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public TreeMap<Integer, HashMap<LocalDate, HashMap<Integer, String>>> gestionHuecosCotiz(List<Cotiz> datosBBDD, Map<Integer, Integer> periodosCorrectosFunda) {

		Map<Integer, HashMap<LocalDate, Integer>> mapaDatosBBDD = new HashMap<Integer, HashMap<LocalDate, Integer>>();
		HashMap<LocalDate, Integer> fechaTotalPeriodos = new HashMap<LocalDate, Integer>();

		LocalDate fechaInicio = LocalDate.now();
		LocalDate fechaFinal = fechaInicio.plusDays(-31);
		ArrayList<LocalDate> columnasDias = new ArrayList<LocalDate>();

		for (int i = 0; i < 31; i++) {
			columnasDias.add(fechaFinal.plusDays(i));
		}

		if (!datosBBDD.isEmpty()) {
			// Metemos los datos del List, que nos llega de la query que se ha ejecutado
			// contra el esquema, en un HashMap
			for (Cotiz cotiz : datosBBDD) {

				Integer key = cotiz.getCddescriptor();
				LocalDate localDate = cotiz.getFechaInicio().toLocalDate();
				if (!mapaDatosBBDD.containsKey(key)) {
					fechaTotalPeriodos = new HashMap<LocalDate, Integer>();
					fechaTotalPeriodos.put(localDate, cotiz.getPeriodosCount());
					mapaDatosBBDD.put(key, (HashMap<LocalDate, Integer>) fechaTotalPeriodos);
				} else {
					fechaTotalPeriodos.put(localDate, cotiz.getPeriodosCount());
				}
			}
		}

		//Volvemos a recorrer el HashMap creado para ver los descriptores que no han traido valores e insertarlos todos
		//con 0 periodos
		for (Map.Entry<Integer, Integer> entry : periodosCorrectosFunda.entrySet()) {

			Integer key = entry.getKey();
			if (!mapaDatosBBDD.containsKey(key)) {
				fechaTotalPeriodos = new HashMap<LocalDate, Integer>();
				for (LocalDate localDate : columnasDias) {
					fechaTotalPeriodos.put(localDate, 0);
				}
				mapaDatosBBDD.put(key, fechaTotalPeriodos);
			}
		}
		
		for (Map.Entry<Integer, HashMap<LocalDate, Integer>> entry : mapaDatosBBDD.entrySet()) {
			System.out.println("descriptor -> " + entry);

		}
		try {
			return proceso(mapaDatosBBDD, periodosCorrectosFunda);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @param mapaDatosBBDD
	 * @param mapPeriodosNecesarios
	 * @return
	 * @throws IOException
	 */
	public TreeMap<Integer, HashMap<LocalDate, HashMap<Integer, String>>> proceso(
			Map<Integer, HashMap<LocalDate, Integer>> mapaDatosBBDD, Map<Integer, Integer> mapPeriodosNecesarios)
			throws IOException {
		// Lista de fechas a tratar
		List<LocalDate> columns = new ArrayList<LocalDate>();
		LocalDate fechaInicio = LocalDate.now();
		LocalDate fechaFinal = fechaInicio.plusDays(-31);

		for (int i = 0; i < 31; i++) {
			columns.add(fechaFinal.plusDays(i));
		}
		LocalDate z = columns.get(0);
		if (z.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
			System.out.println(z);
		}

		Map<Integer, HashMap<LocalDate, HashMap<Integer, String>>> mapaDatosFinal = new HashMap<Integer, HashMap<LocalDate, HashMap<Integer, String>>>();
		;
		Map<LocalDate, HashMap<Integer, String>> fechaPeriodosDescriptor;

		// procesamos los datos
		// 1.iterar todos los descriptores
		for (Map.Entry<Integer, Integer> entry : mapPeriodosNecesarios.entrySet()) {
			fechaPeriodosDescriptor = new HashMap<LocalDate, HashMap<Integer, String>>();
			Integer descriptor = entry.getKey();
			Integer totalPeriodos = entry.getValue();
			for (LocalDate localDate : columns) {
				Integer valorCountBBDD = 0;
				boolean hole = isHole(localDate, mapaDatosBBDD, descriptor);
				// Comprobamos que tenemos datos del descriptor en el hashmap de la query sobre
				// cotiz y/o fundamenta
				if (hole) {
					HashMap<LocalDate, Integer> a = mapaDatosBBDD.get(descriptor);
					valorCountBBDD = a.get(localDate);
				}
				if (!hole || !validarPeriodos(localDate, totalPeriodos, valorCountBBDD,
						descriptor)/* o es diferente de lo que debe */) {
					// O HAY HUECO O EL VALOR DEL PERIODO NO ES VALIDO
					putValuePeriod(mapaDatosFinal, fechaPeriodosDescriptor, descriptor, localDate, valorCountBBDD,
							"#E53131");
				} else {
					// CORRECTO
					putValuePeriod(mapaDatosFinal, fechaPeriodosDescriptor, descriptor, localDate, valorCountBBDD,
							"#DCDCDC");
				}
				// System.out.println(mapaDatosFinal);
			} // fin for int
		} // fin for ext

		TreeMap<Integer, HashMap<LocalDate, HashMap<Integer, String>>> mapaFinalOrdenado = new TreeMap<>();
		mapaFinalOrdenado.putAll(mapaDatosFinal);

		return mapaFinalOrdenado;
	}

	/**
	 * 
	 * @param mapaDatosFinal
	 * @param fechaPeriodosDescriptor
	 * @param descriptor
	 * @param localDate
	 * @param valorCountBBDD
	 * @param color
	 */
	private void putValuePeriod(Map<Integer, HashMap<LocalDate, HashMap<Integer, String>>> mapaDatosFinal,
			Map<LocalDate, HashMap<Integer, String>> fechaPeriodosDescriptor, Integer descriptor, LocalDate localDate,
			Integer valorCountBBDD, String color) {
		if (!mapaDatosFinal.containsKey(descriptor)) {
			HashMap<Integer, String> totalPeriodosColor = new HashMap<Integer, String>();
			totalPeriodosColor.put(valorCountBBDD, color);
			// Map<LocalDate, HashMap<Integer, String>> fechaPeriodosDescriptor = new
			// HashMap<LocalDate, HashMap<Integer, String>>();
			fechaPeriodosDescriptor.put(localDate, totalPeriodosColor);
			mapaDatosFinal.put(descriptor, (HashMap<LocalDate, HashMap<Integer, String>>) fechaPeriodosDescriptor);
		} else {
			HashMap<Integer, String> totalPeriodosColor = new HashMap<Integer, String>();
			totalPeriodosColor.put(valorCountBBDD, color);
			// Map<LocalDate, HashMap<Integer, String>> fechaPeriodosDescriptor = new
			// HashMap<LocalDate, HashMap<Integer, String>>();
			fechaPeriodosDescriptor.put(localDate, totalPeriodosColor);
		}
	}

	/**
	 * @param fecha
	 * @param mapaDatosBBDD
	 * @param descriptor
	 * @return
	 */
	boolean isHole(LocalDate fecha, Map<Integer, HashMap<LocalDate, Integer>> mapaDatosBBDD, Integer descriptor) {
		HashMap<LocalDate, Integer> a = mapaDatosBBDD.get(descriptor);
		boolean containsKey = a.containsKey(fecha);
		return containsKey;
	}

	/**
	 * @param fechaPeriodo
	 * @param periodoNecesario
	 * @param valorDescriptor
	 * @param descriptor
	 * @return
	 */
	boolean validarPeriodos(LocalDate fechaPeriodo, int periodoNecesario, Integer valorDescriptor, Integer descriptor) {

		if (periodoNecesario <= valorDescriptor) {
			return true;
		} else {
			return false;
		}
	}

}
