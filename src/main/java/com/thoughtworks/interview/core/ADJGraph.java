package com.thoughtworks.interview.core;

import com.thoughtworks.interview.core.graph.TravelPath;
import com.thoughtworks.interview.input.InputData;

import java.util.List;

/**
 * 邻接矩阵结构的图
 *
 * @author zhouzhigang
 * @date 2018/6/14.
 */
public class ADJGraph implements Graph{
    @Override
    public Graph createGraph(InputData data) {
        return null;
    }

    @Override
    public float distanceOfRoute(List<String> route) {
        return 0;
    }

    @Override
    public Object getModel() {
        return null;
    }

    @Override
    public TravelPath pathOfTravel(String start, String end) {
        return null;
    }

    @Override
    public TravelPath pathOfTravelWithLoop(String start, String end, float maxDistance) {
        return null;
    }
}
