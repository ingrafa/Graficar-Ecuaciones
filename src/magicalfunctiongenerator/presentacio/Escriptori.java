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
import java.awt.*;
import java.util.*;

import javax.swing.*;

public class Escriptori extends JDesktopPane implements Observer
{
  private MediaTracker tracker = new MediaTracker(this);
  private Image imatge;
  private static final int CENTRED_IMAGE = 0;
  private static final int MOSAIC_IMAGE = 1;
  private static final int EXTEND_IMAGE = 2;

  private int mode;
  private int locX = 20, locY = 20;
  private int visibles;

  public Escriptori()
  {
    //this.setImatge(magicalfunctiongenerator.utils.PopurriUtils.instancia().getImage("tucan.jpg"));
    //this.setModeImatge(this.EXTEND_IMAGE);
    this.setBackground(Color.GRAY);
    this.setBorder(BorderFactory.createLoweredBevelBorder());
  }

  public void setModeImatge(int mode)
  {
    this.mode = mode;
    this.repaint();
  }

  public int getModeImatge()
  {
    return mode;
  }

  public void loadImage(Image image)
  {
    tracker.addImage(image, 0);
    try
    {
      tracker.waitForID(0);
    }
    catch (InterruptedException e)
    {
      System.out.println("INTERRUPTED while loading Image");
    }

    tracker.removeImage(image);
  }

  public void addFinestra(String nom)
  {
    incrementarVisibles();
    FinestraGrafica f = new FinestraGrafica(nom);
    this.add(f);
    f.setLocation(locX, locY);
    locX += 20;
    locY += 20;
    if (locY > this.getHeight() - 20)
    {
      locY = 20;
      locX = 20;
    }

    try
    {
      f.setSelected(true);
    }
    catch (java.beans.PropertyVetoException e2)
    {}

    f.repaint();
  }

  public void removeFinestra(String nom)
  {
    if (!getFrame(nom).isIcon())
    {

      decrementarVisibles();
    }
    if (getFrame(nom).isIcon())
    {
      getFrame(nom).doDefaultCloseAction();
    }
    else
    {
      this.remove(getFrame(nom));
    }
    repaint();
  }

  public void canvis(String nom)
  {
    getFrame(nom).repaint();
  }

  public FinestraGrafica getFrame(String nom)
  {
    JInternalFrame[] frames = this.getAllFrames();
    if (frames != null)
    {
      for (int i = 0; i < frames.length; i++)
      {
        if (frames[i].getTitle().equals(nom))
        {
          return (FinestraGrafica)frames[i];
        }
      }
    }

    return null;
  }

  public boolean existeix(String grafica)
  {
    return getFrame(grafica) != null;
  }

  public void incrementarVisibles()
  {
    visibles++;

    if (visibles > 0)
    {
      FinestraPrincipal.instancia().barraeines.enableButtons(true);
      FinestraPrincipal.instancia().barramenu.enableButtons(true);
    }
  }

  public void decrementarVisibles()
  {
    visibles--;

    if (visibles == 0)
    {
      FinestraPrincipal.instancia().barraeines.enableButtons(false);
      FinestraPrincipal.instancia().barramenu.enableButtons(false);
    }
  }

  public void setImatge(Image im)
  {
    imatge = im;
    loadImage(imatge);
    this.repaint();
  }

  public void update(Observable o, Object arg)
  {
    int canvi = ((Integer)arg).intValue();

    switch (canvi)
    {
      case GestorDeCanvis.GRAFICA_CREADA:
        this.addFinestra(o.toString());
        break;
      case GestorDeCanvis.GRAFICA_ESBORRADA:
      {
        this.removeFinestra(o.toString());
        break;
      }
    }
  }

  public void setModeCanvas(int mode)
  {
    JInternalFrame[] frames = this.getAllFrames();
    if (frames != null)
    {
      for (int i = 0; i < frames.length; i++)
      {
        ((FinestraGrafica)frames[i]).setMode(mode);
      }
    }
  }

  /*public void paintComponent(Graphics g)
  {
    Graphics2D g2 = (Graphics2D)g;

    switch (mode)
    {
      case CENTRED_IMAGE:
        g2.drawImage(imatge, this.getWidth() / 2 - imatge.getWidth(this) / 2, this.getHeight() / 2 - imatge.getHeight(this) / 2, this);
        break;
      case EXTEND_IMAGE:
        g2.drawImage(imatge, 0, 0, this.getWidth(), this.getHeight(), this);
        break;
      case MOSAIC_IMAGE:
        for (int i = 0; i < this.getHeight(); i += imatge.getHeight(this))
        {
          for (int j = 0; j < this.getWidth(); j += imatge.getWidth(this))
          {
            g2.drawImage(imatge, j, i, this);
          }
        }
        break;
    }
  }*/
}
