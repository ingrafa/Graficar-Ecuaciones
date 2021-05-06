/**
 * Magical Function Generator
 *
 * @author Marc Oliveras Galvez <oligalma@gmail.com> 
 * @link http://www.oligalma.com
 * @copyright 2016 Oligalma
 * @license GPL License v3
 */

package magicalfunctiongenerator.domini;

import magicalfunctiongenerator.utils.*;
import java.awt.*;


public abstract class Sprite implements IDibuixable
{
  protected Color color;
  protected boolean visible;
  protected Mapper map;
  protected Grafica grafica;
  protected Stroke stroke;
  protected float escala;

  protected Sprite(Grafica g)
  {
    grafica = g;
    map = g.getMapper();
    stroke = new BasicStroke();
    visible = true;
  }

  public boolean getVisible()
  {
    return visible;
  }

  public void setVisible(boolean b)
  {
    visible = b;
  }

  public Color getColor()
  {
    return color;
  }

  public void setRandomColor()
  {
    setColor(new Color(PopurriUtils.instancia().random(50, 255), PopurriUtils.instancia().random(50, 255), PopurriUtils.instancia().random(50, 255)));
  }

  public void setColor(Color c)
  {
    color = c;
  }

  public float getEscala()
  {
    return escala;
  }

  public void setEscala(float valor)
  {
    escala = valor;
  }

  public void notificar(int canvi)
  {
    grafica.canvis(canvi);
  }
}
