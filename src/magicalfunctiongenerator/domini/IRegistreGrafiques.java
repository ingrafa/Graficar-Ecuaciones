/**
 * Magical Function Generator
 *
 * @author Marc Oliveras Galvez <oligalma@gmail.com> 
 * @link http://www.oligalma.com
 * @copyright 2016 Oligalma
 * @license GPL License v3
 */

package magicalfunctiongenerator.domini;

import java.util.*;

public interface IRegistreGrafiques
{
  ListIterator getGrafiques();
  void add(Grafica grafica) throws Exception;
  int getIndex(String grafica);
  Grafica get(String grafica);
  void remove(String grafica) throws Exception;
  String getGraficaIndex(int index);
  boolean existeix(String grafica);
  int size();
}