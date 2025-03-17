package POO;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
		// Crear un objeto de la clase Persona
    	Persona p1 = new Persona();
    	//p1.nombre = "Juan";
		p1.apellido = "Lopez";
    	p1.edad = 25;
		p1.ocupacion = "Estudiante";
		p1.ci = "123456";
		p1.genero = "Masculino";
   	 
    	// Llamar al método
    	p1.mostrarInformacion();

		p1.Alimentar();
		p1.cambioOcupacion("Ingeniero");
		p1.cambioGenero("Femenino");
		p1.mostrarInformacion();

		Persona p2 = new Persona();
		p2.apellido = "Perez";
		p2.edad = 30;
		p2.ocupacion = "Doctora";
		p2.ci = "654321";
		p2.genero = "Femenino";
   	 
		// Llamar al método
		p2.mostrarInformacion();

		System.out.println("Ingrese nuevo nombre: ");
		String nuevoNombre = sc.nextLine();
		p2.setNombre(nuevoNombre);
		p2.mostrarInformacion();
		
		System.out.println("Ingrese nueva ocupacion]: ");
		String nuevaOcupacion = sc.nextLine();
		p2.cambioOcupacion(nuevaOcupacion);
		p2.mostrarInformacion();
		sc.close();
	}
}

