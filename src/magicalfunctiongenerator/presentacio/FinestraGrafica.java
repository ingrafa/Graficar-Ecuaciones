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
import magicalfunctiongenerator.utils.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

public class FinestraGrafica extends JInternalFrame implements Observer, InternalFrameListener
{
  private CanvasGrafica canvas;
  private ControladorGrafica controlador;
  private Escriptori escriptori = FinestraPrincipal.instancia().escriptori;

  public FinestraGrafica(String grafica)
  {
    super(grafica, true, true, true, true);

    canvas = new CanvasGrafica(GestorDeCanvis.instancia().getXMaxScreen(grafica), GestorDeCanvis.instancia().getYMaxScreen(grafica), this);
    controlador = canvas.getControlador();
    GestorDeCanvis.instancia().addObservador(this, grafica);
    initialize();
  }

  private void initialize()
  {
    this.addInternalFrameListener(this);
    this.getContentPane().add(canvas, BorderLayout.CENTER);
    this.pack();
    this.setVisible(true);
  }

  public String toString()
  {
    return this.getTitle();
  }

  public void setMode(int mode)
  {
    canvas.setMode(mode);
  }

  public void internalFrameActivated(InternalFrameEvent e)
  {
    GestorDeCanvis.instancia().setCoordenadesPantalla(this.getTitle(), 0, canvas.getWidth(), 0, canvas.getHeight());
    FinestraPrincipal.instancia().barraestat.setZoom(controlador.getStringZoom());
  }

  public void internalFrameDeactivated(InternalFrameEvent e)
  {}

  public void internalFrameOpened(InternalFrameEvent e)
  {
    canvas.repaint();
  }

  public void internalFrameClosing(InternalFrameEvent e)
  {
    try
    {
      GestorDeCanvis.instancia().removeGrafica(this.getTitle());
    }
    catch (Exception k)
    {
      PopurriUtils.mostrarMissatgeError(this, k.getMessage());
    }
  }

  public void internalFrameClosed(InternalFrameEvent e)
  {

  }

  public void internalFrameIconified(InternalFrameEvent e)
  {
    escriptori.decrementarVisibles();
  }

  public void internalFrameDeiconified(InternalFrameEvent e)
  {
    escriptori.incrementarVisibles();
  }

  public void update(Observable o, Object arg)
  {
    this.repaint();
  }
}
