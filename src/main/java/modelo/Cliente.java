package modelo;

public class Cliente {
    private String RUC;
    private String razonSocial;
    private String email;
    private String contacto;
    private String telefono;
    private String clave;

    private Oferta[] ofertas;
    private int totalOfertas;

    public Cliente(String RUC, String razonSocial, String email, String contacto, String telefono, Rubro rubro) {
        this.RUC = RUC;
        this.razonSocial = razonSocial;
        this.email = email;
        this.contacto = contacto;
        this.telefono = telefono;
        this.clave = clave;
        this.ofertas = new Oferta[50];
        this.totalOfertas = 0;
    }

    public boolean agregarOferta(Oferta o) {
        if (totalOfertas >= ofertas.length) {
            return false;
        }
        
        ofertas[totalOfertas++] = o;
        return true;
    }

    public boolean eliminarOferta(Oferta o) {
        for (int i = 0; i < totalOfertas; i++) {
            if (ofertas[i] == o) {
                for (int j = i; j < totalOfertas - 1; j++) {
                    ofertas[j] = ofertas[j + 1];
                }
                
                ofertas[--totalOfertas] = null;
                return true;
            }
        }
        return false;
    }

    public Oferta[] getOfertas() {
        Oferta[] res = new Oferta[totalOfertas];
        
        for (int i = 0; i < totalOfertas; i++) {
            res[i] = ofertas[i];
        }
        
        return res;
    }

    public String getRUC() { 
        return RUC; 
    }
    
    public String getRazonSocial() { 
        return razonSocial; 
    }
    
    public String getClave() { 
        return clave; 
    }

    @Override
    public String toString() { 
        return razonSocial + " | RUC: " + RUC; 
    }
}
