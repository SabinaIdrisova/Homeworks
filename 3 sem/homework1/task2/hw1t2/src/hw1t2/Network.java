package hw1t2;

import java.util.ArrayList;

public class Network {
    
    /**
     * constructor for Network
     */
    public Network() {
        this.notInfectedComputers = new ArrayList<Computer>();
        this.infectedComputers = new ArrayList<Computer>();
    }
    /**
     * add computer to network
     * @param computer computer to add
     */
    public void addComputer(Computer computer) {
        notInfectedComputers.add(computer);
    }
    
    /**
     * Start networking
     */
    public void startWorking() {
        update();
        if (infectedComputers.isEmpty()) {
            System.out.println("Network is OK!");
        } else {
            while (!isInfected) {
                System.out.println("next step");
                for (int i = 0; i < infectedComputers.size(); i++) {
                    infectedComputers.get(i).attack();
                }
                update();
                printState();
            }
        }
    }
    
    /**
     * update network's state
     */
    public void update() {
        for (int i = 0; i < notInfectedComputers.size(); i++) {
            if (notInfectedComputers.get(i).isInfected()) {
                infectedComputers.add(notInfectedComputers.get(i));
                notInfectedComputers.remove(i);
            }
        }
        if (notInfectedComputers.isEmpty()) {
            isInfected = true;
        }
    }
    
    /**
     * print current state
     */
    public void printState() {
        for (int i = 0; i < infectedComputers.size(); i++) {
            if (infectedComputers.get(i).isInfected()) {
                System.out.println(infectedComputers.get(i).getName() + " infected");
            }
        }
    }
    
    private ArrayList<Computer> infectedComputers;
    private ArrayList<Computer> notInfectedComputers;
    private boolean isInfected;
}
