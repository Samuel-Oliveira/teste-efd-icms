package br.com.swconsultoria.icms.to;

import br.com.swconsultoria.icms.to.enums.IndPagamento;
import br.com.swconsultoria.icms.to.enums.TipoFrete;
import br.com.swconsultoria.icms.to.enums.TipoOperacao;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class NotaEletronicaTo {

    //Dados Nota
    private Long numeroNota;
    private String chave;
    private String serie;
    private String modelo;
    private LocalDateTime dataNota;
    private TipoFrete tipoFrete;
    private TipoOperacao tipoOperacao;
    private IndPagamento indPagamento;
    private String cfop;
    private BigDecimal valor;

    //Dados Destinatario
    private String cpfCnpjDestinatario;
    private String nomeDestinatario;
    private String enderecoDestinatario;
    private String numeroEnderecoDestinatario;
    private String setorDestinatario;
    private String inscricaoEstadualDestinatario;
    private String cMunicipioDestinatario;
    private String complementoEnderecoDestinatario;
}
