package com.thoughtworks.interview.core;

import com.thoughtworks.interview.core.graph.EdgeNode;
import com.thoughtworks.interview.core.graph.TravelPath;
import com.thoughtworks.interview.core.graph.VertexNode;
import com.thoughtworks.interview.input.FileInputData;
import com.thoughtworks.interview.input.InputData;
import com.thoughtworks.interview.input.VertexData;

import java.io.IOException;
import java.util.*;

/**
 * 邻接表结构构建图
 *
 * @author zhouzhigang
 * @date 2018/6/14.
 */
public class ALGraph implements Graph {

    /**
     * 默认容量
     */
    private static final int DEFAULT_CAPACITY = 100;

    /**
     * 邻接表顶点数组
     * 非线程安全
     */
    private List<VertexNode> list = new ArrayList<VertexNode>();

    /**
     * 图中当前顶点数
     */
    private int numVertexes;

    /**
     * 图中当前边数
     */
    private int numEdges;

    /**
     * 遍历图时，记录步行
     */
    LinkedList<EdgeNode> steps;

    /**
     * 记录
     */
    TravelPath travelPath;

    String start, end;



    @Override
    public Graph createGraph(InputData inputData) {
        List<VertexData> vertexDatas = inputData.getData();
        Set<String> nodes = inputData.getNodes();
        numEdges = vertexDatas.size();
        numVertexes = nodes.size();

        initVertexNode(nodes, vertexDatas);

        for (VertexData item : vertexDatas) {
            EdgeNode edgeNode = new EdgeNode();
            edgeNode.setAdjvex(item.getToIndex())
                    .setData(item.getTo())
                    .setWeight(item.getWeight());

            EdgeNode fEdge = list.get(item.getFromIndex()).getFirstEdge();
            if (fEdge != null) {
                edgeNode.setNext(fEdge);
            }
            list.get(item.getFromIndex()).setFirstEdge(edgeNode);
        }

        return this;
    }

    public void printGraph() {
        for (VertexNode vd : list) {
            System.out.print(vd.getData() + ":  ->  ");
            EdgeNode ef = vd.getFirstEdge();
            if (ef != null) {
                System.out.print(ef.getAdjvex() + "|" + ef.getData() + "|" + ef.getWeight());
                EdgeNode ed = vd.getFirstEdge().getNext();
                if (ed != null) {
                    System.out.print("  ->  ");
                } else {
                    System.out.println("");
                }
                while (ed != null) {
                    System.out.print(ed.getAdjvex() + "|" + ed.getData() + "|" + ed.getWeight());
                    ed = ed.getNext();
                    if (ed != null) {
                        System.out.print("  ->  ");
                    } else {
                        System.out.println("");
                    }
                }

            }
        }
    }

    private int getPosition(String node) {
        for (int i = 0 , size = list.size(); i < size; i++) {
            if (list.get(i).getData().equals(node)) {
                return i;
            }
        }
        return -1;
    }

    private void initVertexNode(Set<String> nodes, List<VertexData> vertexDatas) {
        for (String obj : nodes) {
            VertexNode vertexNode = new VertexNode();
            vertexNode.setData(obj);
            list.add(vertexNode);
            for (VertexData vd : vertexDatas) {
                if (vd.getFrom().equals(obj)) {
                    vd.setFromIndex(list.size() - 1);
                }
                if (vd.getTo().equals(obj)) {
                    vd.setToIndex(list.size() - 1);
                }
            }
        }
    }

    @Override
    public float distanceOfRoute(List<String> route) {
        float distance = 0f;
        for (int i = 0, size = route.size() - 1; i < size; i++) {
            int index = getPosition(route.get(i));
            VertexNode vn = list.get(index);
            EdgeNode ed = vn.getFirstEdge();
            boolean found = false;
            while (ed != null) {
                if (ed.getData().equals(route.get(i + 1))) {
                    distance += ed.getWeight();
                    found = true;
                    break;
                }
                ed = ed.getNext();
            }
            if (!found) {
                System.out.println("没有这样的路线");
                return -1f;
            }
        }
        return distance;
    }

    @Override
    public Object getModel() {
        return list;
    }


    @Override
    public TravelPath pathOfTravel(String start, String end) {
        this.start = start;
        this.end = end;
        travelPath = new TravelPath();
        steps = new LinkedList<EdgeNode>();
        dfs(start);
        return releaseTravel();
    }


    private void dfs(String node) {
        int index = getPosition(node);
        VertexNode vn = list.get(index);
        EdgeNode ed = vn.getFirstEdge();
        if (steps.size() == 0) {
            EdgeNode ef = new EdgeNode();
            ef.setData(node).setAdjvex(index);
            steps.addLast(ef);
        }
        boolean done = steps.size() > 1 && (node.equals(end) || containsStepExceptLast(node));
        if (done) {
            if (node.equals(end)) {
                remarkWalk();
            }
            return;
        }

        while (ed != null) {
            steps.addLast(ed);
            dfs(ed.getData());
            steps.removeLast();
            ed = ed.getNext();
        }
    }

    private boolean containsStepExceptLast(String node){
        for (int i = 0, size = steps.size() - 1; i < size; i++) {
            if (node.equals(steps.get(i).getData())) {
                return true;
            }
        }
        return false;
    }

    private void remarkWalk() {
        LinkedList<EdgeNode> walk = new LinkedList<EdgeNode>(steps);
        travelPath.getTravels().addLast(walk);
        if (walk.size() > travelPath.getMaxNode()) {
            travelPath.setMaxNode(walk.size());
        }
    }

    @Override
    public TravelPath pathOfTravelWithLoop(String start, String end, float maxDistance) {
        this.start = start;
        this.end = end;
        travelPath = new TravelPath();
        steps = new LinkedList<EdgeNode>();
        dfsWithLoop(start, 0, maxDistance);
        return releaseTravel();
    }

    private TravelPath releaseTravel() {
        try {
            TravelPath paths = (TravelPath) travelPath.deepClone();
            travelPath = null;
            steps = null;
            return paths;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void dfsWithLoop(String node, float distance, float maxDistance) {
        int index = getPosition(node);
        VertexNode vn = list.get(index);
        EdgeNode ed = vn.getFirstEdge();
        if (steps.size() == 0) {
            EdgeNode ef = new EdgeNode();
            ef.setData(node).setAdjvex(index);
            steps.addLast(ef);
        }

        if (distance > maxDistance) {
            return;
        }

        if ( steps.size() > 1 && node.equals(end)) {
            remarkWalk();
        }

        while (ed != null) {
            steps.addLast(ed);
            distance += ed.getWeight();
            dfsWithLoop(ed.getData(), distance, maxDistance);
            distance -= ed.getWeight();
            steps.removeLast();
            ed = ed.getNext();
        }
    }


    public List<VertexNode> getList() {
        return list;
    }

    public ALGraph setList(List<VertexNode> list) {
        this.list = list;
        return this;
    }

    public int getNumVertexes() {
        return numVertexes;
    }

    public ALGraph setNumVertexes(int numVertexes) {
        this.numVertexes = numVertexes;
        return this;
    }

    public int getNumEdges() {
        return numEdges;
    }

    public ALGraph setNumEdges(int numEdges) {
        this.numEdges = numEdges;
        return this;
    }
}













