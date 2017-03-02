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
        private int heaptamaño;
        private node[] heap;
        private int capacidad = 50;

        public node(Object nodo, int prioriedad) {
            this.nodo = nodo;
            this.prioriedad = prioriedad;
        }

        public void agrega(int a, int prior) {
            node nuevo = new node(a, prior);
            int posicion = heaptamaño;
            heap[++heaptamaño] = nuevo;
            while (posicion != 1 && nuevo.prioriedad > heap[posicion / 2].prioriedad) {
                heap[posicion] = heap[posicion / 2];
                posicion /= 2;
            }
            heap[posicion] = nuevo;
        }

        public node get(int posicion) {
            return heap[posicion];
        }

        public int tamano() {
            return heaptamaño;
        }

        public boolean Colallena() {
            return heaptamaño == capacidad - 1;
        }

        public boolean ColaVacia() {
            return heaptamaño == 0;
        }

        @Override
        public String toString() {
            return nodo + "," + prioriedad;
        }

    }
}
