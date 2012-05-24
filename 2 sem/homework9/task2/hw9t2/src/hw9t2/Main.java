package hw9t2;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         BTree tree = new BTree(1);
         tree.add(1, 2);
         tree.add(2, 3);
         tree.add(4, 5);
         tree.add(5, 6);
         tree.add(6, 7);
		 tree.add(3, 4);
         tree.add(7, 100);
        
         System.out.println(tree.search(tree.getRoot(), 2));
         System.out.println(tree.search(tree.getRoot(), 3));
         System.out.println(tree.search(tree.getRoot(), 4));
         System.out.println(tree.search(tree.getRoot(), 5));
         System.out.println(tree.search(tree.getRoot(), 6));
         System.out.println(tree.search(tree.getRoot(), 7));
    }
}
