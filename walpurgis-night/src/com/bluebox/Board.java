package com.bluebox;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

//http://zetcode.com/tutorials/javagamestutorial/basics/
@SuppressWarnings("serial")
public class Board extends JPanel {

    private Image bardejov;

    public Board() {

        initBoard();
    }
    
    private void initBoard() {
        loadImage();
        
        int w = bardejov.getWidth(this);
        int h =  bardejov.getHeight(this);
        setPreferredSize(new Dimension(w, h));        
    }
    
    private void loadImage() {
        try{
        	ImageIcon ii = new ImageIcon("src/com/bluebox/images/pinguin.png");
            bardejov = ii.getImage();
        }catch(Exception e){
        	System.out.println(e.getMessage());
        }
                
    }

    @Override
    public void paintComponent(Graphics g) {

        g.drawImage(bardejov, 0, 0, null);
    }
}