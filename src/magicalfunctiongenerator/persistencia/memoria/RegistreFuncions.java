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

public class RegistreFuncions implements IRegistreFuncions
{
  private LinkedList funcions;

  public RegistreFuncions()
  {
    funcions = new LinkedList();
  }

  public ListIterator getFuncions()
  {
    return funcions.listIterator();
  }

  public Funcio get(String nom)
  {
    for (int i = 0; i < funcions.size(); i++)
    {
      if (((Funcio)funcions.get(i)).getExpressio().equals(nom))
      {
        return (Funcio)funcions.get(i);
      }
    }

    return null;
  }

  public void add(Funcio f) throws Exception
  {
    if (existeix(f))
    {
      throw new Exception("The function cannot be inserted in the graphic because it already exists.");
    }

    f.setPunts(new RegistrePunts());

    funcions.add(f);
  }

  public void remove(String funcio) throws Exception
  {
    if (!existeix(funcio))
    {
      throw new Exception("The function cannot be deleted from the graphic because it doesn't exist.");
    }

    funcions.remove(get(funcio));
  }

  public boolean existeix(Funcio f)
  {
    boolean ok = false;

    for (int i = 0; i < funcions.size(); i++)
    {
      if (((Funcio)funcions.get(i)).equals(f))
      {
        ok = true;
        break;
      }
    }
    return ok;
  }

  public boolean comprovarRepetida(Funcio f)
  {
    byte num = 0;
    for (int i = 0; i < funcions.size(); i++)
    {
      Funcio f2 = (Funcio)funcions.get(i);
      if (f2.equals(f))
      {
        num++;
        if (num == 2)
        {
          funcions.remove(i);
          break;
        }
      }
    }
    return num == 2;
  }


  public boolean existeix(String s)
  {
    return get(s) != null;
  }

  public int size()
  {
    return funcions.size();
  }

  public Funcio get(int index)
  {
    return (Funcio)funcions.get(index);
  }

  public int getIndex(String funcio)
  {
    return funcions.indexOf(funcio);
  }

  public void dibuixar(Graphics2D g2)
  {
    ListIterator list = getFuncions();

    while (list.hasNext())
    {
      Funcio f = (Funcio)list.next();
      f.dibuixar(g2);
    }

    list = getFuncions();
    while (list.hasNext())
    {
      Funcio f = (Funcio)list.next();
      f.dibuixarPunts(g2);
    }
  }
}
