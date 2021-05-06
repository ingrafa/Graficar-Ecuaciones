/**
 * Magical Function Generator
 *
 * @author Marc Oliveras Galvez <oligalma@gmail.com> 
 * @link http://www.oligalma.com
 * @copyright 2016 Oligalma
 * @license GPL License v3
 */

package magicalfunctiongenerator.presentacio.propietatsgrafica;

import magicalfunctiongenerator.aplicacio.*;
import magicalfunctiongenerator.utils.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

public class TabFuncio extends JPanel
{
  PopurriUtils pop = PopurriUtils.instancia();
  JButton buttoncolor = new JButton();
  JCheckBox jCheckBox1 = new JCheckBox();
  JComboBox combofuncions = new JComboBox();
  JCheckBox jCheckBox2 = new JCheckBox();
  JCheckBox jCheckBox3 = new JCheckBox();
  JCheckBox jCheckBox4 = new JCheckBox();
  JCheckBox jCheckBox5 = new JCheckBox();
  JLabel labelcolor = new JLabel();
  //String funcio;

  TitledBorder titledBorder3;
  Border border3;
  JPanel jPanel1 = new JPanel();

  public TabFuncio()
  {

    initialize();
  }

  private void initialize()
  {
    border3 = BorderFactory.createCompoundBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, Color.white, new Color(134, 134, 134)), "Color"), BorderFactory.createEmptyBorder(6, 6, 6, 6));
    buttoncolor.setBounds(new Rectangle(140, 22, 114, 28));
    buttoncolor.setText("Canviar Color");
    /*buttoncolor.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        Color c = JColorChooser.showDialog(FinestraPropietatsGrafica.instancia(), "Color de la funció", Color.blue);
        GestorDeCanvis.instancia().setColor(funcio, (String)combofuncions.getSelectedItem(), c);
        labelcolor.setBackground(c);
      }
    });*/

    /*combofuncions.addItemListener(new ItemListener()
    {
      public void itemStateChanged(ItemEvent e)
      {
        funcio = (String)combofuncions.getSelectedItem();
        //labelcolor.setBackground(funcio.getColor());
      }
    });*/


    this.setPreferredSize(new Dimension(400, 300));
    this.setLayout(null);
    jCheckBox1.setSelected(true);
    jCheckBox1.setText("Mostrar funció");
    jCheckBox1.setBounds(new Rectangle(95, 60, 163, 30));
    combofuncions.setEditable(true);
    combofuncions.setBounds(new Rectangle(89, 20, 168, 28));
    jCheckBox2.setSelected(true);
    jCheckBox2.setText("Mostrar asímptotes");
    jCheckBox2.setBounds(new Rectangle(92, 175, 150, 19));
    jCheckBox3.setSelected(true);
    jCheckBox3.setText("Senyalar màxims");
    jCheckBox3.setBounds(new Rectangle(93, 200, 170, 20));
    jCheckBox4.setSelected(true);
    jCheckBox4.setText("Senyalar mínims");
    jCheckBox4.setBounds(new Rectangle(94, 224, 155, 20));
    jCheckBox5.setSelected(true);
    jCheckBox5.setText("Senyalar punts d\'inflexió");
    jCheckBox5.setBounds(new Rectangle(93, 251, 170, 22));
    labelcolor.setBorder(BorderFactory.createEtchedBorder());
    labelcolor.setText("");
    labelcolor.setOpaque(true);
    labelcolor.setBounds(new Rectangle(29, 24, 94, 24));
    jPanel1.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(Color.white, new Color(134, 134, 134)), "Color"));
    jPanel1.setBounds(new Rectangle(72, 97, 274, 68));
    jPanel1.setLayout(null);
    this.add(jCheckBox5, null);
    this.add(jCheckBox4, null);
    this.add(jCheckBox3, null);
    this.add(jCheckBox2, null);
    this.add(combofuncions, null);
    this.add(jCheckBox1, null);
    this.add(jPanel1, null);
    jPanel1.add(buttoncolor, null);
    jPanel1.add(labelcolor, null);
    //setGrup();
  }

  /*public void setGrup()
  {
    ListIterator list = null; // = GestorDeCanvis.instancia().getFuncions();
//    while(list.hasNext())
    //    combofuncions.addItem(list.next());
  }*/
}
