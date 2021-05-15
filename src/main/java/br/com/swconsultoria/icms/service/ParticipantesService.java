package br.com.swconsultoria.icms.service;


import br.com.swconsultoria.icms.to.CadParticipantesTO;
import br.com.swconsultoria.icms.to.NotaEletronicaTo;

import java.util.ArrayList;
import java.util.List;

public class ParticipantesService {

    public static List<CadParticipantesTO> getListaParticipantes(List<NotaEletronicaTo> listaNotas) {
        List<CadParticipantesTO> participantes = new ArrayList<>();

        listaNotas.forEach(
                nota -> {
                    if (participantes.stream().noneMatch(p -> nota.getCpfCnpjDestinatario().equals(p.getCodPart()))) {
                        CadParticipantesTO part = new CadParticipantesTO();
                        part.setCodPart(nota.getCpfCnpjDestinatario());
                        if (nota.getCpfCnpjDestinatario().length() > 11) {
                            part.setCnpj(nota.getCpfCnpjDestinatario());
                        } else {
                            part.setCpf(nota.getCpfCnpjDestinatario());
                        }
                        part.setNumero(nota.getNumeroEnderecoDestinatario());
                        part.setNome(nota.getNomeDestinatario());
                        part.setIe(nota.getInscricaoEstadualDestinatario());
                        part.setEndereco(nota.getEnderecoDestinatario());
                        part.setComplemento(nota.getComplementoEnderecoDestinatario());
                        part.setCodMun(nota.getCMunicipioDestinatario());
                        part.setBairro(nota.getSetorDestinatario());
                        participantes.add(part);
                    }

                });
        return participantes;
    }
}
