package Modelo;
public class Locacao {
    
    private int idLocacao;
    private String banco;
    private int numConta;
    private int agencia;
    private int operacao;
    private int diaDebito;
    private int idCliente;
    private double valorLocacao;
    private String dataFinalDia;
    private String dataFinalMes;
    private String dataFInalAno;
    private String DataFinal;

    Cliente cliente = new Cliente();

    public Cliente getCliente() {
        return cliente;
    }
    
    Imovel imovel = new Imovel();

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public int getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(int idLocacao) {
        this.idLocacao = idLocacao;
    }
    
    
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public String getBanco() {
        return banco;
    }
    public void setBanco(String banco) {
        this.banco = banco;
    }
    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }
    public int getAgencia() {
        return agencia;
    }
    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }
    public int getOperacao() {
        return operacao;
    }
    public void setOperacao(int operacao) {
        this.operacao = operacao;
    }
    public int getDiaDebito() {
        return diaDebito;
    }
    public void setDiaDebito(int diaDebito) {
        this.diaDebito = diaDebito;
    }
    public double getValorLocacao() {
        return valorLocacao;
    }
    public void setValorLocacao(double valorLocacao) {
        this.valorLocacao = valorLocacao;
    }

    public String getDataFinal() {
        return DataFinal;
    }

    public void setDataFinal(String DataFinal) {
        this.DataFinal = DataFinal;
    }

    public String getDataFinalDia() {
        return dataFinalDia;
    }

    public void setDataFinalDia(String dataFinalDia) {
        this.dataFinalDia = dataFinalDia;
    }

    public String getDataFinalMes() {
        return dataFinalMes;
    }

    public void setDataFinalMes(String dataFinalMes) {
        this.dataFinalMes = dataFinalMes;
    }

    public String getDataFInalAno() {
        return dataFInalAno;
    }

    public void setDataFInalAno(String dataFInalAno) {
        this.dataFInalAno = dataFInalAno;
    }

    
    
}
