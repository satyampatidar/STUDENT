package com.vedisoft.sis;

import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Windows XP
 */
public class CoursewiseSubjects extends javax.swing.JPanel {

    /** Creates new form CoursewiseSubjects */
    public CoursewiseSubjects() {
        initComponents();
        Subjects p = new Subjects();
        Vector rows = p.getRecordsTwo();
        Vector columns = p.getColumnsOne();
        DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
        dm.setDataVector(rows, columns);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Coursewise Subjects Form");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(new CoursewiseSubjects());
        f.setBounds(10, 10, 500, 500);
        f.setVisible(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
