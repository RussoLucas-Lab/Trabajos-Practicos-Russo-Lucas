public class CartaNumeral extends CartaConPalo{
    private int numero;

    public CartaNumeral(Palo palo, int numero) {
        super(palo);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String getRepresentacion(){
        return numero + " de " + getPalo();
    }
}
