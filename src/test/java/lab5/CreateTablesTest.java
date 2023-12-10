package lab5;

import lab5.sqlUtils.SQLExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class CreateTablesTest {
    private SQLExecutor sqlExecutor = new SQLExecutor("jdbc:mysql://localhost/javalabs", "root", "lm10112018");

    @Test
    public void createTables() {
        try {
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
                    "UNIQUE INDEX `idtable3_UNIQUE` (`id` ASC) VISIBLE,\n" +
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
                    "`brand_id` INT NOT NULL,\n" +
                    "`year` INT NOT NULL,\n" +
                    "PRIMARY KEY (`id`, `model_id`, `brand_id`),\n" +
                    "UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,\n" +
                    "INDEX `fk_vehicle_model1_idx` (`model_id` ASC, `brand_id` ASC) VISIBLE,\n" +
                    "CONSTRAINT `fk_vehicle_model1`\n" +
                    "FOREIGN KEY (`model_id` , `brand_id`)\n" +
                    "REFERENCES `javalabs`.`model` (`id` , `brand_id`)\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION\n" +
                    ");");
        } catch (SQLException e) {
            Assert.fail("Error while creating tables");
            e.printStackTrace();
        }
    }
}
