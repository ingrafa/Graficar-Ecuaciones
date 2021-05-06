/**
 * Magical Function Generator
 *
 * @author Marc Oliveras Galvez <oligalma@gmail.com> 
 * @link http://www.oligalma.com
 * @copyright 2016 Oligalma
 * @license GPL License v3
 */

package magicalfunctiongenerator.presentacio;

import magicalfunctiongenerator.aplicacio.*;
import magicalfunctiongenerator.presentacio.modes.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class CanvasGrafica extends JComponent
{
  private FinestraGrafica frame;
  private ControladorGrafica controlador;
  public static final int MODE_SURF = 0;
  public static final int MODE_ZOOM_PLUS = 1;
  public static final int MODE_ZOOM_MINUS = 2;
  public static final int MODE_IMANT = 3;
  private Mode mode_actual;
  private ModeSurf mode_surf;
  private ModeZoom mode_zoom_plus;
  private ModeZoom mode_zoom_minus;
  private ModeImant mode_imant;
  private static int mode = MODE_SURF;


  public CanvasGrafica(int width, int height, FinestraGrafica frame)
  {
    this.frame = frame;
    controlador = new ControladorGrafica(frame.getTitle());
    Dimension d = new Dimension(width, height);
    this.setSize(d);
    this.setPreferredSize(d);
    this.enableEvents(AWTEvent.MOUSE_EVENT_MASK);
    this.enableEvents(AWTEvent.MOUSE_MOTION_EVENT_MASK);
    this.enableEvents(AWTEvent.MOUSE_WHEEL_EVENT_MASK);


    this.addComponentListener(new ComponentAdapter()
    {
      public void componentResized(ComponentEvent e)
      {
        controlador.setScreenCoords(0, CanvasGrafica.this.getWidth(), 0, CanvasGrafica.this.getHeight());
      }
    });

    mode_surf = new ModeSurf(controlador, this);
    mode_zoom_plus = new ModeZoom(controlador, this, true);
    mode_zoom_minus = new ModeZoom(controlador, this, false);
    mode_imant = new ModeImant(controlador, this);
    this.setMode(mode);
  }

  public void setCursor(Cursor c)
  {
    frame.getGlassPane().setCursor(c);
    super.setCursor(c);
  }

  protected void processMouseEvent(MouseEvent e)
  {
    mode_actual.dispatchEvent(e);
  }

  protected void processMouseMotionEvent(MouseEvent e)
  {
    FinestraPrincipal.instancia().barraestat.setCoordenades(formatCoordenadaXMapejada(e.getX()), formatCoordenadaYMapejada(e.getY()));
    mode_actual.dispatchEvent(e);
  }

  protected void processMouseWheelEvent(MouseWheelEvent e)
  {
    FinestraPrincipal.instancia().barraestat.setCoordenades(formatCoordenadaXMapejada(e.getX()), formatCoordenadaYMapejada(e.getY()));
    float incrY = e.getScrollAmount() * e.getWheelRotation();

    controlador.setWorldCoords(controlador.getXMinWorld(), controlador.getXMaxWorld(), controlador.getYMinWorld() - incrY, controlador.getYMaxWorld() - incrY);

    controlador.canvis(GestorDeCanvis.WORLD_COORDS_CHANGED);
  }

  public String formatCoordenadaXMapejada(int x)
  {
    return ControladorGrafica.FORMAT_XIFRES.format(controlador.toWorldX(x));
  }

  public String formatCoordenadaYMapejada(int y)
  {
    return ControladorGrafica.FORMAT_XIFRES.format(controlador.toWorldY(y));
  }

  public ControladorGrafica getControlador()
  {
    return controlador;
  }

  public void setMode(int nou_mode)
  {
    mode = nou_mode;
    switch (nou_mode)
    {
      case MODE_SURF:
        this.mode_actual = mode_surf;
        break;
      case MODE_ZOOM_PLUS:
        this.mode_actual = mode_zoom_plus;
        break;
      case MODE_ZOOM_MINUS:
        this.mode_actual = mode_zoom_minus;
        break;
      case MODE_IMANT:
        this.mode_actual = mode_imant;
        break;
    }
    setCursor(mode_actual.getDefaultCursor());
  }

  public void paintComponent(Graphics g)
  {
    Graphics2D g2 = (Graphics2D)g;

    controlador.dibuixar(g2);
    mode_actual.dibuixar(g2);
  }
}
