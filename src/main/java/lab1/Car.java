package lab1;

import java.util.Objects;

/**
 * Клас, що представляє транспортний засіб автомобіль, який є підкласом транспортного засобу.
 */
class Car extends Vehicle {

    /** Кількість дверей у автомобілі. */
    private int numberOfDoors;

    /**
     * Конструктор для створення об'єкта класу Car.
     *
     * @param brand        Марка автомобіля.
     * @param model        Модель автомобіля.
     * @param year         Рік випуску автомобіля.
     * @param numberOfDoors Кількість дверей у автомобілі.
     */
    protected Car(String brand, String model, int year, int numberOfDoors) {
        super(brand, model, year);
        this.numberOfDoors = numberOfDoors;
    }

    /**
     * Отримати кількість дверей у автомобілі.
     *
     * @return Кількість дверей.
     */
    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    /**
     * Встановити кількість дверей у автомобілі.
     *
     * @param numberOfDoors Нова кількість дверей.
     */
    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    /**
     * Перевизначений метод для отримання рядкового представлення об'єкта.
     *
     * @return Рядкове представлення об'єкта.
     */
    @Override
    public String toString() {
        return "Car{" +
                "brand='" + getBrand() + '\'' +
                ", model='" + getModel() + '\'' +
                ", year=" + getYear() +
                ", numberOfDoors=" + numberOfDoors +
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
        Car car = (Car) o;
        return numberOfDoors == car.numberOfDoors;
    }

    /**
     * Перевизначений метод для генерації хеш-коду об'єкта.
     *
     * @return Хеш-код об'єкта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfDoors);
    }

    /**
     * Клас-Builder для створення об'єкта класу Motorcycle.
     */
    public static class CarBuilder {
        private String brand;
        private String model;
        private int year;
        private int numberOfDoors;

        /**
         * Встановити марку автомобіля.
         *
         * @param brand Марка автомобіля.
         * @return Посилання на об'єкт Builder для подальшого використання.
         */
        public CarBuilder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        /**
         * Встановити модель автомобіля.
         *
         * @param model Модель автомобіля.
         * @return Посилання на об'єкт Builder для подальшого використання.
         */
        public CarBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        /**
         * Встановити рік випуску автомобіля.
         *
         * @param year Рік випуску автомобіля.
         * @return Посилання на об'єкт Builder для подальшого використання.
         */
        public CarBuilder setYear(int year) {
            this.year = year;
            return this;
        }

        /**
         * Встановити кількість дверей у автомобілі.
         *
         * @param numberOfDoors Кількість дверей у автомобілі.
         * @return Посилання на об'єкт Builder для подальшого використання.
         */
        public CarBuilder setNumberOfDoors(int numberOfDoors) {
            this.numberOfDoors = numberOfDoors;
            return this;
        }

        /**
         * Побудувати об'єкт класу Car з встановленими параметрами.
         *
         * @return Новий об'єкт класу Car.
         */
        public Car build() {
            return new Car(brand, model, year, numberOfDoors);
        }
    }
}
