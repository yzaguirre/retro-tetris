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
import java.util.Collections;

import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 * @author david
 *
 */
public class Canvas extends JComponent {
	private BufferedImage biCasilla;
	private NodoTablero nodoTablero;
	private ArrayList<NodoTablero> lista;
	private JLabel jlScoreBoard;
	private int score;
	private String currentPieza;
	/**
	 * 
	 */
	public Canvas(JLabel jlScoreBoard) {
		super.setSize(800, 800);
		this.jlScoreBoard = jlScoreBoard;
		biCasilla = Main.ic.getSprite("img/cuadrado.jpg");
		nodoTablero = new NodoTablero();
		lista = new ArrayList<>(50);
	}
	public void newMove(String idPieza){
		this.currentPieza = idPieza;
		Thread hilo = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Canvas.this.newMoveHilo();
			}
		});
		hilo.start();
	}
	private void newMoveHilo(){
		boolean returned = false;
		switch(this.currentPieza){
		case "1":
			returned = encajarPieza01();
			break;
		case "2":
			returned = encajarPieza02();
			break;
		case "3":
			returned = encajarPieza03();
			break;
		case "4":
			returned = encajarPieza04();
			break;
		case "5":
			returned = encajarPieza05();
			break;
		case "6":
			returned = encajarPieza06();
			break;
		case "7":
			returned = encajarPieza07();
			break;
		case "8":
			returned = encajarPieza08();
			break;
		case "9":
			returned = encajarPieza09();
			break;
		case "10":
			returned = encajarPieza10();
			break;
		case "11":
			returned = encajarPieza11();
			break;
		case "12":
			returned = encajarPieza12();
			break;
		case "13":
			returned = encajarPieza13();
			break;
		case "14":
			returned = encajarPieza14();
			break;
		case "15": 
			returned = encajarPieza15();
			break;
		}
		if (returned){
			Collections.sort(lista, new NodoTableroComparable());
			NodoTablero c3 = lista.get(0);
			lista.clear();
			if (c3.father != null){
				NodoTablero c1 = c3.father;
				// animar
				this.nodoTablero = c1;
				repaint();
				try{
					Thread.sleep(500);
				}catch(Exception e){
					
				}
			}
			// animar
			this.nodoTablero = c3;
			// llamar algoritmo de especial
			repaint();
			// this.nodoTablero.father = null; // despues de dibujar
		}
	}
	private boolean encajarPieza01(){
		boolean returnable = false;
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
						// come tablero
						// calcular g y h. Son espacios en blanco ya sumado
						lista.add(comeLineas(hijo));
						returnable = true;
					 }
				}
			}
		}
		return returnable;
	}
	private boolean encajarPieza02(){
		boolean returnable = false;
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
						// come tablero
						// calcular g y h. Son espacios en blanco ya sumado
						lista.add(comeLineas(hijo));
						returnable = true;
					 }
				}
			}
		}
		return returnable;
	}
	private boolean encajarPieza03(){
		boolean returnable = false;
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
						// come tablero
						// calcular g y h. Son espacios en blanco ya sumado
						lista.add(comeLineas(hijo));
						returnable = true;
					 }
				}
			}
		}
		return returnable;
	}
	private boolean encajarPieza04(){
		boolean returnable = false;
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
						// come tablero
						// calcular g y h. Son espacios en blanco ya sumado
						lista.add(comeLineas(hijo));
						returnable = true;
					 }
				}
			}
		}
		return returnable;
	}
	private boolean encajarPieza05(){
		boolean returnable = false;
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
						// come tablero
						// calcular g y h. Son espacios en blanco ya sumado
						lista.add(comeLineas(hijo));
						returnable = true;
					 }
				}
			}
		}
		return returnable;
	}
	private boolean encajarPieza06(){
		boolean returnable = false;
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
						// come tablero
						// calcular g y h. Son espacios en blanco ya sumado
						lista.add(comeLineas(hijo));
						returnable = true;
					 }
				}
			}
		}
		return returnable;
	}
	private boolean encajarPieza07(){
		boolean returnable = false;
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
						// come tablero
						// calcular g y h. Son espacios en blanco ya sumado
						lista.add(comeLineas(hijo));
						returnable = true;
					 }
				}
			}
		}
		return returnable;
	}
	private boolean encajarPieza08(){
		boolean returnable = false;
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
						// come tablero
						// calcular g y h. Son espacios en blanco ya sumado
						lista.add(comeLineas(hijo));
						returnable = true;
					 }
				}
			}
		}
		return returnable;
	}
	private boolean encajarPieza09(){
		boolean returnable = false;
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
						// come tablero
						// calcular g y h. Son espacios en blanco ya sumado
						lista.add(comeLineas(hijo));
						returnable = true;
					 }
				}
			}
		}
		return returnable;
	}
	private boolean encajarPieza10(){
		boolean returnable = false;
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
						// come tablero
						// calcular g y h. Son espacios en blanco ya sumado
						lista.add(comeLineas(hijo));
						returnable = true;
					 }
				}
			}
		}
		return returnable;
	}
	private boolean encajarPieza11(){
		boolean returnable = false;
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
						// come tablero
						// calcular g y h. Son espacios en blanco ya sumado
						lista.add(comeLineas(hijo));
						returnable = true;
					 }
				}
			}
		}
		return returnable;
	}
	private boolean encajarPieza12(){
		boolean returnable = false;
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
						// come tablero
						// calcular g y h. Son espacios en blanco ya sumado
						lista.add(comeLineas(hijo));
						returnable = true;
					 }
				}
			}
		}
		return returnable;
	}
	private boolean encajarPieza13(){
		boolean returnable = false;
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
						// come tablero
						// calcular g y h. Son espacios en blanco ya sumado
						lista.add(comeLineas(hijo));
						returnable = true;
					 }
				}
			}
		}
		return returnable;
	}
	private boolean encajarPieza14(){
		boolean returnable = false;
		for (int i = 0; i < 8; i++){ // fila
			for (int j = 0; j < 8; j++){ // columna
				
				if (nodoTablero.isEmpty(i, j)){ // es espacio libre
					// para figura 1
					// System.out.println("i: " + i + ", j: " + j);
					if (i < 6 && j > 0 && j < 8 && nodoTablero.isEmpty(i + 1, j) && nodoTablero.isEmpty(i + 2, j) && nodoTablero.isEmpty(i + 2, j - 1)){
						NodoTablero hijo = nodoTablero.clone();
						hijo.fill(i, j);
						hijo.fill(i + 1, j);
						hijo.fill(i + 2, j);
						hijo.fill(i + 2, j - 1);
						// come tablero
						comeLineas(hijo);
						// calcular g y h. Son espacios en blanco ya sumado
						lista.add(hijo);
						returnable = true;
					 }
				}
			}
		}
		return returnable;
	}
	private boolean encajarPieza15(){
		boolean returnable = false;
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
						// come tablero
						comeLineas(hijo);
						// calcular g y h. Son espacios en blanco ya sumado
						lista.add(hijo);
						returnable = true;
					 }
				}
			}
		}
		return returnable;
	}
	private NodoTablero comeLineas(NodoTablero c1){
		NodoTablero nt = c1.clone();
		nt.father = c1;
		boolean continuar;
		do {
			continuar = false;
			for_: for (int i = 0; i < 8; i++){ // fila
				if (nt.isOcupied(i, 0)
						&& nt.isOcupied(i, 1)
						&& nt.isOcupied(i, 2)
						&& nt.isOcupied(i, 3)
						&& nt.isOcupied(i, 4)
						&& nt.isOcupied(i, 5)
						&& nt.isOcupied(i, 6)
						&& nt.isOcupied(i, 7)
						){ // es espacio libre
					nt.clearoutRow(i);
					// corriemiento
					nt.corrimientoRow(i);
					continuar = true;
					score += 10;
					jlScoreBoard.setText(String.format("%d", score));
					break for_;
					// salir
				} // fin if
			} // fin 1er for
		} while (continuar);
		
		do {
			continuar = false;
			for_: for (int j = 0; j < 8; j++){ // columna
				if (nt.isOcupied(0, j)
						&& nt.isOcupied(1, j)
						&& nt.isOcupied(2, j)
						&& nt.isOcupied(3, j)
						&& nt.isOcupied(4, j)
						&& nt.isOcupied(5, j)
						&& nt.isOcupied(6, j)
						&& nt.isOcupied(7, j)
						){ // es espacio libre
					nt.clearoutColumn(j);
					// corriemiento
					nt.corrimientoColumn(j);
					continuar = true;
					score += 10;
					jlScoreBoard.setText(String.format("%d", score));
					// corriemiento
					break for_;
					// salir
				} // fin if
			} // fin 2do for
		} while (continuar);
		
		return nt;
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
