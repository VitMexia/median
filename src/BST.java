public class BST<E extends Comparable<E>> {

    private static class Node<E>{
            E key;
            Node<E> left, right, parent;
            Node(E v){ key= v; }
        }
        private Node<E> root;

        public static <E extends Comparable<E>> boolean less(E f, E g){
            return (f.compareTo(g)<0)? true:false;
        }
        public static <E extends Comparable<E>> boolean equals(E f, E g){
            return (f.compareTo(g)==0)? true:false;
        }
}

