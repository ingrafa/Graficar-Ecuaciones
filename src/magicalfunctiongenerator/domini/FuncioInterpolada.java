/**
 * Magical Function Generator
 *
 * @author Marc Oliveras Galvez <oligalma@gmail.com> 
 * @link http://www.oligalma.com
 * @copyright 2016 Oligalma
 * @license GPL License v3
 */

package magicalfunctiongenerator.domini;

import magicalfunctiongenerator.utils.*;
import java.text.*;

public class FuncioInterpolada extends Funcio
{
  private float[][] M; // Taula de difer�ncies finites.

  public FuncioInterpolada(Grafica g)
  {
    super(g);
    expressio = "";
  }

  public void addPunt(float x, float y) throws Exception
  {
    super.addPunt(x, y);
  }

  public void removePunt(Punt p) throws Exception
  {
    if (punts.size() > 1)
      super.removePunt(p);
    else
      throw new Exception("The point cannot be deleted because every interpolated graphic must have one at least.");
  }

  public void firePuntsChanged()
  {
    this.calcularTaulaDiferencies();
    this.calcularPolinomiInterpolacioSimplificat();
  }

  private void calcularTaulaDiferencies()
  {
    int N = punts.size();

    // Calculem la taula de difer�ncies dividides finites...
    M = new float[N][N];

    for (int i = 0; i < N; i++)
      M[i][0] = punts.get(i).getY();

    for (int j = 1; j < N; j++)
      for (int i = 0; i < N - j; i++)
        M[i][j] = (M[i + 1][j - 1] - M[i][j - 1]) / (punts.get(i + j).getX() - (punts.get(i).getX()));
  }

  // Interpolaci� mitjan�ant el polinomi d'interpolaci� de Newton.
  public String getPolinomiInterpolacio(float[] x, float[] y)
  {
    if (x.length == 0 || y.length == 0)
      throw new IllegalArgumentException("An (x,y) value must exist at least.");
    if (x.length != y.length)
      throw new IllegalArgumentException("The X and Y matrix must have the same number of values.");

    int N = x.length;

    // Convertim les taules X i Y a taules de la classe CRacional
    CRacional[] xR = new CRacional[N];
    CRacional[] yR = new CRacional[N];

    for (int i = 0; i < N; i++)
    {
      xR[i] = new CRacional(x[i]);
      yR[i] = new CRacional(y[i]);
    }

    // Calculem la taula de difer�ncies dividides finites...
    CRacional[][] M = new CRacional[N][N];

    for (int i = 0; i < N; i++)
      M[i][0] = yR[i];

    for (int j = 1; j < N; j++)
      for (int i = 0; i < N - j; i++)
      {
        M[i][j] = (M[i + 1][j - 1].restar(M[i][j - 1])).dividir(xR[i + j].restar(xR[i]));
        M[i][j].simplificar();
      }

    // Calculem el polinomi...
    CRacional b[] = M[0];

    String funcio = b[0].toString();

    for (int i = 1; i < N; i++)
    {
      if (!b[i].esCero())
      {
        if (b[i].mayor(new CRacional(0)))
          funcio += "+";
        if (!b[i].equals(new CRacional(1)))
        {
          if (b[i].equals(new CRacional( -1)))
            funcio += "-";
          else
            funcio += b[i].toString();
        }

        for (int j = 0; j < i; j++)
        {
          if (x[j] != 0)
            funcio += "(x" + (x[j] > 0 ? "-" + x[j] : "+" + -x[j]) + ")";
          else
            funcio += "x";
        }
      }
    }

    funcio = funcio.replace(',', '.');

    if (funcio.charAt(0) == '0' && funcio.length() != 1)
      funcio = funcio.replaceFirst("0", "");
    if (funcio.charAt(0) == '+')
      funcio = funcio.replaceFirst("\\+", "");

    return funcio;
  }

  public float getYValue(float xValue)
  {
    float b[] = M[0];
    float valor = b[0];

    for (int i = 1; i < b.length; i++)
    {
      float b2 = b[i];
      for (int j = 0; j < i; j++)
        b2 = b2 * (xValue - punts.get(j).getX());

      valor += b2;
    }
    return valor;
  }

  public void calcularPolinomiInterpolacioSimplificat()
  {
    float b[] = M[0];
    int N = punts.size();

    DecimalFormat format = new DecimalFormat("0.0#####");

    String funcio = b[0] + "";

    for (int i = 1; i < N; i++)
    {
      if (b[i] != 0)
      {
        if (b[i] > 0)
          funcio += "+";
        if (b[i] != 1)
        {
          if (b[i] == -1)
            funcio += "-";
          else
            funcio += format.format(b[i]);
        }

        for (int j = 0; j < i; j++)
        {
          float x = punts.get(j).getX();
          if (x != 0)
            funcio += "(x" + (x > 0 ? "-" + x : "+" + -x) + ")";
          else
            funcio += "x";
        }
      }
    }

    funcio = funcio.replace(',', '.');

    if (funcio.substring(0, 3).equals("0.0") && funcio.length() != 3)
      funcio = funcio.replaceFirst("0.0", "");
    if (funcio.charAt(0) == '+')
      funcio = funcio.replaceFirst("\\+", "");

    expressio = funcio;
  }
}
