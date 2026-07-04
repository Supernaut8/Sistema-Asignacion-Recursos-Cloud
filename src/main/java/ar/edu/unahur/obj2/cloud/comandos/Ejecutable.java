package ar.edu.unahur.obj2.cloud.comandos;

import ar.edu.unahur.obj2.cloud.Excepciones.OverprovisionException;

public interface Ejecutable {

    void ejecutar() throws OverprovisionException;

    void deshacer() throws OverprovisionException;
}
