package com.empresa.alquiler.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private static int contadorClientes = 1;

    private final String idCliente;
    private final String nombre;
    private final List<Reserva> reservas;

    public Cliente(String nombre) {
        this.idCliente = "CLI" + contadorClientes++;
        this.nombre = nombre;
        this.reservas = new ArrayList<>();
    }

    public void reservarVehiculo(Vehiculo vehiculo, LocalDate fechaInicio,
                                 LocalDate fechaFin, boolean seguro, boolean gps) {

        if (tieneReservaActiva()) {
            throw new IllegalStateException("El cliente ya tiene una reserva activa");
        }

        if (!vehiculo.isDisponible()) {
            throw new IllegalStateException("El vehículo no está disponible");
        }

        Reserva reserva = new Reserva(this, vehiculo, fechaInicio, fechaFin, seguro, gps);
        reserva.confirmarReserva();
        reservas.add(reserva);
    }

    private boolean tieneReservaActiva() {
        LocalDate hoy = LocalDate.now();
        for (Reserva reserva : reservas) {
            if (reserva.isConfirmada() && !hoy.isAfter(reserva.getFechaFin())) {
                return true;
            }
        }
        return false;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public String toString() {
        return nombre + " (" + idCliente + ")";
    }
}