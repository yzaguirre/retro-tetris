/**
 * 
 */
package fiusac.ia1;

/**
 * 
 *
 */
public class NodoTablero {

	public NodoTablero father;
	public int tablero[][];
	public int libres;
	public int g, h, f;
	public NodoTablero() {
		tablero = new int[8][8];
		libres = 64;
	}
	public NodoTablero clearoutColumn(int columna){
		NodoTablero c2 = this.clone();
		c2.father = this;
		for (int i = 0; i < 8; i++){
			c2.tablero[i][columna] = 0;
		}
		libres += 8;
		return c2;
	}
	public NodoTablero clearoutRow(int fila){
		NodoTablero c2 = this.clone();
		c2.father = this;
		for (int i = 0; i < 8; i++){
			c2.tablero[fila][i] = 0;
		}
		libres += 8;
		return c2;
	}
	public void clearout(int fila, int columna){
		tablero[fila][columna] = 0;
		libres++;
	}
	public NodoTablero corrimientoRow(int fila){
		NodoTablero c3 = this.clone();
		c3.father = this;
		// averiguar cuadrante
		switch (fila) {
		case 1: // correr fila 0 hacia abajo
			for (int j = 0; j < 8; j++){
				c3.tablero[1][j] = tablero[0][j]; // asignar a fila 1 el valor de fila 0
				c3.tablero[0][j] = 0; // eliminar la fila 0
			}
			break;
		case 2: // correr fila 1, 0 hacia abajo
			for (int i = 2; i > 0; i --){
				for (int j = 0; j < 8; j++){
					c3.tablero[i][j] = tablero[i - 1][j];
					c3.tablero[i - 1][j] = 0;
				}
			}
			break;
		case 3: // correr fila 2, 1, 0 hacia abajo
			for (int i = 3; i > 0; i --){
				for (int j = 0; j < 8; j++){
					c3.tablero[i][j] = tablero[i - 1][j];
					c3.tablero[i - 1][j] = 0;
				}
			}
			break;
		case 4: // correr fila 5, 6, 7 hacia arriba
			for (int i = 4; i < 7; i ++){
				for (int j = 0; j < 8; j++){
					c3.tablero[i][j] = tablero[i + 1][j];
					c3.tablero[i + 1][j] = 0;
				}
			}
			break;
		case 5: // correr fila 6, 7 hacia arriba
			for (int i = 5; i < 7; i ++){
				for (int j = 0; j < 8; j++){
					tablero[i][j] = tablero[i + 1][j];
					tablero[i + 1][j] = 0;
				}
			}
			break;
		case 6: // correr fila 7 hacia arriba
			for (int j = 0; j < 8; j++){
				c3.tablero[6][j] = tablero[7][j];
				c3.tablero[7][j] = 0;
			}
			break;
		default: // no corrimiento
			// se elimino 1 o 7
			return this;
		}
		return c3;
	}
	public NodoTablero corrimientoColumn(int fila){
		NodoTablero c3 = this.clone();
		c3.father = this;
		// averiguar cuadrante
		switch (fila) {
		case 1: // correr columna 0 hacia abajo
			for (int i = 0; i < 8; i++){
				c3.tablero[i][1] = tablero[i][0]; // asignar a col 1 el valor de col 0
				c3.tablero[i][0] = 0; // eliminar la col 0
			}
			break;
		case 2: // correr colummna 1, 0 hacia abajo
			for (int j = 2; j < 7; j ++){
				for (int i = 0; i < 8; i++){
					c3.tablero[j][i] = tablero[j + 1][i];
					c3.tablero[j + 1][i] = 0;
				}
			}
			break;
		case 3: // correr columna 2, 1, 0 hacia abajo
			for (int j = 3; j < 7; j ++){
				for (int i = 0; i < 8; i++){
					c3.tablero[j][i] = tablero[j + 1][i];
					c3.tablero[j + 1][i] = 0;
				}
			}
			break;
		case 4: // correr columna 5, 6, 7 hacia arriba
			for (int j = 4; j < 7; j ++){
				for (int i = 0; i < 8; i++){
					c3.tablero[j][i] = tablero[j + 1][i];
					c3.tablero[j + 1][i] = 0;
				}
			}
			break;
		case 5: // correr columna 6, 7 hacia arriba
			for (int j = 5; j < 7; j ++){
				for (int i = 0; i < 8; i++){
					c3.tablero[j][i] = tablero[j + 1][i];
					c3.tablero[j + 1][i] = 0;
				}
			}
			break;
		case 6: // correr columna 7 hacia arriba
			for (int i = 0; i < 8; i++){
				c3.tablero[i][6] = tablero[i][7];
				c3.tablero[i][7] = 0;
			}
			break;
		default: // no corrimiento
			// se elimino 1 o 7
			return this;
		}
		return c3;
	}
	public void fill(int fila, int columna){
		tablero[fila][columna] = 1;
		libres--;
	}
	public boolean isOcupied(int fila, int columna){
		return tablero[fila][columna] == 1;
	}
	public boolean isEmpty(int fila, int columna){
		return tablero[fila][columna] == 0;
	}
	@Override
	protected NodoTablero clone(){
		NodoTablero nt = new NodoTablero();
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				nt.tablero[i][j] = this.tablero[i][j];
			}
		}
		nt.libres = libres;
		return nt;
	}
}
