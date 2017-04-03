package control;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import modelo.Estudiante;
import modelo.Intento;
import modelo.Persona;

public class Ejercicios1 {
	private Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		Ejercicios2 ej2 = new Ejercicios2();
		// ej2.insertarEnPersonas();
		// HashMap<String, Persona> hm = ej2.getmPersonas();
		// ej2.crearMapaPersonas(ej2.getPersonas());

		// System.out.println(hm.size());
		String[] ks = { "nif", "nombre", "cpostal" };
		String[] vs = { "44561239P", "Maria", "35011" };
		ArrayList<HashMap<String, String>> valorDevuelto = Ejercicios2.creaDatos(ks, vs);

		String[] ks2 = { "gc", "lte", "ftv", "tfe", "lpa", "gom", "hie" };
		// visitantes por islas/meses en un año dado, en miles
		int[][] vs2 = {
				// ene feb mar abr ......
				{ 1, 142, 151, 133, 101, 132, 152, 180, 131, 142, 131, 2 }, // gc
				{ 1, 14, 15, 13, 10, 13, 15, 18, 13, 14, 13, 2 }, // lte ..
				{ 1, 14, 15, 13, 10, 13, 15, 18, 13, 14, 13, 2 }, { 1, 14, 15, 13, 10, 13, 15, 18, 13, 14, 13, 2 },
				{ 1, 14, 15, 13, 10, 13, 15, 18, 13, 14, 13, 2 }, { 1, 14, 15, 13, 10, 13, 15, 18, 13, 14, 13, 2 },
				{ 1, 14, 15, 13, 10, 13, 15, 18, 13, 14, 13, 2 } };
		// ArrayList<HashMap<Integer, Integer>> valorDevuelto2 =
		// Ejercicios2.creaDatos2(ks2, vs2);
		// ej2.mostrarVisitantesIslaMes(valorDevuelto2);
		// int[] acumuladoIsla = ej2.getVisitantesIslaYear(valorDevuelto2);
		// int[] acumuladoMes = ej2.getVisitantesMesYear(valorDevuelto2);
		//int[] acumuladoMes = ej2.getVisitantesMesFichero("ficheros/Turistas2016.txt");
		 HashMap<String, Integer> acumuladoIsla = ej2.getVisitantesIslaFichero3("ficheros/Turistas2016.txt");

		System.exit(0);
		Ejercicios1 ej1 = new Ejercicios1();
		ej1.menu("\t MANTENIMIENTO  DE PERSONAS\n");

