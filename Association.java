/**
 * @autor Juan Solís
 * @description Clase que representa una asociación entre una llave y un valor
 * @version 1.0
 */

 public class Association<K extends Comparable<K>, V> implements Comparable<Association<K, V>> {
    private K key;
    private V value;

    /**
     * @description Constructor de la clase
     * @param key Llave de la asociación
     * @param value Valor de la asociación
     */
    public Association(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * @description Método que devuelve la llave de la asociación
     * @return Llave de la asociación
     */
    public K getKey() {
        return key;
    }

    /**
     * @description Método que devuelve el valor de la asociación
     * @return Valor de la asociación
     */
    public V getValue() {
        return value;
    }

    /**
     * @description Método que establece el valor de la asociación
     * @param value Valor de la asociación
     */
    @Override
    public int compareTo(Association<K, V> other) {
        return this.key.compareTo(other.getKey());
    }

    /**
     * @description Método que devuelve la representación en cadena de la asociación
     * @return Representación en cadena de la asociación
     */
    @Override
    public String toString() {
        return key.toString() + ", " + value.toString();
    }
}
