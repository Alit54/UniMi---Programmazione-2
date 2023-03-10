package ScaloNavale;

public interface Rimorchiatore {
    /**
     * Sposta un numero di navi da un molo all'altro.
     * 
     * IR: Il molo di partenza e di arrivo non devono essere nulli. La quantità deve essere > 0.
     * 
     * @param partenza il molo di partenza.
     * @param arrivo il molo d'arrivo.
     * @param quantità la quantità di navi da spostare.
     * @throws IllegalArgumentException se la quantità è <= 0 o se quantità è minore di quante navi sono nel molo di partenza.
     * @throws NullPointerException se almeno uno dei due moli è null.
     * @return true se le navi sono state spostate correttamente, false altrimenti.
     */
    boolean sposta(Molo partenza, Molo arrivo, int quantità);
}