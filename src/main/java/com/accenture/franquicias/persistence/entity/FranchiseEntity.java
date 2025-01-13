package com.accenture.franquicias.persistence.entity;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("franchise")
public class FranchiseEntity {

    @Column("id_franchise")
    private Integer idFranchise;

    @Column("franchise_name")
    private String franchiseName;

    public Integer getIdFranchise() {
        return idFranchise;
    }

    public void setIdFranchise(Integer idFranchise) {
        this.idFranchise = idFranchise;
    }

    public String getFranchiseName() {
        return franchiseName;
    }

    public void setFranchiseName(String franchiseName) {
        this.franchiseName = franchiseName;
    }
}
