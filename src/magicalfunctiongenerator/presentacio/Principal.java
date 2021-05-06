/**
 * Magical Function Generator
 *
 * @author Marc Oliveras Galvez <oligalma@gmail.com> 
 * @link http://www.oligalma.com
 * @copyright 2016 Oligalma
 * @license GPL License v3
 */

package magicalfunctiongenerator.presentacio;

// import javax.swing.*;

public class Principal
{
  public static void main(String[] args)
  {
    System.setProperty("RegistreGrafiques", "magicalfunctiongenerator.persistencia.memoria.RegistreGrafiques");
    System.setProperty("RegistreFuncions", "magicalfunctiongenerator.persistencia.memoria.RegistreFuncions");
    System.setProperty("RegistrePunts", "magicalfunctiongenerator.persistencia.memoria.RegistrePunts");

    /*try
    {
      UIManager.setLookAndFeel(new com.birosoft.liquid.LiquidLookAndFeel());
    }
    catch (Exception e)
    {}*/

    Splash s = new Splash();
    FinestraPrincipal.instancia();
    s.dispose();
  }
}
