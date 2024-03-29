/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.villabeef.view;

//Janela modelo para desenvolvimento das interfaces
import com.villabeef.model.dto.Conta;
import com.villabeef.model.dto.ItemProduto;
import com.villabeef.model.dto.Produto;
import com.villabeef.model.service.ManterEstoque;
import com.villabeef.model.service.ManterRentabilidade;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class Rentabilidade extends javax.swing.JFrame {

    DefaultTableModel modelo = null;

    /**
     * Creates new form Funcionarios1
     */
    public Rentabilidade() {
        initComponents();

        scrollPane.getViewport().setBackground(new Color(245, 222, 179));
        scrollPane.getViewport().setBorder(null);

        tabela.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
        tabela.getTableHeader().setOpaque(false);
        tabela.getTableHeader().setBackground(new Color(76, 21, 32));
        tabela.getTableHeader().setForeground(new Color(245, 222, 179));
        tabela.setRowHeight(25);

        modelo = (DefaultTableModel) tabela.getModel();
        
        DecimalFormat formato = new DecimalFormat("0.00");
        
        try {
            atualizarTabela(ManterRentabilidade.listar());
            saldoTxt.setText("R$ " + formato.format(ManterRentabilidade.obterSaldo()));
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro inesperado.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Falha na conexão com o banco de dados.", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro inesperado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizarTabela(LinkedHashSet<Conta> lista) {
        DecimalFormat formato = new DecimalFormat("0.00");
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

        Conta array[] = new Conta[lista.size()];
        array = lista.toArray(array);

        if (modelo != null) {
            modelo.getDataVector().removeAllElements();
            modelo.fireTableDataChanged();
        }

        for (int i = lista.size() - 1; i > -1; i--) {
            Conta conta = array[i];

            modelo.insertRow(modelo.getRowCount(), new Object[]{formatoData.format(conta.getData()),
                (conta.getTipo() == 'e' ? "Entrada" : "Saída"), conta.getDescricao(), "R$ " + formato.format(conta.getValor())});
        }
    }

    private boolean validarData(String data) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        formato.setLenient(false);

        try {
            formato.parse(data);
        } catch (ParseException ex) {
            return false;
        }

        return true;
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
        scrollPane = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        saldoTxt = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        fimCampo = new javax.swing.JTextField();
        inicioCampo = new javax.swing.JTextField();
        filtrarButton = new javax.swing.JPanel();
        filtrarTxt = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        compraButton = new javax.swing.JPanel();
        compraTxt = new javax.swing.JLabel();
        impostoButton = new javax.swing.JPanel();
        impostoTxt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(670, 671));
        setMinimumSize(new java.awt.Dimension(670, 671));
        setUndecorated(true);
        setResizable(false);

        background.setBackground(new java.awt.Color(245, 222, 179));
        background.setMaximumSize(new java.awt.Dimension(670, 671));
        background.setMinimumSize(new java.awt.Dimension(670, 671));
        background.setPreferredSize(new java.awt.Dimension(670, 671));
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
        header.add(nomeIcone, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 5, 100, -1));

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

        tabela.setBackground(header.getBackground());
        tabela.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tabela.setForeground(new java.awt.Color(220, 184, 153));
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Tipo", "Descrição", "Valor"
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

        background.add(scrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 480, 450));

        saldoTxt.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        saldoTxt.setForeground(new java.awt.Color(255, 255, 255));
        saldoTxt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        saldoTxt.setText("R$ 0,00");
        background.add(saldoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 590, 470, 70));

        jPanel1.setBackground(header.getBackground());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        background.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 590, 480, 70));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(header.getBackground());
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("a");
        background.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 20, 20));

        fimCampo.setBackground(background.getBackground());
        fimCampo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        fimCampo.setForeground(java.awt.Color.gray);
        fimCampo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fimCampo.setText("dd/mm/aaaa");
        fimCampo.setBorder(null);
        fimCampo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fimCampoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fimCampoFocusLost(evt);
            }
        });
        fimCampo.getDocument().addDocumentListener(new DocumentListener () {
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
                String inicio = inicioCampo.getText();
                String fim = fimCampo.getText();

                if(validarData(inicio) && validarData(fim) && inicio.length() == 10 && fim.length() == 10) {
                    filtrarButton.setEnabled(true);
                    filtrarButton.setBackground(header.getBackground());
                    filtrarTxt.setEnabled(true);
                    filtrarTxt.setForeground(Color.white);
                    filtrarTxt.setCursor(new Cursor(Cursor.HAND_CURSOR));

                    return;
                }

                filtrarButton.setEnabled(false);
                filtrarButton.setBackground(new Color(59, 21, 32));
                filtrarTxt.setEnabled(false);
                filtrarTxt.setForeground(new Color(102, 102, 102));
                filtrarTxt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        background.add(fimCampo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 110, 20));

        inicioCampo.setBackground(background.getBackground());
        inicioCampo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        inicioCampo.setForeground(java.awt.Color.gray);
        inicioCampo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        inicioCampo.setText("dd/mm/aaaa");
        inicioCampo.setBorder(null);
        inicioCampo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inicioCampoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inicioCampoFocusLost(evt);
            }
        });
        inicioCampo.getDocument().addDocumentListener(new DocumentListener () {
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
                String inicio = inicioCampo.getText();
                String fim = fimCampo.getText();

                if(validarData(inicio) && validarData(fim) && inicio.length() == 10 && fim.length() == 10) {
                    filtrarButton.setEnabled(true);
                    filtrarButton.setBackground(header.getBackground());
                    filtrarTxt.setEnabled(true);
                    filtrarTxt.setForeground(Color.white);
                    filtrarTxt.setCursor(new Cursor(Cursor.HAND_CURSOR));

                    return;
                }

                filtrarButton.setEnabled(false);
                filtrarButton.setBackground(new Color(59, 21, 32));
                filtrarTxt.setEnabled(false);
                filtrarTxt.setForeground(new Color(102, 102, 102));
                filtrarTxt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        background.add(inicioCampo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 110, 20));

        filtrarButton.setBackground(new java.awt.Color(59, 21, 32));
        filtrarButton.setEnabled(false);

        filtrarTxt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        filtrarTxt.setForeground(new java.awt.Color(102, 102, 102));
        filtrarTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        filtrarTxt.setText("FILTRAR");
        filtrarTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        filtrarTxt.setEnabled(false);
        filtrarTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filtrarTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                filtrarTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                filtrarTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout filtrarButtonLayout = new javax.swing.GroupLayout(filtrarButton);
        filtrarButton.setLayout(filtrarButtonLayout);
        filtrarButtonLayout.setHorizontalGroup(
            filtrarButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(filtrarTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        filtrarButtonLayout.setVerticalGroup(
            filtrarButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(filtrarTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        background.add(filtrarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 100, 40));
        background.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 110, 10));
        background.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 110, 10));

        compraButton.setBackground(header.getBackground());

        compraTxt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        compraTxt.setForeground(new java.awt.Color(255, 255, 255));
        compraTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        compraTxt.setText("REGISTRAR COMPRA");
        compraTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        compraTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                compraTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                compraTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                compraTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout compraButtonLayout = new javax.swing.GroupLayout(compraButton);
        compraButton.setLayout(compraButtonLayout);
        compraButtonLayout.setHorizontalGroup(
            compraButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(compraTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        compraButtonLayout.setVerticalGroup(
            compraButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(compraTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        background.add(compraButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 160, 30));

        impostoButton.setBackground(header.getBackground());

        impostoTxt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        impostoTxt.setForeground(new java.awt.Color(255, 255, 255));
        impostoTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        impostoTxt.setText("IMPOSTOS");
        impostoTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        impostoTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                impostoTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                impostoTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                impostoTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout impostoButtonLayout = new javax.swing.GroupLayout(impostoButton);
        impostoButton.setLayout(impostoButtonLayout);
        impostoButtonLayout.setHorizontalGroup(
            impostoButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(impostoTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        impostoButtonLayout.setVerticalGroup(
            impostoButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(impostoTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        background.add(impostoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 160, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void filtrarTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filtrarTxtMouseClicked
        DecimalFormat formato = new DecimalFormat("0.00");
        
        try {
            atualizarTabela(ManterRentabilidade.listar(inicioCampo.getText(), fimCampo.getText()));
            saldoTxt.setText("R$ " + formato.format(ManterRentabilidade.obterSaldo()));
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro inesperado.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Falha na conexão com o banco de dados.", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro inesperado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_filtrarTxtMouseClicked

    private void filtrarTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filtrarTxtMouseEntered
        if (filtrarButton.isEnabled())
            filtrarButton.setBackground(new Color(119, 34, 51));
    }//GEN-LAST:event_filtrarTxtMouseEntered

    private void filtrarTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filtrarTxtMouseExited
        if (filtrarButton.isEnabled())
            filtrarButton.setBackground(header.getBackground());
    }//GEN-LAST:event_filtrarTxtMouseExited

    private void inicioCampoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inicioCampoFocusGained
        if (inicioCampo.getText().equals("dd/mm/aaaa")) {
            inicioCampo.setText("");
            inicioCampo.setForeground(Color.black);
        }
    }//GEN-LAST:event_inicioCampoFocusGained

    private void inicioCampoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inicioCampoFocusLost
        if (inicioCampo.getText().isBlank()) {
            inicioCampo.setText("dd/mm/aaaa");
            inicioCampo.setForeground(Color.gray);
        }
    }//GEN-LAST:event_inicioCampoFocusLost

    private void fimCampoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fimCampoFocusGained
        if (fimCampo.getText().equals("dd/mm/aaaa")) {
            fimCampo.setText("");
            fimCampo.setForeground(Color.black);
        }
    }//GEN-LAST:event_fimCampoFocusGained

    private void fimCampoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fimCampoFocusLost
        if (fimCampo.getText().isBlank()) {
            fimCampo.setText("dd/mm/aaaa");
            fimCampo.setForeground(Color.gray);
        }
    }//GEN-LAST:event_fimCampoFocusLost

    private void compraTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_compraTxtMouseClicked
        RegistroCompra r = new RegistroCompra(this, true);
        
        r.setVisible(true);
        r.setLocationRelativeTo(null);
        
        try {
            atualizarTabela(ManterRentabilidade.listar());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro inesperado.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Falha na conexão com o banco de dados.", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_compraTxtMouseClicked

    private void compraTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_compraTxtMouseEntered
        if (compraButton.isEnabled())
            compraButton.setBackground(new Color(119, 34, 51));
    }//GEN-LAST:event_compraTxtMouseEntered

    private void compraTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_compraTxtMouseExited
        if (compraButton.isEnabled())
            compraButton.setBackground(header.getBackground());
    }//GEN-LAST:event_compraTxtMouseExited

    private void impostoTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_impostoTxtMouseClicked
        Impostos i = new Impostos(this, true);
        i.setVisible(true);
        i.setLocationRelativeTo(null);
    }//GEN-LAST:event_impostoTxtMouseClicked

    private void impostoTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_impostoTxtMouseEntered
        if (impostoButton.isEnabled())
            impostoButton.setBackground(new Color(119, 34, 51));
    }//GEN-LAST:event_impostoTxtMouseEntered

    private void impostoTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_impostoTxtMouseExited
        if (impostoButton.isEnabled())
            impostoButton.setBackground(header.getBackground());
    }//GEN-LAST:event_impostoTxtMouseExited

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
            java.util.logging.Logger.getLogger(Rentabilidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rentabilidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rentabilidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rentabilidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rentabilidade().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel compraButton;
    private javax.swing.JLabel compraTxt;
    private javax.swing.JPanel fecharButton;
    private javax.swing.JLabel fecharTxt;
    private javax.swing.JPanel filtrarButton;
    private javax.swing.JLabel filtrarTxt;
    private javax.swing.JTextField fimCampo;
    private javax.swing.JPanel header;
    private javax.swing.JPanel impostoButton;
    private javax.swing.JLabel impostoTxt;
    private javax.swing.JTextField inicioCampo;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel nomeIcone;
    private javax.swing.JLabel saldoTxt;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
