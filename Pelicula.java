package Model;

import java.io.Serializable;
import java.util.Objects;


public class Pelicula implements Comparable<Pelicula>, CSVSerializable, Serializable {

    private static final long serialVersionUID = 1L; 
    private final int id;
    private final String titulo;
    private final String director;
    private final Genero genero;

    public Pelicula(int id, String titulo, String director, Genero genero) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDirector() {
        return director;
    }

    public Genero getGenero() {
        return genero;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Pelicula p)){
            return false;
        }
        return this.id == p.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    
    @Override
    public int compareTo(Pelicula otra) {
        return Integer.compare(this.id, otra.id); // Orden natural por ID
    }

    @Override
    public String toString() {
        return "PELICULA = " + titulo +
                " | ID = " + id +
                " | TITULO = '" + titulo + '\'' +
                " | DIRECTOR = '" + director + '\'' +
                " | GENERO = " + genero;
    }

    @Override
    public String toCSV() { 
        return id + "," + titulo + "," + director + "," + genero;
    }

    public static Pelicula fromCSV(String linea) { // Implementación del método estático fromCSV(String)
        if (linea.endsWith("\n")) {
            linea = linea.substring(0, linea.length() - 1);
        }
        String[] partes = linea.split(",");
        if (partes.length == 4) {
            int id = Integer.parseInt(partes[0].trim());
            String titulo = partes[1].trim();
            String director = partes[2].trim();
            Genero genero = Genero.valueOf(partes[3].strip());

            return new Pelicula(id, titulo, director, genero);
        }
        return null; // Retorna null si el formato es inválido
    }

    public static String toCSVHeader() {
        return "ID,TITULO,DIRECTOR,GENERO";
    }
}
