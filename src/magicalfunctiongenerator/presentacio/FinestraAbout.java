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
import java.awt.*;

import javax.swing.*;

public class FinestraAbout extends JDialog
{
  private static FinestraAbout instancia;

  public static void mostrarAbout()
  {
    if (instancia == null)
    {
      instancia = new FinestraAbout();
    }
    else
    {
      instancia.setVisible(true);
    }
  }

  private FinestraAbout()
  {
    super(FinestraPrincipal.instancia(), "About...");
    initialize();
  }

  private void initialize()
  {
    this.setModal(true);
    this.setResizable(false);
    JLabel lab = new JLabel(PopurriUtils.instancia().getImageIcon("about.gif"));
    this.getContentPane().add(lab, BorderLayout.CENTER);
    this.pack();
    PopurriUtils.instancia().centrarPantalla(this);
    this.setVisible(true);
  }
}
