package com.qianfeng.manmankan.model.recommends;

/**
 * Created by SacuraQH on 2016/9/20.
 */
public class Recommendation {

    /**
     * id : 1181
     * title : 【眼镜】清新游戏 提神醒脑
     * thumb :
     * link :
     * create_at : 2016-06-28 19:20:10
     * status : 1
     * fk : 326091
     * subtitle :
     * content :
     * ext :
     * slot_id : 104
     * priority : 0
     * link_object : {"recommend_image":"","announcement":"QQ群469768321","title":"【眼镜】清新游戏 提神醒脑","create_at":"2016-09-20 11:16:45","intro":"欢迎各位来到本直播间。喜欢的关注关注 \n主播配置\n电脑型号：微星 MS-7816\n操作系统：Windows 7旗舰版\n处理器    :英特尔 第四代酷睿i7-4790 @3.60GHZ四核\n主板      ：微星B85-G43 GAMING\n内存      ：16GB（金士顿DDR3 1866MGz）\n主硬盘   ：三星SSD 850 EVO 120GB 固态硬盘\n显卡      ：Nvidia GeForce GTX 960\n显示器   ：冠捷 AOC2579 2579","video":"http://thumb.quanmin.tv/326091.mp4?t=1474369200","screen":0,"love_cover":"","category_id":"5","video_quality":"","like":"0","default_image":"","slug":"fkmeman","weight":"8958280","status":"1","avatar":"http://image.quanmin.tv/avatar/e2729241a73ac976a79103545ec2376cjpeg?imageView2/2/w/300/","level":"0","uid":"326091","play_at":"2016-09-20 11:16:45","view":"8876","category_slug":"tvgame","nick":"C眼镜","beauty_cover":"","app_shuffling_image":"","start_time":"2016-09-20 15:23:10","follow":"2373","category_name":"单机主机","grade":"","thumb":"http://snap.quanmin.tv/326091-1474369241-211.jpg?imageView2/2/w/390/","hidden":false}
     */

    private int id;
    private String title;
    private String thumb;
    private String link;
    private String create_at;
    private int status;
    private String fk;
    private String subtitle;
    private String content;
    private String ext;
    private int slot_id;
    private int priority;
    /**
     * recommend_image :
     * announcement : QQ群469768321
     * title : 【眼镜】清新游戏 提神醒脑
     * create_at : 2016-09-20 11:16:45
     * intro : 欢迎各位来到本直播间。喜欢的关注关注
     主播配置
     电脑型号：微星 MS-7816
     操作系统：Windows 7旗舰版
     处理器    :英特尔 第四代酷睿i7-4790 @3.60GHZ四核
     主板      ：微星B85-G43 GAMING
     内存      ：16GB（金士顿DDR3 1866MGz）
     主硬盘   ：三星SSD 850 EVO 120GB 固态硬盘
     显卡      ：Nvidia GeForce GTX 960
     显示器   ：冠捷 AOC2579 2579
     * video : http://thumb.quanmin.tv/326091.mp4?t=1474369200
     * screen : 0
     * love_cover :
     * category_id : 5
     * video_quality :
     * like : 0
     * default_image :
     * slug : fkmeman
     * weight : 8958280
     * status : 1
     * avatar : http://image.quanmin.tv/avatar/e2729241a73ac976a79103545ec2376cjpeg?imageView2/2/w/300/
     * level : 0
     * uid : 326091
     * play_at : 2016-09-20 11:16:45
     * view : 8876
     * category_slug : tvgame
     * nick : C眼镜
     * beauty_cover :
     * app_shuffling_image :
     * start_time : 2016-09-20 15:23:10
     * follow : 2373
     * category_name : 单机主机
     * grade :
     * thumb : http://snap.quanmin.tv/326091-1474369241-211.jpg?imageView2/2/w/390/
     * hidden : false
     */

    private LinkObjectBean link_object;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getFk() {
        return fk;
    }

    public void setFk(String fk) {
        this.fk = fk;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public int getSlot_id() {
        return slot_id;
    }

    public void setSlot_id(int slot_id) {
        this.slot_id = slot_id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public LinkObjectBean getLink_object() {
        return link_object;
    }

    public void setLink_object(LinkObjectBean link_object) {
        this.link_object = link_object;
    }

    public static class LinkObjectBean {
        private String recommend_image;
        private String announcement;
        private String title;
        private String create_at;
        private String intro;
        private String video;
        private int screen;
        private String love_cover;
        private String category_id;
        private String video_quality;
        private String like;
        private String default_image;
        private String slug;
        private String weight;
        private String status;
        private String avatar;
        private String level;
        private String uid;
        private String play_at;
        private String view;
        private String category_slug;
        private String nick;
        private String beauty_cover;
        private String app_shuffling_image;
        private String start_time;
        private String follow;
        private String category_name;
        private String grade;
        private String thumb;
        private boolean hidden;

        public String getRecommend_image() {
            return recommend_image;
        }

        public void setRecommend_image(String recommend_image) {
            this.recommend_image = recommend_image;
        }

        public String getAnnouncement() {
            return announcement;
        }

        public void setAnnouncement(String announcement) {
            this.announcement = announcement;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCreate_at() {
            return create_at;
        }

        public void setCreate_at(String create_at) {
            this.create_at = create_at;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        public int getScreen() {
            return screen;
        }

        public void setScreen(int screen) {
            this.screen = screen;
        }

        public String getLove_cover() {
            return love_cover;
        }

        public void setLove_cover(String love_cover) {
            this.love_cover = love_cover;
        }

        public String getCategory_id() {
            return category_id;
        }

        public void setCategory_id(String category_id) {
            this.category_id = category_id;
        }

        public String getVideo_quality() {
            return video_quality;
        }

        public void setVideo_quality(String video_quality) {
            this.video_quality = video_quality;
        }

        public String getLike() {
            return like;
        }

        public void setLike(String like) {
            this.like = like;
        }

        public String getDefault_image() {
            return default_image;
        }

        public void setDefault_image(String default_image) {
            this.default_image = default_image;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getPlay_at() {
            return play_at;
        }

        public void setPlay_at(String play_at) {
            this.play_at = play_at;
        }

        public String getView() {
            return view;
        }

        public void setView(String view) {
            this.view = view;
        }

        public String getCategory_slug() {
            return category_slug;
        }

        public void setCategory_slug(String category_slug) {
            this.category_slug = category_slug;
        }

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public String getBeauty_cover() {
            return beauty_cover;
        }

        public void setBeauty_cover(String beauty_cover) {
            this.beauty_cover = beauty_cover;
        }

        public String getApp_shuffling_image() {
            return app_shuffling_image;
        }

        public void setApp_shuffling_image(String app_shuffling_image) {
            this.app_shuffling_image = app_shuffling_image;
        }

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public String getFollow() {
            return follow;
        }

        public void setFollow(String follow) {
            this.follow = follow;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public boolean isHidden() {
            return hidden;
        }

        public void setHidden(boolean hidden) {
            this.hidden = hidden;
        }
    }
}
