package exercise.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import exercise.model.Product;

import java.sql.SQLException;
import java.sql.Statement;

public class ProductsRepository extends BaseRepository {

    // BEGIN
    public static void save(Product product) throws SQLException {
        String sql = "INSERT INTO products (title, price) VALUES (?, ?)";

        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, product.getTitle());
                statement.setInt(2, product.getPrice());

                statement.executeUpdate();

                ResultSet keys = statement.getGeneratedKeys();

                if (keys.next()) {
                    product.setId(keys.getLong(1));
                } else {
                    throw new SQLException("DB have not returned an id after saving an entity");
                }
            }
        }
    }

    public static Optional<Product> find(long id) throws SQLException {
        String sql = "SELECT * FROM products WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                String title = resultSet.getString("title");
                int price = resultSet.getInt("price");

                Product product = new Product(title, price);
                product.setId(id);

                return Optional.of(product);
            }

            return Optional.empty();
        }
    }

    public static List<Product> getEntities() throws SQLException {
        String sql = "SELECT * FROM products";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            ResultSet resultSet = stmt.executeQuery();
            List<Product> result = new ArrayList<Product>();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");

                String title = resultSet.getString("title");
                int price = resultSet.getInt("price");

                Product product = new Product(title, price);
                product.setId(id);

                result.add(product);
            }

            return result;
        }
    }
    // END
}
