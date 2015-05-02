
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
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
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
    
    // }
    //finish here

    private JLabel label_viewPlant;
    private JScrollPane scrollPanel_viewPlant;
    private JProgressBar progressBar_importXLSX;
    
    private JMenuBar menuBar;
    private JMenu menuComponent_file;
    
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
            if(permit.getModuleNumber().toString().compareTo("22.0")==0){
                moduleFromAbove_TS022.add(t1);
                //f.add(moduleTS022);    
            }else if(permit.getModuleNumber().toString().compareTo("21.0")==0){
                //f.add(moduleTS021);
                moduleFromAbove_TS021.add(t1); 
            }else if(permit.getModuleNumber().toString().compareTo("264.0")==0){
                //f.add(moduleTS264);
                moduleFromAbove_TS264.add(t1); 
            }else if(permit.getModuleNumber().toString().compareTo("265.0")==0){
                //f.add(moduleTS265);
                moduleFromAbove_TS265.add(t1); 
            }else if(permit.getModuleNumber().toString().compareTo("266.0")==0){
                //f.add(moduleTS266);
                moduleFromAbove_TS266.add(t1); 
            }else if(permit.getModuleNumber().toString().compareTo("267.0")==0){
                //f.add(moduleTS267);
                moduleFromAbove_TS267.add(t1);
            }else if(permit.getModuleNumber().toString().compareTo("62.0")==0){
               // f.add(moduleTS062);
                moduleFromAbove_TS062.add(t1);
            }else if(permit.getModuleNumber().toString().compareTo("75.0")==0){
                //f.add(moduleTS075);
                moduleFromAbove_TS075.add(t1);
            }else if(permit.getModuleNumber().toString().compareTo("63.0")==0){
                //f.add(moduleTS063);
                moduleFromAbove_TS063.add(t1);
            } 
    }
    
    private void initComponents(){
        
        
        
        this.frame_main = new JFrame("My frame");
        this.frame_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame_main.setTitle("Permit to Work DEMO 2.0");
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight();
        this.frame_main.setSize(1400, 800);
        
        

        this.menuBar = new JMenuBar();
        this.frame_main.setJMenuBar(this.menuBar);
        this.menuComponent_file = new JMenu("File");
        
        this.myConstraint = new GridBagConstraints();
        
        this.panel_bottons_viewPlants = new JPanel(new GridBagLayout());
        
        this.myConstraint.insets = new Insets(this.inset_leftSide, this.inset_rightSide, this.inset_topSide, this.inset_downSide);
        this.myConstraint.gridwidth = 3;
        
        this.button_import = new JButton("ImportXLSX");
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
        
        this.button_ZoomIn = new JButton("+");
        this.button_ZoomOut = new JButton("-");
        
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
        
    }
       
    private void addContentsToContents(){
        
        this.menuBar.add(menuComponent_file);

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
