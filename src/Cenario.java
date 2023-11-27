/*
 * @author helio
 */

import java.util.ArrayList;
import java.util.Random;

public class Cenario {
    private ArrayList<String> saida;
    private boolean temItem;
    private String item;
    private int sorteioItem;
    private Random rand;
    private boolean first;
    private boolean last;

    public Cenario(boolean first, boolean last) {
        this.first = first;
        this.last = last;

        saida = new ArrayList<String>();

        if (first) {
            saida.add("sul");
        } else if (last) {
            saida.add("norte");
        } else {
            saida.add("sul");
            saida.add("norte");
        }

        rand = new Random();
        sorteioItem = rand.nextInt(10);

        if (sorteioItem < 3) {
            temItem = true;
        }

        if (temItem) {
            String[] itens = { "java coffee", "rebimboca da parafuseta", "combustivel" };
            item = itens[rand.nextInt(itens.length)];
        }
    }

    public boolean getTemItem() { // Fernando: mudei pra public 
        return temItem;
    }

    public String getItem() {
        if (getTemItem()) {
            return item;
        }
        return null;
    }

    public void removeItem() { // Fernando: função para caso o item tenha sido pego do cenário atual 
        if (getTemItem()) {
            temItem = false; 
            item = null; 
        }
    }

    public ArrayList<String> getSaida() {
        return saida;
    }
}
