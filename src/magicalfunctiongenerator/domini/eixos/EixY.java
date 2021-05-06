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

public class EixY extends Eix
{
  public EixY(Grafica g)
  {
    super(g);
  }

  protected void dibuixarEix(Graphics2D g2)
  {
    g2.drawLine(map.toScreenX(0), map.toScreenYmin(), map.toScreenX(0), map.toScreenYmax());
  }

  protected void dibuixarTick(Graphics2D g2, float pos)
  {
    g2.drawLine(map.toScreenX(0) - tick, map.toScreenY(pos), map.toScreenX(0) + tick, map.toScreenY(pos));
  }

  protected void dibuixarNumero(Graphics2D g2, float pos)
  {
    g2.drawString(format.format(pos), map.toScreenX(0) + 2 * tick, map.toScreenY(pos) + 2 * tick);
  }

  protected float getMin()
  {
    return map.getYMinWorld() - escala;
  }

  protected float getMax()
  {
    return map.getYMaxWorld() + escala;
  }
}
