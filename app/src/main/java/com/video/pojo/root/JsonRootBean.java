/**
 * Copyright 2019 bejson.com
 */
package com.video.pojo.root;

import java.util.List;

/**
 * Auto-generated: 2019-03-28 13:48:34
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class JsonRootBean {

    private String type;
    private List<Data> data;
    private String ep;
    private List<Tui> tui;

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public List<Data> getData() {
        return data;
    }

    public void setEp(String ep) {
        this.ep = ep;
    }

    public String getEp() {
        return ep;
    }

    public void setTui(List<Tui> tui) {
        this.tui = tui;
    }

    public List<Tui> getTui() {
        return tui;
    }

}