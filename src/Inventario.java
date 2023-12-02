/*
 * @author fernando
 */
import java.util.HashMap;
import java.util.Map;
public class Inventario {

    private HashMap<Item, Integer> listaInventario;

    public Inventario() {
        listaInventario = new HashMap<Item, Integer>();
    } 
    
    public void adicionarItem(String nome) {
        Item objetoAdd = new Item(nome);
        if (verificarItem(nome)) {
            listaInventario.put(objetoAdd, listaInventario.get(objetoAdd).intValue() + 1);
        } else {    
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            listaInventario.put(objetoAdd, 1);
        }
    }

    public int buscarItem(String nome) {
        int indice = 0; 
        for (Map.Entry<Item, Integer> entrada : listaInventario.entrySet()) {
            Item objeto = entrada.getKey();
            if (objeto.getNome().equals(nome)) {
                return indice; 
            }
            indice++;
        }
        return -1; 
    }

    public void removerItem(String nome) {
        int indice = buscarItem(nome);
        if (indice != -1) {
            listaInventario.remove(indice);
        }
    }

    public boolean verificarItem(String nome) {
        int indice = buscarItem(nome);
        if (indice != -1) {
            return true;
        }
        return false; 
    }

    public void listarItens() {
        System.out.println("Listando itens no inventario: ");
        for (Map.Entry<Item, Integer> entrada : listaInventario.entrySet()) {
            Item objeto = entrada.getKey();
            System.out.println(objeto.getNome() + " " + entrada.getValue());           
        }
        System.out.println("Todos os itens listados.");
    }

    public boolean mochilaVazia() {
        if (listaInventario.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
