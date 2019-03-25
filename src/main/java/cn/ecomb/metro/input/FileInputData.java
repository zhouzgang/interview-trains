package cn.ecomb.metro.input;

import cn.ecomb.metro.core.bean.Line;
import cn.ecomb.metro.core.bean.MetroMap;
import cn.ecomb.metro.core.bean.Station;
import com.google.gson.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouzg
 * @date 2019/3/25
 */
public class FileInputData {

    /**
     * 读取地铁图数据
     * @param file
     * @return
     */
    public MetroMap readData(InputStreamReader file) {
        BufferedReader reader = null;
        MetroMap metroMap = new MetroMap();
        try {
            reader = new BufferedReader(file);
            JsonParser parser = new JsonParser();
            JsonObject metroJson = parser.parse(reader).getAsJsonObject();
            metroMap.setCityCode(metroJson.get("i").getAsString());
            metroMap.setCityName(metroJson.get("s").getAsString());
            JsonArray jsonArray = metroJson.getAsJsonArray("l");
            List<Line> lines = new ArrayList<>();
            for (int i = 0, size = jsonArray.size(); i < size; i++) {
                JsonObject lineJson = jsonArray.get(i).getAsJsonObject();
                Line line = new Line();
                line.setCode(lineJson.get("ls").getAsString());
                line.setName(lineJson.get("ln").getAsString());
                List<Station> stations = new ArrayList<>();
                JsonArray stationArray = lineJson.getAsJsonArray("st");
                for (int j = 0, s = stationArray.size(); j < s; j++) {
                    JsonObject stationJson = stationArray.get(j).getAsJsonObject();
                    Station station = new Station();
                    station.setCode(stationJson.get("poiid").getAsString());
                    station.setName(stationJson.get("n").getAsString());
                    station.setLineCode(lineJson.get("ls").getAsString());
                    station.setLineName(lineJson.get("ln").getAsString());
                    stations.add(station);
                }
                line.setStations(stations);
                lines.add(line);
            }
            metroMap.setLines(lines);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return metroMap;
    }
}
