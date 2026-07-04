package ar.edu.unahur.obj2.cloud.componentes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.cloud.Cluster;
import ar.edu.unahur.obj2.cloud.Excepciones.OverprovisionException;
import ar.edu.unahur.obj2.cloud.comandos.Asignacion;
import ar.edu.unahur.obj2.cloud.comandos.Liberacion;

public class PlanificadorDeDespliguesTest {
    @Test
    void testEjecutarOperaciones() throws OverprovisionException {

        Cluster cluster0 = new Cluster("cp1", 350);

        PlanificaDespliegue plan = new PlanificaDespliegue();

        plan.agregarOperacion(new Asignacion(cluster0, 50));
        plan.agregarOperacion(new Liberacion(cluster0, 100));

        plan.ejecutar();

        assertEquals(400, cluster0.getVcpus());
    }

    @Test
    void alFallarUnaOperacionSeAnulanLasAnteriores() {

        Cluster cluster0 = new Cluster("cp1", 140);

        PlanificaDespliegue plan = new PlanificaDespliegue();

        plan.agregarOperacion(new Asignacion(cluster0, 50));
        plan.agregarOperacion(new Asignacion(cluster0, 300));

        assertThrows(OverprovisionException.class, () -> {
            plan.ejecutar();
        });

        assertEquals(140, cluster0.getVcpus());
    }

    @Test
    void deshacerPlanRevierteOperaciones() throws OverprovisionException {

        Cluster cluster = new Cluster("cp1", 140);

        PlanificaDespliegue plan = new PlanificaDespliegue();

        plan.agregarOperacion(new Asignacion(cluster, 50));

        plan.ejecutar();

        assertEquals(90, cluster.getVcpus());

        plan.deshacer();

        assertEquals(140, cluster.getVcpus());
    }
}
