package fiusac.ia1;
import java.util.Comparator;

public class NodoTableroComparable implements Comparator<NodoTablero> {
	@Override
    public int compare(NodoTablero o1, NodoTablero o2) {
        return (o1.libres>o2.libres ? -1 : (o1.libres==o2.libres ? 0 : 1));
    }

}
