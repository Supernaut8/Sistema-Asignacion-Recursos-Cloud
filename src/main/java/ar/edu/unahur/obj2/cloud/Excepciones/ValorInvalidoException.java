package ar.edu.unahur.obj2.cloud.Excepciones;

public class ValorInvalidoException extends IllegalArgumentException {

    public ValorInvalidoException() {
        super("La cantidad debe ser mayor a 0");
    }
    
}
