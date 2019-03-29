package com.video.pojo.home_x;

public class Videos {
    /**
     * publishTime : 2018
     * score : 9
     * doubanId :
     * img : https://img3.doubanio.com/view/photo/m_ratio_poster/public/p2519070834.jpg
     * movieTypeName : 电影
     * album : true
     * name : 我不是药神
     * movieId : -434435577
     * disable2 : true
     * status :
     * lastUpdateTime : 2019-03-28 23:00:16
     */

    public int publishTime;
    public double score;
    public String doubanId;
    public String img;
    public String movieTypeName;
    public boolean album;
    public String name;
    public int movieId;
    public boolean disable2;
    public String status;
    public String lastUpdateTime;


    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(int publishTime) {
        this.publishTime = publishTime;
    }


    public String getDoubanId() {
        return doubanId;
    }

    public void setDoubanId(String doubanId) {
        this.doubanId = doubanId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getMovieTypeName() {
        return movieTypeName;
    }

    public void setMovieTypeName(String movieTypeName) {
        this.movieTypeName = movieTypeName;
    }

    public boolean isAlbum() {
        return album;
    }

    public void setAlbum(boolean album) {
        this.album = album;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public boolean isDisable2() {
        return disable2;
    }

    public void setDisable2(boolean disable2) {
        this.disable2 = disable2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
