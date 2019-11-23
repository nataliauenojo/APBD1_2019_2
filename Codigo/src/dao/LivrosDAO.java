package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Clientes;
import model.Livros;

public class LivrosDAO extends dao.DbConnection {

    private Connection conn;
    private final String sqlInsert = "INSERT INTO Livros (isbn,titulo,autor,ano,preco,categoria) VALUES (?, ?, ?, ?, ? ,?)";
    private final String sqlUpdate = "UPDATE Livros SET isbn = ?, titulo = ?, autor = ? ,ano = ?,preco = ? ,categoria = ? WHERE isbn = ? ";
    private final String sqlRemove = "DELETE FROM Livros WHERE isbn = ?";
    private final String sqlList = "SELECT isbn ,titulo , autor, ano, preco, categoria FROM Livros ORDER BY isbn";
    private final String sqlFind = "SELECT isbn ,titulo , autor, ano, preco, categoria FROM Livros WHERE isbn = ?";

    public void insert(Livros livros) throws SQLException {
        PreparedStatement ps = null;
        try {
            conn = connect();
            ps = conn.prepareStatement(sqlInsert);
            ps.setInt(1, livros.getIsbn());
            ps.setString(2, livros.getTitulo());
            ps.setString(3, livros.getAutor());
            ps.setString(4, livros.getAno());
            ps.setDouble(5,livros.getPreco());
            ps.setString(6, livros.getCategoria());
            ps.execute();
        } finally {
            ps.close();
            close(conn);
        }

    }

    public void update(Livros livros) throws SQLException {
        PreparedStatement ps = null;
        try {
            conn = connect();
            ps = conn.prepareStatement(sqlUpdate);
            ps.setInt(1, livros.getIsbn());
            ps.setString(2, livros.getTitulo());
            ps.setString(3, livros.getAutor());
            ps.setString(4, livros.getAno());
            ps.setDouble(5,livros.getPreco());
            ps.setString(6, livros.getCategoria());
            ps.setInt(7, livros.getIsbn());
            ps.execute();

        } finally {
            ps.close();
            close(conn);
        }
    }

    public void remove(int isbn) throws SQLException {
        PreparedStatement ps = null;
        try {
            conn = connect();
            ps = conn.prepareStatement(sqlRemove);
            ps.setInt(1, isbn);
            ps.execute();
        } finally {
            ps.close();
            close(conn);
        }

    }

    public ArrayList<Livros> list() throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = connect();
            ps = conn.prepareStatement(sqlList);
            rs = ps.executeQuery();
            ArrayList<Livros> list = new ArrayList<>();
            Livros livros;
            while (rs.next()) {
                livros = new Livros();
                livros.setIsbn(rs.getInt("isbn"));
                livros.setTitulo(rs.getString("titulo"));
                livros.setAutor(rs.getString("autor"));
                livros.setAno(rs.getString("ano"));
                livros.setPreco(rs.getDouble("preco"));
                livros.setCategoria(rs.getString("categoria"));
                list.add(livros);
            }
            return list;
        } finally {
            rs.close();
            ps.close();
            close(conn);
        }
    }

    public void update(Clientes prod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
