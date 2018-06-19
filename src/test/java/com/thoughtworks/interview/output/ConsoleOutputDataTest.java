package com.thoughtworks.interview.output;

import com.thoughtworks.interview.core.ALGraph;
import com.thoughtworks.interview.core.GraphFactory;
import com.thoughtworks.interview.input.FileInputData;
import com.thoughtworks.interview.input.InputData;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zhouzhigang
 * @date 2018/6/16.
 */
public class ConsoleOutputDataTest {
    @Test
    public void outputMinDistance() throws Exception {
        InputData inputData = new FileInputData();
        inputData.getData(ALGraph.class.getResourceAsStream("/data.txt"));
        ALGraph alGraph = (ALGraph) GraphFactory.createALGraph(inputData);

        alGraph.printGraph();

        ConsoleOutputData.outputMinDistance(alGraph, "B", "B");
    }

}