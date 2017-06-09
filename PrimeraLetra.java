import java.util.ArrayList;

public class PrimeraLetra{
  int i;
  int j;
  ArrayList<int[]> coincidencias;
  ArrayList<int[]> noEncontrada;

  public ArrayList<int[]> buscarPrimeraLetra(String palabra, ArrayList<String> sopa){
    coincidencias = new ArrayList<int[]>();
    int[] posNoEncontrada = {-1, 0};
    noEncontrada = new ArrayList<int[]>();
    noEncontrada.add(posNoEncontrada);

    for (i = 0; i < sopa.size(); i++)
    {
      String aux = sopa.get(i);
      for (j = 0; j < aux.length(); j++)
      {
        int[] posicion = {j , i};
        if (aux.charAt(j) == palabra.charAt(0))
          coincidencias.add(posicion);
      }
    }
    if (coincidencias.size() == 0)
      return noEncontrada;
    else
      return coincidencias;
  }
}
