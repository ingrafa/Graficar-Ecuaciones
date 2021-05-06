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
import java.awt.event.*;
import java.text.*;
import java.util.*;

import javax.swing.*;
import javax.swing.Timer;

public class Rellotge extends JLabel implements ActionListener
{
  public Rellotge()
  {
    initialize();
  }

  private void initialize()
  {
    Timer t = new Timer(1000, this);
    t.start();

    this.setBackground(new Color(203, 255, 236));
    this.setFont(new java.awt.Font("Arial", Font.PLAIN, 14));
    this.setHorizontalAlignment(JLabel.CENTER);
    this.setBorder(BorderFactory.createLoweredBevelBorder());
    this.setPreferredSize(new Dimension(70, 40));
    this.setSize(new Dimension(70, 30));
    this.setOpaque(true);
  }

  public void actionPerformed(ActionEvent e)
  {
    SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
    Date d = new Date();
    this.setText(format.format(d));
  }
}
