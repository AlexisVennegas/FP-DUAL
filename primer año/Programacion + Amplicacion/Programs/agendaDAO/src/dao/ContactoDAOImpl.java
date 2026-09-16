package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexion.Singleton;
import modelo.Contacto;

public class ContactoDAOImpl implements ContactoDAO {
    private Connection conn; 

    public ContactoDAOImpl(Connection conn) { this.conn = conn; }

    @Override
    public void guardar(Contacto c) {
        String sql = "INSERT INTO contactos (nombre, telefono) VALUES (?, ?)";
        conn=Singleton.getInstance();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getTelefono());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Error al insertar contacto", e);
        }
    }

   
}
