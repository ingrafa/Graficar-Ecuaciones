/**
 * Magical Function Generator
 *
 * @author Marc Oliveras Galvez <oligalma@gmail.com> 
 * @link http://www.oligalma.com
 * @copyright 2016 Oligalma
 * @license GPL License v3
 */

package magicalfunctiongenerator.presentacio.propietatsgrafica;

import magicalfunctiongenerator.utils.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TabGraella extends JPanel
{
  PopurriUtils pop = PopurriUtils.instancia();
  JButton buttoncolor = new JButton();
  JRadioButton jRadioButton1 = new JRadioButton();
  JRadioButton jRadioButton2 = new JRadioButton();
  JTextField jTextField1 = new JTextField();
  JLabel jLabel1 = new JLabel();
  JCheckBox jCheckBox4 = new JCheckBox();

  public TabGraella()
  {

    initialize();
  }

  private void initialize()
  {
    buttoncolor.setBounds(new Rectangle(112, 128, 126, 44));
    buttoncolor.setText("Color");
    buttoncolor.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        JColorChooser.showDialog(FinestraPropietatsGrafica.instancia(), "Color dels eixos", Color.blue);
      }
    });
    this.setPreferredSize(new Dimension(400, 300));
    this.setLayout(null);
    jRadioButton1.setSelected(true);
    jRadioButton1.setText("Linies Horitzontals");
    jRadioButton1.setBounds(new Rectangle(42, 43, 135, 24));
    jRadioButton2.setText("Linies Verticals");
    jRadioButton2.setBounds(new Rectangle(220, 43, 129, 22));
    jTextField1.setText("10");
    jTextField1.setBounds(new Rectangle(195, 189, 80, 27));
    jLabel1.setText("Divisions");
    jLabel1.setBounds(new Rectangle(110, 184, 62, 31));
    jCheckBox4.setSelected(true);
    jCheckBox4.setText("Mostrar Graella");
    jCheckBox4.setBounds(new Rectangle(101, 88, 170, 21));
    this.add(jRadioButton1, null);
    this.add(jTextField1, null);
    this.add(buttoncolor, null);
    this.add(jCheckBox4, null);
    this.add(jLabel1, null);
        this.add(jRadioButton2, null);
  }
}
