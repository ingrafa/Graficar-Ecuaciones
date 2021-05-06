/**
 * Magical Function Generator
 *
 * @author Marc Oliveras Galvez <oligalma@gmail.com> 
 * @link http://www.oligalma.com
 * @copyright 2016 Oligalma
 * @license GPL License v3
 */

package magicalfunctiongenerator.presentacio;

import magicalfunctiongenerator.utils.*;
import org.nfunk.jep.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;

public class Calculadora extends JDialog
{
  JTextField textexpressio = new JTextField();
  JLabel jLabel1 = new JLabel();
  JLabel labelresultat = new JLabel();
  JTextField textresultat = new JTextField();
  JEP parser = new JEP();
  private static Calculadora instancia;

  public static void mostrarCalculadora()
  {
    if (instancia == null)
    {
      instancia = new Calculadora();
    }
    else
    {
      instancia.setVisible(true);
    }
  }

  public Calculadora()
  {
    super(FinestraPrincipal.instancia(), "Calculator");
    parser.addStandardConstants();
    parser.addStandardFunctions();
    parser.setImplicitMul(true);

    initialize();
  }

  public void initialize()
  {
    textresultat.setEditable(false);
    textexpressio.setScrollOffset(10);
    textexpressio.setText("");
    textexpressio.setBounds(new Rectangle(38, 32, 172, 32));

    textexpressio.addCaretListener(new CaretListener()
    {
      public void caretUpdate(CaretEvent e)
      {
        parser.parseExpression(textexpressio.getText());
        if (parser.hasError())
        {
          textexpressio.setForeground(Color.RED);
        }
        else
        {
          textexpressio.setForeground(Color.BLACK);
          textresultat.setText(parser.getValue() + "");
        }
      }
    });

    jLabel1.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1.setText("Expression");
    jLabel1.setBounds(new Rectangle(80, 0, 93, 28));
    labelresultat.setFont(new java.awt.Font("Dialog", 1, 12));
    labelresultat.setText("Result");
    labelresultat.setBounds(new Rectangle(96, 76, 56, 31));
    textresultat.setText("");
    textresultat.setBounds(new Rectangle(38, 105, 171, 33));


    this.getContentPane().add(textexpressio, null);
    this.getContentPane().add(textresultat, null);
    this.getContentPane().add(labelresultat, null);
    this.getContentPane().add(jLabel1, null);

    this.setTitle("Calculator");
    this.setSize(new Dimension(250, 183));
    this.setResizable(false);
    this.getContentPane().setLayout(null);
    PopurriUtils.instancia().centrarPantalla(this);
    this.setVisible(true);
  }
}
