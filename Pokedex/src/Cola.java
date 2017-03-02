/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Romero
 */
public class Cola {
    Pokemon heap;
    int size;
    int hijos;
    Cola hijo1;
    Cola hijo2;

    public Cola() {
    }

    public Cola(Pokemon heap, int size) {
        this.heap = heap;
        this.size = size;
        this.hijo1=new Cola((new Pokemon()),0);
        this.hijo2=new Cola((new Pokemon()),0);
        hijos=0;
    }
    
    public void queue(Cola nuevo){
        if (nuevo.getSize() != 0) {
            if (size < nuevo.getSize()) {
                System.out.println("0"+nuevo.getSize());
                Cola temporal = new Cola(heap, size);
                heap = nuevo.getHeap();
                size = nuevo.getSize();
                if (hijos==0) {
                    this.hijo1 = new Cola();
                    this.hijo2 = new Cola();
                }if (hijo1.getSize() == 0) {
                    hijo1.queue(temporal);
                    hijos++;
                } else if (hijo2.getSize() == 0) {
                    hijo2.queue(temporal);
                    hijos++;
                } else if (hijo1.getHijo1().size==0&&hijo1.getHijo2().size==0) {
                    hijo1.queue(temporal);
                } else {
                    hijo2.queue(temporal);
                }
                
            } else if (hijo1.getSize() == 0) {
                System.out.println("1");
                hijo1.queue(nuevo);
                hijos++;
            } else if (hijo2.getSize() == 0) {
                hijo2.queue(nuevo);
                hijos++;
            } else if (hijo1.getHijo1().size==0&&hijo1.getHijo2().size==0) {
                hijo1.queue(nuevo);
            } else {
                hijo2.queue(nuevo);
            }
        }
    }
    
    public void dequeue(Cola nuevo){
    }


    public Pokemon getHeap() {
        return heap;
    }

    public void setHeap(Pokemon heap) {
        this.heap = heap;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Cola getHijo1() {
        return hijo1;
    }

    public void setHijo1(Cola hijo1) {
        this.hijo1 = hijo1;
    }

    public Cola getHijo2() {
        return hijo2;
    }

    public void setHijo2(Cola hijo2) {
        this.hijo2 = hijo2;
    }

    public int getHijos() {
        return hijos;
    }

    public void setHijos(int hijos) {
        this.hijos = hijos;
    }

    @Override
    public String toString() {
        return ";"+size + "=" + hijo1.getSize() + "," + hijo2.getSize() +hijo1.toString()+hijo2.toString();
    }
    
}
