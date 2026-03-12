package POO.paquetebase;
public class CuentaBancaria {
    String titular;
    double saldo;

    public CuentaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double cantidad) {
        saldo += cantidad;
        System.out.println(titular + " depositó $" + cantidad + ". Saldo nuevo: $" + saldo);
    }

    public void retirar(double cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
            System.out.println(titular + " retiró $" + cantidad);
        } else {
            System.out.println("Saldo insuficiente para " + titular);
        }
    }
}