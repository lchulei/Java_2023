package lab1;

import java.util.Objects;

/**
 * Клас, що представляє транспортний засіб.
 */
public class Vehicle implements Comparable<Vehicle> {
    private String brand;  // Марка транспортного засобу
    private String model;  // Модель транспортного засобу
    private int year;      // Рік випуску транспортного засобу

    public Vehicle() {

    }

    /**
     * Конструктор для створення об'єкта класу Vehicle.
     *
     * @param brand Марка транспортного засобу.
     * @param model Модель транспортного засобу.
     * @param year  Рік випуску транспортного засобу.
     */
    protected Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    /**
     * Отримати марку транспортного засобу.
     *
     * @return Марка транспортного засобу.
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Встановити марку транспортного засобу.
     *
     * @param brand Нова марка транспортного засобу.
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Отримати модель транспортного засобу.
     *
     * @return Модель транспортного засобу.
     */
    public String getModel() {
        return model;
    }

    /**
     * Встановити модель транспортного засобу.
     *
     * @param model Нова модель транспортного засобу.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Отримати рік випуску транспортного засобу.
     *
     * @return Рік випуску транспортного засобу.
     */
    public int getYear() {
        return year;
    }

    /**
     * Встановити рік випуску транспортного засобу.
     *
     * @param year Новий рік випуску транспортного засобу.
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Перевизначений метод для отримання рядкового представлення об'єкта.
     *
     * @return Рядкове представлення об'єкта.
     */
    @Override
    public String toString() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }

    /**
     * Перевизначений метод для порівняння об'єктів.
     *
     * @param o Об'єкт, з яким порівнюється поточний об'єкт.
     * @return true, якщо об'єкти рівні, інакше - false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return year == vehicle.year &&
                Objects.equals(brand, vehicle.brand) &&
                Objects.equals(model, vehicle.model);
    }

    /**
     * Перевизначений метод для генерації хеш-коду об'єкта.
     *
     * @return Хеш-код об'єкта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(brand, model, year);
    }

    @Override
    public int compareTo(Vehicle v) {
        if (brand.compareTo(v.brand) != 0) {
            return brand.compareTo(v.brand);
        } else if (model.compareTo(v.model) != 0) {
            return model.compareTo(v.model);
        } if (year != v.year) {
            return year - v.year;
        } else {
            return 0;
        }
    }

    /**
     * Внутрішній статичний клас Builder для конструювання об'єкта Vehicle.
     */
    public static class VehicleBuilder {
        private String brand;
        private String model;
        private int year;

        /**
         * Встановити марку транспортного засобу.
         *
         * @param brand Марка транспортного засобу.
         * @return Поточний об'єкт Builder.
         */
        public VehicleBuilder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        /**
         * Встановити модель транспортного засобу.
         *
         * @param model Модель транспортного засобу.
         * @return Поточний об'єкт Builder.
         */
        public VehicleBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        /**
         * Встановити рік випуску транспортного засобу.
         *
         * @param year Рік випуску транспортного засобу.
         * @return Поточний об'єкт Builder.
         */
        public VehicleBuilder setYear(int year) {
            this.year = year;
            return this;
        }

        /**
         * Побудувати об'єкт Vehicle за допомогою параметрів, встановлених в Builder.
         *
         * @return Об'єкт Vehicle.
         */
        public Vehicle build() {
            return new Vehicle(brand, model, year);
        }
    }
}
