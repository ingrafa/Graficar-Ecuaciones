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
import org.nfunk.jep.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.table.*;


public class FinestraNovaFuncio extends JDialog implements Observer
{
  private static FinestraNovaFuncio instancia;
  private JPanel contentPane = new JPanel();
  private JPanel panelgenerar = new JPanel();
  private JRadioButton radiocadena = new JRadioButton();
  private JRadioButton radiotaula = new JRadioButton();
  private JTextField textcadena = new JTextField("x^2");
  private ButtonGroup grafica = new ButtonGroup();
  private JTable taula = new JTable();
  private JScrollPane scroll = new JScrollPane();
  private JButton buttonacceptar = new JButton();
  private JButton buttoncancelar = new JButton();
  private JPanel panelgrupfuncions = new JPanel();
  private JComboBox combografica = new JComboBox();
  private JTextField textgrafica = new JTextField();
  private static JEP parser = new JEP();
  private JRadioButton radiograficanova = new JRadioButton();
  private JRadioButton radiograficaexistent = new JRadioButton();
  private ButtonGroup grup2 = new ButtonGroup();
  private ModelTaula model = new ModelTaula();
  private GestorDeCanvis gestorDeCanvis = GestorDeCanvis.instancia();

  private FinestraNovaFuncio()
  {
    super(FinestraPrincipal.instancia(), "New function...");
    parser.addVariable("x", 0);
    parser.setImplicitMul(true);
    parser.addStandardFunctions();
    parser.addStandardConstants();
    initialize();
  }

  public static FinestraNovaFuncio instancia()
  {
    if (instancia == null)
    {
      instancia = new FinestraNovaFuncio();
    }
    return instancia;
  }

