/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import javafx.scene.input.ZoomEvent;
import javax.imageio.*;
import javax.swing.border.Border;
import onboardsoftware.ReadXLSX;
import onboardsoftware.Task;
import org.apache.poi.ss.usermodel.Cell;

/**
 *
 * @author YURISNMELO
 */
public class MainFrame extends javax.swing.JFrame {
    
    ArrayList<Task> tasks = new ArrayList<Task>();
    javax.swing.JPanel moduleTS022 = new javax.swing.JPanel();
    javax.swing.JPanel moduleTS021 = new javax.swing.JPanel();
    javax.swing.JPanel moduleTS264 = new javax.swing.JPanel();
    javax.swing.JPanel moduleTS265 = new javax.swing.JPanel();
    javax.swing.JPanel moduleTS266 = new javax.swing.JPanel();
    javax.swing.JPanel moduleTS267 = new javax.swing.JPanel();
    javax.swing.JPanel moduleTS062 = new javax.swing.JPanel();
    javax.swing.JPanel moduleTS075 = new javax.swing.JPanel();
    javax.swing.JPanel moduleTS063 = new javax.swing.JPanel();
    
    /**
     * Creates new form MainPanel
     */
    public MainFrame() {
        
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        myUpdate();
        
        
    }
    
    public void myUpdate(){
        setVisible(true);
        Icon initial_icon = new javax.swing.ImageIcon("src/view/image/DEMO PICS/ViewFromAbove.jpg");
        label_plantSection.setIcon(initial_icon);
        BufferedImage img = new BufferedImage(initial_icon.getIconWidth(), initial_icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics g = img.createGraphics();
        initial_icon.paintIcon(null, g, 0, 0);
        g.dispose();
        Image newing = img.getScaledInstance((int)(label_plantSection.getIcon().getIconWidth()/5.7), (int)(label_plantSection.getIcon().getIconHeight()/5.7), java.awt.Image.SCALE_SMOOTH);
        label_plantSection.setIcon(new ImageIcon(newing));
        label_plantSection.setVisible(true);
        add(ScrollPanel_plantShip);
        ScrollPanel_plantShip.setSize(1920,900);
        setResizable(false);
        setVisible(true);
        generateAllModules();
    }
            
    
    public void generateAllModules(){

        moduleTS022.setLocation(466, 403);
        moduleTS022.setSize(100, 137);
        moduleTS022.setBackground(null);
        
        moduleTS021.setLocation(572, 403);
        moduleTS021.setSize(130, 137);
      //  moduleTS021.setBackground(new Color(0,255,0,80));
        
        moduleTS264.setLocation(712, 393);
        moduleTS264.setSize(150, 55);
      //  moduleTS264.setBackground(new Color(255,0,0,80));

        moduleTS265.setLocation(875, 393);
        moduleTS265.setSize(130, 55);
      //  moduleTS265.setBackground(new Color(255,0,0,80));
        
        moduleTS266.setLocation(1015, 393);
        moduleTS266.setSize(130, 55);
      //  moduleTS266.setBackground(new Color(255,0,0,80));

        moduleTS267.setLocation(1155, 393);
        moduleTS267.setSize(145, 55);
     //   moduleTS267.setBackground(new Color(255,0,0,80));
        
        moduleTS062.setLocation(737, 455);
        moduleTS062.setSize(128, 88);
      //  moduleTS062.setBackground(new Color(0,0,255,80));
        
        moduleTS075.setLocation(880, 455);
        moduleTS075.setSize(128, 88);
    //    moduleTS075.setBackground(new Color(0,255,0,80));
        
        moduleTS063.setLocation(1015, 455);
        moduleTS063.setSize(128, 88);
      //  moduleTS063.setBackground(new Color(0,0,255,80));
        
  
    }
    
    public void aplyTasksInModules(){

        javax.swing.JPanel t1 = new javax.swing.JPanel();
        for (Task t:tasks){
            t1 = new javax.swing.JPanel();
            t1.setSize(10, 10);
            if(t.getModuleNumber().toString().compareTo("22.0")==0){
                if(t.isCold())t1.setBackground(Color.BLUE);
                else t1.setBackground(Color.RED);
                moduleTS022.add(t1);
                add(moduleTS022);
            }else if(t.getModuleNumber().toString().compareTo("21.0")==0){
                if(t.isCold())t1.setBackground(Color.BLUE);
                else t1.setBackground(Color.RED);
                add(moduleTS021);
                moduleTS021.add(t1); 
            }else if(t.getModuleNumber().toString().compareTo("264.0")==0){
                if(t.isCold())t1.setBackground(Color.BLUE);
                else t1.setBackground(Color.RED);
                add(moduleTS264);
                moduleTS264.add(t1); 
            }else if(t.getModuleNumber().toString().compareTo("265.0")==0){
                if(t.isCold())t1.setBackground(Color.BLUE);
                else t1.setBackground(Color.RED);
                add(moduleTS265);
                moduleTS265.add(t1); 
            }else if(t.getModuleNumber().toString().compareTo("266.0")==0){
                if(t.isCold())t1.setBackground(Color.BLUE);
                else t1.setBackground(Color.RED);
                add(moduleTS266);
                moduleTS266.add(t1); 
            }else if(t.getModuleNumber().toString().compareTo("267.0")==0){
                if(t.isCold())t1.setBackground(Color.BLUE);
                else t1.setBackground(Color.RED);
                add(moduleTS267);
                moduleTS267.add(t1);
            }else if(t.getModuleNumber().toString().compareTo("62.0")==0){
                if(t.isCold())t1.setBackground(Color.BLUE);
                else t1.setBackground(Color.RED);
                add(moduleTS062);
                moduleTS062.add(t1);
            }else if(t.getModuleNumber().toString().compareTo("75.0")==0){
                if(t.isCold())t1.setBackground(Color.BLUE);
                else t1.setBackground(Color.RED);
                add(moduleTS075);
                moduleTS075.add(t1);
            }else if(t.getModuleNumber().toString().compareTo("63.0")==0){
                if(t.isCold())t1.setBackground(Color.BLUE);
                else t1.setBackground(Color.RED);
                add(moduleTS063);
                moduleTS063.add(t1);
            }
        }
        tasks = new ArrayList<>();
        
        setVisible(true);
    }
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Button = new javax.swing.JPanel();
        Button_ALL = new javax.swing.JButton();
        Button_UpperDeck = new javax.swing.JButton();
        Button_MiddleDeck = new javax.swing.JButton();
        Button_MainDeck = new javax.swing.JButton();
        Button_SideView = new javax.swing.JButton();
        Button_importXLS = new javax.swing.JButton();
        Button_viewFromAbove = new javax.swing.JButton();
        Button_updateMap = new javax.swing.JButton();
        ScrollPanel_plantShip = new javax.swing.JScrollPane();
        label_plantSection = new javax.swing.JLabel();
        Button_zoomIn = new javax.swing.JButton();
        Button_zoomOut = new javax.swing.JButton();
        MenuBar = new javax.swing.JMenuBar();
        Menu_File = new javax.swing.JMenu();
        Button_ImporFile = new javax.swing.JMenuItem();
        Button_Exit = new javax.swing.JMenuItem();
        Menu_Edit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OnSoftwareBoard");
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        Panel_Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

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

        Button_importXLS.setBackground(new java.awt.Color(51, 255, 102));
        Button_importXLS.setForeground(new java.awt.Color(255, 51, 102));
        Button_importXLS.setText("importXLS");
        Button_importXLS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_importXLSActionPerformed(evt);
            }
        });

        Button_viewFromAbove.setText("View from Above");
        Button_viewFromAbove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_viewFromAboveActionPerformed(evt);
            }
        });

        Button_updateMap.setText("Update Map");
        Button_updateMap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button_updateMapMouseClicked(evt);
            }
        });
        Button_updateMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_updateMapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_ButtonLayout = new javax.swing.GroupLayout(Panel_Button);
        Panel_Button.setLayout(Panel_ButtonLayout);
        Panel_ButtonLayout.setHorizontalGroup(
            Panel_ButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_ButtonLayout.createSequentialGroup()
                .addGroup(Panel_ButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Button_importXLS, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Button_viewFromAbove, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_ButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_ButtonLayout.createSequentialGroup()
                        .addComponent(Button_ALL, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button_UpperDeck, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button_MiddleDeck, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button_MainDeck, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button_SideView, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Button_updateMap))
                .addGap(0, 404, Short.MAX_VALUE))
        );
        Panel_ButtonLayout.setVerticalGroup(
            Panel_ButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_ButtonLayout.createSequentialGroup()
                .addGroup(Panel_ButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_viewFromAbove)
                    .addComponent(Button_ALL)
                    .addComponent(Button_UpperDeck)
                    .addComponent(Button_MiddleDeck)
                    .addComponent(Button_MainDeck)
                    .addComponent(Button_SideView))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_ButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_importXLS)
                    .addComponent(Button_updateMap)))
        );

        ScrollPanel_plantShip.setMinimumSize(new java.awt.Dimension(800, 600));
        ScrollPanel_plantShip.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                ScrollPanel_plantShipMouseWheelMoved(evt);
            }
        });
        ScrollPanel_plantShip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ScrollPanel_plantShipMouseClicked(evt);
            }
        });

        label_plantSection.setVisible(false);
        label_plantSection.setText("");
        label_plantSection.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                label_plantSectionComponentAdded(evt);
            }
        });
        label_plantSection.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                label_plantSectionMouseWheelMoved(evt);
            }
        });
        label_plantSection.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_plantSectionMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label_plantSectionMousePressed(evt);
            }
        });
        ScrollPanel_plantShip.setViewportView(label_plantSection);

        Button_zoomIn.setText("+");
        Button_zoomIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button_zoomInMouseClicked(evt);
            }
        });
        Button_zoomIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_zoomInActionPerformed(evt);
            }
        });

        Button_zoomOut.setText("-");
        Button_zoomOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button_zoomOutMouseClicked(evt);
            }
        });
        Button_zoomOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_zoomOutActionPerformed(evt);
            }
        });

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
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(Button_zoomIn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Button_zoomOut, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(ScrollPanel_plantShip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Panel_Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel_Button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_zoomOut)
                    .addComponent(Button_zoomIn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPanel_plantShip, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_UpperDeckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_UpperDeckActionPerformed
       label_plantSection.setIcon(new javax.swing.ImageIcon("src/view/image/DEMO PICS/UpperDeck.jpg"));
       label_plantSection.setVisible(true);
    }//GEN-LAST:event_Button_UpperDeckActionPerformed

    private void Button_ALLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ALLActionPerformed
        label_plantSection.setIcon(new javax.swing.ImageIcon("src/view/image/DEMO PICS/GeneralPlant.jpg"));
        label_plantSection.setVisible(true);
    }//GEN-LAST:event_Button_ALLActionPerformed

    private void Button_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_Button_ExitActionPerformed

    private void Button_MiddleDeckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_MiddleDeckActionPerformed
        label_plantSection.setIcon(new javax.swing.ImageIcon("src/view/image/DEMO PICS/MiddleDeck.jpg"));
        label_plantSection.setVisible(true);
    }//GEN-LAST:event_Button_MiddleDeckActionPerformed

    private void Button_MainDeckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_MainDeckActionPerformed
        label_plantSection.setIcon(new javax.swing.ImageIcon("src/view/image/DEMO PICS/MainDeck.jpg"));
        label_plantSection.setVisible(true);
    }//GEN-LAST:event_Button_MainDeckActionPerformed

    private void Button_SideViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_SideViewActionPerformed
        label_plantSection.setIcon(new javax.swing.ImageIcon("src/view/image/DEMO PICS/SideView.jpg"));
        label_plantSection.setVisible(true);
    }//GEN-LAST:event_Button_SideViewActionPerformed

    private void Button_importXLSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_importXLSActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        ReadXLSX read = new ReadXLSX();
        tasks = read.getTasks(filename);
        for(int i =0;i<tasks.size();i++){
            System.out.println(tasks.get(i).toString());
        }
        myUpdate();

    }//GEN-LAST:event_Button_importXLSActionPerformed

    private void Button_viewFromAboveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_viewFromAboveActionPerformed
        myUpdate();
        
    }//GEN-LAST:event_Button_viewFromAboveActionPerformed

    private void label_plantSectionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_plantSectionMouseClicked
        
    }//GEN-LAST:event_label_plantSectionMouseClicked

    private void label_plantSectionComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_label_plantSectionComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_label_plantSectionComponentAdded

    private void label_plantSectionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_plantSectionMousePressed

    }//GEN-LAST:event_label_plantSectionMousePressed

    private void label_plantSectionMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_label_plantSectionMouseWheelMoved
        
    }//GEN-LAST:event_label_plantSectionMouseWheelMoved

    private void ScrollPanel_plantShipMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_ScrollPanel_plantShipMouseWheelMoved
        
    }//GEN-LAST:event_ScrollPanel_plantShipMouseWheelMoved

    private void Button_zoomInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_zoomInMouseClicked
        
    }//GEN-LAST:event_Button_zoomInMouseClicked

    private void Button_zoomOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_zoomOutMouseClicked
 
    }//GEN-LAST:event_Button_zoomOutMouseClicked

    private void Button_zoomInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_zoomInActionPerformed
