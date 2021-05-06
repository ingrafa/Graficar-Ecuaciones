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
import java.util.*;

import javax.swing.*;

public class ModeImant extends Mode
{
  public static final Cursor MAGNET_CURSOR = Toolkit.getDefaultToolkit().createCustomCursor(PopurriUtils.instancia().getImage("iman2.gif"), new Point(0, 0), "magnet");
  public static final Cursor MAGNET_CURSOR_ACTIVATED = Toolkit.getDefaultToolkit().createCustomCursor(PopurriUtils.instancia().getImage("iman3.gif"), new Point(0, 0), "magnet");
  private Robot robot;
  private int tipus_colisio;
  private int x, y;
  private int lastX, lastY;
  private float xpop;
  private JPopupMenu pop = new JPopupMenu();
  boolean b;

  public void dispatchEvent(AWTEvent e)
  {
    switch (e.getID())
    {
      case MouseEvent.MOUSE_MOVED:
        this.mouseMoved((MouseEvent)e);
        break;
      case MouseEvent.MOUSE_DRAGGED:
        this.mouseDragged((MouseEvent)e);
        break;
      case MouseEvent.MOUSE_PRESSED:
        this.mousePressed((MouseEvent)e);
        break;
    }
  }

  public ModeImant(ControladorGrafica con, JComponent c)
  {
    super(con, c);

    try
    {
      robot = new Robot();
    }
    catch (AWTException e)
    {}
  }

  public void mouseMoved(MouseEvent e)
  {
    x = e.getX();
    y = e.getY();
    tipus_colisio = controlador.comprovarColisions(x, y);

    if (tipus_colisio != ControladorGrafica.NO_COLISIO)
    {
      switch (tipus_colisio)
      {
        case (ControladorGrafica.COLISIO_PUNT):
          break;
        case (ControladorGrafica.NO_COLISIO_PUNT):
          break;
        case (ControladorGrafica.COLISIO_FUNCIO):
          canvas.setCursor(MAGNET_CURSOR_ACTIVATED);
          moureCursor(x, controlador.getYValueScreen());
          break;
        case (ControladorGrafica.NO_COLISIO_FUNCIO):
          canvas.setCursor(MAGNET_CURSOR);
          break;
      }
      b = true;
      canvas.repaint();
    }
    else
    {
      if(b)
        canvas.repaint();
      b = false;
    }
  }

  public void mouseDragged(MouseEvent e)
  {
    if (e.getButton() == 0)
    {
      x = e.getX();
      y = e.getY();

      switch (tipus_colisio)
      {
        case (ControladorGrafica.COLISIO_PUNT):
          if (controlador.getTipusFuncioPuntActual() == ControladorGrafica.FUNCIO_INTERPOLADA)
          {
            float incrX = controlador.toWorldX(x) - controlador.toWorldX(lastX);
            float incrY = controlador.toWorldY(y) - controlador.toWorldY(lastY);

            controlador.incrPuntActual(incrX, incrY);
          }
          break;
      }

      lastX = x;
      lastY = y;
    }
  }

  public void mousePressed(MouseEvent e)
  {
    x = e.getX();
    y = e.getY();
    lastX = x;
    lastY = y;

    pop.setVisible(false);
    pop = new JPopupMenu();

    if (e.getButton() == MouseEvent.BUTTON3)
    {
      xpop = controlador.toWorldX(x);

      switch (tipus_colisio)
      {
        case ControladorGrafica.COLISIO_PUNT:
          JMenuItem eliminarPunt = new JMenuItem("Delete point");
          eliminarPunt.addActionListener(new ActionListener()
          {
            public void actionPerformed(ActionEvent e)
            {
              try
              {
                controlador.esborrarPuntActual();
              }
              catch (Exception e2)
              {
                JOptionPane.showMessageDialog(canvas, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
              }
            }
          });
          pop.add(eliminarPunt);
          pop.setVisible(true);
          break;
        case ControladorGrafica.COLISIO_FUNCIO:
          JMenuItem addPunt = new JMenuItem("Add point");
          JMenuItem removeFuncio  = new JMenuItem("Delete function");

          addPunt.addActionListener(new ActionListener()
          {
            public void actionPerformed(ActionEvent e)
            {
              try
              {
                controlador.afegirPuntFuncioActual(xpop);
              }
              catch (Exception e2){}
            }
          });

          removeFuncio.addActionListener(new ActionListener()
          {
            public void actionPerformed(ActionEvent e)
            {
              controlador.eliminarFuncioActual();
              canvas.setCursor(MAGNET_CURSOR);
            }
          });

          pop.add(addPunt);
          pop.add(removeFuncio);
          pop.setVisible(true);
          break;
      }

      Point p = canvas.getLocationOnScreen();
      pop.setLocation((int)p.getX() + x, (int)p.getY() + y);
    }
    else if(e.getButton() == MouseEvent.BUTTON1 && tipus_colisio == ControladorGrafica.COLISIO_FUNCIO)
    {
      controlador.canviarColorFuncioActual();
      canvas.repaint();
    }
    else
    {
      pop.setVisible(false);
    }
  }

  public Cursor getDefaultCursor()
  {
    return MAGNET_CURSOR;
  }

  private void moureCursor(int x, int y)
  {
    Point p = canvas.getLocationOnScreen();
    robot.mouseMove((int)p.getX() + x, (int)p.getY() + y);
  }

  public void dibuixar(Graphics2D g2)
  {
    if (tipus_colisio != ControladorGrafica.NO_COLISIO)
    {
      g2.setFont(Mode.FONT);
      g2.setColor(controlador.getColorColisio());
      g2.drawString(controlador.getStringColisio(x, y), x, y - 20);
    }
  }
}
