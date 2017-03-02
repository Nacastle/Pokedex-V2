
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
    File Borrados_file;

    public TDA_Archivo() {
    }

    public TDA_Archivo(File Archivo, File Borrados_file) {
        this.Archivo = Archivo;
        this.Borrados_file = Borrados_file;
        //this.cola();
    }

    public void Agregar(Pokemon nuevo, int size) throws FileNotFoundException {
        /* Scanner revision = new Scanner(Archivo);
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
        }*/
        Scanner disponible = new Scanner(Borrados_file);
        disponible.useDelimiter("☼");
        int mayor = 0;
        int posicion = 0;
        if (disponible.hasNext()) {
            Scanner caracteristica = new Scanner(disponible.next());
            caracteristica.useDelimiter(",");
            mayor = Integer.parseInt( caracteristica.next());
            posicion = Integer.parseInt( caracteristica.next());
        }

        /*
        if (Disponibles.getHeaptamaño() != 0) {
            String size_mayor = "" + ((Pokemon) Disponibles.get(0).getNodo()).getDisponible()
                    + ((Pokemon) Disponibles.get(0).getNodo()).getNombre()
                    + ((Pokemon) Disponibles.get(0).getNodo()).getApodo()
                    + ((Pokemon) Disponibles.get(0).getNodo()).getDescripcion()
                    + ((Pokemon) Disponibles.get(0).getNodo()).getAltura()
                    + ((Pokemon) Disponibles.get(0).getNodo()).getCategoria()
                    + ((Pokemon) Disponibles.get(0).getNodo()).getPeso()
                    + ((Pokemon) Disponibles.get(0).getNodo()).getGenero();
            for (int j = 0; j < ((Pokemon) Disponibles.get(0).getNodo()).getHabilidades().size(); j++) {
                size_mayor = size_mayor + ((Pokemon) Disponibles.get(0).getNodo()).getHabilidades().get(j);
            }
            size_mayor = size_mayor
                    + ((Pokemon) Disponibles.get(0).getNodo()).getHp()
                    + ((Pokemon) Disponibles.get(0).getNodo()).getAtaque()
                    + ((Pokemon) Disponibles.get(0).getNodo()).getDefensa()
                    + ((Pokemon) Disponibles.get(0).getNodo()).getAtaque_Especial()
                    + ((Pokemon) Disponibles.get(0).getNodo()).getDefensa_Especial()
                    + ((Pokemon) Disponibles.get(0).getNodo()).getVelocidad()
                    + ((Pokemon) Disponibles.get(0).getNodo()).getEvolucion()
                    + ((Pokemon) Disponibles.get(0).getNodo()).getImagen();
            for (int i = 0; i < ((Pokemon) Disponibles.get(0).getNodo()).getDebilidades().size(); i++) {
                size_mayor = size_mayor + ((Pokemon) Disponibles.get(0).getNodo()).getDebilidades().get(i);
            }
            size_mayor = size_mayor
                    + ((Pokemon) Disponibles.get(0).getNodo()).getTipo()[0]
                    + ((Pokemon) Disponibles.get(0).getNodo()).getTipo()[1];
            //
            mayor = size_mayor.length();
            posicion = Buscar(((Pokemon) Disponibles.get(0).getNodo()));
        }
         */
        Scanner contenido = new Scanner(Archivo);
        contenido.useDelimiter("☼");
        String borrados = "";
        if (mayor >= size) {
            System.out.println("1");
            String nuevo_contenido = "";
            while (contenido.hasNext()) {
                String temporal = contenido.next();
                nuevo_contenido = nuevo_contenido + "☼" + temporal;
                if (nuevo_contenido.length() == posicion) {
                    nuevo_contenido = nuevo_contenido + "☼";
                    String auxiliar = nuevo.getDisponible() + "•"
                            + nuevo.getNombre() + "•"
                            + nuevo.getApodo() + "•"
                            + nuevo.getDescripcion() + "•"
                            + nuevo.getAltura() + "•"
                            + nuevo.getCategoria() + "•"
                            + nuevo.getPeso() + "•"
                            + nuevo.getGenero() + "•";
                    for (int j = 0; j < nuevo.getHabilidades().size(); j++) {
                        auxiliar = auxiliar + nuevo.getHabilidades().get(j) + "○";
                    }
                    auxiliar = auxiliar + "•"
                            + nuevo.getHp() + "•"
                            + nuevo.getAtaque() + "•"
                            + nuevo.getDefensa() + "•"
                            + nuevo.getAtaque_Especial() + "•"
                            + nuevo.getDefensa_Especial() + "•"
                            + nuevo.getVelocidad() + "•"
                            + nuevo.getEvolucion() + "•"
                            + nuevo.getImagen() + "•";
                    for (int i = 0; i < nuevo.getDebilidades().size(); i++) {
                        auxiliar = auxiliar + nuevo.getDebilidades().get(i) + "○";
                    }
                    auxiliar = auxiliar + "•"
                            + nuevo.getTipo()[0] + "•"
                            + nuevo.getTipo()[1];
                    nuevo_contenido = nuevo_contenido + auxiliar;
                    /*if (mayor != size) {
                        nuevo_contenido = nuevo_contenido + "☼";
                        nuevo_contenido = nuevo_contenido + "1•" + posicion + "•" + posicion + "•0••0•••○•••••••••○••";
                        String relleno = "";
                        for (int i = 0; i < mayor - size - 5; i++) {
                            relleno = relleno + " ";
                        }
                        nuevo_contenido = nuevo_contenido + relleno;
                        
                        
                    }*/
                    String botar = contenido.next();
                }
                Scanner comprobacion = new Scanner(temporal);
                comprobacion.useDelimiter("•");
                if (comprobacion.next().equals("1")) {
                    borrados = borrados + "☼" + temporal;
                }

            }
            if (mayor != size) {

            } else {

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
            System.out.println("2");
            String nuevo_contenido = "";
            while (contenido.hasNext()) {
                String temporal = contenido.next();
                nuevo_contenido = nuevo_contenido + "☼" + temporal;
                Scanner comprobacion = new Scanner(temporal);
                comprobacion.useDelimiter("•");
                if (comprobacion.next().equals("1")) {
                    borrados = borrados + "☼" + temporal;
                }
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
            System.out.println(nuevo_contenido);
            FileWriter filewriter = null;
            BufferedWriter bufferedwriter = null;
            try {
                filewriter = new FileWriter(Archivo, false);
                bufferedwriter = new BufferedWriter(filewriter);
                bufferedwriter.write(nuevo_contenido);
                bufferedwriter.flush();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    filewriter.close();
                    bufferedwriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            JOptionPane.showMessageDialog(null, "Listo para embarcarte en una nueva Aventura");
        }
        FileWriter filewriter = null;
        BufferedWriter bufferedwriter = null;
        try {
            filewriter = new FileWriter(Borrados_file, false);
            bufferedwriter = new BufferedWriter(filewriter);
            bufferedwriter.write(borrados);
        } catch (Exception e) {

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
            String nombre = revision.next();
            String apodo = revision.next();
            if (nombre.equals(buscado.getNombre()) && apodo.equals(buscado.getApodo())) {
                resultado = direccion.length();
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
                String Imagen = revision.next();
                Scanner debil = new Scanner(revision.next());
                ArrayList<String> Debilidades = new ArrayList<String>();
                debil.useDelimiter("○");
                while (hability.hasNext()) {
                    Debilidades.add(debil.next());
                }
                String tipo[] = new String[2];
                tipo[0] = revision.next();
                tipo[1] = revision.next();
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

                    nuevo_contenido = nuevo_contenido + "☼";
                    int ubicacion = nuevo_contenido.length();
                    String borrado = "1•" + condenado.getNombre() + "•"
                            + condenado.getApodo() + "•"
                            + condenado.getDescripcion() + "•"
                            + condenado.getAltura() + "•"
                            + condenado.getCategoria() + "•"
                            + condenado.getPeso() + "•"
                            + condenado.getGenero() + "•";
                    for (int j = 0; j < condenado.getHabilidades().size(); j++) {
                        borrado = borrado + condenado.getHabilidades().get(j) + "○";
                    }
                    borrado = borrado + "•"
                            + condenado.getHp() + "•"
                            + condenado.getAtaque() + "•"
                            + condenado.getDefensa() + "•"
                            + condenado.getAtaque_Especial() + "•"
                            + condenado.getDefensa_Especial() + "•"
                            + condenado.getVelocidad() + "•"
                            + condenado.getEvolucion() + "•"
                            + condenado.getImagen() + "•";
                    for (int i = 0; i < condenado.getDebilidades().size(); i++) {
                        borrado = borrado + condenado.getDebilidades().get(i) + "○";
                    }
                    borrado = borrado + "•"
                            + condenado.getTipo()[0] + "•"
                            + condenado.getTipo()[1];

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
            bufferedwriter.flush();
        } catch (Exception e) {

        }
        Scanner actualizar = new Scanner(nuevo_contenido);
        actualizar.useDelimiter("☼");
        String borrados = "";
        while (actualizar.hasNext()) {
            String temporal = actualizar.next();
            Scanner revisar = new Scanner(temporal);
            revisar.useDelimiter("•");
            if (revisar.next().equals("1")) {
                borrados = borrados + "☼" + temporal;
            }
        }
        FileWriter filewriter1 = null;
        BufferedWriter bufferedwriter1 = null;
        try {
            filewriter1 = new FileWriter(Borrados_file, false);
            bufferedwriter1 = new BufferedWriter(filewriter1);
            bufferedwriter1.write(borrados);
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
                            + modificado.getImagen() + "•";
                    for (int i = 0; i < modificado.getDebilidades().size(); i++) {
                        nuevo_contenido = nuevo_contenido + modificado.getDebilidades().get(i) + "○";
                    }
                    nuevo_contenido = nuevo_contenido + "•"
                            + modificado.getTipo()[0] + "•"
                            + modificado.getTipo()[1];
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
            bufferedwriter.flush();
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
        FileWriter filewriter1 = null;
        BufferedWriter bufferedwriter1 = null;
        try {
            filewriter1 = new FileWriter(Borrados_file, false);
            bufferedwriter1 = new BufferedWriter(filewriter1);
            bufferedwriter1.write("");
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

    public ArrayList<Pokemon> Prioridad() throws FileNotFoundException {
        ArrayList<Pokemon> lista_disponibles = new ArrayList<Pokemon>();
        ArrayList<Integer> size_disponibles = new ArrayList<Integer>();
        Scanner disponibles = new Scanner(Borrados_file);
        disponibles.useDelimiter("☼");
        while (disponibles.hasNext()) {
            String parte = disponibles.next();
            Scanner temporal = new Scanner(parte);
            temporal.useDelimiter("•");
            String Nombre = temporal.next();
            String Apodo = temporal.next();
            String Descripcion = temporal.next();
            double Altura = Double.parseDouble(temporal.next());
            String Categoria = temporal.next();
            double Peso = Double.parseDouble(temporal.next());
            String genero = temporal.next();
            Scanner hability = new Scanner(temporal.next());
            ArrayList<String> Habilidades = new ArrayList<String>();
            hability.useDelimiter("○");
            while (hability.hasNext()) {
                Habilidades.add(hability.next());
            }
            int Hp = Integer.parseInt(temporal.next());
            int Ataque = Integer.parseInt(temporal.next());
            int Defensa = Integer.parseInt(temporal.next());
            int Ataque_Especial = Integer.parseInt(temporal.next());
            int Defensa_Especial = Integer.parseInt(temporal.next());
            int Velocidad = Integer.parseInt(temporal.next());
            String Evolucion = temporal.next();
            String Imagen = temporal.next();
            Scanner debil = new Scanner(temporal.next());
            ArrayList<String> Debilidades = new ArrayList<String>();
            debil.useDelimiter("○");
            while (hability.hasNext()) {
                Debilidades.add(debil.next());
            }
            String tipo[] = new String[2];
            tipo[0] = temporal.next();
            tipo[1] = temporal.next();
            Pokemon pokemon = new Pokemon(0, Nombre, Apodo, Descripcion, Altura, Categoria, Peso, genero, Hp, Ataque, Defensa, Ataque_Especial, Defensa_Especial, Velocidad, Evolucion, Imagen);
            pokemon.setHabilidades(Habilidades);
            pokemon.setDebilidades(Debilidades);
            pokemon.setTipo(tipo);
            lista_disponibles.add(pokemon);
            size_disponibles.add(parte.length());
        }
        for (int i = 0; i < lista_disponibles.size() - 1; i++) {
            for (int j = 0; j < lista_disponibles.size(); j++) {
                if (size_disponibles.get(i) > size_disponibles.get(j)) {
                    int auxiliar = size_disponibles.get(i);
                    Pokemon auxiliar2 = lista_disponibles.get(i);
                    size_disponibles.set(i, size_disponibles.get(j));
                    lista_disponibles.set(i, lista_disponibles.get(j));
                    size_disponibles.set(j, auxiliar);
                    lista_disponibles.set(j, auxiliar2);
                }
            }
        }
        return lista_disponibles;
    }

    /*
    public void cola() {
        try {
            Scanner contenido = new Scanner(this.Borrados_file);
            contenido.useDelimiter("☼");
            while (contenido.hasNext()) {
                Scanner registros = new Scanner(contenido.next());
                registros.useDelimiter("•");
                String disponible = registros.next();
                String Nombre = registros.next();
                String Apodo = registros.next();
                String Descripcion = registros.next();
                double Altura = Double.parseDouble(registros.next());
                String Categoria = registros.next();
                double Peso = Double.parseDouble(registros.next());
                String genero = registros.next();
                Scanner hability = new Scanner(registros.next());
                ArrayList<String> Habilidades = new ArrayList<String>();
                hability.useDelimiter("○");
                while (hability.hasNext()) {
                    Habilidades.add(hability.next());
                }
                int Hp = Integer.parseInt(registros.next());
                int Ataque = Integer.parseInt(registros.next());
                int Defensa = Integer.parseInt(registros.next());
                int Ataque_Especial = Integer.parseInt(registros.next());
                int Defensa_Especial = Integer.parseInt(registros.next());
                int Velocidad = Integer.parseInt(registros.next());
                String Evolucion = registros.next();
                String Imagen = registros.next();
                Scanner debil = new Scanner(registros.next());
                ArrayList<String> Debilidades = new ArrayList<String>();
                debil.useDelimiter("○");
                while (hability.hasNext()) {
                    Debilidades.add(debil.next());
                }
                String tipo[] = new String[2];
                tipo[0] = registros.next();
                tipo[1] = registros.next();
                Pokemon pokemon = new Pokemon(1, Nombre, Apodo, Descripcion, Altura, Categoria, Peso, genero, Hp, Ataque, Defensa, Ataque_Especial, Defensa_Especial, Velocidad, Evolucion, Imagen);
                pokemon.setHabilidades(Habilidades);
                pokemon.setDebilidades(Debilidades);
                pokemon.setTipo(tipo);
                Disponibles.add(pokemon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
     */
    public void cola(Pokemon borrado) throws FileNotFoundException {

    }

    public File getArchivo() {
        return Archivo;
    }

    public void setArchivo(File Archivo) {
        this.Archivo = Archivo;
    }

}
