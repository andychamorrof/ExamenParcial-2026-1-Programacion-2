package modelo;

import java.util.Date;

public class Postulacion {

    private Date fecha;
    private boolean anulado;
    private Date fechaAnulacion;

    public Postulacion() {
        this.fecha = new Date();
        this.anulado = false;
        this.fechaAnulacion = null;
    }

    public boolean anular() {
        if (!this.anulado) {
            this.anulado = true;
            this.fechaAnulacion = new Date();
            return true;
        }

        return false;
    }

    public Date getFecha() {
        return fecha;
    }

    public boolean isAnulado() {
        return anulado;
    }

    public Date getFechaAnulacion() {
        return fechaAnulacion;
    }

    @Override
    public String toString() {
        if (this.anulado) {
            return "Postulacion (Fecha = " + fecha + ", estado = Anulado)";
        } 
        else {
            return "Postulacion (Fecha = " + fecha + ", estado = Activo)";
        }
    }
}
