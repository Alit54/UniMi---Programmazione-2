package bancarelle;

public class Bancarella {
    // Attributi
    private String proprietario;
    private Inventario inventario;
    private Listino listino;
    public Bancarella(String proprietario, Inventario inventario, Listino listino) {
        this.proprietario = proprietario;
        this.inventario = inventario;
        this.listino = listino;
    }
    public String getProprietario() {
        return this.proprietario;
    }
    public Inventario getInventario() {
        return this.inventario;
    }
    public Listino getListino() {
        return this.listino;
    }
}
