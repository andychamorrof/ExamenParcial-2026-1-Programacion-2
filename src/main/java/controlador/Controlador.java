package controlador;

import modelo.*;
import vista.Vista;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Controlador {
    private Vista v = new Vista();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Rubro[]      rubros      = new Rubro[20];
    private Cliente[]    clientes    = new Cliente[50];
    private Postulante[] postulantes = new Postulante[100];
    private Oferta[]     ofertas     = new Oferta[100];
    private GradoEstudio[] grados    = {
        new GradoEstudio("Secundaria"), new GradoEstudio("Tecnico"),
        new GradoEstudio("Universitario"), new GradoEstudio("Maestria")
    };

    private int nRubros=0, nClientes=0, nPostulantes=0, nOfertas=0;

    public void iniciar() {
        int op;
        do {
            op = v.menu("RECLUTAMIENTO TI", new String[]{
                "Salir","Rubros","Clientes","Candidatos","Ofertas","Postular"
            });
            switch(op) {
                case 1: menuRubros();       break;
                case 2: menuClientes();     break;
                case 3: menuCandidatos();   break;
                case 4: menuOfertas();      break;
                case 5: postular();         break;
            }
        } while(op != 0);
    }

    private void menuRubros() {
        int op = v.menu("RUBROS", new String[]{"Volver","Registrar","Listar"});
        if (op == 1) { rubros[nRubros++] = new Rubro(v.pedir("Nombre")); v.mensaje("Rubro registrado"); }
        if (op == 2) v.listar(rubros, "Rubros");
    }

    private void menuClientes() {
        int op = v.menu("CLIENTES", new String[]{"Volver","Registrar","Listar","Agregar Oferta"});
        if (op == 1) registrarCliente();
        if (op == 2) v.listar(clientes, "Clientes");
        if (op == 3) agregarOferta();
    }

    private void registrarCliente() {
        v.listar(rubros, "Rubros");
        int ir = Integer.parseInt(v.pedir("Indice rubro"));
        Cliente c = new Cliente(
            v.pedir("RUC"), v.pedir("Razon Social"), v.pedir("Email"),
            v.pedir("Contacto"), v.pedir("Telefono"), rubros[ir]
        );
        clientes[nClientes++] = c;
        v.mensaje("Cliente registrado | Clave: " + c.getClave());
    }

    private void agregarOferta() {
        v.listar(clientes, "Clientes");
        int ic = Integer.parseInt(v.pedir("Indice cliente"));
        try {
            Date fi = sdf.parse(v.pedir("Fecha inicio (dd/MM/yyyy)"));
            Date ft = sdf.parse(v.pedir("Fecha termino (dd/MM/yyyy)"));
            Oferta o = new Oferta(
                v.pedir("Puesto"), v.pedir("Descripcion"),
                v.pedir("Area"), fi, ft
            );
            clientes[ic].agregarOferta(o);
            ofertas[nOfertas++] = o;
            v.mensaje("Oferta agregada");
        } catch(Exception e) { v.mensaje("Fecha invalida"); }
    }

    private void menuCandidatos() {
        int op = v.menu("CANDIDATOS", new String[]{"Volver","Registrar","Listar","Asignar Grado"});
        if (op == 1) registrarCandidato();
        if (op == 2) v.listar(postulantes, "Candidatos");
        if (op == 3) asignarGrado();
    }

    private void registrarCandidato() {
        try {
            Date nac = sdf.parse(v.pedir("Nacimiento (dd/MM/yyyy)"));
            Postulante p = new Postulante(
                v.pedir("Email"), v.pedir("Nombres"), v.pedir("Apellidos"),
                v.pedir("Direccion"), nac
            );
            postulantes[nPostulantes++] = p;
            v.mensaje("Candidato registrado | Clave: " + p.getClave());
        } catch(Exception e) { v.mensaje("Fecha invalida"); }
    }

    private void asignarGrado() {
        v.listar(postulantes, "Candidatos");
        int ip = Integer.parseInt(v.pedir("Indice candidato"));
        v.listar(grados, "Grados");
        int ig = Integer.parseInt(v.pedir("Indice grado"));
        postulantes[ip].asignarGradoEstudio(grados[ig]);
        v.mensaje("Grado asignado");
    }

    private void menuOfertas() {
        int op = v.menu("OFERTAS", new String[]{"Volver","Listar activas","Agregar requisito"});
        if (op == 1) {
            for (int i = 0; i < nOfertas; i++)
                if (ofertas[i].estaActiva()) System.out.println("["+i+"] "+ofertas[i]);
        }
        if (op == 2) {
            v.listar(ofertas, "Ofertas");
            int io = Integer.parseInt(v.pedir("Indice oferta"));
            ofertas[io].agregarRequisito(
                Integer.parseInt(v.pedir("Orden")), v.pedir("Descripcion requisito")
            );
            v.mensaje("Requisito agregado");
        }
    }

    private void postular() {
        v.listar(postulantes, "Candidatos");
        int ip = Integer.parseInt(v.pedir("Indice candidato"));

        for (int i = 0; i < nOfertas; i++)
            if (ofertas[i].estaActiva()) System.out.println("["+i+"] "+ofertas[i]);
        int io = Integer.parseInt(v.pedir("Indice oferta"));
        if (postulantes[ip].postular(ofertas[io]))
            v.mensaje("Postulacion registrada: " + new Date());
        else
            v.mensaje("No se pudo postular");
    }
}