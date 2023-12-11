package lab5.models;

import java.util.Objects;

public class Model {
    private int id;
    private String name;
    private int brandId;

    public Model() {
    }

    public Model(int id, String name, int brandId) {
        this.id = id;
        this.name = name;
        this.brandId = brandId;
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

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brandId=" + brandId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model = (Model) o;
        return id == model.id &&
                brandId == model.brandId &&
                Objects.equals(name, model.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, brandId);
    }

    public static class ModelBuilder {
        private int id;
        private String name;
        private int brandId;

        public ModelBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public ModelBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ModelBuilder setBrandId(int brandId) {
            this.brandId = brandId;
            return this;
        }

        public Model build() {
            return new Model(id, name, brandId);
        }
    }
}