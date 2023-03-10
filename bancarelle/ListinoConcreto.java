package bancarelle;

import java.util.*;

public class ListinoConcreto implements Listino {
    Inventario inventario;
    public ListinoConcreto (Map<Giocattolo, Integer> mappa) {
        inventario = new Inventario(mappa);
    }
    public boolean conosce(Giocattolo giocattolo) {
        if (giocattolo == null) throw new IllegalArgumentException("Il giocattolo non deve essere null.");
        if (inventario.getQuantita(giocattolo) <= 0) {
            return false;
        }
        return true;
    }

    public int prezzoComplessivo(Giocattolo giocattolo, int numDaComprare) {
        if (giocattolo == null) throw new IllegalArgumentException("Il giocattolo non deve essere null.");
        if (numDaComprare < 0) throw new IllegalArgumentException("L'acquisto deve essere positivo.");
        return inventario.getQuantita(giocattolo)*numDaComprare;
    }
}
