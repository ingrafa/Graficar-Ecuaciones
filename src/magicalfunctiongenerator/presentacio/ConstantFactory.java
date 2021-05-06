/**
 * Magical Function Generator
 *
 * @author Marc Oliveras Galvez <oligalma@gmail.com> 
 * @link http://www.oligalma.com
 * @copyright 2016 Oligalma
 * @license GPL License v3
 */

package magicalfunctiongenerator.presentacio;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import magicalfunctiongenerator.utils.PopurriUtils;
import javax.swing.*;
import javax.swing.table.*;

public class ConstantFactory extends JDialog
{
  ModelTaula model = new ModelTaula();
  JTable taula = new JTable();
  JScrollPane scroll = new JScrollPane();
  JButton buttoninsertar = new JButton();
  JPanel jPanel1 = new JPanel();
  JTextField textconstant = new JTextField();
  JTextField textvalor = new JTextField();
  private static ConstantFactory instancia;


  private ConstantFactory()
  {
    super(FinestraPrincipal.instancia(), "Constants generator ::::: NOT IMPLEMENTED YET!!");
    initialize();
  }

  public static void mostrarConstantFactory()
  {
    if (instancia == null)
    {
      instancia = new ConstantFactory();
    }
    else
    {
      instancia.setVisible(true);
    }
  }

  public void initialize()
  {
    this.setResizable(false);
    taula = new JTable(model);
    scroll.getViewport().setView(taula);
    scroll.setBounds(new Rectangle(23, 21, 127, 67));

    buttoninsertar.setMargin(new Insets(2, 2, 2, 2));
    buttoninsertar.setText("Insertar");
    buttoninsertar.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        model.setValueAt(textconstant.getText(), model.getRowCount(), 0);
        model.setValueAt(textvalor.getText(), model.getRowCount() - 1, 1);
        model.fireTableRowsInserted(0, 0);
        textconstant.setText("");
        textvalor.setText("");
      }
    });

    jPanel1.setBorder(BorderFactory.createEtchedBorder());
    jPanel1.setBounds(new Rectangle(12, 100, 206, 36));
    textconstant.setPreferredSize(new Dimension(60, 22));
    textconstant.setText("");
    textvalor.setPreferredSize(new Dimension(60, 22));
    textvalor.setText("");


    jPanel1.add(textconstant, null);
    jPanel1.add(textvalor, null);
    jPanel1.add(buttoninsertar, null);
    this.getContentPane().add(scroll);
    this.getContentPane().add(jPanel1, null);

    this.getContentPane().setLayout(null);
    this.setSize(new Dimension(250, 200));
    PopurriUtils.centrarPantalla(this);
    this.setVisible(true);
  }

  private class ModelTaula extends AbstractTableModel
  {
    String[] header =
        {"Variable", "Valor"};
    LinkedList[] data = new LinkedList[2];

    public ModelTaula()
    {
      data[0] = new LinkedList();
      data[1] = new LinkedList();
    }

    public Object getValueAt(int row, int col)
    {
      return data[col].get(row);
    }

    public int getColumnCount()
    {
      return data.length;
    }

    public String getColumnName(int col)
    {
      return header[col];
    }

    public int getRowCount()
    {
      return data[0].size();
    }

    public void setValueAt(Object value, int row, int col)
    {
      data[col].add(row, value);
    }
  }
}
