/**
 * Magical Function Generator
 *
 * @author Marc Oliveras Galvez <oligalma@gmail.com> 
 * @link http://www.oligalma.com
 * @copyright 2016 Oligalma
 * @license GPL License v3
 */

package magicalfunctiongenerator.presentacio.modes;

import magicalfunctiongenerator.aplicacio.*;
import java.awt.*;
import javax.swing.*;

public abstract class Mode
{
  public static final Font FONT = new Font("Arial", Font.BOLD, 16);
  protected JComponent canvas;
  protected ControladorGrafica controlador;

  public Mode(ControladorGrafica con, JComponent c)
  {
    this.controlador = con;
    canvas = c;
  }

  public abstract void dispatchEvent(AWTEvent event);
  public abstract Cursor getDefaultCursor();
  public abstract void dibuixar(Graphics2D g2);
}
