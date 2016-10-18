package control;

import java.util.Date;

import modelo.Estudiante;
import modelo.Persona;

public class Ejercicios1 {

	public static void main(String[] args) {
		Ejercicios1 ej1 = new Ejercicios1();

		/*
		 * for (int i=0; i < 100 ; i++) ej1.lanzarDado();
		 */
		// int x = 1000;//
		// ej1.listaNPrimerosEnteros(x);
		// ej1.bucleReloj();
		// int x = 134;
		// int y = 138;

		// int resultado = ej1.sumaIntervalo(x, y);

		// System.out.println(" Suma en intervalo " + x + ", " + y + " es " +
		// resultado);
		// int z = 50;
		// ej1.fibonacci(z);
		/*
		 * int cuantasLanzadas = 500; int[] salida =
		 * ej1.lanzadas(cuantasLanzadas); ej1.mostrarLanzadas(salida,
		 * cuantasLanzadas);
		 */
		// int numero = 7771;
		// ej1.listarPrimos(100);
		// ej1.crearHebras(3);

		// crear un objeto de la clase Estudiante

		Estudiante est1 = new Estudiante("43452345L", "Carlos", 'M', new Date(), 15, "20120901");

		ej1.creaListaPersonas();
	}

	public void crearHebras(int cuantas) {
		for (int i = 0; i < cuantas; i++) {
			Thread hebra = new Hebra();
			hebra.setName("Hebra" + i);
			hebra.start();
		}
		System.out.println("creadas las hebras");

	}

	public void creaListaPersonas() {
		// crea 3 personas
		Persona p1 = new Persona("45627812K", "Carlos", 'M', new Date());
		Persona p2 = new Persona();
		p2.setNif("44321987H");
		p2.setNombre("Maria");
		p2.setSexo('F');

		Persona p3 = new Persona("41298730L", "Felipe", 'M', new Date());

		// define el array para 20 personas
		Persona[] listaPersonas = new Persona[20];

		// asigna las personas al array

		listaPersonas[0] = p1;
		listaPersonas[10] = p2;
		listaPersonas[3] = p3;

		// muestra el nombre de las 3 personas

		for (int i = 0; i < listaPersonas.length; i++) {
			try {
				// if (listaPersonas[i] != null)
				System.out.println(listaPersonas[i].getNombre());
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				System.out.println("Objeto nulo");
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
