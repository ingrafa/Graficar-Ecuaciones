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
import java.awt.geom.*;

import javax.swing.*;

public class Punt extends Colisionable
{
  private float x, y;
  private int gruix = 4;
  public static final Image PIN = PopurriUtils.instancia().getImage("pin.gif");
  public static final Image PIN2 = PopurriUtils.instancia().getImage("pin2.gif");
  private ImageIcon imatge;
  private Funcio funcio;

  public Punt(float x, float y, Funcio f)
  {
    super(f.grafica);
    funcio = f;
    color = f.getColor();
    this.x = x;
    this.y = y;
    setImage(PIN);
  }

  public float getX()
  {
    return x;
  }

  public float getY()
  {
    return y;
  }

  public void setX(float f)
  {
    x = f;
  }

  public void setY(float f)
  {
    y = f;
  }

  public Funcio getFuncio()
  {
    return funcio;
  }

  public boolean equals(Object o)
  {
    if (!(o instanceof Punt))
    {
      return false;
    }

    return ((Punt)o).x == x && ((Punt)o).y == y;
  }

  public boolean equals(float x, float y)
  {
    return this.x == x && this.y == y;
  }

  public String toString()
  {
    return "(" + x + " " + y + ")";
  }

  public void setImage(Image image)
  {
    imatge = new ImageIcon(image);
  }

  protected Shape getShapeColisio()
  {
    return new Rectangle2D.Float(map.toScreenX(x) - imatge.getIconWidth() - 10, map.toScreenY(y) - imatge.getIconHeight() - 10, imatge.getIconWidth(), imatge.getIconHeight());
  }

  public void dibuixar(Graphics2D g2)
  {
    if (visible)
    {
      g2.setColor(color);
      //g2.drawOval(map.mapX(x.floatValue()) - gruix / 2, map.mapY(y.floatValue()) - gruix / 2, gruix, gruix);
      imatge.paintIcon(null, g2, map.toScreenX(x) - imatge.getIconWidth(), map.toScreenY(y) - imatge.getIconHeight());
    }
  }
}
