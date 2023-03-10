import java.util.Objects;

public record ElementoChimico(int numeroatomico, String nome, String simbolo, float peso) implements Comparable<ElementoChimico> {

    /**
     * Metodo costruttore del record ElementoChimico.
     * 
     * @param numeroatomico il numero di protoni dell'elemento
     * @param nome il nome dell'elemento
     * @param simbolo il simbolo dell'elemento
     * @param peso il peso dell'elemento espresso in Dalton
     * @throws IllegalArgumentException se numeroatomico < 1, se peso < 0 o se nome e simbolo sono ""
     * @throws NullPointerException se nome o peso sono null
     */
    public ElementoChimico(int numeroatomico, String nome, String simbolo, float peso) {
        if (numeroatomico < 1) throw new IllegalArgumentException("Numero atomico non può essere minore o uguale a 0.");
        if (peso < 0) throw new IllegalArgumentException("Peso non può essere minore a 0.");
        if (Objects.requireNonNull(nome, "Nome non può essere null.").isEmpty())
            throw new IllegalArgumentException("Nome non può essere vuoto.");
        if (Objects.requireNonNull(simbolo, "Nome non può essere null.").isEmpty())
            throw new IllegalArgumentException("Nome non può essere vuoto.");
        this.numeroatomico = numeroatomico;
        this.peso = peso;
        this.nome = nome;
        this.simbolo = simbolo;
    }

    @Override
    public int compareTo(ElementoChimico obj) {
        Objects.requireNonNull(obj, "Obj non può essere null.");
        if (this.numeroatomico < obj.numeroatomico) return -1;
        if (this.numeroatomico > obj.numeroatomico) return 1;
        return 0;
    }

    @Override
    public String toString() {
        String out = "";
        out += "numero atomico: " + this.numeroatomico + "\n";
        out += "nome: " + this.nome + "\n";
        out += "simbolo: " + this.simbolo + "\n";
        out += "peso: " + this.peso;
        return out;
    }
    
}
