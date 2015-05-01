
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
import javax.swing.*;



public class Frame_Main{

    private JFrame frame_main;
    
    private JPanel panel_bottons_viewPlants;
    private JPanel panel_viewPlants;
    
    private JButton button_fromAbove;
    private JButton button_UpperDeck;
    private JButton button_SideView;
    private JButton button_SunkenDeck;
    private JButton button_2ndDeck;
    private JButton button_3ndDeck;
    private JButton button_TankTop;
    private JButton button_ADeck;
    private JButton button_BDeck;
    private JButton button_CDeck;
    private JButton button_EnifDeck;
    private JButton button_More;
    
    private JButton button_ZoomIn;
    private JButton button_ZoomOut;
    
    private double zoomValue = 3;
    
    private JPanel moduleTS022;
    private JPanel moduleTS021;
    private JPanel moduleTS264;
    private JPanel moduleTS265;
    private JPanel moduleTS266;
    private JPanel moduleTS267;
    private JPanel moduleVE286;
    private JPanel moduleTS062;
    private JPanel moduleTS075;
    private JPanel moduleTS063;
    private JPanel moduleTS074;
    private JPanel moduleTS076;
    private JPanel moduleTS077;
    private JPanel moduleTS289;
    private JPanel moduleTS068;
    private JPanel moduleTS011;
    private JPanel moduleTS012;
    private JPanel moduleTS005;
    private JPanel moduleTS071;
    private JPanel moduleTS073;
    private JPanel moduleTS078;
    private JPanel moduleTS079;
    private JPanel moduleIT279;
    private JPanel moduleTS072;

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
    
    public void go(){
        
        initComponents();
        addContentsToContents();
        
        
        button_ZoomIn.addActionListener(
                new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae){
                  
                    
                    
                    if(zoomValue<10){
                        zoomValue+=1;
                        zoomValue=((int)(zoomValue*10))/10.0;
                        System.out.println(zoomValue);
                        Icon initial_icon = new javax.swing.ImageIcon("src/view/images_plants/ViewFromAbove.jpg");
                        BufferedImage img = new BufferedImage(initial_icon.getIconWidth(), initial_icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
                        Graphics g = img.createGraphics();
                        initial_icon.paintIcon(null, g, 0, 0);
                        g.dispose();
                        Image newing = img.getScaledInstance((int)(initial_icon.getIconWidth()*zoomValue/10), (int)(initial_icon.getIconHeight()*zoomValue/10), java.awt.Image.SCALE_FAST);


                        label_viewPlant.setIcon(new ImageIcon(newing));
                    }
                    
                    updateModules_FromAbove();
                
                }
        });
        button_ZoomOut.addActionListener(
                new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae){

                    if(zoomValue>1){
                        zoomValue-=1;
                        System.out.println(zoomValue);
                        Icon initial_icon = new javax.swing.ImageIcon("src/view/images_plants/ViewFromAbove.jpg");
                        BufferedImage img = new BufferedImage(initial_icon.getIconWidth(), initial_icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
                        Graphics g = img.createGraphics();
                        initial_icon.paintIcon(null, g, 0, 0);
                        g.dispose();
                        Image newing = img.getScaledInstance((int)(initial_icon.getIconWidth()*zoomValue/10), (int)(initial_icon.getIconHeight()*zoomValue/10), java.awt.Image.SCALE_FAST);
                        label_viewPlant.setIcon(new ImageIcon(newing));
                    }
                    
                    updateModules_FromAbove();
                }
        });
       
        
        
        scrollPanel_viewPlant.addMouseMotionListener(null);
        
//        button_UpperDeck.addActionListener(
//            new ActionListener(){
//                @Override
//                public void actionPerformed(ActionEvent ae){
//                    System.out.println("Button was clicked");
//                    new SwingWorker(){
//                        @Override
//                        protected Object doInBackground()throws Exception{
////                            progressBar_importXLSX.setVisible(true);
////                            for (int i = 0; i < 100000000; i++) {
////                                progressBar_importXLSX.setValue(i);
////                                new Date();
////                            }
////                            progressBar_importXLSX.setVisible(false);
////                            setScrollImage(scrollPanel_viewPlant,"src/view/images_plants/ViewFromAbove.jpg");
//                            return null;
//                        }
//                    }.execute();
//            }
//        });

