public class Nave {
    private int combustivel; // usada para viajar entre planetas.
    private boolean estado;

    public Nave() {
        combustivel = 100;
        estado = true; // nave esta funcionando. if false, nave quebrada
    }

    public void incrementarCombustivel(int incremento) {
        combustivel += incremento;
    }

    public void decrementarCombustivel(int decremento) {
        combustivel -= decremento;
    }

    public int getCombustivel() {
        return combustivel;
    }

    public void quebrar() {
        estado = false;
    }

    public boolean getEstado() {
        return estado;
    }
}
