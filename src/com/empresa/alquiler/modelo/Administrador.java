package com.empresa.alquiler.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Administrador {
    private final List<Vehiculo> flota;

    public Administrador() {
        this.flota = new ArrayList<>();
    }

    public void añadirVehiculo(Vehiculo vehiculo) {
        flota.add(vehiculo);
        System.out.println("Vehículo añadido: " + vehiculo);
    }

    public boolean verificarDisponibilidad(Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin) {
        if (!flota.contains(vehiculo)) {
            return false;
        }

        if (!vehiculo.isDisponible()) {
            return false;
        }

        for (Reserva reserva : vehiculo.getReservas()) {
            if (reserva.isConfirmada()) {
                boolean fechaFinAntes = fechaFin.isBefore(reserva.getFechaInicio());
                boolean fechaInicioDespues = fechaInicio.isAfter(reserva.getFechaFin());
                if (!(fechaFinAntes || fechaInicioDespues)) {
                    return false;
                }
            }
        }

        return true;
    }

    public List<Vehiculo> listarVehiculosDisponibles() {
        List<Vehiculo> disponibles = new ArrayList<>();
        for (Vehiculo vehiculo : flota) {
            if (vehiculo.isDisponible()) {
                disponibles.add(vehiculo);
            }
        }
        return disponibles;
    }

    public List<Vehiculo> getFlota() {
        return flota;
    }

    public void mostrarFlota() {
        System.out.println("\n--- FLOTA DE VEHÍCULOS ---");
        for (Vehiculo vehiculo : flota) {
            String estado = vehiculo.isDisponible() ? "Disponible" : "No disponible";
            System.out.println(vehiculo + " - " + estado);
        }
    }
}