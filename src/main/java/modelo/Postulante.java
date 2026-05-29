package modelo;

import java.util.Date;

public class Postulante {
    private String email;
    private String nombres;
    private String apellidos;
    private String direccion;
    private Date nacimiento;
    private String clave;
    private GradoEstudio gradoEstudio;

    private Postulacion[] postulaciones;
    private Oferta[] ofertasPostuladas;
    private int totalPostulaciones;

    public Postulante(String email, String nombres, String apellidos, String direccion, Date nacimiento) {
        this.email = email;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.nacimiento = nacimiento;
        
        this.clave = clave;
        this.postulaciones = new Postulacion[100];
        this.ofertasPostuladas = new Oferta[100];
        this.totalPostulaciones = 0;
    }

    public boolean asignarGradoEstudio(GradoEstudio grado) {
        this.gradoEstudio = grado;
        return true;
    }
    
    public boolean postular(Oferta oferta) {
        if (totalPostulaciones >= postulaciones.length) {
            return false;
        }
        
        postulaciones[totalPostulaciones] = new Postulacion();
        ofertasPostuladas[totalPostulaciones] = oferta;
        totalPostulaciones++;
        
        return true;
    }

    public boolean anularPostulacion(Postulacion p) {
        for (int i = 0; i < totalPostulaciones; i++){
            if (postulaciones[i] == p) {
                return postulaciones[i].anular();
            }
        }

        return false;
    }

    public Postulacion[] getPostulaciones() {
        Postulacion[] res = new Postulacion[totalPostulaciones];
        
        for (int i = 0; i < totalPostulaciones; i++) {
            res[i] = postulaciones[i];
        }
        
        return res;
    }

    public String getEmail() { 
        return email; 
    }
    
    public String getNombres() { 
        return nombres; 
    }
    
    public String getApellidos() { 
        return apellidos; 
    }
    
    public String getClave() { 
        return clave; 
    }
    
    public GradoEstudio getGradoEstudio() { 
        return gradoEstudio; 
    }

    @Override
    public String toString() { 
        return nombres + " " + apellidos + " | " + email; 
    }
}
    