package com.qianfeng.manmankan.model.recommends;

/**
 * Created by SacuraQH on 2016/9/20.
 */
public class Index {

    /**
     * id : 430
     * title : 总觉得我的诺手可以1打9
     * thumb : http://image.quanmin.tv/9a424bebace8f9ec9a2ca4561b69fc2bjpg
     * link :
     * create_at : 2016-03-16 21:07:28
     * status : 1
     * fk : 326745
     * subtitle :
     * content :
     * ext :
     * slot_id : 105
     * priority : 3
     * link_object : {"recommend_image":"http://image.quanmin.tv/a31d5c90109cec5e0e0a3a267f9fc0f4jpg","announcement":"每天下午3点到10点左右。","title":"有种诺克叫做霸天斩。","create_at":"2016-09-20 14:55:23","intro":"保持善良 宽容，不忘初心。","video":"http://thumb.quanmin.tv/326745.mp4?t=1474369200","screen":0,"love_cover":"","category_id":"1","video_quality":"234","like":"3","default_image":"","slug":"qq312118607","weight":"66358580","status":"1","level":"0","avatar":"http://image.quanmin.tv/avatar/ad569547dfe896f22a7bc5b1d4ecd3d5gif?imageView2/2/w/300/","uid":"326745","play_at":"2016-09-20 14:55:23","view":"285151","category_slug":"lol","nick":"浏阳河长的像猴子","beauty_cover":"","app_shuffling_image":"http://image.quanmin.tv/3f727a8ac18a90a42d0de45926b38773jpg","follow":"101003","start_time":"2016-09-20 14:55:23","category_name":"英雄联盟","thumb":"http://image.quanmin.tv/9a424bebace8f9ec9a2ca4561b69fc2bjpg","grade":"","hidden":false}
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
     * recommend_image : http://image.quanmin.tv/a31d5c90109cec5e0e0a3a267f9fc0f4jpg
     * announcement : 每天下午3点到10点左右。
     * title : 有种诺克叫做霸天斩。
     * create_at : 2016-09-20 14:55:23
     * intro : 保持善良 宽容，不忘初心。
     * video : http://thumb.quanmin.tv/326745.mp4?t=1474369200
     * screen : 0
     * love_cover :
     * category_id : 1
     * video_quality : 234
     * like : 3
     * default_image :
     * slug : qq312118607
     * weight : 66358580
     * status : 1
     * level : 0
     * avatar : http://image.quanmin.tv/avatar/ad569547dfe896f22a7bc5b1d4ecd3d5gif?imageView2/2/w/300/
     * uid : 326745
     * play_at : 2016-09-20 14:55:23
     * view : 285151
     * category_slug : lol
     * nick : 浏阳河长的像猴子
     * beauty_cover :
     * app_shuffling_image : http://image.quanmin.tv/3f727a8ac18a90a42d0de45926b38773jpg
     * follow : 101003
     * start_time : 2016-09-20 14:55:23
     * category_name : 英雄联盟
     * thumb : http://image.quanmin.tv/9a424bebace8f9ec9a2ca4561b69fc2bjpg
     * grade :
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
        private String level;
        private String avatar;
        private String uid;
        private String play_at;
        private String view;
        private String category_slug;
        private String nick;
        private String beauty_cover;
        private String app_shuffling_image;
        private String follow;
        private String start_time;
        private String category_name;
        private String thumb;
        private String grade;
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

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
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

        public String getFollow() {
            return follow;
        }

        public void setFollow(String follow) {
            this.follow = follow;
        }

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public boolean isHidden() {
            return hidden;
        }

        public void setHidden(boolean hidden) {
            this.hidden = hidden;
        }
    }
}
