package bancarelle;

public interface Listino {
    public boolean conosce(Giocattolo giocattolo);
    public int prezzoComplessivo(Giocattolo giocattolo, int numDaComprare);
}
