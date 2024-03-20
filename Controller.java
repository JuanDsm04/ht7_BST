import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @autor Juan Solís
 * @description Clase que representa el controlador del programa
 * @version 1.0
 */
public class Controller {
    private BST<Association<String, String>> tree;

    /**
     * @description Constructor de la clase
     */
    public Controller() {
        tree = new BST<>();
        llenarArbolConDiccionario();
    }

    /**
     * @description Método que llena el árbol con el diccionario
     */
    private void llenarArbolConDiccionario() {
        try (BufferedReader br = new BufferedReader(new FileReader("diccionario.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.split(",");
                String key = words[0].trim();
                String value = words[1].trim().substring(0, words[1].length() - 1);
                Association<String, String> association = new Association<>(key, value);
                tree.insert(association);
            }
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    /**
     * @description Método que muestra el diccionario
     */
    public void mostrarDiccionario() {
        System.out.println("Diccionario en orden:");
        tree.inorder();
    }
    
    /**
     * @description Método que traduce un archivo
     */
    public void traducir(){
        try (BufferedReader br = new BufferedReader(new FileReader("diccionario.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.split(",");
                String key = words[0].trim().substring(1);
                String value = words[1].trim().substring(0, words[1].length() - 1); // Eliminar el último carácter ")"
                Association<String, String> association = new Association<>(key, value);
                tree.insert(association);
            }

        } catch (IOException e){
            System.out.println("Error al leer el archivo");
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader("traducir.txt"))) {
            String line;
            StringBuilder translatedText = new StringBuilder();

            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    String translatedWord = translateWord(word, tree);
                    translatedText.append(translatedWord).append(" ");
                }
            }

            System.out.println("Texto traducido:");
            System.out.println(translatedText.toString());

        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }
    }
    
    /**
     * @description Método que traduce una palabra
     * @param word Palabra a traducir
     * @param tree Árbol BST
     * @return Palabra traducida
     */
    private static String translateWord(String word, BST<Association<String, String>> tree) {
        Association<String, String> association = tree.search(new Association<>(word, ""));

        if (association != null) {
            String translatedWord = association.getValue();
            
            if (!translatedWord.isEmpty()) {
                translatedWord = translatedWord.substring(0, translatedWord.length() - 1);
            }

            return translatedWord;

        } else {
            return "*" + word + "*";
        }
    }
}