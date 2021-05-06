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
import magicalfunctiongenerator.utils.PopurriUtils;
import javax.swing.*;


public class MathKeyboard extends JDialog implements ActionListener
{
  Component focusOwner;
  private static MathKeyboard instancia;
  JPanel jPanel1 = new JPanel();
  JPanel qwerty = new JPanel();
  JPanel asdfg = new JPanel();
  JPanel zxcvb = new JPanel();
  JPanel jPanel2 = new JPanel();
  JButton jButton1 = new JButton();
  JButton jButton2 = new JButton();
  JButton jButton3 = new JButton();
  JButton jButton4 = new JButton();
  JButton jButton5 = new JButton();
  JButton jButton6 = new JButton();
  JButton jButton7 = new JButton();
  JButton jButton8 = new JButton();
  JButton jButton9 = new JButton();
  JButton jButton10 = new JButton();
  JButton jButton11 = new JButton();
  JButton jButton12 = new JButton();
  JButton jButton13 = new JButton();
  JButton jButton14 = new JButton();
  JButton jButton15 = new JButton();
  JButton jButton16 = new JButton();
  JButton jButton17 = new JButton();
  JButton jButton18 = new JButton();
  JButton jButton19 = new JButton();
  JButton jButton111 = new JButton();
  JButton jButton112 = new JButton();
  JButton jButton113 = new JButton();
  JButton jButton114 = new JButton();
  JButton jButton115 = new JButton();
  JButton jButton116 = new JButton();
  JButton jButton117 = new JButton();
  JButton jButton20 = new JButton();
  GridLayout gridLayout1 = new GridLayout();
    JButton jButton21 = new JButton();
    JButton jButton22 = new JButton();
    JButton jButton23 = new JButton();
    JButton jButton24 = new JButton();
    JButton jButton25 = new JButton();
    JButton jButton26 = new JButton();
    JButton jButton27 = new JButton();
    JButton jButton28 = new JButton();
    JButton jButton29 = new JButton();
    JButton jButton210 = new JButton();
    JButton jButton211 = new JButton();
    JButton jButton212 = new JButton();
    JButton jButton213 = new JButton();
    JButton jButton214 = new JButton();
    JButton jButton215 = new JButton();
    JButton jButton216 = new JButton();

  public MathKeyboard()
  {
    super(FinestraPrincipal.instancia(), "Math keyboard ::::: NOT IMPLEMENTED YET!!");
    initialize();
  }

  public static void mostrarKeyboard()
  {
    if (instancia == null)
    {
      instancia = new MathKeyboard();
    }
    else
    {
      instancia.setVisible(true);
    }
  }

