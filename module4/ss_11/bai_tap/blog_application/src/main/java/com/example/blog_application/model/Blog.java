package com.example.blog_application.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String author;
    private LocalDateTime createDate;
    private String remark;
    @Column(columnDefinition = "text")
    private String description;
    @Column(columnDefinition = "text")
    private String content;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne
@JoinColumn(name="category_id")
private Category category;


    public Blog(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Blog(int id, String name, String author, LocalDateTime createDate, String description, String content, Category category, String remark) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.createDate = createDate;
        this.description = description;
        this.content = content;
        this.category = category;
        this.remark = remark;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Blog(int id, String name, String author, LocalDateTime createDate, String description, String content, Category category) {
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
