package proyecto4;
/* Clase para probar la funcionalidad*/
public class TestIntegerSet {

    public static void main(String[] args) {
        // Crea dos conjuntos vacíos
        IntegerSet conjunto1 = new IntegerSet();
        IntegerSet conjunto2 = new IntegerSet();

        // Muestra conjuntos vacíos
        System.out.println("Conjunto 1 (vacío): " + conjunto1.toSetString());
        System.out.println("Conjunto 2 (vacío): " + conjunto2.toSetString());

        // Inserta elementos en el conjunto 1
        conjunto1.insertElement(5);
        conjunto1.insertElement(10);
        conjunto1.insertElement(15);
        conjunto1.insertElement(20);

        // Inserta elementos en el conjunto 2
        conjunto2.insertElement(10);
        conjunto2.insertElement(20);
        conjunto2.insertElement(30);
        conjunto2.insertElement(40);

        // Muestra los conjuntos después de insertar elementos
        System.out.println("\nConjunto 1: " + conjunto1.toSetString());
        System.out.println("Conjunto 2: " + conjunto2.toSetString());

        // Prueba si los conjuntos son iguales
        System.out.println("\n¿Los conjuntos son iguales? " + conjunto1.equalTo(conjunto2));

        // Crea un conjunto 3 igual al conjunto 1
        IntegerSet conjunto3 = new IntegerSet();
        conjunto3.insertElement(5);
        conjunto3.insertElement(10);
        conjunto3.insertElement(15);
        conjunto3.insertElement(20);

        // Prueba si conjunto1 y conjunto3 son iguales
        System.out.println("¿Conjunto 1 y Conjunto 3 son iguales? " + conjunto1.equalTo(conjunto3));

        // Calcula la unión de conjunto1 y conjunto2
        IntegerSet unionConjuntos = conjunto1.union(conjunto2);
        System.out.println("\nUnión de Conjunto 1 y Conjunto 2: " + unionConjuntos.toSetString());

        // Calcula la intersección de conjunto1 y conjunto2
        IntegerSet interseccionConjuntos = conjunto1.interseccion(conjunto2);
        System.out.println("Intersección de Conjunto 1 y Conjunto 2: " + interseccionConjuntos.toSetString());

        // Elimina un elemento del conjunto1
        conjunto1.deleteElement(5);
        System.out.println("\nConjunto 1 después de eliminar el elemento 5: " + conjunto1.toSetString());

        // Prueba con un valor fuera del rango
        System.out.println("\nIntentando insertar un valor fuera del rango (101):");
        conjunto1.insertElement(101);
    }
}