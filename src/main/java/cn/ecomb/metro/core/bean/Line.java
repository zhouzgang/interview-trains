package cn.ecomb.metro.core.bean;

import lombok.Data;

import java.util.List;

/**
 * 地铁线路
 * @author zhouzg
 * @date 2019/3/25
 */
@Data
public class Line {

    private String name;
    private String code;
    private List<Station> stations;
}
