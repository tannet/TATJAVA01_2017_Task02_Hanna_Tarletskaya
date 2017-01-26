package com.epam.sport_shop;

public class Category {
    private String category;

    Category(String category) {
        setCategory(category);
    }


    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return this.category;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category1 = (Category) o;

        return category != null ? category.equals(category1.category) : category1.category == null;
    }

    @Override
    public int hashCode() {
        return category != null ? category.hashCode() : 0;
    }

    @Override
    public String toString() {
        return getCategory();
    }
}
