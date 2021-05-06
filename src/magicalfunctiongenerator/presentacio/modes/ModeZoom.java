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
import magicalfunctiongenerator.presentacio.FinestraPrincipal;
import magicalfunctiongenerator.utils.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

import javax.swing.*;

public class ModeZoom extends Mode
{
  public static final Cursor ZOOM_PLUS_CURSOR = Toolkit.getDefaultToolkit().createCustomCursor(PopurriUtils.instancia().getImage("lupaplus2.gif"), new Point(0, 0), "hand");
  public static final Cursor ZOOM_MINUS_CURSOR = Toolkit.getDefaultToolkit().createCustomCursor(PopurriUtils.instancia().getImage("lupaminus2.gif"), new Point(0, 0), "hand");
  private static final Color COLOR_ZOOM_PLUS = new Color(50, 200, 50);
  private static final Color COLOR_ZOOM_MINUS = new Color(230, 25, 25);
  private Color color;
  private boolean zoomplus;
  protected int x, y;
  protected int lastX, lastY;
  protected boolean clic;
  private int zoom;


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

  public ModeZoom(ControladorGrafica con, JComponent canvas, boolean zoomplus)
  {
    super(con, canvas);
    this.zoomplus = zoomplus;
    color = zoomplus ? COLOR_ZOOM_PLUS : COLOR_ZOOM_MINUS;
  }

  public void mousePressed(MouseEvent e)
  {
    clic = true;
    lastX = e.getX();
    lastY = e.getY();
    x = e.getX();
    y = e.getY();

    canvas.repaint();
  }

  public void mouseDragged(MouseEvent e)
  {
    x = e.getX();
    y = e.getY();
    canvas.repaint();
  }

  public void mouseReleased(MouseEvent e)
  {
    x = e.getX();
    y = e.getY();

    if (lastX > x)
    {
      int aux = lastX;
      lastX = x;
      x = aux;
    }

    if (lastY > y)
    {
      int aux = lastY;
      lastY = y;
      y = aux;
    }

    if (zoomplus)
    {
      //Evitem zoom amb una escala massa petita
      if (x - lastX < 40)
      {
        lastX -= 80;
        x += 80;
      }

      if (y - lastY < 40)
      {
        lastY -= 80;
        y += 80;
      }

      if(controlador.getZoom() > 1f)
        controlador.setWorldCoords(controlador.toWorldX(lastX), controlador.toWorldX(x), controlador.toWorldY(y), controlador.toWorldY(lastY));
    }
    else
    {
      if (x - lastX < 40)
      {
        lastX -= 40;
        x += 40;
      }

      if (y - lastY < 40)
      {
        lastY -= 40;
        y += 40;
      }


      float zoomx = controlador.getDistX() / 10 * 5;
      float zoomy = controlador.getDistY() / 10 * 5;

      controlador.setWorldCoords(controlador.toWorldX(lastX) - zoomx, controlador.toWorldX(x) + zoomx, controlador.toWorldY(y) - zoomy, controlador.toWorldY(lastY) + zoomy);
    }

    clic = false;
    FinestraPrincipal.instancia().barraestat.setZoom(controlador.getStringZoom());
    canvas.repaint();
  }

  public void dibuixarXY(Graphics2D g2)
  {
    g2.drawString(ControladorGrafica.formatCoordenades(controlador.toWorldX(x), controlador.toWorldY(y)), x - 20, y + 35);
  }

  public void dibuixarLastXY(Graphics2D g2)
  {
    g2.drawString(ControladorGrafica.formatCoordenades(controlador.toWorldX(lastX), controlador.toWorldY(lastY)), lastX - 55, lastY - 20);
  }

  private void dibuixarAreaZoom(Graphics2D g2, Color color)
  {
    g2.setColor(color);
    GeneralPath gp = new GeneralPath();
    this.dibuixarLastXY(g2);

    float[] f =
        {7, 5};
    g2.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 3, f, 3));
    gp.moveTo(lastX, lastY);
    gp.lineTo(x, lastY);
    gp.lineTo(x, y);
    gp.lineTo(lastX, y);
    gp.lineTo(lastX, lastY);
    g2.draw(gp);

    dibuixarXY(g2);
  }

  public Cursor getDefaultCursor()
  {
    return zoomplus ? ZOOM_PLUS_CURSOR : ZOOM_MINUS_CURSOR;
  }

  public void dibuixar(Graphics2D g2)
  {
    if (clic)
    {
      g2.setColor(color);
      g2.setFont(Mode.FONT);
      this.dibuixarLastXY(g2);
      this.dibuixarAreaZoom(g2, color);
    }
  }
}
