package ar.edu.unahur.obj2.cloud.componentes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ar.edu.unahur.obj2.cloud.Excepciones.OverprovisionException;
import ar.edu.unahur.obj2.cloud.comandos.Ejecutable;

public class PlanificaDespliegue implements Ejecutable {

    private List<Ejecutable> operaciones = new ArrayList<>();

    public void agregarOperacion (Ejecutable operacion) {
        this.operaciones.add(operacion);
    }



    @Override
    public void ejecutar() throws OverprovisionException {
        List<Ejecutable> ejecutadas = new ArrayList<>();

        try {
            for(Ejecutable operacion : operaciones) {
                operacion.ejecutar();
                ejecutadas.add(operacion);
            }

            
        }catch (OverprovisionException exception) {
            Collections.reverse(ejecutadas);

            for (Integer i = ejecutadas.size() - 1; i >= 0; i--) {
                ejecutadas.get(i).deshacer();
            }
            throw exception;
        }
        
    }

    @Override
    public void deshacer() throws OverprovisionException {
        for (Integer i = operaciones.size() - 1; i >= 0; i++) {
            operaciones.get(i).deshacer();
        }      
    }

}
