package ar.edu.unahur.obj2.cloud.componentes;

import ar.edu.unahur.obj2.cloud.Excepciones.OverprovisionException;
import ar.edu.unahur.obj2.cloud.comandos.Ejecutable;

public class PlanificadorDeDespligues {

    public void ejecutar(Ejecutable ejecutable) throws OverprovisionException {
        ejecutable.ejecutar();
    }
    
}
