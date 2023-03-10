import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class TavolaPeriodica {
    /*
     * OVERVIEW: La classe rappresenta la tavola periodica.
     * 
     */

    private final ArrayList<ElementoChimico> lista = new ArrayList<>();


    /**
     * 
     * 
     * @param lista la lista degli elementi da inserire alla tavola 
     */
    public TavolaPeriodica(ArrayList<ElementoChimico> lista) {
        Objects.requireNonNull(lista, "GLS");
        
        // Primo metodo
        Iterator<ElementoChimico> iterator = lista.iterator();
        while (iterator.hasNext()) {
            ElementoChimico elemento = Objects.requireNonNull(iterator.next());
            aggiungiElemento(elemento);
        }

        // Secondo metodo
        for (ElementoChimico elemento: lista) {
            Objects.requireNonNull(elemento);
            aggiungiElemento(elemento);
        }
    }

    /**
     * Aggiunge un elemento alla Tavola Periodica.
     * 
     * @param elemento l'elemento da aggiungere alla Tavola Periodica
     * @return la lunghezza della lista
     * @throws IllegalArgumentException se elemento è già presente
     */
    public int aggiungiElemento(ElementoChimico elemento) {
        Objects.requireNonNull(elemento, "GLS");
        if (this.elementoPresente(elemento.simbolo())) throw new IllegalArgumentException("Elemento già presente.");    
        lista.add(elemento);
        lista.sort(null);
        return lunghezza();
    }

    /**
     * Controlla se il simbolo dell'elemento indicato è presente nella tavola periodica.
     * 
     * @param simbolo il simbolo dell'elemento da cercare
     * @return true se l'elemento è presente nella tavola. False altrimenti
     */
    public boolean elementoPresente(String simbolo) {
        if (Objects.requireNonNull(simbolo, "Simbolo non può essere null.").isEmpty())
            throw new IllegalArgumentException("Simbolo non può essere vuoto.");
        Iterator<ElementoChimico> iterator = lista.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().simbolo().equals(simbolo)) return true; 
        }
        return false;
    }

    /**
     * 
     * @return la quantità di elementi presenti nella Tavola Periodica
     */
    public int lunghezza() {
        return lista.size();
    }
}
