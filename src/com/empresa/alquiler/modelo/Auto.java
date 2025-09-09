package com.empresa.alquiler.modelo;

public class Auto extends Vehiculo {
    private final String tipoCombustible;

    public Auto(String idVehiculo, String marca, String modelo, int año,
                double costoDiario, String tipoCombustible) {
        super(idVehiculo, marca, modelo, año, costoDiario);
        this.tipoCombustible = tipoCombustible;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public String toString() {
        return super.toString() + " - Auto " + tipoCombustible;
    }
}