		System.out.println("FIN DEL PROGRAMA");
	}

	private void menu(String titulo) {
		Ejercicios2 ej2 = new Ejercicios2();
		// ej2.mediaEnterosFichero("ficheros/enteros.txt");
		// ej2.escribirLanzamientosDadoFichero(1000);
		// HashMap<String, ArrayList<Integer>> clasificacion =
		// ej2.creaClasificacion2("ficheros/partidos.txt");
		String[] equipos = { "RMA", "BCNA", "UDLP", "ALA", "RSO", "BET", "EIB", "ATM", "ATB", "SEV", "VIL", "ESP",
				"CEL", "VAL", "DEP", "MLG", "LEG", "GRA", "SPO", "OSA" };
		// ej2.creaPartidosTodos("ficheros/partidosTodos.txt", equipos);
		HashMap<String, Integer> clasificacion = ej2.creaClasificacion("ficheros/partidosTodos.txt");
		// mostrar clasificacion ordenada por puntos (valor)
		System.out.println("Antes ordenación");

		Set<String> claves = clasificacion.keySet();
		Iterator<String> iterador = claves.iterator();
		while (iterador.hasNext()) {
			String equipo = iterador.next();
			System.out.println(equipo + " : " + clasificacion.get(equipo));
		}
		System.out.println("Después de ordenación por los puntos (valor)");

		Map<String, Integer> clasificacionOrdenada = sortByValues(clasificacion);

		Set<String> claves2 = clasificacionOrdenada.keySet();
		Iterator<String> iterador2 = claves2.iterator();
		while (iterador2.hasNext()) {
			String equipo = iterador2.next();
			System.out.println(equipo + " : " + clasificacion.get(equipo));
		}

		System.exit(0);
		// ej2.insertarEnPersonas();
		for (;;) { // while(true)
			System.out.println(titulo);
			System.out.println("\t\t1. Gestión de lista");
			System.out.println("\t\t2. Gestión de mapa");

			System.out.println("\t\t0. Salir del programa");
			String tecleado = teclado.nextLine();

			try {
				int opcion = 0;
				opcion = Integer.parseInt(tecleado);
				switch (opcion) {
				case 1:
					menuList("Gestión de ArrayList");
					break;
				case 2:
					menuMap("Gestión de HashMap");
					break;
				case 0:
					return; // salida del menú
				default:
					break;
				}
			} catch (NumberFormatException e) {
				// entra por aqui si se equivoca y teclea un valor no entero
			}
		}
	}

	private static HashMap sortByValues(HashMap map) {
		List list = new LinkedList(map.entrySet());
		// Defined Custom Comparator here
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o2)).getValue()).compareTo(((Map.Entry) (o1)).getValue());
			}
		});

		// Here I am copying the sorted list in HashMap
		// using LinkedHashMap to preserve the insertion order
		HashMap sortedHashMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
		}
		return sortedHashMap;
	}

	public void menuList(String titulo) {
		Ejercicios2 ej2 = new Ejercicios2();
		ej2.insertarEnPersonas();
		for (;;) { // while(true)
			System.out.println(titulo);
			System.out.println("\t\t1. Listar todas las personas");
			System.out.println("\t\t2. Crear una persona");
			System.out.println("\t\t3. Modificar datos de una persona (NIF)");
			System.out.println("\t\t4. Eliminar una persona de la lista (ID)");
			System.out.println("\t\t5. Eliminar una persona de la lista (NIF)");
			System.out.println("\t\t0. Volver al menú anterior1");
			String tecleado = teclado.nextLine();

			try {
				int opcion = 0;
				opcion = Integer.parseInt(tecleado);
				switch (opcion) {
				case 1:
					ej2.recorrerListaPersonas2();
					// listarTodos();
					break;
				case 2:
					ej2.crearPersona();
					break;
				case 3:
					ej2.modificarPersona();
					break;
				case 4:
					ej2.borrarPersona();
					break;
				case 5:
					ej2.borrarPersonaNif();
					break;
				case 0:
					return; // salida del menú
				default:
					break;
				}
			} catch (NumberFormatException e) {
				// entra por aqui si se equivoca y teclea un valor no entero
			}
		}

	}

	public void menuMap(String titulo) {
		Ejercicios2 ej2 = new Ejercicios2();
		ej2.insertarEnMapaPersonas();

		for (;;) { // while(true)
			System.out.println(titulo);
			System.out.println("\t\t1. Listar todas las personas");
			System.out.println("\t\t2. Crear una persona");
			System.out.println("\t\t3. Modificar datos de una persona (NIF)");
			System.out.println("\t\t4. Eliminar una persona de la lista (ID)");
			System.out.println("\t\t5. Eliminar una persona de la lista (NIF)");
			System.out.println("\t\t0. Volver al menu anterior");
			String tecleado = teclado.nextLine();

			try {
				int opcion = 0;
				opcion = Integer.parseInt(tecleado);
				switch (opcion) {
				case 1:
					ej2.recorrerMapa(ej2.getmPersonas());
					break;
				case 2:
					ej2.crearPersonaEnMapa(ej2.getmPersonas());
					break;
				case 3:
					ej2.modificarPersona();
					break;
				case 4:
					ej2.borrarPersonaIdEnMapa(ej2.getmPersonas());
					break;
				case 5:
					ej2.borrarPersonaNif();
					break;
				case 0:
					return; // salida del menú
				default:
					break;
				}
			} catch (NumberFormatException e) {
				// entra por aqui si se equivoca y teclea un valor no entero
			}
		}

	}

	public void modificarPersona() {
		System.out.println("modificarPersona");
	}

	public void borrarPersona() {
		System.out.println("borrarPersona");
	}

	public int[] sumaFilasMatrizEnteros(int[][] matriz) {
		int[] resultado = new int[matriz.length];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				resultado[i] += matriz[i][j];
			}
		}
		return resultado;
	}

	public int[] sumaColumnasMatrizEnteros(int[][] matriz) {
		// calculamos el número máximo de columnas
		int numMaxColumnas = 0;
		for (int i = 0; i < matriz.length; i++) {
			if (matriz[i].length > numMaxColumnas)
				numMaxColumnas = matriz[i].length;
		}

		// recorremos la matriz por COLUMNAS.
		int[] resultado = new int[numMaxColumnas];

		for (int j = 0; j < numMaxColumnas; j++) {
			for (int i = 0; i < matriz.length; i++) {
				// try {
				if (j < matriz[i].length)
					resultado[j] += matriz[i][j];
				/*
				 * } catch (ArrayIndexOutOfBoundsException e) {
				 * 
				 * }
				 */
			}
		}
		return resultado;
	}

	public int sumaMatrizEnteros(int[][] matriz) {
		int suma = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++)
				suma += matriz[i][j];
		}
		return suma;
	}

	public int[] mezclaArrayEnteros(int[] a1, int[] a2) {

		int[] a3 = new int[a1.length + a2.length];
		int i = 0, j = 0, k = 0;
		while (k < a3.length) {
			try {
				if (a1[i] < a2[j]) {
					a3[k] = a1[i];
					i++;
				} else {
					a3[k] = a2[j];
					j++;
				}
				k++;
			} catch (ArrayIndexOutOfBoundsException excepcion) {
				if (i >= a1.length) {
					a1[a1.length - 1] = Integer.MAX_VALUE;
					i--;
				} else if (j >= a2.length) {
					a2[a2.length - 1] = Integer.MAX_VALUE;
					j--;
				}
			}
		}
		return a3;
	}

	public boolean busquedaBinaria(int buscaMe, int[] enDonde) {
		int min, max, med;
		min = 0;
		max = enDonde.length - 1;
		while (min <= max) {
			med = min + (max - min) / 2;
			if (enDonde[med] == buscaMe)
				return true;
			else if (enDonde[med] > buscaMe)
				max = med - 1;
			else
				min = med + 1;
		}
		return false;
	}

	public void ordenaListaNumeros(int[] lista) {
		for (int i = 0; i < lista.length - 1; i++) {
			for (int j = i + 1; j < lista.length; j++) {
				if (lista[i] > (lista[j])) // hay que permutar
				{
					int aux = lista[i];
					lista[i] = lista[j];
					lista[j] = aux;
				}
			}
		}
	}

	public void ordenaListaCadenas(String[] lista) {
		// public String[] ordenaListaCadenas(String[] lista) {
		for (int i = 0; i < lista.length - 1; i++) {
			for (int j = i + 1; j < lista.length; j++) {
				if (lista[i].compareTo(lista[j]) > 0) // hay que permutar
				{
					String aux = lista[i];
					lista[i] = lista[j];
					lista[j] = aux;
				}
			}
		}

		// return lista;

	}

	public int generaAleatorioEntre(int min, int max) {
		/*
		 * int numero = min; int diferencia = max -min; Random rnd = new
		 * Random(); numero += rnd.nextInt(diferencia);
		 */
		return min + new Random().nextInt(max - min);
	}

	public void adivinaNumero() {

		int[] limites = generarIntervalo(); // se piden dos numeros y se genera
		int numeroAdivinar = generaAleatorioEntre(limites[0], limites[1]); // numero
																			// //
																			// adivinar
		jugarAdivinaNumero(numeroAdivinar);
	}

	private void jugarAdivinaNumero(int numeroAdivinar) {
		int contadorIntentos = 0;
		Intento[] intentos = new Intento[200];
		boolean jugando = true;
		do { // bucle del juego

			// validamos el número jugado
			boolean error1 = true;
			int numeroJugado = 0;
			while (error1) {
				try {
					System.out.println("Teclee número entero (Q|q para terminar)");
					Scanner teclado = new Scanner(System.in);
					String numeroTecleado = teclado.nextLine();

					if (numeroTecleado.compareToIgnoreCase("Q") == 0) {
						System.out.println("Fin de la partida . Hasta la próxima!");
						System.exit(0);
					}

					numeroJugado = Integer.parseInt(numeroTecleado);
					error1 = false;
				} catch (NumberFormatException e) {
					System.out.println("Número incorrecto!");
				}
			}

			// creamos el intento
			Intento intento = new Intento(numeroJugado, new Date());
			// guardamos el intento..
			intentos[contadorIntentos++] = intento;

			// mostrar los intentos hasta ahora ....
			for (int i = 0; i < intentos.length; i++) {

				try {
					System.out.printf("%d. \t%d\t%s\n", i + 1, intentos[i].getNumero(), intentos[i].getFechaHora());
				} catch (NullPointerException e) {
					break;
				}
			}

			// tenemos un número tecleado válido
			if (numeroJugado < numeroAdivinar)
				System.out.println("Pruebe un número MAYOR... ");
			else if (numeroJugado > numeroAdivinar)
				System.out.println("Pruebe un número MENOR... ");
			else {
				System.out.println("ENHORABUENA, HA ACERTADO!!... ");
				jugando = false;
			}

		} while (jugando);

	}

	private int[] generarIntervalo() {
		System.out.println("Generacion del numero en un intervalo");
		// bucle validacion
		int min = 0;
		int max = 0;
		boolean error1 = true;
		while (error1) {
			System.out.println("Teclee intervalo (min@max)");
			Scanner teclado = new Scanner(System.in);
			String intervalo = teclado.nextLine();
			String[] limites = intervalo.split("@");
			// validamos que hay dos numeros
			if (limites.length != 2) {
				System.out.println("Teclee dos valores !");
				error1 = true;
				continue;
			}
			try {
				min = Integer.parseInt(limites[0]);
				max = Integer.parseInt(limites[1]);
				if (min >= max) {
					System.out.println("Min < Max !!");
					error1 = true;
					continue;
				}
				// validación superada
				error1 = false;
			} catch (NumberFormatException e) {
				System.out.println("Error de formato !");
				error1 = true;
				continue;
			}
		}
		// System.out.println("validación superada");
		int[] intervalo = new int[2];
		intervalo[0] = min;
		intervalo[1] = max;
		return intervalo;
	}

	public void crearHebras(int cuantas) {
		for (int i = 0; i < cuantas; i++) {
			Thread hebra = new Hebra();
			hebra.setName("Hebra" + i);
			hebra.start();
		}
		System.out.println("creadas las hebras");

	}

	public void convierteAEnteros() {
		// definimos un array de cadenas
		// String[] numeros = new String[15];
		String[] numeros = { "12t3", "650", "78m6", "1", "0987" };
	}

	public void creaListaPersonas() {
		// crea 3 personas
		Persona p1 = new Persona("45627812K", "Carlos", 'M', 19801109);
		Persona p2 = new Persona();
		p2.setNif("44321987H");
		p2.setNombre("Maria");
		p2.setSexo('F');

		Persona p3 = new Persona("41298730L", "Felipe", 'M', 19811129);

		// define el array para 20 personas
		Persona[] listaPersonas = new Persona[20];

		// asigna las personas al array

		listaPersonas[0] = p1;
		listaPersonas[10] = p2;
		listaPersonas[3] = p3;

		// muestra el nombre de las 3 personas
		for (int i = 0; i < listaPersonas.length; i++) {
			try {
				System.out.println(listaPersonas[i].getNombre());
			} catch (NullPointerException exepcion) {
				System.out.println("elemento " + i + " está null");
			} catch (Exception exepcion) {
				System.out.println("General excepcion");
			}
		}

	}

	public void listarPrimos(int cuantos) {
		// int contador = 0;
		int candidato = 1;
		// while (contador < cuantos) {
		for (int contador = 0; contador < cuantos; contador++) {
			if (esPrimo(candidato))
				System.out.println(candidato);
			candidato++;

		}

	}

	public boolean esPrimo(int numero) {
		for (int i = 2; i < numero; i++) {
			if (numero % i == 0) {
				// System.out.println(numero + " NO es primo !!" + i);

				return false;
			}

		}
		// System.out.println(numero + " es primo !!");
		return true;

	}

	public void fibonacci(int n) {
		float a, b, c;
		a = 0;
		b = 1;

		/*
		 * for (int i = 0; i < n; i++) { c=a+b; System.out.print(c + ", "); a=b;
		 * }
		 */
		int i = 0;
		while (i < n) {
			c = a + b;
			System.out.print(c + ", " + "\n");
			a = b;
			b = c;
			i++;
		}

	}

	public int sumaIntervalo(int menor, int mayor) {
		int acum = 0;
		for (int i = menor; i <= mayor; i++)
			acum += i;
		return acum;
	}

	public void mostrarLanzadas(int[] datos, int cuantasLanzadas) {
		for (int i = 0; i < datos.length; i++)
			/*
			 * System.out.println("El número " + (i + 1) + " ha salido " +
			 * datos[i] + " veces(" + ((datos[i]*100)/cuantasLanzadas) + " %)");
			 */
			System.out.printf("El numero %d aparece %d veces (%.2f)\n", (i + 1), datos[i],
					(float) (datos[i] * 100) / cuantasLanzadas);
	}

	public int[] lanzadas(int numLanzadas) {
		int[] resultado = new int[6];
		int numero;
		for (int i = 0; i < numLanzadas; i++) {
			numero = lanzarDado();
			resultado[numero - 1]++;
		}
		return resultado;
	}

	public int lanzarDado() {

		int valor = (int) (1 + Math.random() * 6);
		// System.out.println(valor);
		return valor;

	}

	public void listaNPrimerosEnteros(int n) {
		for (int i = 0; i < n; i++)
			System.out.println(i + 1);

	}

	public void bucleReloj() {
		int h = 0, m = 0, s = 0;
		while (h < 24) // bucle de horas
		{
			m = 0;
			while (m < 60) {
				s = 0;
				while (s < 60) {
					System.out.println(h + " : " + m + " : " + s);
					s++;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				m++; // m= m + 1;
			}
			h++;
		}

	}

}
