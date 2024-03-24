package com.example.ejercicio_2_4_sharon_salazar.firmas;

public class firmas {
    private Integer id;
    private byte[] dfirma;
    private String descripcion;

    public firmas() {
    }

    public firmas(Integer id, byte[] dfirma, String descripcion) {
        this.id = id;
        this.dfirma = dfirma;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getDfirma() {
        return dfirma;
    }

    public void setDfirma(byte[] dfirma) {
        this.dfirma = dfirma;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}