package com.thoughtworks.interview;

import com.thoughtworks.interview.core.ALGraph;
import com.thoughtworks.interview.core.GraphFactory;
import com.thoughtworks.interview.input.FileInputData;
import com.thoughtworks.interview.input.InputData;
import com.thoughtworks.interview.output.ConsoleOutputData;

/**
 * @author zhouzhigang
 * @date 2018/6/14.
 */
public class Application {

    public static void main(String[] args) {
        InputData inputData = new FileInputData();
        inputData.getData(ALGraph.class.getResourceAsStream("/data.txt"));
        ALGraph alGraph = (ALGraph) GraphFactory.createALGraph(inputData);

        ConsoleOutputData.outputDistance(alGraph);
        ConsoleOutputData.outputMaxTravelStep(alGraph, "C", "C");
        ConsoleOutputData.outputNumOfTravel(alGraph, "A", "C");
        ConsoleOutputData.outputMinDistance(alGraph, "A", "C");
        ConsoleOutputData.outputMinDistance(alGraph, "B", "B");
        ConsoleOutputData.outputTravelWithLoop(alGraph, "C", "C", 30f);

    }
}