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
import java.util.*;

public class RegistreGrafiques implements IRegistreGrafiques
{
  private LinkedList grafiques;

  public RegistreGrafiques()
  {
    grafiques = new LinkedList();
  }

  public Grafica get(String grafica)
  {
    for (int i = 0; i < grafiques.size(); i++)
    {
      if (((Grafica)grafiques.get(i)).getNom().equals(grafica))
      {
        return (Grafica)grafiques.get(i);
      }
    }

    return null;
  }

  public ListIterator getGrafiques()
  {
    return grafiques.listIterator();
  }

  public void add(Grafica grafica) throws Exception
  {
    if (existeix(grafica.getNom()))
    {
      throw new Exception("The graphic cannot be inserted because it already exists.");
    }

    grafica.setFuncions(new RegistreFuncions());
    grafica.setPunts(new RegistrePunts());
    grafiques.add(grafica);
  }

  public int getIndex(String nom)
  {
    return grafiques.indexOf(nom);
  }

  public void remove(String grafica) throws Exception
  {
    if (!existeix(grafica))
    {
      throw new Exception("La gr�fica no es pot esborrar perqu� no existeix.");
    }
    grafiques.remove(get(grafica));
  }

  public boolean existeix(String grafica)
  {
    return get(grafica) != null;
  }

  public int size()
  {
    return grafiques.size();
  }

  public String getGraficaIndex(int index)
  {
    return grafiques.get(index).toString();
  }
}
