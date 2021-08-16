package utp.misiontic2022.c2.p47.reto4.controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import utp.misiontic2022.c2.p47.reto4.modelo.dao.Requerimiento_1Dao;
import utp.misiontic2022.c2.p47.reto4.modelo.dao.Requerimiento_2Dao;
import utp.misiontic2022.c2.p47.reto4.modelo.dao.Requerimiento_3Dao;
import utp.misiontic2022.c2.p47.reto4.modelo.vo.Requerimiento_1;
import utp.misiontic2022.c2.p47.reto4.modelo.vo.Requerimiento_2;
import utp.misiontic2022.c2.p47.reto4.modelo.vo.Requerimiento_3;

public class ControladorRequerimientos{

    Requerimiento_1Dao r1Dao = new Requerimiento_1Dao();
    Requerimiento_2Dao r2Dao = new Requerimiento_2Dao();
    Requerimiento_3Dao r3Dao = new Requerimiento_3Dao();
    // Su código
    
    public ArrayList<Requerimiento_1> consultarRequerimiento1() throws SQLException {
        return r1Dao.requerimiento1();
        // Su código
    }

    public ArrayList<Requerimiento_2> consultarRequerimiento2() throws SQLException {
        return r2Dao.requerimiento2();
        // Su código
    }

    public ArrayList<Requerimiento_3> consultarRequerimiento3() throws SQLException {
        return r3Dao.requerimiento3();
        // Su código
    }

}
