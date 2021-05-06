/**
 * Magical Function Generator
 *
 * @author Marc Oliveras Galvez <oligalma@gmail.com> 
 * @link http://www.oligalma.com
 * @copyright 2016 Oligalma
 * @license GPL License v3
 */

package magicalfunctiongenerator.utils;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.image.*;
import java.io.*;

import javax.swing.*;

public class Portapapers implements ClipboardOwner
{
  private static Portapapers instancia;

  private Portapapers()
  {}

  public static Portapapers instancia()
  {
    if (instancia == null)
    {
      instancia = new Portapapers();
    }
    return instancia;
  }

  public void copiarText(String text)
  {
    copiar(new StringSelection(text));
  }

  public void copiarImatge(Image i)
  {
    ImatgeTransferible im = new ImatgeTransferible(i);
    copiar(im);
  }

  public void copiarComponent(JComponent c)
  {
    BufferedImage bif = new BufferedImage(c.getWidth(), c.getHeight(), BufferedImage.TYPE_INT_RGB);
    Graphics2D g2 = bif.createGraphics();
    c.printAll(g2);

    ImatgeTransferible im = new ImatgeTransferible(bif);
    copiar(im);
  }

  private void copiar(Transferable t)
  {
    Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
    c.setContents(t, this);
  }

  private class ImatgeTransferible implements Transferable
  {
    private Image imatge;
    private DataFlavor myFlavor = DataFlavor.imageFlavor;

    public ImatgeTransferible(Image im)
    {
      imatge = im;
    }

    public synchronized DataFlavor[] getTransferDataFlavors()
    {
      return new DataFlavor[]{myFlavor};
    }

    public boolean isDataFlavorSupported(DataFlavor flavor)
    {
      return myFlavor.equals(flavor);
    }

    public synchronized Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException
    {
      if (!myFlavor.equals(flavor))
        throw new UnsupportedFlavorException(flavor);
      return (imatge);
    }
  }

  public void lostOwnership(Clipboard cb, Transferable trans)
  {
    //System.out.println("S'ha perdut el propietari del portapapers");
  }
}
