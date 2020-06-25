/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Controle.ClienteControle;
import Controle.ImovelControle;
import Controle.LocacaoControle;
import Controle.LoginException;
import Controle.Validacao;
import Modelo.Cliente;
import Modelo.Imovel;
import Modelo.Locacao;
import com.sun.crypto.provider.JceKeyStore;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class TelaCadLocacao extends Cabecalho {

    private boolean vrNovoAlteraLocacao;//false: alterar locação, true: nova Locacao
    private Cliente cliente = new Cliente();
    Locacao locacao = new Locacao();
    private boolean clienteSelecionado;//utilizado para verificar se o cliente foi selecionado

    /*
    *   METODO CONSTRUTOR PARA NOVO IMÓVEL
    *   recebe o Objeto Imovel da TelaInicial e preenche os campos da TelaCadLocação com os dados do imóvel selecionado
     */
    public TelaCadLocacao(Imovel imv) {
        vrNovoAlteraLocacao = true; //para sinalizar que se refere á um novo imóvel
        clienteSelecionado = false; //nenhum Cliente selecionado
        initComponents();
        locacao.getImovel().setId(imv.getId());
        jLabelImvId.setText(Integer.toString(imv.getId()));
        jLabelImvRua.setText(imv.getRua());
        jLabelImvNum.setText(Integer.toString(imv.getNumero()));//convertendo para String
        jLabelImvBairro.setText(imv.getBairro());
        jLabelImvCidade.setText(imv.getCidade());
        jLabelImvEstado.setText(imv.getEstado());
        jLabelImvCep.setText(imv.getCEP());
        jLabelImvTipo.setText(imv.getTipo());
        jLabelImvQuartos.setText(Integer.toString(imv.getQtdQuarto()));
        jLabelImvTamanho.setText(Double.toString(imv.getTamanho()));
        jLabelImvValor.setText(Double.toString(imv.getValor()));
    }

    /*
    *   METODO CONSTRUTOR PARA ALTERAR IMOVEL
    *   recebe o Objeto Locacao da TelaInicial e preenche os campos da TelaCadLocação com os dados da Locacao selecionada
     */
    public TelaCadLocacao(Locacao loc) {
        vrNovoAlteraLocacao = false; //false significa alterar
        clienteSelecionado = false; //nenhum Cliente selecionado

        initComponents();

        locacao.setIdLocacao(loc.getIdLocacao());
        jLabelImvId.setText(Integer.toString(loc.getImovel().getId()));
        jLabelImvRua.setText(loc.getImovel().getRua());
        jLabelImvNum.setText(Integer.toString(loc.getImovel().getNumero()));//convertendo para String
        jLabelImvBairro.setText(loc.getImovel().getBairro());
        jLabelImvCidade.setText(loc.getImovel().getCidade());
        jLabelImvEstado.setText(loc.getImovel().getEstado());
        jLabelImvCep.setText(loc.getImovel().getCEP());
        jLabelImvTipo.setText(loc.getImovel().getTipo());
        jLabelImvQuartos.setText(Integer.toString(loc.getImovel().getQtdQuarto()));
        jLabelImvTamanho.setText(Double.toString(loc.getImovel().getTamanho()));
        jLabelImvValor.setText(Double.toString(loc.getImovel().getValor()));
        jTextFieldValorLocado.setText(Double.toString(loc.getValorLocacao()));
        jTextFieldObs.setText(loc.getImovel().getObs());

        populaCamposCliente(loc.getCliente().getCPF());
    }

    ImovelControle imov = new ImovelControle();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanelCliente = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabelSexo = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabelDataNascimento = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelNomeCliente = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelCPF = new javax.swing.JLabel();
        jButtonNovoCliente = new javax.swing.JToggleButton();
        jButtonBuscaClienteCPF1 = new javax.swing.JToggleButton();
        jButtonAlteraCliente = new javax.swing.JToggleButton();
        jButtonExcluirCliente = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();
        jLabelBanco = new javax.swing.JLabel();
        jLabelAgencia = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelConta = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabelOperacao = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanelInfImovel = new javax.swing.JPanel();
        jLabelImvCidade = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabelImvRua = new javax.swing.JLabel();
        jLabelImvId = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabelImvBairro = new javax.swing.JLabel();
        jLabelImvCep = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabelImvEstado = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabelImvValor = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabelImvNum = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabelImvTipo = new javax.swing.JLabel();
        jLabelImvQuartos = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabelImvTamanho = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jTextFieldObs = new javax.swing.JTextField();
        jTextFieldValorLocado = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jcDataFinal = new com.toedter.calendar.JDateChooser();
        jPanelComandosLocacao = new javax.swing.JPanel();
        jButtonSalvarLocacao = new javax.swing.JToggleButton();
        jButtonCancelarVoltarLocacao = new javax.swing.JToggleButton();
        jLabelNovaLocacao = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel8.setText("Sexo:");

        jLabelSexo.setForeground(new java.awt.Color(51, 51, 51));

        jLabel9.setText("Nascimento:");

        jLabelDataNascimento.setForeground(new java.awt.Color(51, 51, 51));

        jLabel4.setText("Nome:");

        jLabelNomeCliente.setForeground(new java.awt.Color(51, 51, 51));

        jLabel7.setText("CPF:");

        jLabelCPF.setForeground(new java.awt.Color(51, 51, 51));

        jButtonNovoCliente.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButtonNovoCliente.setText("Novo");
        jButtonNovoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoClienteActionPerformed(evt);
            }
        });

        jButtonBuscaClienteCPF1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButtonBuscaClienteCPF1.setText("Buscar");
        jButtonBuscaClienteCPF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscaClienteCPF1ActionPerformed(evt);
            }
        });

        jButtonAlteraCliente.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButtonAlteraCliente.setText("Alterar");
        jButtonAlteraCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlteraClienteActionPerformed(evt);
            }
        });

        jButtonExcluirCliente.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jButtonExcluirCliente.setText("Excluir");
        jButtonExcluirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirClienteActionPerformed(evt);
            }
        });

        jLabel5.setText("Banco:");

        jLabelBanco.setForeground(new java.awt.Color(51, 51, 51));

        jLabelAgencia.setForeground(new java.awt.Color(51, 51, 51));

        jLabel6.setText("Agencia:");

        jLabelConta.setForeground(new java.awt.Color(51, 51, 51));

        jLabel10.setText("Conta:");

        jLabelOperacao.setForeground(new java.awt.Color(51, 51, 51));

        jLabel11.setText("Op:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Cliente");

        javax.swing.GroupLayout jPanelClienteLayout = new javax.swing.GroupLayout(jPanelCliente);
        jPanelCliente.setLayout(jPanelClienteLayout);
        jPanelClienteLayout.setHorizontalGroup(
            jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelClienteLayout.createSequentialGroup()
                        .addComponent(jButtonExcluirCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAlteraCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonNovoCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonBuscaClienteCPF1))
                    .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelClienteLayout.createSequentialGroup()
                            .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanelClienteLayout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelNomeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanelClienteLayout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabelBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabelAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabelConta, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelClienteLayout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelClienteLayout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabelSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel12)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanelClienteLayout.setVerticalGroup(
            jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabelNomeCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8))
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addComponent(jLabelSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addComponent(jLabelDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelAgencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelBanco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelConta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonExcluirCliente)
                    .addComponent(jButtonAlteraCliente)
                    .addComponent(jButtonNovoCliente)
                    .addComponent(jButtonBuscaClienteCPF1))
                .addGap(24, 24, 24))
        );

        jLabelImvCidade.setForeground(new java.awt.Color(51, 51, 51));

        jLabel15.setText("Cidade:");

        jLabel16.setText("Rua:");

        jLabelImvRua.setForeground(new java.awt.Color(51, 51, 51));

        jLabelImvId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelImvId.setForeground(new java.awt.Color(51, 51, 51));

        jLabel18.setText("Bairro:");

        jLabelImvBairro.setForeground(new java.awt.Color(51, 51, 51));

        jLabelImvCep.setForeground(new java.awt.Color(51, 51, 51));

        jLabel19.setText("CEP:");

        jLabel20.setText("UF");

        jLabelImvEstado.setForeground(new java.awt.Color(51, 51, 51));

        jLabel21.setText("Observações:");

        jLabel22.setText("Valor Locado: ");

        jLabelImvValor.setForeground(new java.awt.Color(51, 51, 51));

        jLabel23.setText("Valor da Locação:");

        jLabel24.setText("N°:");

        jLabelImvNum.setForeground(new java.awt.Color(51, 51, 51));

        jLabel25.setText("Data final do contrato:");

        jLabel26.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel26.setText("Informações do Imóvel código:");

        jLabel27.setText("Tipo:");

        jLabelImvTipo.setForeground(new java.awt.Color(51, 51, 51));

        jLabelImvQuartos.setForeground(new java.awt.Color(51, 51, 51));

        jLabel28.setText("Quartos:");

        jLabel29.setText("m²");

        jLabelImvTamanho.setForeground(new java.awt.Color(51, 51, 51));

        jLabel30.setText("Tamanho:");

        jTextFieldObs.setForeground(new java.awt.Color(0, 0, 51));
        jTextFieldObs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldObsActionPerformed(evt);
            }
        });

        jTextFieldValorLocado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldValorLocadoActionPerformed(evt);
            }
        });

        jLabel31.setForeground(new java.awt.Color(255, 0, 0));
        jLabel31.setText("*");

        javax.swing.GroupLayout jPanelInfImovelLayout = new javax.swing.GroupLayout(jPanelInfImovel);
        jPanelInfImovel.setLayout(jPanelInfImovelLayout);
        jPanelInfImovelLayout.setHorizontalGroup(
            jPanelInfImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfImovelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInfImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(jPanelInfImovelLayout.createSequentialGroup()
                        .addGroup(jPanelInfImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelInfImovelLayout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelImvId, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelInfImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelInfImovelLayout.createSequentialGroup()
                                    .addComponent(jLabel21)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldObs))
                                .addGroup(jPanelInfImovelLayout.createSequentialGroup()
                                    .addGroup(jPanelInfImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelInfImovelLayout.createSequentialGroup()
                                            .addComponent(jLabel27)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabelImvTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(89, 89, 89)
                                            .addComponent(jLabelImvQuartos, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(118, 118, 118)
                                            .addComponent(jLabel30)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabelImvTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel29))
                                        .addGroup(jPanelInfImovelLayout.createSequentialGroup()
                                            .addGap(211, 211, 211)
                                            .addComponent(jLabel28)))
                                    .addGap(249, 249, 249))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelInfImovelLayout.createSequentialGroup()
                                    .addComponent(jLabel23)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelImvValor, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel22)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldValorLocado, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelInfImovelLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelImvCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelImvEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelInfImovelLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelImvCep, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelImvRua, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelImvNum, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelImvBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInfImovelLayout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(104, 104, 104)))
                        .addGap(0, 26, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelInfImovelLayout.setVerticalGroup(
            jPanelInfImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfImovelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelInfImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelImvId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(jPanelInfImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInfImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInfImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelImvCep, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(jPanelInfImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelImvRua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanelInfImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabelImvNum, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabelImvBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelInfImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jPanelInfImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelInfImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelImvCidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabelImvEstado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelInfImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addGroup(jPanelInfImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelImvQuartos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel29)
                    .addComponent(jLabelImvTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelImvTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelInfImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInfImovelLayout.createSequentialGroup()
                        .addGroup(jPanelInfImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanelInfImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldValorLocado)
                                .addComponent(jLabel25))
                            .addGroup(jPanelInfImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInfImovelLayout.createSequentialGroup()
                                    .addGap(4, 4, 4)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelInfImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                                    .addComponent(jLabelImvValor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(31, 31, 31)
                        .addGroup(jPanelInfImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jTextFieldObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jcDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jButtonSalvarLocacao.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jButtonSalvarLocacao.setText("Salvar");
        jButtonSalvarLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarLocacaoActionPerformed(evt);
            }
        });

        jButtonCancelarVoltarLocacao.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jButtonCancelarVoltarLocacao.setText("Cancelar");
        jButtonCancelarVoltarLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarVoltarLocacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelComandosLocacaoLayout = new javax.swing.GroupLayout(jPanelComandosLocacao);
        jPanelComandosLocacao.setLayout(jPanelComandosLocacaoLayout);
        jPanelComandosLocacaoLayout.setHorizontalGroup(
            jPanelComandosLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelComandosLocacaoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSalvarLocacao)
                .addGap(18, 18, 18)
                .addComponent(jButtonCancelarVoltarLocacao)
                .addGap(43, 43, 43))
        );
        jPanelComandosLocacaoLayout.setVerticalGroup(
            jPanelComandosLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelComandosLocacaoLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanelComandosLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvarLocacao)
                    .addComponent(jButtonCancelarVoltarLocacao))
                .addContainerGap())
        );

        jLabelNovaLocacao.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabelNovaLocacao.setText("Cadastro de Nova Locação:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelComandosLocacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNovaLocacao)
                            .addComponent(jPanelInfImovel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 12, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNovaLocacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelInfImovel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelComandosLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNovoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoClienteActionPerformed
        //String cpf;
        TelaCliente tCliente = new TelaCliente();
        tCliente.setLocationRelativeTo(null);
        tCliente.setVisible(true);
    }//GEN-LAST:event_jButtonNovoClienteActionPerformed

    private void jTextFieldObsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldObsActionPerformed
    }//GEN-LAST:event_jTextFieldObsActionPerformed

    /*
    *   BOTÃO PARA SALVAR NOVA LOCACAO E ALTERAR LOCACAO NO BANCO DE DADOS
    *   Esse botão quando acionado captura o conteúdo dos campos preenchidos em um objeto Locacao,
    *   primeiro faz as validações e posteriormente chama na classe locacaoContole os métodos novaLocacao e alteraLocacao,
    *   a opção de utilização de cada método é definido através do construtor
     */
    private void jButtonSalvarLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarLocacaoActionPerformed
        int id = cliente.getId();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        try {
            locacao.setValorLocacao(Double.parseDouble(jTextFieldValorLocado.getText()));
            if (clienteSelecionado) {
                Validacao validacao = new Validacao();
                //Esse if verifica se todos os campos estão preenchidos
                if (validacao.estaVazio(jTextFieldValorLocado)) {
                    LocacaoControle locacaoControle = new LocacaoControle();

                    locacao.getCliente().setId(cliente.getId());
                    locacao.getImovel().setObs(jTextFieldObs.getText());
                    if (format.format(jcDataFinal.getDate()).compareTo(format.format(date.getTime())) > 0) {
                        locacao.setDataFinal(format.format(jcDataFinal.getDate()));
                        //vrNovoAlteraLocacao é definido através do construtor
                        if (vrNovoAlteraLocacao) {
                            locacaoControle.novaLocacao(locacao);
                        } else {
                            locacaoControle.alteraLocacao(locacao);
                        }
                        dispose();
                        TelaInicial tInicial = new TelaInicial();
                        tInicial.setLocationRelativeTo(null);
                        tInicial.setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "Data de contrato menor que a atual");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Todos os campos sinalizados devem estar preenchidos!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione o Cliente!");
            }
        } catch (NumberFormatException | HeadlessException e) {
            jTextFieldValorLocado.setText("");
            JOptionPane.showMessageDialog(null, "Campo Valor somente é permitido números!");
        }
    }//GEN-LAST:event_jButtonSalvarLocacaoActionPerformed

    /*
    * BOTÃO CANCELAR
    * Botão cancelar fecha a TelaCadLocação e abre a TelaInicial
     */
    private void jButtonCancelarVoltarLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarVoltarLocacaoActionPerformed
        dispose();
        TelaInicial tInicial = new TelaInicial();
        tInicial.setLocationRelativeTo(null);
        tInicial.setVisible(true);
    }//GEN-LAST:event_jButtonCancelarVoltarLocacaoActionPerformed

    /*
    *   BOTÃO PARA BUSCAR CLIENTE
    *   Botão quando acionado abre uma caixa JOptionPane pedindo o CPF,
     */
    private void jButtonBuscaClienteCPF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscaClienteCPF1ActionPerformed
        String cpf;
        cpf = JOptionPane.showInputDialog(null, "Digite o CPF", "Busca Cliente", JOptionPane.INFORMATION_MESSAGE);
        populaCamposCliente(cpf);
    }

    /*
    *   METODO QUE POPULA OS CAMPOS CLIENTES
    *   Utilizado pelo botão buscar cliente e pelo método construtor para alterar a locacao
    *   Ele recebe o CPF e se válido popula os campos Cliente
    *   Esse método chama o metodo busca Clienete pelo CPF na classe ClienteControle que retorna um Resultset,
    *   se achar um cliente ele popula os campos na TelaCadLocacao, caso contrário informa que o cliente não foi encontrado
     */
    private void populaCamposCliente(String cpf) {

        ClienteControle clienteControle = new ClienteControle();

        try {
            ResultSet res = clienteControle.buscaCliente(cpf);
            if (res.next()) {
                cliente.setId(res.getInt("cliente_id"));
                cliente.setNome(res.getString("cliente_nome"));
                cliente.setCPF(res.getString("cpf"));
                cliente.setSexo(res.getString("sexo").charAt(0));
                cliente.setNascimento(res.getString("data_nascimento"));
                cliente.setNomeBanco(res.getString("banco"));
                cliente.setNumAgencia(res.getInt("agencia"));
                cliente.setNumConta(res.getInt("conta"));
                cliente.setOperacao(res.getInt("operacao"));
                cliente.setNascimentoDia(res.getString("day(data_nascimento)"));
                cliente.setNascimentoMes(res.getString("month(data_nascimento)"));
                cliente.setNascimentoAno(res.getString("year(data_nascimento)"));
                jLabelNomeCliente.setText(cliente.getNome());
                jLabelCPF.setText(cliente.getCPF());
                jLabelDataNascimento.setText(cliente.getNascimento());
                jLabelBanco.setText(cliente.getNomeBanco());
                jLabelConta.setText(Integer.toString(cliente.getNumConta()));
                jLabelAgencia.setText(Integer.toString(cliente.getNumAgencia()));
                jLabelOperacao.setText(Integer.toString(cliente.getOperacao()));
                if (cliente.getSexo() == 'm') {
                    jLabelSexo.setText("Masculino");
                } else {
                    jLabelSexo.setText("Feminino");
                }
                clienteSelecionado = true; //Cliente selecionado
            } else {
                JOptionPane.showMessageDialog(this, "Cliente não encontrado.");
                jLabelNomeCliente.setText("");
                jLabelCPF.setText("");
                jLabelDataNascimento.setText("");
                jLabelSexo.setText("");
                clienteSelecionado = false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO:" + ex);
        }

    }//GEN-LAST:event_jButtonBuscaClienteCPF1ActionPerformed

    private void jButtonAlteraClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlteraClienteActionPerformed

        TelaCliente tCliente = new TelaCliente(cliente);
        tCliente.setLocationRelativeTo(null);
        tCliente.setVisible(true);

    }//GEN-LAST:event_jButtonAlteraClienteActionPerformed

    private void jButtonExcluirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirClienteActionPerformed
        ClienteControle clienteControle = new ClienteControle();
        clienteControle.deleteCliente(cliente);
        jLabelNomeCliente.setText("");
        jLabelCPF.setText("");
        jLabelDataNascimento.setText("");
        jLabelSexo.setText("");
    }//GEN-LAST:event_jButtonExcluirClienteActionPerformed

    private void jTextFieldValorLocadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldValorLocadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldValorLocadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton jButtonAlteraCliente;
    private javax.swing.JToggleButton jButtonBuscaClienteCPF1;
    private javax.swing.JToggleButton jButtonCancelarVoltarLocacao;
    private javax.swing.JToggleButton jButtonExcluirCliente;
    private javax.swing.JToggleButton jButtonNovoCliente;
    private javax.swing.JToggleButton jButtonSalvarLocacao;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAgencia;
    private javax.swing.JLabel jLabelBanco;
    private javax.swing.JLabel jLabelCPF;
    private javax.swing.JLabel jLabelConta;
    private javax.swing.JLabel jLabelDataNascimento;
    private javax.swing.JLabel jLabelImvBairro;
    private javax.swing.JLabel jLabelImvCep;
    private javax.swing.JLabel jLabelImvCidade;
    private javax.swing.JLabel jLabelImvEstado;
    private javax.swing.JLabel jLabelImvId;
    private javax.swing.JLabel jLabelImvNum;
    private javax.swing.JLabel jLabelImvQuartos;
    private javax.swing.JLabel jLabelImvRua;
    private javax.swing.JLabel jLabelImvTamanho;
    private javax.swing.JLabel jLabelImvTipo;
    private javax.swing.JLabel jLabelImvValor;
    private javax.swing.JLabel jLabelNomeCliente;
    private javax.swing.JLabel jLabelNovaLocacao;
    private javax.swing.JLabel jLabelOperacao;
    private javax.swing.JLabel jLabelSexo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelCliente;
    private javax.swing.JPanel jPanelComandosLocacao;
    private javax.swing.JPanel jPanelInfImovel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextFieldObs;
    private javax.swing.JTextField jTextFieldValorLocado;
    private com.toedter.calendar.JDateChooser jcDataFinal;
    // End of variables declaration//GEN-END:variables
}
