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
import java.text.*;
import java.util.*;

public class ControladorGrafica
{
  private Grafica grafica;
  private Mapper map;
  public static final DecimalFormat FORMAT_XIFRES = new DecimalFormat("0.000");
  public static final int GRAFICA_CREADA = 0;
  public static final int FUNCIO_CREADA = 1;
  public static final int GRAFICA_ESBORRADA = 2;
  public static final int FUNCIO_ESBORRADA = 3;
  public static final int WORLD_COORDS_CHANGED = 4;
  public static final int SCREEN_COORDS_CHANGED = 5;
  public static final int FUNCIO_MODIFICADA = 6;
  public static final int GRAFICA_MODIFICADA = 7;
  public static final int ZOOM_MODIFICAT = 8;

  // Codis colisions
  public static final int NO_COLISIO = 0;
  public static final int COLISIO_PUNT = 1;
  public static final int NO_COLISIO_PUNT = 2;
  public static final int COLISIO_FUNCIO = 3;
  public static final int NO_COLISIO_FUNCIO = 4;
  private boolean colisio;
  private Colisionable actual;
  private Funcio f;
  private float yvalue;
  public static final int FUNCIO_SIMPLE = 0;
  public static final int FUNCIO_INTERPOLADA = 1;

  public ControladorGrafica(String grafica)
  {
    this.grafica = FabricaDAO.instancia().getRegistreGrafiques().get(grafica);
    map = this.grafica.getMapper();
  }

  public void dibuixar(Graphics2D g2)
  {
    grafica.dibuixar(g2);
  }

  public void setWorldCoords(float xmin, float xmax, float ymin, float ymax)
  {
    map.setWorldCoords(xmin, xmax, ymin, ymax);
    grafica.canvis(WORLD_COORDS_CHANGED);
  }

  public void setScreenCoords(int xmin, int xmax, int ymin, int ymax)
  {
    map.setScreenCoords(xmin, xmax, ymin, ymax);
    grafica.canvis(SCREEN_COORDS_CHANGED);
  }

  public float toWorldX(int x)
  {
    return map.toWorldX(x);
  }

  public float toWorldY(int y)
  {
    return map.toWorldY(y);
  }

  public float getXMinWorld()
  {
    return map.getXMinWorld();
  }

  public float getXMaxWorld()
  {
    return map.getXMaxWorld();
  }

  public float getYMinWorld()
  {
    return map.getYMinWorld();
  }

  public float getYMaxWorld()
  {
    return map.getYMaxWorld();
  }

  public void canvis(int canvi)
  {
    grafica.canvis(canvi);
  }

  public float getDistY()
  {
    return map.getDistY();
  }

  public float getDistX()
  {
    return map.getDistX();
  }

  public int comprovarColisions(int x, int y)
  {
    ListIterator colisionables = grafica.getColisionables();
    int tipus_colisio = NO_COLISIO;
    colisio = false;
    Colisionable actual2 = null;

    while (colisionables.hasNext())
    {
      actual2 = (Colisionable)colisionables.next();

      if (actual2.colisio(x, y))
      {
        colisio = true;
        actual2.setColisio(true);

        if (actual2 instanceof Funcio)
        {
          f = (Funcio)actual2;
          yvalue = f.getYValue(map.toWorldX(x));
          tipus_colisio = COLISIO_FUNCIO;
        }
        else if (actual2 instanceof Punt)
        {
          Punt p = (Punt)actual2;
          p.setImage(Punt.PIN2);
          tipus_colisio = COLISIO_PUNT;
        }

        break;
      }
      actual2.setColisio(false);
    }

    if (actual != null && (!actual2.getColisio() || (actual2.getColisio() && actual != actual2)))
    {
      actual.setColisio(false);
      if (actual instanceof Funcio)
      {
        tipus_colisio = NO_COLISIO_FUNCIO;
      }
      else if (actual instanceof Punt)
      {
        ((Punt)actual).setImage(Punt.PIN); tipus_colisio = NO_COLISIO_PUNT;
      }
    }

    actual = colisio ? actual2 : null;

    return tipus_colisio;
  }

  public void incrPuntActual(float x, float y)
  {
    Punt p = (Punt)actual;
    p.setX(p.getX() + x);
    p.setY(p.getY() + y);
    FuncioInterpolada f = (FuncioInterpolada)p.getFuncio();
    f.firePuntsChanged();
    f.notificar(GestorDeCanvis.FUNCIO_MODIFICADA);
  }

  public int getTipusFuncioPuntActual()
  {
    Punt p = (Punt)actual;
    return p.getFuncio()instanceof FuncioSimple ? FUNCIO_SIMPLE : FUNCIO_INTERPOLADA;
  }

  public void canviarColorFuncioActual()
  {
    ((Funcio)actual).setRandomColor();
  }


  public void esborrarPuntActual() throws Exception
  {
    Punt p = (Punt)actual;
    Funcio f = p.getFuncio();
    f.removePunt(p);

    if (f instanceof FuncioInterpolada)
    {
      ((FuncioInterpolada)f).firePuntsChanged();
    }
    grafica.canvis(GestorDeCanvis.GRAFICA_MODIFICADA);
  }

  public void afegirPuntFuncioActual(float x) throws Exception
  {
    Funcio f = (Funcio)this.f;
    f.addPunt(x, f.getYValue(x));
    if (f instanceof FuncioInterpolada)
    {
      ((FuncioInterpolada)f).firePuntsChanged();
    }
    grafica.canvis(GestorDeCanvis.GRAFICA_MODIFICADA);
  }

  public int getYValueScreen()
  {
    return map.toScreenY(yvalue);
  }

  public Color getColorColisio()
  {
    if(actual instanceof Funcio)
      return ((Funcio)actual).getColor();
    else if(actual instanceof Punt)
      return ((Punt)actual).getFuncio().getColor();
    return Color.black;
  }

  public String getStringZoom()
  {
    return FORMAT_XIFRES.format(getZoom()) + "%";
  }

  public float getZoom()
  {
    return map.getDistX() * map.getDistY() / 400 * 100;
  }

  public String getStringColisio(int x, int y)
  {
    if(actual instanceof Funcio)
      return formatCoordenades(toWorldX(x), toWorldY(y));
    else if(actual instanceof Punt)
    {
      Punt p = (Punt) actual;
      return formatCoordenades(p.getX(), p.getY());
    }
    return "";
  }

  public void eliminarFuncioActual()
  {
    try
    {
      GestorDeCanvis.instancia().removeFuncio(((Funcio)actual).getExpressio(), grafica.getNom());
      GestorDeCanvis.instancia().notificar(grafica.getNom(), GestorDeCanvis.FUNCIO_ESBORRADA);
      actual = null;
    }
    catch(Exception e){}
  }


  public static String formatCoordenades(float x, float y)
  {
    return "(" + FORMAT_XIFRES.format(x) + " " + FORMAT_XIFRES.format(y) + ")";
  }

  static
  {
    DecimalFormatSymbols symbols = new DecimalFormatSymbols();
    symbols.setDecimalSeparator('.');
    FORMAT_XIFRES.setDecimalFormatSymbols(symbols);
  }
}
