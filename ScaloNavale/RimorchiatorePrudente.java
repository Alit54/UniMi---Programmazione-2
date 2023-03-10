package ScaloNavale;

import java.util.ArrayList;
import java.util.Objects;

public class RimorchiatorePrudente implements Rimorchiatore{
    private int pesomax;

    public RimorchiatorePrudente (int pesomax) {
        if (pesomax <= 0) throw new IllegalArgumentException("Bla");
        this.pesomax = pesomax;
    }

    @Override
    public boolean sposta(Molo partenza, Molo arrivo, int quantità) {
        Objects.requireNonNull(partenza, "Il primo molo non può essere null.");
        Objects.requireNonNull(arrivo, "Il secondo molo non può essere null.");
        if (quantità <= 0) throw new IllegalArgumentException("Non puoi spostare meno di 0 navi.");
        if (quantità < partenza.getQuanteNavi()) throw new IllegalArgumentException("Non ci sono abbastanza navi da rimuovere.");
        ArrayList<Nave> navi = new ArrayList<Nave>();
        int somma = 0;
        while (quantità > 0) {
            do {
                Nave nave = partenza.remove();
                navi.add(nave);
                somma += nave.peso();
                quantità--;
            } while (somma < pesomax && quantità > 0);
            arrivo.add(navi);
            navi = new ArrayList<Nave>();
        }
        return true;
    }
}