//        for(;;){
//            try{    
//                Thread.sleep(2000);
//            }catch(InterruptedException ex){
//            }
//            SwingUtilities.invokeLater(new Runnable() {
//                @Override
//                public void run() {
//                    theText.append("\nTickle"+new Date());
//                }
//            });
//        }
    }
    
    private void initComponents(){
        
        
        
        this.frame_main = new JFrame("My frame");
        this.frame_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame_main.setTitle("Permit to Work DEMO 2.0");
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight();
        this.frame_main.setSize(xsize, ysize);
        
        

        this.menuBar = new JMenuBar();
        this.frame_main.setJMenuBar(this.menuBar);
        this.menuComponent_file = new JMenu("File");
        
        this.myConstraint = new GridBagConstraints();
        
        this.panel_bottons_viewPlants = new JPanel(new GridBagLayout());
        
        this.myConstraint.insets = new Insets(this.inset_leftSide, this.inset_rightSide, this.inset_topSide, this.inset_downSide);
        this.myConstraint.gridwidth = 3;
        
        this.button_fromAbove = new JButton("From Above");
        this.button_UpperDeck = new JButton("Upper Deck");
        this.button_SideView = new JButton("Side View");
        this.button_SunkenDeck = new JButton("Sunken Deck");
        this.button_2ndDeck = new JButton("2nd Deck");
        this.button_3ndDeck = new JButton("3nd Deck");
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
        
        
        Icon initial_icon = new javax.swing.ImageIcon("src/view/images_plants/ViewFromAbove.jpg");
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
        
        
        
        this.moduleTS022 = new JPanel();
        this.moduleTS021 = new JPanel();
        this.moduleTS264 = new JPanel();
        this.moduleTS265 = new JPanel();
        this.moduleTS266 = new JPanel();
        this.moduleTS267 = new JPanel();
        this.moduleTS062 = new JPanel();
        this.moduleTS075 = new JPanel();
        this.moduleTS063 = new JPanel();
        this.moduleTS074 = new JPanel();
        this.moduleTS076 = new JPanel();
        this.moduleTS077 = new JPanel();
        this.moduleTS289 = new JPanel();
        this.moduleTS068 = new JPanel();
        this.moduleTS011 = new JPanel();
        this.moduleTS012 = new JPanel();
        this.moduleTS005 = new JPanel();
        this.moduleTS071 = new JPanel();
        this.moduleTS073 = new JPanel();
        this.moduleTS078 = new JPanel();
        this.moduleTS079 = new JPanel();
        this.moduleTS072 = new JPanel();
        updateModules_FromAbove();
        this.panel_viewPlants.add(this.moduleTS022);
        this.panel_viewPlants.add(this.moduleTS021);
        this.panel_viewPlants.add(this.moduleTS264);
        this.panel_viewPlants.add(this.moduleTS265);
        this.panel_viewPlants.add(this.moduleTS266);
        this.panel_viewPlants.add(this.moduleTS267);
        this.panel_viewPlants.add(this.moduleTS062);
        this.panel_viewPlants.add(this.moduleTS075);
        this.panel_viewPlants.add(this.moduleTS063);
        this.panel_viewPlants.add(this.moduleTS074);
        this.panel_viewPlants.add(this.moduleTS076);
        this.panel_viewPlants.add(this.moduleTS077);
        this.panel_viewPlants.add(this.moduleTS289);
        this.panel_viewPlants.add(this.moduleTS068);
        this.panel_viewPlants.add(this.moduleTS011);
        this.panel_viewPlants.add(this.moduleTS012);
        this.panel_viewPlants.add(this.moduleTS005);
        this.panel_viewPlants.add(this.moduleTS071);
        this.panel_viewPlants.add(this.moduleTS073);
        this.panel_viewPlants.add(this.moduleTS078);
        this.panel_viewPlants.add(this.moduleTS079);
        this.panel_viewPlants.add(this.moduleTS072);
        
        this.panel_viewPlants.add(this.label_viewPlant);
      
        this.scrollPanel_viewPlant = new JScrollPane(panel_viewPlants);
        
        this.frame_main.setVisible(true);
//        this.progressBar_importXLSX = new JProgressBar(0,99999999);
//        this.progressBar_importXLSX.setValue(0);
//        this.progressBar_importXLSX.setStringPainted(true);
        
        
    }
    
    public void updateModules_FromAbove(){
        
        
        this.moduleTS022.setLocation((int)(2637*zoomValue/10),(int)(600*zoomValue/10));
        this.moduleTS022.setSize((int)(576*zoomValue/10), (int)(795*zoomValue/10));
        this.moduleTS022.setBackground(new Color(0,0,255,80));
        
        
        this.moduleTS021.setLocation((int)(3272*zoomValue/10),(int)(600*zoomValue/10));
        this.moduleTS021.setSize((int)(709*zoomValue/10), (int)(795*zoomValue/10));
        this.moduleTS021.setBackground(new Color(0,255,0,80));
        
        this.moduleTS264.setLocation((int)(4053*zoomValue/10),(int)(573*zoomValue/10));
        this.moduleTS264.setSize((int)(877*zoomValue/10), (int)(261*zoomValue/10));
        this.moduleTS264.setBackground(new Color(255,0,0,80));
        
        this.moduleTS265.setLocation((int)(4980*zoomValue/10),(int)(548*zoomValue/10));
        this.moduleTS265.setSize((int)(719*zoomValue/10), (int)(295*zoomValue/10));
        this.moduleTS265.setBackground(new Color(255,0,0,80));
        
        this.moduleTS266.setLocation((int)(5764*zoomValue/10),(int)(525*zoomValue/10));
        this.moduleTS266.setSize((int)(717*zoomValue/10), (int)(321*zoomValue/10));
        this.moduleTS266.setBackground(new Color(255,0,0,80));
        
        this.moduleTS267.setLocation((int)(6545*zoomValue/10),(int)(580*zoomValue/10));
        this.moduleTS267.setSize((int)(851*zoomValue/10), (int)(259*zoomValue/10));
        this.moduleTS267.setBackground(new Color(255,0,2,80));
   
        this.moduleTS062.setLocation((int)(4189*zoomValue/10),(int)(900*zoomValue/10));
        this.moduleTS062.setSize((int)(719*zoomValue/10), (int)(497*zoomValue/10));
        this.moduleTS062.setBackground(new Color(0,0,255,80));
        
        this.moduleTS075.setLocation((int)(4985*zoomValue/10),(int)(900*zoomValue/10));
        this.moduleTS075.setSize((int)(719*zoomValue/10), (int)(497*zoomValue/10));
        this.moduleTS075.setBackground(new Color(0,255,0,80));
        
        this.moduleTS063.setLocation((int)(5761*zoomValue/10),(int)(900*zoomValue/10));
        this.moduleTS063.setSize((int)(709*zoomValue/10), (int)(503*zoomValue/10));
        this.moduleTS063.setBackground(new Color(0,0,255,80));
        
        this.moduleTS074.setLocation((int)(6545*zoomValue/10),(int)(900*zoomValue/10));
        this.moduleTS074.setSize((int)(875*zoomValue/10), (int)(503*zoomValue/10));
        this.moduleTS074.setBackground(new Color(0,255,0,80));
        
        this.moduleTS076.setLocation((int)(7477*zoomValue/10),(int)(820*zoomValue/10));
        this.moduleTS076.setSize((int)(721*zoomValue/10), (int)(585*zoomValue/10));
        this.moduleTS076.setBackground(new Color(0,0,255,80));
        
        this.moduleTS077.setLocation((int)(8257*zoomValue/10),(int)(867*zoomValue/10));
        this.moduleTS077.setSize((int)(709*zoomValue/10), (int)(527*zoomValue/10));
        this.moduleTS077.setBackground(new Color(0,255,0,80));
        
        this.moduleTS289.setLocation((int)(9145*zoomValue/10),(int)(1225*zoomValue/10));
        this.moduleTS289.setSize((int)(391*zoomValue/10), (int)(347*zoomValue/10));
        this.moduleTS289.setBackground(new Color(255,0,0,80));
        
        this.moduleTS068.setLocation((int)(2109*zoomValue/10),(int)(1437*zoomValue/10));
        this.moduleTS068.setSize((int)(469*zoomValue/10), (int)(775*zoomValue/10));
        this.moduleTS068.setBackground(new Color(0,0,255,80));
        
        this.moduleTS011.setLocation((int)(2627*zoomValue/10),(int)(1429*zoomValue/10));
        this.moduleTS011.setSize((int)(737*zoomValue/10), (int)(737*zoomValue/10));
        this.moduleTS011.setBackground(new Color(0,255,0,80));
        
        this.moduleTS012.setLocation((int)(3411*zoomValue/10),(int)(1433*zoomValue/10));
        this.moduleTS012.setSize((int)(731*zoomValue/10), (int)(741*zoomValue/10));
        this.moduleTS012.setBackground(new Color(0,0,255,80));
        
        this.moduleTS005.setLocation((int)(4200*zoomValue/10),(int)(1435*zoomValue/10));
        this.moduleTS005.setSize((int)(721*zoomValue/10), (int)(655*zoomValue/10));
        this.moduleTS005.setBackground(new Color(0,255,0,80));
        
        this.moduleTS071.setLocation((int)(4987*zoomValue/10),(int)(1431*zoomValue/10));
        this.moduleTS071.setSize((int)(715*zoomValue/10), (int)(775*zoomValue/10));
        this.moduleTS071.setBackground(new Color(0,0,255,80));
        
        this.moduleTS073.setLocation((int)(5757*zoomValue/10),(int)(1433*zoomValue/10));
        this.moduleTS073.setSize((int)(875*zoomValue/10), (int)(789*zoomValue/10));
        this.moduleTS073.setBackground(new Color(0,255,0,80));
        
        this.moduleTS078.setLocation((int)(6697*zoomValue/10),(int)(1429*zoomValue/10));
        this.moduleTS078.setSize((int)(723*zoomValue/10), (int)(715*zoomValue/10));
        this.moduleTS078.setBackground(new Color(0,0,255,80));
        
        this.moduleTS079.setLocation((int)(7483*zoomValue/10),(int)(1433*zoomValue/10));
        this.moduleTS079.setSize((int)(723*zoomValue/10), (int)(847*zoomValue/10));
        this.moduleTS079.setBackground(new Color(0,255,0,80));
        
        this.moduleTS072.setLocation((int)(8263*zoomValue/10),(int)(1433*zoomValue/10));
        this.moduleTS072.setSize((int)(719*zoomValue/10), (int)(553*zoomValue/10));
        this.moduleTS072.setBackground(new Color(0,0,255,80));
        
        
    }
            
    
    private void addContentsToContents(){
        
        this.menuBar.add(menuComponent_file);

        //Buttons to panel
        this.panel_bottons_viewPlants.add(button_ZoomIn,this.myConstraint);
        this.panel_bottons_viewPlants.add(button_ZoomOut,this.myConstraint);
        this.panel_bottons_viewPlants.add(this.button_fromAbove,this.myConstraint);
        this.panel_bottons_viewPlants.add(this.button_UpperDeck,this.myConstraint);
        this.panel_bottons_viewPlants.add(this.button_SideView,this.myConstraint);
        this.panel_bottons_viewPlants.add(this.button_SunkenDeck,this.myConstraint);
        this.panel_bottons_viewPlants.add(this.button_2ndDeck,this.myConstraint);
        this.panel_bottons_viewPlants.add(this.button_3ndDeck,this.myConstraint);
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

//    private void setScrollImage(JScrollPane scrollPane, String path){
//        
//        
//        Icon initial_icon = new javax.swing.ImageIcon(path);
//        this.label_viewPlant.setIcon(initial_icon);
////        BufferedImage img = new BufferedImage(initial_icon.getIconWidth(), initial_icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
////        Graphics g = img.createGraphics();
////        initial_icon.paintIcon(null, g, 0, 0);
////        g.dispose();
////        Image newing = img.getScaledInstance((int)(this.label_viewPlant.getIcon().getIconWidth()/5.7), (int)(this.label_viewPlant.getIcon().getIconHeight()/5.7), java.awt.Image.SCALE_SMOOTH);
////        this.label_viewPlant.setIcon(new ImageIcon(newing));
//        scrollPane.add(this.label_viewPlant);
//    }
    
}
