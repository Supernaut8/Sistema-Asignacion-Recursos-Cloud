package ar.edu.unahur.obj2.cloud.observadores;

import ar.edu.unahur.obj2.cloud.Movimiento;

public class FalsoObservador implements ObservadorCluster {
    private boolean notificado = false;

    @Override
    public void actualizar(Movimiento movimiento) {
        notificado = true;
    }

    public boolean fueNotificado() {
        return notificado;
    }
}
