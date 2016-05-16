package rotaryinformatorapp.com.rotaryinformatorapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladimir on 5/5/2016.
 */
public class Category implements Serializable {

    private int id;
    private String name;
    private int drawable;
    private int statusbarColor;
    private int actionbarColor;

    private List<SubCategory> subCategories = new ArrayList<>(30);

    public Category(int id, String name, int drawable, int statusbarColor, int actionbarColor) {
        this.id = id;
        this.name = name;
        this.drawable = drawable;
        this.statusbarColor = statusbarColor;
        this.actionbarColor = actionbarColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addSubCategory(SubCategory subCategory) {
        subCategories.add(subCategory);
    }

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", drawable=" + drawable +
                ", subCategories=" + subCategories +
                '}';
    }


    public int getStatusbarColor() {
        return statusbarColor;
    }

    public void setStatusbarColor(int statusbarColor) {
        this.statusbarColor = statusbarColor;
    }

    public int getActionbarColor() {
        return actionbarColor;
    }

    public void setActionbarColor(int actionbarColor) {
        this.actionbarColor = actionbarColor;
    }
}
