/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.villabeef.view;

//Janela modelo para desenvolvimento das interfaces

import com.villabeef.model.dto.Imposto;
import com.villabeef.model.service.ManterRentabilidade;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;


public class Impostos extends javax.swing.JDialog {
    
    /**
     * A return status code - returned if Cancel button has been pressed
     */
    public static final int RET_CANCEL = 0;
    /**
     * A return status code - returned if OK button has been pressed
     */
    public static final int RET_OK = 1;
    
    
    DefaultTableModel modelo = null;
    
    /**
     * Creates new form Funcionarios1
     */
    public Impostos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        scrollPane.getViewport().setBackground(new Color(245, 222, 179));
        scrollPane.getViewport().setBorder(null);

        tabela.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
        tabela.getTableHeader().setOpaque(false);
        tabela.getTableHeader().setBackground(new Color(76, 21, 32));
        tabela.getTableHeader().setForeground(new Color(245, 222, 179));
        tabela.setRowHeight(25);
        
        modelo = (DefaultTableModel) tabela.getModel();

        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
        
        try {
            atualizarTabela(ManterRentabilidade.listarImpostos());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro inesperado.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Falha na conexão com o banco de dados.", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void atualizarTabela(HashSet<Imposto> lista) {
        DecimalFormat formato = new DecimalFormat("0.00");
        
        if (modelo != null) {
            modelo.getDataVector().removeAllElements();
            modelo.fireTableDataChanged();
        }

        for (Imposto i : lista) {
            modelo.insertRow(modelo.getRowCount(), new Object[] {i.getDescricao(), 
            i.getValor()});
        }
    }
    
