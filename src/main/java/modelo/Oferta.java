package modelo;

import java.util.Date;

public class Oferta {
    private String puesto;
    private String descripcion;
    private String area;
    private Date fechaInicio;
    private Date fechaTermino;

    private Requisito[] requisitos;
    private int totalRequisitos;

    public Oferta(String puesto, String descripcion, String area, Date fechaInicio, Date fechaTermino) {
        this.puesto = puesto;
        this.descripcion = descripcion;
        this.area = area;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        
        this.requisitos = new Requisito[20];
        this.totalRequisitos = 0;
    }

    public boolean agregarRequisito(int orden, String desc) {
        if (totalRequisitos >= requisitos.length) {
            return false;
        }
        
        requisitos[totalRequisitos++] = new Requisito(orden, desc);
        
        return true;
    }

    public Requisito[] getRequisitos() {
        Requisito[] res = new Requisito[totalRequisitos];
        
        for (int i = 0; i < totalRequisitos; i++) res[i] = requisitos[i];{
            return res;
        }
    }

    public boolean eliminarRequisito(int orden) {
        for (int i = 0; i < totalRequisitos; i++) {
            if (requisitos[i].getOrden() == orden) {
                for (int j = i; j < totalRequisitos - 1; j++){
                    requisitos[j] = requisitos[j + 1];
                }
                
                requisitos[--totalRequisitos] = null;
                return true;
            }
        }
        return false;
    }

    public boolean estaActiva() {
        Date hoy = new Date();
        
        if (hoy.after(fechaInicio) && hoy.before(fechaTermino)) {
            return true;
        } 
        else {
            return false;
        }
    }

    public String getPuesto() { 
        return puesto; 
    }
    
    public String getArea() { 
        return area; 
    }
    
    public String getDescripcion() { 
        return descripcion; 
    }
    
    public Date getFechaInicio() { 
        return fechaInicio; 
    }
    
    public Date getFechaTermino() { 
        return fechaTermino; 
    }

    @Override
    public String toString() { 
        return puesto + " - " + area; 
    }
}
