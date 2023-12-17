package com.avagyan.inventoryapp.dto;

import com.avagyan.inventoryapp.settings.Codable;

import java.time.LocalDate;
import java.util.Optional;

/**
 * Списание товаров
 *
 * @author Abaev Evgeniy
 */
public class Cancellation {
    private Long id;
    /**
     * Дата работы
     */
    private LocalDate date;
    /**
     * Тип работы
     */
    private Code code;
    /**
     * Номер склада
     */
    private Long warehouseId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }



    public enum Code implements Codable<String> {
        IN("IN"),
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
