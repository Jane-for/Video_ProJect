package com.video.pojo.home_x;

import java.util.List;

public class ViewItemModels {
    /**
     * videos : [{"publishTime":2018,"score":9,"doubanId":"","img":"https://img3.doubanio.com/view/photo/m_ratio_poster/public/p2519070834.jpg","movieTypeName":"电影","album":true,"name":"我不是药神","movieId":-434435577,"disable2":true,"status":"","lastUpdateTime":"2019-03-28 23:00:16"},{"publishTime":2018,"score":0,"doubanId":"","img":"http://wx3.sinaimg.cn/mw690/006We1hygy1fyqzwfjot7j304805z74e.jpg","movieTypeName":"电影","album":true,"name":"绿皮书","movieId":-588472656,"disable2":false,"status":"BD高清 共130分钟","lastUpdateTime":"2019-03-14 10:50:17"},{"publishTime":2018,"score":8,"doubanId":"","img":"https://img3.doubanio.com/view/photo/m_ratio_poster/public/p2535096871.jpg","movieTypeName":"电影","album":true,"name":"无双","movieId":1160126003,"disable2":true,"status":"BD高清 共130分钟","lastUpdateTime":"2019-02-04 00:17:23"},{"publishTime":2018,"score":8.1,"doubanId":"","img":"https://img3.doubanio.com/view/photo/m_ratio_poster/public/p2539661066.jpg","movieTypeName":"电影","album":true,"name":"无名之辈","movieId":1651967104,"disable2":false,"status":"HD高清 共100分钟","lastUpdateTime":"2019-01-04 08:21:14"},{"publishTime":2018,"score":7.3,"doubanId":"3168101","img":"https://img3.doubanio.com/view/photo/m_ratio_poster/public/p2536447516.jpg","movieTypeName":"电影","album":true,"name":"毒液:致命守护者","movieId":1894577920,"disable2":false,"status":"Ts抢先版","lastUpdateTime":"2018-10-05 15:14:21"},{"publishTime":2018,"score":6.9,"doubanId":"30122633","img":"https://img3.doubanio.com/view/photo/m_ratio_poster/public/p2531080870.jpg","movieTypeName":"电影","album":true,"name":"快把我哥带走","movieId":-708674414,"disable2":true,"status":"全30集","lastUpdateTime":"2019-03-29 01:00:16"}]
     * title : 热门电影
     * moreUrl : movieheaven://filters?type=1&year=2018&sort=review
     */

    public String title;
    public String moreUrl;
    public List<Videos> videos;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMoreUrl() {
        return moreUrl;
    }

    public void setMoreUrl(String moreUrl) {
        this.moreUrl = moreUrl;
    }

    public List<Videos> getVideos() {
        return videos;
    }

    public void setVideos(List<Videos> videos) {
        this.videos = videos;
    }
}
