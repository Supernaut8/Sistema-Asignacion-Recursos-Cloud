package ar.edu.unahur.obj2.cloud;

import ar.edu.unahur.obj2.cloud.comandos.TipoMovimiento;

public class Movimiento {

    private String clusterId;
    private TipoMovimiento tipo;
    private Integer cantidad;
    private Integer capacidadActual;


    public Movimiento(TipoMovimiento asignacion) {
    
    }
    public String getClusterId() {
        return clusterId;
    }
    public TipoMovimiento getTipo() {
        return tipo;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public Integer getCapacidadActual() {
        return capacidadActual;
    }

    
}
