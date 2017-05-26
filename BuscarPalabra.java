import java.util.ArrayList;
import java.util.*;

public class BuscarPalabra{
  public boolean buscarLetra(String palabra, int indice, int x, int y, ArrayList<String> sopa){
    //ArrayList<Integer> newPos = new ArrayList<Integer>();
    for (int i = 0; i < sopa.size(); i++)
    {
      String aux = sopa.get(i);
      for (int j = 0; j < aux.length(); j++)
      {
        //newPos.add(i);
        //newPos.add(j);

        if (indice == palabra.length() - 1)
          return true;

        else if (aux.charAt(j) == palabra.charAt(indice))
        {
          if (indice == 0)
            return buscarLetra(palabra, indice + 1, i, j, sopa);

          /* Movimiento izquierda derecha arriba o abajo */
          else 
          {
            return buscarLetra(palabra, indice + 1, i, j, sopa);
          }
        }
        //newPos.clear();
      }
    }
    return false;
  }

  public ArrayList<String> BuscarPalabra(ArrayList<String> sopa, ArrayList<String> palabras){
    ArrayList<String> siPresentes = new ArrayList<String>();

    for (int i = 0; i < palabras.size(); i++)
    {
      String aux = palabras.get(i);
      if (buscarLetra(aux, 0, 0, 0, sopa))
        siPresentes.add(aux);
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
