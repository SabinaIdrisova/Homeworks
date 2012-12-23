package hw1t2;

import java.util.ArrayList;
import java.util.Random;

public class Computer {
    
    /**
     * constructor for Computer
     * @param OS operating system 
     * @param name name of the computer
     */
    public Computer(OS OS, String name) {
        this.OS = OS;
        this.name = name;
        this.isInfected = false;
        this.connections = new ArrayList<Computer>();
    }
    
    /**
     * get computer's name
     * @return name computer's name
     */
    public String getName() {
        return name;
    }
    
    /**
     * get computer's OS
     * @return OS computer's OS
     */
    public OS getOS() {
        return OS;
    }
    
    /**
     * check if computer is infected
     * @return true, if computer is infected, false, if computer isn't infected
     */
    public boolean isInfected() {
        return isInfected;
    }
    
    /**
     * infect the computer
     */
    public void setInfected() {
        isInfected = true;
    }
  
    /**
     * try to attack other computers
     */
    public void attack() {
        int attackPower = random.nextInt(100);
        for (int i = 0; i < connections.size(); i++) {
            if (connections.get(i).isInfected)
                continue;
            if (attackPower > connections.get(i).getOS().getInfectionChance()) {
                connections.get(i).setInfected();
            }  
        }
    }
    
    /**
     * connect two computers to each other
     * @param secondComputer
     */
    public void connect(Computer secondComputer) {  
        for (int i = 0; i < connections.size(); i++) {
            if (connections.get(i).getName().equals(secondComputer.getName())) {
                return;
            }
        }
        connections.add(secondComputer);
        secondComputer.connect(this);
    }
    
    /**
     * get computer's connections with other computers
     * @return computer's connections
     */
    public ArrayList<Computer> getConnections() {
        return connections;
    }
    
    private OS OS;
    
    private String name;
    
    private boolean isInfected;
    
    private ArrayList<Computer> connections;
    
    private static Random random = new Random();
    
}
