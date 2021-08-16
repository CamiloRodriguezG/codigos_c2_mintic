package utp.misiontic2022.c2.p47.reto4.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utp.misiontic2022.c2.p47.reto4.modelo.vo.Requerimiento_2;
import utp.misiontic2022.c2.p47.reto4.util.JDBCUtilities;

public class Requerimiento_2Dao {
    Connection conn;

    public ArrayList<Requerimiento_2> requerimiento2() throws SQLException {
        conn = JDBCUtilities.getConnection();
        ResultSet rs = null;
        Statement stmt = null;
        String sql = "SELECT * FROM Compra c join MaterialConstruccion mc on c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion where mc.Precio_Unidad < 1100";
        List<Requerimiento_2> comprasInf1100 = new ArrayList<Requerimiento_2>();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Requerimiento_2 r2 = new Requerimiento_2(rs.getInt("ID_Compra"));
                comprasInf1100.add(r2);
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
        return (ArrayList<Requerimiento_2>) comprasInf1100;
        // Su código
    }
}