package br.com.swconsultoria.icms.to;

import lombok.Data;

/**
 * Classe TO de representação dos Participantes do Speed Fiscal
 *
 * @author Samuel Oliveira
 */
@Data
public class CadParticipantesTO {

    private String codPart;
    private String nome;
    private String cnpj;
    private String cpf;
    private String ie;
    private String codMun;
    private String endereco;
    private String numero;
    private String complemento;
    private String bairro;

}
