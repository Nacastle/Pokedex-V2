
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

    public TDA_Archivo() {
    }

    public TDA_Archivo(File Archivo) {
        this.Archivo = Archivo;
    }

    public void Agregar(Pokemon nuevo, int size) throws FileNotFoundException {
        Scanner revision = new Scanner(Archivo);
        revision.useDelimiter("☼");
        String direccion = "";
        while (revision.hasNext()) {
            String temporal = revision.next();
            Scanner escaner = new Scanner(temporal);
            escaner.useDelimiter("•");
            if (escaner.next().equals("1")) {
                Borrados.add(direccion.length());
                Sizes_Borrados.add(temporal.length());
            }
            direccion = direccion + "☼" + temporal;
        }
        int mayor = 0;
        int posicion = 0;
        if (Borrados.size() != 0) {
            mayor = Sizes_Borrados.get(0);
            posicion = Borrados.get(0);
            for (int i = 0; i < 10; i++) {
                if (Sizes_Borrados.get(i) > mayor) {
                    mayor = Sizes_Borrados.get(i);
                    posicion = Borrados.get(i);
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
                    nuevo_contenido = nuevo_contenido + "☼" + nuevo.getDisponible() + "•"
                            + nuevo.getNombre() + "•"
                            + nuevo.getApodo() + "•"
                            + nuevo.getDescripcion() + "•"
                            + nuevo.getAltura() + "•"
                            + nuevo.getCategoria() + "•"
                            + nuevo.getPeso() + "•"
                            + nuevo.getGenero() + "•";
                    for (int j = 0; j < nuevo.getHabilidades().size(); j++) {
                        nuevo_contenido = nuevo_contenido + nuevo.getHabilidades().get(j) + "○";
                    }
                    nuevo_contenido = nuevo_contenido + "•"
                            + nuevo.getHp() + "•"
                            + nuevo.getAtaque() + "•"
                            + nuevo.getDefensa() + "•"
                            + nuevo.getAtaque_Especial() + "•"
                            + nuevo.getDefensa_Especial() + "•"
                            + nuevo.getVelocidad() + "•"
                            + nuevo.getEvolucion() + "•"
                            + nuevo.getImagen() + "•";
                    for (int i = 0; i < nuevo.getDebilidades().size(); i++) {
                        nuevo_contenido = nuevo_contenido + nuevo.getDebilidades().get(i) + "○";
                    }
                    nuevo_contenido = nuevo_contenido + "•"
                            + nuevo.getTipo()[0] + "•"
                            + nuevo.getTipo()[1];

                    if (mayor != size) {
                        nuevo_contenido = nuevo_contenido + "1•";
                        for (int i = 0; i < mayor - size - 1; i++) {
                            nuevo_contenido = nuevo_contenido + " ";
                        }
                        nuevo_contenido = nuevo_contenido + "☼";
                        for (int i = 0; i < Borrados.size(); i++) {
                            if (posicion == Borrados.get(i)) {
                                Borrados.set(i, nuevo_contenido.length());
                                Sizes_Borrados.set(i, mayor - size);
                            }
                        }
                    } else {
                        for (int i = 0; i < Borrados.size(); i++) {
                            if (posicion == Borrados.get(i)) {
                                Borrados.remove(i);
                                Sizes_Borrados.remove(i);
                            }
                        }
                    }
                    String botar = contenido.next();
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
            nuevo_contenido = nuevo_contenido + "☼" + nuevo.getDisponible() + "•"
                    + nuevo.getNombre() + "•"
                    + nuevo.getApodo() + "•"
                    + nuevo.getDescripcion() + "•"
                    + nuevo.getAltura() + "•"
                    + nuevo.getCategoria() + "•"
                    + nuevo.getPeso() + "•"
                    + nuevo.getGenero() + "•";
            for (int j = 0; j < nuevo.getHabilidades().size(); j++) {
                nuevo_contenido = nuevo_contenido + nuevo.getHabilidades().get(j) + "○";
            }
            nuevo_contenido = nuevo_contenido + "•"
                    + nuevo.getHp() + "•"
                    + nuevo.getAtaque() + "•"
                    + nuevo.getDefensa() + "•"
                    + nuevo.getAtaque_Especial() + "•"
                    + nuevo.getDefensa_Especial() + "•"
                    + nuevo.getVelocidad() + "•"
                    + nuevo.getEvolucion() + "•"
                    + nuevo.getImagen() + "•";
            for (int i = 0; i < nuevo.getDebilidades().size(); i++) {
                nuevo_contenido = nuevo_contenido + nuevo.getDebilidades().get(i) + "○";
            }
            nuevo_contenido = nuevo_contenido + "•"
                    + nuevo.getTipo()[0] + "•"
                    + nuevo.getTipo()[1];
            FileWriter filewriter = null;
            BufferedWriter bufferedwriter = null;
            try {
                filewriter = new FileWriter(Archivo, false);
                bufferedwriter = new BufferedWriter(filewriter);
                bufferedwriter.write(nuevo_contenido);
            } catch (Exception e) {

            }
            JOptionPane.showMessageDialog(null, "Listo para embarcarte en una nueva Aventura");
        }

    }

    public int Buscar(Pokemon buscado) throws FileNotFoundException {
        Scanner contenido = new Scanner(Archivo);
        contenido.useDelimiter("☼");
        String direccion = "";
        int resultado = -1;
        while (contenido.hasNext()) {
            String temporal = contenido.next();
            Scanner revision = new Scanner(temporal);
            revision.useDelimiter("•");
            String disponible = revision.next();
            if (disponible.equals("0")) {
                String nombre = revision.next();
                String apodo = revision.next();
                if (nombre.equals(buscado.getNombre()) && apodo.equals(buscado.getApodo())) {
                    resultado = direccion.length();
                }
            }
            direccion = direccion + "☼" + temporal;
        }
        return resultado;
    }

    public ArrayList<Pokemon> Listar() throws FileNotFoundException {
        ArrayList<Pokemon> listados = new ArrayList<Pokemon>();
        Scanner contenido = new Scanner(Archivo);
        contenido.useDelimiter("☼");
        while (contenido.hasNext()) {
            Scanner revision = new Scanner(contenido.next());
            revision.useDelimiter("•");
            String disponible = revision.next();
            if (disponible.equals("0")) {
                String Nombre = revision.next();
                String Apodo = revision.next();
                String Descripcion = revision.next();
                double Altura = Double.parseDouble(revision.next());
                String Categoria = revision.next();
                double Peso = Double.parseDouble(revision.next());
                String genero = revision.next();
                Scanner hability = new Scanner(revision.next());
                ArrayList<String> Habilidades = new ArrayList<String>();
                hability.useDelimiter("○");
                while (hability.hasNext()) {
                    Habilidades.add(hability.next());
                }
                int Hp = Integer.parseInt(revision.next());
                int Ataque = Integer.parseInt(revision.next());
                int Defensa = Integer.parseInt(revision.next());
                int Ataque_Especial = Integer.parseInt(revision.next());
                int Defensa_Especial = Integer.parseInt(revision.next());
                int Velocidad = Integer.parseInt(revision.next());
                String Evolucion = revision.next();
                Object Imagen = revision.next();
                Scanner debil = new Scanner(revision.next());
                ArrayList<String> Debilidades = new ArrayList<String>();
                debil.useDelimiter("○");
                while (hability.hasNext()) {
                    Debilidades.add(debil.next());
                }
                String tipo[]=new String[2];
                tipo[0]=revision.next();
                tipo[1]=revision.next();
                Pokemon pokemon = new Pokemon(0, Nombre, Apodo, Descripcion, Altura, Categoria, Peso, genero, Hp, Ataque, Defensa, Ataque_Especial, Defensa_Especial, Velocidad, Evolucion, Imagen);
                pokemon.setHabilidades(Habilidades);
                pokemon.setDebilidades(Debilidades);
                pokemon.setTipo(tipo);
                listados.add(pokemon);
            }
        }
        return listados;
    }

    public void Borrar(Pokemon condenado) throws FileNotFoundException {
        Scanner contenido = new Scanner(Archivo);
        contenido.useDelimiter("☼");
        String nuevo_contenido = "";
        while (contenido.hasNext()) {
            String temporal = contenido.next();
            Scanner revision = new Scanner(temporal);
            revision.useDelimiter("•");
            String disponible = revision.next();
            if (disponible.equals("0")) {
                String nombre = revision.next();
                String apodo = revision.next();
                if (nombre.equals(condenado.getNombre()) && apodo.equals(condenado.getApodo())) {
                    nuevo_contenido = nuevo_contenido + "☼" + "1•" + condenado.getNombre() + "•"
                            + condenado.getApodo() + "•"
                            + condenado.getDescripcion() + "•"
                            + condenado.getAltura() + "•"
                            + condenado.getCategoria() + "•"
                            + condenado.getPeso() + "•"
                            + condenado.getGenero() + "•";
                    for (int j = 0; j < condenado.getHabilidades().size(); j++) {
                        nuevo_contenido = nuevo_contenido + condenado.getHabilidades().get(j) + "○";
                    }
                    nuevo_contenido = nuevo_contenido + "•"
                            + condenado.getHp() + "•"
                            + condenado.getAtaque() + "•"
                            + condenado.getDefensa() + "•"
                            + condenado.getAtaque_Especial() + "•"
                            + condenado.getDefensa_Especial() + "•"
                            + condenado.getVelocidad() + "•"
                            + condenado.getEvolucion() + "•"
                            + condenado.getImagen()+"•";
                    for (int i = 0; i < condenado.getDebilidades().size(); i++) {
                        nuevo_contenido = nuevo_contenido + condenado.getDebilidades().get(i) + "○";
                    }
                    nuevo_contenido = nuevo_contenido + "•"
                            +condenado.getTipo()[0]+"•"
                            +condenado.getTipo()[1];
                } else {
                    nuevo_contenido = nuevo_contenido + "☼" + temporal;
                }
            } else {
                nuevo_contenido = nuevo_contenido + "☼" + temporal;
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
    }

    public void Modificar(Pokemon Original, Pokemon modificado) throws FileNotFoundException {
        Scanner contenido = new Scanner(Archivo);
        contenido.useDelimiter("☼");
        String nuevo_contenido = "";
        while (contenido.hasNext()) {
            String temporal = contenido.next();
            Scanner revision = new Scanner(temporal);
            revision.useDelimiter("•");
            String disponible = revision.next();
            if (disponible.equals("0")) {
                String nombre = revision.next();
                String apodo = revision.next();
                if (nombre.equals(Original.getNombre()) && apodo.equals(Original.getApodo())) {
                    nuevo_contenido = nuevo_contenido + "☼" + "1•" + modificado.getNombre() + "•"
                            + modificado.getApodo() + "•"
                            + modificado.getDescripcion() + "•"
                            + modificado.getAltura() + "•"
                            + modificado.getCategoria() + "•"
                            + modificado.getPeso() + "•"
                            + modificado.getGenero() + "•";
                    for (int j = 0; j < modificado.getHabilidades().size(); j++) {
                        nuevo_contenido = nuevo_contenido + modificado.getHabilidades().get(j) + "○";
                    }
                    nuevo_contenido = nuevo_contenido + "•"
                            + modificado.getHp() + "•"
                            + modificado.getAtaque() + "•"
                            + modificado.getDefensa() + "•"
                            + modificado.getAtaque_Especial() + "•"
                            + modificado.getDefensa_Especial() + "•"
                            + modificado.getVelocidad() + "•"
                            + modificado.getEvolucion() + "•"
                            + modificado.getImagen()+"•";
                    for (int i = 0; i < modificado.getDebilidades().size(); i++) {
                        nuevo_contenido = nuevo_contenido + modificado.getDebilidades().get(i) + "○";
                    }
                    nuevo_contenido = nuevo_contenido + "•"
                            +modificado.getTipo()[0]+"•"
                            +modificado.getTipo()[1];
                } else {
                    nuevo_contenido = nuevo_contenido + "☼" + temporal;
                }
            } else {
                nuevo_contenido = nuevo_contenido + "☼" + temporal;
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
    }

    public void Compactar() throws FileNotFoundException {
        Scanner contenido = new Scanner(Archivo);
        contenido.useDelimiter("☼");
        String nuevo_contenido = "";
        while (contenido.hasNext()) {
            String temporal = contenido.next();
            Scanner revision = new Scanner(temporal);
            revision.useDelimiter("•");
            String disponible = revision.next();
            if (disponible.equals("0")) {
                nuevo_contenido = nuevo_contenido + "☼" + temporal;
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
    }

    public void Eliminar() {
        FileWriter filewriter = null;
        BufferedWriter bufferedwriter = null;
        try {
            filewriter = new FileWriter(Archivo, false);
            bufferedwriter = new BufferedWriter(filewriter);
            bufferedwriter.write("");
        } catch (Exception e) {

        }
    }

    public File getArchivo() {
        return Archivo;
    }

    public void setArchivo(File Archivo) {
        this.Archivo = Archivo;
    }

    public ArrayList<Integer> getBorrados() {
        return Borrados;
    }

    public void setBorrados(ArrayList<Integer> Borrados) {
        this.Borrados = Borrados;
    }

    public ArrayList<Integer> getSizes_Borrados() {
        return Sizes_Borrados;
    }

    public void setSizes_Borrados(ArrayList<Integer> Sizes_Borrados) {
        this.Sizes_Borrados = Sizes_Borrados;
    }

    @Override
    public String toString() {
        return "TDA_Archivo{" + "Archivo=" + Archivo + ", Borrados=" + Borrados + ", Sizes_Borrados=" + Sizes_Borrados + '}';
    }

}
