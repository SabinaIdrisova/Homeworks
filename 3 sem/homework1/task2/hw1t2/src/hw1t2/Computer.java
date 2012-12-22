package hw1t2;

import java.util.ArrayList;
import java.util.Random;

public class Computer {
    
    public Computer(OS OS, String name) {
        this.OS = OS;
        this.name = name;
        this.isInfected = false;
        this.connections = new ArrayList<Computer>();
    }
    
    public String getName() {
        return name;
    }
    
    public OS getOS() {
        return OS;
    }
    
    public boolean isInfected() {
        return isInfected;
    }
    
    public void setInfected() {
        isInfected = true;
    }
  
    public void attack() {
        Random random = new Random();
        int attackPower = random.nextInt(100);
        for (int i = 0; i < connections.size(); i++) {
            if (connections.get(i).isInfected)
                continue;
            if (attackPower > connections.get(i).getOS().getInfectionChance()) {
                connections.get(i).setInfected();
            }  
        }
    }
    
    public void connect(Computer secondComputer) {  
        for (int i = 0; i < connections.size(); i++) {
            if (connections.get(i).getName() == secondComputer.getName()) {
                return;
            }
        }
        connections.add(secondComputer);
        secondComputer.connect(this);
    }
    
    private OS OS;
    
    private String name;
    
    private boolean isInfected;
    
    private ArrayList<Computer> connections;
    
}
