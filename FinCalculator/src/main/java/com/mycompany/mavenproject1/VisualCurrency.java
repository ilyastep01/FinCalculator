/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author ilyas
 */
public class VisualCurrency extends JFrame {
    
    String link = null;
    String link2 = null;
    float CurAt = 1;
    boolean curRubBol = false;
    boolean curAtRubBol = false;
    boolean curDoubleBol = false;
    String[] dolDateGlobal;
    float[] dolValGlobal;
    int grafOffset = 0;
    Thread myThready = new AnimThreadCur(this);	
    
    public static void main(String[] args) throws Exception {
                     
        
           javax.swing.SwingUtilities.invokeLater(() -> {
               try {
                   createGUI("https://www.vbr.ru/banki/kurs-valut/cbrf/eur/","https://www.vbr.ru/banki/kurs-valut/cbrf/xdr/",1,false,true,false);
               } catch (Exception ex) {
                   Logger.getLogger(VisualCurrency.class.getName()).log(Level.SEVERE, null, ex);
               }
           }); 
          
    }
      
    public static void createGUI(String link, String link2,float CurAt,boolean curRubBol,boolean curAtRubBol,boolean curDoubleBol) throws Exception {

          VisualCurrency frame = new VisualCurrency(link,link2,CurAt,curRubBol,curAtRubBol,curDoubleBol);
          frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


          frame.getContentPane().paint(frame.getGraphics());
          
        frame.setPreferredSize(new Dimension(1500, 900));
          
          frame.pack();
          frame.setVisible(true);          
     }
    
    public void start() throws Exception{
         
        javax.swing.SwingUtilities.invokeLater(() -> {
               try {
                   createGUI(link,link2,CurAt,curRubBol,curAtRubBol,curDoubleBol);
               } catch (Exception ex) {
                   Logger.getLogger(VisualCurrency.class.getName()).log(Level.SEVERE, null, ex);
               }
           });
        
     }
        