  private void initialize()
  {
    buttonacceptar.setBounds(new Rectangle(50, 416, 109, 27));
    buttonacceptar.setText("Accept");
    buttonacceptar.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        validar();
      }
    });
    buttoncancelar.setText("Close");
    buttoncancelar.setBounds(new Rectangle(162, 416, 109, 27));
    buttoncancelar.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        tancar();
      }
    });

    radiotaula.setBounds(new Rectangle(41, 91, 123, 24));
    radiocadena.setBounds(new Rectangle(41, 27, 158, 21));
    textcadena.setBounds(new Rectangle(23, 52, 205, 24));
    panelgrupfuncions.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(Color.white, new Color(134, 134, 134)), "Add function to..."));
    panelgrupfuncions.setBounds(new Rectangle(37, 243, 251, 156));
    panelgrupfuncions.setLayout(null);
    combografica.setBounds(new Rectangle(56, 114, 134, 22));
    combografica.setEnabled(false);
    textgrafica.setText("Graphic " + gestorDeCanvis.getNumeroGrafiquesCreades());
    textgrafica.setBounds(new Rectangle(28, 50, 199, 24));
    scroll.setBorder(BorderFactory.createLineBorder(Color.black));
    scroll.setBounds(new Rectangle(51, 117, 109, 78));
    scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    radiograficanova.setSelected(true);

    radiograficanova.addItemListener(new ItemListener()
    {
      public void itemStateChanged(ItemEvent e)
      {
        textgrafica.setEnabled(radiograficanova.isSelected());
      }
    });

    radiograficanova.setText("New graphic");
    radiograficanova.setBounds(new Rectangle(29, 26, 158, 21));
    radiograficaexistent.setBounds(new Rectangle(42, 90, 169, 21));
    radiograficaexistent.setText("Existing graphic");
    radiograficaexistent.setEnabled(false);
    radiograficaexistent.addItemListener(new ItemListener()
    {
      public void itemStateChanged(ItemEvent e)
      {
        combografica.setEnabled(radiograficaexistent.isSelected());
      }
    });
    panelgenerar.add(radiocadena, null);
    panelgenerar.add(radiotaula, null);
    panelgenerar.add(scroll);
    panelgenerar.add(textcadena);
    contentPane.add(panelgrupfuncions, null);
    panelgrupfuncions.add(radiograficanova, null);
    panelgrupfuncions.add(textgrafica, null);
    panelgrupfuncions.add(radiograficaexistent, null);
    panelgrupfuncions.add(combografica, null);
    contentPane.add(panelgenerar, null);
    contentPane.add(buttonacceptar, null);
    contentPane.add(buttoncancelar, null);

    radiocadena.setSelected(true);
    radiocadena.setSize(158, 21);
    radiocadena.setLocation(41, 29);
    radiocadena.setText("String");
    radiocadena.addItemListener(new ItemListener()
    {
      public void itemStateChanged(ItemEvent e)
      {
        textcadena.setEnabled(radiocadena.isSelected());
      }
    });

    radiotaula.addItemListener(new ItemListener()
    {
      public void itemStateChanged(ItemEvent e)
      {
        taula.setEnabled(radiotaula.isSelected());
        scroll.setEnabled(radiotaula.isSelected());
        model.setEditable(radiotaula.isSelected());
      }
    });

    radiotaula.setText("Values table");
    grafica.add(radiocadena);
    grafica.add(radiotaula);

    taula = new JTable(model);
    taula.addMouseListener(new MouseAdapter()
    {
      public void mousePressed(MouseEvent e)
      {
        radiotaula.setSelected(true);
      }
    });

    textcadena.addMouseListener(new MouseAdapter()
    {
      public void mousePressed(MouseEvent e)
      {
        radiocadena.setSelected(true);
      }
    });


    taula.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent e)
      {
        if (e.getKeyChar() == e.VK_DELETE)
        {
          model.deleteRows(taula.getSelectedRows());
        }
      }
    });
    model.setEditable(false);

    scroll.getViewport().setView(taula);
    scroll.setBackground(java.awt.Color.white);
    scroll.setEnabled(false);

    textcadena.setSize(205, 27);
    textcadena.setLocation(27, 56);

    textcadena.addCaretListener(new CaretListener()
    {
      public void caretUpdate(CaretEvent e)
      {
        parser.parseExpression(textcadena.getText());
        if (parser.hasError())
        {
          textcadena.setForeground(Color.RED);
        }
        else
        {
          textcadena.setForeground(Color.BLACK);
        }
      }
    });

    panelgenerar.setBounds(new Rectangle(36, 27, 251, 207));
    panelgenerar.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(Color.white, new Color(134, 134, 134)), "Generate function from..."));
    panelgenerar.setLayout(null);

    this.getContentPane().add(contentPane, null);
    contentPane.setLayout(null);
    contentPane.setBackground(Color.white);

    this.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
    this.setResizable(false);
    this.setSize(new Dimension(320, 492));
    this.setLocation(this.getParent().getWidth() - this.getWidth() - 10, this.getParent().getHeight() / 2 - this.getHeight() / 2);
    this.setVisible(true);
    grup2.add(radiograficaexistent);
    grup2.add(radiograficanova);
  }

  private void validar()
  {
    String funcio = "";
    float[][] valors = null;

    // Crea la funció a partir d'una cadena de caràcters.
    if (radiocadena.isSelected())
    {
      funcio = textcadena.getText();
      // Crea la funció a partir de la taula de valors.
    }
    else
    {
      valors = model.getXYValues();

    }
    String grafica = "";

    // Crea una nova gràfica.
    if (radiograficanova.isSelected())
    {
      grafica = textgrafica.getText();
      try
      {
        LinkedList list = FinestraPrincipal.instancia().getObservadors();
        list.add(this);
        gestorDeCanvis.addGrafica(grafica, list, -10, 10, -10, 10, 0, 400, 0, 300);
      }
      catch (Exception e)
      {
        PopurriUtils.mostrarMissatgeError(this, e.getMessage());
        return;
      }
    }
    // Obté un grafica de funcions existent.
    else
    {
      grafica = (String)combografica.getSelectedItem();

      // Crea la funció.
    }
    try
    {
      if (radiocadena.isSelected())
      {
        gestorDeCanvis.addFuncio(funcio, grafica);
      }
      else
      {
        gestorDeCanvis.addFuncio(valors[0], valors[1], grafica);
      }
    }
    catch (Exception e)
    {
      if (radiograficanova.isSelected())
      {
        try
        {
          gestorDeCanvis.removeGrafica(grafica);
        }
        catch (Exception e2)
        {}
      }
      PopurriUtils.mostrarMissatgeError(this, e.getMessage());
      return;
    }

    if (radiograficanova.isSelected())
    {
      gestorDeCanvis.setNotificar(grafica, true);
      gestorDeCanvis.notificar(grafica, GestorDeCanvis.GRAFICA_CREADA);
      gestorDeCanvis.notificar(grafica, GestorDeCanvis.FUNCIO_CREADA);
    }
  }

  public void update(Observable o, Object arg)
  {
    int canvi = ((Integer)arg).intValue();

    switch (canvi)
    {
      case GestorDeCanvis.GRAFICA_CREADA:
        textgrafica.setText("Graphic " + gestorDeCanvis.getNumeroGrafiquesCreades());
        combografica.addItem(o.toString());
        radiograficaexistent.setEnabled(true);
        break;
      case GestorDeCanvis.GRAFICA_ESBORRADA:
        combografica.removeItem(o.toString());
        if (combografica.getItemCount() == 0)
        {
          radiograficaexistent.setEnabled(false);
          radiograficanova.setSelected(true);
        }
        break;
    }
  }

  private void tancar()
  {
    this.setVisible(false);
  }

  private class ModelTaula extends AbstractTableModel
  {
    private static final int XCOLUMN = 0;
    private static final int YCOLUMN = 1;
    private String[] header =
        {"X", "Y"};
    private LinkedList data = new LinkedList();
    private boolean editable = false;

    public ModelTaula()
    {
      data.add(new Punt());
    }

    public Object getValueAt(int row, int col)
    {
      Punt c = (Punt)data.get(row);
      if (col == XCOLUMN)
      {
        return c.getX();
      }
      else
      {
        return c.getY();
      }
    }

    public int getColumnCount()
    {
      return 2;
    }

    public String getColumnName(int col)
    {
      return header[col];
    }

    public boolean isCellEditable(int row, int col)
    {
      return editable;
    }

    public void setEditable(boolean editable)
    {
      this.editable = editable;
    }

    public void deleteRows(int[] rows)
    {
      for (int i = rows.length - 1; i >= 0; i--)
      {
        data.remove(rows[i]);
        this.fireTableRowsDeleted(rows[i], rows[i]);
      }

      if (data.size() == 0)
      {
        data.add(new Punt());
      }
    }

    public int getRowCount()
    {
      return data.size();
    }

    public Class getColumnClass(int column)
    {
      return "".getClass();
    }

    public float[][] getXYValues()
    {
      LinkedList list2 = new LinkedList();
      ListIterator list = data.listIterator();

      while (list.hasNext())
      {
        Punt c = (Punt)list.next();
        if (c.getX() != null && c.getY() != null)
        {
          list2.add(c);
        }
      }

      float[][] f = new float[2][list2.size()];
      for (int i = 0; i < list2.size(); i++)
      {
        Punt c = (Punt)list2.get(i);
        f[0][i] = c.getX().floatValue();
        f[1][i] = c.getY().floatValue();
      }

      return f;
    }

    public void setValueAt(Object value, int row, int col)
    {
      String valor = value.toString();
      Punt c = (Punt)data.get(row);

      if (!valor.equals(""))
      {
        try
        {
          Float f = new Float(valor);
          if (PopurriUtils.xifresDecimals(f.floatValue()) > 6)
          {
            JOptionPane.showMessageDialog(FinestraNovaFuncio.this, "The maximum number of decimals is 6.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
          }

          if (f.floatValue() > gestorDeCanvis.getXifraMaxima() || f.floatValue() < gestorDeCanvis.getXifraMinima())
          {
            JOptionPane.showMessageDialog(FinestraNovaFuncio.this, "The maximum value of a number is " + gestorDeCanvis.getXifraMaxima(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
          }

          if (col == XCOLUMN)
          {
            for (int i = 0; i < data.size(); i++)
            {
              Punt c2 = (Punt)data.get(i);

              if (c2.getX() != null && row != i && c2.getX().equals(f))
              {
                JOptionPane.showMessageDialog(FinestraNovaFuncio.this, "Two identical X values are not allowed: " + f, "Error", JOptionPane.ERROR_MESSAGE);
                return;
              }
            }
            c.setX(f);
          }
          else
          {
            c.setY(f);

          }
          Punt last = (Punt)data.getLast();
          if ((last.getX() != null ^ last.getY() != null))
          {
            data.add(new Punt());
            this.fireTableRowsInserted(data.size(), data.size());
          }
        }
        catch (NumberFormatException e)
        {
          JOptionPane.showMessageDialog(FinestraNovaFuncio.this, "\"" + valor + "\" it is not a numeric value", "Error", JOptionPane.ERROR_MESSAGE);
        }
      }
      else
      {
        if (col == XCOLUMN)
        {
          c.setX(null);
        }
        else
        {
          c.setY(null);
        }
        if (row != data.size() - 1 && c.getX() == null && c.getY() == null)
        {
          data.remove(row);
          this.fireTableRowsDeleted(row, row);
        }
      }
    }

    private class Punt
    {
      private Float x, y;

      public Punt()
      {}

      public Float getX()
      {
        return x;
      }

      public Float getY()
      {
        return y;
      }

      public void setX(Float f)
      {
        x = f;
      }

      public void setY(Float f)
      {
        y = f;
      }

      public boolean equals(Object o)
      {
        if (!(o instanceof Punt))
        {
          return false;
        }

        return ((Punt)o).x.equals(x) && ((Punt)o).y.equals(y);
      }
    }
  }
}
