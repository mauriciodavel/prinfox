package br.com.infox.telas;
// Aula 13

import br.com.infox.controller.UsuarioController;
import java.sql.*;
import br.com.infox.dal.ModuloConexao;
import br.com.infox.entities.Usuario;
import javax.swing.JOptionPane;

public class TelaUsuario extends javax.swing.JInternalFrame {
// usando variável de conexão do DAL

    Connection conexao = null;
    // Criando variáveis especiais para conexão do banco
    // Prepareted Statement e Resultset são frameworks do pacote java.sql
    // e servem para preparar e executar as instruções SQL
    PreparedStatement pst = null;
    ResultSet rs = null;

    /* Creates new form TelaUsuario
     */
    public TelaUsuario() {
        initComponents();
        conexao = ModuloConexao.conector();
    }

    // Metodo que consulta um usuário cadastrado com base no valor digitado no campo IDUSER
    private void consultar() {
        String sql = "select * from tbusuarios where iduser=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUsuId.getText());
            rs = pst.executeQuery();

            // Montando a estrutura caso seja localizado no banco com base no critério de busca
            if (rs.next()) {
                txtUsuNome.setText(rs.getString(2));
                txtUsuFone.setText(rs.getString(3));
                txtUsuLogin.setText(rs.getString(4));
                txtUsuSenha.setText(rs.getString(5));
                // a linha abaixo se refere ao combobox
                cboUsuPerfil.setSelectedItem(rs.getString(6));
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não localizado");
                // as linhas abaixo limpam os campos para que o usuario possa cadastrar um novo
                txtUsuNome.setText(null);
                txtUsuFone.setText(null);
                txtUsuLogin.setText(null);
                txtUsuSenha.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }
// Método para adicionar usuários (botão adicionar)

    private void adicionar() {
//        
//        Usuario u = new Usuario();
//        u.setId( Integer.parseInt( txtUsuId.getText()) );
//        u.setLogin(txtUsuLogin.getText());
//        u.setPerfil(cboUsuPerfil.getSelectedItem().toString());
//        u.setFone(txtUsuFone.getText());
//        u.setSenha(txtUsuSenha.getText());
//        u.setUsuario(txtUsuNome.getText());
//        
//        UsuarioController controller = new UsuarioController();
//        
//        controller.Cadastrar(u);
//        
//        
        String sql = "insert into tbusuarios(iduser,usuario,fone,login,senha,perfil) values(?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUsuId.getText());
            pst.setString(2, txtUsuNome.getText());
            pst.setString(3, txtUsuFone.getText());
            pst.setString(4, txtUsuLogin.getText());
            pst.setString(5, txtUsuSenha.getText());
            pst.setString(6, cboUsuPerfil.getSelectedItem().toString());
            // validação dos campos obrigatórios
            if ((txtUsuId.getText().isEmpty()) || (txtUsuNome.getText().isEmpty()) || (txtUsuLogin.getText().isEmpty()) || (txtUsuSenha.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Campo de preenchimento obrigatório está em branco!");

            } else {

                // a linha abaixo atualiza a tabela de usuário com os dados do formulário
                // a linha abaixo é usada para confirmar a inserção dos dados na tabela
                int adicionado = pst.executeUpdate();
                // a linha abaixo serve de apoio ao entendimento da lógica
                System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");
                    // as linhas abaixo limpam os campos para que o usuario possa cadastrar um novo
                    txtUsuNome.setText(null);
                    txtUsuFone.setText(null);
                    txtUsuLogin.setText(null);
                    txtUsuSenha.setText(null);
                    
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    // Criando método para alterar dados dos usuários
    
    private void alterar(){
    String sql="update tbusuarios set usuario=?,fone=?,login=?,senha=?,perfil=? where iduser=?";
    
        try {
            pst=conexao.prepareStatement(sql);
            pst.setString(1,txtUsuNome.getText());
            pst.setString(2,txtUsuFone.getText());
            pst.setString(3,txtUsuLogin.getText());
            pst.setString(4,txtUsuSenha.getText());
            pst.setString(5,cboUsuPerfil.getSelectedItem().toString());
            pst.setString(6,txtUsuId.getText());
            
            // validação dos campos obrigatórios
            if ((txtUsuId.getText().isEmpty()) || (txtUsuNome.getText().isEmpty()) || (txtUsuLogin.getText().isEmpty()) || (txtUsuSenha.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Campo de preenchimento obrigatório está em branco!");

            } else {

                // a linha abaixo atualiza a tabela de usuário com os dados do formulário
                // a linha abaixo é usada para confirmar a alteração dos dados do usuário na tabela
                int adicionado = pst.executeUpdate();
                // a linha abaixo serve de apoio ao entendimento da lógica
                System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do usuário alterados com sucesso");
                    // as linhas abaixo limpam os campos para que o usuario possa cadastrar um novo
                    txtUsuNome.setText(null);
                    txtUsuFone.setText(null);
                    txtUsuLogin.setText(null);
                    txtUsuSenha.setText(null);
                    
                }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    // método responsável pela remoção de usuários
    private void remover(){
    // a estrutura abaixo confirma a remoção do usuário
    int confirma=JOptionPane.showConfirmDialog(null,"Tem certeza de que deseja remover este usuário?","Atenção!",JOptionPane.YES_NO_OPTION);
    if (confirma == JOptionPane.YES_OPTION){
        String sql="delete from tbusuarios where iduser=?";
        try {
            pst=conexao.prepareStatement(sql);
            pst.setString(1,txtUsuId.getText());
            int apagado=pst.executeUpdate();
            if (apagado > 0){
                JOptionPane.showMessageDialog(null, "Usuário removido com sucesso");
                    txtUsuId.setText(null);
                    txtUsuNome.setText(null);
                    txtUsuFone.setText(null);
                    txtUsuLogin.setText(null);
                    txtUsuSenha.setText(null);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtUsuId = new javax.swing.JTextField();
        txtUsuNome = new javax.swing.JTextField();
        txtUsuFone = new javax.swing.JTextField();
        txtUsuLogin = new javax.swing.JTextField();
        txtUsuSenha = new javax.swing.JTextField();
        cboUsuPerfil = new javax.swing.JComboBox<>();
        btnUsuCreate = new javax.swing.JButton();
        btnUsuRead = new javax.swing.JButton();
        btnUsuUpdate = new javax.swing.JButton();
        btbUsuDelete = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Usuários");
        setPreferredSize(new java.awt.Dimension(1129, 462));

        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("*id");

        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("*Nome");

        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Fone");

        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("*Login");

        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("*Senha");

        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("*Perfil");

        cboUsuPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "user", "gerente" }));

        btnUsuCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/create.png"))); // NOI18N
        btnUsuCreate.setToolTipText("Adicionar");
        btnUsuCreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuCreate.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUsuCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuCreateActionPerformed(evt);
            }
        });

        btnUsuRead.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/read.png"))); // NOI18N
        btnUsuRead.setToolTipText("Encontrar");
        btnUsuRead.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuRead.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUsuRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuReadActionPerformed(evt);
            }
        });

        btnUsuUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/update.png"))); // NOI18N
        btnUsuUpdate.setToolTipText("Editar");
        btnUsuUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuUpdate.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUsuUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuUpdateActionPerformed(evt);
            }
        });

        btbUsuDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/delete.png"))); // NOI18N
        btbUsuDelete.setToolTipText("Excluir");
        btbUsuDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btbUsuDelete.setPreferredSize(new java.awt.Dimension(80, 80));
        btbUsuDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbUsuDeleteActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("( \" ) Campos de Preenchimento obrigatório!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboUsuPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsuId, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsuNome, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsuFone, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsuSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtUsuLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUsuCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btnUsuRead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnUsuUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btbUsuDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(486, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsuId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsuNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUsuFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtUsuLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtUsuSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboUsuPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUsuCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuRead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btbUsuDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(364, Short.MAX_VALUE))
        );

        setBounds(0, 0, 1130, 726);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsuReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuReadActionPerformed
        // chamando o método consultar
        consultar();
    }//GEN-LAST:event_btnUsuReadActionPerformed

    private void btnUsuCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuCreateActionPerformed
        // Chamando o método adicionar ao botão
        adicionar();
    }//GEN-LAST:event_btnUsuCreateActionPerformed

    private void btnUsuUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuUpdateActionPerformed
        // chamando o método alterar
        alterar();
    }//GEN-LAST:event_btnUsuUpdateActionPerformed

    private void btbUsuDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbUsuDeleteActionPerformed
        // chamando o método remover
        remover();
    }//GEN-LAST:event_btbUsuDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbUsuDelete;
    private javax.swing.JButton btnUsuCreate;
    private javax.swing.JButton btnUsuRead;
    private javax.swing.JButton btnUsuUpdate;
    private javax.swing.JComboBox<String> cboUsuPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtUsuFone;
    private javax.swing.JTextField txtUsuId;
    private javax.swing.JTextField txtUsuLogin;
    private javax.swing.JTextField txtUsuNome;
    private javax.swing.JTextField txtUsuSenha;
    // End of variables declaration//GEN-END:variables
}
