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
import java.awt.*;

public class LiniesXGraella extends LiniesGraella
{
  public LiniesXGraella(Grafica g)
  {
    super(g);
  }

  protected void dibuixarLinia(Graphics2D g2, float pos)
  {
    g2.drawLine(map.toScreenXmin(), map.toScreenY(pos), map.toScreenXmax(), map.toScreenY(pos));
  }

  protected float getMax()
  {
    return map.getYMaxWorld();
  }

  protected float getMin()
  {
    return map.getYMinWorld();
  }
}
