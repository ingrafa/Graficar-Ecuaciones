/**
 * Magical Function Generator
 *
 * @author Marc Oliveras Galvez <oligalma@gmail.com> 
 * @link http://www.oligalma.com
 * @copyright 2016 Oligalma
 * @license GPL License v3
 */

package magicalfunctiongenerator.domini;

import org.nfunk.jep.*;

public class FuncioSimple extends Funcio
{
  protected JEP parser = new JEP();

  public FuncioSimple(String expressio, Grafica g)
  {
    super(g);
    this.expressio = expressio;

    parser.addVariable("x", 0);
    parser.setImplicitMul(true);
    parser.addStandardFunctions();
    parser.addStandardConstants();

    parser.parseExpression(expressio);
    if (parser.hasError())
      throw new IllegalArgumentException("The expression of the function is incorrect.");
  }

  public float getYValue(float xValue)
  {
    parser.addVariable("x", xValue);
    return (float)parser.getValue();
  }

  public void setExpressio(String expressio) throws Exception
  {
    parser.parseExpression(expressio);

    if (parser.hasError())
    {
      parser.parseExpression(this.expressio);
      throw new Exception("The expression of the function is incorrect.");
    }
    this.expressio = expressio;
  }

  public void addPunt(float x, float y) throws Exception
  {
    super.addPunt(x, getYValue(x));
  }
}
