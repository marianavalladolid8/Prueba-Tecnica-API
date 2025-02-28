package proyecto1;

public class Propietario {
    private String nombre;
    private String cpf;
    private String dni;
    private String fechaNacimiento;
    private Direccion direccion;

    // Constructor con parámetros obligatorios y dirección
    public Propietario(String nombre, String cpf, String dni, Direccion direccion) {
        this.nombre = nombre;
        this.cpf = cpf;
        this.dni = dni;
        this.direccion = direccion;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}