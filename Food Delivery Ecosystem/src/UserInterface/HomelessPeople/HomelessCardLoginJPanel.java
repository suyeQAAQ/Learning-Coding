/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.HomelessPeople;

import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Refrigerator.refrigerator;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Astha Sharma
 */
public class HomelessCardLoginJPanel extends javax.swing.JPanel {

    /**
     * Creates new form HomelessCardLoginJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount useraccount;
    private Organization homelessOrg;
    private Enterprise enterprise;
    private Network city;
    public HomelessCardLoginJPanel(JPanel userProcessContainer,UserAccount useraccount,Organization homelessOrg,Enterprise enterprise,Network city) {
        initComponents();
        this.city = city;
        this.enterprise = enterprise;
        this.homelessOrg = homelessOrg;
        this.enterprise = enterprise;
        this.userProcessContainer = userProcessContainer;
        this.useraccount = useraccount;
        this.cityLbl.setText(this.city.getName());
        popCom();
    }
    
    public void popCom(){
        cbAddress.removeAllItems();
        for(refrigerator r:this.city.getRefriDir().getRefrilist()){
            cbAddress.addItem(r);
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

        jLabel2 = new javax.swing.JLabel();
        cbAddress = new javax.swing.JComboBox();
        insertCard = new javax.swing.JButton();
        cityLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 153));

        jLabel2.setText("City:");

        cbAddress.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        cbAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAddressActionPerformed(evt);
            }
        });

        insertCard.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        insertCard.setText("Insert Card!");
        insertCard.setEnabled(false);
        insertCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertCardActionPerformed(evt);
            }
        });

        cityLbl.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        cityLbl.setText("<value>");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Please select refrigerator in your city:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cityLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(insertCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbAddress, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(180, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cityLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(insertCard, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAddressActionPerformed
        // TODO add your handling code here:
        refrigerator r = (refrigerator)this.cbAddress.getSelectedItem();
        if(r!=null){
            insertCard.setEnabled(true);
        }
    }//GEN-LAST:event_cbAddressActionPerformed

    private void insertCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertCardActionPerformed
        // TODO add your handling code here:
        refrigerator r = (refrigerator)this.cbAddress.getSelectedItem();
        HomelessPersonalUIJPanel h = new HomelessPersonalUIJPanel(userProcessContainer,useraccount,homelessOrg,enterprise,city,r);
        userProcessContainer.add(h);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_insertCardActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbAddress;
    private javax.swing.JLabel cityLbl;
    private javax.swing.JButton insertCard;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
