package cn.ecomb.metro.core;

import cn.ecomb.metro.core.bean.MetroMap;
import cn.ecomb.metro.input.FileInputData;
import org.junit.Test;

import java.io.InputStreamReader;

import static org.junit.Assert.*;

/**
 * @author zhouzg
 * @date 2019/3/25
 */
public class MetroUndirectedGraphTest {

    @Test
    public void createGraphTest() {
        this.getClass().getResourceAsStream("/metro.json");
        InputStreamReader inputStreamReader = new InputStreamReader(this.getClass().getResourceAsStream("/metro.json"));
        FileInputData fileInputData = new FileInputData();
        MetroMap metroMap = fileInputData.readData(inputStreamReader);
        MetroUndirectedGraph metroUndirectedGraph = new MetroUndirectedGraph();
        metroUndirectedGraph.createGraph(metroMap);
    }

}