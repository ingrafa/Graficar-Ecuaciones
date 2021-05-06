/**
 * Magical Function Generator
 *
 * @author Marc Oliveras Galvez <oligalma@gmail.com> 
 * @link http://www.oligalma.com
 * @copyright 2016 Oligalma
 * @license GPL License v3
 */

package magicalfunctiongenerator.presentacio.configuracions;

import magicalfunctiongenerator.presentacio.*;

import javax.swing.*;

public class FinestraConfigurar extends JDialog
{
  private static FinestraConfigurar instancia;
  private JTabbedPane tab = new JTabbedPane();
  private TabAparencia tabaparencia = new TabAparencia();
  private TabModes tabmodes = new TabModes();

  public static FinestraConfigurar instancia()
  {
    if (instancia == null)
    {
      instancia = new FinestraConfigurar();
    }
    return instancia;
  }

  private FinestraConfigurar()
  {
    super(FinestraPrincipal.instancia(), "Settings");
    initialize();
  }

  public void initialize()
  {
    this.setContentPane(tab);
    this.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
    this.setResizable(false);

    this.setVisible(true);
    tab.addTab("Aparència general", tabaparencia);
    tab.addTab("Opcions modes", tabmodes);
    this.pack();
    magicalfunctiongenerator.utils.PopurriUtils.instancia().centrarPantalla(this);
  }
}
