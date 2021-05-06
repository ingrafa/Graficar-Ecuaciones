/**
 * Magical Function Generator
 *
 * @author Marc Oliveras Galvez <oligalma@gmail.com> 
 * @link http://www.oligalma.com
 * @copyright 2016 Oligalma
 * @license GPL License v3
 */

package magicalfunctiongenerator.utils;

import java.io.*;

import javax.swing.*;
import javax.swing.filechooser.*;


public class ImageFileView extends FileView
{
  ImageIcon jpgIcon = PopurriUtils.instancia().getImageIcon("jpg_file.gif");
  ImageIcon gifIcon = PopurriUtils.instancia().getImageIcon("gif_file.gif");

  public String getName(File f)
  {
    return null; // let the L&F FileView figure this out
  }

  public String getDescription(File f)
  {
    return null; // let the L&F FileView figure this out
  }

  public Boolean isTraversable(File f)
  {
    return null; // let the L&F FileView figure this out
  }

  public String getTypeDescription(File f)
  {
    String extension = PopurriUtils.instancia().getExtension(f);
    String type = null;

    if (extension != null)
    {
      if (extension.equals("jpeg") || extension.equals("jpg"))
      {
        type = "Imatge JPG";
      }
      else if (extension.equals("gif"))
      {
        type = "Imatge GIF";
      }
    }
    return type;
  }

  public Icon getIcon(File f)
  {
    String extension = PopurriUtils.instancia().getExtension(f);
    Icon icon = null;
    if (extension != null)
    {
      if (extension.equals("jpeg") || extension.equals("jpg"))
      {
        icon = jpgIcon;
      }
      else if (extension.equals("gif"))
      {
        icon = gifIcon;
      }
    }
    return icon;
  }
}
