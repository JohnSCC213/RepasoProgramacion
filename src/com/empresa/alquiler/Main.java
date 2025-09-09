package com.empresa.alquiler;

import com.empresa.alquiler.modelo.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE ALQUILER DE VEHÍCULOS ===");

        Administrador admin = new Administrador();

        System.out.println("\n1. AÑADIENDO VEHÍCULOS A LA FLOTA:");
        admin.añadirVehiculo(new Auto("A001", "Toyota", "Corolla", 2022, 50.0, "Gasolina"));
        admin.añadirVehiculo(new Moto("M001", "Honda", "CBR600", 2023, 30.0, 600));
        admin.añadirVehiculo(new Camioneta("C001", "Ford", "Ranger", 2022, 80.0, 1000));
        admin.añadirVehiculo(new Autobus("B001", "Mercedes", "Sprinter", 2021, 120.0, 20));

        System.out.println("\n2. CREANDO CLIENTE:");
        Cliente cliente = new Cliente("Juan Perez");
        System.out.println("Cliente creado: " + cliente);

        System.out.println("\n3. VEHÍCULOS DISPONIBLES:");
        admin.mostrarFlota();

        System.out.println("\n4. REALIZANDO RESERVA:");
        try {
            Vehiculo camioneta = admin.getFlota().get(2);
            cliente.reservarVehiculo(camioneta,
                    LocalDate.now().plusDays(1),
                    LocalDate.now().plusDays(6),
                    false,
                    true);
        } catch (Exception e) {
            System.out.println("Error en la reserva: " + e.getMessage());
        }

        System.out.println("\n5. ESTADO ACTUAL DE LA FLOTA:");
        admin.mostrarFlota();

        System.out.println("\n6. INTENTANDO RESERVAR VEHÍCULO NO DISPONIBLE:");
        try {
            Vehiculo mismaCamioneta = admin.getFlota().get(2);
            cliente.reservarVehiculo(mismaCamioneta,
                    LocalDate.now().plusDays(7),
                    LocalDate.now().plusDays(10),
                    true, true);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n7. VERIFICANDO DISPONIBILIDAD:");
        Vehiculo auto = admin.getFlota().get(0);
        boolean disponible = admin.verificarDisponibilidad(auto,
                LocalDate.now().plusDays(1),
                LocalDate.now().plusDays(3));
        System.out.println("Auto disponible: " + disponible);

        System.out.println("\n=== PROGRAMA EJECUTADO CON ÉXITO ===");
    }
}