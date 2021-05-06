/**
 * Magical Function Generator
 *
 * @author Marc Oliveras Galvez <oligalma@gmail.com> 
 * @link http://www.oligalma.com
 * @copyright 2016 Oligalma
 * @license GPL License v3
 */

package magicalfunctiongenerator.domini.linies;

import magicalfunctiongenerator.domini.*;
import magicalfunctiongenerator.utils.*;
import java.awt.*;

public abstract class LiniesGraella extends Sprite
{
  public LiniesGraella(Grafica g)
  {
    super(g);
    escala = 1f;
    float[] f =
        {7, 5};
    stroke = new BasicStroke(); //1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 3, f, 3);
    color = Color.lightGray;
  }

  protected abstract void dibuixarLinia(Graphics2D g2, float pos);

  protected abstract float getMax();

  protected abstract float getMin();


  public void dibuixar(Graphics2D g2)
  {
    if (visible)
    {
      g2.setColor(color);
      g2.setStroke(stroke);

      if (getMax() * getMin() < 0)
      {
        for (float i = 0; i <= getMax(); i += escala)
        {
          dibuixarLinia(g2, i);

        }
        for (float i = 0; i >= getMin(); i -= escala)
        {
          dibuixarLinia(g2, i);
        }
      }

      else if (getMin() < 0)
      {
        for (float i = PopurriUtils.multiple(getMax(), escala); i >= getMin(); i -= escala)
        {
          dibuixarLinia(g2, i);

        }
      }
      else
      {
        for (float i = PopurriUtils.multiple(getMin(), escala); i <= getMax(); i += escala)
        {
          dibuixarLinia(g2, i);
        }
      }
    }
  }
}
