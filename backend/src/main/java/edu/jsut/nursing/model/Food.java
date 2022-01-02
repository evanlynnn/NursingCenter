package edu.jsut.nursing.model;

public class Food {
    private Integer foodId;

    private String name;

    private Double protein;

    private Double cho;

    private Double heat;

    private Double fat;

    private String imgName;

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public Double getCho() {
        return cho;
    }

    public void setCho(Double cho) {
        this.cho = cho;
    }

    public Double getHeat() {
        return heat;
    }

    public void setHeat(Double heat) {
        this.heat = heat;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName == null ? null : imgName.trim();
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodId=" + foodId +
                ", name='" + name + '\'' +
                ", protein=" + protein +
                ", cho=" + cho +
                ", heat=" + heat +
                ", fat=" + fat +
                ", imgName='" + imgName + '\'' +
                '}';
    }
}