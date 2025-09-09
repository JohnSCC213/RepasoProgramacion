package com.empresa.alquiler.modelo;

public class Moto extends Vehiculo {
    private final int cilindrada;

    public Moto(String idVehiculo, String marca, String modelo, int año,
                double costoDiario, int cilindrada) {
        super(idVehiculo, marca, modelo, año, costoDiario);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public String toString() {
        return super.toString() + " - Moto " + cilindrada + "cc";
    }
}