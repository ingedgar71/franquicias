package com.accenture.franquicias.persistence.entity;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table("branch")
public class BranchEntity {


    @Column("id_branch")
    private Integer idBranch;

    @Column("branch_name")
    private String branchName;

    @Column("id_franchise")
    private Integer idFranchise;

    public Integer getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(Integer idBranch) {
        this.idBranch = idBranch;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Integer getIdFranchise() {
        return idFranchise;
    }

    public void setIdFranchise(Integer idFranchise) {
        this.idFranchise = idFranchise;
    }
}
