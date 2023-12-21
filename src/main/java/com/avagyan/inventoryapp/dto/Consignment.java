package com.avagyan.inventoryapp.dto;

import com.avagyan.inventoryapp.settings.Codable;

import java.time.LocalDate;

/**
 * Модель накладной
 *
 * @author Abaev Evgeniy
 */
public class Consignment {
    /**
     * Идентификатор накладной
     */
    private Long id;
    /**
     * Артикл
     */
    private String article;
    /**
     * Кол-во
     */
    private Integer quantity;
    /**
     * Цена за штуку
     */
    private Integer price;
    /**
     * Цена в сумме
     */
    private Integer totalPrice;
    /**
     * Дата
     */
    private LocalDate expirationDate;
    /**
     * Поставщик
     */
    private Long providerId;
    /**
     * Тип работы (приемка/списание)
     */
    private Code code;

    public Consignment() {

    }
    public Consignment(String article, Integer quantity) {
        this.article = article;
        this.quantity = quantity;
    }

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDate getDate() {
        return expirationDate;
    }

    public void setDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public enum Code implements Codable<String> {

        /**
         * Публичный доступ
         */
        IN("IN"),

        /**
         * Персональные данные
         */
        OUT("OUT");

        private final String code;

        Code(String code) {
            this.code = code;
        }

        @Override
        public String getCode() {
            return code;
        }
    }
}
