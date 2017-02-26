
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Romero
 */
public class TDA_Archivo {

    File Archivo;
    private ArrayList<Integer> Borrados = new ArrayList();
    private ArrayList<Integer> Sizes_Borrados = new ArrayList();

    public TDA_Archivo(File Archivo) {
        this.Archivo = Archivo;
    }

    public void Agregar(User nuevo, int size) throws FileNotFoundException {
        int mayor = 0;
        int posicion = 0;
        if (Borrados.size() != 0) {
            mayor = (int) Sizes_Borrados.get(0);
            posicion = (int) Borrados.get(0);
            for (int i = 0; i < 10; i++) {
                if ((int) Sizes_Borrados.get(i) > mayor) {
                    mayor = (int) Sizes_Borrados.get(i);
                    posicion = (int) Borrados.get(i);
                }
            }
        }
        Scanner contenido = new Scanner(Archivo);
        contenido.useDelimiter("☼");
        if (mayor >= size) {
            String nuevo_contenido = "";
            while (contenido.hasNext()) {
                nuevo_contenido = nuevo_contenido + "☼" + contenido.next();
                if (nuevo_contenido.length() == posicion) {
                    nuevo_contenido = nuevo_contenido + "☼" + nuevo.getAge() + "♣" + nuevo.getName() + "♣" + nuevo.getUser() + "♣" + nuevo.getPassword() + "♣";
                    for (int i = 0; i < nuevo.getPokedex().size(); i++) {
                        nuevo_contenido = nuevo_contenido
                                + nuevo.getPokedex().get(i).getNombre() + "•"
                                + nuevo.getPokedex().get(i).getApodo() + "•"
                                + nuevo.getPokedex().get(i).getDescripcion() + "•"
                                + nuevo.getPokedex().get(i).getAltura() + "•"
                                + nuevo.getPokedex().get(i).getCategoria() + "•"
                                + nuevo.getPokedex().get(i).getPeso() + "•"
                                + nuevo.getPokedex().get(i).getGenero() + "•";
                        for (int j = 0; j < nuevo.getPokedex().get(i).getHabilidades().size(); j++) {
                            nuevo_contenido = nuevo_contenido + nuevo.getPokedex().get(i).getHabilidades().get(j) + "○";
                        }
                        nuevo_contenido = nuevo_contenido + "•"
                                + nuevo.getPokedex().get(i).getHp() + "•"
                                + nuevo.getPokedex().get(i).getAtaque() + "•"
                                + nuevo.getPokedex().get(i).getDefensa() + "•"
                                + nuevo.getPokedex().get(i).getAtaque_Especial() + "•"
                                + nuevo.getPokedex().get(i).getDefensa_Especial() + "•"
                                + nuevo.getPokedex().get(i).getVelocidad() + "•"
                                + nuevo.getPokedex().get(i).getEvolucion() + "•"
                                + nuevo.getPokedex().get(i).getImagen() + "♥";

                    }
                    nuevo_contenido = nuevo_contenido + "♣";
                    if (mayor != size) {
                        for (int i = 0; i < mayor - size; i++) {
                            nuevo_contenido = nuevo_contenido + " ";
                        }
                        nuevo_contenido = nuevo_contenido + "☼";
                        for (int i = 0; i < Borrados.size(); i++) {
                            if (posicion == (int) Borrados.get(i)) {
                                Borrados.set(i, nuevo_contenido.length());
                                Sizes_Borrados.set(i, mayor - size);
                            }
                        }
                    } else {
                        for (int i = 0; i < Borrados.size(); i++) {
                            if (posicion == (int) Borrados.get(i)) {
                                Borrados.remove(i);
                                Sizes_Borrados.remove(i);
                            }
                        }
                    }
                }
            }
            FileWriter filewriter = null;
            BufferedWriter bufferedwriter = null;
            try {
                filewriter = new FileWriter(Archivo, false);
                bufferedwriter = new BufferedWriter(filewriter);
                bufferedwriter.write(nuevo_contenido);
            } catch (Exception e) {

            }
        } else {
            String nuevo_contenido = "";
            while (contenido.hasNext()) {
                nuevo_contenido = nuevo_contenido + "☼" + contenido.next();
            }
            nuevo_contenido = nuevo_contenido + "☼" + nuevo.getAge() + "♣" + nuevo.getName() + "♣" + nuevo.getUser() + "♣" + nuevo.getPassword() + "♣";
            for (int i = 0; i < nuevo.getPokedex().size(); i++) {
                nuevo_contenido = nuevo_contenido
                        + nuevo.getPokedex().get(i).getNombre() + "•"
                        + nuevo.getPokedex().get(i).getApodo() + "•"
                        + nuevo.getPokedex().get(i).getDescripcion() + "•"
                        + nuevo.getPokedex().get(i).getAltura() + "•"
                        + nuevo.getPokedex().get(i).getCategoria() + "•"
                        + nuevo.getPokedex().get(i).getPeso() + "•"
                        + nuevo.getPokedex().get(i).getGenero() + "•";
                for (int j = 0; j < nuevo.getPokedex().get(i).getHabilidades().size(); j++) {
                    nuevo_contenido = nuevo_contenido + nuevo.getPokedex().get(i).getHabilidades().get(j) + "○";
                }
                nuevo_contenido = nuevo_contenido + "•"
                        + nuevo.getPokedex().get(i).getHp() + "•"
                        + nuevo.getPokedex().get(i).getAtaque() + "•"
                        + nuevo.getPokedex().get(i).getDefensa() + "•"
                        + nuevo.getPokedex().get(i).getAtaque_Especial() + "•"
                        + nuevo.getPokedex().get(i).getDefensa_Especial() + "•"
                        + nuevo.getPokedex().get(i).getVelocidad() + "•"
                        + nuevo.getPokedex().get(i).getEvolucion() + "•"
                        + nuevo.getPokedex().get(i).getImagen() + "♥";
            }
            nuevo_contenido = nuevo_contenido + "♣";
            FileWriter filewriter = null;
            BufferedWriter bufferedwriter = null;
            try {
                filewriter = new FileWriter(Archivo, false);
                bufferedwriter = new BufferedWriter(filewriter);
                bufferedwriter.write(nuevo_contenido);
            } catch (Exception e) {

            }
            JOptionPane.showMessageDialog(null,"Listo para embarcarte en una nueva Aventura");
        }

    }

    public int Buscar(User buscado) throws FileNotFoundException {
        Scanner contenido1 = new Scanner(Archivo);
        Scanner contenido2 = new Scanner(Archivo);
        return 0;
    }

    public void Listar() {

    }

    public void Borrar(User condenado) {

    }

    public void Modificar(User modificado) {

    }

    public void Compactar() {

    }

    public void Eliminar() {

    }
}
