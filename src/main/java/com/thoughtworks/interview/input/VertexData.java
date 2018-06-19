package com.thoughtworks.interview.input;

/**
 * 输入数据转化为节点数据
 *
 * @author zhouzhigang
 * @date 2018/6/14.
 */
public class VertexData {


    private String from;

    private String to;

    private int fromIndex;

    private int toIndex;

    private float weight;

    public String getFrom() {
        return from;
    }

    public VertexData setFrom(String from) {
        this.from = from;
        return this;
    }

    public String getTo() {
        return to;
    }

    public VertexData setTo(String to) {
        this.to = to;
        return this;
    }

    public int getFromIndex() {
        return fromIndex;
    }

    public VertexData setFromIndex(int fromIndex) {
        this.fromIndex = fromIndex;
        return this;
    }

    public int getToIndex() {
        return toIndex;
    }

    public VertexData setToIndex(int toIndex) {
        this.toIndex = toIndex;
        return this;
    }

    public float getWeight() {
        return weight;
    }

    public VertexData setWeight(float weight) {
        this.weight = weight;
        return this;
    }
}
