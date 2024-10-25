package Negocio;

import java.time.LocalDate;

public class Medicamento {
    private int id;//ALTERAÇÃO
    private String nome;
    private String principioAtivo;
    private LocalDate dataFabricacao;
    private LocalDate dataValidade;

    public static int proximoIdMedicamento = 1; //ALTERAÇÃO

    public Medicamento(String nome, String principioAtivo, LocalDate dataFabricacao, LocalDate dataValidade) {

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

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getProximoIdMedicamento() {
        return proximoIdMedicamento++;
    }
    @Override
    public String toString() {
        return  "\nID ='" + id + '\'' +
                "Medicamento ='" + nome + '\'' +
                ", Principio Ativo ='" + principioAtivo + '\'' +
                ", Fabricacao ='" + dataFabricacao + '\'' +
                ", Validade ='" + dataValidade;
    }
}

