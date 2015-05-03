
package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

import model.Permit;
import util.ReaderXLSX;



public class Frame_Main{

    private JFrame frame_main;
    
    private JPanel panel_bottons_viewPlants;
    private JPanel panel_viewPlants;
    
    private JButton button_import;
    private JButton button_fromAbove;
    private JButton button_UpperDeck;
    private JButton button_SideView;
    private JButton button_SunkenDeck;
    private JButton button_2ndDeck;
    private JButton button_3rdDeck;
    private JButton button_TankTop;
    private JButton button_ADeck;
    private JButton button_BDeck;
    private JButton button_CDeck;
    private JButton button_EnifDeck;
    private JButton button_More;
    
    private JButton button_ZoomIn;
    private JButton button_ZoomOut;
    
    private double zoomValue = 2.2;
    
    private JPanel moduleFromAbove_TS022;
    private JPanel moduleFromAbove_TS021;
    private JPanel moduleFromAbove_TS264;
    private JPanel moduleFromAbove_TS265;
    private JPanel moduleFromAbove_TS266;
    private JPanel moduleFromAbove_TS267;
    private JPanel moduleFromAbove_VE286;
    private JPanel moduleFromAbove_TS062;
    private JPanel moduleFromAbove_TS075;
    private JPanel moduleFromAbove_TS063;
    private JPanel moduleFromAbove_TS074;
    private JPanel moduleFromAbove_TS076;
    private JPanel moduleFromAbove_TS077;
    private JPanel moduleFromAbove_TS289;
    private JPanel moduleFromAbove_TS068;
    private JPanel moduleFromAbove_TS011;
    private JPanel moduleFromAbove_TS012;
    private JPanel moduleFromAbove_TS005;
    private JPanel moduleFromAbove_TS071;
    private JPanel moduleFromAbove_TS073;
    private JPanel moduleFromAbove_TS078;
    private JPanel moduleFromAbove_TS079;
    private JPanel moduleFromAbove_IT279;
    private JPanel moduleFromAbove_TS072;
    
    //new modules to map and add in the plants >_<
    // {
    private JPanel moduleFromAbove_HeliDeck;
    private JPanel moduleFromAbove_LifeBoat;
    private JPanel moduleUpperDeck_PumpRoom;
    private JPanel moduleSunkenDeck_PumpRoom;
    private JPanel moduleSunkenDeck_FoamRoom;
    private JPanel module2ndDeck_ER_EngineRoom;
    private JPanel module3rdDeck;
    private JPanel moduleTankTop;
    private JPanel moduleADeck;
    private JPanel moduleBDeck;
    private JPanel moduleCDeck;
    private JPanel moduleEnifDeck;
    private JPanel moduleMore_2Deck;
    private JPanel moduleMore_DDeck;
    private JPanel moduleMore_EDeck;
    private JPanel moduleMore_NavBridgeDeck;
    private JPanel moduleMore_TopDeck;
    private JPanel moduleMore_UpperECRDeck;
    
    private JPanel moduleSideView_Helideck;
    private JPanel moduleSideView_NavBridgeDeck;
    private JPanel moduleSideView_EDeck;
    private JPanel moduleSideView_DDeck;
    private JPanel moduleSideView_CDeck;
    private JPanel moduleSideView_BDeck;
    private JPanel moduleSideView_ADeck;
    private JPanel moduleSideView_TS068;
    private JPanel moduleSideView_TS011;
    private JPanel moduleSideView_TS012;
    private JPanel moduleSideView_TS005;
    private JPanel moduleSideView_TS071;
    private JPanel moduleSideView_TS073;
    private JPanel moduleSideView_TS078;
    private JPanel moduleSideView_TS079_IT279;
    private JPanel moduleSideView_TS072;
    private JPanel moduleSideView_VentTower;
    private JPanel moduleSideView_FlareTower;
    
    
    // }
    //finish here

    private JLabel label_viewPlant;
    private JScrollPane scrollPanel_viewPlant;
    private JProgressBar progressBar_importXLSX;
    
//    private JMenuBar menuBar;
//    private JMenu menuComponent_file;
    
    private GridBagConstraints myConstraint;

    final private int inset_leftSide = 5;
    final private int inset_rightSide = 5;
    final private int inset_topSide = 5;
    final private int inset_downSide = 5;
    
//    private String pathPlant = "src/view/images_plants/ViewFromAboveUpdated.jpg";
    
    private URL pathPlantURL = this.getClass().getResource("/resources/viewFromAboveUpdated.jpg");
    
    
    
