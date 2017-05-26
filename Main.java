import java.util.Scanner;
import java.util.ArrayList;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingrese nombre archivo palabras: ");
    String file = sc.next();
    System.out.print("Ingrese nombre archivo sopa: ");
    String file2 = sc.next();

    /* Creamo el objeto para manejar los archivos, del cual obtenemos un array de la lista de palabras
    y un array con la sopa en forma de "matriz", quitandole los espacios y simbolos especiales */
    ManejoArchivos inFiles = new ManejoArchivos();
    ArrayList<String> listaPalabras = inFiles.leerPalabras(file);
    ArrayList<String> sopaDeLetras = inFiles.leerSopa(file2);

    BuscarPalabra ins = new BuscarPalabra();
    ArrayList<String> siPresentes = ins.BuscarPalabra(sopaDeLetras, listaPalabras);
    ArrayList<String> noPresentes = ins.palabrasNoPresentes(listaPalabras, siPresentes);

    ManejoArchivos outFiles = new ManejoArchivos();
    outFiles.escribirResultados(siPresentes, noPresentes);
  }
}
