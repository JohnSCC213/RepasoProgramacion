package com.empresa.alquiler.modelo;

public class Autobus extends Vehiculo {
    private final int capacidadPasajeros;

    public Autobus(String idVehiculo, String marca, String modelo, int año,
                   double costoDiario, int capacidadPasajeros) {
        super(idVehiculo, marca, modelo, año, costoDiario);
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public String toString() {
        return super.toString() + " - Autobús " + capacidadPasajeros + " pasajeros";
    }
}