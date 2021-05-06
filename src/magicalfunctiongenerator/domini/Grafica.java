/**
 * Magical Function Generator
 *
 * @author Marc Oliveras Galvez <oligalma@gmail.com> 
 * @link http://www.oligalma.com
 * @copyright 2016 Oligalma
 * @license GPL License v3
 */

package magicalfunctiongenerator.domini;

import magicalfunctiongenerator.domini.eixos.*;
import magicalfunctiongenerator.domini.linies.*;
import java.awt.*;
import java.util.*;

public class Grafica extends Observable implements IDibuixable
{
  private String nom;
  private Color background;
  private Mapper map;
  private EixCoordenades eix;
  private Graella graella;
  private IRegistreFuncions funcions;
  private IRegistrePunts punts;
  private boolean notificar;

  public Grafica(String nom, float xminw, float xmaxw, float yminw, float ymaxw, int xpmins, int xpmaxs, int ypmins, int ypmaxs)
  {
    this.nom = nom;
    map = new Mapper(xminw, xmaxw, yminw, ymaxw, xpmins, xpmaxs, ypmins, ypmaxs, this);
    graella = new Graella(this);
    eix = new EixCoordenades(this);
    background = Color.white;
  }

  public String getNom()
  {
    return nom;
  }

  public void setNotificar(boolean b)
  {
    notificar = b;
  }

  public ListIterator getFuncions()
  {
    return funcions.getFuncions();
  }

  public ListIterator getColisionables()
  {
    LinkedList colisionables = new LinkedList();

    ListIterator list = funcions.getFuncions();

    while (list.hasNext())
    {
      Funcio f = (Funcio)list.next();
      colisionables.addFirst(f);
    }

    list = funcions.getFuncions();

    while (list.hasNext())
    {
      Funcio f = (Funcio)list.next();
      ListIterator list2 = f.getPunts();
      while (list2.hasNext())
      {
        Punt p = (Punt)list2.next();
        colisionables.add(funcions.size() - 1, p);
      }
    }

    return colisionables.listIterator();
  }

  public void setNom(String nom)
  {
    this.nom = nom;
  }

  public void addFuncio(String nom) throws Exception
  {
    Funcio f = new FuncioSimple(nom, this);
    funcions.add(f);
  }

  public void addFuncio(float[] x, float[] y) throws Exception
  {
    if (x.length == 0 || y.length == 0)
    {
      throw new IllegalArgumentException("An (x,y) value must exist at least.");
    }
    if (x.length != y.length)
    {
      throw new IllegalArgumentException("The X and Y matrix must have the same number of values.");
    }

    FuncioInterpolada f = new FuncioInterpolada(this);
    funcions.add(f);

    for (int i = 0; i < x.length; i++)
    {
      f.addPunt(x[i], y[i]);

    }
    f.firePuntsChanged();
    if (funcions.comprovarRepetida(f))
    {
      throw new Exception("The function cannot be insert in the graphic because it already exists.");
    }
  }

  /*public void addPunt(float x, float y, Funcio funcio) throws Exception
     {
    Punt p = new Punt(x, y, funcio);
    if(funcio == null)
      punts.add(p);
    else
      funcio.addPunt(p);
     }*/

  public Funcio getFuncio(String funcio)
  {
    return funcions.get(funcio);
  }

  public int getNumeroFuncions()
  {
    return funcions.size();
  }

  public int getIndexFuncio(String funcio)
  {
    return funcions.getIndex(funcio);
  }

  public void removeFuncio(String nom) throws Exception
  {
    funcions.remove(nom);
  }

  public String getFuncioIndex(int index)
  {
    return funcions.get(index).toString();
  }

  public void setFuncions(IRegistreFuncions funcions)
  {
    this.funcions = funcions;
  }

  public void setPunts(IRegistrePunts punts)
  {
    this.punts = punts;
  }

  public void setWorldCoords(float xmin, float xmax, float ymin, float ymax)
  {
    map.setWorldCoords(xmin, xmax, ymin, ymax);
  }

  public void setScreenCoords(int xpmin, int xpmax, int ypmin, int ypmax)
  {
    map.setScreenCoords(xpmin, xpmax, ypmin, ypmax);
  }

  public Mapper getMapper()
  {
    return map;
  }

  private void dibuixarBackground(Graphics2D g2)
  {
    g2.setColor(background);
    g2.fillRect(map.getXMinScreen(), map.getYMinScreen(), map.getXMaxScreen(), map.getYMaxScreen());
  }

  public String toString()
  {
    return nom;
  }

  public void canvis(int canvi)
  {
    this.setChanged();
    if (notificar)
    {
      this.notifyObservers(new Integer(canvi));
    }
  }

  public boolean equals(Object o)
  {
    if (o instanceof Grafica)
    {
      return ((Grafica)o).nom.equals(nom);
    }
    return false;
  }

  public void dibuixar(Graphics2D g2)
  {
    dibuixarBackground(g2);
    graella.dibuixar(g2);
    eix.dibuixar(g2);
    funcions.dibuixar(g2);
    punts.dibuixar(g2);
  }
}
