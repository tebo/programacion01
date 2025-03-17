class cajaAhorro extends cuentaBanco {
    private double interes;
    
    public extends CuentaBanco(String nombre, String apellido, double saldo, double interes) {
        super(nombre, apellido, saldo);
        this.interes = interes;
    }

    public void calcularInteres() {
        double intereses = saldo * interes;
        saldo += intereses;
    }

    
}
