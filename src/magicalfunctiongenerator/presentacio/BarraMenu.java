/**
 * Magical Function Generator
 *
 * @author Marc Oliveras Galvez <oligalma@gmail.com> 
 * @link http://www.oligalma.com
 * @copyright 2016 Oligalma
 * @license GPL License v3
 */

package magicalfunctiongenerator.presentacio;

import javax.swing.*;

public class BarraMenu extends JMenuBar
{
  JMenu menuarxiu = new JMenu("File");
  JMenu menueditar = new JMenu("Edit");
  JMenu menumode = new JMenu("Modes");
  JMenu menueines = new JMenu("Tools");
  JMenu menuajuda = new JMenu("Help");

  // Arxiu
  JMenuItem menuitemnova = menuarxiu.add(ActionFactory.instancia().novaFuncio());
  //JMenuItem menuitemworkspace = menuarxiu.add(ActionFactory.instancia().guardar());
  JMenuItem menuitemimprimir = menuarxiu.add(ActionFactory.instancia().impressora());
  //JMenuItem menuitemconfigurar = menuarxiu.add(ActionFactory.instancia().configurar());
  JMenuItem menuitemsortir = menuarxiu.add(ActionFactory.instancia().sortir());
  // Editar
  //JMenuItem menuitemopcions = menueditar.add(ActionFactory.instancia().opcions());
  JMenuItem menuitemcopiar = menueditar.add(ActionFactory.instancia().copiar());
  JMenuItem menuitemesborrar = menueditar.add(ActionFactory.instancia().esborrar());

  // Mode
  JMenuItem menuitemnavegar = menumode.add(ActionFactory.instancia().navegar());
  JMenuItem menuitemiman = menumode.add(ActionFactory.instancia().iman());
  JMenuItem menuitemzoomplus = menumode.add(ActionFactory.instancia().zoomPlus());
  JMenuItem menuitemzoomminus = menumode.add(ActionFactory.instancia().zoomMinus());

  // Eines
  JMenuItem menuitemcalculadora = menueines.add(ActionFactory.instancia().calculadora());
  //JMenuItem menuitemkeyboard = menueines.add(ActionFactory.instancia().keyboard());
  //JMenuItem menuitemconstants = menueines.add(ActionFactory.instancia().constants());
  
  // Ajuda
  //JMenuItem menuitemajuda = menuajuda.add(ActionFactory.instancia().ajuda());
  //JMenuItem menuitemmates = menuajuda.add(ActionFactory.instancia().ajudamates());
  JMenuItem menuitemabout = menuajuda.add(ActionFactory.instancia().about());


  public BarraMenu()
  {
    this.add(menuarxiu);
    this.add(menueditar);
    this.add(menumode);
    this.add(menueines);
    this.add(menuajuda);

    this.setPreferredSize(new java.awt.Dimension(43, 23));
  }

  public void enableButtons(boolean enable)
  {
   // menuitemopcions.setEnabled(enable);
    menuitemcopiar.setEnabled(enable);
    menuitemiman.setEnabled(enable);
    menuitemzoomplus.setEnabled(enable);
    menuitemzoomminus.setEnabled(enable);
    menuitemimprimir.setEnabled(enable);
    menuitemnavegar.setEnabled(enable);
    menuitemesborrar.setEnabled(enable);
  }
}