    private int mouseX, mouseY;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        nomeIcone = new javax.swing.JLabel();
        fecharButton = new javax.swing.JPanel();
        fecharTxt = new javax.swing.JLabel();
        valor = new javax.swing.JLabel();
        valorCampo = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        descricao = new javax.swing.JLabel();
        descricaoCampo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        inserirButton = new javax.swing.JPanel();
        inserirTxt = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(780, 385));
        setMinimumSize(new java.awt.Dimension(780, 385));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(780, 385));
        setResizable(false);

        background.setBackground(new java.awt.Color(245, 222, 179));
        background.setMaximumSize(new java.awt.Dimension(780, 385));
        background.setMinimumSize(new java.awt.Dimension(780, 385));
        background.setPreferredSize(new java.awt.Dimension(780, 385));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(76, 21, 32));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nomeIcone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VILLAsmall.png"))); // NOI18N
        nomeIcone.setText("jLabel2");
        header.add(nomeIcone, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 5, 100, -1));

        fecharButton.setBackground(header.getBackground());

        fecharTxt.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        fecharTxt.setForeground(background.getBackground());
        fecharTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fecharTxt.setText("X");
        fecharTxt.setMaximumSize(new java.awt.Dimension(40, 40));
        fecharTxt.setMinimumSize(new java.awt.Dimension(40, 40));
        fecharTxt.setPreferredSize(new java.awt.Dimension(40, 40));
        fecharTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fecharTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fecharTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fecharTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout fecharButtonLayout = new javax.swing.GroupLayout(fecharButton);
        fecharButton.setLayout(fecharButtonLayout);
        fecharButtonLayout.setHorizontalGroup(
            fecharButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fecharButtonLayout.createSequentialGroup()
                .addComponent(fecharTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        fecharButtonLayout.setVerticalGroup(
            fecharButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fecharButtonLayout.createSequentialGroup()
                .addComponent(fecharTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        header.add(fecharButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        background.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 40));

        valor.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        valor.setForeground(header.getBackground());
        valor.setText("VALOR");
        background.add(valor, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, -1, -1));

        valorCampo.setBackground(background.getBackground());
        valorCampo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        valorCampo.setForeground(java.awt.Color.gray);
        valorCampo.setText("Insira as informações");
        valorCampo.setToolTipText("");
        valorCampo.setBorder(null);
        valorCampo.setDisabledTextColor(java.awt.Color.gray);
        valorCampo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                valorCampoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                valorCampoFocusLost(evt);
            }
        });
        valorCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorCampoActionPerformed(evt);
            }
        });
        background.add(valorCampo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 320, 30));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        background.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 320, 10));

        descricao.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        descricao.setForeground(header.getBackground());
        descricao.setText("DESCRIÇÃO");
        background.add(descricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, -1, -1));

        descricaoCampo.setBackground(background.getBackground());
        descricaoCampo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        descricaoCampo.setForeground(java.awt.Color.gray);
        descricaoCampo.setText("Insira as informações");
        descricaoCampo.setToolTipText("");
        descricaoCampo.setBorder(null);
        descricaoCampo.setDisabledTextColor(java.awt.Color.gray);
        descricaoCampo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                descricaoCampoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                descricaoCampoFocusLost(evt);
            }
        });
        descricaoCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descricaoCampoActionPerformed(evt);
            }
        });
        background.add(descricaoCampo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 320, 30));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        background.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 320, 10));

        inserirButton.setBackground(header.getBackground());

        inserirTxt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        inserirTxt.setForeground(new java.awt.Color(255, 255, 255));
        inserirTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inserirTxt.setText("CADASTRAR");
        inserirTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inserirTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inserirTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inserirTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                inserirTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout inserirButtonLayout = new javax.swing.GroupLayout(inserirButton);
        inserirButton.setLayout(inserirButtonLayout);
        inserirButtonLayout.setHorizontalGroup(
            inserirButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inserirTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        inserirButtonLayout.setVerticalGroup(
            inserirButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inserirTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        background.add(inserirButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, 140, 40));

        tabela.setBackground(header.getBackground());
        tabela.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tabela.setForeground(new java.awt.Color(220, 184, 153));
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Valor"
            }
        ));
        tabela.setGridColor(new java.awt.Color(204, 204, 204));
        tabela.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabela.setRowHeight(25);
        tabela.setSelectionBackground(new java.awt.Color(119, 34, 51));
        tabela.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tabela.setShowGrid(true);
        tabela.setShowVerticalLines(false);
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        scrollPane.setViewportView(tabela);

        background.add(scrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 390, 300));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fecharTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fecharTxtMouseClicked
        doClose(RET_CANCEL);
    }//GEN-LAST:event_fecharTxtMouseClicked

    private void fecharTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fecharTxtMouseEntered
        fecharButton.setBackground(background.getBackground());
        fecharTxt.setForeground(header.getBackground());
    }//GEN-LAST:event_fecharTxtMouseEntered

    private void fecharTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fecharTxtMouseExited
        fecharButton.setBackground(header.getBackground());
        fecharTxt.setForeground(background.getBackground());
    }//GEN-LAST:event_fecharTxtMouseExited

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        setLocation(x - mouseX, y - mouseY);
    }//GEN-LAST:event_headerMouseDragged

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void valorCampoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorCampoFocusGained
        if(valorCampo.getText().equals("Insira as informações")) {
            valorCampo.setText("");
            valorCampo.setForeground(Color.black);
        }
    }//GEN-LAST:event_valorCampoFocusGained

    private void valorCampoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorCampoFocusLost
        if(valorCampo.getText().isBlank()) {
            valorCampo.setText("Insira as informações");
            valorCampo.setForeground(Color.gray);
        }
    }//GEN-LAST:event_valorCampoFocusLost

    private void descricaoCampoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_descricaoCampoFocusGained
        if(descricaoCampo.getText().equals("Insira as informações")) {
            descricaoCampo.setText("");
            descricaoCampo.setForeground(Color.black);
        }
    }//GEN-LAST:event_descricaoCampoFocusGained

    private void descricaoCampoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_descricaoCampoFocusLost
        if(descricaoCampo.getText().isBlank()) {
            descricaoCampo.setText("Insira as informações");
            descricaoCampo.setForeground(Color.gray);
        }
    }//GEN-LAST:event_descricaoCampoFocusLost

    private void inserirTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inserirTxtMouseClicked
        String descricao = descricaoCampo.getText();
        double valor = Double.parseDouble(valorCampo.getText().replace(',', '.'));
        
        try {
            ManterRentabilidade.inserirImposto(descricao, valor);
            atualizarTabela(ManterRentabilidade.listarImpostos());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro inesperado.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Falha na conexão com o banco de dados.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_inserirTxtMouseClicked

    private void valorCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorCampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorCampoActionPerformed

    private void inserirTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inserirTxtMouseEntered
        inserirButton.setBackground(new Color(119, 34, 51));
    }//GEN-LAST:event_inserirTxtMouseEntered

    private void inserirTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inserirTxtMouseExited
        inserirButton.setBackground(header.getBackground());
    }//GEN-LAST:event_inserirTxtMouseExited

    private void descricaoCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descricaoCampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descricaoCampoActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        
    }//GEN-LAST:event_tabelaMouseClicked
    
    
    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }
    
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
            java.util.logging.Logger.getLogger(Impostos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Impostos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Impostos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Impostos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Impostos dialog = new Impostos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JLabel descricao;
    private javax.swing.JTextField descricaoCampo;
    private javax.swing.JPanel fecharButton;
    private javax.swing.JLabel fecharTxt;
    private javax.swing.JPanel header;
    private javax.swing.JPanel inserirButton;
    private javax.swing.JLabel inserirTxt;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel nomeIcone;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tabela;
    private javax.swing.JLabel valor;
    private javax.swing.JTextField valorCampo;
    // End of variables declaration//GEN-END:variables

    private int returnStatus = RET_CANCEL;
}
