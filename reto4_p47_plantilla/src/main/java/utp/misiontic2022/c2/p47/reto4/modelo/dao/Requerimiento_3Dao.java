package utp.misiontic2022.c2.p47.reto4.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utp.misiontic2022.c2.p47.reto4.modelo.vo.Requerimiento_3;
import utp.misiontic2022.c2.p47.reto4.util.JDBCUtilities;

public class Requerimiento_3Dao {
    Connection conn;

    public ArrayList<Requerimiento_3> requerimiento3() throws SQLException {
        conn = JDBCUtilities.getConnection();
        ResultSet rs = null;
        Statement stmt = null;
        String sql = "SELECT ID_Compra , STRFTIME('%Y',Fecha ) fecha from Compra c where Pagado = 'Parcialmente' AND Fecha LIKE '%-02-%'";
        List<Requerimiento_3> comprasFechas02 = new ArrayList<Requerimiento_3>();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Requerimiento_3 r1 = new Requerimiento_3(rs.getInt("ID_Compra"), rs.getString("fecha"));
                comprasFechas02.add(r1);
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
        return (ArrayList<Requerimiento_3>) comprasFechas02;
        // Su código
    }
}