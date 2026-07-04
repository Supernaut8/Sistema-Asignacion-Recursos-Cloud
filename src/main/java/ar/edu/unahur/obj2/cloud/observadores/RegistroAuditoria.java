package ar.edu.unahur.obj2.cloud.observadores;

import ar.edu.unahur.obj2.cloud.Movimiento;

public class RegistroAuditoria implements ObservadorCluster {

    @Override
    public void actualizar(Movimiento movimiento) {
        System.out.print(movimiento);
    }

}
