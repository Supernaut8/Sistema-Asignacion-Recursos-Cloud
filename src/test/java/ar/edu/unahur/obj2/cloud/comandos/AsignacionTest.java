package ar.edu.unahur.obj2.cloud.comandos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.cloud.Cluster;
import ar.edu.unahur.obj2.cloud.Excepciones.OverprovisionException;

public class AsignacionTest {
    @Test
    void testEjecutarUnaAsignacionInvalida() {

        Cluster cluster0 = new Cluster("cp1", 350);

        assertThrows(IllegalArgumentException.class, ()-> {
            new Asignacion(cluster0, 0);
        });
    }

    @Test
    void testEjecutarAsignacionValida() throws OverprovisionException {

        Cluster cluster0 = new Cluster("cp1", 350);
        Ejecutable operacion = new Asignacion(cluster0, 30);

        operacion.ejecutar();
        assertEquals(320, cluster0.getVcpus());
    }
}
