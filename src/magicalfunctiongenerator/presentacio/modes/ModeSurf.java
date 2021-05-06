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
import magicalfunctiongenerator.utils.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ModeSurf extends Mode
{
  public static final Cursor STOP_CURSOR = Toolkit.getDefaultToolkit().createCustomCursor(PopurriUtils.instancia().getImage("ship.png"), new Point(0, 0), "hand");
  public static final Cursor RUN_CURSOR = Toolkit.getDefaultToolkit().createCustomCursor(PopurriUtils.instancia().getImage("ship2.png"), new Point(0, 0), "hand");
  protected int x, y;
  protected int lastX, lastY;

  public ModeSurf(ControladorGrafica con, JComponent c)
  {
    super(con, c);
  }

  public void dispatchEvent(AWTEvent e)
  {
    switch (e.getID())
    {
      case MouseEvent.MOUSE_PRESSED:
        this.mousePressed((MouseEvent)e);
        break;
      case MouseEvent.MOUSE_RELEASED:
        this.mouseReleased((MouseEvent)e);
        break;
      case MouseEvent.MOUSE_DRAGGED:
        this.mouseDragged((MouseEvent)e);
        break;
    }
  }

  public void mousePressed(MouseEvent e)
  {
    lastX = e.getX();
    lastY = e.getY();
    x = e.getX();
    y = e.getY();

    canvas.setCursor(RUN_CURSOR);
  }

  public void mouseReleased(MouseEvent e)
  {
    x = e.getX();
    y = e.getY();

    canvas.setCursor(STOP_CURSOR);
  }

  public void mouseDragged(MouseEvent e)
  {
    x = e.getX();
    y = e.getY();

    float incrX = controlador.toWorldX(x) - controlador.toWorldX(lastX);
    float incrY = controlador.toWorldY(y) - controlador.toWorldY(lastY);

    controlador.setWorldCoords(controlador.getXMinWorld() - incrX, controlador.getXMaxWorld() - incrX, controlador.getYMinWorld() - incrY, controlador.getYMaxWorld() - incrY);
    controlador.canvis(GestorDeCanvis.WORLD_COORDS_CHANGED);

    lastX = x;
    lastY = y;
  }

  public Cursor getDefaultCursor()
  {
    return STOP_CURSOR;
  }

  public void dibuixar(Graphics2D g2)
  {

  }
}
