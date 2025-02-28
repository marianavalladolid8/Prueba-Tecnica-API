package proyecto4;
/**
 * Clase que representa un conjunto de enteros en el rango de 0 a 100
 */
public class IntegerSet {
    private boolean[] conjunto;
    private static final int TAMANIO_CONJUNTO = 101; // Para almacenar números de 0 a 100

    /**
     * Constructor sin argumentos que inicializa el conjunto como vacío
     */
    public IntegerSet() {
        conjunto = new boolean[TAMANIO_CONJUNTO];
        // Por defecto todos los valores de un array de boolean se inicializan a false,
        // pero lo hacemos explícito para mayor claridad
        for (int i = 0; i < TAMANIO_CONJUNTO; i++) {
            conjunto[i] = false;
        }
    }

    /**
     * Método que crea un nuevo conjunto que representa la unión de dos conjuntos existentes
     * @param otroConjunto Conjunto a unir con el conjunto actual
     * @return Nuevo conjunto que representa la unión
     */
    public IntegerSet union(IntegerSet otroConjunto) {
        IntegerSet resultado = new IntegerSet();

        for (int i = 0; i < TAMANIO_CONJUNTO; i++) {
            // Aplicamos la operación lógica OR
            resultado.conjunto[i] = this.conjunto[i] || otroConjunto.conjunto[i];
        }

        return resultado;
    }

    /**
     * Método que crea un nuevo conjunto que representa la intersección de dos conjuntos existentes
     * @param otroConjunto Conjunto a intersectar con el conjunto actual
     * @return Nuevo conjunto que representa la intersección
     */
    public IntegerSet interseccion(IntegerSet otroConjunto) {
        IntegerSet resultado = new IntegerSet();

        for (int i = 0; i < TAMANIO_CONJUNTO; i++) {
            // Aplicamos la operación lógica AND
            resultado.conjunto[i] = this.conjunto[i] && otroConjunto.conjunto[i];
        }

        return resultado;
    }

    /**
     * Método para insertar un nuevo elemento en el conjunto
     * @param k Elemento a insertar
     */
    public void insertElement(int k) {
        if (k >= 0 && k < TAMANIO_CONJUNTO) {
            conjunto[k] = true;
        } else {
            System.out.println("El elemento debe estar en el rango de 0 a 100");
        }
    }

    /**
     * Método para eliminar un elemento del conjunto
     * @param m Elemento a eliminar
     */
    public void deleteElement(int m) {
        if (m >= 0 && m < TAMANIO_CONJUNTO) {
            conjunto[m] = false;
        } else {
            System.out.println("El elemento debe estar en el rango de 0 a 100");
        }
    }

    /**
     * Método que devuelve una representación del conjunto como cadena
     * @return Cadena que representa el conjunto
     */
    public String toSetString() {
        StringBuilder sb = new StringBuilder();
        boolean conjuntoVacio = true;

        for (int i = 0; i < TAMANIO_CONJUNTO; i++) {
            if (conjunto[i]) {
                if (!conjuntoVacio) {
                    sb.append(" ");
                }
                sb.append(i);
                conjuntoVacio = false;
            }
        }

        if (conjuntoVacio) {
            return "-"; // Representa un conjunto vacío, no olvidar
        } else {
            return sb.toString();
        }
    }

    /**
     * Método que determina si dos conjuntos son iguales
     * @param otroConjunto Conjunto a comparar
     * @return true si los conjuntos son iguales, false en caso contrario
     */
    public boolean equalTo(IntegerSet otroConjunto) {
        for (int i = 0; i < TAMANIO_CONJUNTO; i++) {
            if (this.conjunto[i] != otroConjunto.conjunto[i]) {
                return false;
            }
        }
        return true;
    }
}