/**
 * 
 */
package fiusac.ia1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

/**
 * @author david
 *
 */
public class Canvas extends JComponent {
	BufferedImage biCasilla;
	/**
	 * 
	 */
	public Canvas() {
		super.setSize(800, 800);
		biCasilla = Main.ic.getSprite("img/cuadrado.jpg");
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		BufferedImage biBuff = new BufferedImage(800, 800, BufferedImage.TRANSLUCENT);
		
		Graphics2D g2dBuff = biBuff.createGraphics();
		g2dBuff.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // antialiasing
		
		g2dBuff.setColor(Color.GRAY);
		g2dBuff.fillRect(0, 0, 800, 800);
		g2dBuff.setColor(Color.BLACK);
		for (int i = 0; i < 800; i = i + 100){
			g2dBuff.drawLine(0, i, 800, i);
			g2dBuff.drawLine(i, 0, i, 800);
		}
		g2dBuff.drawImage(biCasilla, 0, 0, this);
		// g2dBuff.drawImage(biFondo, 0, 0, this); // dibujar fondo
		g2d.drawImage(biBuff, 0, 0, this); // imprimir el dibujo al JComponent
	}

}
