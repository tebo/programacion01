package POO.paquetebase;
public class Main {
    public static void main(String[] args) {
        // Creamos objetos (instanciación)
        Coche miCoche = new Coche("Toyota", "Rojo");
        Persona alumno = new Persona("Carlos", 20);
        CuentaBancaria miCuenta = new CuentaBancaria("Ana", 500.0);

        // Usamos sus métodos
        miCoche.acelerar();
        alumno.saludar();
        miCuenta.retirar(100.0);
    }
}