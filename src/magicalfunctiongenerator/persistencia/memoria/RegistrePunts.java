/**
 * Magical Function Generator
 *
 * @author Marc Oliveras Galvez <oligalma@gmail.com> 
 * @link http://www.oligalma.com
 * @copyright 2016 Oligalma
 * @license GPL License v3
 */

package magicalfunctiongenerator.persistencia.memoria;

import magicalfunctiongenerator.domini.*;
import java.awt.*;
import java.util.*;

public class RegistrePunts implements IRegistrePunts
{
  LinkedList punts;

  public RegistrePunts()
  {
    punts = new LinkedList();
  }

  public ListIterator getPunts()
  {
    return punts.listIterator();
  }

  public Punt get(float x, float y)
  {
    for (int i = 0; i < punts.size(); i++)
    {
      if (((Punt)punts.get(i)).equals(x, y))
      {
        return (Punt)punts.get(i);
      }
    }

    return null;
  }

  public void add(Punt p) throws Exception
  {
    if (existeix(p))
    {
      throw new Exception("The point cannot be inserted because it already exists.");
    }

    punts.add(p);
  }

  public void remove(float x, float y) throws Exception
  {
    if (!existeix(x, y))
    {
      throw new Exception("The point cannot be deleted because it doesn't exist.");
    }

    punts.remove(get(x, y));
  }

  public boolean existeix(Punt p)
  {
    boolean ok = false;

    for (int i = 0; i < punts.size(); i++)
    {
      if (((Punt)punts.get(i)).equals(p))
      {
        ok = true;
        break;
      }
    }
    return ok;
  }

  public boolean existeix(float x, float y)
  {
    return get(x, y) != null;
  }

  public int size()
  {
    return punts.size();
  }

  public Punt get(int index)
  {
    return (Punt)punts.get(index);
  }

  public int getIndex(Punt p)
  {
    return punts.indexOf(p);
  }

  public void dibuixar(Graphics2D g2)
  {
    ListIterator list = getPunts();
    while (list.hasNext())
    {
      Punt c = (Punt)list.next();
      c.dibuixar(g2);
    }
  }
}
