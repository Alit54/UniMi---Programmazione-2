package ScaloNavale;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

// AF: (molo) -> Rappresento il molo come una coda di navi.

public class Molo {
    private ArrayList<Nave> molo;

    /**
     * Costruttore che inizializza un molo vuoto.
     */ 
    public Molo() {
        this.molo = new ArrayList<Nave>();
    }
    /**
     * Crea un molo copiando un molo già esistente.
     * 
     * @param molo la lista di navi
     * @throws NullPointerException se il molo è null o se il molo contiene una nave null
     */
    public Molo(ArrayList<Nave> molo) {
        Objects.requireNonNull(molo, "molo non può essere null.");
        this.molo = new ArrayList<Nave>() ;
        this.add(molo);
    }

    /**
     * Aggiunge una nave al molo.
     * 
     * IR: Nave non può essere null.
     * 
     * @param nave la nave da aggiungere al molo.
     * @return lunghezza del molo dopo l'aggiunta della nave.
     * @throws NullPointerException se la nave non è null.
     */
    protected int add(Nave nave) {
        Objects.requireNonNull(nave, "Nave non può essere null.");
        molo.add(nave);
        return molo.size();
    }

    /**
     * Aggiunge una lista di navi al molo.
     * 
     * IR: Nessuna delle navi nell'Arraylist deve essere null e l'ArrayList non deve essere null.
     * 
     * @param navi le navi da inserire
     * @return lunghezza del molo dopo l'aggiunta delle navi.
     * @throws NullPointerException se una delle navi è null.
     */
    protected int add(ArrayList<Nave> navi) {
        Objects.requireNonNull(navi, "Le navi non possono essere null.");
        Iterator<Nave> iterator = navi.iterator();
        while (iterator.hasNext()) {
            Nave nave = iterator.next();
            this.add(nave);
        }
        return molo.size();
    }

    /**
     * Rimuove l'ultima nave della coda di navi.
     * 
     * @return la nave rimossa.
     * @throws IndexOutOfBoundException se il molo è vuoto prima della rimozione.
     */
    protected Nave remove() {
        int index = molo.size()-1;
        Nave nave = molo.remove(index);
        return nave;
    }

    /**
     * Metodo osservazionale: Restituisce il peso dell'ultima nave della coda.
     * 
     * @return il peso dell'ultima nave della coda.
     * @throws IndexOutOfBoundException se il molo è vuoto.
     */
    public int getPesoUltimaNave() {
        int index = molo.size()-1;
        return molo.get(index).peso();
    }

    /**
     * Metodo osservazionale: Restituisce la quantità di navi del molo.
     * 
     * @return il numero di navi del molo.
     */
    public int getQuanteNavi() {
        return molo.size();
    }

    @Override
    public String toString() {
        String out = "< ";
        Iterator<Nave> iterator = molo.iterator();
        while (iterator.hasNext()) {
            out += iterator.next().toString();
            if (iterator.hasNext()) {
                out += ", ";
            }
        }
        return out + " #";
    }
}