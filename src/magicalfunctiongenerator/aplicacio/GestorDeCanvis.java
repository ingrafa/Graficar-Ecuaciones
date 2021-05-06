/**
 * Magical Function Generator
 *
 * @author Marc Oliveras Galvez <oligalma@gmail.com> 
 * @link http://www.oligalma.com
 * @copyright 2016 Oligalma
 * @license GPL License v3
 */

package magicalfunctiongenerator.aplicacio;

import magicalfunctiongenerator.domini.*;
import java.awt.*;
import java.util.*;

public class GestorDeCanvis
{
  private int numGrafiquesCreades = 0;
  private static GestorDeCanvis instancia;
  private IRegistreGrafiques grafiques;

  public static final int GRAFICA_CREADA = 0;
  public static final int FUNCIO_CREADA = 1;
  public static final int GRAFICA_ESBORRADA = 2;
  public static final int FUNCIO_ESBORRADA = 3;
  public static final int WORLD_COORDS_CHANGED = 4;
  public static final int SCREEN_COORDS_CHANGED = 5;
  public static final int FUNCIO_MODIFICADA = 6;
  public static final int GRAFICA_MODIFICADA = 7;
  public static final int ZOOM_MODIFICAT = 8;

  public static GestorDeCanvis instancia()
  {
    if (instancia == null)
    {
      instancia = new GestorDeCanvis();
    }
    return instancia;
  }

  private GestorDeCanvis()
  {
    grafiques = FabricaDAO.instancia().getRegistreGrafiques();
  }

  // M�TODES ADD................................................................
  public void addObservador(Observer o, String grafica)
  {
    Grafica g = grafiques.get(grafica);
    g.addObserver(o);
  }

  public void addFuncio(String funcio, String grafica) throws Exception
  {
    Grafica g = grafiques.get(grafica);
    g.addFuncio(funcio);
    g.canvis(FUNCIO_CREADA);
  }

  public void addFuncio(float[] x, float[] y, String grafica) throws Exception
  {
    Grafica g = grafiques.get(grafica);
    g.addFuncio(x, y);
    g.canvis(FUNCIO_CREADA);
  }

  public void addGrafica(String nom, LinkedList observers, float xminw, float xmaxw, float yminw, float ymaxw, int xpmins, int xpmaxs, int ypmins, int ypmaxs) throws Exception
  {
    Grafica g = new Grafica(nom, xminw, xmaxw, yminw, ymaxw, xpmins, xpmaxs, ypmins, ypmaxs);
    grafiques.add(g);

    ListIterator list = observers.listIterator();
    while (list.hasNext())
    {
      g.addObserver((Observer)list.next());

    }
    numGrafiquesCreades++;
    g.canvis(GRAFICA_CREADA);
  }

  // M�TODES SET................................................................
  public void setNotificar(String grafica, boolean notificar)
  {
    getGrafica(grafica).setNotificar(notificar);
  }

  public void setCoordenadesMon(String grafica, float xmin, float xmax, float ymin, float ymax)
  {
    Grafica g = getGrafica(grafica);
    g.setWorldCoords(xmin, xmax, ymin, ymax);
    g.canvis(WORLD_COORDS_CHANGED);
  }

  public void setCoordenadesPantalla(String grafica, int xmin, int xmax, int ymin, int ymax)
  {
    Grafica g = getGrafica(grafica);
    g.setScreenCoords(xmin, xmax, ymin, ymax);
    g.canvis(SCREEN_COORDS_CHANGED);

  }

  public void setColor(String funcio, String grafica, Color c)
  {
    grafiques.get(grafica).getFuncio(funcio).setColor(c);
  }

  // M�TODES REMOVE.............................................................
  public void removeFuncio(String funcio, String grafica) throws Exception
  {
    Grafica g = getGrafica(grafica);
    g.removeFuncio(funcio);
    g.canvis(FUNCIO_ESBORRADA);
  }

  public void removeGrafica(String grafica) throws Exception
  {
    Grafica g = getGrafica(grafica);
    if (g == null)
    {
      throw new Exception("The graphic cannot be deleted because it doesn't exist.");
    }
    grafiques.remove(grafica);
    g.canvis(GRAFICA_ESBORRADA);
  }

  public void removeObservador(Observer o, String grafica)
  {
    Grafica g = grafiques.get(grafica);
    g.deleteObserver(o);
  }

  // M�TODES GET................................................................
  private Grafica getGrafica(String grafica)
  {
    return grafiques.get(grafica);
  }

  public float getDistanciaMaxima()
  {
    return Mapper.DISTANCIA_MAXIMA;
  }

  public float getXifraMaxima()
  {
    return Mapper.XIFRA_MAXIMA;
  }

  public float getXifraMinima()
  {
    return Mapper.XIFRA_MINIMA;
  }

  public int getNumeroGrafiquesCreades()
  {
    return numGrafiquesCreades;
  }

  public int getXMaxScreen(String grafica)
  {
    return grafiques.get(grafica).getMapper().getXMaxScreen();
  }

  public int getYMaxScreen(String grafica)
  {
    return grafiques.get(grafica).getMapper().getYMaxScreen();
  }

  public ListIterator getGrafiques()
  {
    return grafiques.getGrafiques();
  }

  public ListIterator getFuncions(String grafica)
  {
    return grafiques.get(grafica).getFuncions();
  }

  public String getGraficaIndex(int index)
  {
    return grafiques.getGraficaIndex(index);
  }

  public int getNumeroFuncionsGrafica(String grafica)
  {
    return getGrafica(grafica).getNumeroFuncions();
  }

  public int getNumeroGrafiques()
  {
    return grafiques.size();
  }

  public String getFuncioIndex(int index, String grafica)
  {
    return getGrafica(grafica).getFuncioIndex(index);
  }

  public int getIndexGrafica(String grafica)
  {
    return grafiques.getIndex(grafica);
  }

  public int getIndexFuncioGrafica(String funcio, String grafica)
  {
    return getGrafica(grafica).getIndexFuncio(funcio);
  }


  // ALTRES M�TODES.............................................................
  public boolean existeix(String grafica)
  {
    return getGrafica(grafica) != null;
  }

  public void notificar(String grafica, int canvi)
  {
    getGrafica(grafica).canvis(canvi);
  }
}
