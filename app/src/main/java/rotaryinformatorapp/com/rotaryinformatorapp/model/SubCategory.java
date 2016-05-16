package rotaryinformatorapp.com.rotaryinformatorapp.model;

import java.io.Serializable;

/**
 * Created by Vladimir on 5/6/2016.
 */
public class SubCategory implements Serializable {
    private int id;
    private String name;
    private String assetFileName;
    private int color;

    public SubCategory(int id, String name, String assetFileName, int color) {
        this.id = id;
        this.name = name;
        this.assetFileName = assetFileName;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAssetFileName() {
        return assetFileName;
    }

    public void setAssetFileName(String assetFileName) {
        this.assetFileName = assetFileName;
    }

    @Override
    public String toString() {
        return "SubCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", assetFileName=" + assetFileName +
                '}';
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
