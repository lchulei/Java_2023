package lab1;

import java.util.Objects;

/**
 * Клас, що представляє транспортний засіб вантажівку, яка є підкласом транспортного засобу.
 */
class Truck extends Vehicle {
    /** Вантажопідйомність вантажівки. */
    private int cargoCapacity;

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
    /**
     * Статичний клас Builder для побудови об'єктів класу Truck.
     */
    public static class TruckBuilder {
        private final String brand;
        private final String model;
        private final int year;
        private int cargoCapacity;

        /**
         * Конструктор для об'єкта класу TruckBuilder, який приймає обов'язкові параметри.
         *
         * @param brand Марка вантажівки.
         * @param model Модель вантажівки.
         * @param year  Рік випуску вантажівки.
         */
        public TruckBuilder(String brand, String model, int year) {
            this.brand = brand;
            this.model = model;
            this.year = year;
        }

        /**
         * Встановити вантажопідйомність вантажівки.
         *
         * @param cargoCapacity Вантажопідйомність вантажівки.
         * @return Поточний об'єкт TruckBuilder для подальшої побудови.
         */
        public TruckBuilder cargoCapacity(int cargoCapacity) {
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
