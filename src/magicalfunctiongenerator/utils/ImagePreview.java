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
import java.beans.*;
import java.io.*;

import javax.swing.*;


public class ImagePreview extends JComponent implements PropertyChangeListener
{
  ImageIcon thumbnail = null;
  File f = null;

  public ImagePreview(JFileChooser fc)
  {
    setPreferredSize(new Dimension(100, 50));
    fc.addPropertyChangeListener(this);
  }

  public void loadImage()
  {
    if (f == null)
    {
      return;
    }

    ImageIcon tmpIcon = new ImageIcon(f.getPath());
    if (tmpIcon.getIconWidth() > 90)
    {
      thumbnail = new ImageIcon(tmpIcon.getImage().getScaledInstance(90, -1, Image.SCALE_DEFAULT));
    }
    else
    {
      thumbnail = tmpIcon;
    }
  }

  public void propertyChange(PropertyChangeEvent e)
  {
    String prop = e.getPropertyName();
    if (prop.equals(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY))
    {
      f = (File)e.getNewValue();
      if (isShowing())
      {
        loadImage();
        repaint();
      }
    }
  }

  public void paintComponent(Graphics g)
  {
    if (thumbnail == null)
    {
      loadImage();
    }
    if (thumbnail != null)
    {
      int x = getWidth() / 2 - thumbnail.getIconWidth() / 2;
      int y = getHeight() / 2 - thumbnail.getIconHeight() / 2;

      if (y < 0)
      {
        y = 0;
      }

      if (x < 5)
      {
        x = 5;
      }
      thumbnail.paintIcon(this, g, x, y);
    }
  }
}
