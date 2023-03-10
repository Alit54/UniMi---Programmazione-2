package ScaloNavale;

import java.util.Objects;

public class Scalo {
    private Molo[] moli;

    public Scalo(int dimensione) {
        if (dimensione <= 0)
            throw new IllegalArgumentException("Dimensione deve essere positiva.");
        this.moli = new Molo[dimensione];
        for (int i=0; i<moli.length; i++) {
            this.moli[i] = new Molo();
        }
    }

    public Scalo(Molo[] moli) {
        Objects.requireNonNull(moli, "Moli non può essere null.");
        this.moli = new Molo[moli.length];
        for (int i=0; i<moli.length; i++) {
            this.moli[i] = moli[i];
        }
    }

    public boolean sposta(Rimorchiatore rimorchiatore, int partenza, int arrivo, int quantità) {
        Objects.requireNonNull(rimorchiatore, "Bla");
        if (partenza < 0 || partenza > moli.length) throw new IllegalArgumentException("bla");
        if (arrivo < 0 || arrivo > moli.length) throw new IllegalArgumentException("bla");
        rimorchiatore.sposta(moli[partenza], moli[arrivo], quantità);
        return true;
    }

    @Override
    public String toString() {
        String out = "";
        for (int i=0; i<moli.length; i++) {
            out += i + ":" + moli[i].toString() + "\n";
        }
        return out;
    }
}