//        Icon initial_icon = new javax.swing.ImageIcon("src/view/image/DEMO PICS/ViewFromAbove.jpg");
//        BufferedImage img = new BufferedImage(initial_icon.getIconWidth(), initial_icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
//        Graphics g = img.createGraphics();
//        initial_icon.paintIcon(null, g, 0, 0);
//        g.dispose();
//        Image newing = img.getScaledInstance((int)(label_plantSection.getIcon().getIconWidth()*1.1), (int)(label_plantSection.getIcon().getIconHeight()*1.1), java.awt.Image.SCALE_FAST);
//        label_plantSection.setIcon(new ImageIcon(newing));
    }//GEN-LAST:event_Button_zoomInActionPerformed

    private void Button_zoomOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_zoomOutActionPerformed
//        Icon initial_icon = new javax.swing.ImageIcon("src/view/image/DEMO PICS/ViewFromAbove.jpg");
//        BufferedImage img = new BufferedImage(initial_icon.getIconWidth(), initial_icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
//        Graphics g = img.createGraphics();
//        initial_icon.paintIcon(null, g, 0, 0);
//        g.dispose();
//        Image newing = img.getScaledInstance((int)(label_plantSection.getIcon().getIconWidth()/1.1), (int)(label_plantSection.getIcon().getIconHeight()/1.1), java.awt.Image.SCALE_FAST);
//        label_plantSection.setIcon(new ImageIcon(newing));
    }//GEN-LAST:event_Button_zoomOutActionPerformed

    private void ScrollPanel_plantShipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScrollPanel_plantShipMouseClicked
        
    }//GEN-LAST:event_ScrollPanel_plantShipMouseClicked

    private void Button_updateMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_updateMapActionPerformed
       aplyTasksInModules();
    }//GEN-LAST:event_Button_updateMapActionPerformed

    private void Button_updateMapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_updateMapMouseClicked
        
    }//GEN-LAST:event_Button_updateMapMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
      
    }//GEN-LAST:event_formMouseClicked

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        
    }//GEN-LAST:event_formWindowStateChanged

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
               
    }//GEN-LAST:event_formComponentResized
    
    
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
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
    private javax.swing.JButton Button_importXLS;
    private javax.swing.JButton Button_updateMap;
    private javax.swing.JButton Button_viewFromAbove;
    private javax.swing.JButton Button_zoomIn;
    private javax.swing.JButton Button_zoomOut;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenu Menu_Edit;
    private javax.swing.JMenu Menu_File;
    private javax.swing.JPanel Panel_Button;
    private javax.swing.JScrollPane ScrollPanel_plantShip;
    private javax.swing.JLabel label_plantSection;
    // End of variables declaration//GEN-END:variables
}
