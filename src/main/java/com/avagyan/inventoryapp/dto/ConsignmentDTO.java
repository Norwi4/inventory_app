package com.avagyan.inventoryapp.dto;

import java.time.LocalDate;

/**
 * Отображение накладной
 * @author Abaev Evgeniy
 */
public class ConsignmentDTO {
    /**
     * Идентификатор накладной
     */
    private Long id;
    /**
     * Артикл
     */
    private String article;
    /**
     * Название продуктта
     */
    private String productName;
    /**
     * Кол-во
     */
    private Integer quantity;
    /**
     * Годен до
     */
    private LocalDate expirationDate;
    /**
     * Дата создания накладной
     */
    private LocalDate comeInDate;
    /**
     * Идентификатор поставщика
     */
    private Long providerId;
    /**
     * Название организации поставщика
     */
    private String organizationName;
    /**
     * Ответственный от поставщика
     */
    private String responsible;

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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public LocalDate getComeInDate() {
        return comeInDate;
    }

    public void setComeInDate(LocalDate comeInDate) {
        this.comeInDate = comeInDate;
    }
}
