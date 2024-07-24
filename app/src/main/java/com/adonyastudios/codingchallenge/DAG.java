package com.adonyastudios.codingchallenge;

import java.util.ArrayList;

public class DAG {

    private int longestPathStepCount = 0;
    private String pathing = "";
    private String finalPathing="";

    public void connectVertices(Vertex startingVertex, Vertex pointToVertex){
        //edge case 1 : to prevent connecting to itself
        if (startingVertex.equals(pointToVertex)){
            System.err.println("Cannot connect to itself");
        } //edge case 2 : the vertex already is connected to
        else if(startingVertex.toVertices.contains(pointToVertex)){
            System.err.println("Cannot have duplicate connections");
        } //edge case 3 :  the vertex that is attempting to be connected to already connects to this one + no backwards movement
        else if(pointToVertex.toVertices.contains(startingVertex)){
            System.err.println("Cannot connect to previous Vertex");
        } //edge case 4 : preventing connecting a vector in the opposite direction
        else if(startingVertex.layer>pointToVertex.layer){
            System.err.println("Cannot connect to a Vertex on a higher level");
        }else{
            startingVertex.toVertices.add(pointToVertex);
            pointToVertex.fromVertices.add(startingVertex);
        }
    }

    public String calculateLongestPath(Vertex vertex){
        int totalSteps =0;
        // case 6 : Vertex doesn't have any other connections
        if(vertex.toVertices.isEmpty()){
//            System.out.println( "Vertex: "+ vertex.name+" has no other connections making its longest path 0");
            return "Vertex: "+ vertex.name+" has no other connections making its longest path 1";
        }

        // case 7 : Vertex has only 1 other connection
        if(vertex.toVertices.size() == 1){
            longestPathStepCount=1;
            finalPathing = vertex.name + " -> " + vertex.toVertices.get(0).name;
//            System.out.println("The longest path of Vertex "+ vertex.name+ " is \n"+
//                    finalPathing + "\n with a total of "+longestPathStepCount+ " steps");
            return "The longest path of Vertex "+ vertex.name+ " is \n"+
                    finalPathing + "\n with a total of "+longestPathStepCount+ " steps";
        }
        for (Vertex outsideVertex:
             vertex.toVertices) {
            int insideSteps =1;
//            System.out.println("From given vertex: "+vertex.name+ " stepped to: "+ outsideVertex.name);

            pathing = vertex.name + " -> "+outsideVertex.name;

//            System.out.println("Starting on step: "+ insideSteps);

            if (!outsideVertex.toVertices.isEmpty()){
//                System.out.println(outsideVertex.name+ " goes deeper. It connects to "+ outsideVertex.toVertices);
                deeperComputation(outsideVertex,outsideVertex.toVertices,insideSteps);
            }
        }
//        System.out.println("The longest path of Vertex "+ vertex.name+ " is \n"+
//                finalPathing + "\n with a total of "+longestPathStepCount+ " steps");
        return "The longest path of Vertex "+ vertex.name+ " is \n"+
                finalPathing + "\n with a total of "+longestPathStepCount+ " steps";
    }

    private void deeperComputation(Vertex vertex,ArrayList<Vertex> vertexArrayList, int stepCount){
        int startingStepCount = stepCount;
        String startingPathing = pathing;
        for (Vertex insideVertex:vertexArrayList
             ) {
            stepCount=startingStepCount;
            pathing = startingPathing;
            if(!insideVertex.toVertices.isEmpty()){
                stepCount++;
                pathing += " -> "+ insideVertex.name ;
//                System.out.println("Updating Pathing: "+ pathing);
                if(stepCount>longestPathStepCount){
                    finalPathing = pathing ;
//                    System.out.println("final Pathing updated: "+ finalPathing);
                    longestPathStepCount=stepCount;
                }
//                System.out.println("Current vertex is: "+vertex.name+ " stepping to: "+ insideVertex.name+ " and on step: "+ stepCount);
                deeperComputation(insideVertex, insideVertex.toVertices,stepCount);
            } else{
                stepCount++;
                pathing += " -> "+ insideVertex.name ;
//                System.out.println("stepped from: "+ vertex+ " to: "+ insideVertex+" and ended the journey on step: "+ stepCount);
                if(stepCount>longestPathStepCount){
                    finalPathing = pathing ;
//                    System.out.println("Final final pathing: "+ finalPathing);
                    longestPathStepCount=stepCount;
                }
            }
        }
    }

}
