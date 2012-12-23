package hw1t2;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Network network = new Network();
        Computer comp1 = new Computer(new Windows(), "computer1");
        Computer comp2 = new Computer(new Windows(), "computer2");
        Computer comp3 = new Computer(new Linux(), "computer3");
        network.addComputer(comp1);
        network.addComputer(comp2);
        network.addComputer(comp3);
        comp2.connect(comp3);
        comp3.connect(comp1);
        comp2.setInfected(); 
        network.startWorking();  
    }
}
