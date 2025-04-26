public abstract class CartaConPalo extends Carta {
  private Palo palo;

  public CartaConPalo(Palo palo){
      this.palo = palo;
  }

    public Palo getPalo() {
        return palo;
    }
}
