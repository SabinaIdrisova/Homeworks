
package task3;

public class Main {

    public static void main(String[] args) {
        List list = new List();
	list.addToStart(6);
	list.addToStart(8);
        list.addToEnd(14);
        ListElement position = list.firstPosition();
        list.insert(8, position);
        position = list.lastPosition();
        list.insert(9, position);
        position = list.firstPosition();
        list.insert(4, list.nextPosition(position));
	list.printList();
    }
}
