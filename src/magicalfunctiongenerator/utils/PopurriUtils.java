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
import java.io.*;
import java.net.*;

import javax.swing.*;

public class PopurriUtils
{
  private static PopurriUtils instancia;

  private PopurriUtils()
  {}

  public static PopurriUtils instancia()
  {
    if (instancia == null)
    {
      instancia = new PopurriUtils();
    }
    return instancia;
  }

  public static int random(int a, int b)
  {
    return a >= 0 ? (int)(Math.random() * (b - a + 1) + a) : (int)(Math.random() * (b - a + 1)) + a;
  }

  public static int xifresDecimals(float num)
  {
    String s = num + "";

    return s.length() - s.indexOf(".") - 1;
  }

  public static float multiple(float numero, float multiple)
  {
    return numero - (numero % multiple);
  }

  public ImageIcon getImageIcon(String nom)
  {
    return new ImageIcon(getImage(nom));
  }

  public String getDirectoriImatges()
  {
    File directori = new File("imatges");
    return directori.getPath();
  }

  public Image getImage(String nom)
  {
    return Toolkit.getDefaultToolkit().getImage(getDirectoriImatges() + System.getProperty("file.separator") + nom);
  }

  public Image getImage(URL url)
  {
    return Toolkit.getDefaultToolkit().getImage(url);
  }

  public static void centrarPantalla(Component c)
  {
    float screenwidth = (float)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    float screenheight = (float)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    Point p = new Point((int)screenwidth / 2 - c.getWidth() / 2, (int)screenheight / 2 - c.getHeight() / 2);
    c.setLocation(p);
  }

  public static void maximitzar(Component c)
  {
    float screenwidth = (float)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    float screenheight = (float)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    c.setSize(new Dimension((int)screenwidth, (int)screenheight - 50));

    Point p = new Point(0, 0);
    c.setLocation(p);
  }

  public static void mostrarMissatgeError(Component c, String missatge)
  {
    JOptionPane.showMessageDialog(c, missatge, "Error", JOptionPane.ERROR_MESSAGE);
  }

  public String getExtension(File f)
  {

    String ext = null;
    String s = f.getName();
    int i = s.lastIndexOf('.');

    if (i > 0 && i < s.length() - 1)
    {
      ext = s.substring(i + 1).toLowerCase();
    }
    return ext;
  }
}
