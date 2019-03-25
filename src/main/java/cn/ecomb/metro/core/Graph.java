package cn.ecomb.metro.core;


import cn.ecomb.metro.core.bean.MetroMap;

import java.util.List;

/**
 * @author zhouzg
 * @date 2019/3/25
 */
public interface Graph {

    /**
     * 创建图
     * @return
     */
    Graph createGraph(MetroMap metroMap);

    /**
     * 添加节点
     */
    void addNode();

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
    void pathOfTravel(String start, String end);
}
