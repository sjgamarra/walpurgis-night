package test.main;

import java.awt.EventQueue;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ShootingMissilesEx extends JFrame {

    public ShootingMissilesEx() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new Board());
        
        setSize(400, 300);
        setResizable(false);
        
        setTitle("Dorito's Magical World");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                ShootingMissilesEx ex = new ShootingMissilesEx();
                ex.setVisible(true);
            }
        });
    }
}