import java.io.*;
import java.util.*;

public class GestorContactoMFile {
	private static final String NOMBRE_ARCHIVO = "Contactos.txt";
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int opcion;

		do {
			mostrarMenu();
			opcion = scanner.nextInt();
			scanner.nextLine(); // limpiar buffer

			switch (opcion) {
				case 1:
					agregarContacto();
					break;
				case 2:
					mostrarContactos();
					break;
				case 3:
					buscarContacto();
					break;
				case 4:
					modificarContacto();
					break;
				case 5:
					eliminarContacto();
					break;
				case 6:
					eliminarArchivo();
					break;
				case 7:
					System.out.println("¡Hasta pronto!");
					break;
				default:
					System.out.println("Opción no válida.");
			}
		} while (opcion != 7);
	}

	private static void mostrarMenu() {
		System.out.println("\n=== GESTOR DE CONTACTOS (File) ===");
		System.out.println("1. Agregar contacto");
		System.out.println("2. Mostrar todos los contactos");
		System.out.println("3. Buscar contacto por nombre compl./part.");
		System.out.println("4. Modificar contacto");
		System.out.println("5. Eliminar contacto");
		System.out.println("6. Eliminar archivo de contactos");
		System.out.println("7. Salir");
		System.out.print("Seleccione una opción: ");
	}

	public static void agregarContacto() {
		System.out.println("\n--- AGREGAR CONTACTO ---");

		// TODO: Pedir nombre y teléfono al usuario
		System.out.print("Nombre: ");
		String nombre = scanner.nextLine();
		System.out.print("Teléfono: ");
		String telefono = scanner.nextLine();

		FileWriter fw = null;
		try {
			// TODO: Abrir archivo en modo APPEND (añadir)
			fw = new FileWriter(NOMBRE_ARCHIVO, true);

			// TODO: Escribir el contacto en el formato: nombre,telefono
			fw.write(nombre + "," + telefono + System.lineSeparator());

			// TODO: Imprimir los datos agregados
			System.out.println("\n--- CONTACTO AGREGADO CORRECTAMENTE ---");
			System.out.println("Nombre: " + nombre);
			System.out.println("Teléfono: " + telefono);

			// TODO: Cerrar el archivo y mostrar mensaje de éxito
			fw.close();
			System.out.println("Contacto agregado con éxito.");
		} catch (IOException e) {
			System.out.println("Error al agregar contacto: " + e.getMessage());
		}
	}

	public static void mostrarContactos() {
		System.out.println("\n--- LISTA DE CONTACTOS ---");
		File archivo = new File(NOMBRE_ARCHIVO);

		// TODO: Verificar si el archivo existe
		if (!archivo.exists()) {
			System.out.println("El archivo no existe.");
			return;
		}

		try (FileReader fr = new FileReader(archivo)) {
			StringBuilder sb = new StringBuilder();
			int c;
			while ((c = fr.read()) != -1) {
				sb.append((char) c);
			}

			// TODO: Mostrar todos los contactos con formato (separar con coma)
			String[] lineas = sb.toString().split("\\r?\\n");
			for (String linea : lineas) {
				String[] partes = linea.split(",");
				if (partes.length == 2) {
					System.out.println("Nombre: " + partes[0] + " | Teléfono: " + partes[1]);
				} else {
					System.out.println(linea); // en caso de formato incorrecto
				}
			}

		} catch (IOException e) {
			System.out.println("Error al mostrar contactos.");
		}
	}

	public static void buscarContacto() {
		System.out.println("\n--- BUSCAR CONTACTO (File) ---");
		System.out.print("Ingrese el nombre o parte de: ");
		String nombreBuscado = scanner.nextLine().toLowerCase();

		try {
			File archivo = new File(NOMBRE_ARCHIVO);

			// TODO: Verificar si el archivo existe
			if (!archivo.exists()) {
				System.out.println("El archivo no existe.");
				return;
			}

			FileReader fr = new FileReader(archivo);
			Scanner lector = new Scanner(fr);
			boolean encontrado = false;

			System.out.println("\n--- RESULTADOS DE BÚSQUEDA ---");

			while (lector.hasNextLine()) {
				String linea = lector.nextLine();

				// TODO: Leer el archivo y buscar contactos que coincidan parcialmente
				if (linea.toLowerCase().contains(nombreBuscado)) {
					// TODO: Mostrar solo los contactos que coincidan
					String[] datos = linea.split(",");
					if (datos.length == 2) {
						System.out.println("Nombre: " + datos[0] + " | Teléfono: " + datos[1]);
					} else {
						System.out.println(linea); // en caso de formato incorrecto
					}
					encontrado = true;
				}
			}

			if (!encontrado) {
				System.out.println("No se encontró ningún contacto que coincida.");
			}

			lector.close();
			fr.close();
		} catch (IOException e) {
			System.out.println("Error al buscar contacto: " + e.getMessage());
		}
	}

	public static void modificarContacto() {
		System.out.println("\n--- MODIFICAR CONTACTO ---");
		System.out.print("Nombre del contacto a modificar: ");
		String nombreBuscado = scanner.nextLine().toLowerCase();

		File archivo = new File(NOMBRE_ARCHIVO);
		if (!archivo.exists()) {
			System.out.println("El archivo no existe.");
			return;
		}

		List<String> contactos = new ArrayList<>();
		boolean modificado = false;

		try (Scanner lector = new Scanner(new FileReader(archivo))) {
			while (lector.hasNextLine()) {
				String linea = lector.nextLine();
				if (linea.toLowerCase().startsWith(nombreBuscado + ",")) {
					String[] partes = linea.split(",");
					System.out.println("Contacto encontrado: " + linea);

					System.out.print("Nuevo nombre (Enter para mantener '" + partes[0] + "'): ");
					String nuevoNombre = scanner.nextLine();
					if (nuevoNombre.isEmpty())
						nuevoNombre = partes[0];

					System.out.print("Nuevo teléfono (Enter para mantener '" + partes[1] + "'): ");
					String nuevoTel = scanner.nextLine();
					if (nuevoTel.isEmpty())
						nuevoTel = partes[1];

					// TODO: Imprimir los datos actualizados (aunque no se hayan modificado)
					System.out.println("\n--- DATOS ACTUALIZADOS ---");
					System.out.println("Nombre: " + nuevoNombre);
					System.out.println("Teléfono: " + nuevoTel);

					contactos.add(nuevoNombre + "," + nuevoTel);
					modificado = true;
				} else {
					contactos.add(linea);
				}
			}
		} catch (IOException e) {
			System.out.println("Error al leer archivo.");
			return;
		}

		if (modificado) {
			try (FileWriter fw = new FileWriter(NOMBRE_ARCHIVO)) {
				for (String c : contactos)
					fw.write(c + "\n");
				System.out.println("Contacto modificado con éxito.");
			} catch (IOException e) {
				System.out.println("Error al guardar cambios.");
			}
		} else {
			System.out.println("No se encontró el contacto.");
		}
	}

	public static void eliminarContacto() {
		System.out.println("\n--- ELIMINAR CONTACTO ---");
		System.out.print("Nombre del contacto a eliminar: ");
		String nombreBuscado = scanner.nextLine().toLowerCase();

		File archivo = new File(NOMBRE_ARCHIVO);
		if (!archivo.exists()) {
			System.out.println("El archivo no existe.");
			return;
		}

		List<String> contactos = new ArrayList<>();
		boolean eliminado = false;

		try (Scanner lector = new Scanner(new FileReader(archivo))) {
			while (lector.hasNextLine()) {
				String linea = lector.nextLine();
				if (linea.toLowerCase().startsWith(nombreBuscado + ",")) {
					eliminado = true; // lo omitimos
				} else {
					contactos.add(linea);
				}
			}
		} catch (IOException e) {
			System.out.println("Error al procesar archivo.");
			return;
		}

		if (eliminado) {
			try (FileWriter fw = new FileWriter(NOMBRE_ARCHIVO)) {
				for (String c : contactos)
					fw.write(c + "\n");
				System.out.println("Contacto eliminado con éxito.");
			} catch (IOException e) {
				System.out.println("Error al guardar cambios.");
			}
		} else {
			System.out.println("No se encontró el contacto.");
		}
	}

	public static void eliminarArchivo() {
		System.out.println("\n--- ELIMINAR ARCHIVO (File) ---");
		File archivo = new File(NOMBRE_ARCHIVO);

		// TODO: eliminar el archivo
		if (archivo.exists()) {
			// TODO: Verificar si se eliminó correctamente
			if (archivo.delete()) {
				System.out.println("Archivo eliminado correctamente.");
			} else {
				System.out.println("No se pudo eliminar el archivo.");
			}
		} else {
			System.out.println("El archivo no existe.");
		}
	}
}
