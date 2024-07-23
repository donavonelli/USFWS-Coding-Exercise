package com.adonyastudios.codingchallenge;

public class Main {
    public static void main(String[] args){
        System.out.println("Starting");
        Vertex A = new Vertex("A", 1);
        Vertex B = new Vertex("B", 2);
        Vertex C = new Vertex("C", 3);
        Vertex D = new Vertex("D", 3);
        Vertex E = new Vertex("E", 4);
        Vertex F = new Vertex("F", 5);
        DAG dag = new DAG();
        //Testing case 1, shouldn't be allowed to connect to self
        dag.connectVertices(A,A);
        dag.connectVertices(A,B);
        //Testing case 2, shouldn't be allowed to dup connections
        dag.connectVertices(A,B);
        dag.connectVertices(B,C);
        //Testing case 3 , shouldn't be allowed to connect to a previous Vertex
        dag.connectVertices(C,B);
        dag.connectVertices(B,D);
        dag.connectVertices(C,D);
        dag.connectVertices(A,E);
        dag.connectVertices(D,E);
        //Testing case 4 , shouldn't be allowed to connect to a Vertex on a higher layer
        dag.connectVertices(F,A);
        //Testing case 5 , connected vertices shouldn't connect to a higher layer aka only move
        //in one direction
        dag.connectVertices(F,A);

        System.out.println(E.connectedVertices);
    }
}
