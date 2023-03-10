import java.util.Objects;

public class Molecola {
    TavolaPeriodica tavola;
    String formula;
    int peso;
    
    public Molecola (String formula) {
        if(Objects.requireNonNull(formula).isEmpty()) throw new IllegalArgumentException();
        this.formula = formula;
       // String[] elementi = Helpers.parseFormula(formula);
       // for (int i=0; i<elementi.length; i+=2) {
       //     if (!tavola.elementoPresente(elementi[i])) throw new IllegalArgumentException();
       //     
       // }
    }
}
