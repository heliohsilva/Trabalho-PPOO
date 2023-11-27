/*
 * @author fernando
 */
public class Item {

    private String nome; 

    public Item(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}
/*
import java.util.Random;

public class Item {
    
    private String nome;

    public Item() {
        nome = gerarItem();
    }

    private String gerarItem() {
        String[] possiveisItens = { "java coffee", "rebimboca da parafuseta", "combustivel" };
        Random rand = new Random();
        int valor = rand.nextInt(2);
        String escolhido = possiveisItens[valor]; 
        return escolhido; 
    }

} */