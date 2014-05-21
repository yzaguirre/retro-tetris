/**
 * 
 */
package fiusac.ia1;

/**
 * 
 *
 */
public class NodoTablero {

	
	public int tablero[][];
	public int ocupados;
	public int g, h, f;
	public NodoTablero() {
		tablero = new int[8][8];
		ocupados = 0;
	}
	public void clearout(int fila, int columna){
		tablero[fila][columna] = 0;
		ocupados--;
	}
	public void fill(int fila, int columna){
		tablero[fila][columna] = 1;
		ocupados++;
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
		nt.ocupados = ocupados;
		return nt;
	}
}
