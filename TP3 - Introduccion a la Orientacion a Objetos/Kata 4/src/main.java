import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        ArrayList<Gallinas> listaGallinas = new ArrayList<>();

        listaGallinas.add(new Gallinas(2, 10));
        listaGallinas.add(new Gallinas(1, 5));

        for (Gallinas g : listaGallinas) {
            g.ponerHuevo();
            g.envejecer();
        }
        for (Gallinas g : listaGallinas) {
            g.mostrarEstado();
        }

    }
}