    public void go(){
    	initComponents();
        addContentsToContents();
        
        
        button_ZoomIn.addActionListener(
                new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae){
                  
                    
                    
                    if(zoomValue<10){
                        zoomValue+=1;
                        Icon initial_icon = new javax.swing.ImageIcon(pathPlantURL);
                        BufferedImage img = new BufferedImage(initial_icon.getIconWidth(), initial_icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
                        Graphics g = img.createGraphics();
                        initial_icon.paintIcon(null, g, 0, 0);
                        g.dispose();
                        Image newing = img.getScaledInstance((int)(initial_icon.getIconWidth()*zoomValue/10), (int)(initial_icon.getIconHeight()*zoomValue/10), java.awt.Image.SCALE_DEFAULT);


                        label_viewPlant.setIcon(new ImageIcon(newing));
                    }
                    
                    updateModules();
                
                }
        });
        button_ZoomOut.addActionListener(
                new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae){

                    if(zoomValue>1){
                        zoomValue-=1;
                        Icon initial_icon = new javax.swing.ImageIcon(pathPlantURL);
                        BufferedImage img = new BufferedImage(initial_icon.getIconWidth(), initial_icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
                        Graphics g = img.createGraphics();
                        initial_icon.paintIcon(null, g, 0, 0);
                        g.dispose();
                        Image newing = img.getScaledInstance((int)(initial_icon.getIconWidth()*zoomValue/10), (int)(initial_icon.getIconHeight()*zoomValue/10), java.awt.Image.SCALE_DEFAULT);
                        label_viewPlant.setIcon(new ImageIcon(newing));
                    }
                    
                    updateModules();
                }
        });
        button_import.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int r = chooser.showOpenDialog(null);
                File f = chooser.getSelectedFile();
                if (r == JFileChooser.APPROVE_OPTION) {
                    final String filename = f.getAbsolutePath();
//                    System.out.println(filename);

                    SwingUtilities.invokeLater(new Runnable() {

                        @Override
                        public void run() {
                            ReaderXLSX read = new ReaderXLSX(filename);
                            read.execute();
                              updateModules();
                            try {
                                final ArrayList<Permit> a = read.get();
//                                System.out.println(a.toString());
//                                System.out.println("DONE");
                                
                                
                                SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {

                                    @Override
                                    protected Boolean doInBackground() throws Exception {
                                        for(Permit p : a){
//                                            Thread.sleep(100);
                                            applyPermitsInModules(p);
                                            frame_main.revalidate();
                                            frame_main.repaint();
                                        }
                                        return true;
                                    }
                                    @Override
                                    protected void done(){
                                        try {
                                            Boolean t = get();
                                            if(t){
                                                System.out.println("JOGUEI TODAS AS PERMITS DONE!");
                                            }
                                        } catch (InterruptedException ex) {
                                            Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
                                        } catch (ExecutionException ex) {
                                            Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        
                                    }
                                };
                                
                                worker.execute();
                                          updateModules();
                                
                                        
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ExecutionException ex) {
                                Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });
                } else {
                    System.out.println("CANCELED");
                }
                
                  updateModules();
                
            }
        });
        
        button_fromAbove.addActionListener(
                new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae){
//                    pathPlant = "src/view/images_plants/ViewFromAboveUpdated.jpg";
                    pathPlantURL = this.getClass().getResource("/resources/viewFromAboveUpdated.jpg");
                    cleanViewPlant();
                    moduleFromAbove_TS022.setVisible(true);
                    moduleFromAbove_TS021.setVisible(true);
                    moduleFromAbove_TS264.setVisible(true);
                    moduleFromAbove_TS265.setVisible(true);
                    moduleFromAbove_TS266.setVisible(true);
                    moduleFromAbove_TS267.setVisible(true);
                    moduleFromAbove_TS062.setVisible(true);
                    moduleFromAbove_TS075.setVisible(true);
                    moduleFromAbove_TS063.setVisible(true);
                    moduleFromAbove_TS074.setVisible(true);
                    moduleFromAbove_TS076.setVisible(true);
                    moduleFromAbove_TS077.setVisible(true);
                    moduleFromAbove_TS289.setVisible(true);
                    moduleFromAbove_TS068.setVisible(true);
                    moduleFromAbove_TS011.setVisible(true);
                    moduleFromAbove_TS012.setVisible(true);
                    moduleFromAbove_TS005.setVisible(true);
                    moduleFromAbove_TS071.setVisible(true);
                    moduleFromAbove_TS073.setVisible(true);
                    moduleFromAbove_TS078.setVisible(true);
                    moduleFromAbove_TS079.setVisible(true);
                    moduleFromAbove_TS072.setVisible(true);
                    moduleFromAbove_HeliDeck.setVisible(true);
                    moduleFromAbove_LifeBoat.setVisible(true);
                    updateImageViewPlant();
                    
                }
        });
        button_UpperDeck.addActionListener(
                new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae){
//                    pathPlant = "src/view/images_plants/UpperDeckUpdated.jpg";
                    pathPlantURL = this.getClass().getResource("/resources/UpperDeckUpdated.jpg");
                    cleanViewPlant();
                    moduleUpperDeck_PumpRoom.setVisible(true);
                    updateImageViewPlant();
                    
                }
        });
        button_SideView.addActionListener(
                new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae){
//                    pathPlant = "src/view/images_plants/SideView.jpg";
                    pathPlantURL = this.getClass().getResource("/resources/SideView.jpg");
                    cleanViewPlant();
                    moduleSideView_ADeck.setVisible(true);
                    moduleSideView_BDeck.setVisible(true);
                    moduleSideView_CDeck.setVisible(true);
                    moduleSideView_DDeck.setVisible(true);
                    moduleSideView_EDeck.setVisible(true);
                    moduleSideView_FlareTower.setVisible(true);
                    moduleSideView_Helideck.setVisible(true);
                    moduleSideView_NavBridgeDeck.setVisible(true);
                    moduleSideView_TS005.setVisible(true);
                    moduleSideView_TS011.setVisible(true);
                    moduleSideView_TS012.setVisible(true);
                    moduleSideView_TS068.setVisible(true);
                    moduleSideView_TS071.setVisible(true);
                    moduleSideView_TS072.setVisible(true);
                    moduleSideView_TS073.setVisible(true);
                    moduleSideView_TS078.setVisible(true);
                    moduleSideView_TS079_IT279.setVisible(true);
                    moduleSideView_VentTower.setVisible(true);
                    updateImageViewPlant();
                }
        });
        button_SunkenDeck.addActionListener(
                new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae){
//                    pathPlant = "src/view/images_plants/SunkenDeckUpdated.jpg";
                    pathPlantURL = this.getClass().getResource("/resources/SunkenDeckUpdated.jpg");
                    cleanViewPlant();
                    moduleSunkenDeck_FoamRoom.setVisible(true);
                    moduleSunkenDeck_PumpRoom.setVisible(true);
                    updateImageViewPlant();
                }
        });
        button_2ndDeck.addActionListener(
                new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae){
//                    pathPlant = "src/view/images_plants/2ndDeck.jpg";
                    pathPlantURL = this.getClass().getResource("/resources/2ndDeck.jpg");
                    cleanViewPlant();
                    module2ndDeck_ER_EngineRoom.setVisible(true);
                    updateImageViewPlant();
                }
        });
        button_3rdDeck.addActionListener(
                new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae){
//                    pathPlant = "src/view/images_plants/3rdDeck.jpg";
                    pathPlantURL = this.getClass().getResource("/resources/3rdDeck.jpg");
                    cleanViewPlant();
                    module3rdDeck.setVisible(true);
                    updateImageViewPlant();
                }
        });
        button_TankTop.addActionListener(
                new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae){
//                    pathPlant = "src/view/images_plants/Tank Top.jpg";
                    pathPlantURL = this.getClass().getResource("/resources/Tank Top.jpg");
                    cleanViewPlant();
                    moduleTankTop.setVisible(true);
                    updateImageViewPlant();
                }
        });
        button_ADeck.addActionListener(
                new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae){
//                    pathPlant = "src/view/images_plants/A-Deck.jpg";
                    pathPlantURL = this.getClass().getResource("/resources/A-Deck.jpg");
                    cleanViewPlant();
                    moduleADeck.setVisible(true);
                    updateImageViewPlant();
                }
        });
        button_BDeck.addActionListener(
                new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae){
//                    pathPlant = "src/view/images_plants/B-Deck.jpg";
                    pathPlantURL = this.getClass().getResource("/resources/B-Deck.jpg");
                    cleanViewPlant();
                    moduleBDeck.setVisible(true);
                    updateImageViewPlant();
                }
        });
        button_CDeck.addActionListener(
                new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae){
//                    pathPlant = "src/view/images_plants/C-Deck.jpg";
                    pathPlantURL = this.getClass().getResource("/resources/C-Deck.jpg");
                    cleanViewPlant();
                    moduleCDeck.setVisible(true);
                    updateImageViewPlant();
                }
        });
        button_EnifDeck.addActionListener(
                new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae){
//                    pathPlant = "src/view/images_plants/ENIF Deck.jpg";
                    pathPlantURL = this.getClass().getResource("/resources/ENIF Deck.jpg");
                    cleanViewPlant();
                    moduleEnifDeck.setVisible(true);
                    updateImageViewPlant();
                }
        });
        button_More.addActionListener(
                new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae){
//                    pathPlant = "src/view/images_plants/More.jpg";
                    pathPlantURL = this.getClass().getResource("/resources/More.jpg");
                    cleanViewPlant();
                    moduleMore_2Deck.setVisible(true);
                    moduleMore_DDeck.setVisible(true);
                    moduleMore_EDeck.setVisible(true);
                    moduleMore_NavBridgeDeck.setVisible(true);
                    moduleMore_TopDeck.setVisible(true);
                    moduleMore_UpperECRDeck.setVisible(true);
                    updateImageViewPlant();
                }
        });
        
        scrollPanel_viewPlant.addMouseMotionListener(null);
        
    }
    
    private void cleanViewPlant(){
        
        moduleFromAbove_TS022.setVisible(false);
        moduleFromAbove_TS021.setVisible(false);
        moduleFromAbove_TS264.setVisible(false);
        moduleFromAbove_TS265.setVisible(false);
        moduleFromAbove_TS266.setVisible(false);
        moduleFromAbove_TS267.setVisible(false);
        moduleFromAbove_TS062.setVisible(false);
        moduleFromAbove_TS075.setVisible(false);
        moduleFromAbove_TS063.setVisible(false);
        moduleFromAbove_TS074.setVisible(false);
        moduleFromAbove_TS076.setVisible(false);
        moduleFromAbove_TS077.setVisible(false);
        moduleFromAbove_TS289.setVisible(false);
        moduleFromAbove_TS068.setVisible(false);
        moduleFromAbove_TS011.setVisible(false);
        moduleFromAbove_TS012.setVisible(false);
        moduleFromAbove_TS005.setVisible(false);
        moduleFromAbove_TS071.setVisible(false);
        moduleFromAbove_TS073.setVisible(false);
        moduleFromAbove_TS078.setVisible(false);
        moduleFromAbove_TS079.setVisible(false);
        moduleFromAbove_TS072.setVisible(false);
        moduleFromAbove_HeliDeck.setVisible(false);
        moduleFromAbove_LifeBoat.setVisible(false);
        moduleUpperDeck_PumpRoom.setVisible(false);
        moduleSunkenDeck_FoamRoom.setVisible(false);
        moduleSunkenDeck_PumpRoom.setVisible(false);
        module2ndDeck_ER_EngineRoom.setVisible(false);
        module3rdDeck.setVisible(false);
        moduleTankTop.setVisible(false);
        moduleADeck.setVisible(false);
        moduleBDeck.setVisible(false);
        moduleCDeck.setVisible(false);
        moduleEnifDeck.setVisible(false);
        moduleMore_2Deck.setVisible(false);
        moduleMore_DDeck.setVisible(false);
        moduleMore_EDeck.setVisible(false);
        moduleMore_NavBridgeDeck.setVisible(false);
        moduleMore_TopDeck.setVisible(false);
        moduleMore_UpperECRDeck.setVisible(false);
        
        moduleSideView_ADeck.setVisible(false);
        moduleSideView_BDeck.setVisible(false);
        moduleSideView_CDeck.setVisible(false);
        moduleSideView_DDeck.setVisible(false);
        moduleSideView_EDeck.setVisible(false);
        moduleSideView_FlareTower.setVisible(false);
        moduleSideView_Helideck.setVisible(false);
        moduleSideView_NavBridgeDeck.setVisible(false);
        moduleSideView_TS005.setVisible(false);
        moduleSideView_TS011.setVisible(false);
        moduleSideView_TS012.setVisible(false);
        moduleSideView_TS068.setVisible(false);
        moduleSideView_TS071.setVisible(false);
        moduleSideView_TS072.setVisible(false);
        moduleSideView_TS073.setVisible(false);
        moduleSideView_TS078.setVisible(false);
        moduleSideView_TS079_IT279.setVisible(false);
        moduleSideView_VentTower.setVisible(false);
    }
   
    private void updateImageViewPlant(){
        Icon initial_icon = new javax.swing.ImageIcon(pathPlantURL);
        BufferedImage img = new BufferedImage(initial_icon.getIconWidth(), initial_icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics g = img.createGraphics();
        initial_icon.paintIcon(null, g, 0, 0);
        g.dispose();
        Image newing = img.getScaledInstance((int)(initial_icon.getIconWidth()*zoomValue/10), (int)(initial_icon.getIconHeight()*zoomValue/10), java.awt.Image.SCALE_DEFAULT);
        label_viewPlant.setIcon(new ImageIcon(newing));
    }
    
    private JPanel generateT(Permit permit){
        javax.swing.JPanel t = new javax.swing.JPanel();
        t = new javax.swing.JPanel();
        t.setSize(10, 10);
        if(permit.isCold()){
            t.setBackground(Color.BLUE);
            t.setName(permit.getColdWorkPermitNo().toString());
        }
        else {
            t.setBackground(Color.RED);
            t.setName(permit.getHotWorkPermitNo().toString());
        }
        t.setToolTipText(permit.toString());
        return t;
    }
    
    public void applyPermitsInModules(Permit permit){
        javax.swing.JPanel t1 = new javax.swing.JPanel();
            t1 = new javax.swing.JPanel();
            t1.setSize(10, 10);
            if(permit.isCold()){
                t1.setBackground(Color.BLUE);
                t1.setName(permit.getColdWorkPermitNo().toString());
            }
            else {
                t1.setBackground(Color.RED);
                t1.setName(permit.getHotWorkPermitNo().toString());
            }
            
//            System.out.println(permit.getModuleNumber().toString());
            t1.setToolTipText(permit.toString());
            if(permit.getModuleNumber().toString().equalsIgnoreCase("22.0")){
                moduleFromAbove_TS022.add(t1);
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("21.0")){
                moduleFromAbove_TS021.add(t1); 
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("264.0")){
                moduleFromAbove_TS264.add(t1); 
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("265.0")){
                moduleFromAbove_TS265.add(t1); 
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("266.0")){
                moduleFromAbove_TS266.add(t1); 
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("267.0")){
                moduleFromAbove_TS267.add(t1);
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("62.0")){
                moduleFromAbove_TS062.add(t1);
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("75.0")){
                moduleFromAbove_TS075.add(t1);
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("63.0")){
                moduleFromAbove_TS063.add(t1);
            } 
            
            //TODO: Novos Modulos
            
            else if(permit.getModuleNumber().toString().equalsIgnoreCase("helideck")){
                moduleFromAbove_HeliDeck.add(t1);
                JPanel t2 = generateT(permit);
                moduleSideView_Helideck.add(t2);
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("lifeboats")){
                moduleFromAbove_LifeBoat.add(t1);
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("Pump Room")){
                moduleUpperDeck_PumpRoom.add(t1);
                JPanel t2 = generateT(permit);
                moduleSunkenDeck_PumpRoom.add(t2);
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("foam room")){
                moduleSunkenDeck_FoamRoom.add(t1);
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("Sunken Deck")){
                moduleSunkenDeck_PumpRoom.add(t1);
                JPanel t2 = generateT(permit);
                moduleSunkenDeck_FoamRoom.add(t2);
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("ER")){
                module2ndDeck_ER_EngineRoom.add(t1);
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("3rd Deck")){
                module3rdDeck.add(t1);
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("Tank Top")){
                moduleTankTop.add(t1);
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("A Deck")){
                moduleADeck.add(t1);
                JPanel t2 = generateT(permit);
                moduleSideView_ADeck.add(t2);
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("B Deck")){
                moduleBDeck.add(t1);
                JPanel t2 = generateT(permit);
                moduleSideView_BDeck.add(t2);
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("C Deck")){
                moduleCDeck.add(t1);
                JPanel t2 = generateT(permit);
                moduleSideView_CDeck.add(t2);
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("ENIF")){
                moduleEnifDeck.add(t1);
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("2nd Deck")){
                moduleMore_2Deck.add(t1);
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("D Deck")){
                moduleMore_DDeck.add(t1);
                JPanel t2 = generateT(permit);
                moduleSideView_DDeck.add(t2);
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("E Deck")){
                moduleMore_EDeck.add(t1);
                JPanel t2 = generateT(permit);
                moduleSideView_EDeck.add(t2);
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("Nev Bridge Deck")){
                moduleMore_NavBridgeDeck.add(t1);
                JPanel t2 = generateT(permit);
                moduleSideView_NavBridgeDeck.add(t2);
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("Top Deck")){
                moduleMore_TopDeck.add(t1);
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("ECR Deck")){
                moduleMore_UpperECRDeck.add(t1);
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("68.0")){
                moduleSideView_TS068.add(t1);
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("11.0")){
                moduleSideView_TS011.add(t1);
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("12.0")){
                moduleSideView_TS012.add(t1);
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("5.0")){
                moduleSideView_TS005.add(t1);
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("71.0")){
                moduleSideView_TS071.add(t1);
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("73.0")){
                moduleSideView_TS073.add(t1);
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("78.0")){
                moduleSideView_TS078.add(t1);
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("79.0") ||
                    permit.getModuleNumber().toString().equalsIgnoreCase("279.0")){
                moduleFromAbove_TS079.add(t1);
                JPanel t2 = generateT(permit);
                moduleSideView_TS079_IT279.add(t2);
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("72")){
                moduleSideView_TS072.add(t1);
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("Vent Tower")){
                moduleSideView_VentTower.add(t1);
            }else if(permit.getModuleNumber().toString().equalsIgnoreCase("Flare Tower")){
                moduleSideView_FlareTower.add(t1);
            }
    }
    
    private void initComponents(){
        
      try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      } catch (ClassNotFoundException ex) {
        Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
        Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
        Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
      } catch (UnsupportedLookAndFeelException ex) {
        Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
      }
        
        this.frame_main = new JFrame("My frame");
        this.frame_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame_main.setTitle("Permit to Work DEMO 2.0");
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight();
        this.frame_main.setSize(1400, 800);
        
//        this.menuBar = new JMenuBar();
//        this.frame_main.setJMenuBar(this.menuBar);
//        this.menuComponent_file = new JMenu("File");
        
        this.myConstraint = new GridBagConstraints();
        
        this.panel_bottons_viewPlants = new JPanel(new GridBagLayout());
        
        this.myConstraint.insets = new Insets(this.inset_leftSide, this.inset_rightSide, this.inset_topSide, this.inset_downSide);
        this.myConstraint.gridwidth = 3;
        
        this.button_import = new JButton("ImportXLSX", new ImageIcon(this.getClass().getResource("/resources/excel import.png")));
        this.button_ZoomIn = new JButton(new ImageIcon(this.getClass().getResource("/resources/zoom in.png")));
        this.button_ZoomOut = new JButton(new ImageIcon(this.getClass().getResource("/resources/zoom out.png")));
        
        this.button_fromAbove = new JButton("From Above");
        this.button_UpperDeck = new JButton("Upper Deck");
        this.button_SideView = new JButton("Side View");
        this.button_SunkenDeck = new JButton("Sunken Deck");
        this.button_2ndDeck = new JButton("2nd Deck");
        this.button_3rdDeck = new JButton("3nd Deck");
        this.button_TankTop = new JButton("Tank Top");
        this.button_ADeck = new JButton("A Deck");
        this.button_BDeck = new JButton("B Deck");
        this.button_CDeck = new JButton("C Deck");
        this.button_EnifDeck = new JButton("Enif Deck");
        this.button_More = new JButton("More");
        
        this.panel_viewPlants = new JPanel();
        this.panel_viewPlants.setLayout(new BorderLayout());
        
        Icon initial_icon = new javax.swing.ImageIcon(pathPlantURL);        
        BufferedImage img = new BufferedImage(initial_icon.getIconWidth(), initial_icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics g = img.createGraphics();
        initial_icon.paintIcon(null, g, 0, 0);
        g.dispose();
        Image newing = img.getScaledInstance((int) (initial_icon.getIconWidth() * zoomValue / 10),
                                             (int)(initial_icon.getIconHeight()*zoomValue/10),
                                             java.awt.Image.SCALE_SMOOTH);
        this.label_viewPlant = new JLabel(new ImageIcon(newing));
        this.label_viewPlant.setHorizontalAlignment(SwingConstants.LEFT);
        this.label_viewPlant.setVerticalAlignment(SwingConstants.TOP);
        
        
        //initialization of All Modules
        this.moduleFromAbove_TS022 = new JPanel();
        this.moduleFromAbove_TS021 = new JPanel();
        this.moduleFromAbove_TS264 = new JPanel();
        this.moduleFromAbove_TS265 = new JPanel();
        this.moduleFromAbove_TS266 = new JPanel();
        this.moduleFromAbove_TS267 = new JPanel();
        this.moduleFromAbove_TS062 = new JPanel();
        this.moduleFromAbove_TS075 = new JPanel();
        this.moduleFromAbove_TS063 = new JPanel();
        this.moduleFromAbove_TS074 = new JPanel();
        this.moduleFromAbove_TS076 = new JPanel();
        this.moduleFromAbove_TS077 = new JPanel();
        this.moduleFromAbove_TS289 = new JPanel();
        this.moduleFromAbove_TS068 = new JPanel();
        this.moduleFromAbove_TS011 = new JPanel();
        this.moduleFromAbove_TS012 = new JPanel();
        this.moduleFromAbove_TS005 = new JPanel();
        this.moduleFromAbove_TS071 = new JPanel();
        this.moduleFromAbove_TS073 = new JPanel();
        this.moduleFromAbove_TS078 = new JPanel();
        this.moduleFromAbove_TS079 = new JPanel();
        this.moduleFromAbove_TS072 = new JPanel();
        this.moduleFromAbove_HeliDeck = new JPanel();
        this.moduleFromAbove_LifeBoat = new JPanel();
        this.moduleUpperDeck_PumpRoom = new JPanel();
        this.moduleSunkenDeck_FoamRoom = new JPanel();
        this.moduleSunkenDeck_PumpRoom = new JPanel();
        this.module2ndDeck_ER_EngineRoom = new JPanel();
        this.module3rdDeck = new JPanel();
        this.moduleTankTop = new JPanel();
        this.moduleADeck = new JPanel();
        this.moduleBDeck = new JPanel();
        this.moduleCDeck = new JPanel();
        this.moduleEnifDeck = new JPanel();
        this.moduleMore_2Deck = new JPanel();
        this.moduleMore_DDeck = new JPanel();
        this.moduleMore_EDeck = new JPanel();
        this.moduleMore_NavBridgeDeck = new JPanel();
        this.moduleMore_TopDeck = new JPanel();
        this.moduleMore_UpperECRDeck = new JPanel();
        
        this.moduleSideView_Helideck = new JPanel();
        this.moduleSideView_NavBridgeDeck = new JPanel();
        this.moduleSideView_EDeck = new JPanel();
        this.moduleSideView_DDeck = new JPanel();
        this.moduleSideView_CDeck = new JPanel();
        this.moduleSideView_BDeck = new JPanel();
        this.moduleSideView_ADeck = new JPanel();
        this.moduleSideView_TS068 = new JPanel();
        this.moduleSideView_TS011 = new JPanel();
        this.moduleSideView_TS012 = new JPanel();
        this.moduleSideView_TS005 = new JPanel();
        this.moduleSideView_TS071 = new JPanel();
        this.moduleSideView_TS073 = new JPanel();
        this.moduleSideView_TS078 = new JPanel();
        this.moduleSideView_TS079_IT279 = new JPanel();
        this.moduleSideView_TS072 = new JPanel();
        this.moduleSideView_VentTower = new JPanel();
        this.moduleSideView_FlareTower = new JPanel();
        
        updateModules();
        //initial modules to view From Above
        this.panel_viewPlants.add(this.moduleFromAbove_TS022);
        this.panel_viewPlants.add(this.moduleFromAbove_TS021);
        this.panel_viewPlants.add(this.moduleFromAbove_TS264);
        this.panel_viewPlants.add(this.moduleFromAbove_TS265);
        this.panel_viewPlants.add(this.moduleFromAbove_TS266);
        this.panel_viewPlants.add(this.moduleFromAbove_TS267);
        this.panel_viewPlants.add(this.moduleFromAbove_TS062);
        this.panel_viewPlants.add(this.moduleFromAbove_TS075);
        this.panel_viewPlants.add(this.moduleFromAbove_TS063);
        this.panel_viewPlants.add(this.moduleFromAbove_TS074);
        this.panel_viewPlants.add(this.moduleFromAbove_TS076);
        this.panel_viewPlants.add(this.moduleFromAbove_TS077);
        this.panel_viewPlants.add(this.moduleFromAbove_TS289);
        this.panel_viewPlants.add(this.moduleFromAbove_TS068);
        this.panel_viewPlants.add(this.moduleFromAbove_TS011);
        this.panel_viewPlants.add(this.moduleFromAbove_TS012);
        this.panel_viewPlants.add(this.moduleFromAbove_TS005);
        this.panel_viewPlants.add(this.moduleFromAbove_TS071);
        this.panel_viewPlants.add(this.moduleFromAbove_TS073);
        this.panel_viewPlants.add(this.moduleFromAbove_TS078);
        this.panel_viewPlants.add(this.moduleFromAbove_TS079);
        this.panel_viewPlants.add(this.moduleFromAbove_TS072);
        this.panel_viewPlants.add(this.moduleFromAbove_HeliDeck);
        this.panel_viewPlants.add(this.moduleFromAbove_LifeBoat);
        this.panel_viewPlants.add(this.moduleUpperDeck_PumpRoom);
        this.moduleUpperDeck_PumpRoom.setVisible(false);
        this.panel_viewPlants.add(this.moduleSunkenDeck_FoamRoom);
        this.moduleSunkenDeck_FoamRoom.setVisible(false);
        this.panel_viewPlants.add(this.moduleSunkenDeck_PumpRoom);
        this.moduleSunkenDeck_PumpRoom.setVisible(false);
        this.panel_viewPlants.add(this.module2ndDeck_ER_EngineRoom);
        this.module2ndDeck_ER_EngineRoom.setVisible(false);
        this.panel_viewPlants.add(this.module3rdDeck);
        this.module3rdDeck.setVisible(false);
        this.panel_viewPlants.add(this.moduleTankTop);
        this.moduleTankTop.setVisible(false);
        this.panel_viewPlants.add(this.moduleADeck);
        this.moduleADeck.setVisible(false);
        this.panel_viewPlants.add(this.moduleBDeck);
        this.moduleBDeck.setVisible(false);
        this.panel_viewPlants.add(this.moduleCDeck);
        this.moduleCDeck.setVisible(false);
        this.panel_viewPlants.add(this.moduleEnifDeck);
        this.moduleEnifDeck.setVisible(false);
        this.panel_viewPlants.add(this.moduleMore_2Deck);
        this.moduleMore_2Deck.setVisible(false);
        this.panel_viewPlants.add(this.moduleMore_DDeck);
        this.moduleMore_DDeck.setVisible(false);
        this.panel_viewPlants.add(this.moduleMore_EDeck);
        this.moduleMore_EDeck.setVisible(false);
        this.panel_viewPlants.add(this.moduleMore_NavBridgeDeck);
        this.moduleMore_NavBridgeDeck.setVisible(false);
        this.panel_viewPlants.add(this.moduleMore_TopDeck);
        this.moduleMore_TopDeck.setVisible(false);
        this.panel_viewPlants.add(this.moduleMore_UpperECRDeck);
        this.moduleMore_UpperECRDeck.setVisible(false);
        
        this.panel_viewPlants.add(this.moduleSideView_ADeck);
        this.moduleSideView_ADeck.setVisible(false);
        this.panel_viewPlants.add(this.moduleSideView_BDeck);
        this.moduleSideView_BDeck.setVisible(false);
        this.panel_viewPlants.add(this.moduleSideView_CDeck);
        this.moduleSideView_CDeck.setVisible(false);
        this.panel_viewPlants.add(this.moduleSideView_DDeck);
        this.moduleSideView_DDeck.setVisible(false);
        this.panel_viewPlants.add(this.moduleSideView_EDeck);
        this.moduleSideView_EDeck.setVisible(false);
        this.panel_viewPlants.add(this.moduleSideView_FlareTower);
        this.moduleSideView_FlareTower.setVisible(false);
        this.panel_viewPlants.add(this.moduleSideView_Helideck);
        this.moduleSideView_Helideck.setVisible(false);
        this.panel_viewPlants.add(this.moduleSideView_NavBridgeDeck);
        this.moduleSideView_NavBridgeDeck.setVisible(false);
        this.panel_viewPlants.add(this.moduleSideView_TS005);
        this.moduleSideView_TS005.setVisible(false);
        this.panel_viewPlants.add(this.moduleSideView_TS011);
        this.moduleSideView_TS011.setVisible(false);
        this.panel_viewPlants.add(this.moduleSideView_TS012);
        this.moduleSideView_TS012.setVisible(false);
        this.panel_viewPlants.add(this.moduleSideView_TS068);
        this.moduleSideView_TS068.setVisible(false);
        this.panel_viewPlants.add(this.moduleSideView_TS071);
        this.moduleSideView_TS071.setVisible(false);
        this.panel_viewPlants.add(this.moduleSideView_TS072);
        this.moduleSideView_TS072.setVisible(false);
        this.panel_viewPlants.add(this.moduleSideView_TS073);
        this.moduleSideView_TS073.setVisible(false);
        this.panel_viewPlants.add(this.moduleSideView_TS078);
        this.moduleSideView_TS078.setVisible(false);
        this.panel_viewPlants.add(this.moduleSideView_TS079_IT279);
        this.moduleSideView_TS079_IT279.setVisible(false);
        this.panel_viewPlants.add(this.moduleSideView_VentTower);
        this.moduleSideView_VentTower.setVisible(false);
        
        
        
        
        this.panel_viewPlants.add(this.label_viewPlant);
      
        this.scrollPanel_viewPlant = new JScrollPane(panel_viewPlants);
        
        this.frame_main.setVisible(true);
//        this.progressBar_importXLSX = new JProgressBar(0,99999999);
//        this.progressBar_importXLSX.setValue(0);
//        this.progressBar_importXLSX.setStringPainted(true);
        
        
    }
    
    public void updateModules(){
        
        
        this.moduleFromAbove_TS022.setLocation((int)(2637*zoomValue/10),(int)(600*zoomValue/10));
        this.moduleFromAbove_TS022.setSize((int)(576*zoomValue/10), (int)(795*zoomValue/10));
        this.moduleFromAbove_TS022.setBackground(new Color(0,0,255,80));
        
        this.moduleFromAbove_TS021.setLocation((int)(3272*zoomValue/10),(int)(600*zoomValue/10));
        this.moduleFromAbove_TS021.setSize((int)(709*zoomValue/10), (int)(795*zoomValue/10));
        this.moduleFromAbove_TS021.setBackground(new Color(0,255,0,80));
        
        this.moduleFromAbove_TS264.setLocation((int)(4053*zoomValue/10),(int)(573*zoomValue/10));
        this.moduleFromAbove_TS264.setSize((int)(877*zoomValue/10), (int)(261*zoomValue/10));
        this.moduleFromAbove_TS264.setBackground(new Color(255,0,0,80));
        
        this.moduleFromAbove_TS265.setLocation((int)(4980*zoomValue/10),(int)(548*zoomValue/10));
        this.moduleFromAbove_TS265.setSize((int)(719*zoomValue/10), (int)(295*zoomValue/10));
        this.moduleFromAbove_TS265.setBackground(new Color(255,0,0,80));
        
        this.moduleFromAbove_TS266.setLocation((int)(5764*zoomValue/10),(int)(525*zoomValue/10));
        this.moduleFromAbove_TS266.setSize((int)(717*zoomValue/10), (int)(321*zoomValue/10));
        this.moduleFromAbove_TS266.setBackground(new Color(255,0,0,80));
        
        this.moduleFromAbove_TS267.setLocation((int)(6545*zoomValue/10),(int)(580*zoomValue/10));
        this.moduleFromAbove_TS267.setSize((int)(851*zoomValue/10), (int)(259*zoomValue/10));
        this.moduleFromAbove_TS267.setBackground(new Color(255,0,2,80));
   
        this.moduleFromAbove_TS062.setLocation((int)(4189*zoomValue/10),(int)(900*zoomValue/10));
        this.moduleFromAbove_TS062.setSize((int)(719*zoomValue/10), (int)(497*zoomValue/10));
        this.moduleFromAbove_TS062.setBackground(new Color(0,0,255,80));
        
        this.moduleFromAbove_TS075.setLocation((int)(4985*zoomValue/10),(int)(900*zoomValue/10));
        this.moduleFromAbove_TS075.setSize((int)(719*zoomValue/10), (int)(497*zoomValue/10));
        this.moduleFromAbove_TS075.setBackground(new Color(0,255,0,80));
        
        this.moduleFromAbove_TS063.setLocation((int)(5761*zoomValue/10),(int)(900*zoomValue/10));
        this.moduleFromAbove_TS063.setSize((int)(709*zoomValue/10), (int)(503*zoomValue/10));
        this.moduleFromAbove_TS063.setBackground(new Color(0,0,255,80));
        
        this.moduleFromAbove_TS074.setLocation((int)(6545*zoomValue/10),(int)(900*zoomValue/10));
        this.moduleFromAbove_TS074.setSize((int)(875*zoomValue/10), (int)(503*zoomValue/10));
        this.moduleFromAbove_TS074.setBackground(new Color(0,255,0,80));
        
        this.moduleFromAbove_TS076.setLocation((int)(7477*zoomValue/10),(int)(820*zoomValue/10));
        this.moduleFromAbove_TS076.setSize((int)(721*zoomValue/10), (int)(585*zoomValue/10));
        this.moduleFromAbove_TS076.setBackground(new Color(0,0,255,80));
        
        this.moduleFromAbove_TS077.setLocation((int)(8257*zoomValue/10),(int)(867*zoomValue/10));
        this.moduleFromAbove_TS077.setSize((int)(709*zoomValue/10), (int)(527*zoomValue/10));
        this.moduleFromAbove_TS077.setBackground(new Color(0,255,0,80));
        
        this.moduleFromAbove_TS289.setLocation((int)(9145*zoomValue/10),(int)(1225*zoomValue/10));
        this.moduleFromAbove_TS289.setSize((int)(391*zoomValue/10), (int)(347*zoomValue/10));
        this.moduleFromAbove_TS289.setBackground(new Color(255,0,0,80));
        
        this.moduleFromAbove_TS068.setLocation((int)(2109*zoomValue/10),(int)(1437*zoomValue/10));
        this.moduleFromAbove_TS068.setSize((int)(469*zoomValue/10), (int)(775*zoomValue/10));
        this.moduleFromAbove_TS068.setBackground(new Color(0,0,255,80));
        
        this.moduleFromAbove_TS011.setLocation((int)(2627*zoomValue/10),(int)(1429*zoomValue/10));
        this.moduleFromAbove_TS011.setSize((int)(737*zoomValue/10), (int)(737*zoomValue/10));
        this.moduleFromAbove_TS011.setBackground(new Color(0,255,0,80));
        
        this.moduleFromAbove_TS012.setLocation((int)(3411*zoomValue/10),(int)(1433*zoomValue/10));
        this.moduleFromAbove_TS012.setSize((int)(731*zoomValue/10), (int)(741*zoomValue/10));
        this.moduleFromAbove_TS012.setBackground(new Color(0,0,255,80));
        
        this.moduleFromAbove_TS005.setLocation((int)(4200*zoomValue/10),(int)(1435*zoomValue/10));
        this.moduleFromAbove_TS005.setSize((int)(721*zoomValue/10), (int)(655*zoomValue/10));
        this.moduleFromAbove_TS005.setBackground(new Color(0,255,0,80));
        
        this.moduleFromAbove_TS071.setLocation((int)(4987*zoomValue/10),(int)(1431*zoomValue/10));
        this.moduleFromAbove_TS071.setSize((int)(715*zoomValue/10), (int)(775*zoomValue/10));
        this.moduleFromAbove_TS071.setBackground(new Color(0,0,255,80));
        
        this.moduleFromAbove_TS073.setLocation((int)(5757*zoomValue/10),(int)(1433*zoomValue/10));
        this.moduleFromAbove_TS073.setSize((int)(875*zoomValue/10), (int)(789*zoomValue/10));
        this.moduleFromAbove_TS073.setBackground(new Color(0,255,0,80));
        
        this.moduleFromAbove_TS078.setLocation((int)(6697*zoomValue/10),(int)(1429*zoomValue/10));
        this.moduleFromAbove_TS078.setSize((int)(723*zoomValue/10), (int)(715*zoomValue/10));
        this.moduleFromAbove_TS078.setBackground(new Color(0,0,255,80));
        
        this.moduleFromAbove_TS079.setLocation((int)(7483*zoomValue/10),(int)(1433*zoomValue/10));
        this.moduleFromAbove_TS079.setSize((int)(723*zoomValue/10), (int)(847*zoomValue/10));
        this.moduleFromAbove_TS079.setBackground(new Color(0,255,0,80));
        
        this.moduleFromAbove_TS072.setLocation((int)(8263*zoomValue/10),(int)(1433*zoomValue/10));
        this.moduleFromAbove_TS072.setSize((int)(719*zoomValue/10), (int)(553*zoomValue/10));
        this.moduleFromAbove_TS072.setBackground(new Color(0,0,255,80));
        
        this.moduleFromAbove_HeliDeck.setLocation((int)(5*zoomValue/10),(int)(1001*zoomValue/10));
        this.moduleFromAbove_HeliDeck.setSize((int)(843*zoomValue/10), (int)(783*zoomValue/10));
        this.moduleFromAbove_HeliDeck.setBackground(new Color(0,255,255,80));
        
        this.moduleFromAbove_LifeBoat.setLocation((int)(1100*zoomValue/10),(int)(600*zoomValue/10));
        this.moduleFromAbove_LifeBoat.setSize((int)(843*zoomValue/10), (int)(400*zoomValue/10));
        this.moduleFromAbove_LifeBoat.setBackground(new Color(0,255,255,80));
        
        this.moduleUpperDeck_PumpRoom.setLocation((int)(2050*zoomValue/10),(int)(1324*zoomValue/10));
        this.moduleUpperDeck_PumpRoom.setSize((int)(157*zoomValue/10), (int)(190*zoomValue/10));
        this.moduleUpperDeck_PumpRoom.setBackground(new Color(0,255,255,80));
        
        this.moduleSunkenDeck_FoamRoom.setLocation((int)(1480*zoomValue/10),(int)(1004*zoomValue/10));
        this.moduleSunkenDeck_FoamRoom.setSize((int)(196*zoomValue/10), (int)(225*zoomValue/10));
        this.moduleSunkenDeck_FoamRoom.setBackground(new Color(0,255,255,80));
        
        this.moduleSunkenDeck_PumpRoom.setLocation((int)(1673*zoomValue/10),(int)(665*zoomValue/10));
        this.moduleSunkenDeck_PumpRoom.setSize((int)(156*zoomValue/10), (int)(380*zoomValue/10));
        this.moduleSunkenDeck_PumpRoom.setBackground(new Color(0,255,0,80));
        
        this.module2ndDeck_ER_EngineRoom.setLocation((int)(1035*zoomValue/10),(int)(716*zoomValue/10));
        this.module2ndDeck_ER_EngineRoom.setSize((int)(477*zoomValue/10), (int)(335*zoomValue/10));
        this.module2ndDeck_ER_EngineRoom.setBackground(new Color(0,255,0,95));
        
        this.module3rdDeck.setLocation((int)(100*zoomValue/10),(int)(100*zoomValue/10));
        this.module3rdDeck.setSize((int)(1500*zoomValue/10), (int)(1500*zoomValue/10));
        this.module3rdDeck.setBackground(new Color(255,255,0,50));
        
        this.moduleTankTop.setLocation((int)(100*zoomValue/10),(int)(100*zoomValue/10));
        this.moduleTankTop.setSize((int)(1400*zoomValue/10), (int)(1000*zoomValue/10));
        this.moduleTankTop.setBackground(new Color(255,255,0,50));
        
        this.moduleADeck.setLocation((int)(100*zoomValue/10),(int)(100*zoomValue/10));
        this.moduleADeck.setSize((int)(1500*zoomValue/10), (int)(1500*zoomValue/10));
        this.moduleADeck.setBackground(new Color(255,255,0,50));
        
        this.moduleBDeck.setLocation((int)(100*zoomValue/10),(int)(100*zoomValue/10));
        this.moduleBDeck.setSize((int)(1500*zoomValue/10), (int)(1500*zoomValue/10));
        this.moduleBDeck.setBackground(new Color(255,255,0,50));
        
        this.moduleCDeck.setLocation((int)(100*zoomValue/10),(int)(100*zoomValue/10));
        this.moduleCDeck.setSize((int)(1500*zoomValue/10), (int)(1500*zoomValue/10));
        this.moduleCDeck.setBackground(new Color(255,255,0,50));
        
        this.moduleEnifDeck.setLocation((int)(100*zoomValue/10),(int)(100*zoomValue/10));
        this.moduleEnifDeck.setSize((int)(1500*zoomValue/10), (int)(1500*zoomValue/10));
        this.moduleEnifDeck.setBackground(new Color(255,255,0,50));
        
        this.moduleMore_2Deck.setLocation((int)(100*zoomValue/10),(int)(200*zoomValue/10));
        this.moduleMore_2Deck.setSize((int)(1100*zoomValue/10), (int)(1800*zoomValue/10));
        this.moduleMore_2Deck.setBackground(new Color(255,255,0,50));
        
        this.moduleMore_DDeck.setLocation((int)(1550*zoomValue/10),(int)(200*zoomValue/10));
        this.moduleMore_DDeck.setSize((int)(1100*zoomValue/10), (int)(1800*zoomValue/10));
        this.moduleMore_DDeck.setBackground(new Color(255,255,0,50));
        
        this.moduleMore_EDeck.setLocation((int)(3000*zoomValue/10),(int)(200*zoomValue/10));
        this.moduleMore_EDeck.setSize((int)(1100*zoomValue/10), (int)(1800*zoomValue/10));
        this.moduleMore_EDeck.setBackground(new Color(255,255,0,50));
        
        this.moduleMore_NavBridgeDeck.setLocation((int)(100*zoomValue/10),(int)(2500*zoomValue/10));
        this.moduleMore_NavBridgeDeck.setSize((int)(1100*zoomValue/10), (int)(1800*zoomValue/10));
        this.moduleMore_NavBridgeDeck.setBackground(new Color(255,255,0,50));
        
        this.moduleMore_TopDeck.setLocation((int)(1750*zoomValue/10),(int)(2500*zoomValue/10));
        this.moduleMore_TopDeck.setSize((int)(1100*zoomValue/10), (int)(1800*zoomValue/10));
        this.moduleMore_TopDeck.setBackground(new Color(255,255,0,50));
        
        this.moduleMore_UpperECRDeck.setLocation((int)(3200*zoomValue/10),(int)(2500*zoomValue/10));
        this.moduleMore_UpperECRDeck.setSize((int)(1100*zoomValue/10), (int)(1800*zoomValue/10));
        this.moduleMore_UpperECRDeck.setBackground(new Color(255,255,0,50));

        
        this.moduleSideView_ADeck.setLocation((int)(2120*zoomValue/10),(int)(1303*zoomValue/10));
        this.moduleSideView_ADeck.setSize((int)(501*zoomValue/10), (int)(107*zoomValue/10));
        this.moduleSideView_ADeck.setBackground(new Color(255,255,0,50));
        
        this.moduleSideView_BDeck.setLocation((int)(2120*zoomValue/10),(int)(1205*zoomValue/10));
        this.moduleSideView_BDeck.setSize((int)(503*zoomValue/10), (int)(95*zoomValue/10));
        this.moduleSideView_BDeck.setBackground(new Color(255,255,0,50));
        
        this.moduleSideView_CDeck.setLocation((int)(2120*zoomValue/10),(int)(1105*zoomValue/10));
        this.moduleSideView_CDeck.setSize((int)(501*zoomValue/10), (int)(99*zoomValue/10));
        this.moduleSideView_CDeck.setBackground(new Color(255,255,0,50));
        
        this.moduleSideView_DDeck.setLocation((int)(2120*zoomValue/10),(int)(1001*zoomValue/10));
        this.moduleSideView_DDeck.setSize((int)(503*zoomValue/10), (int)(101*zoomValue/10));
        this.moduleSideView_DDeck.setBackground(new Color(255,255,0,50));
        
        this.moduleSideView_EDeck.setLocation((int)(2120*zoomValue/10),(int)(897*zoomValue/10));
        this.moduleSideView_EDeck.setSize((int)(499*zoomValue/10), (int)(107*zoomValue/10));
        this.moduleSideView_EDeck.setBackground(new Color(255,255,0,50));
        
        this.moduleSideView_FlareTower.setLocation((int)(9860*zoomValue/10),(int)(515*zoomValue/10));
        this.moduleSideView_FlareTower.setSize((int)(389*zoomValue/10), (int)(969*zoomValue/10));
        this.moduleSideView_FlareTower.setBackground(new Color(255,255,0,50));
        
        this.moduleSideView_Helideck.setLocation((int)(668*zoomValue/10),(int)(826*zoomValue/10));
        this.moduleSideView_Helideck.setSize((int)(951*zoomValue/10), (int)(349*zoomValue/10));
        this.moduleSideView_Helideck.setBackground(new Color(255,255,0,50));
        
        this.moduleSideView_NavBridgeDeck.setLocation((int)(2120*zoomValue/10),(int)(793*zoomValue/10));
        this.moduleSideView_NavBridgeDeck.setSize((int)(501*zoomValue/10), (int)(105*zoomValue/10));
        this.moduleSideView_NavBridgeDeck.setBackground(new Color(255,255,0,50));
        
        this.moduleSideView_TS005.setLocation((int)(4914*zoomValue/10),(int)(1005*zoomValue/10));
        this.moduleSideView_TS005.setSize((int)(725*zoomValue/10), (int)(425*zoomValue/10));
        this.moduleSideView_TS005.setBackground(new Color(255,255,0,50));
        
        this.moduleSideView_TS011.setLocation((int)(3351*zoomValue/10),(int)(664*zoomValue/10));
        this.moduleSideView_TS011.setSize((int)(717*zoomValue/10), (int)(773*zoomValue/10));
        this.moduleSideView_TS011.setBackground(new Color(255,255,0,50));
        
        this.moduleSideView_TS012.setLocation((int)(4119*zoomValue/10),(int)(658*zoomValue/10));
        this.moduleSideView_TS012.setSize((int)(733*zoomValue/10), (int)(781*zoomValue/10));
        this.moduleSideView_TS012.setBackground(new Color(255,255,0,50));
        
        this.moduleSideView_TS068.setLocation((int)(2807*zoomValue/10),(int)(1266*zoomValue/10));
        this.moduleSideView_TS068.setSize((int)(501*zoomValue/10), (int)(177*zoomValue/10));
        this.moduleSideView_TS068.setBackground(new Color(255,255,0,50));
        
        this.moduleSideView_TS071.setLocation((int)(5690*zoomValue/10),(int)(713*zoomValue/10));
        this.moduleSideView_TS071.setSize((int)(721*zoomValue/10), (int)(729*zoomValue/10));
        this.moduleSideView_TS071.setBackground(new Color(255,255,0,50));
        
        this.moduleSideView_TS072.setLocation((int)(8975*zoomValue/10),(int)(452*zoomValue/10));
        this.moduleSideView_TS072.setSize((int)(713*zoomValue/10), (int)(993*zoomValue/10));
        this.moduleSideView_TS072.setBackground(new Color(255,255,0,50));
        
        this.moduleSideView_TS073.setLocation((int)(6476*zoomValue/10),(int)(637*zoomValue/10));
        this.moduleSideView_TS073.setSize((int)(869*zoomValue/10), (int)(805*zoomValue/10));
        this.moduleSideView_TS073.setBackground(new Color(255,255,0,50));
        
        this.moduleSideView_TS078.setLocation((int)(7408*zoomValue/10),(int)(650*zoomValue/10));
        this.moduleSideView_TS078.setSize((int)(717*zoomValue/10), (int)(793*zoomValue/10));
        this.moduleSideView_TS078.setBackground(new Color(255,255,0,50));
        
        this.moduleSideView_TS079_IT279.setLocation((int)(8187*zoomValue/10),(int)(908*zoomValue/10));
        this.moduleSideView_TS079_IT279.setSize((int)(717*zoomValue/10), (int)(535*zoomValue/10));
        this.moduleSideView_TS079_IT279.setBackground(new Color(255,255,0,50));
        
        this.moduleSideView_VentTower.setLocation((int)(9686*zoomValue/10),(int)(533*zoomValue/10));
        this.moduleSideView_VentTower.setSize((int)(169*zoomValue/10), (int)(915*zoomValue/10));
        this.moduleSideView_VentTower.setBackground(new Color(255,255,0,50));
        
    }
       
    private void addContentsToContents(){
        
//        this.menuBar.add(menuComponent_file);

        //Buttons to panel
        this.panel_bottons_viewPlants.add(button_ZoomIn,this.myConstraint);
        this.panel_bottons_viewPlants.add(button_ZoomOut,this.myConstraint);
        this.panel_bottons_viewPlants.add(this.button_import,this.myConstraint);
        this.panel_bottons_viewPlants.add(this.button_fromAbove,this.myConstraint);
        this.panel_bottons_viewPlants.add(this.button_UpperDeck,this.myConstraint);
        this.panel_bottons_viewPlants.add(this.button_SideView,this.myConstraint);
        this.panel_bottons_viewPlants.add(this.button_SunkenDeck,this.myConstraint);
        this.panel_bottons_viewPlants.add(this.button_2ndDeck,this.myConstraint);
        this.panel_bottons_viewPlants.add(this.button_3rdDeck,this.myConstraint);
        this.panel_bottons_viewPlants.add(this.button_TankTop,this.myConstraint);
        this.panel_bottons_viewPlants.add(this.button_ADeck,this.myConstraint);
        this.panel_bottons_viewPlants.add(this.button_BDeck,this.myConstraint);
        this.panel_bottons_viewPlants.add(this.button_CDeck,this.myConstraint);
        this.panel_bottons_viewPlants.add(this.button_EnifDeck,this.myConstraint);
        this.panel_bottons_viewPlants.add(this.button_More,this.myConstraint);

        this.frame_main.getContentPane().add(this.panel_bottons_viewPlants,BorderLayout.NORTH);
        
        this.frame_main.add(this.scrollPanel_viewPlant);
        
        this.frame_main.setVisible(true);
        
        
    }
    
}
