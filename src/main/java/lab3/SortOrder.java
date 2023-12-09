package lab3;

public enum SortOrder {
    ASCENDING("Ascending"),
    DESCENDING("Descending");

    private String name;

    SortOrder(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
