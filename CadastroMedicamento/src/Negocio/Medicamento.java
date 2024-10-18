package Negocio;

public class Medicamento {
    private String nome;
    private String principioAtivo;
    private String dataFabricacao;
    private String dataValidade;

    public Medicamento(String nome, String principioAtivo, String dataFabricacao, String dataValidade) {
        this.setNome(nome);
        this.setPrincipioAtivo(principioAtivo);
        this.setDataFabricacao(dataFabricacao);
        this.setDataValidade(dataValidade);
    }

    public Medicamento() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPrincipioAtivo() {
        return principioAtivo;
    }

    public void setPrincipioAtivo(String principioAtivo) {
        this.principioAtivo = principioAtivo;
    }

    public String getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(String dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    @Override
    public String toString() {
        return  "\nMedicamento ='" + nome + '\'' +
                ", Principio Ativo ='" + principioAtivo + '\'' +
                ", Fabricacao ='" + dataFabricacao + '\'' +
                ", Validade ='" + dataValidade;
    }
}

