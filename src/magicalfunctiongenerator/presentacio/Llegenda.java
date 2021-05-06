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
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;


public class Llegenda extends JScrollPane implements TreeSelectionListener, Observer
{
  private JTree tree = new JTree();
  private ModelArbre model;
  private final String ARREL = "GRAPHICS..........";
  private TreeSelectionEvent event;
  private JPopupMenu pop = new JPopupMenu();
  JMenuItem menuitemopcions = pop.add(ActionFactory.instancia().opcions());

  public Llegenda()
  {
    try
    {
      jbInit();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception
  {
    update(null, null);
    tree.setExpandsSelectedPaths(true);
    tree.addTreeSelectionListener(this);
    tree.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent e)
      {
        if (e.getKeyCode() == e.VK_DELETE)
        {
          Object o = event.getPath().getLastPathComponent();
          if (GestorDeCanvis.instancia().existeix(o.toString()))
          {
            try
            {
              GestorDeCanvis.instancia().removeGrafica(o.toString());
            }
            catch (Exception k)
            {}
          }
          else
          {
            try
            {
              GestorDeCanvis.instancia().removeFuncio(o.toString(), event.getPath().getParentPath().getLastPathComponent().toString());
            }
            catch (Exception k)
            {}
          }
          tree.setSelectionRow(0);
        }
      }
    });

    this.getViewport().setView(tree);
  }

  public void valueChanged(TreeSelectionEvent e)
  {
    event = e;
  }

  private class ModelArbre implements TreeModel
  {
    public ModelArbre()
    {

    }

    public void addTreeModelListener(TreeModelListener l)
    {

    }

    public Object getChild(Object parent, int index)
    {
      if (parent.equals(getRoot()))
      {
        return GestorDeCanvis.instancia().getGraficaIndex(index);
      }
      else
      {
        return GestorDeCanvis.instancia().getFuncioIndex(index, parent.toString());
      }
    }

    public int getChildCount(Object parent)
    {
      if (parent.equals(getRoot()))
      {
        return GestorDeCanvis.instancia().getNumeroGrafiques();
      }
      else
      {
        return GestorDeCanvis.instancia().getNumeroFuncionsGrafica(parent.toString());
      }
    }

    public int getIndexOfChild(Object parent, Object child)
    {
      if (parent.equals(getRoot()))
      {
        return GestorDeCanvis.instancia().getIndexGrafica(child.toString());
      }
      else
      {
        return GestorDeCanvis.instancia().getIndexFuncioGrafica(child.toString(), parent.toString());
      }
    }

    public Object getRoot()
    {
      return ARREL + "(" + GestorDeCanvis.instancia().getNumeroGrafiques() + ")";
    }

    public boolean isLeaf(Object node)
    {
      return!GestorDeCanvis.instancia().existeix(node.toString()) && !node.equals(getRoot());
    }

    public void removeTreeModelListener(TreeModelListener l)
    {

    }

    public void valueForPathChanged(TreePath path, Object newValue)
    {

    }
  }

  public void update(Observable o, Object arg)
  {
    //int canvi = ((Integer)arg).intValue();
    model = new ModelArbre();
    tree.setModel(model);
    for (int i = 0; i < tree.getRowCount(); i++)
    {
      tree.expandRow(i);
    }
  }
}
