package lab1;

import java.util.Objects;

/**
 * Клас, що представляє транспортний засіб вантажівку, яка є підкласом транспортного засобу.
 */
public class Truck extends Vehicle implements Comparable<Vehicle> {
    /** Вантажопідйомність вантажівки. */
    private int cargoCapacity;

    public Truck() {
        super();
    }

    /**
     * Конструктор для створення об'єкта класу Truck.
     *
     * @param brand         Марка вантажівки.
     * @param model         Модель вантажівки.
     * @param year          Рік випуску вантажівки.
     * @param cargoCapacity Вантажопідйомність вантажівки.
     */
    protected Truck(String brand, String model, int year, int cargoCapacity) {
        super(brand, model, year);
        this.cargoCapacity = cargoCapacity;
    }

    /**
     * Отримати вантажопідйомність вантажівки.
     *
     * @return Вантажопідйомність.
     */
    public int getCargoCapacity() {
        return cargoCapacity;
    }

    /**
     * Перевизначений метод для отримання рядкового представлення об'єкта.
     *
     * @return Рядкове представлення об'єкта.
     */
    @Override
    public String toString() {
        return "Truck{" +
                "brand='" + getBrand() + '\'' +
                ", model='" + getModel() + '\'' +
                ", year=" + getYear() +
                ", cargoCapacity=" + cargoCapacity +
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
        if (!super.equals(o)) return false;
        Truck truck = (Truck) o;
        return cargoCapacity == truck.cargoCapacity;
    }

    /**
     * Перевизначений метод для генерації хеш-коду об'єкта.
     *
     * @return Хеш-код об'єкта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cargoCapacity);
    }

    @Override
    public int compareTo(Vehicle v) {
        if (!(v instanceof Truck)) {
            return super.compareTo(v);
        }
        Truck t = (Truck) v;
        if (super.compareTo(t) == 0) {
            return cargoCapacity - t.cargoCapacity;
        }
        return super.compareTo(t);
    }

    /**
     * Статичний клас Builder для побудови об'єктів класу Truck.
     */
    public static class TruckBuilder {
        private String brand;
        private String model;
        private int year;
        private int cargoCapacity;

        /**
         * Встановити марку мотоцикла.
         *
         * @param brand Марка мотоцикла.
         * @return Посилання на об'єкт білдера.
         */
        public Truck.TruckBuilder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        /**
         * Встановити модель мотоцикла.
         *
         * @param model Модель мотоцикла.
         * @return Посилання на об'єкт білдера.
         */
        public Truck.TruckBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        /**
         * Встановити рік випуску мотоцикла.
         *
         * @param year Рік випуску мотоцикла.
         * @return Посилання на об'єкт білдера.
         */
        public Truck.TruckBuilder setYear(int year) {
            this.year = year;
            return this;
        }


        /**
         * Встановити вантажопідйомність вантажівки.
         *
         * @param cargoCapacity Вантажопідйомність вантажівки.
         * @return Поточний об'єкт TruckBuilder для подальшої побудови.
         */
        public TruckBuilder setCargoCapacity(int cargoCapacity) {
            this.cargoCapacity = cargoCapacity;
            return this;
        }

        /**
         * Метод для створення об'єкта класу Truck на основі параметрів TruckBuilder.
         *
         * @return Новий об'єкт класу Truck.
         */
        public Truck build() {
            return new Truck(brand, model, year, cargoCapacity);
        }
    }
}
