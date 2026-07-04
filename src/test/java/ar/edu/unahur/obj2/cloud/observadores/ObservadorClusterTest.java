package ar.edu.unahur.obj2.cloud.observadores;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.cloud.Cluster;

public class ObservadorClusterTest {
    @Test
    void testActualizarNotificacion() {
        
        Cluster cluster0 = new Cluster("cp1", 140);

        FalsoObservador observador = new FalsoObservador();

        cluster0.agregarObservador(observador);

        cluster0.liberar(40);

        assertTrue(observador.fueNotificado());
    }
}
