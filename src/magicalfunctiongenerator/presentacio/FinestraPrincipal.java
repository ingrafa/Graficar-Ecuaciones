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
import java.awt.*;
import java.util.*;

import javax.swing.*;


public class FinestraPrincipal extends JFrame
{
  public BarraEstat barraestat = new BarraEstat();
  public BarraMenu barramenu = new BarraMenu();
  public BarraEinesPrincipal barraeines = new BarraEinesPrincipal();
  public Escriptori escriptori = new Escriptori();
  public Llegenda llegenda = new Llegenda();

  JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

  private static FinestraPrincipal instancia;

  public static FinestraPrincipal instancia()
  {
    if (instancia == null)
    {
      instancia = new FinestraPrincipal();
    }
    return instancia;
  }

  private FinestraPrincipal()
  {
    super("Magical Function Generator !!!");
    initialize();
  }

  private void initialize()
  {
    // Fent JPanel contentPane = (JPanel)this.getContentPane(); és més eficient
    JPanel contentPane = (JPanel)this.getContentPane();
    split.setLeftComponent(llegenda);
    split.setRightComponent(escriptori);
    split.setDividerSize(12);
    split.setDividerLocation(150);
    split.setLastDividerLocation(300);

    contentPane.add(barraeines, BorderLayout.NORTH);
    contentPane.add(barraestat, BorderLayout.SOUTH);
    contentPane.add(split, BorderLayout.CENTER);

    this.setJMenuBar(barramenu);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    PopurriUtils.instancia().maximitzar(this);
    this.setVisible(true);
  }

  public void setMode(int mode)
  {
    escriptori.setModeCanvas(mode);
  }

  public LinkedList getObservadors()
  {
    LinkedList observers = new LinkedList();
    observers.add(escriptori);
    observers.add(llegenda);

    return observers;
  }
}
