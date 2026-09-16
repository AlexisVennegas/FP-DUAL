package testexamen1;

import java.util.List;

class Restaurante {
    private String nombre;
    private List<String> servicios;
    private int checkIn;
    private List<Reserva> reservas;

    public Restaurante(String nombre, List<String> servicios, int checkIn, List<Reserva> reservas) {
        this.nombre = nombre;
        this.servicios = servicios;
        this.checkIn = checkIn;
        this.reservas = reservas;
    }

    public String getNombre() { return nombre; }
    public List<String> getServicios() { return servicios; }
    public int getCheckIn() { return checkIn; }
    public List<Reserva> getReservas() { return reservas; }
}
