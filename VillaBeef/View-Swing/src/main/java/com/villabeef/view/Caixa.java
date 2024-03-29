/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.villabeef.view;

//Janela modelo para desenvolvimento das interfaces

import com.villabeef.common.CampoInvalidoException;
import com.villabeef.model.dto.ItemProduto;
import com.villabeef.model.dto.Produto;
import com.villabeef.model.service.ManterEstoque;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;


public class Caixa extends javax.swing.JFrame {
    
    private HashSet<ItemProduto> itens = new HashSet<>();
    
    DefaultTableModel modelo = null;
    
    /**
     * Creates new form Funcionarios1
     */
    public Caixa() {
        
        initComponents();
        scrollPane.getViewport().setBackground(new Color(245, 222, 179));
        scrollPane.getViewport().setBorder(null);

        tabela.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
        tabela.getTableHeader().setOpaque(false);
        tabela.getTableHeader().setBackground(new Color(76, 21, 32));
        tabela.getTableHeader().setForeground(new Color(245, 222, 179));
        tabela.setRowHeight(25);
        
        modelo = (DefaultTableModel) tabela.getModel();
        
        
    }
    
    private int mouseX, mouseY;
    
    
    
    private void atualizarTabela(HashSet<ItemProduto> lista) {
        DecimalFormat formato = new DecimalFormat("0.00");
        
        double total = 0.0;
        
        if (modelo != null) {
            modelo.getDataVector().removeAllElements();
            modelo.fireTableDataChanged();
        }
        
        try {
            for (ItemProduto item : lista) {
                Produto produto = ManterEstoque.obterProduto(item.getIdProduto());

                modelo.insertRow(modelo.getRowCount(), new Object[] {(produto.getTipo() + " " + produto.getMarca()), ("R$ " + formato.format(item.getValor()))});
                
                total += item.getValor();
                
                subtotalTxt.setText("R$ " + formato.format(total));
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro inesperado.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Falha na conexão com o banco de dados.", JOptionPane.ERROR_MESSAGE);
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

        background = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        nomeIcone = new javax.swing.JLabel();
        fecharButton = new javax.swing.JPanel();
        fecharTxt = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        identificacaoCampo = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        subtotal = new javax.swing.JLabel();
        adicionarButton = new javax.swing.JPanel();
        adicionarTxt = new javax.swing.JLabel();
        identificacao = new javax.swing.JLabel();
        quantidadeCampo = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        subtotalTxt = new javax.swing.JLabel();
        quantidade1 = new javax.swing.JLabel();
        finalizarButton = new javax.swing.JPanel();
        finalizarTxt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(870, 550));
        setMinimumSize(new java.awt.Dimension(870, 550));
        setUndecorated(true);
        setResizable(false);

        background.setBackground(new java.awt.Color(245, 222, 179));
        background.setMaximumSize(new java.awt.Dimension(870, 550));
        background.setMinimumSize(new java.awt.Dimension(870, 550));
        background.setPreferredSize(new java.awt.Dimension(870, 550));
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
        header.add(nomeIcone, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 5, 100, -1));

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

        tabela.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tabela.setForeground(new java.awt.Color(220, 184, 153));
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Preço"
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

        background.add(scrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 480, 380));

