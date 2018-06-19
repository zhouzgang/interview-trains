package com.thoughtworks.interview.core;

import com.thoughtworks.interview.core.graph.TravelPath;
import com.thoughtworks.interview.input.InputData;

import java.util.List;

/**
 * 图接口
 *
 * @author zhouzhigang
 * @date 2018/6/14.
 */
public interface Graph {

    /**
     * 创建图
     * @param inputData 图构建数据
     * @return
     */
    Graph createGraph(InputData inputData);

    /**
     * 获取构建好的图模型
     * @return
     */
    Object getModel();

    /**
     * 获取两个顶点之间的距离
     *
     * @param route 路径经过的节点
     * @return
     */
    float distanceOfRoute(List<String> route);

    /**
     * 获取两地的行程
     *
     * @param start 起始地
     * @param end   目的地
     * @return
     */
    TravelPath pathOfTravel(String start, String end);

    /**
     * 获取距离范围内的所有路径
     * todo 可以优化成待条件的路径查找
     * @param start
     * @param end
     * @param maxDistance
     * @return
     */
    TravelPath pathOfTravelWithLoop(String start, String end, float maxDistance);


}
