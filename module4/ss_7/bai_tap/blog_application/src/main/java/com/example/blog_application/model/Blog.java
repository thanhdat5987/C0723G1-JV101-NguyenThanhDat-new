package com.example.blog_application.model;

import javax.persistence.*;

import static java.awt.SystemColor.TEXT;
import static java.awt.SystemColor.text;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String author;
    private String createDate;
    @Column(columnDefinition = "text")
    private String description;
    @Column(columnDefinition = "text")
    private String content;
    private String category;
    private String remark;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Blog(int id, String name, String author, String createDate, String description, String content, String category, String remark) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.createDate = createDate;
        this.description = description;
        this.content = content;
        this.category = category;
        this.remark = remark;
    }

    public Blog(int id, String name, String author, String createDate, String description, String content, String category) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.createDate = createDate;
        this.description = description;
        this.content = content;
        this.category = category;
    }

    public Blog() {
    }

    public Blog(int id, String name, String content, String remark) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.remark = remark;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