        jPanel1.setBackground(header.getBackground());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 60)); // NOI18N
        jLabel1.setForeground(background.getBackground());
        jLabel1.setText("CAIXA LIVRE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        background.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 870, -1));

        identificacaoCampo.setBackground(background.getBackground());
        identificacaoCampo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        identificacaoCampo.setForeground(java.awt.Color.gray);
        identificacaoCampo.setText("Especifique a identificação");
        identificacaoCampo.setToolTipText("");
        identificacaoCampo.setBorder(null);
        identificacaoCampo.setDisabledTextColor(java.awt.Color.gray);
        identificacaoCampo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                identificacaoCampoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                identificacaoCampoFocusLost(evt);
            }
        });
        identificacaoCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                identificacaoCampoActionPerformed(evt);
            }
        });
        identificacaoCampo.getDocument().addDocumentListener(new DocumentListener () {
            public void changedUpdate(DocumentEvent e) {
                aviso();
            }
            public void removeUpdate(DocumentEvent e) {
                aviso();
            }
            public void insertUpdate(DocumentEvent e) {
                aviso();
            }

            public void aviso() {
                String id = identificacaoCampo.getText();
                String quantidade = quantidadeCampo.getText();

                if(!id.equals("Especifique a identificacao") && !id.isBlank() && !quantidade.isBlank() && Integer.valueOf(quantidade) > 0) {
                    adicionarButton.setEnabled(true);
                    adicionarButton.setBackground(header.getBackground());
                    adicionarTxt.setEnabled(true);
                    adicionarTxt.setForeground(Color.white);
                    adicionarTxt.setCursor(new Cursor(Cursor.HAND_CURSOR));

                    return;
                }

                adicionarButton.setEnabled(false);
                adicionarButton.setBackground(new Color(59, 21, 32));
                adicionarTxt.setEnabled(false);
                adicionarTxt.setForeground(new Color(102, 102, 102));
                adicionarTxt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        background.add(identificacaoCampo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 320, 30));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        background.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, 320, 10));

        subtotal.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        subtotal.setForeground(header.getBackground());
        subtotal.setText("SUBTOTAL");
        background.add(subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 420, -1, -1));

        adicionarButton.setBackground(header.getBackground());
        adicionarButton.setEnabled(false);

        adicionarTxt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        adicionarTxt.setForeground(new java.awt.Color(255, 255, 255));
        adicionarTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adicionarTxt.setText("ADICIONAR");
        adicionarTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        adicionarTxt.setEnabled(false);
        adicionarTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adicionarTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                adicionarTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                adicionarTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout adicionarButtonLayout = new javax.swing.GroupLayout(adicionarButton);
        adicionarButton.setLayout(adicionarButtonLayout);
        adicionarButtonLayout.setHorizontalGroup(
            adicionarButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(adicionarTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        adicionarButtonLayout.setVerticalGroup(
            adicionarButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(adicionarTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        background.add(adicionarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 290, 160, 40));

        identificacao.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        identificacao.setForeground(header.getBackground());
        identificacao.setText("IDENTIFICAÇÃO DO PRODUTO");
        background.add(identificacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, -1, -1));

        quantidadeCampo.setBackground(background.getBackground());
        quantidadeCampo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        quantidadeCampo.setForeground(java.awt.Color.gray);
        quantidadeCampo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        quantidadeCampo.setText("0");
        quantidadeCampo.setToolTipText("");
        quantidadeCampo.setBorder(null);
        quantidadeCampo.setDisabledTextColor(java.awt.Color.gray);
        quantidadeCampo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                quantidadeCampoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                quantidadeCampoFocusLost(evt);
            }
        });
        quantidadeCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantidadeCampoActionPerformed(evt);
            }
        });
        quantidadeCampo.getDocument().addDocumentListener(new DocumentListener () {
            public void changedUpdate(DocumentEvent e) {
                aviso();
            }
            public void removeUpdate(DocumentEvent e) {
                aviso();
            }
            public void insertUpdate(DocumentEvent e) {
                aviso();
            }

            public void aviso() {
                String id = identificacaoCampo.getText();
                String quantidade = quantidadeCampo.getText();

                if(!id.equals("Especifique a identificacao") && !id.isBlank() && !quantidade.isBlank() && Integer.valueOf(quantidade) > 0) {
                    adicionarButton.setEnabled(true);
                    adicionarButton.setBackground(header.getBackground());
                    adicionarTxt.setEnabled(true);
                    adicionarTxt.setForeground(Color.white);
                    adicionarTxt.setCursor(new Cursor(Cursor.HAND_CURSOR));

                    return;
                }

                adicionarButton.setEnabled(false);
                adicionarButton.setBackground(new Color(59, 21, 32));
                adicionarTxt.setEnabled(false);
                adicionarTxt.setForeground(new Color(102, 102, 102));
                adicionarTxt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        background.add(quantidadeCampo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, 100, 30));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        background.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, 100, 10));

        jPanel2.setBackground(header.getBackground());

        subtotalTxt.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        subtotalTxt.setForeground(background.getBackground());
        subtotalTxt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        subtotalTxt.setText("R$ 0,00");
        subtotalTxt.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(subtotalTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(subtotalTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        background.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 450, 320, -1));

        quantidade1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        quantidade1.setForeground(header.getBackground());
        quantidade1.setText("QUANTIDADE");
        background.add(quantidade1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, -1, -1));

        finalizarButton.setBackground(header.getBackground());

        finalizarTxt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        finalizarTxt.setForeground(new java.awt.Color(255, 255, 255));
        finalizarTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        finalizarTxt.setText("FINALIZAR");
        finalizarTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        finalizarTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                finalizarTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                finalizarTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                finalizarTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout finalizarButtonLayout = new javax.swing.GroupLayout(finalizarButton);
        finalizarButton.setLayout(finalizarButtonLayout);
        finalizarButtonLayout.setHorizontalGroup(
            finalizarButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(finalizarTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        finalizarButtonLayout.setVerticalGroup(
            finalizarButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(finalizarTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        background.add(finalizarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, 320, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fecharTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fecharTxtMouseClicked
        setVisible(false);
        dispose();
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

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        
    }//GEN-LAST:event_tabelaMouseClicked

    private void identificacaoCampoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_identificacaoCampoFocusGained
        if (identificacaoCampo.getText().equals("Especifique a identificação")) {
            identificacaoCampo.setText("");
            identificacaoCampo.setForeground(Color.black);
        }
    }//GEN-LAST:event_identificacaoCampoFocusGained

    private void identificacaoCampoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_identificacaoCampoFocusLost
        if (identificacaoCampo.getText().isBlank()) {
            identificacaoCampo.setText("Especifique a identificação");
            identificacaoCampo.setForeground(Color.gray);
        }
    }//GEN-LAST:event_identificacaoCampoFocusLost

    private void identificacaoCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_identificacaoCampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_identificacaoCampoActionPerformed

    private void adicionarTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adicionarTxtMouseClicked
        try {
            if(itens.size() > 0) {
                Produto produto = ManterEstoque.obterProduto(identificacaoCampo.getText());
                
                for(ItemProduto i : itens) {
                    if(ManterEstoque.obterProduto(i.getIdProduto()).getId().equals(produto.getId())) {
                        JOptionPane.showMessageDialog(rootPane, "Já existem itens deste produto adicionados. Por questões de conflitos, não será possível adicionar outro item deste produto", "Impedimento", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                }
            }
            
            itens.addAll(ManterEstoque.adicionarCompra(identificacaoCampo.getText(), Integer.valueOf(quantidadeCampo.getText())));
            atualizarTabela(itens);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro inesperado", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Falha na conexão com o banco de dados", JOptionPane.ERROR_MESSAGE);
        } catch (CampoInvalidoException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Campo inválido", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_adicionarTxtMouseClicked

    private void adicionarTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adicionarTxtMouseEntered
        if (adicionarButton.isEnabled())
            adicionarButton.setBackground(new Color(119, 34, 51));
    }//GEN-LAST:event_adicionarTxtMouseEntered

    private void adicionarTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adicionarTxtMouseExited
        if (adicionarButton.isEnabled())
        adicionarButton.setBackground(header.getBackground());
    }//GEN-LAST:event_adicionarTxtMouseExited

    private void quantidadeCampoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quantidadeCampoFocusGained
        if (quantidadeCampo.getText().equals("0")) {
            quantidadeCampo.setText("");
            quantidadeCampo.setForeground(Color.black);
        }
    }//GEN-LAST:event_quantidadeCampoFocusGained

    private void quantidadeCampoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quantidadeCampoFocusLost
        if (quantidadeCampo.getText().isBlank() || identificacaoCampo.getText().equals("0")) {
            quantidadeCampo.setText("0");
            quantidadeCampo.setForeground(Color.gray);
        }
    }//GEN-LAST:event_quantidadeCampoFocusLost

    private void quantidadeCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantidadeCampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantidadeCampoActionPerformed

    private void finalizarTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finalizarTxtMouseClicked
        try {
            boolean resultado = ManterEstoque.finalizarCompra(itens, Double.parseDouble(subtotalTxt.getText().replace("R$ ", "").replace(',', '.')));
            
            if(resultado) {
                itens = new HashSet<>();
                atualizarTabela(itens);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro inesperado", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro inesperado", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Falha na conexão com o banco de dados", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro inesperado", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_finalizarTxtMouseClicked

    private void finalizarTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finalizarTxtMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_finalizarTxtMouseEntered

    private void finalizarTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finalizarTxtMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_finalizarTxtMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel adicionarButton;
    private javax.swing.JLabel adicionarTxt;
    private javax.swing.JPanel background;
    private javax.swing.JPanel fecharButton;
    private javax.swing.JLabel fecharTxt;
    private javax.swing.JPanel finalizarButton;
    private javax.swing.JLabel finalizarTxt;
    private javax.swing.JPanel header;
    private javax.swing.JLabel identificacao;
    private javax.swing.JTextField identificacaoCampo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel nomeIcone;
    private javax.swing.JLabel quantidade1;
    private javax.swing.JTextField quantidadeCampo;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JLabel subtotal;
    private javax.swing.JLabel subtotalTxt;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
