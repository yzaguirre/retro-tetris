/**
 * 
 */
package fiusac.ia1;

/**
 * 
 *
 */
public class NodoTablero {

	/*Unico proposito es para animar la insercion y elminacino*/
	public NodoTablero father;
	public int tablero[][];
	public int libres;
	public NodoTablero() {
		tablero = new int[8][8];
		libres = 64;
	}
	public void clearoutColumn(int columna){
		for (int i = 0; i < 8; i++){
			tablero[i][columna] = 0;
		}
		libres += 8;
	}
	public void clearoutRow(int fila){
		for (int i = 0; i < 8; i++){
			tablero[fila][i] = 0;
		}
		libres += 8;
	}
	public void corrimientoRow(int fila){
		// averiguar cuadrante
		switch (fila) {
		case 1: // correr fila 0 hacia abajo
			for (int j = 0; j < 8; j++){
				tablero[1][j] = tablero[0][j]; // asignar a fila 1 el valor de fila 0
				tablero[0][j] = 0; // eliminar la fila 0
			}
			break;
		case 2: // correr fila 1, 0 hacia abajo
			for (int i = 2; i > 0; i --){
				for (int j = 0; j < 8; j++){
					tablero[i][j] = tablero[i - 1][j];
					tablero[i - 1][j] = 0;
				}
			}
			break;
		case 3: // correr fila 2, 1, 0 hacia abajo
			for (int i = 3; i > 0; i --){
				for (int j = 0; j < 8; j++){
					tablero[i][j] = tablero[i - 1][j];
					tablero[i - 1][j] = 0;
				}
			}
			break;
		case 4: // correr fila 5, 6, 7 hacia arriba
			for (int i = 4; i < 7; i ++){
				for (int j = 0; j < 8; j++){
					tablero[i][j] = tablero[i + 1][j];
					tablero[i + 1][j] = 0;
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
				tablero[6][j] = tablero[7][j];
				tablero[7][j] = 0;
			}
			break;
		default: // no corrimiento
			// se elimino 1 o 7
			break;
		}
	}
	public void corrimientoColumn(int fila){
		// averiguar cuadrante
		switch (fila) {
		case 1: // correr columna 0 hacia abajo
			for (int i = 0; i < 8; i++){
				tablero[i][1] = tablero[i][0]; // asignar a col 1 el valor de col 0
				tablero[i][0] = 0; // eliminar la col 0
			}
			break;
		case 2: // correr colummna 1, 0 hacia abajo
			for (int j = 2; j < 7; j ++){
				for (int i = 0; i < 8; i++){
					tablero[j][i] = tablero[j + 1][i];
					tablero[j + 1][i] = 0;
				}
			}
			break;
		case 3: // correr columna 2, 1, 0 hacia abajo
			for (int j = 3; j < 7; j ++){
				for (int i = 0; i < 8; i++){
					tablero[j][i] = tablero[j + 1][i];
					tablero[j + 1][i] = 0;
				}
			}
			break;
		case 4: // correr columna 5, 6, 7 hacia arriba
			for (int j = 4; j < 7; j ++){
				for (int i = 0; i < 8; i++){
					tablero[j][i] = tablero[j + 1][i];
					tablero[j + 1][i] = 0;
				}
			}
			break;
		case 5: // correr columna 6, 7 hacia arriba
			for (int j = 5; j < 7; j ++){
				for (int i = 0; i < 8; i++){
					tablero[j][i] = tablero[j + 1][i];
					tablero[j + 1][i] = 0;
				}
			}
			break;
		case 6: // correr columna 7 hacia arriba
			for (int i = 0; i < 8; i++){
				tablero[i][6] = tablero[i][7];
				tablero[i][7] = 0;
			}
			break;
		default: // no corrimiento
			// se elimino 1 o 7
			break;
		}
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
