package com.thoughtworks.interview.core;

import com.thoughtworks.interview.input.InputData;

/**
 * 构建图模型工厂方法，构建不同的图模型
 *
 * @author zhouzhigang
 * @date 2018/6/14.
 */
public class GraphFactory {

    /**
     * 创建邻接表结构的图
     *
     * @param inputData 输入数据
     * @return
     */
    public static Graph createALGraph(InputData inputData) {
        return new ALGraph().createGraph(inputData);
    }

    /**
     * 创建邻接矩阵结构的图
     *
     * @param inputData 输入数据
     * @return
     */
    public static Graph createADJGraph(InputData inputData) {
        return null;
    }

}
