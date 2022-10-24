package br.com.rafael.desafiotunts.entity.enums;

import lombok.Getter;

@Getter
public enum SituationEnum {

    REPROVADO_POR_NOTA("Reprovado por nota"),
    REPROVADO_POR_FALTA("Reprovado por falta"),
    EXAME_FINAL("Exame Final"),
    APROVADO("Aprovado");

    private String description;

    SituationEnum(String description) {
        this.description = description;
    }
}
