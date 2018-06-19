package com.thoughtworks.interview.output;

import com.thoughtworks.interview.core.ALGraph;
import com.thoughtworks.interview.core.Graph;
import com.thoughtworks.interview.core.graph.TravelPath;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouzhigang
 * @date 2018/6/16.
 */
public class ConsoleOutputData implements OutputData{

    public static void outputDistance(Graph alGraph) {
        List<String> route1 = new ArrayList<String>();
        route1.add(new String("A"));
        route1.add(new String("B"));
        route1.add(new String("C"));

        printRoute(route1);
        System.out.println(alGraph.distanceOfRoute(route1) > 0 ? alGraph.distanceOfRoute(route1) : "");

        List<String> route2 = new ArrayList<String>();
        route2.add(new String("A"));
        route2.add(new String("D"));

        printRoute(route2);
        System.out.println(alGraph.distanceOfRoute(route2) > 0 ? alGraph.distanceOfRoute(route2) : "");

        List<String> route3 = new ArrayList<String>();
        route3.add(new String("A"));
        route3.add(new String("D"));
        route3.add(new String("C"));

        printRoute(route3);
        System.out.println(alGraph.distanceOfRoute(route3) > 0 ? alGraph.distanceOfRoute(route3) : "");

        List<String> route4 = new ArrayList<String>();
        route4.add(new String("A"));
        route4.add(new String("E"));
        route4.add(new String("B"));
        route4.add(new String("C"));
        route4.add(new String("D"));

        printRoute(route4);
        System.out.println(alGraph.distanceOfRoute(route4) > 0 ? alGraph.distanceOfRoute(route4) : "");

        List<String> route5 = new ArrayList<String>();
        route5.add(new String("A"));
        route5.add(new String("E"));
        route5.add(new String("D"));

        printRoute(route5);
        System.out.println(alGraph.distanceOfRoute(route5) > 0 ? alGraph.distanceOfRoute(route5) : "");
    }

    private static void printRoute(List<String> route) {
        System.out.print("路线: ");
        for (int i = 0 , size = route.size(); i < size; i++) {
            if (i == size - 1) {
                System.out.print(route.get(i) + " 距离: ");
            } else {
                System.out.print(route.get(i) + " -> ");
            }
        }
    }

    public static void outputMaxTravelStep(ALGraph alGraph, String start, String end) {
        TravelPath travelPath = alGraph.pathOfTravel(start, end);
        System.out.println("从" + start + "开始到"+ end +"结束的行程数最多: " + travelPath.getMaxNode());
        System.out.println();
    }

    public static void outputNumOfTravel(ALGraph alGraph, String start, String end) {
        TravelPath travelPath = alGraph.pathOfTravel(start, end);
        System.out.println("从" + start + "开始到"+ end +"结束的行程次数: " + travelPath.getTravels().size());
        System.out.println();
    }

    public static void outputMinDistance(ALGraph alGraph, String start, String end) {
        TravelPath travelPath = alGraph.pathOfTravel(start, end);
        travelPath.printTravelsWithWeight();
        System.out.println("从" + start + "开始到"+ end +"结束的最短路径长度: " + travelPath.getMinDistance());
        System.out.println();
    }

    public static void outputTravelWithLoop(ALGraph alGraph, String start, String end, float maxDistance) {
        TravelPath travelPath = alGraph.pathOfTravelWithLoop(start, end, maxDistance);
        travelPath.printTravelsWithWeight();
        System.out.println("从" + start + "开始到"+ end +"小于" + maxDistance + "的不同路线的数: " + travelPath.getTravels().size());
        System.out.println();
    }



}
