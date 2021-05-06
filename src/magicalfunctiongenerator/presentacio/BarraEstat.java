/**
 * Magical Function Generator
 *
 * @author Marc Oliveras Galvez <oligalma@gmail.com> 
 * @link http://www.oligalma.com
 * @copyright 2016 Oligalma
 * @license GPL License v3
 */

package magicalfunctiongenerator.presentacio;

import magicalfunctiongenerator.utils.*;
import magicalfunctiongenerator.aplicacio.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class BarraEstat extends JToolBar implements Observer
{
  private Rellotge clock = new Rellotge();
  private Etiqueta xcursor = new Etiqueta("x2.gif", "0.000");
  private Etiqueta ycursor = new Etiqueta("y2.gif", "0.000");
  private Etiqueta zoom = new Etiqueta("zoom.gif", "100.000% ");
  //private JLabel image_extra = new JLabel(PopurriUtils.instancia().getImageIcon("pencil.png"));

  public BarraEstat()
  {
    initialize();
  }

  public void initialize()
  {
    xcursor.setPreferredSize(new Dimension(95, 0));
    ycursor.setPreferredSize(new Dimension(95, 0));

    BoxLayout box = new BoxLayout(this, BoxLayout.X_AXIS);
    this.setLayout(box);

    this.add(Box.createRigidArea(new Dimension(10, 35)));
    this.add(xcursor);
    this.add(Box.createRigidArea(new Dimension(8, 0)));
    this.add(ycursor);
    this.addSeparator();
    this.add(zoom);
  //  this.addSeparator();
    this.add(Box.createHorizontalGlue());
    //this.add(image_extra);
    this.add(Box.createHorizontalGlue());
   // this.addSeparator();
    this.add(clock);
    this.add(Box.createRigidArea(new Dimension(10, 0)));

    this.setBorder(BorderFactory.createLoweredBevelBorder());
    this.setOpaque(true);
    this.setFloatable(false);
    this.setBorderPainted(true);
  }

  public void addSeparator()
  {
    ImageIcon separator = PopurriUtils.instancia().getImageIcon("ball4.gif");
    this.add(new JLabel(separator));
  }

  private class Etiqueta extends JLabel
  {
    public Etiqueta(String imatge, String valor)
    {
      this.setIcon(PopurriUtils.instancia().getImageIcon(imatge));
      this.setText(valor);
      this.setVerticalAlignment(JLabel.CENTER);
      this.setHorizontalAlignment(JLabel.LEFT);
      this.setFont(new java.awt.Font("Arial", Font.PLAIN, 14));
      initialize();
    }

    private void initialize()
    {
      this.setBorder(BorderFactory.createRaisedBevelBorder());
    }
  }

  public void setZoom(String zoom)
  {
    this.zoom.setText(zoom);
  }

  public void setCoordenades(String x, String y)
  {
    xcursor.setText(x);
    ycursor.setText(y);
  }

  public void update(Observable o, Object arg)
  {
     int canvi = ((Integer)arg).intValue();
     switch (canvi)
     {
       case GestorDeCanvis.ZOOM_MODIFICAT:
         break;
     }
  }
}
