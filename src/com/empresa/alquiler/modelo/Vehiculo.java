package com.empresa.alquiler.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehiculo {
    protected String idVehiculo;
    protected String marca;
    protected String modelo;
    protected int año;
    protected double costoDiario;
    protected boolean disponibilidad;
    protected List<Reserva> reservas;

    public Vehiculo(String idVehiculo, String marca, String modelo, int año, double costoDiario) {
        this.idVehiculo = idVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.costoDiario = costoDiario;
        this.disponibilidad = true;
        this.reservas = new ArrayList<>();
    }

    public double calcularPrecio(int dias, boolean seguro, boolean gps) {
        double costoBase = costoDiario * dias;
        double costoTotal = costoBase;

        if (seguro) {
            costoTotal += costoBase * 0.10;
        }

        if (gps) {
            costoTotal += 5 * dias;
        }

        return costoTotal;
    }

    public String getIdVehiculo() {
        return idVehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAño() {
        return año;
    }

    public double getCostoDiario() {
        return costoDiario;
    }

    public boolean isDisponible() {
        return disponibilidad;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public String toString() {
        return marca + " " + modelo + " (" + año + ") - $" + costoDiario + "/día";
    }
}