package com.adonyastudios.codingchallenge;

public class Main {
    public static void main(String[] args){
//        System.out.println("Starting Simple Dag Testing");
        Vertex A = new Vertex("A", 1);
        Vertex B = new Vertex("B", 2);
        Vertex C = new Vertex("C", 3);
        Vertex D = new Vertex("D", 3);
        Vertex E = new Vertex("E", 4);
        Vertex F = new Vertex("F", 5);
        DAG dag = new DAG();
        //Testing case 1, shouldn't be allowed to connect to self
//        dag.connectVertices(A,A);

        dag.connectVertices(A,B);

        //Testing case 2, shouldn't be allowed to dup connections
//        dag.connectVertices(A,B);

        dag.connectVertices(B,C);

        //Testing case 3 , shouldn't be allowed to connect to a previous Vertex
//        dag.connectVertices(C,B);

        dag.connectVertices(B,D);
        dag.connectVertices(C,D);

        dag.connectVertices(A,E);
        dag.connectVertices(D,E);

        //Testing case 4 , shouldn't be allowed to connect to a Vertex on a higher layer
//        dag.connectVertices(F,A);

//        dag.calculateLongestPath(B);

        //Starting Complex DAG Testing
        Vertex A2 = new Vertex("A2", 1);
        Vertex B2 = new Vertex("B2", 1);
        Vertex C2 = new Vertex("C2", 1);
        Vertex D2 = new Vertex("D2", 2);
        Vertex E2 = new Vertex("E2", 3);
        Vertex F2 = new Vertex("F2", 3);
        Vertex G2 = new Vertex("G2", 4);
        Vertex H2 = new Vertex("H2", 5);
        Vertex I2 = new Vertex("I2", 5);
        Vertex J2 = new Vertex("J2", 6);


        DAG dag2 = new DAG();

        dag2.connectVertices(A2,D2);
        dag2.connectVertices(A2,E2);
        dag2.connectVertices(A2,H2);
        dag2.connectVertices(B2,A2);
        dag2.connectVertices(B2,D2);

        //Test Case 2: shouldn't be allowed to duplicate connections
//        dag2.connectVertices(A2,B2); //should send err

        dag2.connectVertices(C2,B2);
        dag2.connectVertices(C2,D2);
        dag2.connectVertices(C2,J2);
        dag2.connectVertices(D2,H2);
        dag2.connectVertices(D2,E2);
        dag2.connectVertices(D2,G2);
        dag2.connectVertices(D2,F2);
        dag2.connectVertices(D2,J2);
        dag2.connectVertices(E2,G2);
        dag2.connectVertices(F2,J2);
        dag2.connectVertices(G2,J2);
        dag2.connectVertices(G2,H2);
        dag2.connectVertices(H2,J2);

        String result = dag2.calculateLongestPath(D2);
        System.out.println(result);
    }
}
