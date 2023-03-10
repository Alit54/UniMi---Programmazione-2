package ScaloNavale;

import java.util.Scanner;

public class Java {
    /*
     * Il seguente tema d'esame è giusto, se si esclude la presenza della classe Scalo che, con la seguente implementazione,
     * risulta inutile.
     * La classe "Molo" sarebbe dovuta essere private e accessibile unicamente dalla classe Scalo.
     * Il metodo sposta() dei rimorchiatori avrebbe dovuto avere in ingresso uno Scalo invece dei due moli.
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroMoli = scanner.nextInt();
        Molo[] moli = new Molo[numeroMoli];
        for (int i=0; i<numeroMoli; i++) {
            String stringa = scanner.nextLine();
            String[] riga = stringa.split(" ");
            Molo molo = new Molo();
            for (int j=0; j<riga.length; j+=2) {
                int peso = Integer.parseInt(riga[j+1]);
                Nave nave = new Nave(riga[j], peso);
                molo.add(nave);
            }
            moli[i] = molo;
        }
        scanner.close();
        Scalo scalo = new Scalo(moli);
        Rimorchiatore mini = new RimorchiatoreMini();
        int[] conversione = new int[args.length];
        for (int i=0; i<args.length; i++) {
            conversione[i] = Integer.parseInt(args[i]);
        }
        System.out.println(scalo);
        scalo.sposta(mini, conversione[0], conversione[1], conversione[2]);
        // Stampo risultati
        System.out.println(scalo);
    }
}