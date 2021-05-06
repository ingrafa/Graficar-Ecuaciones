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

public interface IRegistrePunts extends IDibuixable
{
  ListIterator getPunts();
  Punt get(float x, float y);
  void add(Punt p) throws Exception;
  void remove(float x, float y) throws Exception;
  boolean existeix(Punt p);
  boolean existeix(float x, float y);
  int size();
  boolean equals(Object o);
  Punt get(int index);
  int getIndex(Punt p);
}
