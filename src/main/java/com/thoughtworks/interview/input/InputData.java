package com.thoughtworks.interview.input;

import java.io.InputStream;
import java.util.List;
import java.util.Set;

/**
 * 图构建数据的输入接口
 *
 * @author zhouzhigang
 * @date 2018/6/14.
 */
public interface InputData {

    /**
     * 获取输入数据
     * @return 返回图构建数据
     */
    List<VertexData> getData();

    /**
     * 带数据文件路径，获取输入数据
     * @param inputStream
     * @return
     */
    List<VertexData> getData(InputStream inputStream);

    /**
     * 获取所有唯一节点
     *
     * @return
     */
    Set<String> getNodes();


    /**
     * 带数据文件路径， 获取所有唯一节点
     * @param inputStream
     * @return
     */
    Set<String> getNodes(InputStream inputStream);
}
