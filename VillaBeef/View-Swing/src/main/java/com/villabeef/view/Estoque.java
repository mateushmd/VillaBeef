/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.villabeef.view;

import com.villabeef.model.dto.Funcionario;
import com.villabeef.model.dto.ItemProduto;
import com.villabeef.model.dto.Produto;
import com.villabeef.model.service.ManterEstoque;
import com.villabeef.model.service.ManterFuncionario;
import com.villabeef.model.service.ManterProduto;
import com.villabeef.model.service.ManterUsuario;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Estoque extends javax.swing.JFrame {

    private DefaultTableModel modelo = null;

    private int mouseX, mouseY;

    private ItemProduto item = null;
    private Produto produto = null;

    /**
     * Creates new form Funcionarios1
     */
    public Estoque() {
        initComponents();

        scrollPane.getViewport().setBackground(new Color(245, 222, 179));
        scrollPane.getViewport().setBorder(null);

        tabela.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
        tabela.getTableHeader().setOpaque(false);
        tabela.getTableHeader().setBackground(new Color(76, 21, 32));
        tabela.getTableHeader().setForeground(new Color(245, 222, 179));
        tabela.setRowHeight(25);

        modelo = (DefaultTableModel) tabela.getModel();

        try {
            atualizarTabela(ManterEstoque.listar());
            

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro inesperado.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Falha na conexão com o banco de dados.", JOptionPane.ERROR_MESSAGE);
        }
        
        temItemVencido();
    }

    private void atualizarTabela(HashSet<ItemProduto> lista) {
        DecimalFormat formato = new DecimalFormat("0.00");
        
        if (modelo != null) {
            modelo.getDataVector().removeAllElements();
            modelo.fireTableDataChanged();
        }
        
        try {
            for (ItemProduto item : lista) {
                Produto produto = ManterEstoque.obterProduto(item.getIdProduto());

                modelo.insertRow(modelo.getRowCount(), new Object[] {produto.getTipo(), 
                produto.getMarca(), item.getId(), item.getValidade(), "R$ " + formato.format(item.getValor())});
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro inesperado.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Falha na conexão com o banco de dados.", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void desativar() {
        tipoCampo.setText("Selecione um item para inspecioná-lo");
        marcaCampo.setText("Selecione um item para inspecioná-lo");
        idCampo.setText("Selecione um item para inspecioná-lo");
        validadeCampo.setText("Selecione um item para inspecioná-lo");
        valorCampo.setText("Selecione um item para inspecioná-lo");

        editarButton.setEnabled(false);
        editarButton.setBackground(new Color(59, 21, 32));
        editarTxt.setEnabled(false);
        editarTxt.setForeground(new Color(102, 102, 102));
        editarTxt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        aplicarButton.setEnabled(false);
        aplicarButton.setBackground(new Color(59, 21, 32));
        aplicarTxt.setEnabled(false);
        aplicarTxt.setForeground(new Color(102, 102, 102));
        aplicarTxt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        limparButton.setEnabled(false);
        limparButton.setBackground(new Color(59, 21, 32));
        limparTxt.setEnabled(false);
        limparTxt.setForeground(new Color(102, 102, 102));
        limparTxt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        excluirButton.setEnabled(false);
        excluirButton.setBackground(new Color(59, 21, 32));
        excluirTxt.setEnabled(false);
        excluirTxt.setForeground(new Color(102, 102, 102));
        excluirTxt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        tipoCampo.setEnabled(false);
        marcaCampo.setEnabled(false);
        idCampo.setEnabled(false);
        validadeCampo.setEnabled(false);
        valorCampo.setEnabled(false);
    }
    
    private void temItemVencido() {
        try {
            if(ManterEstoque.obterItensVencidos().size() > 0) {
                avisoValidadeTxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/avisoB.png"))); // NOI18N
                avisoValidadeButton.setEnabled(true);
                avisoValidadeTxt.setEnabled(true);
                avisoValidadeTxt.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            else {
                avisoValidadeTxt.setIcon(null);
                avisoValidadeButton.setEnabled(false);
                avisoValidadeTxt.setEnabled(false);
                avisoValidadeTxt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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
        avisoValidadeButton = new javax.swing.JPanel();
        avisoValidadeTxt = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        valor = new javax.swing.JLabel();
        tipo = new javax.swing.JLabel();
        marca = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        marcaCampo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        tipoCampo = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        idCampo = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        valorCampo = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        buscaTxt = new javax.swing.JTextField();
        buscaButton = new javax.swing.JPanel();
        buscaIcon = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        editarButton = new javax.swing.JPanel();
        editarTxt = new javax.swing.JLabel();
        aplicarButton = new javax.swing.JPanel();
        aplicarTxt = new javax.swing.JLabel();
        limparButton = new javax.swing.JPanel();
        limparTxt = new javax.swing.JLabel();
        adicionarButton = new javax.swing.JPanel();
        adicionarTxt = new javax.swing.JLabel();
        validade = new javax.swing.JLabel();
        validadeCampo = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        excluirButton = new javax.swing.JPanel();
        excluirTxt = new javax.swing.JLabel();
        filtro = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 580));
        setUndecorated(true);
        setResizable(false);

        background.setBackground(new java.awt.Color(245, 222, 179));
        background.setMaximumSize(new java.awt.Dimension(900, 580));
        background.setMinimumSize(new java.awt.Dimension(900, 580));
        background.setPreferredSize(new java.awt.Dimension(900, 580));
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
        header.add(nomeIcone, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 5, 100, -1));

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

        avisoValidadeButton.setBackground(header.getBackground());
        avisoValidadeButton.setEnabled(false);

        avisoValidadeTxt.setEnabled(false);
        avisoValidadeTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                avisoValidadeTxtMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout avisoValidadeButtonLayout = new javax.swing.GroupLayout(avisoValidadeButton);
        avisoValidadeButton.setLayout(avisoValidadeButtonLayout);
        avisoValidadeButtonLayout.setHorizontalGroup(
            avisoValidadeButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(avisoValidadeButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(avisoValidadeTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        avisoValidadeButtonLayout.setVerticalGroup(
            avisoValidadeButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(avisoValidadeButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(avisoValidadeTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );

        header.add(avisoValidadeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, 40, 40));

        background.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 40));

        tabela.setBackground(header.getBackground());
        tabela.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tabela.setForeground(new java.awt.Color(220, 184, 153));
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Marca", "ID", "Validade", "Valor"
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

        background.add(scrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 480, 450));

        valor.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        valor.setForeground(header.getBackground());
        valor.setText("VALOR");
        background.add(valor, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 390, -1, -1));

        tipo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tipo.setForeground(header.getBackground());
        tipo.setText("TIPO");
        background.add(tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, -1, -1));

        marca.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        marca.setForeground(header.getBackground());
        marca.setText("MARCA");
        background.add(marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, -1, -1));

        id.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        id.setForeground(header.getBackground());
        id.setText("ID");
        background.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, -1, -1));

        marcaCampo.setBackground(background.getBackground());
        marcaCampo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        marcaCampo.setForeground(new java.awt.Color(0, 0, 0));
        marcaCampo.setText("Selecione um item para inspecioná-lo");
        marcaCampo.setToolTipText("");
        marcaCampo.setBorder(null);
        marcaCampo.setDisabledTextColor(java.awt.Color.gray);
        marcaCampo.setEnabled(false);
        marcaCampo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                marcaCampoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                marcaCampoFocusLost(evt);
            }
        });
        background.add(marcaCampo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, 320, 30));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        background.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 320, 10));

        tipoCampo.setBackground(background.getBackground());
        tipoCampo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tipoCampo.setForeground(new java.awt.Color(0, 0, 0));
        tipoCampo.setText("Selecione um item para inspecioná-lo");
        tipoCampo.setToolTipText("");
        tipoCampo.setBorder(null);
        tipoCampo.setDisabledTextColor(java.awt.Color.gray);
        tipoCampo.setEnabled(false);
        tipoCampo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tipoCampoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tipoCampoFocusLost(evt);
            }
        });
        background.add(tipoCampo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 320, 30));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        background.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, 320, 10));

        idCampo.setBackground(background.getBackground());
        idCampo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        idCampo.setForeground(new java.awt.Color(0, 0, 0));
        idCampo.setText("Selecione um item para inspecioná-lo");
        idCampo.setToolTipText("");
        idCampo.setBorder(null);
        idCampo.setDisabledTextColor(java.awt.Color.gray);
        idCampo.setEnabled(false);
        idCampo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                idCampoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                idCampoFocusLost(evt);
            }
        });
        background.add(idCampo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, 320, 30));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        background.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, 320, 10));

        valorCampo.setBackground(background.getBackground());
        valorCampo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        valorCampo.setForeground(new java.awt.Color(0, 0, 0));
        valorCampo.setText("Selecione um item para inspecioná-lo");
        valorCampo.setToolTipText("");
        valorCampo.setBorder(null);
        valorCampo.setDisabledTextColor(java.awt.Color.gray);
        valorCampo.setEnabled(false);
        valorCampo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                valorCampoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                valorCampoFocusLost(evt);
            }
        });
        background.add(valorCampo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 420, 320, 30));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        background.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 450, 320, 10));

        buscaTxt.setBackground(background.getBackground());
        buscaTxt.setForeground(java.awt.Color.gray);
        buscaTxt.setText("Busca");
        buscaTxt.setBorder(null);
        buscaTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                buscaTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                buscaTxtFocusLost(evt);
            }
        });
        background.add(buscaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 330, 40));

        buscaButton.setBackground(background.getBackground());

        buscaIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busca.png"))); // NOI18N
        buscaIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buscaIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscaIconMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout buscaButtonLayout = new javax.swing.GroupLayout(buscaButton);
        buscaButton.setLayout(buscaButtonLayout);
        buscaButtonLayout.setHorizontalGroup(
            buscaButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buscaButtonLayout.createSequentialGroup()
                .addComponent(buscaIcon)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        buscaButtonLayout.setVerticalGroup(
            buscaButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buscaIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        background.add(buscaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 40, 40));

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        background.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 330, 10));

        editarButton.setBackground(new java.awt.Color(59, 21, 32));
        editarButton.setEnabled(false);

        editarTxt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        editarTxt.setForeground(new java.awt.Color(102, 102, 102));
        editarTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editarTxt.setText("EDITAR");
        editarTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editarTxt.setEnabled(false);
        editarTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editarTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editarTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout editarButtonLayout = new javax.swing.GroupLayout(editarButton);
        editarButton.setLayout(editarButtonLayout);
        editarButtonLayout.setHorizontalGroup(
            editarButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editarTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        editarButtonLayout.setVerticalGroup(
            editarButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editarTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        background.add(editarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 470, 100, 40));

        aplicarButton.setBackground(new java.awt.Color(59, 21, 32));
        aplicarButton.setEnabled(false);

        aplicarTxt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        aplicarTxt.setForeground(new java.awt.Color(102, 102, 102));
        aplicarTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aplicarTxt.setText("APLICAR");
        aplicarTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        aplicarTxt.setEnabled(false);
        aplicarTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aplicarTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aplicarTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aplicarTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout aplicarButtonLayout = new javax.swing.GroupLayout(aplicarButton);
        aplicarButton.setLayout(aplicarButtonLayout);
        aplicarButtonLayout.setHorizontalGroup(
            aplicarButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aplicarTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        aplicarButtonLayout.setVerticalGroup(
            aplicarButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aplicarTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        background.add(aplicarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 470, 100, 40));

        limparButton.setBackground(new java.awt.Color(59, 21, 32));
        limparButton.setEnabled(false);

        limparTxt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        limparTxt.setForeground(new java.awt.Color(102, 102, 102));
        limparTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        limparTxt.setText("LIMPAR");
        limparTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        limparTxt.setEnabled(false);
        limparTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                limparTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                limparTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                limparTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout limparButtonLayout = new javax.swing.GroupLayout(limparButton);
        limparButton.setLayout(limparButtonLayout);
        limparButtonLayout.setHorizontalGroup(
            limparButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(limparTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        limparButtonLayout.setVerticalGroup(
            limparButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(limparTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        background.add(limparButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 470, 100, 40));

        adicionarButton.setBackground(header.getBackground());

        adicionarTxt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        adicionarTxt.setForeground(new java.awt.Color(255, 255, 255));
        adicionarTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adicionarTxt.setText("ADICIONAR");
        adicionarTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        background.add(adicionarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 530, 150, 40));

        validade.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        validade.setForeground(header.getBackground());
        validade.setText("VALIDADE");
        background.add(validade, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, -1, -1));

        validadeCampo.setBackground(background.getBackground());
        validadeCampo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        validadeCampo.setForeground(new java.awt.Color(0, 0, 0));
        validadeCampo.setText("Selecione um item para inspecioná-lo");
        validadeCampo.setToolTipText("");
        validadeCampo.setBorder(null);
        validadeCampo.setDisabledTextColor(java.awt.Color.gray);
        validadeCampo.setEnabled(false);
        validadeCampo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                validadeCampoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                validadeCampoFocusLost(evt);
            }
        });
        background.add(validadeCampo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, 320, 30));

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        background.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, 320, 10));

        excluirButton.setBackground(new java.awt.Color(59, 21, 32));
        excluirButton.setEnabled(false);

        excluirTxt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        excluirTxt.setForeground(new java.awt.Color(255, 255, 255));
        excluirTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        excluirTxt.setText("EXCLUIR");
        excluirTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        excluirTxt.setEnabled(false);
        excluirTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                excluirTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                excluirTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                excluirTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout excluirButtonLayout = new javax.swing.GroupLayout(excluirButton);
        excluirButton.setLayout(excluirButtonLayout);
        excluirButtonLayout.setHorizontalGroup(
            excluirButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(excluirTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        excluirButtonLayout.setVerticalGroup(
            excluirButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(excluirTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        background.add(excluirButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 530, 150, 40));

        filtro.setBackground(header.getBackground());
        filtro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        filtro.setForeground(new java.awt.Color(255, 255, 255));
        filtro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Marca", "Tipo" }));
        filtro.setBorder(null);
        filtro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        background.add(filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 66, 80, 40));

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

    private void marcaCampoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_marcaCampoFocusGained
        if (marcaCampo.getText().equals("Selecione um item para inspecioná-lo")) {
            marcaCampo.setText("");
            marcaCampo.setForeground(Color.black);
        }
    }//GEN-LAST:event_marcaCampoFocusGained

    private void tipoCampoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tipoCampoFocusGained
        if (tipoCampo.getText().equals("Selecione um item para inspecioná-lo")) {
            tipoCampo.setText("");
            tipoCampo.setForeground(Color.black);
        }
    }//GEN-LAST:event_tipoCampoFocusGained

    private void idCampoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idCampoFocusGained
        if (idCampo.getText().equals("Selecione um item para inspecioná-lo")) {
            idCampo.setText("");
            idCampo.setForeground(Color.black);
        }
    }//GEN-LAST:event_idCampoFocusGained

    private void valorCampoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorCampoFocusGained
        if (valorCampo.getText().equals("Selecione um item para inspecioná-lo")) {
            valorCampo.setText("");
            valorCampo.setForeground(Color.black);
        }
    }//GEN-LAST:event_valorCampoFocusGained

    private void buscaTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscaTxtFocusGained
        if (buscaTxt.getText().equals("Busca")) {
            buscaTxt.setText("");
            buscaTxt.setForeground(Color.black);
        }
    }//GEN-LAST:event_buscaTxtFocusGained

    private void buscaTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscaTxtFocusLost
        if (buscaTxt.getText().isBlank()) {
            buscaTxt.setText("Busca");
            buscaTxt.setForeground(Color.gray);
        }
    }//GEN-LAST:event_buscaTxtFocusLost

    private void tipoCampoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tipoCampoFocusLost
        if (tipoCampo.getText().isBlank()) {
            tipoCampo.setText("Selecione um item para inspecioná-lo");
            tipoCampo.setForeground(Color.gray);
        }
    }//GEN-LAST:event_tipoCampoFocusLost

    private void marcaCampoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_marcaCampoFocusLost
        if (marcaCampo.getText().isBlank()) {
            marcaCampo.setText("Selecione um item para inspecioná-lo");
            marcaCampo.setForeground(Color.gray);
        }
    }//GEN-LAST:event_marcaCampoFocusLost

    private void idCampoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idCampoFocusLost
        if (idCampo.getText().isBlank()) {
            idCampo.setText("Selecione um item para inspecioná-lo");
            idCampo.setForeground(Color.gray);
        }
    }//GEN-LAST:event_idCampoFocusLost

    private void valorCampoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorCampoFocusLost
        if (valorCampo.getText().isBlank()) {
            valorCampo.setText("Selecione um item para inspecioná-lo");
            valorCampo.setForeground(Color.gray);
        }
    }//GEN-LAST:event_valorCampoFocusLost

    private void adicionarTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adicionarTxtMouseClicked
        RegistroProduto r = new RegistroProduto(this, true);
        r.setVisible(rootPaneCheckingEnabled);
        r.setLocationRelativeTo(null);

        try {
            atualizarTabela(ManterEstoque.listar());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro inesperado.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Falha na conexão com o banco de dados.", JOptionPane.ERROR_MESSAGE);
        }
        
        temItemVencido();
    }//GEN-LAST:event_adicionarTxtMouseClicked

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        try {
            int index = tabela.getSelectedRow();

            TableModel modelo = tabela.getModel();

            item = ManterEstoque.obterPorId(modelo.getValueAt(index, 2).toString());
            produto = ManterEstoque.obterProduto(item.getIdProduto());

            DecimalFormat formato = new DecimalFormat("0.00");

            tipoCampo.setText(produto.getTipo());
            marcaCampo.setText(produto.getMarca());
            idCampo.setText(item.getId());
            validadeCampo.setText(item.getValidade());
            valorCampo.setText(formato.format(item.getValor()));

            editarButton.setEnabled(true);
            editarButton.setBackground(header.getBackground());
            editarTxt.setEnabled(true);
            editarTxt.setForeground(Color.white);
            editarTxt.setCursor(new Cursor(Cursor.HAND_CURSOR));

            limparButton.setEnabled(true);
            limparButton.setBackground(header.getBackground());
            limparTxt.setEnabled(true);
            limparTxt.setForeground(Color.white);
            limparTxt.setCursor(new Cursor(Cursor.HAND_CURSOR));

            excluirButton.setEnabled(true);
            excluirButton.setBackground(header.getBackground());
            excluirTxt.setEnabled(true);
            excluirTxt.setForeground(Color.white);
            excluirTxt.setCursor(new Cursor(Cursor.HAND_CURSOR));
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro inesperado.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Falha na conexão com o banco de dados.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tabelaMouseClicked

    private void validadeCampoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_validadeCampoFocusGained
        if (validadeCampo.getText().equals("Selecione um item para inspecioná-lo")) {
            validadeCampo.setText("");
            validadeCampo.setForeground(Color.black);
        }
    }//GEN-LAST:event_validadeCampoFocusGained

    private void validadeCampoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_validadeCampoFocusLost
        if (validadeCampo.getText().isBlank()) {
            validadeCampo.setText("Selecione um item para inspecioná-lo");
            validadeCampo.setForeground(Color.gray);
        }
    }//GEN-LAST:event_validadeCampoFocusLost

    private void limparTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limparTxtMouseClicked
        desativar();
    }//GEN-LAST:event_limparTxtMouseClicked

    private void editarTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarTxtMouseClicked
        aplicarButton.setEnabled(true);
        aplicarButton.setBackground(header.getBackground());
        aplicarTxt.setEnabled(true);
        aplicarTxt.setForeground(Color.white);
        aplicarTxt.setCursor(new Cursor(Cursor.HAND_CURSOR));

        tipoCampo.setEnabled(true);
        marcaCampo.setEnabled(true);
        idCampo.setEnabled(true);
        validadeCampo.setEnabled(true);
        valorCampo.setEnabled(true);
    }//GEN-LAST:event_editarTxtMouseClicked

    private void editarTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarTxtMouseEntered
        if (editarButton.isEnabled())
            editarButton.setBackground(new Color(119, 34, 51));
    }//GEN-LAST:event_editarTxtMouseEntered

    private void editarTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarTxtMouseExited
        if (editarButton.isEnabled())
            editarButton.setBackground(header.getBackground());
    }//GEN-LAST:event_editarTxtMouseExited

    private void aplicarTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aplicarTxtMouseEntered
        if (aplicarButton.isEnabled())
            aplicarButton.setBackground(new Color(119, 34, 51));
    }//GEN-LAST:event_aplicarTxtMouseEntered

    private void aplicarTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aplicarTxtMouseExited
        if (aplicarButton.isEnabled())
            aplicarButton.setBackground(header.getBackground());
    }//GEN-LAST:event_aplicarTxtMouseExited

    private void limparTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limparTxtMouseEntered
        if (limparButton.isEnabled())
            limparButton.setBackground(new Color(119, 34, 51));
    }//GEN-LAST:event_limparTxtMouseEntered

    private void limparTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limparTxtMouseExited
        if (limparButton.isEnabled())
            limparButton.setBackground(header.getBackground());
    }//GEN-LAST:event_limparTxtMouseExited

    private void adicionarTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adicionarTxtMouseEntered
        if (adicionarButton.isEnabled())
            adicionarButton.setBackground(new Color(119, 34, 51));
    }//GEN-LAST:event_adicionarTxtMouseEntered

    private void adicionarTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adicionarTxtMouseExited
        if (adicionarButton.isEnabled())
            adicionarButton.setBackground(header.getBackground());
    }//GEN-LAST:event_adicionarTxtMouseExited

    private void excluirTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_excluirTxtMouseClicked
        try {
            int resultado =JOptionPane.showConfirmDialog(rootPane, "Deseja excluir o registro deste item?", 
                        "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            if(resultado == JOptionPane.YES_OPTION) {
                ManterEstoque.excluir(item);
                
                desativar();
                atualizarTabela(ManterEstoque.listar());
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro inesperado.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Falha na conexão com o banco de dados.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_excluirTxtMouseClicked

    private void excluirTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_excluirTxtMouseEntered
        if (excluirButton.isEnabled())
            excluirButton.setBackground(new Color(119, 34, 51));
    }//GEN-LAST:event_excluirTxtMouseEntered

    private void excluirTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_excluirTxtMouseExited
        if (excluirButton.isEnabled())
            excluirButton.setBackground(header.getBackground());
    }//GEN-LAST:event_excluirTxtMouseExited

    private void aplicarTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aplicarTxtMouseClicked
        String marca = marcaCampo.getText();
        String tipo = tipoCampo.getText();
        double valor = Double.valueOf(valorCampo.getText().replace(',', '.'));
        String validade = validadeCampo.getText();
        String id  = idCampo.getText();
        
        try {
            SimpleDateFormat formato1 = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formato2 = new SimpleDateFormat("yyyy-MM-dd");

            Date data = Date.valueOf(formato2.format(formato1.parse(validade)));

            int resultado;

            Produto novoProduto = produto;

            if(!produto.getTipo().equals(tipo) | !produto.getMarca().equals(marca))
            {
                novoProduto = new Produto("", marcaCampo.getText(), tipoCampo.getText(), 0, 0);
            }

            ItemProduto novoItem = new ItemProduto(id, data, valor);
        
            ManterEstoque.alterar(novoProduto, item, novoItem);
            atualizarTabela(ManterEstoque.listar());
            
            aplicarButton.setEnabled(false);
            aplicarButton.setBackground(new Color(59, 21, 32));
            aplicarTxt.setEnabled(false);
            aplicarTxt.setForeground(new Color(102, 102, 102));
            aplicarTxt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro inesperado.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Falha na conexão com o banco de dados.", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro inesperado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        temItemVencido();
    }//GEN-LAST:event_aplicarTxtMouseClicked

    private void buscaIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscaIconMouseClicked
        try {
            atualizarTabela(ManterEstoque.pesquisar(buscaTxt.getText(), filtro.getSelectedIndex()));
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro inesperado.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Falha na conexão com o banco de dados.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buscaIconMouseClicked

    private void avisoValidadeTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_avisoValidadeTxtMouseClicked
        try {
            ItensVencidos i = new ItensVencidos(this, true, ManterEstoque.obterItensVencidos());
            i.setVisible(true);
            i.setLocationRelativeTo(null);
            
            atualizarTabela(ManterEstoque.listar());
            temItemVencido();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro inesperado.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Falha na conexão com o banco de dados.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_avisoValidadeTxtMouseClicked

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
            java.util.logging.Logger.getLogger(Estoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Estoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Estoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Estoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Estoque().setVisible(true);
            }
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel adicionarButton;
    private javax.swing.JLabel adicionarTxt;
    private javax.swing.JPanel aplicarButton;
    private javax.swing.JLabel aplicarTxt;
    private javax.swing.JPanel avisoValidadeButton;
    private javax.swing.JLabel avisoValidadeTxt;
    private javax.swing.JPanel background;
    private javax.swing.JPanel buscaButton;
    private javax.swing.JLabel buscaIcon;
    private javax.swing.JTextField buscaTxt;
    private javax.swing.JPanel editarButton;
    private javax.swing.JLabel editarTxt;
    private javax.swing.JPanel excluirButton;
    private javax.swing.JLabel excluirTxt;
    private javax.swing.JPanel fecharButton;
    private javax.swing.JLabel fecharTxt;
    private javax.swing.JComboBox<String> filtro;
    private javax.swing.JPanel header;
    private javax.swing.JLabel id;
    private javax.swing.JTextField idCampo;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JPanel limparButton;
    private javax.swing.JLabel limparTxt;
    private javax.swing.JLabel marca;
    private javax.swing.JTextField marcaCampo;
    private javax.swing.JLabel nomeIcone;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tabela;
    private javax.swing.JLabel tipo;
    private javax.swing.JTextField tipoCampo;
    private javax.swing.JLabel validade;
    private javax.swing.JTextField validadeCampo;
    private javax.swing.JLabel valor;
    private javax.swing.JTextField valorCampo;
    // End of variables declaration//GEN-END:variables
    // </editor-fold> 
}
