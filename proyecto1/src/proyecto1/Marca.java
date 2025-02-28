package proyecto1;

public class Marca {
    private String nombre;
    private int nrOfModels;
    private int anoLanzamiento;
    private String codigo;

    // Constructor
    public Marca(String nombre, int nrOfModels, int anoLanzamiento, String codigo) {
        this.nombre = nombre;
        this.nrOfModels = nrOfModels;
        this.anoLanzamiento = anoLanzamiento;
        this.codigo = codigo;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNrOfModels() {
        return nrOfModels;
    }

    public void setNrOfModels(int nrOfModels) {
        this.nrOfModels = nrOfModels;
    }

    public int getAnoLanzamiento() {
        return anoLanzamiento;
    }

    public void setAnoLanzamiento(int anoLanzamiento) {
        this.anoLanzamiento = anoLanzamiento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
