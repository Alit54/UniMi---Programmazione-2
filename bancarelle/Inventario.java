package bancarelle;

import java.util.*;

public class Inventario {
    private Map<Giocattolo,Integer> elenco; 
    public Inventario() {
        elenco = new HashMap<Giocattolo, Integer>();
    }

    
    /**
    * Aggiunge la quantità di giocattoli indicata all'elenco dell'inventario. 
    *
    * @param num il numero di giocattoli da inserire.
    * @param giocattolo il giocattolo da inserire.
    *
    * @throws NullPointerException se il giocattolo è null.
    */
    public void aggiungi(int num, final Giocattolo giocattolo) {
        if (giocattolo == null) throw new NullPointerException("Il giocattolo non può essere null.");
        if (elenco.containsKey(giocattolo)) num += elenco.get(giocattolo);
        elenco.put(giocattolo, num);
    }

    /**
    * Aggiunge la quantità di giocattoli indicata all'elenco dell'inventario. 
    *
    * @param num il numero di giocattoli da inserire.
    * @param giocattolo il giocattolo da inserire.
    *
    * @throws NullPointerException se il giocattolo è null.
    * @throws IllegalArgumentException se il giocattolo non è presente in inventario o se si cerca di togliere più giocattoli di quelli presenti.
    */
    public void rimuovi(int num, final Giocattolo giocattolo) {
        if (giocattolo == null) throw new NullPointerException("Il giocattolo non può essere null.");
        if (!elenco.containsKey(giocattolo)) throw new IllegalArgumentException("Giocattolo non presente nell'inventario.");
        if (elenco.get(giocattolo)-num < 0) throw new IllegalArgumentException("Non ci sono abbastanza giocattoli da rimuovere.");
        num = elenco.get(giocattolo) - num;
        if (num != 0) elenco.put(giocattolo, num);
        else elenco.remove(giocattolo);
    }

    /**
     * Restituisce la quantità di elementi del giocattolo passato come parametro che sono presenti nell'inventario.
     * 
     * @param giocattolo il giocattolo di cui si vuole sapere la quantità.
     * @return la quantità di giocattoli passati come parametro. 
     */
    public int getQuantita(Giocattolo giocattolo) {
        if (giocattolo == null) throw new NullPointerException("Il giocattolo non può essere null.");
        if (!elenco.containsKey(giocattolo)) return 0;
        return elenco.get(giocattolo);
    }


/*
 * Errori riscontrati:
 *      Mancanza di un metodo costruttore copia
 *      Mancanza di un metodo override "aggiungi"
 *          public void aggiungi(final Giocattolo giocattolo) {
                aggiungi(1, giocattolo);
            }
 *      Lancio di "IllegalArgumentException" invece di "NoSuchElementException"
 *      Mancato controllo del parametro num<0 nelle funzioni "aggiungi" e "rimuovi" 
 */

    public void aggiungi(final Giocattolo giocattolo) {
        aggiungi(1, giocattolo);
    }
    /**
    * Costruisce un inventario a partire da una mappa che, per ciascun giocattoo, indica quanti ne
    * debba contenere l'inventario.
    *
    * @param inventario una mappa tra giocattoli e le loro numerosità.
    * @throws NullPointerException se inventario è null, o contiene chiavi o valori uguali a {@code
    *     null}.
    * @throws IllegalArgumentException se uno dei valori non è positivo.
    */
    public Inventario(final Map<Giocattolo, Integer> inventario) {
        Objects.requireNonNull(
            inventario, "La mappa che rappresenta l'inventario non può essere null.");
        for (Map.Entry<Giocattolo, Integer> e : inventario.entrySet())
          aggiungi(e.getValue(), e.getKey());
      }
    
    /**
    * Costruisce una copia dell'inventario dato.
    *
    * @param originale l'inventario di cui effettuare una copia.
    * @throws NullPointerException se inventario è {@code null}.
    */
    public Inventario(final Inventario originale) {
        this(originale.elenco);
    }
}