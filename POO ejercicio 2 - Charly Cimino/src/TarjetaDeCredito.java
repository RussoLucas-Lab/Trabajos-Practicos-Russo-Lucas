public class TarjetaDeCredito {
    private String entidadBancaria;
    private String numero;
    private double saldo;
    private  EntidadFinanciera entidadFinanciera;
    private Persona titular;

    public TarjetaDeCredito(String entidadBancaria, String numero, double saldo, EntidadFinanciera entidadFinanciera, Persona titular) {
        this.entidadBancaria = entidadBancaria;
        this.numero = numero;
        this.saldo = saldo;
        this.entidadFinanciera = entidadFinanciera;
        this.titular = titular;
    }

    public boolean tieneSaldoDisponible(double monto){
        return saldo >= monto;
    }

    public void descontar(double monto){
        saldo -=monto;
    }

    public String nombreCompletoDeTitular(){
        return titular.nombreCompleto();
    }

    @Override
    public String toString() {
        return "TarjetaDeCredito{" +
                "entidadBancaria='" + entidadBancaria + '\'' +
                ", numero='" + numero + '\'' +
                ", saldo=" + saldo +
                ", entidadFinanciera=" + entidadFinanciera +
                ", titular=" + titular +
                '}';
    }
}
