package com.avagyan.inventoryapp.dto;

/**
 * ДТО для заполнения кол-ва каждого ингредиента блюда
 *
 * @author Abaev Evgeniy
 */
public class ProductsDishDTO {
    private Long id;
    private String article;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
