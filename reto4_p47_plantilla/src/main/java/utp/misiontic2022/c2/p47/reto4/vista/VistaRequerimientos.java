package utp.misiontic2022.c2.p47.reto4.vista;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Container;
import utp.misiontic2022.c2.p47.reto4.controlador.ControladorRequerimientos;

import utp.misiontic2022.c2.p47.reto4.modelo.vo.Requerimiento_1;
import utp.misiontic2022.c2.p47.reto4.modelo.vo.Requerimiento_2;
import utp.misiontic2022.c2.p47.reto4.modelo.vo.Requerimiento_3;

public class VistaRequerimientos extends JFrame implements ActionListener{

    //La interfaz la hice sin netbeans, por eso esta medio feita :(

    public static final ControladorRequerimientos controlador = new ControladorRequerimientos();

    private Container contenedor;
    private JButton botonr1; 
    private JButton botonr2;
    private JButton botonr3; 

    public VistaRequerimientos() {
        contenedor = getContentPane();
        setSize(400, 500);
        setVisible(true);
        contenedor.setLayout(new GridLayout(2,1));

        //superior
        Container contenedorSuperior = new Container();
        contenedorSuperior.setLayout(new GridLayout(1,1));

        JLabel titulo = new JLabel("Proyectos de construccion");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Serif", Font.PLAIN, 30));
        contenedorSuperior.add(titulo);

        //inferior
        Container contenedorInferior = new Container();
        contenedorInferior.setLayout(new FlowLayout());

        Container contenedor1 = new Container();
        contenedor1.setLayout(new GridLayout(2,1));
        JLabel titulor1 = new JLabel("ID compras pagadas");
        botonr1 = new JButton("Obtener");
        botonr1.addActionListener(this);
        contenedor1.add(titulor1);
        contenedor1.add(botonr1);

        Container contenedor2 = new Container();
        contenedor2.setLayout(new GridLayout(2,1));
        JLabel titulor2 = new JLabel("ID compras cuyo precio de unidad es inferior a 1100");
        botonr2 = new JButton("Obtener");
        botonr2.addActionListener(this);
        contenedor2.add(titulor2);
        contenedor2.add(botonr2);

        Container contenedor3 = new Container();
        contenedor3.setLayout(new GridLayout(2,1));
        JLabel titulor3 = new JLabel("ID y año de compras pagadas parcialmente y en el mes 02");
        botonr3 = new JButton("Obtener");
        botonr3.addActionListener(this);
        contenedor3.add(titulor3);
        contenedor3.add(botonr3);

        contenedorInferior.add(contenedor1);
        contenedorInferior.add(contenedor2);
        contenedorInferior.add(contenedor3);

        contenedor.add(contenedorSuperior);
        contenedor.add(contenedorInferior);
    }

    public static void requerimiento1(){
        try {
            // Su código
            ArrayList<Requerimiento_1> lista = controlador.consultarRequerimiento1();
            Object listaFinal[][] = new Object[lista.size()][2];
            String titulos[] = {"ID's", "Pagada"};
            for(int i=0; i<lista.size(); i++){
                listaFinal[i][0] = lista.get(i).getId();
                listaFinal[i][1] = "Si";
            }
            JTable tabla = new JTable(listaFinal, titulos);
            JOptionPane.showMessageDialog(null, new JScrollPane(tabla));
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void requerimiento2(){
        try {
            // Su código
            ArrayList<Requerimiento_2> lista = controlador.consultarRequerimiento2();
            Object listaFinal[][] = new Object[lista.size()][2];
            String titulos[] = {"ID's", "Precio de unidad de material inferior a 1100"};
            for(int i=0; i<lista.size(); i++){
                listaFinal[i][0] = lista.get(i).getId();
                listaFinal[i][1] = "Si";
            }
            JTable tabla = new JTable(listaFinal, titulos);
            JOptionPane.showMessageDialog(null, new JScrollPane(tabla));
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void requerimiento3(){
        try {
            // Su código
            ArrayList<Requerimiento_3> lista = controlador.consultarRequerimiento3();
            Object listaFinal[][] = new Object[lista.size()][2];
            String titulos[] = {"ID", "Año"};
            for(int i=0; i<lista.size(); i++){
                listaFinal[i][0] = lista.get(i).getId();
                listaFinal[i][1] = lista.get(i).getFecha();
            }
            JTable tabla = new JTable(listaFinal, titulos);
            JOptionPane.showMessageDialog(null, new JScrollPane(tabla));
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botonr1){
            requerimiento1();
        }else if(e.getSource() == botonr2){
            requerimiento2();
        }else if(e.getSource() == botonr3){
            requerimiento3();
        }
    }

}
