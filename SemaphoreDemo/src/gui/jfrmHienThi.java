/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.Stack;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.DefaultListModel;

/**
 *
 * @author Admin
 */
public class jfrmHienThi extends javax.swing.JFrame {
    
    final int SLEEPTIME_C = 1000;    
    final int SLEEPTIME_P = 400;

    
    public static Semaphore writePermits;
    public static Semaphore readPermits;
    public static Stack<Integer> buffer;
    
    DefaultListModel<String> model = new DefaultListModel<>();
    DefaultListModel<String> modelC1 = new DefaultListModel<>();
    DefaultListModel<String> modelC2 = new DefaultListModel<>();
    DefaultListModel<String> modelC3 = new DefaultListModel<>();

    static boolean isRunning;


    /**
     * Creates new form jfrmHienThi
     */
    public jfrmHienThi() {
        initComponents();    
        writePermits = null;
        readPermits = null;
        buffer = new Stack<>();
        
        lstData.setModel(model);
        
        lstConsumer1.setModel(modelC1);
        lstConsumer2.setModel(modelC2);
        lstConsumer3.setModel(modelC3);
        
        isRunning = false;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMain = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNum = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstConsumer1 = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstConsumer3 = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        lstConsumer2 = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstData = new javax.swing.JList<>();
        btnChay = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        ckbP1 = new javax.swing.JCheckBox();
        ckbP2 = new javax.swing.JCheckBox();
        btnStop = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        pnMain.setBackground(new java.awt.Color(255, 255, 255));
        pnMain.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Producer & Consumer");

        jLabel2.setText("Số sản phẩm:");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lstConsumer1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consumer 1", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        lstConsumer1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(lstConsumer1);

        lstConsumer3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consumer 3", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        lstConsumer3.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(lstConsumer3);

        lstConsumer2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consumer 2", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        lstConsumer2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(lstConsumer2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
        );

        lstData.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        lstData.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstData);

        btnChay.setText("Chạy");
        btnChay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChayActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        ckbP1.setText("Producer 1");

        ckbP2.setText("Producer 2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ckbP1)
                    .addComponent(ckbP2))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ckbP1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ckbP2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnStop.setText("Ngừng");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnMainLayout = new javax.swing.GroupLayout(pnMain);
        pnMain.setLayout(pnMainLayout);
        pnMainLayout.setHorizontalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnMainLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114)
                .addComponent(btnChay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStop)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnMainLayout.setVerticalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMainLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChay)
                    .addComponent(btnStop))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChayActionPerformed
        btnChay.setEnabled(isRunning);
        
        isRunning = true;
        
        int BUFFER_SIZE = Integer.parseInt(txtNum.getText());
        
        writePermits = new Semaphore(BUFFER_SIZE);
        readPermits = new Semaphore(0);
        
        // producer
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (isRunning) {
                        writePermits.acquire();
                        ckbP1.setSelected(true); // thực hiện công việc

                        Thread.sleep(SLEEPTIME_P); // simulate time to work

                        int data = ThreadLocalRandom.current().nextInt(100);
                        buffer.push(data);

                        model.insertElementAt(data + "", 0);

                        readPermits.release();

                        ckbP1.setSelected(false);// ngừng công việc
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start(); // 1
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (isRunning) {
                        writePermits.acquire();
                        ckbP2.setSelected(true); // thực hiện công việc

                        Thread.sleep(SLEEPTIME_P); // simulate time to work

                        int data = ThreadLocalRandom.current().nextInt(100);     
                        buffer.push(data);

                        model.insertElementAt(data + "", 0);

                        readPermits.release();

                        ckbP2.setSelected(false);// ngừng công việc
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start(); // 2
        // consumer
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (isRunning) {
                        readPermits.acquire();
                        
                        Thread.sleep(SLEEPTIME_C); // simulate time to work
                        String a = buffer.pop()+"";

                        modelC1.insertElementAt(a, 0);                    
                        model.removeElement(a);

                        writePermits.release();

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start(); // 1
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (isRunning) {
                        readPermits.acquire();
                        Thread.sleep(SLEEPTIME_C + 100); // simulate time to work
                        String a = buffer.pop()+"";

                        modelC2.insertElementAt(a, 0);                    
                        model.removeElement(a);

                        writePermits.release();

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start(); // 2
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (isRunning) {
                        readPermits.acquire();
                        Thread.sleep(SLEEPTIME_C + 200); // simulate time to work
                        String a = buffer.pop()+"";

                        modelC3.insertElementAt(a, 0);                    
                        model.removeElement(a);

                        writePermits.release();

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start(); // 3
    }//GEN-LAST:event_btnChayActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        
        if (!isRunning)
        {
            // clear
            model.removeAllElements();
            modelC1.removeAllElements();
            modelC2.removeAllElements();
            modelC3.removeAllElements();
            ckbP1.setSelected(false);
            ckbP2.setSelected(false);
            
            // clear stack
            buffer.clear();
            
            btnChay.setEnabled(true);
            btnStop.setText("Ngừng");
            
            txtNum.requestFocus();
            return;
        }
        isRunning = !isRunning;
        
        btnStop.setText("Khởi động lại");
        
    }//GEN-LAST:event_btnStopActionPerformed

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
            java.util.logging.Logger.getLogger(jfrmHienThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfrmHienThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfrmHienThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfrmHienThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfrmHienThi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChay;
    private javax.swing.JButton btnStop;
    private javax.swing.JCheckBox ckbP1;
    private javax.swing.JCheckBox ckbP2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList<String> lstConsumer1;
    private javax.swing.JList<String> lstConsumer2;
    private javax.swing.JList<String> lstConsumer3;
    private javax.swing.JList<String> lstData;
    private javax.swing.JPanel pnMain;
    private javax.swing.JTextField txtNum;
    // End of variables declaration//GEN-END:variables
}
