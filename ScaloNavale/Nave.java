package ScaloNavale;

import java.util.Objects;

// AF: (nome, peso) --> Il nome rappresenta il nome della nave, mentre il peso rappresenta il suo peso.

public record Nave(String nome, int peso) {

    /**
     * Crea la Nave con parametri Nome e Peso.
     * 
     * IR: nome non può essere null o vuoto. Peso deve essere positivo (> 0).
     * 
     * @param nome il nome della Nave
     * @param peso il peso della Nave
     */
    public Nave(String nome, int peso) {
        if(Objects.requireNonNull(nome, "Nome non può essere null.").isEmpty()) 
            throw new IllegalArgumentException("Nome non può essere vuoto");
        this.nome = nome;
        if (peso <= 0) 
            throw new IllegalArgumentException("Il peso deve essere positivo.");
        this.peso = peso;
    }
    
    @Override
    public String toString() {
        return nome + "[" + peso + "]";
    }
}
