package lab1;

import java.util.Objects;

/**
 * Клас, що представляє мотоцикл, який є підкласом транспортного засобу.
 */
public class Motorcycle extends Vehicle {

    /** Тип двигуна мотоцикла. */
    private String engineType;

    public Motorcycle() {
        super();
    }

    /**
     * Конструктор для створення об'єкта класу Motorcycle.
     *
     * @param brand      Марка мотоцикла.
     * @param model      Модель мотоцикла.
     * @param year       Рік випуску мотоцикла.
     * @param engineType Тип двигуна мотоцикла.
     */
    protected Motorcycle(String brand, String model, int year, String engineType) {
        super(brand, model, year);
        this.engineType = engineType;
    }

    /**
     * Отримати тип двигуна мотоцикла.
     *
     * @return Тип двигуна.
     */
    public String getEngineType() {
        return engineType;
    }

    /**
     * Встановити тип двигуна мотоцикла.
     *
     * @param engineType Новий тип двигуна.
     */
    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    /**
     * Запустити двигун мотоцикла і вивести повідомлення.
     */
    public void startEngine() {
        System.out.println("Motorcycle engine is started!");
    }

    /**
     * Перевизначений метод для отримання рядкового представлення об'єкта.
     *
     * @return Рядкове представлення об'єкта.
     */
    @Override
    public String toString() {
        return "Motorcycle{" +
                "brand='" + getBrand() + '\'' +
                ", model='" + getModel() + '\'' +
                ", year=" + getYear() +
                ", engineType='" + engineType + '\'' +
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
        Motorcycle that = (Motorcycle) o;
        return Objects.equals(engineType, that.engineType);
    }

    /**
     * Перевизначений метод для генерації хеш-коду об'єкта.
     *
     * @return Хеш-код об'єкта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), engineType);
    }

    /**
     * Клас-Builder для створення об'єкта класу Motorcycle.
     */
    public static class MotorcycleBuilder {
        private String brand;
        private String model;
        private int year;
        private String engineType;

        /**
         * Встановити марку мотоцикла.
         *
         * @param brand Марка мотоцикла.
         * @return Посилання на об'єкт білдера.
         */
        public MotorcycleBuilder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        /**
         * Встановити модель мотоцикла.
         *
         * @param model Модель мотоцикла.
         * @return Посилання на об'єкт білдера.
         */
        public MotorcycleBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        /**
         * Встановити рік випуску мотоцикла.
         *
         * @param year Рік випуску мотоцикла.
         * @return Посилання на об'єкт білдера.
         */
        public MotorcycleBuilder setYear(int year) {
            this.year = year;
            return this;
        }

        /**
         * Встановити тип двигуна мотоцикла.
         *
         * @param engineType Тип двигуна мотоцикла.
         * @return Посилання на об'єкт білдера.
         */
        public MotorcycleBuilder setEngineType(String engineType) {
            this.engineType = engineType;
            return this;
        }

        /**
         * Побудова об'єкта Motorcycle із заданими параметрами.
         *
         * @return Об'єкт класу Motorcycle.
         */
        public Motorcycle build() {
            return new Motorcycle(brand, model, year, engineType);
        }
    }
}
