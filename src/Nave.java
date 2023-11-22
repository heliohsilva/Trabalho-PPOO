public class Nave {
    private int combustivel; // usada para viajar entre planetas.
    private boolean estado;

    public Nave() {
        combustivel = 20;
        estado = true; // nave esta funcionando. if false, nave quebrada
    }

    public void incrementarCombustivel(int incremento) {
        combustivel += incremento;
    }

    public void decrementarCombustivel(int decremento) {
        combustivel -= decremento;
    }

    public void decrementarCombustivel(int numerador, int denominador) {
        combustivel -= combustivel * Math.floor(numerador / denominador);
    }

    public int getCombustivel() {
        return combustivel;
    }

    public void quebrar() {
        estado = false;
    }

    public void consertar() {
        estado = true;
    }

    public boolean getEstado() {
        return estado;
    }
}
