/**
 *
/**
 * @author Rohit Ahuja
 * rohitahuja@email.com
 * 9893075987
 */


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SplashPanel.java
 *
 * Created on Apr 24, 2009, 1:55:56 PM
 */
package com.vedisoft.sis;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JWindow;

/**
 *
 * @author Windows XP
 */
public class SplashPanel extends javax.swing.JPanel {

    /** Creates new form SplashPanel */
    public SplashPanel() {
        initComponents();
    }

    public void abc(int a) {
        jProgressBar1.setValue(a);
    }

    public static void main(String[] args) {
        Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dm.width - 408) / 2;
        int y = (dm.height - 223) / 2;
        JWindow win = new JWindow();
        SplashPanel sp = new SplashPanel();
        win.setContentPane(sp);
        win.setBounds(x, y, 408, 223);
        win.setVisible(true);
        try {
            for (int i = 1; i <= 100; i++) {
                sp.abc(i);
                Thread.sleep(50);
            }
        } catch (Exception e) {
        }
        win.setVisible(false);
        MainFrame mf = new MainFrame();
        mf.setBounds(0, 0,(int) dm.getWidth(), (int)dm.getHeight());
        mf.setVisible(true);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 153), 10, true));
        setLayout(new java.awt.BorderLayout());

        jProgressBar1.setForeground(new java.awt.Color(102, 204, 0));
        add(jProgressBar1, java.awt.BorderLayout.PAGE_END);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vedisoft.jpg"))); // NOI18N
        add(jLabel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
/**
* Vedisoft : Java - Module 1 "Desktop Technologies"
*
*
*   Vedisoft Software & Education Services Pvt. Ltd.
*   Plot No. 275, Zone II, M.P. Nagar,
*   Bhopal.
*   Phone : 0755 - 4076207, 4076208
*   Email : contact@vedisoft.com
*   Web : www.vedisoft.com
*/