/**
 * @autor Juan Solís
 * @description Clase que representa un árbol binario de búsqueda
 * @version 1.0
 */

class BST<E extends Comparable<E>> {
    private TreeNode root;

    /**
     * @description Clase que representa un nodo del árbol
     */
    private class TreeNode {
        E data;
        TreeNode left, right;

        public TreeNode(E item) {
            data = item;
            left = right = null;
        }
    }
    
    /**
     * @description Constructor de la clase
     */
    public BST() {
        root = null;
    }

    /**
     * @description Método que inserta un elemento en el árbol
     * @param item Elemento a insertar
     */
    public void insert(E item) {
        root = insertRec(root, item);
    }

    /**
     * @description Método que inserta un elemento en el árbol
     * @param root Raíz del árbol
     * @param item Elemento a insertar
     * @return Raíz del árbol
     */
    private TreeNode insertRec(TreeNode root, E item) {
        if (root == null) {
            root = new TreeNode(item);
            return root;
        }

        if (item.compareTo(root.data) < 0) {
            root.left = insertRec(root.left, item);

        } else if (item.compareTo(root.data) > 0) {
            root.right = insertRec(root.right, item);

        }
        return root;
    }

    /**
     * @description Método que recorre el árbol en orden
     */
    public void inorder() {
        inorderRec(root);
    }

    /**
     * @description Método que recorre el árbol en orden
     * @param node Nodo a partir del cual se recorre el árbol
     */
    private void inorderRec(TreeNode node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.println(node.data);
            inorderRec(node.right);
        }
    }
}