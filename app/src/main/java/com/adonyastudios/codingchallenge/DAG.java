package com.adonyastudios.codingchallenge;

import java.util.ArrayList;

public class DAG {

//    public Vertex vertex;
//    public ArrayList<Vertex> connectedVertices = new ArrayList<Vertex>();

//    DAG(Vertex vertexImported){
//        this.vertex = vertexImported;
//    }

    public void connectVertices(Vertex startingVertex, Vertex pointToVertex){
        //edge case 1 : to prevent connecting to itself
        if (startingVertex.equals(pointToVertex)){
            System.err.println("Cannot connect to itself");
        } //edge case 2 : the vertex already is connected to
        else if(startingVertex.connectedVertices.contains(pointToVertex)){
            System.err.println("Cannot have duplicate connections");
        } //edge case 3 :  the vertex that is attempting to be connected to already connects to this one
        else if(pointToVertex.connectedVertices.contains(startingVertex)){
            System.err.println("Cannot connect to previous Vertex");
        } //edge case 4 : preventing connecting a vector in the opposite direction
        else if(startingVertex.layer>pointToVertex.layer){
            System.out.println("got here");
            System.err.println("Cannot connect to a Vertex on a higher level");
        }else{
            if(!startingVertex.connectedVertices.isEmpty()) {

                //edge case 5 : preventing connecting a vector connection in the opposite direction
                for (int i = 0; i < startingVertex.connectedVertices.size(); i++) {
                    if (startingVertex.connectedVertices.get(i).layer > pointToVertex.layer) {
                        System.err.println("Cannot contain a Vertex that connects to a higher layer"+ startingVertex +" "+ pointToVertex);
                        break;
                    }
                }
            }
            startingVertex.connectedVertices.add(pointToVertex);
        }
    }
}
