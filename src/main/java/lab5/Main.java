package lab5;

import lab5.sqlUtils.SQLExecutor;

import java.sql.SQLException;

public class Main {
    private static SQLExecutor sqlExecutor = new SQLExecutor("jdbc:mysql://localhost/javalabs", "root", "lm10112018");

    public static void main(String args[]) {
        try {
            sqlExecutor.executeQueryWithNoResult("DROP TABLE IF EXISTS javalabs.advertisement");
            sqlExecutor.executeQueryWithNoResult("DROP TABLE IF EXISTS javalabs.vehicle;");
            sqlExecutor.executeQueryWithNoResult("DROP TABLE IF EXISTS javalabs.model;");
            sqlExecutor.executeQueryWithNoResult("DROP TABLE IF EXISTS javalabs.brand;");

            sqlExecutor.executeQueryWithNoResult("CREATE TABLE brand(\n" +
                    "`id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "`name` VARCHAR(45) NOT NULL,\n" +
                    "PRIMARY KEY (`id`),\n" +
                    "UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE\n" +
                    ");");

            sqlExecutor.executeQueryWithNoResult("CREATE TABLE model(\n" +
                    "`id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "`brand_id` INT NOT NULL,\n" +
                    "PRIMARY KEY (`id`, `brand_id`),\n" +
                    "UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,\n" +
                    "INDEX `fk_model_brand_idx` (`brand_id` ASC) VISIBLE,\n" +
                    "CONSTRAINT `fk_model_brand`\n" +
                    "FOREIGN KEY (`brand_id`)\n" +
                    "REFERENCES `javalabs`.`brand` (`id`)\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    ");");

            sqlExecutor.executeQueryWithNoResult("CREATE TABLE vehicle(\n" +
                    "`id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "`model_id` INT NOT NULL,\n" +
                    "`year` INT NOT NULL,\n" +
                    "PRIMARY KEY (`id`, `model_id`),\n" +
                    "UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,\n" +
                    "INDEX `fk_vehicle_model_idx` (`model_id` ASC) VISIBLE,\n" +
                    "CONSTRAINT `fk_vehicle_model`\n" +
                    "FOREIGN KEY (`model_id`)\n" +
                    "REFERENCES `javalabs`.`model` (`id`)\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    ");");

            sqlExecutor.executeQueryWithNoResult("CREATE TABLE advertisement(\n" +
                    "`id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "`vehicle_id` INT NOT NULL,\n" +
                    "`price` INT NOT NULL,\n" +
                    "`information` VARCHAR(255) NULL,\n" +
                    "`contactNumber` VARCHAR(16) NOT NULL,\n" +
                    "`dateOfPosting` DATE NOT NULL,\n" +
                    "PRIMARY KEY (`id`, `vehicle_id`),\n" +
                    "UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,\n" +
                    "INDEX `fk_advertisement_vehicle1_idx` (`vehicle_id` ASC) VISIBLE,\n" +
                    "CONSTRAINT `fk_advertisement_vehicle1`\n" +
                    "FOREIGN KEY (`vehicle_id`)\n" +
                    "REFERENCES `javalabs`.`vehicle` (`id`)\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
