/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
public class Cliente {
    private String CPF;
    private String Nome;
    private char Sexo;
    private String Nascimento;
    private int id;
    private String nascimentoDia;
    private String nascimentoMes;
    private String nascimentoAno;
    private String nomeBanco;
    private int numConta;
    private int numAgencia;
    private int operacao;
    public String getNomeBanco() {
        return nomeBanco;
    }
    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }
    public int getNumConta() {
        return numConta;
    }
    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }
    public int getNumAgencia() {
        return numAgencia;
    }
    public void setNumAgencia(int numAgencia) {
        this.numAgencia = numAgencia;
    }
    public int getOperacao() {
        return operacao;
    }
    public void setOperacao(int operacao) {
        this.operacao = operacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getCPF() {
        return CPF;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    public String getNome() {
        return Nome;
    }
    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    public char getSexo() {
        return Sexo;
    }
    public void setSexo(char Sexo) {
        this.Sexo = Sexo;
    }
    public String getNascimento() {
        return Nascimento;
    }
    public void setNascimento(String Nascimento) {
        this.Nascimento = Nascimento;
    }

    public String getNascimentoDia() {
        return nascimentoDia;
    }

    public void setNascimentoDia(String nascimentoDia) {
        this.nascimentoDia = nascimentoDia;
    }

    public String getNascimentoMes() {
        return nascimentoMes;
    }

    public void setNascimentoMes(String nascimentoMes) {
        this.nascimentoMes = nascimentoMes;
    }

    public String getNascimentoAno() {
        return nascimentoAno;
    }

    public void setNascimentoAno(String nascimentoAno) {
        this.nascimentoAno = nascimentoAno;
    }
    
}
