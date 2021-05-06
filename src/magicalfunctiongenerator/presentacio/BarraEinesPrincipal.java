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

import javax.swing.*;

public class BarraEinesPrincipal extends JToolBar
{
  private JButton buttonnova;
  private JToggleButton buttonnavegar = new JToggleButton(ActionFactory.instancia().navegar());
  private JToggleButton buttonzoomplus = new JToggleButton(ActionFactory.instancia().zoomPlus());
  private JToggleButton buttonzoomminus = new JToggleButton(ActionFactory.instancia().zoomMinus());
  private JToggleButton buttoniman = new JToggleButton(ActionFactory.instancia().iman());

  private JButton buttoncopiar;
  private JButton buttoncalculadora;
  private JButton buttonimpressora;
  private JButton buttonkeyboard;
  private ButtonGroup grup = new ButtonGroup();

  public BarraEinesPrincipal()
  {
    grup.add(buttonnavegar);
    grup.add(buttonzoomplus);
    grup.add(buttonzoomminus);
    grup.add(buttoniman);

    BoxLayout box = new BoxLayout(this, BoxLayout.X_AXIS);
    this.setLayout(box);

    // Arxiu
    buttonnova = this.add(ActionFactory.instancia().novaFuncio());
    buttonimpressora = this.add(ActionFactory.instancia().impressora());

    this.addSeparator();

    // Editar
    buttoncopiar = this.add(ActionFactory.instancia().copiar());

    this.addSeparator();

    // Modes
    this.add(buttonnavegar);
    this.add(buttonzoomplus);
    this.add(buttonzoomminus);
    this.add(buttoniman);

    this.addSeparator();

    // Eines
    buttoncalculadora = this.add(ActionFactory.instancia().calculadora());
    //buttonkeyboard = this.add(ActionFactory.instancia().keyboard());


    buttonnova.setToolTipText("New graphic...");
    buttonnavegar.setToolTipText("Surf mode");
    buttonzoomplus.setToolTipText("Zoom in mode");
    buttonzoomminus.setToolTipText("Zoom out mode");
    buttoniman.setToolTipText("Magnet mode");
    buttoncopiar.setToolTipText("Copy");
    buttoncalculadora.setToolTipText("Calculator");
    buttonimpressora.setToolTipText("Print");
   // buttonkeyboard.setToolTipText("Teclat matemàtic");

    buttonnavegar.setSelected(true);
    buttonnavegar.setText("");
    buttonzoomplus.setText("");
    buttonzoomminus.setText("");
    buttoniman.setText("");

    this.setOpaque(true);
    this.setFloatable(false);
    this.setBorderPainted(true);
    this.setSize(100, 50);
    this.setPreferredSize(new java.awt.Dimension(4, 60));
  }

  public void addSeparator()
  {
    ImageIcon separator = PopurriUtils.instancia().getImageIcon("ball4.gif");
    this.add(new JLabel(separator));
  }

  public void enableButtons(boolean enable)
  {
    buttonnavegar.setEnabled(enable);
    buttoncopiar.setEnabled(enable);
    buttoniman.setEnabled(enable);
    buttonzoomplus.setEnabled(enable);
    buttonzoomminus.setEnabled(enable);
    buttonimpressora.setEnabled(enable);
  }
}
