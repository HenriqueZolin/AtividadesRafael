package com.unicesumar.repository;

import com.unicesumar.entities.Venda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class VendaRepository implements EntityRepository<Venda> {

    private final Connection connection;

    public VendaRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Venda entity) {
        String query = "INSERT INTO sales (id, user_id, payment_method, sale_date) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, entity.getUuid().toString());
            stmt.setString(2, entity.getUserId().toString());
            stmt.setString(3, entity.getPaymentMethod());
            stmt.setTimestamp(4, java.sql.Timestamp.valueOf(entity.getSaleDate()));
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Venda> findById(UUID id) {
        String query = "SELECT * FROM sales WHERE id = ?";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, id.toString());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Venda venda = new Venda(
                        UUID.fromString(rs.getString("id")),
                        UUID.fromString(rs.getString("user_id")),
                        rs.getString("payment_method"),
                        rs.getTimestamp("sale_date").toLocalDateTime()
                );
                return Optional.of(venda);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public List<Venda> findAll() {
        List<Venda> vendas = new ArrayList<>();
        String query = "SELECT * FROM sales";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Venda venda = new Venda(
                        UUID.fromString(rs.getString("id")),
                        UUID.fromString(rs.getString("user_id")),
                        rs.getString("payment_method"),
                        rs.getTimestamp("sale_date").toLocalDateTime()
                );
                vendas.add(venda);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vendas;
    }

    @Override
    public void deleteById(UUID id) {
        String query = "DELETE FROM sales WHERE id = ?";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, id.toString());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
