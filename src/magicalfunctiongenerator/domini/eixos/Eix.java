/**
 * Magical Function Generator
 *
 * @author Marc Oliveras Galvez <oligalma@gmail.com> 
 * @link http://www.oligalma.com
 * @copyright 2016 Oligalma
 * @license GPL License v3
 */

package magicalfunctiongenerator.domini.eixos;

import magicalfunctiongenerator.domini.*;
import magicalfunctiongenerator.utils.*;
import java.awt.*;
import java.text.*;

public abstract class Eix extends Sprite
{
  protected int tick = 4;
  protected static DecimalFormat format;
  protected boolean numeros_visibles = true;
  protected boolean ticks_visibles = true;
  protected boolean eix_visible = true;

  public Eix(Grafica g)
  {
    super(g);
    escala = 2f;
    color = Color.black;
    stroke = new BasicStroke();
    format = new DecimalFormat("#0.00");
  }

  public void setDibuixarNumeros(boolean b)
  {
    numeros_visibles = b;
  }

  public void setDibuixarTicks(boolean b)
  {
    ticks_visibles = b;
  }

  public void setDibuixarEix(boolean b)
  {
    eix_visible = b;
  }

  public boolean getDibuixarNumeros()
  {
    return numeros_visibles;
  }

  public boolean getDibuixarTicks()
  {
    return ticks_visibles;
  }

  public boolean getDibuixarEix()
  {
    return eix_visible;
  }


  protected abstract void dibuixarEix(Graphics2D g2);

  protected abstract void dibuixarTick(Graphics2D g2, float pos);

  protected abstract void dibuixarNumero(Graphics2D g2, float pos);

  protected abstract float getMax();

  protected abstract float getMin();

  private void dibuixarTicks(Graphics2D g2)
  {
    if (ticks_visibles)
    {
      if (getMax() * getMin() < 0)
      {
        for (float i = 0; i <= getMax(); i += escala)
        {
          dibuixarTick(g2, i);
        }
        for (float i = 0; i >= getMin(); i -= escala)
        {
          dibuixarTick(g2, i);
        }
      }
      else if (getMin() < 0)
      {
        for (float i = PopurriUtils.multiple(getMax(), escala); i >= getMin(); i -= escala)
        {
          dibuixarTick(g2, i);
        }
      }
      else
      {
        for (float i = PopurriUtils.multiple(getMin(), escala); i <= getMax(); i += escala)
        {
          dibuixarTick(g2, i);
        }
      }
    }
  }

  private void dibuixarNumeros(Graphics2D g2)
  {
    if (numeros_visibles)
    {
      if (getMax() * getMin() < 0)
      {
        for (float i = 0; i <= getMax(); i += escala)
        {
          dibuixarNumero(g2, i);
        }
        for (float i = 0; i >= getMin(); i -= escala)
        {
          dibuixarNumero(g2, i);
        }
      }
      else if (getMin() < 0)
      {
        for (float i = PopurriUtils.multiple(getMax(), escala); i >= getMin(); i -= escala)
        {
          dibuixarNumero(g2, i);
        }
      }
      else
      {
        for (float i = PopurriUtils.multiple(getMin(), escala); i <= getMax(); i += escala)
        {
          dibuixarNumero(g2, i);
        }
      }
    }
  }

  public void dibuixar(Graphics2D g2)
  {
    if (visible)
    {
      g2.setColor(color);
      g2.setStroke(new BasicStroke(2));

      dibuixarEix(g2);
      dibuixarTicks(g2);
      dibuixarNumeros(g2);
    }
  }
}
