/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;



/**
 *
 * @author ilyas
 */
public class CurrencyConverterForm extends javax.swing.JFrame {
public static float RUB = 1;
public static float USD = -1;
public static float EUR = -1;
public static float GBP = -1;
public static float KZT = -1;
    
        
    

    /**
     * Creates new form MainWindow
     */
    public CurrencyConverterForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Конвертор валют");

        jButton1.setText("Назад");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField2.setEditable(false);

        jButton2.setText("Рассчитать");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RUB", "USD", "EUR", "GBP", "KZT" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RUB", "USD", "EUR", "GBP", "KZT" }));

        jButton3.setText("График курса валюты относительно");
        jButton3.setActionCommand("График курса валюты относительно");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RUB", "USD", "EUR", "GBP", "KZT" }));
        jComboBox3.setToolTipText("");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RUB", "USD", "EUR", "GBP", "KZT" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(440, 440, 440)
                        .addComponent(jButton2)))
                .addContainerGap(268, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(39, 39, 39)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(306, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        float text1=0;
        
        if (!"".equals(jTextField1.getText())) {text1 = Integer.parseInt (jTextField1.getText());}

        

        String tmpS = (String) jComboBox1.getSelectedItem();
        String tmpS2 = (String) jComboBox2.getSelectedItem();
        
        float x = 0,y = 0;
               
        if (null != tmpS) switch (tmpS) {
        case "RUB":
            x = RUB;
            break;
        case "USD":
            x = USD;
            break;
        case "EUR":
            x = EUR;
            break;
        case "GBP":
            x = GBP;
            break;
        case "KZT":
            x = KZT;
            break; 
        default:
            x = 1;
            break;
    }

        
        if (null != tmpS2) switch (tmpS2) {
        case "RUB":
            y = RUB;
            break;
        case "USD":
            y = USD;
            break;
        case "EUR":
            y = EUR;
            break;
        case "GBP":
            y = GBP;
            break;
        case "KZT":
            y = KZT;
            break;    
        default:
            y = 1;
            break;
    }
        
//        if ("RUB".equals(tmpS)) { x = 1; } 
//        else if ("USD".equals(tmpS)) { x = USD; } 
//        else if ("EUR".equals(tmpS)) { x = EUR; }
        
//        if ("RUB".equals(tmpS2)) { y = 1; } 
//        else if ("USD".equals(tmpS2)) { y = USD; } 
//        else if ("EUR".equals(tmpS2)) { y = EUR; }        
        
        jTextField2.setText(Float.toString((text1/y)*x));

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MainForm mainWindow = new MainForm();
        mainWindow.start();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String link = "https://www.vbr.ru/banki/kurs-valut/cbrf/usd/";
        String link2 = "https://www.vbr.ru/banki/kurs-valut/cbrf/usd/";
        float curAt = 1;
        boolean curRubBol = false;
        boolean curAtRubBol = false;
        boolean curDoubleBol = false;
         String tmpS3 = (String) jComboBox3.getSelectedItem();
         String tmpS4 = (String) jComboBox4.getSelectedItem();
         
         if (null != tmpS3) switch (tmpS3) {
        case "RUB":
            link = "https://www.vbr.ru/banki/kurs-valut/cbrf/usd/";
            curRubBol = true;
            break;     
        case "USD":
            link = "https://www.vbr.ru/banki/kurs-valut/cbrf/usd/";
            break;
        case "EUR":
            link = "https://www.vbr.ru/banki/kurs-valut/cbrf/eur/";
            break;
        case "GBP":
            link = "https://www.vbr.ru/banki/kurs-valut/cbrf/gbp/";
            break;
        case "KZT":
            link = "https://www.vbr.ru/banki/kurs-valut/cbrf/kzt/";
            break;    
        default:
            link = "https://www.vbr.ru/banki/kurs-valut/cbrf/usd/";
            break;
        }
         
         if (null != tmpS4) switch (tmpS4) {
        case "RUB":
            if ("RUB".equals(tmpS3)) {curDoubleBol = true;}
            curAtRubBol = true;
            link2 = "https://www.vbr.ru/banki/kurs-valut/cbrf/usd/";
            break;
        case "USD":
            if ("USD".equals(tmpS3)) {curDoubleBol = true;}
            link2 = "https://www.vbr.ru/banki/kurs-valut/cbrf/usd/";
            break;
        case "EUR":
            if ("EUR".equals(tmpS3)) {curDoubleBol = true;}
            link2 = "https://www.vbr.ru/banki/kurs-valut/cbrf/eur/";
            break;
        case "GBP":
            if ("GBP".equals(tmpS3)) {curDoubleBol = true;}
            link2 = "https://www.vbr.ru/banki/kurs-valut/cbrf/gbp/";
            break;
        case "KZT":
            if ("KZT".equals(tmpS3)) {curDoubleBol = true;}
            link2 = "https://www.vbr.ru/banki/kurs-valut/cbrf/kzt/";
            break;    
        default:
            curAt = 1;
            break;
        }
         
//         if ("USD".equals(tmpS3)) { link = "https://www.vbr.ru/banki/kurs-valut/cbrf/usd/3mesaca/"; } 
//         else if ("EUR".equals(tmpS3)) { link = "https://www.vbr.ru/banki/kurs-valut/cbrf/eur/3mesaca/"; }
//         else if ("111".equals(tmpS3)) { link = "https://www.vbr.ru/banki/kurs-valut/cbrf/eur/3mesaca/";}
         
   VisualCurrency frame = new VisualCurrency(link, link2, curAt, curRubBol, curAtRubBol, curDoubleBol);
    try {
        frame.start();
    } catch (Exception ex) {
        Logger.getLogger(CurrencyConverterForm.class.getName()).log(Level.SEVERE, null, ex);
    }   
        
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception {
      
        start();
        
    }
    
    public static void start() throws Exception {
        
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
            java.util.logging.Logger.getLogger(CreditCalcForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreditCalcForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreditCalcForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreditCalcForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        if ((USD == -1)){
        USD = CurrencyConvert.getСurVal("https://www.vbr.ru/banki/kurs-valut/cbrf/usd/");
        EUR = CurrencyConvert.getСurVal("https://www.vbr.ru/banki/kurs-valut/cbrf/eur/");
        GBP = CurrencyConvert.getСurVal("https://www.vbr.ru/banki/kurs-valut/cbrf/gbp/");
        KZT = CurrencyConvert.getСurVal("https://www.vbr.ru/banki/kurs-valut/cbrf/kzt/");}
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int sizeWidth = 980;
                int sizeHeight = 600;
                int locationX = (screenSize.width - sizeWidth) / 2;
                int locationY = (screenSize.height - sizeHeight) / 2;
                javax.swing.JFrame frame = new CurrencyConverterForm();
                frame.setBounds(locationX, locationY, sizeWidth, sizeHeight);
                frame.setVisible(true);
                                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}