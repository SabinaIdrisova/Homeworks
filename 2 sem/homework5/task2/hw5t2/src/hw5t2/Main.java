package hw5t2;

public class Main {

    public static void main(String[] args) {
        UniqueList list = new UniqueList();
        try {
            list.addToStart(1);
        } catch (ElementExistsInListException ex) {
           System.out.println("Element 1 already exists in list!");
        }
        try {
            list.addToStart(3);
        } catch (ElementExistsInListException ex) {
            System.out.println("Element 3 already exists in list!");
        }
        try {
            list.addToStart(1);
        } catch (ElementExistsInListException ex) {
            System.out.println("Element 1 already exists in list!");
        }
        try {
            list.removeElement(4);
        } catch (RemoveElementNonexistInListException ex) {
            System.out.println("Element 4 non-exists in list!");
        }
        try {
            list.removeElement(1);
        } catch (RemoveElementNonexistInListException ex) {
            System.out.println("Element 1 non-exists in list!");
        }
        list.printList(); 
    }
}
