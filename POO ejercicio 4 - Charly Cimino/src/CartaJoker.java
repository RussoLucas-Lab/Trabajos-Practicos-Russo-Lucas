public class CartaJoker extends Carta{
    private boolean aColor;
    public CartaJoker(boolean aColor){
        super();
        this.aColor = aColor;
    }

    public boolean isaColor() {
        return aColor;
    }

    @Override
        public String getRepresentacion(){
        return "Jocker: " + (aColor ? "color" : "b&n");
    }
}
