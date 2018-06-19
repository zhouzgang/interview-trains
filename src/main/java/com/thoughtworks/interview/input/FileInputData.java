package com.thoughtworks.interview.input;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 以文件形式读取图构建数据
 *
 * @author zhouzhigang
 * @date 2018/6/14.
 */
public class FileInputData implements InputData{

    /** 图构建数据默认分隔符 */
    private static final String DEFAULT_SEPARATOR = ",";

    /** 数据文件的默认路径 */
    private static final String DEFAULT_FILE_PATH = "/data.txt";

    /** 图构建数据 */
    private List<VertexData> datas = new ArrayList<VertexData>();

    /** 图节点 */
    private HashSet<String> nodes = new HashSet<String>();


    private void readData() {
        File file = new File(FileInputData.class.getResource(DEFAULT_FILE_PATH).toString());
        try {
            readData(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从文件中读取数据
     */
    private void readData(InputStream inputStream) {
        InputStreamReader read = null;
        try {
            read = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt;
            while((lineTxt = bufferedReader.readLine()) != null) {
                String[] lineNodes = lineTxt.split(DEFAULT_SEPARATOR);
                for (int i = 0, length = lineNodes.length; i < length; i++) {
                    VertexData vd = new VertexData();
                    String node = lineNodes[i];
                    vd.setFrom(String.valueOf(node.charAt(0)))
                            .setTo(String.valueOf(node.charAt(1)))
                            .setWeight(Integer.parseInt(node.substring(2, node.length())));
                    nodes.add(String.valueOf(node.charAt(0)));
                    nodes.add(String.valueOf(node.charAt(1)));
                    datas.add(vd);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                read.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public List<VertexData> getData() {
        if (datas.size() == 0) {
            readData();
        }
        return datas;
    }

    @Override
    public Set<String> getNodes() {
        if (datas.size() == 0) {
            readData();
        }
        return nodes;
    }

    @Override
    public List<VertexData> getData(InputStream inputStream) {
        if (datas.size() == 0) {
            readData(inputStream);
        }
        return datas;
    }

    @Override
    public Set<String> getNodes(InputStream inputStream) {
        if (datas.size() == 0) {
            readData(inputStream);
        }
        return nodes;
    }

}











