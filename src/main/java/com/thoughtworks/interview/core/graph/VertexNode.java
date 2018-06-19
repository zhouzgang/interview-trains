package com.thoughtworks.interview.core.graph;

/**
 * 顶点表节点
 *
 * @author zhouzhigang
 * @date 2018/6/14.
 */
public class VertexNode {

    /** 顶点域，存储顶点信息 */
    private String data;

    /** 边表头指针 */
    private EdgeNode firstEdge;

    public String getData() {
        return data;
    }

    public VertexNode setData(String data) {
        this.data = data;
        return this;
    }

    public EdgeNode getFirstEdge() {
        return firstEdge;
    }

    public VertexNode setFirstEdge(EdgeNode firstEdge) {
        this.firstEdge = firstEdge;
        return this;
    }
}
