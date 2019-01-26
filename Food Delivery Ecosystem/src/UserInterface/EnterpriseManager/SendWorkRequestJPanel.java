/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.EnterpriseManager;

import Business.Network.Network;
import Business.Enterprise.Enterprise;
import Business.Food.Food;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.Workqueue.DeliverWorkRequest;
import Business.Workqueue.WorkRequest;
import java.awt.CardLayout;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 帅的一匹
 * When we come up with some good ideas or want to build a system with complicated funtions,
 * we should design the whole model
 * and make the work flow logical first, then do the code,
 * I think this is the correct way to do software engineering.
 */
public class SendWorkRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SendWorkRequestJPanel
     */
    private Network city;
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    
    public SendWorkRequestJPanel(JPanel userProcessContainer, Enterprise enterprise,Network city) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.city = city;
        lblValue.setText(enterprise.getName());
        popTable();
        popCom();
    }
    public void popUserCom(Organization organization){
        cbUserAccount.removeAllItems();
        for(UserAccount ua:organization.getUserAccountDirectory().getUserAccountList()){
            cbUserAccount.addItem(ua);
        }
    }
    
    public void popCom(){
        cbSend.removeAllItems();
        if(this.enterprise.getEnterpriseType() == Enterprise.EnterpriseType.Donation){
            for(Enterprise s:city.getEnterpriseDir().getEnterpriseList()){
                if(s.getEnterpriseType() == Enterprise.EnterpriseType.Deliever)
                    cbSend.addItem(s);
            }
        }
    }
    public void popTable(){
        DefaultTableModel dtm = (DefaultTableModel)tblWork.getModel();
        dtm.setRowCount(0);
        for(Food f:this.city.getFoodDir().getFoodlist()){
            Object[] row = new Object[3];
            row[0]=f.getFoodId();
            row[1]=f;
            row[2]=f.getExpirationDate();
            dtm.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAdmin = new javax.swing.JLabel();
        lblEnterprise = new javax.swing.JLabel();
        lblValue = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblWork = new javax.swing.JTable();
        cbSend = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        subBtn = new javax.swing.JButton();
        cbUserAccount = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbSendOrg = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(0, 153, 153));

        lblAdmin.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblAdmin.setText("My Work Area -Manager Role");

        lblEnterprise.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblEnterprise.setText("Enterprise: ");

        lblValue.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblValue.setText("<Value>");

        tblWork.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tblWork.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Foodid", "Foodname", "expirationTime"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblWork);
        if (tblWork.getColumnModel().getColumnCount() > 0) {
            tblWork.getColumnModel().getColumn(0).setResizable(false);
            tblWork.getColumnModel().getColumn(1).setResizable(false);
            tblWork.getColumnModel().getColumn(2).setResizable(false);
        }

        cbSend.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        cbSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSendActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton1.setText("<<Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        subBtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        subBtn.setText("Submit");
        subBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subBtnActionPerformed(evt);
            }
        });

        cbUserAccount.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Select Enterprise:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Select UserAccount:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Select Organization:");

        cbSendOrg.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        cbSendOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSendOrgActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(lblEnterprise)
                        .addGap(80, 80, 80)
                        .addComponent(lblValue))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                                .addGap(8, 8, 8)
                                                .addComponent(cbSendOrg, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(8, 8, 8)
                                                .addComponent(cbSend, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel2)))
                                .addGap(4, 4, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbUserAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(subBtn)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(lblAdmin)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAdmin)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEnterprise)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblValue)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cbUserAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSendOrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(subBtn))
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void subBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subBtnActionPerformed
        // TODO add your handling code here:
        if(this.enterprise.getEnterpriseType() == Enterprise.EnterpriseType.Donation){
            DeliverWorkRequest wr = new DeliverWorkRequest();
            wr.setStatus("Undelivered");
            wr.setfLocation(enterprise.toString());
            wr.settLocation(cbSend.getSelectedItem().toString());
            wr.setReceiver((UserAccount)cbUserAccount.getSelectedItem());
            int r = tblWork.getSelectedRow();
            if(r>=0){
            Food f = (Food)tblWork.getValueAt(r,1);
            wr.setFood(f);
            wr.setSender(f.getDonor());
            this.city.getWorkqueue().getWorkRequestList().add(wr);
            JOptionPane.showMessageDialog(null, "The work request has been sent to "+ (UserAccount)cbUserAccount.getSelectedItem()+" !");
            }else{
                JOptionPane.showMessageDialog(null, "Please Select one row!");
            }
        }
        
    }//GEN-LAST:event_subBtnActionPerformed

    private void cbSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSendActionPerformed
        // TODO add your handling code here:
        Enterprise e = (Enterprise) cbSend.getSelectedItem();
        if(e!=null){
            popOrgCom(e);
        }
    }//GEN-LAST:event_cbSendActionPerformed

    public void popOrgCom(Enterprise e){
        cbSendOrg.removeAllItems();
        for(Organization o:e.getOrganizationDirectory().getOrganizationList()){
            cbSendOrg.addItem(o);
        }
    }
    private void cbSendOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSendOrgActionPerformed
        // TODO add your handling code here:
        Organization o = (Organization) cbSendOrg.getSelectedItem();
        if(o!=null){
            popUserCom(o);
        }
    }//GEN-LAST:event_cbSendOrgActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbSend;
    private javax.swing.JComboBox cbSendOrg;
    private javax.swing.JComboBox cbUserAccount;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JLabel lblEnterprise;
    private javax.swing.JLabel lblValue;
    private javax.swing.JButton subBtn;
    private javax.swing.JTable tblWork;
    // End of variables declaration//GEN-END:variables
}
