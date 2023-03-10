package bancarelle;

import java.util.Objects;

/* Questa classe è presa dalle soluzioni a scopo di capire come implementare una classe. */

public final class Giocattolo {
    // Attributi
    private String nome, materiale;

    // RI: nome e materiale sono non null e non vuoti.
    /**
   * Costruisce un giocattolo dato nome e materiale.
   *
   * @param nome il nome del giocattolo, deve essere una stringa non vuota.
   * @param materiale il materiale di cui è costituito il giocattolo, deve essere una stringa non
   *     vuota.
   * @throws NullPointerException se nome o materiale sono {@code null}
   * @throws IllegalArgumentException se nome o materiale sono stringhe vuote.
   */
    public Giocattolo(final String nome, final String materiale) {
        this.nome = Objects.requireNonNull(nome, "Il nome non può essere null.");
        this.materiale = Objects.requireNonNull(materiale, "Il materiale non può essere null");
        if (nome.isEmpty() || materiale.isEmpty())
            throw new IllegalArgumentException("Nome e materiale non devono essere vuoti.");
    }
    
    /**
     * Restituisce il nome del giocattolo.
     * 
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Restituisce il materiale del giocattolo.
     * 
     * @return materiale
     */
    public String getMateriale() {
        return materiale;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, materiale);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Giocattolo)) return false;
        final Giocattolo tmp = (Giocattolo) obj;
        return tmp.nome.equals(nome) && tmp.materiale.equals(materiale);
    }

    @Override
    public String toString() {
        return nome + " di " + materiale;
    }
}

