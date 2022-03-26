package com.project.reha.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString
public class ProcedureDto {

    private Long id;

    private String name;

    private String type;

    public ProcedureDto(Long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public ProcedureDto() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcedureDto that = (ProcedureDto) o;
        return name.equals(that.name) && type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }
}
