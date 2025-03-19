package POO;

abstract class figura {
    private String color;
    private String nombre;
    protected int area;
    protected int perimetro;

    public abstract double calcularArea();
    
    public figura(String color, String nombre, int area, int perimetro) {
        this.color = color;
        this.nombre = nombre;
        this.area = area;
        this.perimetro = perimetro;
    }

    public void mostrarDatos(){
        System.out.println("Color: "+color);
        System.out.println("Nombre: "+nombre);
        System.out.println("Area: "+area);
        System.out.println("Perimetro: "+perimetro);
    }
}

class circulo extends figura {
    private double radio;

    public circulo(String color, String nombre, int area, int perimetro, double radio) {
        super(color, nombre, area, perimetro);
        this.radio = radio;
    }

    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println("Radio: "+radio);
    }

    public double calcularArea(){
        area = (int) (Math.PI * Math.pow(radio, 2));
        return area;
    }

}

class rectangulo extends figura {
    private double base;
    private double altura;

    public rectangulo(String color, String nombre, int area, int perimetro, double base, double altura) {
        super(color, nombre, area, perimetro);
        this.base = base;
        this.altura = altura;
    }

    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println("Base: "+base);
        System.out.println("Altura: "+altura);
    }

    public double calcularArea(){
        area = (int) (base * altura);
        return area;
    }

    public void calcularPerimetro(){
        perimetro = (int) (2 * base + 2 * altura);
    }
}

class exagono extends figura {
    private double lado;

    public exagono(String color, String nombre, int area, int perimetro, double lado) {
        super(color, nombre, area, perimetro);
        this.lado = lado;
    }

    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println("Lado: "+lado);
    }

    public double calcularArea(){
        area = (int) (3 * Math.sqrt(3) * Math.pow(lado, 2) / 2);
        return area;
    }

    public void calcularPerimetro(){
        perimetro = (int) (6 * lado);
    }
}

class ejercicioFiguras {
    public static void main(String[] args) {
    circulo circulo1 = new circulo("Rojo", "Circulo", 0, 0, 5);
    circulo1.calcularArea();
    circulo1.mostrarDatos();

    rectangulo rectangulo1 = new rectangulo("Azul", "Rectangulo", 0, 0, 5, 10);
    rectangulo1.calcularArea();
    rectangulo1.calcularPerimetro();
    rectangulo1.mostrarDatos();

    exagono exagono1 = new exagono("Verde", "Exagono", 0, 0, 5);
    exagono1.calcularArea();
    exagono1.calcularPerimetro(); 
    exagono1.mostrarDatos();
}

}