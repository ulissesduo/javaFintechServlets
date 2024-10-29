package br.com.fiap.fintech.DAO;

import br.com.fiap.fintech.Entities.ObjetivoFuturo;
import br.com.fiap.fintech.Factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ObjetivoFuturoDAO {
    public void save(ObjetivoFuturo objetivoFuturo) throws SQLException {
        String sql = "INSERT INTO objetivos_futurosT (descricao, quantidade_alvo, valor_atual, tipo, usuario_id_usuario) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement statement = con.prepareStatement(sql)) {

            statement.setString(1, objetivoFuturo.getDescricao());
            statement.setInt(2, objetivoFuturo.getQuantidadeAlvo());
            statement.setDouble(3, objetivoFuturo.getValorAtual());
            statement.setString(4, objetivoFuturo.getTipo());
            statement.setInt(5, objetivoFuturo.getUsuarioIdUsuario());

            statement.executeUpdate();
        }
    }
}
