
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Evaluacion_Mier {
	public static void main(String[] args) {
		Scanner dato = new Scanner(System.in);

		List<String> listaNombres = new ArrayList<>();
		List<String> listaApellido = new ArrayList<>();
		List<Integer> listaNroDeLegajo = new ArrayList<>();

		System.out.println("Cuantos datos registrara?");
		int cantidadRegistros = dato.nextInt();

		for (int i = 0; i < cantidadRegistros; i++) {
			System.out.println("Ingrese el nombre: ");
			String Nombres = dato.next();
			listaNombres.add(Nombres);
			System.out.println("Ingrese el apellido: ");
			String apellidos = dato.next();
			listaApellido.add(apellidos);
			System.out.println("Ingrese el numero de Legajo:");
			int numero = dato.nextInt();

			while (numero <= 10000 || numero > 100000) {
				System.out.println("Legajo incorrecto. Ingresalo de nuevo.");
			}
			listaNroDeLegajo.add(numero);
		}
		for (int i = 0; i < (listaNroDeLegajo.size() - 1); i++) {

			for (int j = 0; j < (listaNroDeLegajo.size() - i - 1); j++) {
				if (listaNroDeLegajo.get(j) > listaNroDeLegajo.get(j + 1)) {
					int temporalNumero = listaNroDeLegajo.get(j);
					int segundoNumero = listaNroDeLegajo.get(j + 1);
					listaNroDeLegajo.set(j, segundoNumero);
					listaNroDeLegajo.set(j + 1, temporalNumero);
					String temporalApellido = listaApellido.get(j + 1);
					String segundoApellido = listaApellido.get(j);
					listaApellido.set(j, segundoApellido);
					listaApellido.set(j + 1, temporalApellido);
					String temporalNombre = listaNombres.get(j + 1);
					String segundoNombre = listaNombres.get(j);
					listaNombres.set(j, segundoNombre);
					listaNombres.set(j + 1, temporalNombre);
				}
			}
		}
		System.out.println("lista de DNI ordenada: ");
		for (int i = 0; i < listaNroDeLegajo.size(); i++) {
			System.out.println("El DNI " + (i + 1) + "es " + listaNroDeLegajo.get(i) + "pertenece a: "
					+ listaNombres.get(i) + listaApellido.get(i));
		}

		System.out.println("Ingrese el numero de legajo que quiera buscar: ");
		int numeroBuscado = dato.nextInt();
		
		boolean encontrado = false;

		int nro_Encontrado = 0;
		String nombreEncontrado = "";
		String ApellidoEncontrado = "";


		for (int i = 0; i < listaNroDeLegajo.size(); i++) {

			if (numeroBuscado == listaNroDeLegajo.get(i)) {
				// PARA LISTAS codigoBuscad == nro_de_socio.get(i)
				nro_Encontrado = listaNroDeLegajo.get(i);
				nombreEncontrado = listaNombres.get(i);
			    ApellidoEncontrado = listaApellido.get(i);
				encontrado = true;
				break;
			}

		}
		if (encontrado == true) {
			System.out.println("El numero de socio ingresado es: " + nro_Encontrado);
			System.out.println("El nombre es: "+ nombreEncontrado);
			System.out.println("El apellido es: "+ ApellidoEncontrado);

		}
			
		System.err.println("Programa flinalizado.");	

	}
}
