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
import java.awt.print.*;

import javax.swing.*;

public class Impressora implements Printable
{
  private static Impressora instancia;
  private JComponent c;

  private Impressora(){}

  public static Impressora instancia()
  {
    if (instancia == null)
      instancia = new Impressora();
    return instancia;
  }

  public void imprimir(JComponent c)
  {
    this.c = c;
    Book b = new Book();
    PrinterJob pj = PrinterJob.getPrinterJob();
    b.append(this, pj.defaultPage(), 1);
    pj.setPageable(b);

    if (pj.printDialog())
      try
      {
        pj.print();
      }
      catch (PrinterException ex)
      {
        System.out.print("Error en la impressi�");
      }
  }

  public int print(Graphics g, PageFormat pf, int pos)
  {
    int marge = 100;
    g.translate(marge, marge);
    c.printAll(g);
    g.translate( -marge, -marge);

    return Printable.PAGE_EXISTS;
  }
}
