package com.qianfeng.manmankan.model.programas;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by Administrator on 2016/9/20.
 */
@Table(name="models")
public class ProgramaModel {

    /**
     * id : 3
     * name : 炉石传说
     * slug : heartstone
     * first_letter : L
     * status : 0
     * prompt : 1
     * image : http://image.quanmin.tv/0656f090299e5ad777a2f71d84b7fa11jpg
     * thumb : http://image.quanmin.tv/d84f4600207f67fe3e5fdeff21ded1bdpng
     * priority : 4
     * screen : 0
     */
    @Column(name = "id",isId = true,autoGen = false)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="slug")
    private String slug;

    private String first_letter;
    private int status;
    private int prompt;
    private String image;
    @Column(name="thumb")
    private String thumb;
    private int priority;
    private int screen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getFirst_letter() {
        return first_letter;
    }

    public void setFirst_letter(String first_letter) {
        this.first_letter = first_letter;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPrompt() {
        return prompt;
    }

    public void setPrompt(int prompt) {
        this.prompt = prompt;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getScreen() {
        return screen;
    }

    public void setScreen(int screen) {
        this.screen = screen;
    }
}
