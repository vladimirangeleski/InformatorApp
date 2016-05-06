package rotaryinformatorapp.com.rotaryinformatorapp.model;

/**
 * Created by Vladimir on 5/6/2016.
 */
public class SubCategory {
    private int id;
    private String name;
    private int resource;

    public SubCategory(int id, String name, int resource) {
        this.id = id;
        this.name = name;
        this.resource = resource;
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

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }
}
