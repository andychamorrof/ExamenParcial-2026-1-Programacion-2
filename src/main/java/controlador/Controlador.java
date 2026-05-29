package controlador;

import modelo.*;
import vista.Vista;
import java.text.SimpleDateFormat;

public class Controlador {
    private Vista v = new Vista();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Rubro[] rubros = new Rubro[20];
    private Cliente[] clientes = new Cliente[50];
    private Postulante[] postulantes = new Postulante[100];
    private Oferta[] ofertas = new Oferta[100];
    private GradoEstudio[] grados = {
        new GradoEstudio("Secundaria"), 
        new GradoEstudio("Tecnico"),
        new GradoEstudio("Universitario"), 
        new GradoEstudio("Maestria")
    };

    private int nRubros=0, nClientes=0, nPostulantes=0, nOfertas=0;

    public void iniciar() {
        int op;
        do {
            op = v.menu("RECLUTAMIENTO DE TI", new String[]{
                "Salir","Rubros","Clientes","Candidatos","Ofertas","Postular"
            });
            switch(op) {
                case 1: {
                    menuRubros();       
                    break;
                }
              
                case 2: {
                    menuClientes();     
                    break;
                }
                
                case 3: {
                    menuCandidatos();   
                    break;
                }
                 
                case 4: {
                    menuOfertas();      
                    break;
                }
                    
                case 5: {
                    postular();         
                    break;
                }
            }
        } while(op != 0);
    }

    private void menuRubros() {

    }

    private void menuClientes() {

    }

    private void menuCandidatos() {

    }

    private void menuOfertas() {

    }

    private void postular() {

    }
}
