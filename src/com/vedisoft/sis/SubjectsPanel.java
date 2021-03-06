/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vedisoft.sis;

import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class SubjectsPanel extends javax.swing.JPanel {

    Subjects s;
    int tot = 0, cur = 0;
    Vector  courses;

    /** Creates new form SubjectsPanel */
    public SubjectsPanel() {
        
        s = new Subjects();        
        courses = s.getCourses();
        System.out.println(courses);
        initComponents();
        int num = s.getTotal();
        if (num >= 1) {
            cur = 1;
            tot = num;
            s = s.getRecord(1);
            show(s);
        }
        updateStatus();
    }

    public void updateStatus() {
        jLabel1.setText("Row " + cur + " of " + tot);
    }

    public void show(Subjects s) {        
        jComboBox1.setSelectedIndex(s.getCourseid());
        jTextField1.setText(s.getSubjectcode());
        jTextField2.setText(s.getSubjectname());
        jTextField3.setText("" + s.getSemester());
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Subjects Form");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(new SubjectsPanel());
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox(courses);
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setFont(new java.awt.Font("Verdana", 3, 18));
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);

        add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setLayout(null);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Subjects"));

        jLabel2.setFont(new java.awt.Font("Verdana", 3, 18));
        jLabel2.setText("Subject Code");

        jTextField1.setFont(new java.awt.Font("Verdana", 3, 18));

        jLabel3.setFont(new java.awt.Font("Verdana", 3, 18));
        jLabel3.setText("Subject Name");

        jTextField2.setFont(new java.awt.Font("Verdana", 3, 18));

        jLabel4.setFont(new java.awt.Font("Verdana", 3, 18));
        jLabel4.setText("Semester");

        jTextField3.setFont(new java.awt.Font("Verdana", 3, 18));

        jLabel5.setFont(new java.awt.Font("Verdana", 3, 18));
        jLabel5.setText("Course");

        jComboBox1.setFont(new java.awt.Font("Verdana", 3, 18)); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                        .addGap(42, 42, 42))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, 0, 107, Short.MAX_VALUE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                .addGap(86, 86, 86))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3);
        jPanel3.setBounds(30, 20, 750, 240);

        jButton1.setFont(new java.awt.Font("Verdana", 3, 18));
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(90, 310, 90, 40);

        jButton2.setFont(new java.awt.Font("Verdana", 3, 18));
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(180, 310, 120, 40);

        jButton3.setFont(new java.awt.Font("Verdana", 3, 18));
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(300, 310, 100, 40);

        jButton4.setFont(new java.awt.Font("Verdana", 3, 18));
        jButton4.setText("Save");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(400, 310, 90, 40);

        jButton5.setFont(new java.awt.Font("Verdana", 3, 18));
        jButton5.setText("First");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);
        jButton5.setBounds(90, 350, 90, 40);

        jButton6.setFont(new java.awt.Font("Verdana", 3, 18));
        jButton6.setText("Next");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6);
        jButton6.setBounds(180, 350, 90, 40);

        jButton7.setFont(new java.awt.Font("Verdana", 3, 18));
        jButton7.setText("Previous");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7);
        jButton7.setBounds(270, 350, 130, 40);

        jButton8.setFont(new java.awt.Font("Verdana", 3, 18));
        jButton8.setText("Last");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8);
        jButton8.setBounds(400, 350, 90, 40);

        jButton9.setFont(new java.awt.Font("Verdana", 3, 18));
        jButton9.setText("Show");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton9);
        jButton9.setBounds(90, 390, 400, 40);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        boolean b = s.delete();
        if (b) {
            tot -= 1;
            cur -= 1;
            JOptionPane.showMessageDialog(this, "Record Deletion Successful.");
            if (cur == 0 && tot == 0) {
                jComboBox1.setSelectedIndex(-1);
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
            } else if (cur >= 1) {
                s = s.getRecord(cur);
                show(s);
                updateStatus();
            } else {
                cur = tot;
                s = s.getRecord(cur);
                show(s);
                updateStatus();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Record Deletion Failure.");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (cur == 1) {
            JOptionPane.showMessageDialog(this, "Already on First Record");
            return;
        } else {
            cur -= 1;
            s = s.getRecord(cur);
            show(s);
            updateStatus();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jComboBox1.setSelectedIndex(0);
        jButton4.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        s.setSubjectcode(jTextField1.getText());
        s.setSubjectname(jTextField2.getText());
        s.setSemester(Integer.parseInt(jTextField3.getText()));        
        s.setCourseid(jComboBox1.getSelectedIndex());
        boolean b = s.update();
        if (b) {
            JOptionPane.showMessageDialog(this, "Record Updation Successful.");
        } else {
            JOptionPane.showMessageDialog(this, "Record Updation Failure.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        s.setSubjectcode(jTextField1.getText());
        s.setSubjectname(jTextField2.getText());
        s.setSemester(Integer.parseInt(jTextField3.getText()));        
        s.setCourseid(jComboBox1.getSelectedIndex());
        boolean b = s.add();
        if (b) {
            tot += 1;
            cur = tot;
            s = s.getRecord(cur);
            show(s);
            updateStatus();
            jButton4.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Record Insertion Successful.");
        } else {
            JOptionPane.showMessageDialog(this, "Record Insertion Failure.");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (cur == 1) {
            JOptionPane.showMessageDialog(this, "Already on First Record");
            return;
        }
        if (tot >= 1) {
            s = s.getRecord(1);
            show(s);
            cur = 1;
            updateStatus();

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (cur == tot) {
            JOptionPane.showMessageDialog(this, "Already on Last Record");
            return;
        } else {
            cur += 1;
            s = s.getRecord(cur);
            show(s);
            updateStatus();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (cur == tot) {
            JOptionPane.showMessageDialog(this, "Already on Last Record");
            return;
        } else {
            s = s.getRecord(tot);
            show(s);
            cur = tot;
            updateStatus();
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
