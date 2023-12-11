package lab5.models;

public class Brand {
    private int id;
    private String name;

    public Brand() {
    }

    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
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

    public static class BrandBuilder {
        private int id;
        private String name;

        public BrandBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public BrandBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public Brand build() {
            return new Brand(id, name);
        }
    }
}