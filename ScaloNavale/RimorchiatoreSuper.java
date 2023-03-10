package ScaloNavale;

import java.util.ArrayList;
import java.util.Objects;

public class RimorchiatoreSuper implements Rimorchiatore{
    @Override
    public boolean sposta(Molo partenza, Molo arrivo, int quantità) {
        Objects.requireNonNull(partenza, "Il primo molo non può essere null.");
        Objects.requireNonNull(arrivo, "Il secondo molo non può essere null.");
        if (quantità <= 0) throw new IllegalArgumentException("Non puoi spostare meno di 0 navi.");
        if (quantità < partenza.getQuanteNavi()) throw new IllegalArgumentException("Non ci sono abbastanza navi da rimuovere.");
        ArrayList<Nave> navi = new ArrayList<Nave>();
        for (int i=0; i<quantità; i++) {
            Nave nave = partenza.remove();
            navi.add(nave);
        }
        arrivo.add(navi);
        return true;
    }
}
