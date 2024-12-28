package Menu_P;
/*
Se desea gestionar las actividades de un campeonato de futbol. 
Para ello se necesitan controlar la información de los equipos de futbol, jugadores, dirigentes y partidos.
Se conoce que los equipos de futbol tienen nombre, categoría, presidentes y lista de jugadores. 
Hay 2 categorías de equipos, de primera y de segunda. Los de primera pueden inscribir un máximo de 24 jugadores 
y los de segunda tienen cupo libre, pero ambos como mínimo deben inscribir 11 jugadores.

Los jugadores, árbitros y dirigentes deben tener los datos básicos. Jugadores tienen posición en la que juegan,
cantidad de goles, cantidad de tarjetas amarillas y rojas, minutos jugados, así como la fecha de contrato. 
Los dirigentes tienen fecha de elección, patrimonio en dólares y cargo (presidente, vicepresidente, vocal, etc).
Se debe organizar y gestionar los resultados de los partidos, para lo cual se ingresan los equipos que juegan,
el marcador del partido, las tarjetas por equipo. Esto afecta al registro de cada jugador.
Dentro de las consultas que se puedan realizar están la tabla de posiciones, la lista de jugadores por equipos
y la lista de equipos participantes.

Considere lo siguiente:
- Al crear un equipo este debe tener dirigente.
- Puede crear dirigentes sin equipo.
- Todo jugador debe pertenecer a un equipo.

Desarrolle una aplicación GUI o de consola en java con un diseño CRUD para gestionar los jugadores, equipos, dirigentes, 
árbitros y partidos.

Para el enunciado anterior:
- Realice el modelo UML orientado a objeto.
- Declare las clases.
- Desarrolle una aplicación GUI (calificación máxima 10) o de consola (calificación máxima 8) en java.

Entregables del proyecto:
1. Documento PDF con UML orientado a objeto.
2. Archivos .java con las clases.
*/
//import java.util.Date;
import java.util.List;
import java.util.ArrayList;


class V_Equipo {
    private String nombre;
    private String categoria;
    private Dirigente presidente;
    private List<V_Jugador> jugadores;

    public V_Equipo(String nombre, String categoria, Dirigente presidente) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.presidente = presidente;
        this.jugadores = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Dirigente getPresidente() {
        return presidente;
    }

    public void setPresidente(Dirigente presidente) {
        this.presidente = presidente;
    }

    public List<V_Jugador> getJugadores() {
        return jugadores;
    }

    public boolean agregarJugador(V_Jugador jugador) {
        if (categoria.equals("Primera") && jugadores.size() >= 24) {
            System.out.println("El equipo ya tiene el máximo permitido de jugadores.");
            return false;
        }
        jugadores.add(jugador);
        return true;
    }
}

