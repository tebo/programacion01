public class cuentaBanco {
    private String nombre;
    private String apellido;
    protected double saldo;
    int numeroCuenta;


    public cuentaBanco(String nombre, String apellido, double saldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroCuenta = (int) (Math.random() * 1000);
        this.saldo = saldo;
    }

    public void depositar(double cantidad) {
        saldo += cantidad;
    }

    public void retirar(double cantidad) {
        if (cantidad > saldo) {
            System.out.println("Saldo insuficiente");
            return;
        } else {
        saldo -= cantidad;
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}
//clase cajadeahorro hereda d cuentaBanco
class cajadeahorro extends cuentaBanco {
    private double interes;
    
    public cajadeahorro(String nombre, String apellido, double saldo, double interes) {
        super(nombre, apellido, saldo);
        this.interes = interes;
    }

    public void calcularInteres() {
        double intereses = saldo * interes;
        saldo += intereses;
    }
}

class EjercicioBanco {
    public static void main(String[] args) {
        cuentaBanco cuenta = new cuentaBanco("Juan", "Perez", 1000);
        cuenta.depositar(500);
        cuenta.retirar(200);
        System.out.println("Nombre: " + cuenta.getNombre());
        System.out.println("Apellido: " + cuenta.getApellido());
        System.out.println("Numero de cuenta: " + cuenta.getNumeroCuenta());
        System.out.println("Saldo: " + cuenta.getSaldo());

        cajadeahorro caja = new cajadeahorro("Maria", "Lopez", 2000, 0.1);
        caja.depositar(500);
        caja.calcularInteres(); // 2000 + 2000 * 0.1 = 2200
        caja.retirar(200);
        System.out.println("Nombre: " + caja.getNombre());
        System.out.println("Apellido: " + caja.getApellido()); 
        System.out.println("Numero de cuenta: " + caja.getNumeroCuenta());
        System.out.println("Saldo: " + caja.getSaldo());
    }   
}