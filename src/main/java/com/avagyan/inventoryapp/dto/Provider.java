package com.avagyan.inventoryapp.dto;

/**
 * Модель поставщик
 *
 * @author Abaev Evgeniy
 */
public class Provider {
    /**
     * Идентификатор поставщика
     */
    private Long id;
    /**
     * Наименование организации
     */
    private String organizationName;
    /**
     * ФИО ответственного лица
     */
    private String responsible;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
