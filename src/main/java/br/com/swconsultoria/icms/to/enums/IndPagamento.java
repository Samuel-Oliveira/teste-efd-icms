package br.com.swconsultoria.icms.to.enums;

public enum IndPagamento {

    A_VISTA("0"), A_PRAZO("1");

    private final String descricao;

    IndPagamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }
}