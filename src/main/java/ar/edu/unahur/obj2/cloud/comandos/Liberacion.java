package ar.edu.unahur.obj2.cloud.comandos;

import ar.edu.unahur.obj2.cloud.Cluster;
import ar.edu.unahur.obj2.cloud.Excepciones.OverprovisionException;

public class Liberacion implements Ejecutable{
    
    private Cluster cluster;
    private Integer cantidad;

    public Liberacion(Cluster cluster, Integer cantidad) {
        this.cluster = cluster;
        this.cantidad = cantidad;
    }

    @Override
    public void ejecutar() throws OverprovisionException {
        cluster.liberar(cantidad);
    }

    @Override
    public void deshacer() throws OverprovisionException {
        cluster.asignar(cantidad);
    }
    
}
