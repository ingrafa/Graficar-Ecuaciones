/**
 * Magical Function Generator
 *
 * @author Marc Oliveras Galvez <oligalma@gmail.com> 
 * @link http://www.oligalma.com
 * @copyright 2016 Oligalma
 * @license GPL License v3
 */

package magicalfunctiongenerator.presentacio;

import magicalfunctiongenerator.aplicacio.*;
import magicalfunctiongenerator.utils.*;
import java.awt.event.*;

import javax.swing.*;

public class ActionFactory
{
  private static ActionFactory instancia;

  // No es pot instanciar!!
  private ActionFactory()
  {}

  public static ActionFactory instancia()
  {
    if (instancia == null)
    {
      instancia = new ActionFactory();
    }
    return instancia;
  }

  // MENÚ ARXIU....................................................
  public Action novaFuncio()
  {
    AbstractAction a = new AbstractAction("New function...", PopurriUtils.instancia().getImageIcon("chart.png"))
    {
      public void actionPerformed(ActionEvent e)
      {
        FinestraNovaFuncio.instancia().setVisible(true);
      }
    };
    return a;
  }

  public Action guardar()
  {
    AbstractAction a = new AbstractAction("Save workspace...", PopurriUtils.instancia().getImageIcon("floppy.gif"))
    {
      public void actionPerformed(ActionEvent e)
      {
        FinestraNovaFuncio.instancia().setVisible(true);
      }
    };
    return a;
  }

  public Action configurar()
  {
    AbstractAction a = new AbstractAction("Settings...", PopurriUtils.instancia().getImageIcon("wrench.gif"))
    {
      public void actionPerformed(ActionEvent e)
      {
        magicalfunctiongenerator.presentacio.configuracions.FinestraConfigurar.instancia().setVisible(true);
      }
    };
    return a;
  }


  public Action impressora()
  {
    AbstractAction a = new AbstractAction("Print...", PopurriUtils.instancia().getImageIcon("printer.png"))
    {
      public void actionPerformed(ActionEvent e)
      {
        Impressora.instancia().imprimir(FinestraPrincipal.instancia().escriptori.getSelectedFrame());
      }
    };
    a.setEnabled(false);

    return a;
  }

  public Action sortir()
  {
    AbstractAction a = new AbstractAction("Exit", PopurriUtils.instancia().getImageIcon("door.png"))
    {
      public void actionPerformed(ActionEvent e)
      {
        System.exit(0);
      }
    };

    return a;
  }

  // MENÚ EDITAR.................................................
  public Action opcions()
  {
    AbstractAction a = new AbstractAction("Graphic properties...", PopurriUtils.instancia().getImageIcon("palette.gif"))
    {
      public void actionPerformed(ActionEvent e)
      {
         magicalfunctiongenerator.presentacio.propietatsgrafica.FinestraPropietatsGrafica.instancia().setVisible(true);
      }
    };
    a.setEnabled(false);

    return a;
  }

  public Action esborrar()
  {
    AbstractAction a = new AbstractAction("Delete graphic", PopurriUtils.instancia().getImageIcon("trash.png"))
    {
      public void actionPerformed(ActionEvent e)
      {
        try
        {
          GestorDeCanvis.instancia().removeGrafica(FinestraPrincipal.instancia().escriptori.getSelectedFrame().getTitle());
        }
        catch (Exception k)
        {}
      }

    };
    a.setEnabled(false);

    return a;
  }

  public Action copiar()
  {
    AbstractAction a = new AbstractAction("Copy graphic", PopurriUtils.instancia().getImageIcon("copy.png"))
    {
      public void actionPerformed(ActionEvent e)
      {
        Portapapers.instancia().copiarComponent(FinestraPrincipal.instancia().escriptori.getSelectedFrame());
      }

    };
    a.setEnabled(false);

    return a;
  }

  // MENÚ MODE..........................................................
  public Action navegar()
  {
    AbstractAction a = new AbstractAction("Surf mode", PopurriUtils.instancia().getImageIcon("ship.png"))
    {
      public void actionPerformed(ActionEvent e)
      {
        FinestraPrincipal.instancia().setMode(CanvasGrafica.MODE_SURF);
      }
    };
    a.setEnabled(false);

    return a;
  }

  public Action zoomPlus()
  {
    AbstractAction a = new AbstractAction("Zoom in mode", PopurriUtils.instancia().getImageIcon("zoom_in.png"))
    {
      public void actionPerformed(ActionEvent e)
      {
        FinestraPrincipal.instancia().setMode(CanvasGrafica.MODE_ZOOM_PLUS);
      }
    };
    a.setEnabled(false);

    return a;
  }

  public Action zoomMinus()
  {
    AbstractAction a = new AbstractAction("Zoom out mode", PopurriUtils.instancia().getImageIcon("zoom_out.png"))
    {
      public void actionPerformed(ActionEvent e)
      {
        FinestraPrincipal.instancia().setMode(CanvasGrafica.MODE_ZOOM_MINUS);
      }

    };
    a.setEnabled(false);

    return a;
  }

  public Action iman()
  {
    AbstractAction a = new AbstractAction("Magnet mode", PopurriUtils.instancia().getImageIcon("magnet.png"))
    {
      public void actionPerformed(ActionEvent e)
      {
        FinestraPrincipal.instancia().setMode(CanvasGrafica.MODE_IMANT);
      }

    };
    a.setEnabled(false);

    return a;
  }

  // MENÚ EINES........................................................
  public Action calculadora()
  {
    AbstractAction a = new AbstractAction("Calculator", PopurriUtils.instancia().getImageIcon("calculator.png"))
    {
      public void actionPerformed(ActionEvent e)
      {
        Calculadora.mostrarCalculadora();
      }

    };
    return a;
  }

  public Action keyboard()
  {
    AbstractAction a = new AbstractAction("Mathematical keyboard", PopurriUtils.instancia().getImageIcon("keyboard.gif"))
    {
      public void actionPerformed(ActionEvent e)
      {
        MathKeyboard.mostrarKeyboard();
      }

    };
    return a;
  }

  public Action constants()
  {
    AbstractAction a = new AbstractAction("Constants generator", PopurriUtils.instancia().getImageIcon("abc.gif"))
    {
      public void actionPerformed(ActionEvent e)
      {
        ConstantFactory.mostrarConstantFactory();
      }

    };
    return a;
  }

  // MENÚ AJUDA.........................................................
  public Action ajuda()
  {
    AbstractAction a = new AbstractAction("Help", PopurriUtils.instancia().getImageIcon("help.png"))
    {
      public void actionPerformed(ActionEvent e)
      {
        ConstantFactory.mostrarConstantFactory();
      }

    };
    return a;
  }

  public Action ajudamates()
  {
    AbstractAction a = new AbstractAction("Math lesson", PopurriUtils.instancia().getImageIcon("matematicas.gif"))
    {
      public void actionPerformed(ActionEvent e)
      {
        ConstantFactory.mostrarConstantFactory();
      }

    };
    return a;
  }

  public Action about()
  {
    AbstractAction a = new AbstractAction("About...", PopurriUtils.instancia().getImageIcon("help.png"))
    {
      public void actionPerformed(ActionEvent e)
      {
        FinestraAbout.mostrarAbout();
      }

    };
    return a;
  }
}
