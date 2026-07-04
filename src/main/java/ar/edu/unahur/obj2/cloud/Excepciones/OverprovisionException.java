package ar.edu.unahur.obj2.cloud.Excepciones;

public class OverprovisionException extends Exception {

    public OverprovisionException() {
        super("Se excedio el límite de overprovisioning");
    }
    
}
