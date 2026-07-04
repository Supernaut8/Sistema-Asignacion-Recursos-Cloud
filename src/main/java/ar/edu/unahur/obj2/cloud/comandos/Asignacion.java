package ar.edu.unahur.obj2.cloud.comandos;

import ar.edu.unahur.obj2.cloud.Cluster;
import ar.edu.unahur.obj2.cloud.Excepciones.OverprovisionException;

public class Asignacion implements Ejecutable {

    private Cluster cluster;
    private Integer cantidad;

    public Asignacion(Cluster cluster, Integer cantidad) {

        if (cantidad <= 0)
            throw new IllegalArgumentException();

        this.cluster = cluster;
        this.cantidad = cantidad;
    }

    @Override
    public void ejecutar() throws OverprovisionException {
        cluster.asignar(cantidad);
    }

    @Override
    public void deshacer() throws OverprovisionException {
        cluster.liberar(cantidad);
    }

}
