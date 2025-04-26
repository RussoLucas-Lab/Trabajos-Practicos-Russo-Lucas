public class CartaFigura extends CartaConPalo{
    private char letra;

    public CartaFigura(Palo palo, char letra) {
        super(palo);
        this.letra = letra;
    }

    public char getLetra() {
        return letra;
    }
    @Override
    public String getRepresentacion(){
        return letra + " de " + getPalo();
    }
}
