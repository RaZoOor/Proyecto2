import java.util.ArrayList;
import java.util.*;

public class BuscarPalabra{

  private ArrayList<int[]> buscarPrimeraLetra(String palabra, int indice, ArrayList<String> sopa){
    ArrayList<int[]> coincidencias = new ArrayList<int[]>();
    int[] posNoEncontrada = {-1, 0, 0};
    ArrayList<int[]> noEncontrada = new ArrayList<int[]>();
    noEncontrada.add(posNoEncontrada);

    for (int i = 0; i < sopa.size(); i++)
    {
      String aux = sopa.get(i);
      for (int j = 0; j < aux.length(); j++)
      {
        int[] posicion = {i , j, 0};
        if (aux.charAt(j) == palabra.charAt(indice))
          coincidencias.add(posicion);
      }
    }
    if (coincidencias.size() == 0)
      return noEncontrada;
    else
      return coincidencias;
  }

  private ArrayList<int[]> generarEstadosPosibles(int[] pos, ArrayList<String> sopa, String palabra){
    ArrayList<int[]> posibles = new ArrayList<int[]>();
    int x = pos[0];
    int y = pos[1];
    int indice = pos[2];

    if (indice >= palabra.length() - 1)
      return posibles;

    else
    {
      char letraABuscar = palabra.charAt(indice);

      for (int i = 0; i < sopa.size(); i++)
      {
        String aux = sopa.get(i);
        for (int j = 0; j < aux.length(); j++)
        {
          if (aux.charAt(j) == letraABuscar)
          {
            int[] newPos = {i, j, indice + 1};
            posibles.add(newPos);
          }
        }
      }
    }
    return posibles;
  }

  private boolean buscarEnSopa(int[] pos, ArrayList<String> sopa, String palabra, ArrayList<int[]> abiertos){

    if (pos[0] == -1)
      return false;

    else
    {
      if (abiertos.size() == 0)
        abiertos.add(pos);

      while (abiertos.size() != 0)
      {
        int[] m = new int[3];
        m[0] = pos[0];
        m[1] = pos[1];
        m[2] = pos[2] + 1; //Siguiente letra

        if (abiertos.size() > palabra.length() - 1)
          return true;
        abiertos.addAll(generarEstadosPosibles(m, sopa, palabra));
        System.out.println(abiertos.size());
        return buscarEnSopa(m, sopa, palabra, abiertos);
      }
    }
    return false;
  }

  public ArrayList<String> BuscarPalabra(ArrayList<String> sopa, ArrayList<String> palabras){
    ArrayList<String> siPresentes = new ArrayList<String>();

    for (int i = 0; i < palabras.size(); i++)
    {
      String aux = palabras.get(i);
      ArrayList<int[]> estados = new ArrayList<int[]>();
      ArrayList<int[]> aux1 = buscarPrimeraLetra(aux, 0, sopa);
      for (int j = 0; j < aux1.size(); j++)
      {
        if (buscarEnSopa(aux1.get(j), sopa, aux, estados))
        {
          siPresentes.add(aux);
          break;
        }
      }
    }
    return siPresentes;
  }

  public ArrayList<String> palabrasNoPresentes(ArrayList<String> original, ArrayList<String> siPresentes){
    ArrayList<String> noPresentes = (ArrayList<String>) original.clone();
    int size_1 = original.size();
    int size_2 = siPresentes.size();
    /* Si es que no se encontro alguna palabra en la sopa, devolver como no presente la lista original de
    palabras */
    if (size_2 == 0)
      return original;
    /* Recorremos la lista original para comparar palabra a palabra con la lista de estas que si se encuentran
    en la sopa */
    for (int i = 0; i < size_1; i++)
    {
      for (int j = 0; j < size_2; j++)
      {
        String palabra = siPresentes.get(j);
        String palabraOr = original.get(i);
        if (palabraOr.equals(palabra))
          noPresentes.remove(palabra);
      }
    }
    return noPresentes;
  }
}
