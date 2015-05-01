/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author YURISNMELO
 */
public class TestingFrameInsideFrame {
    
    private  JFrame framePrincipal;
    private  JFrame frameInterno;
    private  JPanel panel1;
    private  JPanel panel2;
    private  JPanel panel3;
    private  JPanel panel4;
    private  JScrollPane scrollPane;
    private  JViewport view;
    
    public TestingFrameInsideFrame(){
        InitComponents();
        framePrincipal.setVisible(true);
    }
    
    private void InitComponents(){
        
        framePrincipal = new JFrame();
        framePrincipal.setSize(1000, 1000);
 
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();

        panel2.setBackground(new Color(255, 0, 0, 80));
        panel2.setLocation(500, 500);
        panel2.setSize(200, 200);
        
        panel3.setBackground(new Color(0, 255, 0, 80));
        panel3.setLocation(610, 500);
        panel3.setSize(100, 100);

        ImageIcon pic = new ImageIcon("src/view/images_plants/ViewFromAbove.jpg");
        
        panel1.setLayout( new BorderLayout());
        
        panel1.add(panel2);
        panel1.add(panel3);
        panel1.add(new JLabel(pic));
        
        
        scrollPane = new JScrollPane(panel1);

        framePrincipal.add(scrollPane);
        
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new TestingFrameInsideFrame();
        });
    }
    
    
}
