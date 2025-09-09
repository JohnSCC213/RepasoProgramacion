package com.empresa.alquiler.modelo;

public class Camioneta extends Vehiculo {
    private final double capacidadCarga;

    public Camioneta(String idVehiculo, String marca, String modelo, int año,
                     double costoDiario, double capacidadCarga) {
        super(idVehiculo, marca, modelo, año, costoDiario);
        this.capacidadCarga = capacidadCarga;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public String toString() {
        return super.toString() + " - Camioneta " + capacidadCarga + "kg";
    }
}