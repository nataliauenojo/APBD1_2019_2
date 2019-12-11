package dao;

import model.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientesDAO extends dao.DbConnection {

    private Connection conn;
    private final String sqlInsert = "INSERT INTO Clientes (nome , telefone) VALUES (?, ?)";
    private final String sqlUpdate = "UPDATE Clientes SET id = ?, nome = ?,telefone = ? WHERE id = ? ";
    private final String sqlRemove = "DELETE FROM Clientes WHERE id = ?";
    private final String sqlList = "SELECT id , nome ,telefone FROM Clientes ORDER BY id";
    private final String sqlFind = "SELECT id , nome FROM Clientes WHERE id = ?";

    public void insert(Clientes clientes) throws SQLException {
        PreparedStatement ps = null;
        try {
            conn = connect();
            ps = conn.prepareStatement(sqlInsert);
            ps.setString(1, clientes.getNome());
            ps.setString(2, clientes.getTelefone());
            ps.execute();
        } finally {
            ps.close();
            close(conn);
        }

    }

    public void update(Clientes clientes) throws SQLException {
        PreparedStatement ps = null;
        try {
            conn = connect();
            ps = conn.prepareStatement(sqlUpdate);
            ps.setInt(1, clientes.getId());
            ps.setString(2, clientes.getNome());
            ps.setString(3, clientes.getTelefone());
            ps.setInt(4, clientes.getId());
            ps.execute();
            
        } finally {
            ps.close();
            close(conn);
        }
    }

    public void remove(int id) throws SQLException {
        PreparedStatement ps = null;
        try {
            conn = connect();
            ps = conn.prepareStatement(sqlRemove);
            ps.setInt(1, id);
            ps.execute();
        } finally {
            ps.close();
            close(conn);
        }

    }

    public ArrayList<Clientes> list() throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = connect();
            ps = conn.prepareStatement(sqlList);
            rs = ps.executeQuery();
            ArrayList<Clientes> list = new ArrayList<>();
            Clientes clientes;
            while (rs.next()) {
                clientes = new Clientes();
                clientes.setId(rs.getInt("id"));
                clientes.setNome(rs.getString("nome"));
                clientes.setTelefone(rs.getString("telefone"));
                list.add(clientes);
            }
            return list;
        } finally {
            rs.close();
            ps.close();
            close(conn);
        }
    }
}

/**
 *
 * @author Natalia
 */
