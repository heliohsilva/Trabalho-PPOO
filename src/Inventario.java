/*
 * @author fernando
 */
import java.util.ArrayList;
public class Inventario {

    private ArrayList<Item> listaInventario;

    public Inventario() {
        listaInventario = new ArrayList<>();
    } 
    
    public void adicionarItem(String nome) {
        Item objetoAdd = new Item(nome);
        listaInventario.add(objetoAdd);
    }

    public int buscarItem(String nome) {
        int indice = 0; 
        for (Item objeto : listaInventario) {
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
        for (Item objeto : listaInventario) {
            System.out.println(objeto.getNome());           
        }
        System.out.println("Todos os itens listados.");
    }

}
