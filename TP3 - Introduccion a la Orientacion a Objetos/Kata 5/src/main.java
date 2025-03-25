public class main {
    public static void main(String[] args) {
        NaveEspacial n1 = new NaveEspacial("Interceptor", 50);

        n1.avanzar(60);
        n1.recargarCombustible(40);
        n1.avanzar(60);
        n1.mostrarEstado();
    }
}
