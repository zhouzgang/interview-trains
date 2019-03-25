package cn.ecomb.metro.input;

import org.junit.Test;

import java.io.InputStreamReader;

/**
 * @author zhouzg
 * @date 2019/3/25
 */
public class FileInputDataTest {

    @Test
    public void readDataTest() {
        this.getClass().getResourceAsStream("/metro.json");
        InputStreamReader inputStreamReader = new InputStreamReader(this.getClass().getResourceAsStream("/metro.json"));
        FileInputData fileInputData = new FileInputData();
        fileInputData.readData(inputStreamReader);
    }

}