package ar.edu.unahur.obj2.cloud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.cloud.Excepciones.OverprovisionException;

public class ClusterTest {
    @Test
    public void creacionClusterYcomprobacionDeCapacidad() {
        Cluster cluster = new Cluster("cp5", 250);
        assertEquals(250, cluster.getVcpus());
    }

    @Test
    void modificacionDeCapacidadLuegoDeOperacionAsignar() throws Exception {

        Cluster cluster0 = new Cluster("cp1", 350);

        cluster0.asignar(50);

        assertEquals(300, cluster0.getVcpus());
    }

    @Test
    void modificacionDeCapacidadLuegoDeOperacionLiberar() throws Exception {

        Cluster cluster0 = new Cluster("cp1", 350);

        cluster0.liberar(50);

        assertEquals(400, cluster0.getVcpus());
    }

    @Test
    void pruebaDeErrorPorOverprovisionAlIntentarAsignar() {

        Cluster cluster0 = new Cluster("cp1", 30);

        assertThrows(OverprovisionException.class, () -> {
            cluster0.asignar(240);
        });

    }

    @Test
    void testGetVcpus() {

    }

}
