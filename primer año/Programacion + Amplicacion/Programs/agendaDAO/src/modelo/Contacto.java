package modelo;

public class Contacto {
    private int id;
    private String nombre;
    private String telefono;

    // Constructor para crear nuevos (sin ID)
    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

   
    // Getters y Setters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
}
