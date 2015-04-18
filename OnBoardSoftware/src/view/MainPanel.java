/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import javax.imageio.*;
import onboardsoftware.ReadXLSX;
import onboardsoftware.Task;

/**
 *
 * @author YURISNMELO
 */
public class MainPanel extends javax.swing.JFrame {

     
    /**
     * Creates new form MainPanel
     */
    public MainPanel() {
        initComponents();
        label_plantSeciton.setVisible(false);
        
    }
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_PlantView = new javax.swing.JPanel();
        label_plantSeciton = new javax.swing.JLabel();
        Panel_Button = new javax.swing.JPanel();
        Label_View = new javax.swing.JLabel();
        Button_ALL = new javax.swing.JButton();
        Button_UpperDeck = new javax.swing.JButton();
        Button_MiddleDeck = new javax.swing.JButton();
        Button_MainDeck = new javax.swing.JButton();
        Button_SideView = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        MenuBar = new javax.swing.JMenuBar();
        Menu_File = new javax.swing.JMenu();
        Button_ImporFile = new javax.swing.JMenuItem();
        Button_Exit = new javax.swing.JMenuItem();
        Menu_Edit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_plantSeciton.setVisible(false);
        label_plantSeciton.setText("");

        javax.swing.GroupLayout Panel_PlantViewLayout = new javax.swing.GroupLayout(Panel_PlantView);
        Panel_PlantView.setLayout(Panel_PlantViewLayout);
        Panel_PlantViewLayout.setHorizontalGroup(
            Panel_PlantViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_PlantViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_plantSeciton, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
        );
        Panel_PlantViewLayout.setVerticalGroup(
            Panel_PlantViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_PlantViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_plantSeciton)
                .addContainerGap(423, Short.MAX_VALUE))
        );

        Label_View.setBackground(new java.awt.Color(0, 102, 102));
        Label_View.setText("VIEW");

        Button_ALL.setText("All");
        Button_ALL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ALLActionPerformed(evt);
            }
        });

        Button_UpperDeck.setText("Upper Deck");
        Button_UpperDeck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_UpperDeckActionPerformed(evt);
            }
        });

        Button_MiddleDeck.setText("Middle Deck");
        Button_MiddleDeck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_MiddleDeckActionPerformed(evt);
            }
        });

        Button_MainDeck.setText("Main Deck");
        Button_MainDeck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_MainDeckActionPerformed(evt);
            }
        });

        Button_SideView.setText("Side View");
        Button_SideView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_SideViewActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(51, 255, 102));
        jButton1.setForeground(new java.awt.Color(255, 51, 102));
        jButton1.setText("importXLS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_ButtonLayout = new javax.swing.GroupLayout(Panel_Button);
        Panel_Button.setLayout(Panel_ButtonLayout);
        Panel_ButtonLayout.setHorizontalGroup(
            Panel_ButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Button_ALL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Button_MiddleDeck, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
            .addComponent(Label_View, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Button_MainDeck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Button_SideView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Button_UpperDeck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Panel_ButtonLayout.setVerticalGroup(
            Panel_ButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_ButtonLayout.createSequentialGroup()
                .addComponent(Label_View, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Button_ALL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Button_UpperDeck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Button_MiddleDeck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Button_MainDeck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Button_SideView)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Menu_File.setText("File");

        Button_ImporFile.setText("Import File");
        Menu_File.add(Button_ImporFile);

        Button_Exit.setText("Exit");
        Button_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ExitActionPerformed(evt);
            }
        });
        Menu_File.add(Button_Exit);

        MenuBar.add(Menu_File);

        Menu_Edit.setText("Edit");
        MenuBar.add(Menu_Edit);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(Panel_Button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panel_PlantView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 30, Short.MAX_VALUE)
                        .addComponent(Panel_PlantView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Panel_Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_UpperDeckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_UpperDeckActionPerformed
       label_plantSeciton.setIcon(new javax.swing.ImageIcon("src/view/image/DEMO PICS/UpperDeck.jpg"));
       label_plantSeciton.setVisible(true);
    }//GEN-LAST:event_Button_UpperDeckActionPerformed

    private void Button_ALLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ALLActionPerformed
        label_plantSeciton.setIcon(new javax.swing.ImageIcon("src/view/image/DEMO PICS/GeneralPlant.jpg"));
        label_plantSeciton.setVisible(true);
    }//GEN-LAST:event_Button_ALLActionPerformed

    private void Button_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_Button_ExitActionPerformed

    private void Button_MiddleDeckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_MiddleDeckActionPerformed
        label_plantSeciton.setIcon(new javax.swing.ImageIcon("src/view/image/DEMO PICS/MiddleDeck.jpg"));
        label_plantSeciton.setVisible(true);
    }//GEN-LAST:event_Button_MiddleDeckActionPerformed

    private void Button_MainDeckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_MainDeckActionPerformed
        label_plantSeciton.setIcon(new javax.swing.ImageIcon("src/view/image/DEMO PICS/MainDeck.jpg"));
        label_plantSeciton.setVisible(true);
    }//GEN-LAST:event_Button_MainDeckActionPerformed

    private void Button_SideViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_SideViewActionPerformed
        label_plantSeciton.setIcon(new javax.swing.ImageIcon("src/view/image/DEMO PICS/SideView.jpg"));
        label_plantSeciton.setVisible(true);
    }//GEN-LAST:event_Button_SideViewActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        ReadXLSX read = new ReadXLSX();
        ArrayList<Task> tasks = read.getTasks(filename);
        
        for(int i =0;i<tasks.size();i++){
            System.out.println(tasks.get(i).toString());
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_ALL;
    private javax.swing.JMenuItem Button_Exit;
    private javax.swing.JMenuItem Button_ImporFile;
    private javax.swing.JButton Button_MainDeck;
    private javax.swing.JButton Button_MiddleDeck;
    private javax.swing.JButton Button_SideView;
    private javax.swing.JButton Button_UpperDeck;
    private javax.swing.JLabel Label_View;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenu Menu_Edit;
    private javax.swing.JMenu Menu_File;
    private javax.swing.JPanel Panel_Button;
    private javax.swing.JPanel Panel_PlantView;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel label_plantSeciton;
    // End of variables declaration//GEN-END:variables
}
