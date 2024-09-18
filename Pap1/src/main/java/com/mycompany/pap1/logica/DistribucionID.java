package com.mycompany.pap1.logica;

import java.io.Serializable;
import java.util.Objects;

public class DistribucionID implements Serializable {
    private Beneficiario beneficiario;
    private Donacion donacion;         

    // Default constructor
    public DistribucionID() {}

    // Getters and Setters
    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }

    public Donacion getDonacion() {
        return donacion;
    }

    public void setDonacion(Donacion donacion) {
        this.donacion = donacion;
    }

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DistribucionID that = (DistribucionID) o;
        return donacion == that.donacion && Objects.equals(beneficiario, that.beneficiario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beneficiario, donacion);
    }
}