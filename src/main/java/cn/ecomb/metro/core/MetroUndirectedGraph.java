package cn.ecomb.metro.core;

import cn.ecomb.metro.core.bean.Line;
import cn.ecomb.metro.core.bean.MetroMap;
import cn.ecomb.metro.core.bean.Station;

import java.util.*;

/**
 * @author zhouzg
 * @date 2019/3/25
 */
public class MetroUndirectedGraph implements Graph{

    private final Map<String, Station> stationMap = new HashMap<>();
    private final Map<String, Map<String, Station>> adjacent = new HashMap<>();

    @Override
    public Graph createGraph(MetroMap metroMap) {
        List<Line> lines = metroMap.getLines();
        lines.forEach(line -> {
            List<Station> stations = line.getStations();
            for (int i = 0, size = stations.size(); i < size; i++) {
                String sCode = stations.get(i).getCode();
                if (Objects.isNull(adjacent.get(sCode))) {
                    stationMap.put(sCode, stations.get(i));
                    adjacent.put(sCode, new HashMap<>());
                }
                addEdge(stations, i, size, sCode);
            }
        });
        return this;
    }

    private void addEdge(List<Station> stations, int i, int size, String sCode) {
        if (i == 0) {
            Station next = stations.get(i + 1);
            adjacent.get(sCode).put(next.getCode(), next);
        } else if (i > 0 && i < size-1) {
            Station next = stations.get(i + 1);
            adjacent.get(sCode).put(next.getCode(), next);
            Station pre = stations.get(i - 1);
            adjacent.get(sCode).put(pre.getCode(), pre);
        } else if (i == size -1) {
            Station pre = stations.get(i - 1);
            adjacent.get(sCode).put(pre.getCode(), pre);
        }
    }

    @Override
    public void addNode() {

    }

    @Override
    public float distanceOfRoute(List<String> route) {
        return 0;
    }

    @Override
    public void pathOfTravel(String start, String end) {

    }
}
