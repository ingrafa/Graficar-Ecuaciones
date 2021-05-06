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
import java.awt.*;

public class EixX extends Eix
{
  public EixX(Grafica g)
  {
    super(g);
  }

  protected void dibuixarEix(Graphics2D g2)
  {
    if (eix_visible)
    {
      g2.drawLine(map.toScreenXmin(), map.toScreenY(0), map.toScreenXmax(), map.toScreenY(0));
    }
  }

  protected void dibuixarTick(Graphics2D g2, float pos)
  {
    g2.drawLine(map.toScreenX(pos), map.toScreenY(0) - tick, map.toScreenX(pos), map.toScreenY(0) + tick);
  }

  protected void dibuixarNumero(Graphics2D g2, float pos)
  {
    g2.drawString(format.format(pos), map.toScreenX(pos) - 2 * tick, map.toScreenY(0) - 2 * tick);
  }

  protected float getMin()
  {
    return map.getXMinWorld() - escala;
  }

  protected float getMax()
  {
    return map.getXMaxWorld() + escala;
  }
}
