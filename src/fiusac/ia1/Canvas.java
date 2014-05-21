/**
 * 
 */
package fiusac.ia1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JComponent;

/**
 * @author david
 *
 */
public class Canvas extends JComponent {
	private BufferedImage biCasilla;
	
	private NodoTablero nodoTablero;
	private ArrayList<NodoTablero> lista;
	/**
	 * 
	 */
	public Canvas() {
		super.setSize(800, 800);
		biCasilla = Main.ic.getSprite("img/cuadrado.jpg");
		nodoTablero = new NodoTablero();
		lista = new ArrayList<>(50);
	}
	public void newMove(String idPieza){
		switch(idPieza){
		case "1":
			encajarPieza01();
			break;
		case "2":
			encajarPieza02();
			break;
		case "3":
			encajarPieza03();
			break;
		case "4":
			encajarPieza04();
			break;
		case "5":
			encajarPieza05();
			break;
		case "6":
			encajarPieza06();
			break;
		case "7":
			encajarPieza07();
			break;
		case "8":
			encajarPieza08();
			break;
		case "9":
			encajarPieza09();
			break;
		case "10":
			encajarPieza10();
			break;
		case "11":
			encajarPieza11();
			break;
		case "12":
			encajarPieza12();
			break;
		case "13":
			encajarPieza13();
			break;
		case "14":
			encajarPieza14();
			break;
		case "15": 
			encajarPieza15();
			break;
		}
		this.nodoTablero = lista.get(0);
		lista.clear();
		// llamar algoritmo de especial
		repaint();
	}
	private void encajarPieza01(){
		for (int i = 0; i < 8; i++){ // fila
			for (int j = 0; j < 8; j++){ // columna
				
				if (nodoTablero.isEmpty(i, j)){ // es espacio libre
					// para figura 1
					if (i < 5 && nodoTablero.isEmpty(i + 1, j) && nodoTablero.isEmpty(i + 2, j) && nodoTablero.isEmpty(i + 3, j)){
						NodoTablero hijo = nodoTablero.clone();
						hijo.fill(i, j);
						hijo.fill(i + 1, j);
						hijo.fill(i + 2, j);
						hijo.fill(i + 3, j);
						// come tablero, genera 2 versiones, crear 3er clone
						// calcular g y h
						// calcularHeuristica(hijo, this.nodoTablero);
						lista.add(hijo);
					 }
				}
			}
		}
	}
	private void encajarPieza02(){
		for (int i = 0; i < 8; i++){ // fila
			for (int j = 0; j < 8; j++){ // columna
				
				if (nodoTablero.isEmpty(i, j)){ // es espacio libre
					// para figura 1
					if (j < 5 && nodoTablero.isEmpty(i, j + 1) && nodoTablero.isEmpty(i, j + 2) && nodoTablero.isEmpty(i, j + 3)){
						NodoTablero hijo = nodoTablero.clone();
						hijo.fill(i, j);
						hijo.fill(i, j + 1);
						hijo.fill(i, j + 2);
						hijo.fill(i, j + 3);
						// come tablero, genera 2 versiones, crear 3er clone
						// calcular g y h
						// calcularHeuristica(hijo, this.nodoTablero);
						lista.add(hijo);
					 }
				}
			}
		}
	}
	private void encajarPieza03(){
		for (int i = 0; i < 8; i++){ // fila
			for (int j = 0; j < 8; j++){ // columna
				
				if (nodoTablero.isEmpty(i, j)){ // es espacio libre
					// para figura 1
					if (i < 7 && j < 7 && nodoTablero.isEmpty(i, j + 1) && nodoTablero.isEmpty(i + 1, j) && nodoTablero.isEmpty(i + 1, j + 1)){
						NodoTablero hijo = nodoTablero.clone();
						hijo.fill(i, j);
						hijo.fill(i, j + 1);
						hijo.fill(i + 1, j);
						hijo.fill(i + 1, j + 1);
						// come tablero, genera 2 versiones, crear 3er clone
						// calcular g y h
						// calcularHeuristica(hijo, this.nodoTablero);
						lista.add(hijo);
					 }
				}
			}
		}
	}
	private void encajarPieza04(){
		for (int i = 0; i < 8; i++){ // fila
			for (int j = 0; j < 8; j++){ // columna
				
				if (nodoTablero.isEmpty(i, j)){ // es espacio libre
					// para figura 1
					if (i < 7 && j > 0 && j < 7 && nodoTablero.isEmpty(i, j + 1) && nodoTablero.isEmpty(i + 1, j) && nodoTablero.isEmpty(i + 1, j - 1)){
						NodoTablero hijo = nodoTablero.clone();
						hijo.fill(i, j);
						hijo.fill(i, j + 1); // derecha
						hijo.fill(i + 1, j); // abajo
						hijo.fill(i + 1, j - 1); // diagonal 
						// come tablero, genera 2 versiones, crear 3er clone
						// calcular g y h
						// calcularHeuristica(hijo, this.nodoTablero);
						lista.add(hijo);
					 }
				}
			}
		}
	}
	private void encajarPieza05(){
		for (int i = 0; i < 8; i++){ // fila
			for (int j = 0; j < 8; j++){ // columna
				
				if (nodoTablero.isEmpty(i, j)){ // es espacio libre
					// para figura 1
					if (i < 6 && j < 7 && nodoTablero.isEmpty(i + 1, j) && nodoTablero.isEmpty(i + 1, j + 1) && nodoTablero.isEmpty(i + 2, j + 1)){
						NodoTablero hijo = nodoTablero.clone();
						hijo.fill(i, j);
						hijo.fill(i + 1, j); // abajo
						hijo.fill(i + 1, j + 1); // diagonal
						hijo.fill(i + 2, j + 1); // abajo
						
						// come tablero, genera 2 versiones, crear 3er clone
						// calcular g y h
						// calcularHeuristica(hijo, this.nodoTablero);
						lista.add(hijo);
					 }
				}
			}
		}
	}
	private void encajarPieza06(){
		for (int i = 0; i < 8; i++){ // fila
			for (int j = 0; j < 8; j++){ // columna
				
				if (nodoTablero.isEmpty(i, j)){ // es espacio libre
					// para figura 1
					if (i < 7 && j < 6 && nodoTablero.isEmpty(i, j + 1) && nodoTablero.isEmpty(i + 1, j + 1) && nodoTablero.isEmpty(i + 1, j + 2)){
						NodoTablero hijo = nodoTablero.clone();
						hijo.fill(i, j);
						hijo.fill(i, j + 1); // derecha
						hijo.fill(i + 1, j + 1); // diagonal
						hijo.fill(i + 1, j + 2); //  derecha
						// come tablero, genera 2 versiones, crear 3er clone
						// calcular g y h
						// calcularHeuristica(hijo, this.nodoTablero);
						lista.add(hijo);
					 }
				}
			}
		}
	}
	private void encajarPieza07(){
		for (int i = 0; i < 8; i++){ // fila
			for (int j = 0; j < 8; j++){ // columna
				
				if (nodoTablero.isEmpty(i, j)){ // es espacio libre
					// para figura 1
					if (j > 0 && i < 6 && j < 8 && nodoTablero.isEmpty(i + 1, j) && nodoTablero.isEmpty(i + 1, j - 1) && nodoTablero.isEmpty(i + 2, j - 1)){
						NodoTablero hijo = nodoTablero.clone();
						hijo.fill(i, j);
						hijo.fill(i + 1, j); // abajo
						hijo.fill(i + 1, j - 1); // diagonal
						hijo.fill(i + 2, j - 1); // abajo
						
						// come tablero, genera 2 versiones, crear 3er clone
						// calcular g y h
						// calcularHeuristica(hijo, this.nodoTablero);
						lista.add(hijo);
					 }
				}
			}
		}
	}
	private void encajarPieza08(){
		for (int i = 0; i < 8; i++){ // fila
			for (int j = 0; j < 8; j++){ // columna
				
				if (nodoTablero.isEmpty(i, j)){ // es espacio libre
					// para figura 1
					if (i < 6 && j < 7 && nodoTablero.isEmpty(i, j + 1) && nodoTablero.isEmpty(i + 1, j + 1) && nodoTablero.isEmpty(i + 2, j + 1)){
						NodoTablero hijo = nodoTablero.clone();
						hijo.fill(i, j);
						hijo.fill(i, j + 1);
						hijo.fill(i + 1, j + 1);
						hijo.fill(i + 2, j + 1);
						// come tablero, genera 2 versiones, crear 3er clone
						// calcular g y h
						// calcularHeuristica(hijo, this.nodoTablero);
						lista.add(hijo);
					 }
				}
			}
		}
	}
	private void encajarPieza09(){
		for (int i = 0; i < 8; i++){ // fila
			for (int j = 0; j < 8; j++){ // columna
				
				if (nodoTablero.isEmpty(i, j)){ // es espacio libre
					// para figura 1
					if (i < 6 && j < 7 && nodoTablero.isEmpty(i + 1, j) && nodoTablero.isEmpty(i + 2, j) && nodoTablero.isEmpty(i + 2, j + 1)){
						NodoTablero hijo = nodoTablero.clone();
						hijo.fill(i, j);
						hijo.fill(i + 1, j);
						hijo.fill(i + 2, j);
						hijo.fill(i + 2, j + 1);
						// come tablero, genera 2 versiones, crear 3er clone
						// calcular g y h
						// calcularHeuristica(hijo, this.nodoTablero);
						lista.add(hijo);
					 }
				}
			}
		}
	}
	private void encajarPieza10(){
		for (int i = 0; i < 8; i++){ // fila
			for (int j = 0; j < 8; j++){ // columna
				
				if (nodoTablero.isEmpty(i, j)){ // es espacio libre
					// para figura 1
					if (i > 0 && i < 8 && j < 6 && nodoTablero.isEmpty(i, j + 1) && nodoTablero.isEmpty(i, j + 2) && nodoTablero.isEmpty(i - 1, j + 2)){
						NodoTablero hijo = nodoTablero.clone();
						hijo.fill(i, j);
						hijo.fill(i, j + 1);
						hijo.fill(i, j + 2);
						hijo.fill(i - 1, j + 2);
						// come tablero, genera 2 versiones, crear 3er clone
						// calcular g y h
						// calcularHeuristica(hijo, this.nodoTablero);
						lista.add(hijo);
					 }
				}
			}
		}
	}
	private void encajarPieza11(){
		for (int i = 0; i < 8; i++){ // fila
			for (int j = 0; j < 8; j++){ // columna
				
				if (nodoTablero.isEmpty(i, j)){ // es espacio libre
					// para figura 1
					if (i < 7 &&  j < 6 && nodoTablero.isEmpty(i, j + 1) && nodoTablero.isEmpty(i, j + 2) && nodoTablero.isEmpty(i + 1, j)){
						NodoTablero hijo = nodoTablero.clone();
						hijo.fill(i, j);
						hijo.fill(i, j + 1);
						hijo.fill(i, j + 2);
						hijo.fill(i + 1, j);
						// come tablero, genera 2 versiones, crear 3er clone
						// calcular g y h
						// calcularHeuristica(hijo, this.nodoTablero);
						lista.add(hijo);
					 }
				}
			}
		}
	}
	private void encajarPieza12(){
		for (int i = 0; i < 8; i++){ // fila
			for (int j = 0; j < 8; j++){ // columna
				
				if (nodoTablero.isEmpty(i, j)){ // es espacio libre
					// para figura 1
					if (i < 6 && j < 7 && nodoTablero.isEmpty(i + 1, j) && nodoTablero.isEmpty(i + 2, j) && nodoTablero.isEmpty(i, j + 1)){
						NodoTablero hijo = nodoTablero.clone();
						hijo.fill(i, j);
						hijo.fill(i + 1, j);
						hijo.fill(i + 2, j);
						hijo.fill(i, j + 1);
						// come tablero, genera 2 versiones, crear 3er clone
						// calcular g y h
						// calcularHeuristica(hijo, this.nodoTablero);
						lista.add(hijo);
					 }
				}
			}
		}
	}
	private void encajarPieza13(){
		for (int i = 0; i < 8; i++){ // fila
			for (int j = 0; j < 8; j++){ // columna
				
				if (nodoTablero.isEmpty(i, j)){ // es espacio libre
					// para figura 1
					if (i < 7 && j < 6 && nodoTablero.isEmpty(i, j + 1) && nodoTablero.isEmpty(i, j + 2) && nodoTablero.isEmpty(i + 1, j + 2)){
						NodoTablero hijo = nodoTablero.clone();
						hijo.fill(i, j);
						hijo.fill(i, j + 1);
						hijo.fill(i, j + 2);
						hijo.fill(i + 1, j + 2);
						// come tablero, genera 2 versiones, crear 3er clone
						// calcular g y h
						// calcularHeuristica(hijo, this.nodoTablero);
						lista.add(hijo);
					 }
				}
			}
		}
	}
	private void encajarPieza14(){
		for (int i = 0; i < 8; i++){ // fila
			for (int j = 0; j < 8; j++){ // columna
				
				if (nodoTablero.isEmpty(i, j)){ // es espacio libre
					// para figura 1
					System.out.println("i: " + i + ", j: " + j);
					if (i < 6 && j > 0 && j < 8 && nodoTablero.isEmpty(i + 1, j) && nodoTablero.isEmpty(i + 2, j) && nodoTablero.isEmpty(i + 2, j - 1)){
						NodoTablero hijo = nodoTablero.clone();
						hijo.fill(i, j);
						hijo.fill(i + 1, j);
						hijo.fill(i + 2, j);
						hijo.fill(i + 2, j - 1);
						// come tablero, genera 2 versiones, crear 3er clone
						// calcular g y h
						// calcularHeuristica(hijo, this.nodoTablero);
						lista.add(hijo);
					 }
				}
			}
		}
	}
	private void encajarPieza15(){
		for (int i = 0; i < 8; i++){ // fila
			for (int j = 0; j < 8; j++){ // columna
				
				if (nodoTablero.isEmpty(i, j)){ // es espacio libre
					// para figura 1
					if (i < 7 && j < 6 && nodoTablero.isEmpty(i + 1, j) && nodoTablero.isEmpty(i + 1, j + 1) && nodoTablero.isEmpty(i + 1, j + 2)){
						NodoTablero hijo = nodoTablero.clone();
						hijo.fill(i, j);
						hijo.fill(i + 1, j);
						hijo.fill(i + 1, j + 1);
						hijo.fill(i + 1, j + 2);
						// come tablero, genera 2 versiones, crear 3er clone
						// calcular g y h
						// calcularHeuristica(hijo, this.nodoTablero);
						lista.add(hijo);
					 }
				}
			}
		}
	}
	private void comeLineas(NodoTablero nt){
		NodoTablero ntHorizontal = nt.clone();
		NodoTablero ntVertical = nt.clone();
		for (int i = 0; i < 8; i++){ // fila
			for (int j = 0; j < 8; j++){ // columna
				
				if (ntHorizontal.isOcupied(i, 0)
						&& ntHorizontal.isOcupied(i, 1)
						&& ntHorizontal.isOcupied(i, 2)
						&& ntHorizontal.isOcupied(i, 3)
						&& ntHorizontal.isOcupied(i, 4)
						&& ntHorizontal.isOcupied(i, 5)
						&& ntHorizontal.isOcupied(i, 6)
						&& ntHorizontal.isOcupied(i, 7)
						){ // es espacio libre
				}
				if (ntVertical.isOcupied(0, j)
						&& ntVertical.isOcupied(1, j)
						&& ntVertical.isOcupied(2, j)
						&& ntVertical.isOcupied(3, j)
						&& ntVertical.isOcupied(4, j)
						&& ntVertical.isOcupied(5, j)
						&& ntVertical.isOcupied(6, j)
						&& ntVertical.isOcupied(7, j)
						){ // es espacio libre
				}
			}
		}
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
		for (int i = 0; i < 8; i++){ // fila
			for (int j = 0; j < 8; j++){ // columna
				if (nodoTablero.tablero[i][j] == 1){
					// System.out.println("(i,j) " + i + " : " + j);
					g2dBuff.drawImage(biCasilla, j * 100, i * 100, this);
				}
				
			}
		}
		//g2dBuff.drawImage(biCasilla, 0, 0, this);
		g2d.drawImage(biBuff, 0, 0, this); // imprimir el dibujo al JComponent
	}

}
