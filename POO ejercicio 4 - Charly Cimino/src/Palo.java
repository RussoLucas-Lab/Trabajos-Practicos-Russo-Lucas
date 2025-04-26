public enum Palo {

    DIAMANTE(Color.ROJO),
    CORAZON(Color.ROJO),
    PICA(Color.NEGRO),
    TREBOL(Color.NEGRO);

    private Color color;

    Palo(Color color) {
        this.color = color;
    }
}
