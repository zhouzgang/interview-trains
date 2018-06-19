package com.thoughtworks.interview.input;

import org.junit.Test;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author zhouzhigang
 * @date 2018/6/15.
 */
public class FileInputDataTest {
    @Test
    public void getData() throws Exception {
        InputData inputData = new FileInputData();
        List<VertexData> list = inputData.getData(this.getClass().getResourceAsStream("/data.txt"));
        for (VertexData vd : list) {
            System.out.println(vd.getFrom() + "->" +  vd.getTo() +  "->" +  vd.getWeight());
        }
    }

    @Test
    public void getNodes() throws Exception {
        InputData inputData = new FileInputData();
        Set<String> list = inputData.getNodes(this.getClass().getResourceAsStream("/data.txt"));
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

}