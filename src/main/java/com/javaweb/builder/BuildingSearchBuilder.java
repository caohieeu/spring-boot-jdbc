package com.javaweb.builder;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class BuildingSearchBuilder {
    String name;
    Double floor_area;
    String ward;
    Long district_id;
    Integer basement_number;
    List<String> typeCode = new ArrayList<>();
    String managerName;  
    String managerPhoneNumber;  
    Double rentPriceFrom;
    Double rentPriceTo;
    Double areaFrom;
    Double areaTo;
    Long staffId;
    
    public BuildingSearchBuilder(Builder builder) {
        this.name = builder.name;
        this.floor_area = builder.floor_area;
        this.ward = builder.ward;
        this.district_id = builder.district_id;
        this.basement_number = builder.basement_number;
        this.typeCode = builder.typeCode;
        this.managerName = builder.managerName;
        this.managerPhoneNumber = builder.managerPhoneNumber;
        this.rentPriceFrom = builder.rentPriceFrom;
        this.rentPriceTo = builder.rentPriceTo;
        this.areaFrom = builder.areaFrom;
        this.areaTo = builder.areaTo;
        this.staffId = builder.staffId;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public Double getFloor_area() {
        return floor_area;
    }

    public String getWard() {
        return ward;
    }

    public Long getDistrictId() {
        return district_id;
    }

    public Integer getBasement_number() {
        return basement_number;
    }

    public List<String> getTypeCode() {
        return typeCode;
    }

    public String getManagerName() {
        return managerName;
    }

    public String getManagerPhoneNumber() {
        return managerPhoneNumber;
    }
    
    public Double getRentPriceFrom() {
        return rentPriceFrom;
    }

    public Double getRentPriceTo() {
        return rentPriceTo;
    }
    
    public Double getAreaFrom() {
        return areaFrom;
    }
    
    public Double getAreaTo() {
        return areaTo;
    }
    
    public Long getStaffId() {
        return staffId;
    }

    // Static inner Builder class
    public static class Builder {
        String name;
        Double floor_area;
        String ward;
        Long district_id;
        Integer basement_number;
        List<String> typeCode = new ArrayList<>();
        String managerName;
        String managerPhoneNumber;
        Double rentPriceFrom;
        Double rentPriceTo;
        Double areaFrom;
        Double areaTo;
        Long staffId;

        // Builder methods
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setFloor_area(Double floor_area) {
            this.floor_area = floor_area;
            return this;
        }

        public Builder setWard(String ward) {
            this.ward = ward;
            return this;
        }

        public Builder setDistrictId(Long district_id) {
            this.district_id = district_id;
            return this;
        }

        public Builder setBasement_number(Integer basement_number) {
            this.basement_number = basement_number;
            return this;
        }

        public Builder setTypeCode(List<String> typeCode) {
            this.typeCode = typeCode;
            return this;
        }

        public Builder setManagerName(String managerName) {
            this.managerName = managerName;
            return this;
        }

        public Builder setManagerPhoneNumber(String managerPhoneNumber) {
            this.managerPhoneNumber = managerPhoneNumber;
            return this;
        }
        
        public Builder setRentPriceFrom(Double rentPriceFrom) {
            this.rentPriceFrom = rentPriceFrom;
            return this;
        }

        public Builder setRentPriceTo(Double rentPriceTo) {
            this.rentPriceTo = rentPriceTo;
            return this;
        }
        
        public Builder setAreaFrom(Double areaFrom) {
            this.areaFrom = areaFrom;
            return this;
        }
        
        public Builder setAreaTo(Double areaTo) {
            this.areaTo = areaTo;
            return this;
        }
        
        public Builder setStaffId(Long staffId) {
            this.staffId = staffId;
            return this;
        }
        
        public BuildingSearchBuilder build() {
            return new BuildingSearchBuilder(this);
        }
    }
}
