package com.ecoenvio.test;

import com.ecoenvio.modelo.Cliente;
import com.ecoenvio.modelo.Dimensiones;
import com.ecoenvio.modelo.Envio;

public class EnvioTest {
    public static void main(String[] args) {
        Dimensiones dim = new Dimensiones(10.0, 10.0, 10.0);
        Cliente cli = new Cliente("Juan", "REGULAR");
        Envio envio = new Envio("E001", 3.0, 10.0, "EFECTIVO", dim, cli);
        double esperado = 5.00 + (0.50 * 10.0);
        if (envio.calcularCostoTotal() == esperado) {
            System.out.println("testCalculoEstandar: EXITOSO");
        } else {
            System.out.println("testCalculoEstandar: FALLIDO");
        }

        Dimensiones dim2 = new Dimensiones(100.0, 100.0, 10.0);
        Cliente cli2 = new Cliente("Ana", "REGULAR");
        Envio envio2 = new Envio("E002", 3.0, 10.0, "EFECTIVO", dim2, cli2);
        double esperado2 = (5.00 + (0.50 * 10.0)) + 15.00;
        if (envio2.calcularCostoTotal() == esperado2) {
            System.out.println("testVolumenExcedido: EXITOSO");
        } else {
            System.out.println("testVolumenExcedido: FALLIDO");
        }

        Dimensiones dim3 = new Dimensiones(10.0, 10.0, 10.0);
        Cliente cliPremium = new Cliente("Pedro", "PREMIUM");
        Envio envioPremium = new Envio("E003", 3.0, 100.0, "EFECTIVO", dim3, cliPremium);
        double basePremium = 5.00 + (0.50 * 100.0);
        double esperadoPremium = basePremium * 0.90;
        if (envioPremium.calcularCostoTotal() == esperadoPremium) {
            System.out.println("testMembresiaPremium: EXITOSO");
        } else {
            System.out.println("testMembresiaPremium: FALLIDO");
        }

        Cliente cliVip = new Cliente("Maria", "VIP");
        Envio envioVip = new Envio("E004", 3.0, 100.0, "EFECTIVO", dim3, cliVip);
        double baseVip = 5.00 + (0.50 * 100.0);
        double esperadoVip = baseVip * 0.80;
        if (envioVip.calcularCostoTotal() == esperadoVip) {
            System.out.println("testMembresiaVip: EXITOSO");
        } else {
            System.out.println("testMembresiaVip: FALLIDO");
        }

        Dimensiones dim4 = new Dimensiones(10.0, 10.0, 10.0);
        Cliente cli4 = new Cliente("Luis", "REGULAR");
        double base4 = 5.00 + (0.50 * 100.0);

        Envio envioTransferencia = new Envio("E005", 3.0, 100.0, "TRANSFERENCIA", dim4, cli4);
        double esperadoTransferencia = base4 * 0.95;
        if (envioTransferencia.calcularCostoTotal() == esperadoTransferencia) {
            System.out.println("testMetodoTransferencia: EXITOSO");
        } else {
            System.out.println("testMetodoTransferencia: FALLIDO");
        }

        Envio envioTarjeta = new Envio("E006", 3.0, 100.0, "TARJETA", dim4, cli4);
        double esperadoTarjeta = base4 * 1.03;
        if (envioTarjeta.calcularCostoTotal() == esperadoTarjeta) {
            System.out.println("testMetodoTarjeta: EXITOSO");
        } else {
            System.out.println("testMetodoTarjeta: FALLIDO");
        }

        Dimensiones dim5 = new Dimensiones(10.0, 10.0, 10.0);
        Cliente cli5 = new Cliente("Luis", "REGULAR");
        
        Envio envioPesoCero = new Envio("E007", 0.0, 10.0, "EFECTIVO", dim5, cli5);
        if (envioPesoCero.calcularCostoTotal() == 0.0) {
            System.out.println("testValidacionPesoCero: EXITOSO");
        } else {
            System.out.println("testValidacionPesoCero: FALLIDO");
        }
        
        Envio envioPagoInvalido = new Envio("E008", 3.0, 10.0, "CHEQUE", dim5, cli5);
        try {
            envioPagoInvalido.calcularCostoTotal();
            System.out.println("testExcepcionPagoInvalido: FALLIDO");
        } catch (IllegalArgumentException e) {
            System.out.println("testExcepcionPagoInvalido: EXITOSO");
        }
    }
}