package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;

public class ClienteDAO {

    private final Connection con;
    private PreparedStatement cmd;
    private final String TABELA = "tb_cliente";

    public ClienteDAO() {
        this.con = new Conexao().conectar();
    }

    public long inserir(Cliente a) {
        try {
            final String SQL = "INSERT INTO " + TABELA + "(nome,cpf) VALUES (?,?)";
            cmd = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            cmd.setString(1, a.getNome());
            cmd.setString(2, a.getCpf());            

            if (cmd.executeUpdate() > 0) {
                ResultSet rs = cmd.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
            return -1;
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
            return -1;
        } finally {
            new Conexao().desconectar(con);
        }
    }

    public long atualizar(Cliente a) {
        try {
            final String SQL = "UPDATE " + TABELA + " SET  nome=?,cpf=? "
                    + "WHERE id_cliente=?";
            
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, a.getNome());
            cmd.setString(2, a.getCpf());            
            cmd.setInt(3, a.getId());
            return (cmd.executeUpdate() > 0) ? a.getId() : -1;
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
            return -1;
        } finally {
            new Conexao().desconectar(con);
        }
    }

    public long deletar(int id) {
        try {
            final String SQL = "DELETE FROM " + TABELA + " WHERE id_cliente=?";
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, id);
            return (cmd.executeUpdate() > 0) ? id : -1;
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
            return -1;
        } finally {
            new Conexao().desconectar(con);
        }
    }

    public List<Cliente> listar() {
        try {
            cmd = con.prepareStatement("SELECT * FROM " + TABELA + " ORDER BY id_cliente");
            ResultSet rs = cmd.executeQuery();
            List<Cliente> lista = new ArrayList<>();
            while (rs.next()) {
                Cliente a = new Cliente(
                        rs.getInt("id_cliente"), rs.getString("nome"), rs.getString("cpf")
                );
                lista.add(a);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
            return null;
        } finally {
            new Conexao().desconectar(con);
        }
    }

    public Cliente get(int id) {
        try {
            cmd = con.prepareStatement("SELECT * FROM " + TABELA + " WHERE id_cliente=?");
            cmd.setInt(1, id);
            ResultSet rs = cmd.executeQuery();
            if (rs.next()) {
                Cliente a = new Cliente(
                        rs.getInt("id_cliente"), rs.getString("nome"), rs.getString("cpf")
                );
                return a;
            }
            return null;
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
            return null;
        } finally {
            new Conexao().desconectar(con);
        }
    }
}
