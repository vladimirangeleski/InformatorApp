package rotaryinformatorapp.com.rotaryinformatorapp.model;

/**
 * Created by Vladimir on 5/5/2016.
 */
public class Category {

    private String name;
    private int drawable;

    public Category(String name, int drawable) {
        this.name = name;
        this.drawable = drawable;
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
}
