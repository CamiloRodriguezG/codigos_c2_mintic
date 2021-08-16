package utp.misiontic2022.c2.p47.reto4.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utp.misiontic2022.c2.p47.reto4.modelo.vo.Requerimiento_1;
import utp.misiontic2022.c2.p47.reto4.util.JDBCUtilities;

public class Requerimiento_1Dao {

    Connection conn;

    public ArrayList<Requerimiento_1> requerimiento1() throws SQLException {
        conn = JDBCUtilities.getConnection();
        ResultSet rs = null;
        Statement stmt = null;
        String sql = "SELECT * FROM Compra WHERE Pagado = 'Si'";
        List<Requerimiento_1> comprasPagadas = new ArrayList<Requerimiento_1>();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Requerimiento_1 r1 = new Requerimiento_1(rs.getInt("ID_Compra"));
                comprasPagadas.add(r1);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return (ArrayList<Requerimiento_1>) comprasPagadas;
        // Su código
    }
}