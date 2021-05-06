/**
 * Magical Function Generator
 *
 * @author Marc Oliveras Galvez <oligalma@gmail.com> 
 * @link http://www.oligalma.com
 * @copyright 2016 Oligalma
 * @license GPL License v3
 */

package magicalfunctiongenerator.presentacio.configuracions;

import java.awt.*;

import javax.swing.*;

public class TabModes extends JTabbedPane
{
  TabModeSurf mode_surf = new TabModeSurf();
  TabModeZoomPlus mode_zoom_plus = new TabModeZoomPlus();
  TabModeZoomMinus mode_zoom_minus = new TabModeZoomMinus();
  TabModeImant mode_imant = new TabModeImant();

  public TabModes()
  {

    initialize();
  }

  private void initialize()
  {
    this.addTab("Surf mode", mode_surf);
    this.addTab("Zoom in mode", mode_zoom_plus);
    this.addTab("Zoom out mode", mode_zoom_minus);
    this.addTab("Magnet mode", mode_imant);

    this.setPreferredSize(new Dimension(400, 300));
  }
}
