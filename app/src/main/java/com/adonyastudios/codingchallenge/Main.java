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

        //Question 1: Does the solution work for larger graphs?
        // As long as the graph is in fact a DAG then it should work on any sized graph

        //Question 2: Can you think of any optimizations?
        /*There is room for more efficency such as removing the fromVertices ArrayList and using
            better data structures to reduce redundacy but i believe my solution is an accurate display
            of how i personally tackle coding problems
         */

        //Question 3: What’s the computational complexity of your solution?
        /*
        In terms of Big O notation, I believe my code is Linear Time Complexity for the simple fact
        if you add another Vertice and you make a new connection the code only has to account for
        that vertices and what Vertices it may be connected to, without it having to run any complicated
        extra code
         */

        //Question 4: Are there any unusual cases that aren't handled?
        /*
        I believe I have handled a majority of the cases to ensure the integrity of a DAG. However
        if one wanted to get past such checks, the vertices layers are able to be adjusted after
        being connected, compromising the integrity of a DAG in the process
         */
    }
}
