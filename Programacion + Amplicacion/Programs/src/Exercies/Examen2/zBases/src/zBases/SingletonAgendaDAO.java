package zBases;

import java.sql.*;

public class SingletonAgendaDAO {

	private static Connection conn = null;



    private SingletonAgendaDAO() {


         String url = "jdbc:mariadb://localhost:3306/retroplay_db";
         String usuario = "programacion1";
         String password = "programacion1";

         try{

             conn = DriverManager.getConnection(url, usuario, password);
         }
         catch(SQLException e){
                e.printStackTrace();
            }
        } // Fin constructor

        // Métodos
        public static Connection getConnection() {


            try {
                if (conn == null || conn.isClosed()) {
                    new SingletonAgendaDAO();
                    crearTablaSiNoExiste();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return conn;
        }




        private static void crearTablaSiNoExiste() {
            String sql = "CREATE TABLE IF NOT EXISTS videojuegos(" 
                    +"idJuego INT AUTO_INCREMENT PRIMARY KEY," 
                            + "titulo VARCHAR(50)," 
                    + "plataforma VARCHAR(50)," 
                            + "precio DECIMAL(6,2)," +
                    "stock INT)";
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(sql);
            } catch (SQLException e) {
                System.out.println("Error al inicializar la tabla de contactos");
            }
        }

        public static void cerrado() {

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // Habría que hacerlo con DAOException
                    System.err.println("Error al cerrar conexión");
                }
            }

        }
}