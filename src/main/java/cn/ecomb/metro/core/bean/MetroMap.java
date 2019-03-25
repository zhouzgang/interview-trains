package cn.ecomb.metro.core.bean;

import lombok.Data;

import java.util.List;

/**
 * 地铁线路图
 * @author zhouzg
 * @date 2019/3/25
 */
@Data
public class MetroMap {

    private String cityCode;
    private String cityName;
    private List<Line> lines;

}
