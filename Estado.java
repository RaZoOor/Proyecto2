import java.util.ArrayList;
import java.util.*;

public class Estado{
  //Atributos
  int x;
  int y;
  int esFin;
  //Constructor del estado
  public Estado(int x, int y, int esFin){
    this.x = x;
    this.y = y;
    this.esFin = esFin;
  }

  public boolean buscarPalabra(int actual, String palabraABuscar, ArrayList<String> sopa){
    if (x == -1 || y == -1) return false; //Comprobamos si la primera letra no esta en la sopa, para ahorrar procesos
    else if (x >= sopa.get(0).length() || y >= sopa.size()) return false; //Comprobamos que no se salga de los limites

    if (actual == palabraABuscar.length() - 1) return true; //corroboramos si ya encontramos la palabra

    if (sopa.get(y).charAt(x) == palabraABuscar.charAt(actual))
    {
      actual++;
      //Movimiento arriba
      y--;
      if (buscarPalabra(actual, palabraABuscar, sopa) && y >= 0) return true;
      y++;
      //Movimiento izquierda
      x--;
      if (buscarPalabra(actual, palabraABuscar, sopa) && x >= 0) return true;
      x++;
      //Movimiento abajo
      y++;
      if (buscarPalabra(actual, palabraABuscar, sopa) && y >= 0) return true;
      y--;
      //Movimiento derecha
      x++;
      if (buscarPalabra(actual, palabraABuscar, sopa) && x >= 0) return true;
      x--;

      return false;
    }
    return false;
  }
}
