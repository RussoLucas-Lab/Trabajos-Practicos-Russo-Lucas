public class Test {
    public static void main(String[] args) {
        Fabrica f1 = new Fabrica();

        Sucursal s1 = new Sucursal("sucursal 1");
        Sucursal s2 = new Sucursal("sucursal 2");
        Sucursal s3 = new Sucursal("sucursal 3");

        Instrumento i1 = new Instrumento("001", 100.00, TipoInstrumento.CUERDA);
        Instrumento i2 = new Instrumento("002", 150.00, TipoInstrumento.VIENTO);
        Instrumento i3 = new Instrumento("003", 200.00, TipoInstrumento.PERCUSION);
        Instrumento i4 = new Instrumento("004", 100.00, TipoInstrumento.CUERDA);
        Instrumento i5 = new Instrumento("005", 100.00, TipoInstrumento.CUERDA);

        f1.agregarSucursal(s1);

        s1.agregarInstrumento(i1);
        s1.agregarInstrumento(i2);
        s1.agregarInstrumento(i3);
        s1.agregarInstrumento(i4);
        s1.agregarInstrumento(i5);

        s1.mostrarInstrumentos();
        s1.borrarInstrumento("005");
        s1.mostrarInstrumentos();


    }
}
