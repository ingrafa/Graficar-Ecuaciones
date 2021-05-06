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


public class TabEixos extends JPanel
{
  PopurriUtils pop = PopurriUtils.instancia();
  JButton buttoncolor = new JButton();
  JRadioButton jRadioButton1 = new JRadioButton();
  JRadioButton jRadioButton2 = new JRadioButton();
  JTextField jTextField1 = new JTextField();
  JLabel jLabel1 = new JLabel();
  JCheckBox jCheckBox1 = new JCheckBox();
  JCheckBox jCheckBox2 = new JCheckBox();
  JCheckBox jCheckBox3 = new JCheckBox();

  public TabEixos()
  {

    initialize();
  }

  private void initialize()
  {
    buttoncolor.setBounds(new Rectangle(85, 65, 126, 44));
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
    jRadioButton1.setText("Eix X");
    jRadioButton1.setBounds(new Rectangle(53, 23, 135, 24));
    jRadioButton2.setText("Eix Y");
    jRadioButton2.setBounds(new Rectangle(211, 23, 129, 22));
    jTextField1.setText("10");
    jTextField1.setBounds(new Rectangle(171, 137, 80, 27));
    jLabel1.setText("Divisions");
    jLabel1.setBounds(new Rectangle(80, 136, 62, 31));
    jCheckBox1.setSelected(true);
    jCheckBox1.setText("Mostrar Eix");
    jCheckBox1.setBounds(new Rectangle(81, 183, 178, 24));
    jCheckBox2.setSelected(true);
    jCheckBox2.setText("Mostrar Ticks");
    jCheckBox2.setBounds(new Rectangle(81, 213, 174, 24));
    jCheckBox3.setSelected(true);
    jCheckBox3.setText("Mostrar Numeració");
    jCheckBox3.setBounds(new Rectangle(80, 239, 155, 27));
    this.add(jRadioButton2, null);
    this.add(buttoncolor, null);
    this.add(jTextField1, null);
    this.add(jLabel1, null);
    this.add(jRadioButton1, null);
    this.add(jCheckBox1, null);
    this.add(jCheckBox2, null);
    this.add(jCheckBox3, null);
  }
}