import java.util.ArrayList;
import java.util.Random;

public class Cenario {
    private ArrayList<String> saida;
    private boolean temItem;
    private String item;
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
        temItem = rand.nextBoolean();

        if (temItem) {
            String[] itens = { "java coffee", "rebimboca da parafuseta", "combustivel" };
            item = itens[rand.nextInt(itens.length)];
        }
    }

    private boolean getTemItem() {
        return temItem;
    }

    public String getItem() {
        if (getTemItem()) {
            return item;
        }
        return null;
    }

    public ArrayList<String> getSaida() {
        return saida;
    }
}