  public void initialize()
  {
    JPanel contentPane = (JPanel)this.getContentPane();
    contentPane.setLayout(null);
    this.setResizable(false);
    jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.Y_AXIS));
    jButton1.setMaximumSize(new Dimension(25, 25));
    jButton1.setPreferredSize(new Dimension(25, 25));
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.setText("Y");
    jButton1.addActionListener(this);
    jButton1.addMouseListener(new MouseAdapter()
    {
      public void mouseEntered(MouseEvent e)
      {
        focusOwner = FinestraPrincipal.instancia().getFocusOwner();
        System.out.println(focusOwner);
      }
    });
    qwerty.setMaximumSize(new Dimension(32767, 30));
    zxcvb.setMaximumSize(new Dimension(32767, 30));
    asdfg.setMaximumSize(new Dimension(32767, 30));
    asdfg.setMinimumSize(new Dimension(10, 10));
    jButton2.setText("U");
    jButton2.setMargin(new Insets(2, 2, 2, 2));
    jButton2.setPreferredSize(new Dimension(25, 25));
    jButton2.setMaximumSize(new Dimension(25, 25));
    jButton3.setText("I");
    jButton3.setMargin(new Insets(2, 2, 2, 2));
    jButton3.setPreferredSize(new Dimension(25, 25));
    jButton3.setMaximumSize(new Dimension(25, 25));
    jButton4.setText("T");
    jButton4.setMargin(new Insets(2, 2, 2, 2));
    jButton4.setPreferredSize(new Dimension(25, 25));
    jButton4.setMaximumSize(new Dimension(25, 25));
    jButton5.setText("R");
    jButton5.setMargin(new Insets(2, 2, 2, 2));
    jButton5.setPreferredSize(new Dimension(25, 25));
    jButton5.setMaximumSize(new Dimension(25, 25));
    jButton6.setText("E");
    jButton6.setMargin(new Insets(2, 2, 2, 2));
    jButton6.setPreferredSize(new Dimension(25, 25));
    jButton6.setMaximumSize(new Dimension(25, 25));
    jButton7.setText("W");
    jButton7.setMargin(new Insets(2, 2, 2, 2));
    jButton7.setPreferredSize(new Dimension(25, 25));
    jButton7.setMaximumSize(new Dimension(25, 25));
    jButton8.setText("Q");
    jButton8.setMargin(new Insets(2, 2, 2, 2));
    jButton8.setPreferredSize(new Dimension(25, 25));
    jButton8.setMaximumSize(new Dimension(25, 25));
    jButton9.setText("O");
    jButton9.setMargin(new Insets(2, 2, 2, 2));
    jButton9.setPreferredSize(new Dimension(25, 25));
    jButton9.setMaximumSize(new Dimension(25, 25));
    jButton10.setText("P");
    jButton10.setMargin(new Insets(2, 2, 2, 2));
    jButton10.setPreferredSize(new Dimension(25, 25));
    jButton10.setMaximumSize(new Dimension(25, 25));
    jButton11.setText("L");
    jButton11.setMargin(new Insets(2, 2, 2, 2));
    jButton11.setPreferredSize(new Dimension(25, 25));
    jButton11.setMaximumSize(new Dimension(25, 25));
    jButton12.setText("K");
    jButton12.setMargin(new Insets(2, 2, 2, 2));
    jButton12.setPreferredSize(new Dimension(25, 25));
    jButton12.setMaximumSize(new Dimension(25, 25));
    jButton13.setText("J");
    jButton13.setMargin(new Insets(2, 2, 2, 2));
    jButton13.setPreferredSize(new Dimension(25, 25));
    jButton13.setMaximumSize(new Dimension(25, 25));
    jButton14.setText("H");
    jButton14.setMargin(new Insets(2, 2, 2, 2));
    jButton14.setPreferredSize(new Dimension(25, 25));
    jButton14.setMaximumSize(new Dimension(25, 25));
    jButton15.setText("G");
    jButton15.setMargin(new Insets(2, 2, 2, 2));
    jButton15.setPreferredSize(new Dimension(25, 25));
    jButton15.setMaximumSize(new Dimension(25, 25));
    jButton16.setText("F");
    jButton16.setMargin(new Insets(2, 2, 2, 2));
    jButton16.setPreferredSize(new Dimension(25, 25));
    jButton16.setMaximumSize(new Dimension(25, 25));
    jButton17.setText("D");
    jButton17.setMargin(new Insets(2, 2, 2, 2));
    jButton17.setPreferredSize(new Dimension(25, 25));
    jButton17.setMaximumSize(new Dimension(25, 25));
    jButton18.setText("S");
    jButton18.setMargin(new Insets(2, 2, 2, 2));
    jButton18.setPreferredSize(new Dimension(25, 25));
    jButton18.setMaximumSize(new Dimension(25, 25));
    jButton19.setText("A");
    jButton19.setMargin(new Insets(2, 2, 2, 2));
    jButton19.setPreferredSize(new Dimension(25, 25));
    jButton19.setToolTipText("");
    jButton19.setMaximumSize(new Dimension(25, 25));
    jButton111.setText("M");
    jButton111.setMargin(new Insets(2, 2, 2, 2));
    jButton111.setPreferredSize(new Dimension(25, 25));
    jButton111.setMaximumSize(new Dimension(25, 25));
    jButton112.setText("N");
    jButton112.setMargin(new Insets(2, 2, 2, 2));
    jButton112.setPreferredSize(new Dimension(25, 25));
    jButton112.setMaximumSize(new Dimension(25, 25));
    jButton113.setText("B");
    jButton113.setMargin(new Insets(2, 2, 2, 2));
    jButton113.setPreferredSize(new Dimension(25, 25));
    jButton113.setMaximumSize(new Dimension(25, 25));
    jButton114.setText("V");
    jButton114.setMargin(new Insets(2, 2, 2, 2));
    jButton114.setPreferredSize(new Dimension(25, 25));
    jButton114.setMaximumSize(new Dimension(25, 25));
    jButton115.setText("C");
    jButton115.setMargin(new Insets(2, 2, 2, 2));
    jButton115.setPreferredSize(new Dimension(25, 25));
    jButton115.setMaximumSize(new Dimension(25, 25));
    jButton116.setText("X");
    jButton116.setMargin(new Insets(2, 2, 2, 2));
    jButton116.setPreferredSize(new Dimension(25, 25));
    jButton116.setMaximumSize(new Dimension(25, 25));
    jButton117.setText("Z");
    jButton117.setMargin(new Insets(2, 2, 2, 2));
    jButton117.setPreferredSize(new Dimension(25, 25));
    jButton117.setMaximumSize(new Dimension(25, 25));

    jPanel1.setDoubleBuffered(true);
    jPanel2.setLayout(gridLayout1);
    jButton20.setHorizontalAlignment(SwingConstants.CENTER);
        jButton20.setMargin(new Insets(2, 2, 2, 2));
    jButton20.setText("7");
    gridLayout1.setColumns(3);
        gridLayout1.setHgap(2);
        gridLayout1.setRows(3);
        gridLayout1.setVgap(2);
        jButton21.setHorizontalAlignment(SwingConstants.CENTER);
        jButton21.setMargin(new Insets(2, 2, 2, 2));
        jButton21.setText("8");
        jButton22.setHorizontalAlignment(SwingConstants.CENTER);
        jButton22.setMargin(new Insets(2, 2, 2, 2));
        jButton22.setText("9");
        jButton23.setHorizontalAlignment(SwingConstants.CENTER);
        jButton23.setMargin(new Insets(2, 2, 2, 2));
        jButton23.setText("4");
        jButton24.setHorizontalAlignment(SwingConstants.CENTER);
        jButton24.setMargin(new Insets(2, 2, 2, 2));
        jButton24.setText("5");
        jButton25.setHorizontalAlignment(SwingConstants.CENTER);
        jButton25.setMargin(new Insets(2, 2, 2, 2));
        jButton25.setText("1");
        jButton26.setHorizontalAlignment(SwingConstants.CENTER);
        jButton26.setMargin(new Insets(2, 2, 2, 2));
        jButton26.setText("6");
        jButton27.setHorizontalAlignment(SwingConstants.CENTER);
        jButton27.setMargin(new Insets(2, 2, 2, 2));
        jButton27.setText("2");
        jButton28.setMargin(new Insets(2, 2, 2, 2));
        jButton28.setSelected(false);
        jButton28.setText("3");
        jButton29.setBounds(new Rectangle(18, 134, 89, 25));
        jButton29.setOpaque(true);
        jButton29.setPreferredSize(new Dimension(61, 15));
        jButton29.setText("SIN");
        jButton210.setText("SQRT");
        jButton210.setBounds(new Rectangle(18, 162, 89, 25));
        jButton210.setOpaque(true);
        jButton210.setPreferredSize(new Dimension(61, 15));
        jButton210.setToolTipText("");
        jButton211.setText("COS");
        jButton211.setBounds(new Rectangle(117, 134, 89, 25));
        jButton211.setOpaque(true);
        jButton211.setPreferredSize(new Dimension(61, 15));
        jButton211.setSelectedIcon(null);
        jButton212.setText("POW");
        jButton212.setBounds(new Rectangle(117, 163, 89, 25));
        jButton212.setOpaque(true);
        jButton212.setPreferredSize(new Dimension(61, 15));
        jButton213.setBounds(new Rectangle(217, 134, 89, 26));
        jButton213.setOpaque(true);
        jButton213.setPreferredSize(new Dimension(61, 15));
        jButton213.setText("TAN");
        jButton214.setBounds(new Rectangle(218, 164, 89, 23));
        jButton214.setOpaque(true);
        jButton214.setPreferredSize(new Dimension(61, 15));
        jButton214.setToolTipText("");
        jButton214.setText("PI");
        jButton215.setBounds(new Rectangle(317, 164, 89, 23));
        jButton215.setOpaque(true);
        jButton215.setPreferredSize(new Dimension(61, 15));
        jButton215.setText("E");
        jButton216.setBounds(new Rectangle(317, 134, 89, 26));
        jButton216.setOpaque(true);
        jButton216.setPreferredSize(new Dimension(61, 15));
        jButton216.setText("LOG");
        jPanel2.setBorder(BorderFactory.createRaisedBevelBorder());
        jPanel1.add(qwerty);
    qwerty.add(jButton8, null);
    qwerty.add(jButton7, null);
    qwerty.add(jButton6, null);
    qwerty.add(jButton5, null);
    qwerty.add(jButton4, null);
    qwerty.add(jButton1, null);
    qwerty.add(jButton2, null);
    qwerty.add(jButton3, null);
    qwerty.add(jButton9, null);
    qwerty.add(jButton10, null);
    jPanel1.add(asdfg);
    asdfg.add(jButton19, null);
    asdfg.add(jButton18, null);
    asdfg.add(jButton17, null);
    asdfg.add(jButton16, null);
    asdfg.add(jButton15, null);
    asdfg.add(jButton14, null);
    asdfg.add(jButton13, null);
    asdfg.add(jButton12, null);
    asdfg.add(jButton11, null);
    jPanel1.add(zxcvb);
    zxcvb.add(jButton117, null);
    zxcvb.add(jButton116, null);
    zxcvb.add(jButton115, null);
    zxcvb.add(jButton114, null);
    zxcvb.add(jButton113, null);
    zxcvb.add(jButton112, null);
    zxcvb.add(jButton111, null);
        contentPane.add(jButton210, null);
        contentPane.add(jButton212, null);
        contentPane.add(jButton214, null);
        contentPane.add(jButton215, null);
        contentPane.add(jButton29, null);
        contentPane.add(jButton211, null);
        contentPane.add(jButton213, null);
        contentPane.add(jButton216, null);
    contentPane.add(jPanel2, null);
    jPanel2.add(jButton20, null);
        jPanel2.add(jButton21, null);
        jPanel2.add(jButton22, null);
        jPanel2.add(jButton23, null);
        jPanel2.add(jButton24, null);
        jPanel2.add(jButton26, null);
        jPanel2.add(jButton25, null);
        jPanel2.add(jButton27, null);
        jPanel2.add(jButton28, null);
    zxcvb.add(Box.createRigidArea(new Dimension(25, 0)));


    jPanel1.setBackground(Color.lightGray);
    jPanel1.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanel1.setBounds(new Rectangle(16, 17, 322, 106));

    jPanel2.setBounds(new Rectangle(345, 18, 126, 106));

    contentPane.add(jPanel1, null);

    this.setSize(new Dimension(510, 221));
    PopurriUtils.centrarPantalla(this);
    this.setVisible(true);
  }

  public void actionPerformed(ActionEvent e)
  {
    if (focusOwner instanceof JTextField)
    {
      JTextField f = (JTextField)focusOwner;
      f.setText(f.getText() + ((JButton)e.getSource()).getText());
    }
  }
}
