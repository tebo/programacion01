/**
 * Programa 2: Encapsulación y Métodos Setters
 * Demuestra: Control de atributos, validaciones y métodos para modificar estado
 */

public class CuentaBancaria {
    // Atributos privados - Solo accesibles dentro de la clase
    private String numeroCuenta;
    private String titular;
    private double saldo;

    // Constructor
    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    // Getters - Métodos para obtener información
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    // Setters - Métodos para modificar información (con validación)
    public void setTitular(String titular) {
        if (titular != null && !titular.isEmpty()) {
            this.titular = titular;
        } else {
            System.out.println("Error: El titular no puede estar vacío");
        }
    }

    // Método para depositar dinero
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("✓ Depósito de $" + cantidad + " realizado exitosamente");
        } else {
            System.out.println("✗ La cantidad debe ser mayor a 0");
        }
    }

    // Método para retirar dinero
    public void retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            System.out.println("✓ Retiro de $" + cantidad + " realizado exitosamente");
        } else if (cantidad > saldo) {
            System.out.println("✗ Fondos insuficientes. Saldo actual: $" + saldo);
        } else {
            System.out.println("✗ La cantidad debe ser mayor a 0");
        }
    }

    // Método para mostrar el estado de la cuenta
    public void mostrarEstado() {
        System.out.println("\n--- Estado de la Cuenta ---");
        System.out.println("Número de Cuenta: " + numeroCuenta);
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: $" + saldo);
        System.out.println("------------------------");
    }

    // Método main para probar la clase
    public static void main(String[] args) {
        // Crear una cuenta bancaria
        CuentaBancaria cuenta = new CuentaBancaria("1234567890", "Juan Pérez", 1000);

        cuenta.mostrarEstado();

        // Realizar operaciones
        cuenta.depositar(500);
        cuenta.mostrarEstado();

        cuenta.retirar(200);
        cuenta.mostrarEstado();

        cuenta.retirar(2000); // Intenta retirar más de lo que tiene
        cuenta.mostrarEstado();

        // Modificar el titular
        cuenta.setTitular("Juan Carlos Pérez");
        System.out.println("Nuevo titular: " + cuenta.getTitular());
    }
}
