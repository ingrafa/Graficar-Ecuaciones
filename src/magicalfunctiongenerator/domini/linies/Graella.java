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

public class Graella
{
  private LiniesXGraella liniaX;
  private LiniesYGraella liniaY;

  public Graella(Grafica g)
  {
    liniaX = new LiniesXGraella(g);
    liniaY = new LiniesYGraella(g);
  }

  public void dibuixar(Graphics2D g2)
  {
    liniaX.dibuixar(g2);
    liniaY.dibuixar(g2);
  }
}