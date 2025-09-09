package com.empresa.alquiler.modelo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {
    private static int contadorReservas = 1;

    private String idReserva;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double costoTotal;
    private boolean seguro;
    private boolean gps;
    private boolean confirmada;

    public Reserva(Cliente cliente, Vehiculo vehiculo, LocalDate fechaInicio,
                   LocalDate fechaFin, boolean seguro, boolean gps) {
        this.idReserva = "RES" + contadorReservas++;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.seguro = seguro;
        this.gps = gps;
        this.confirmada = false;
    }

    public void confirmarReserva() {
        if (!vehiculo.isDisponible()) {
            throw new IllegalStateException("El vehículo no está disponible");
        }

        if (fechaInicio.isAfter(fechaFin)) {
            throw new IllegalArgumentException("La fecha de inicio debe ser anterior a la fecha de fin");
        }

        int dias = (int) ChronoUnit.DAYS.between(fechaInicio, fechaFin);
        this.costoTotal = vehiculo.calcularPrecio(dias, seguro, gps);

        vehiculo.setDisponibilidad(false);
        vehiculo.agregarReserva(this);
        this.confirmada = true;

        System.out.println("Reserva confirmada: " + idReserva);
        System.out.println("Costo total: $" + costoTotal);
    }

    public String getIdReserva() {
        return idReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public boolean isConfirmada() {
        return confirmada;
    }

    public String toString() {
        return "Reserva " + idReserva + " - " + vehiculo.getMarca() + " " +
                vehiculo.getModelo() + " (" + fechaInicio + " a " + fechaFin + ")";
    }
}