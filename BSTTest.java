import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * @autor Juan Solís
 * @description Clase para realizar pruebas unitarias a la clase BST
 */
public class BSTTest {
    private BST<Association<String, String>> bst;

    /**
     * @description Se ejecuta antes de cada test
     */
    @Before
    public void setUp() {
        bst = new BST<>();
    }

    /**
     * @description Test que prueba el método insert (hecho para no fallar)
     */
    @Test
    public void testInsert() {
        bst.insert(new Association<>("apple", "manzana"));

        assertEquals("manzana", bst.search(new Association<>("apple", "")));
    }

    /**
     * @description Test que prueba el método search (hecho para no fallar)
     */
    @Test
    public void testSearch() {
        bst.insert(new Association<>("cherry", "cereza"));

        assertEquals("cereza", bst.search(new Association<>("cherry", "")));
        assertNull(bst.search(new Association<>("orange", "")));
    }

    /**
     * @description Test que prueba el método insert (hecho para fallar)
     */
    @Test
    public void testInsertFailure() {
        bst.insert(new Association<>("apple", "manzana"));

        assertEquals("mango", bst.search(new Association<>("apple", "")));
    }
}
