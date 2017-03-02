
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexis
 */
public class Priority {

    public class node {

        private Object nodo;
        private int prioriedad;

        public node(Object nodo, int prioriedad) {
            this.nodo = nodo;
            this.prioriedad = prioriedad;
        }

        public Object getNodo() {
            return nodo;
        }

        public void setNodo(Object nodo) {
            this.nodo = nodo;
        }

        public int getPrioriedad() {
            return prioriedad;
        }

        public void setPrioriedad(int prioriedad) {
            this.prioriedad = prioriedad;
        }
        
        @Override
        public String toString() {
            return nodo + "," + prioriedad;
        }
    }

    private int heaptamaño;
    private node[] heap;
    private int capacidad = 50;

    public void insertar(int a, int prior) {
        node nuevo = new node(a, prior);
        int posicion = heaptamaño;
        heap[++heaptamaño] = nuevo;
        while (posicion != 1 && nuevo.prioriedad > heap[posicion / 2].prioriedad) {
            heap[posicion] = heap[posicion / 2];
            posicion /= 2;
        }
        heap[posicion] = nuevo;
    }

    public Priority() {
        heap = new node[this.capacidad+1];
        heaptamaño = 0;
    }

    public node get(int posicion) {
        return heap[posicion];
    }

    public int tamano() {
        return heaptamaño;
    }
    
    public void limpiar(){
        heap = new node[capacidad + 1];
        heaptamaño = 0;
    }

    public boolean Colallena() {
        return heaptamaño == capacidad - 1;
    }

    public boolean ColaVacia() {
        return heaptamaño == 0;
    }
    
    public node Priority(){
        int padre, hijo;
        node primero, ultimo;
        if (ColaVacia()) {
            JOptionPane.showMessageDialog(null, "Esta vacio");
            return null;
        }
        
        primero = heap[1];
        ultimo = heap[heaptamaño--];
        
        padre = 1;
        hijo = 2;
        while(hijo <= padre){
            if (hijo < heaptamaño && heap[hijo].prioriedad < heap[hijo + 1].prioriedad) {
                hijo++;
            }
            if (ultimo.prioriedad >= heap[hijo].prioriedad) {
                break;
            }
            
            heap[padre] = heap[hijo];
            padre = hijo;
            hijo *= 2;
        }
        heap[padre] = ultimo;
        return primero;
    }
    
    public int peek(){
        return heap[1].prioriedad;
    }

    public int getHeaptamaño() {
        return heaptamaño;
    }

    public void setHeaptamaño(int heaptamaño) {
        this.heaptamaño = heaptamaño;
    }

    public node[] getHeap() {
        return heap;
    }

    public void setHeap(node[] heap) {
        this.heap = heap;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    
}
