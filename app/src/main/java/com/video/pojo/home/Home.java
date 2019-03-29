package com.video.pojo.home;

import com.google.gson.annotations.SerializedName;
import com.video.pojo.root.Tui;

import java.util.List;

public class Home {


    /**
     * type : home
     * new : [{"name":"大地的女儿","source":{"eps":[{"name":"hd高清","url":"https://yun.kubozy-youku-163.com/20190328/9426_e39ba189/index.m3u8"}]}},{"name":"大放异彩","source":{"eps":[{"name":"hd高清","url":"https://yun.kubozy-youku-163.com/20190328/9427_1094b610/index.m3u8"}]}},{"name":"地狱来的房东","source":{"eps":[{"name":"hd高清","url":"https://yun.kubozy-youku-163.com/20190328/9428_67e7868c/index.m3u8"}]}},{"name":"淘气小女巫","source":{"eps":[{"name":"hd高清","url":"https://yun.kubozy-youku-163.com/20190328/9429_6606bc06/index.m3u8"}]}},{"name":"金玉良言","source":{"eps":[{"name":"hd高清","url":"https://yun.kubozy-youku-163.com/20190328/9431_7dd430cf/index.m3u8"}]}},{"name":"苦难","source":{"eps":[{"name":"hd高清","url":"https://yun.kubozy-youku-163.com/20190328/9432_d6dc02fb/index.m3u8"}]}},{"name":"女巫斗恶龙","source":{"eps":[{"name":"hd720p","url":"https://yun.kubozy-youku-163.com/20190328/9419_8b55b172/index.m3u8"}]}},{"name":"第26届东方风云榜音乐盛典","source":{"eps":[{"name":"(上)20190328","url":"https://135zyv6.xw0371.com/2019/03/28/Ta47krYH75SrvjuR/playlist.m3u8"}]}},{"name":"山田孝之","source":{"eps":[{"name":"720p","url":"https://135zyv6.xw0371.com/2019/03/28/HBctqInaXm08hyXY/playlist.m3u8"}]}},{"name":"麦田守望的女孩","source":{"eps":[{"name":"HD高清","url":"https://135zyv6.xw0371.com/2019/03/28/RiB7dXgTxcnckSWa/playlist.m3u8"}]}}]
     * hot : [{"name":"大黄蜂","source":{"eps":[{"name":"HD1080无字版","url":"https://135zyv6.xw0371.com/2018/12/16/bXBsnQhCZDWm3mLm/playlist.m3u8"}]}},{"name":"天气预爆","source":{"eps":[{"name":"HDTC高清版","url":"https://yong.yongjiu6.com/20181221/Ap4GaWfV/index.m3u8"}]}},{"name":"我为花狂","source":{"eps":[{"name":"HD高清","url":"https://www.hongxinhuaxue.com/20190127/L5YDXm2H/index.m3u8"}]}},{"name":"素媛","source":{"eps":[{"name":"HD720P中字","url":"https://vs1.baduziyuan.com/20181119/lJXEJDlk/index.m3u8"}]}},{"name":"CNN 世界各地的性和爱: 上海","source":{"eps":[{"name":"HD720P中字","url":"https://vs1.baduziyuan.com/20180430/XMLfPY0Z/index.m3u8"}]}},{"name":"我们的1944","source":{"eps":[{"name":"HD中字","url":"https://kakazy-yun.com/20181217/12986_faedfc02/index.m3u8"}]}},{"name":"神探蒲松龄","source":{"eps":[{"name":"HDTC清晰版","url":"https://videos5.jsyunbf.com/2019/02/05/V0Jousqp54XYPbog/playlist.m3u8"}]}},{"name":"憨豆特工3","source":{"eps":[{"name":"TS720清晰中字","url":"https://videos4.jsyunbf.com/2018/10/11/wcejK6Dm6zaiQfnZ/playlist.m3u8"}]}},{"name":"第26届东方风云榜音乐盛典","source":{"eps":[{"name":"(上)20190328","url":"https://135zyv6.xw0371.com/2019/03/28/Ta47krYH75SrvjuR/playlist.m3u8"}]}},{"name":"神勇飞虎霸王花","source":{"eps":[{"name":"HD1080P中字","url":"https://videos.fjhps.com/20170925/QpP2n78L/index.m3u8"}]}}]
     * tui : [{"showName":"淘宝天猫优惠券","showType":"text","clickType":"link","clickContent":"https://temai.m.taobao.com/index.htm?pid=mm_30629912_364300319_100921950373","clickId":"bhtq3tkrtr3cpr1mikv0"},{"showName":"雅士利营养品专卖","showType":"text","clickType":"link","clickContent":"https://shop215422730.taobao.com","clickId":"bi2aibo6kkmr10cmap4g"}]
     */

    public String type;
    @SerializedName("new")
    public List<New> newX;
    public List<Hot> hot;
    public List<Tui> tui;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<New> getNewX() {
        return newX;
    }

    public void setNewX(List<New> newX) {
        this.newX = newX;
    }

    public List<Hot> getHot() {
        return hot;
    }

    public void setHot(List<Hot> hot) {
        this.hot = hot;
    }

    public List<Tui> getTui() {
        return tui;
    }

    public void setTui(List<Tui> tui) {
        this.tui = tui;
    }
}
