package ar.edu.unahur.obj2.cloud;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.cloud.Excepciones.OverprovisionException;
import ar.edu.unahur.obj2.cloud.comandos.TipoMovimiento;
import ar.edu.unahur.obj2.cloud.observadores.ObservadorCluster;

public class Cluster {

    private final String ID;
    private Integer vcpus;

    private List<ObservadorCluster> observadores = new ArrayList<>();

    public Cluster(String iD, Integer vcpus) {
        ID = iD;
        this.vcpus = vcpus;
    }

    public String getID() {
        return ID;
    }

    public Integer getVcpus() {
        return vcpus;
    }

    public void asignar(Integer cantidad) throws OverprovisionException {
        if (vcpus - cantidad < - 200)
            throw new OverprovisionException();

        this.vcpus -= cantidad;
        informar(new Movimiento(TipoMovimiento.ASIGNACION));
    } 

    public void liberar(Integer cantidad) {
        this.vcpus += cantidad;
        informar(new Movimiento(TipoMovimiento.LIBERACION));
    }

    public void agregarObservador(ObservadorCluster observador) {
        observadores.add(observador);
    }

    public void eliminarObservador(ObservadorCluster observador) {
        observadores.remove(observador);
    }

    private void informar(Movimiento movimiento) {
        observadores.forEach(o -> o.actualizar(movimiento));
    }

    
}

    