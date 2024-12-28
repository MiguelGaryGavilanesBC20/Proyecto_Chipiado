package Menu_P;

class Equipo extends Dirigente {
    private String nombre_e;
    private String dirigente;
     
    public Equipo(String nombre,String nombre_e,String dirigente){
        super(nombre);
        this.nombre_e = nombre_e;
        dirigente = nombre;
    }
    
    public String getNombre_e() {
        return nombre_e;
    }

    public void setNombre_e(String nombre_e) {
        this.nombre_e = nombre_e;
    }

    public String getDirigente() {
        return dirigente;
    }

    public void setDirigente(String dirigente) {
        this.dirigente = dirigente;
    }

}
