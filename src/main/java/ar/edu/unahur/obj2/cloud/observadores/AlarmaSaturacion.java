package ar.edu.unahur.obj2.cloud.observadores;

import ar.edu.unahur.obj2.cloud.Movimiento;

public class AlarmaSaturacion implements ObservadorCluster {

    @Override
    public void actualizar(Movimiento movimiento) {
        if(movimiento.getCapacidadActual() < 0) {
            System.out.print("Alerta clúster operando en la zona de overprovisioning");
        };
    }

}