    VisualCurrency(String linkTmp, String link2Tmp, float CurAtTmp, boolean curRubBolTmp,boolean curAtRubBolTmp, boolean curDoubleBolTmp ) {
        setLayout(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int sizeWidth = 1500;
        int sizeHeight = 900;
        int locationX = (screenSize.width - sizeWidth) / 2;
        int locationY = (screenSize.height - sizeHeight) / 2;
        //this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(locationX, locationY, sizeWidth, sizeHeight);
        //this.setSize(sizeWidth, sizeHeight);
        //this.setLocation(locationX, locationY);
        link = linkTmp;
        link2 = link2Tmp;
        CurAt = CurAtTmp;
        curRubBol = curRubBolTmp;
        curDoubleBol = curDoubleBolTmp;
        curAtRubBol = curAtRubBolTmp;
        connect();
        try {
        myThready.start();
        } catch (Exception e) {
        }
    }
    
    public final void connect(){
        String dol = "",dol2 = "";
        try {
            dol = getContentOfHTTPPage(link);
            dol2 = getContentOfHTTPPage(link2);
        } catch (Exception ex) {
            Logger.getLogger(VisualCurrency.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          String[] dolDate = new String[14];
          float[] dolVal = new float[14], dol2Val = new float[14];
          
          for (int i = 0; i < dolDate.length; i++) {
            dol = dol.substring(dol.indexOf("currencies_table_def")+"currencies_table_def".length());
            dol2 = dol2.substring(dol2.indexOf("currencies_table_def")+"currencies_table_def".length());
            dolDate[i] = dol.substring(55, 65);

            
                try {
                  dolVal[i] = Float.parseFloat(dol.substring(81, 83)+"."+dol.substring(84, 88));
                } catch (NumberFormatException e) {
                try {
                  dolVal[i] = Float.parseFloat(dol.substring(81, 82)+"."+dol.substring(83, 87));
                } catch (NumberFormatException ex) {
                  dolVal[i] = Float.parseFloat(dol.substring(81, 84)+"."+dol.substring(85, 89));
                }                 
                } 
                
                try {
                  dol2Val[i] = Float.parseFloat(dol2.substring(81, 83)+"."+dol2.substring(84, 88));
                } catch (NumberFormatException e) {
                try {
                  dol2Val[i] = Float.parseFloat(dol2.substring(81, 82)+"."+dol2.substring(83, 87));
                } catch (NumberFormatException ex) {
                  dol2Val[i] = Float.parseFloat(dol2.substring(81, 84)+"."+dol2.substring(85, 89));
                }                 
                } 
                
                if (curRubBol) {dolVal[i] = 1/dol2Val[i];}
                
                
                if (curDoubleBol) {dolVal[i] /= dolVal[i];}
                
                if ((!curDoubleBol)&&(!curRubBol)&&(!curAtRubBol)) {
                    
                    dolVal[i] /= dol2Val[i];
                
                } 
                
                
                
                
                
            
            }
          ArrayList<String> dolDateListFull = null;
        try {
            dolDateListFull = reverseOrder(getDateDiprosone(dolDate[dolDate.length-1],dolDate[0]));
        } catch (ParseException ex) {
            Logger.getLogger(VisualCurrency.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          
           ArrayList<String> dolDateList = new ArrayList<>();
           ArrayList<Float> dolValList = new ArrayList<>();
           
           dolDateList.addAll(Arrays.asList(dolDate));
           for (float s : dolVal) {
            dolValList.add(s);
            }


          if (dolDateListFull != null) {
          for (int i = 0; i < dolDateListFull.size()-1; i++) {
              if (!dolDateList.get(i).equals(dolDateListFull.get(i))){
                  dolDateList.add(i,dolDateListFull.get(i));
                  dolValList.add(i,dolValList.get(i)); 
              }  
          }
          }

          dolDate = new String[dolDateList.size()];
          dolVal = new float[dolValList.size()];
          
          for (int i = 0; i < dolDateList.size(); i++) {
            dolDate[i] = dolDateList.get(i);
            dolVal[i] = dolValList.get(i);
        }
          
    dolDateGlobal = dolDate;
    dolValGlobal = dolVal;
          
    }
    
    public void paint2(Graphics2D gr) {
        
        String[] dolDate = dolDateGlobal;
        float[] dolVal = dolValGlobal;
        
        int width = getWidth();
        int height = getHeight();
        gr.setColor(new Color(214,217,223));
        gr.fillRect(0, 0, width, height);
        
        gr.setColor(Color.BLACK);
        int offsetX = 70;
        int offsetX_2 = getWidth()-70;
        int offsetY = 70;
        int offsetY_2 = this.getHeight()-70;
        int lengthX = offsetX_2 - offsetX;
        int lengthY = offsetY_2 - offsetY;
        
        
        Font currentFont = gr.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * getWidth()/1500F);
        gr.setFont(newFont);
        
        //gr.drawLine(offsetX-5, offsetY_2-20, offsetX+5, offsetY_2-20);
        int[] xPoints = new int[(dolDate.length)];
        
//        for (int i = 0; i <= (dolDate.length-1); i++) {
//            gr.setColor(Color.GRAY);
//            gr.drawLine(offsetX +(lengthX/(dolDate.length-1))*i , offsetY_2, offsetX +(lengthX/(dolDate.length-1))*i , offsetY);
//            gr.setColor(Color.BLACK);
//            gr.drawLine(offsetX +(lengthX/(dolDate.length-1))*i , offsetY_2-5, offsetX +(lengthX/(dolDate.length-1))*i , offsetY_2+5);
//            if (i != 0){
//            gr.drawString(dolDate[(dolDate.length-1)-i], offsetX +(lengthX/(dolDate.length-1))*i - lengthX/((dolDate.length-1)*2), offsetY_2 + lengthY/((dolDate.length-1)*2));}
//            xPoints[(dolDate.length-1) - i]=offsetX +(lengthX/(dolDate.length-1))*i;
//        }
        


        for (int i = 0; i <= (dolDate.length-1); i++) {
            gr.setColor(Color.GRAY);
            gr.drawLine(offsetX - grafOffset +(lengthX/(dolDate.length-1))*i*2 , offsetY_2, offsetX - grafOffset +(lengthX/(dolDate.length-1))*i*2 , offsetY);
            gr.setColor(Color.BLACK);
            gr.drawLine(offsetX - grafOffset +(lengthX/(dolDate.length-1))*i*2 , offsetY_2-5, offsetX - grafOffset +(lengthX/(dolDate.length-1))*i*2 , offsetY_2+5);
            if (i != 0){
            gr.drawString(dolDate[(dolDate.length-1)-i], offsetX - grafOffset +(lengthX/(dolDate.length-1))*i*2 - lengthX/((dolDate.length-1)*2), offsetY_2 + lengthY/((dolDate.length-1)*2));}
            xPoints[(dolDate.length-1) - i]=offsetX - grafOffset +(lengthX/(dolDate.length-1))*i*2;
        }

        
        
        
        float min = -1, max = 0;
        for (float f : dolVal) {
            if ((f < min)||(min == -1)){min = f;}
            if (f > max){max = f;}
        }

        int minInt = (int) Math.floor(min);
        int maxInt = (int) Math.floor(max+1);
        int difInt = (maxInt - minInt);
        double difDem;
        double difDemZero;
        if ((difInt >= 3)&&(difInt <= 10)){
          difInt *=2;
          difDem = 0.5;
          difDemZero = 0.0;
        } else if (difInt >= 2) {
          difInt *=4;
          difDem = 0.25;  
          difDemZero = 0.00;
        } else {
          difInt *=8;
          difDem = 0.125;
          difDemZero = 0.000;
        }
        
        if (curDoubleBol){
            minInt = 0;
            maxInt = 2;
            difInt = 4;
            difDem = 0.5;
            difDemZero = 0.0;
        }
        
        int tmpMin=offsetY, tmpMax, tmpDif;
        
        for (int i = 1; i <= difInt; i++) {
            tmpMin = offsetY_2-(lengthY/difInt)*i;
        }
        gr.drawLine(offsetX-5, offsetY_2, offsetX+5, offsetY_2);
        gr.drawString(String.valueOf(minInt+difDemZero), offsetX - (lengthX/30) , offsetY_2 );
        //System.out.println(offsetY_2+" "+String.valueOf(minInt+0.0));
        tmpMax = offsetY_2;
        tmpDif = tmpMax - tmpMin;
        gr.drawLine(offsetX, offsetY, offsetX, offsetY_2);
        gr.drawLine(offsetX, offsetY_2, offsetX_2, offsetY_2);
        
               
        int[] yPoints = new int[dolVal.length];
        
        for (int i = 0; i < dolVal.length; i++) {

            
              yPoints[i] = (int) (tmpMax - ((tmpDif/(maxInt - minInt))*(dolVal[i] - minInt)));   
              
        }

        for (int i = 1; i <= difInt; i++) {
            gr.setColor(Color.GRAY);
            gr.drawLine(offsetX, offsetY_2-(lengthY/difInt)*i, offsetX_2, offsetY_2-(lengthY/difInt)*i);
            gr.setColor(Color.LIGHT_GRAY);
            gr.drawLine(offsetX, offsetY_2-(lengthY/difInt)*i+(lengthY/(difInt*2)), offsetX_2, offsetY_2-(lengthY/difInt)*i+(lengthY/(difInt*2)));
        }

        gr.setColor(Color.BLUE);
        Graphics2D g2 = (Graphics2D) gr;   
        g2.setStroke(new BasicStroke(1.5f));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); //сглаживание
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.drawPolyline(xPoints, yPoints, xPoints.length);
        
        gr.setColor(new Color(214,217,223));
        gr.fillRect(0, 0, offsetX, height);
        gr.fillRect(offsetX_2, 0, width, height);
        

            if (grafOffset == getWidth()-139){
                gr.setColor(Color.BLACK);
            gr.drawString(dolDate[(dolDate.length-1)-(dolDate.length-1)], offsetX - grafOffset +(lengthX/(dolDate.length-1))*(dolDate.length-1)*2 - lengthX/((dolDate.length-1)*2), offsetY_2 + lengthY/((dolDate.length-1)*2));}

        
        for (int i = 1; i <= difInt; i++) {
            gr.setColor(Color.BLACK);
            gr.drawLine(offsetX-5, offsetY_2-(lengthY/difInt)*i, offsetX+5, offsetY_2-(lengthY/difInt)*i);
            gr.drawString(String.valueOf(minInt+difDem*i), offsetX - (lengthX/30) , offsetY_2-(lengthY/difInt)*i );
        }
        gr.drawLine(offsetX-5, offsetY_2, offsetX+5, offsetY_2);
        gr.drawString(String.valueOf(minInt+difDemZero), offsetX - (lengthX/30) , offsetY_2 );

        gr.dispose();
        
    }
    
    @Override
    public void paint(Graphics g) {
    BufferedImage bufferedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = bufferedImage.createGraphics();
    paint2(g2d);
    Graphics2D g2dComponent = (Graphics2D) g;
    g2dComponent.drawImage(bufferedImage, null, 0, 0);       
    }
       
    public static String getContentOfHTTPPage(String pageAddress) throws Exception {
        StringBuilder sb = new StringBuilder();
        URL pageURL = new URL(pageAddress);
        URLConnection uc = pageURL.openConnection();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        uc.getInputStream()))) {
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }         
        }
        return sb.toString();
    }
    
    public static  ArrayList<String> getDateDiprosone(String dateStart, String dateEnd) throws ParseException {
        
    ArrayList<String> dateList = new ArrayList<>(); 
    Calendar gcal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    Date start = sdf.parse(dateStart);
    Date end = sdf.parse(dateEnd);
    gcal.setTime(start);
    gcal.add(Calendar.DAY_OF_MONTH, -1);
    do {
        gcal.add(Calendar.DAY_OF_MONTH, 1);
        Date d = gcal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String dateString = dateFormat.format(d); 
        dateList.add(dateString);
    } while (gcal.getTime().before(end));
    
    
    return dateList;    
    }
     
    public static ArrayList<String> reverseOrder(ArrayList<String> a){

         ArrayList<String> d = new ArrayList<>();
         
         for (int i = a.size()-1; i >= 0; i--) {
             d.add(a.get(i));
         }
         return d;
    }
    
    public class windowListener implements WindowListener {

        @Override
          public void windowActivated(WindowEvent e) {
                          
          }

          @Override
          public void windowClosed(WindowEvent e) {
               
                myThready.stop();
                  
          }

          @Override
          public void windowClosing(WindowEvent e) {
               //System.out.println("windowClosing" );               
          }

          @Override
          public void windowDeactivated(WindowEvent e) {
                           
          }

          @Override
          public void windowDeiconified(WindowEvent e) {
                             
          }

          @Override
          public void windowIconified(WindowEvent e) {
                              
          }

          @Override
          public void windowOpened(WindowEvent e) {
               
          }
     }
    
}

class AnimThreadCur extends Thread			
	
{
    VisualCurrency frame = null;
    
        AnimThreadCur(VisualCurrency frameTmp){
           //start(); 
           frame = frameTmp;
           
        }
    
        @Override
	public void run()		
	{
              
            try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(VisualGrossBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while (frame.grafOffset < frame.getWidth()-139){
        
        
            
        try {
            TimeUnit.MILLISECONDS.sleep(5);
        } catch (InterruptedException ex) {
            Logger.getLogger(VisualGrossBook.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        frame.grafOffset += 1;
	frame.repaint();
        
        } 
        frame.grafOffset = frame.getWidth()-139;
	frame.repaint();
        }
        
        
}