package modelo;

public class Rubro {
    private String nombre;
    private boolean estado;

    public Rubro(String nombre) {
        this.nombre = nombre;
        this.estado = true;
    }

    public boolean habilitar() {
        this.estado = true;
        return true;
    }

    public boolean deshabilitar() {
        this.estado = false;
        return true;
    }

    public String getNombre() { 
        return nombre; 
    }
    public boolean isEstado()  { 
        return estado; 
    }

    @Override
    public String toString() {
        if (this.estado) {
            return this.nombre + " [Activo]";
        } 
        else {
            return this.nombre + " [Inactivo]";
        }
    }
}
