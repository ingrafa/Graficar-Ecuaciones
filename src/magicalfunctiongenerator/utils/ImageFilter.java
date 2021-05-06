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

import javax.swing.filechooser.FileFilter;


public class ImageFilter extends FileFilter
{
  private final String[] EXTENSIONS =
      {"jpeg", "jpg", "gif"};

  public boolean accept(File f)
  {
    if (f.isDirectory())
    {
      return true;
    }

    String s = f.getName();
    int i = s.lastIndexOf('.');


    for (int j = 0; j < EXTENSIONS.length; j++)
    {
      if (PopurriUtils.instancia().getExtension(f).equals(EXTENSIONS[j]))
      {
        return true;
      }
    }


    return false;
  }

  public String getDescription()
  {
    return "Nom�s Imatges";
  }
}
