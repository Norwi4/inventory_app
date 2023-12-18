package com.avagyan.inventoryapp.dto;

/**
 * ДТО списания блюда
 *
 * @author Abaev Evgeniy
 */
public class CancellationDish {
    private Long dishId;
    private Integer count;

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
