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
import magicalfunctiongenerator.utils.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.*;
import javax.swing.border.*;

public class TabAparencia extends JPanel
{
  JTextField textimatge = new JTextField();
  JPanel panelimatge = new JPanel();
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;
  JButton buttonimatge = new JButton();
  PopurriUtils pop = PopurriUtils.instancia();
  JComboBox comboimatge = new JComboBox();
  JCheckBox jCheckBox1 = new JCheckBox();

  public TabAparencia()
  {
    this.setPreferredSize(new Dimension(520, 333));
    initialize();
  }

  private void initialize()
  {
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white, new Color(134, 134, 134)), "Imatge de Fons");
    textimatge.setText("");
    textimatge.setEditable(false);
    textimatge.setBounds(new Rectangle(65, 27, 174, 30));
    this.setLayout(null);
    panelimatge.setBorder(titledBorder2);
    panelimatge.setBounds(new Rectangle(44, 39, 294, 141));
    panelimatge.setLayout(null);
    buttonimatge.setBounds(new Rectangle(21, 28, 31, 26));
    buttonimatge.setText("...");
    comboimatge.addItemListener(new ItemListener()
    {
      public void itemStateChanged(ItemEvent e)
      {
        FinestraPrincipal.instancia().escriptori.setModeImatge(comboimatge.getSelectedIndex());
      }
    });
    buttonimatge.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Escull una imatge");
        chooser.removeChoosableFileFilter(chooser.getAcceptAllFileFilter());
        chooser.setAccessory(new ImagePreview(chooser));
        chooser.setFileView(new ImageFileView());
        chooser.addChoosableFileFilter(new ImageFilter());

        if (chooser.showOpenDialog(FinestraConfigurar.instancia()) == JFileChooser.APPROVE_OPTION)
        {
          File file = chooser.getSelectedFile();
          try
          {
            Image im = PopurriUtils.instancia().getImage(file.toURL());
            textimatge.setText(file.toString());
            FinestraPrincipal.instancia().escriptori.setImatge(im);
          }
          catch (MalformedURLException z)
          {}

        }
      }
    });
    comboimatge.setBounds(new Rectangle(34, 86, 158, 29));
    comboimatge.addItem("Centrada");
    comboimatge.addItem("Mosaic");
    comboimatge.addItem("Estesa");
    comboimatge.setSelectedItem("Estesa");
    jCheckBox1.setSelected(true);
    jCheckBox1.setText("Usar Look & Feel");
    jCheckBox1.setBounds(new Rectangle(59, 204, 135, 27));
    panelimatge.add(buttonimatge, null);
    panelimatge.add(textimatge, null);
    panelimatge.add(comboimatge, null);
    this.add(jCheckBox1, null);
    this.add(panelimatge, null);
  }
}
