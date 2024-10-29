package br.com.fiap.fintech.DAO;

import br.com.fiap.fintech.Entities.Investimento;
import br.com.fiap.fintech.Entities.TipoInvestimento;
import br.com.fiap.fintech.Factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvestimentoDAO {
    public void save(Investimento investimento) throws SQLException {
        String sql = "INSERT INTO investimentosT (tipo_investimento, valor_investido, data_inicio, data_resgate, usuario_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement statement = con.prepareStatement(sql)) {

            statement.setString(1, investimento.getTipoInvestimento().name());
            statement.setDouble(2, investimento.getValor());
            statement.setTimestamp(3, investimento.getDataInicio());
            statement.setTimestamp(4, investimento.getDataResgate());
            statement.setInt(5, investimento.getUsuarioId());

            statement.executeUpdate();
        }
    }


    public List<Investimento> findAll() throws SQLException {
        List<Investimento> investimentos = new ArrayList<>();
        String sql = "SELECT * FROM investimentosT";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement statement = con.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Long id = rs.getLong("ID_INVESTIMENTO");
                TipoInvestimento tipoInvestimento = TipoInvestimento.valueOf(rs.getString("TIPO_INVESTIMENTO"));
                double valor = rs.getDouble("VALOR_INVESTIDO");
                Timestamp dataInicio = rs.getTimestamp("DATA_INICIO");
                Timestamp dataResgate = rs.getTimestamp("DATA_RESGATE");
                int usuarioId = rs.getInt("USUARIO_ID");

                Investimento investimento = new Investimento(tipoInvestimento, valor, dataInicio, dataResgate, usuarioId);
                investimento.setId(id);
                investimentos.add(investimento);
            }
        }
        return investimentos;
    }
}
