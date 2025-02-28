package proyecto1;

public class Main {
    public static void main(String[] args) {
        // Crear dirección
        Direccion direccion = new Direccion(
                "Calle Benito Juarez",
                "El Salto",
                "GDL",
                "Jalisco",
                "48091",
                "Piso 2A"
        );

        // Crea propietario
        Propietario propietario = new Propietario(
                "Mar Valladolid",
                "12345678X",
                "Z9876543",
                direccion
        );
        propietario.setFechaNacimiento("28/04/1995");

        // Crea marca
        Marca marca = new Marca(
                "Toyota",
                15,
                1937,
                "TOY-001"
        );

        // Crea coche
        Coche coche = new Coche(propietario, marca);
        coche.setModelo("Corolla");
        coche.setColor("Azul");
        coche.setAno(2022);
        coche.setChasis("9BRBLWHEXG0000001");
        coche.setVelocidadMaxima(180);
        coche.setNumeroPuertas(4);
        coche.setTieneTechoSolar(false);
        coche.setNumeroMarchas(6);
        coche.setTransmisionAutomatica(true);
        coche.setTransmision("CVT");
        coche.setVolumenCombustible(45.0);

        // Demostración de uso
        System.out.println("Información del Vehículo:");
        System.out.println("Marca: " + coche.getMarca().getNombre());
        System.out.println("Modelo: " + coche.getModelo());
        System.out.println("Propietario: " + coche.getPropietario().getNombre());
        System.out.println("Dirección: " + coche.getPropietario().getDireccion().getCalle() + ", "
                + coche.getPropietario().getDireccion().getCiudad());

        // Probar métodos
        coche.mostrarVolumenCombustible();
        System.out.println("Autonomía estimada (con consumo de 0.1L/km): "
                + coche.calcularAutonomia(0.1) + " km");

        coche.acelerar();
        coche.acelerar();
        coche.acelerar();

        // Intentar poner marcha atrás con velocidad > 0
        coche.cambiarMarcha(-1);

        coche.frenar();

        // Ahora sí debería permitir poner marcha atrás
        coche.cambiarMarcha(-1);
    } // Espero no chocar
}
