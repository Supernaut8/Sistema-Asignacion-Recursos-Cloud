package ar.edu.unahur.obj2.cloud;

import ar.edu.unahur.obj2.cloud.Excepciones.OverprovisionException;

public class Cluster {

    private final String ID;
    private Integer vcpus;

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
    } 

    public void liberar(Integer cantidad) {
        this.vcpus += cantidad;
    }

    
}

    