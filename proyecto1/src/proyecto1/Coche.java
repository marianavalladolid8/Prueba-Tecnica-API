package proyecto1;

public class Coche {
    private String modelo;
    private String color;
    private int ano;
    private Marca marca;
    private String chasis;
    private Propietario propietario;
    private int velocidadMaxima;
    private int velocidadActual;
    private int numeroPuertas;
    private boolean tieneTechoSolar;
    private int numeroMarchas;
    private boolean transmisionAutomatica;
    private String transmision;
    private double volumenCombustible;
    private double repostaje;

    // Constructor con propietario
    public Coche(Propietario propietario, Marca marca) {
        this.propietario = propietario;
        this.marca = marca;
        this.velocidadActual = 0;
    }

    // Método para acelerar
    public void acelerar() {
        if (velocidadActual < velocidadMaxima) {
            velocidadActual++;
            System.out.println("Acelerando. Velocidad actual: " + velocidadActual + " km/h");
        } else {
            System.out.println("El vehículo ya está en su velocidad máxima");
        }
    }

    // Método para frenar
    public void frenar() {
        velocidadActual = 0;
        System.out.println("Vehículo detenido");
    }

    // Método para cambiar marcha
    public void cambiarMarcha(int nuevaMarcha) {
        if (nuevaMarcha < 0 && velocidadActual > 0) {
            System.out.println("No se puede engranar la marcha atrás si la velocidad es superior a 0 KM/h");
            return;
        }

        if (nuevaMarcha <= numeroMarchas && nuevaMarcha >= -1) {
            System.out.println("Cambiando a marcha: " + (nuevaMarcha == -1 ? "R" : nuevaMarcha));
        } else {
            System.out.println("Marcha no válida");
        }
    }

    // Método para reducir marcha
    public void reducirMarcha() {
        // Implementación de reducción de marcha
        System.out.println("Reduciendo marcha");
    }

    // Método para calcular autonomía
    public double calcularAutonomia(double consumoPorKm) {
        if (consumoPorKm <= 0) {
            return 0;
        }
        return volumenCombustible / consumoPorKm;
    }

    // Método para mostrar volumen de combustible
    public void mostrarVolumenCombustible() {
        System.out.println("Volumen de combustible actual: " + volumenCombustible + " litros");
    }

    // Getters y Setters
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public int getVelocidadActual() {
        return velocidadActual;
    }

    public void setVelocidadActual(int velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public boolean isTieneTechoSolar() {
        return tieneTechoSolar;
    }

    public void setTieneTechoSolar(boolean tieneTechoSolar) {
        this.tieneTechoSolar = tieneTechoSolar;
    }

    public int getNumeroMarchas() {
        return numeroMarchas;
    }

    public void setNumeroMarchas(int numeroMarchas) {
        this.numeroMarchas = numeroMarchas;
    }

    public boolean isTransmisionAutomatica() {
        return transmisionAutomatica;
    }

    public void setTransmisionAutomatica(boolean transmisionAutomatica) {
        this.transmisionAutomatica = transmisionAutomatica;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public double getVolumenCombustible() {
        return volumenCombustible;
    }

    public void setVolumenCombustible(double volumenCombustible) {
        this.volumenCombustible = volumenCombustible;
    }

    public double getRepostaje() {
        return repostaje;
    }

    public void setRepostaje(double repostaje) {
        this.repostaje = repostaje;
    }
}
