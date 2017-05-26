import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class ManejoArchivos{
	public ArrayList<String> leerPalabras(String archivo){
		ArrayList<String> palabras = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		File f = new File(archivo);
		Scanner s;
		try {
			s = new Scanner(f);
			while (s.hasNextLine()) {
				String linea = s.nextLine();
				palabras.add(linea.toLowerCase());
			}
			s.close();
		} catch (FileNotFoundException e) {
			System.out.println("Archivo " + archivo + " no existe en el directorio");
		}
		return palabras;
	}

	public ArrayList<String> leerSopa(String archivo){
		ArrayList<String> sopa = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		File f = new File(archivo);
		Scanner s;
		try {
			s = new Scanner(f);
			while (s.hasNextLine()){
				String linea = s.nextLine();
				String lineas = linea.replaceAll("\\s+", "");
				sopa.add(lineas.toLowerCase());
			}
			s.close();
		} catch (FileNotFoundException e){
			System.out.println("Archivo " + archivo + "  no existe en el directorio");
		}
		return sopa;
	}
	public void escribirResultados(ArrayList<String> presentes, ArrayList<String> noPresentes){
		FileWriter fichero = null;
		PrintWriter pw = null;

		try {
			fichero = new FileWriter("Solucion.out");
			pw = new PrintWriter(fichero);

			pw.println("Palabras en la sopa:");
	    for (int i = 0; i < presentes.size(); i++)
	        pw.println(presentes.get(i));

			pw.println("\nPalabras que no se encuentran en la sopa:");
			for (int i = 0; i < noPresentes.size(); i++)
	        pw.println(noPresentes.get(i));

		} catch (Exception e) {
			System.out.println("Error al crear archivo de salida");
		} finally {
			try {
				// para asegurarnos que se cierra el fichero.
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar fichero");
			}
		}
	}
}
