package br.com.franca.ShirtVirtual.enums;

public enum TipoEndereco {

    ENTREGA("Entrega"),
    COBRANCA("Cobrança");

    private String descricaoTipoEndereco;

     TipoEndereco(String descricaoTipoEndereco) {
        this.descricaoTipoEndereco=descricaoTipoEndereco;
    }

    public String getDescricaoTipoEndereco() {
        return descricaoTipoEndereco;
    }

    @Override
    public String toString() {
        return this.descricaoTipoEndereco;
    }
}