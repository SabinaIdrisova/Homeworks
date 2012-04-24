package hw6t2;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.Timer;

public class ClockFrame extends javax.swing.JFrame {
    
    public ClockFrame() {
        Timer timer = new Timer(1000, new Listener());   
        timer.start();
    }
    
    public void showForm() {
        setSize(400, 160);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        label = new JLabel();
        Font font = new Font("Verdana", Font.CENTER_BASELINE, 70);
        label.setFont(font);   
        add(label);
        java.awt.Dimension dim = getToolkit().getScreenSize();
        setLocation(dim.width/2 - getWidth()/2, dim.height/2 - getHeight()/2);
    }
      
    public void renderTime() {
        Calendar calendar = Calendar.getInstance();
        String hour = Integer.toString(calendar.get(Calendar.HOUR_OF_DAY));
        String minute = Integer.toString(calendar.get(Calendar.MINUTE));
        String second = Integer.toString(calendar.get(Calendar.SECOND));
        if (Integer.parseInt(minute) < 10)
            minute = "0" + minute;
        if (Integer.parseInt(second) < 10)
            second = "0" + second;
        label.setText(hour + ":" + minute + ":" + second);
    }
    
    public class Listener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            renderTime();
        }
    }
    
    private JLabel label;
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

