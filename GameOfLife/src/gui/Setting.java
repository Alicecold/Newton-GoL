package gui;

import javax.swing.JOptionPane;
import gameoflife.*;
import java.io.IOException;

/**
 * @author Jacob ahlberg, Alice Darner, Viktor Aoun, Shaon Ahmed.
 */
public class Setting extends javax.swing.JDialog {
    
    public Setting(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    
    
    private void setGridSize(){
        String itemText = (String)comboBox.getSelectedItem();
        
        if (itemText.equals("50 x 25")){
            GUIGrid.setGridSize(50, 25);
        }
        if (itemText.equals("100 x 50")){
            GUIGrid.setGridSize(100, 50);
            
        }
        if (itemText.equals("200 x 100")){
            GUIGrid.setGridSize(200, 100);
            
        }
        
        GUIGrid.setShouldChangeSize(true);
    }
    
    private void forceGridSize(int x, int y){
        GUIGrid.setGridSize(x, y);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        comboBox = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        generateButon = new javax.swing.JButton();
        setRndCellsCheckBox = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        loadFromFileButton = new javax.swing.JButton();
        saveFromFileButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        okButton.setText("Ok");
        okButton.setPreferredSize(new java.awt.Dimension(111, 25));
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.setPreferredSize(new java.awt.Dimension(111, 25));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "50 x 25", "100 x 50", "200 x 100" }));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        generateButon.setText("Generate");
        generateButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateButonActionPerformed(evt);
            }
        });

        setRndCellsCheckBox.setText("Set random cells");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(setRndCellsCheckBox)
                    .addComponent(generateButon))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(setRndCellsCheckBox)
                .addGap(18, 18, 18)
                .addComponent(generateButon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Boardsize");

        loadFromFileButton.setText("Load from file");
        loadFromFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadFromFileButtonActionPerformed(evt);
            }
        });

        saveFromFileButton.setText("Save to file");
        saveFromFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFromFileButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(saveFromFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(loadFromFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveFromFileButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(loadFromFileButton)
                                .addGap(189, 189, 189))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        //Closes the setting frame.
        setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void loadFromFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadFromFileButtonActionPerformed
        try {
            Cell.setNumberOfAliveCells(0);
            GUIGrid.setBoard(Filehandler.loadFile());
            forceGridSize(GUIGrid.getBoard().getBoardSize(0), GUIGrid.getBoard().getBoardSize(1));
            if(GUIGrid.getBoard() != null){
                setVisible(false);
            }else{
                System.err.println("Something went wrong reading file");
            }
        } catch (IOException ex) {
            System.err.println("IOException when loading file! Shuting down...");
            System.exit(1);
        } catch (NullPointerException ex2){
            System.err.println("No file choosed");
        }
    }//GEN-LAST:event_loadFromFileButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        setGridSize();
        setVisible(false);
    }//GEN-LAST:event_okButtonActionPerformed

    private void generateButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateButonActionPerformed
        GUIGrid.setShouldGenerate(setRndCellsCheckBox.isSelected());
        if (setRndCellsCheckBox.isSelected()){
            setGridSize();
            setVisible(false);
        }
        else
            JOptionPane.showMessageDialog(null, "There's nothing to generate, sir.",
                                        "Information", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_generateButonActionPerformed

    private void saveFromFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFromFileButtonActionPerformed
        try {
            Filehandler.saveFile(GUIGrid.getBoard());
            setVisible(false);
        } catch (IOException ex) {
            System.err.println("IOException found!");
        }
    }//GEN-LAST:event_saveFromFileButtonActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Setting dialog = new Setting(new javax.swing.JFrame(), true);
                dialog.setTitle("Settings");
                dialog.setVisible(true);
            }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JButton generateButon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loadFromFileButton;
    private javax.swing.JButton okButton;
    private javax.swing.JButton saveFromFileButton;
    private javax.swing.JCheckBox setRndCellsCheckBox;
    // End of variables declaration//GEN-END:variables
}
