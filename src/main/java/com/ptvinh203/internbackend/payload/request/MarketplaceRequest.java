package com.ptvinh203.internbackend.payload.request;

import com.ptvinh203.internbackend.annotation.JsonSnakeCaseNaming;
import com.ptvinh203.internbackend.util.base_model.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@JsonSnakeCaseNaming
public class MarketplaceRequest extends AbstractEntity {
    private String id;
    private String name;
    private String address;
    private Double area;
    private String typeId;
    private Double price;
    private LocalDate date;
    private String description;

    public String checkValid() {
        if (id == null || name == null || address == null || area == null || typeId == null || price == null || date == null || description == null) {
            return "All properties are required!";
        }

        if (!id.startsWith("MB")) return "Invalid id! id must be start with 'MB'";
        try {
            Integer.parseInt(id.substring(2));
        } catch (Exception ex) {
            return "Invalid id! Last characters must be a number!";
        }

        if (area < 10) return "Area must be bigger than 10m2";
        if (price < 500000) return "Price must be bigger than 500.000VND";
        if (date.isBefore(LocalDate.now())) return "Invalid date";
        return "";
    }
}
