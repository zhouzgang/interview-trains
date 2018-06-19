package com.thoughtworks.interview.core.graph;

import java.io.*;
import java.util.LinkedList;


/**
 * 路径
 *
 * @author zhouzhigang
 * @date 2018/6/15.
 */
public class TravelPath implements Serializable{

    /**
     * 行程数
     */
    private int pathNum;

    /**
     * 最多站点
     */
    private int maxNode;

    /**
     * 路径表
     */
    LinkedList<LinkedList<EdgeNode>> travels = new LinkedList<LinkedList<EdgeNode>>();


    public void printTravels() {
        for (LinkedList travel : travels) {
            for (Object walk : travel) {
                EdgeNode edgeNode = (EdgeNode) walk;
                System.out.printf("-> " + edgeNode.getData());
            }
            System.out.println("");
        }
    }

    public void printTravelsWithWeight() {
        for (LinkedList travel : travels) {
            float dis = 0f;
            for (Object walk : travel) {
                EdgeNode edgeNode = (EdgeNode) walk;
                dis += edgeNode.getWeight();
                System.out.printf(" -"  + edgeNode.getWeight() + "-> " + edgeNode.getData() + ":" );
            }
            System.out.println("路程: " + dis);
        }
    }

    public float getMinDistance() {
        float[] allTravelDis = new float[travels.size()];
        for (int i = 0, size = travels.size(); i < size; i++) {
            float travelDis = 0f;
            for (Object walk : travels.get(i)) {
                EdgeNode ed = (EdgeNode) walk;
                travelDis += ed.getWeight();
            }
            allTravelDis[i] = travelDis;
        }
        float minDis = allTravelDis[0];
        for (int i = 0, length = allTravelDis.length; i < length; i++) {
            if (allTravelDis[i] < minDis) {
                minDis = allTravelDis[i];
            }
        }
        return minDis;
    }

    public Object deepClone() throws IOException, OptionalDataException, ClassNotFoundException {
        // 将对象写到流里
        OutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(this);

        // 从流里读出来
        InputStream bi = new ByteArrayInputStream(((ByteArrayOutputStream) bo).toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);
        return (oi.readObject());
    }

    public int getPathNum() {
        return pathNum;
    }

    public TravelPath setPathNum(int pathNum) {
        this.pathNum = pathNum;
        return this;
    }

    public int getMaxNode() {
        return maxNode;
    }

    public TravelPath setMaxNode(int maxNode) {
        this.maxNode = maxNode;
        return this;
    }

    public LinkedList<LinkedList<EdgeNode>> getTravels() {
        return travels;
    }

    public TravelPath setTravels(LinkedList<LinkedList<EdgeNode>> travels) {
        this.travels = travels;
        return this;
    }
}
