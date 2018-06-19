package com.thoughtworks.interview.core;

import com.thoughtworks.interview.core.graph.TravelPath;
import com.thoughtworks.interview.input.FileInputData;
import com.thoughtworks.interview.input.InputData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouzhigang
 * @date 2018/6/15.
 */
public class ALGraphTest {
    @Test
    public void createGraph() throws Exception {
        InputData inputData = new FileInputData();
        inputData.getData(this.getClass().getResourceAsStream("/data.txt"));
        ALGraph alGraph = (ALGraph)GraphFactory.createALGraph(inputData);
        alGraph.printGraph();
    }

    @Test
    public void distanceOfRoute() throws Exception{

        InputData inputData = new FileInputData();
        inputData.getData(this.getClass().getResourceAsStream("/data.txt"));
        Graph alGraph = GraphFactory.createALGraph(inputData);

        List<String> route1 = new ArrayList<String>();
        route1.add(new String("A"));
        route1.add(new String("B"));
        route1.add(new String("C"));
        float distance = alGraph.distanceOfRoute(route1);
        printRoute(route1);
        System.out.println(distance);

        List<String> route2 = new ArrayList<String>();
        route2.add(new String("A"));
        route2.add(new String("D"));

        printRoute(route2);
        System.out.println(alGraph.distanceOfRoute(route2));

        List<String> route3 = new ArrayList<String>();
        route3.add(new String("A"));
        route3.add(new String("D"));
        route3.add(new String("C"));

        printRoute(route3);
        System.out.println(alGraph.distanceOfRoute(route3));

        List<String> route4 = new ArrayList<String>();
        route4.add(new String("A"));
        route4.add(new String("E"));
        route4.add(new String("B"));
        route4.add(new String("C"));
        route4.add(new String("D"));

        printRoute(route4);
        System.out.println(alGraph.distanceOfRoute(route4));

        List<String> route5 = new ArrayList<String>();
        route5.add(new String("A"));
        route5.add(new String("E"));
        route5.add(new String("D"));

        printRoute(route5);
        System.out.println(alGraph.distanceOfRoute(route5));
    }

    private void printRoute(List<String> route) {
        System.out.print("路线: ");
        for (int i = 0 , size = route.size(); i < size; i++) {
            if (i == size - 1) {
                System.out.print(route.get(i) + " 距离: ");
            } else {
                System.out.print(route.get(i) + " -> ");
            }
        }
    }

    @Test
    public void pathOfTravel() {
        InputData inputData = new FileInputData();
        inputData.getData(ALGraph.class.getResourceAsStream("/data.txt"));
        ALGraph alGraph = (ALGraph)GraphFactory.createALGraph(inputData);
        TravelPath tp = alGraph.pathOfTravel("A", "C");
        tp.printTravelsWithWeight();
    }

    @Test
    public void pathOfTravelWithLoop() {
        InputData inputData = new FileInputData();
        inputData.getData(ALGraph.class.getResourceAsStream("/data.txt"));
        ALGraph alGraph = (ALGraph)GraphFactory.createALGraph(inputData);
        TravelPath tp = alGraph.pathOfTravelWithLoop("C", "C", 30f);
        tp.printTravelsWithWeight();
        System.out.println(tp.getTravels().size());
    }

}