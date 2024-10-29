package br.com.fiap.fintech.DAO;

import br.com.fiap.fintech.Entities.Despesa;
import br.com.fiap.fintech.Factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DespesaDAO {

    public void save (Despesa despesa) throws SQLException {

        String sql = "INSERT INTO despesasT (descricao, valor, data_pagamento, status_pagamento, categoria, usuario_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = ConnectionFactory.getConnection()){

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, despesa.getDescricao());
            statement.setDouble(2, despesa.getValor());
            statement.setTimestamp(3, despesa.getData_pagamento());
            statement.setString(4, String.valueOf(despesa.getStatus_pagamento()));
            statement.setString(5, despesa.getCategoria());
            statement.setInt(6, despesa.getUsuario_id());

            statement.executeUpdate();
        }
        catch(Exception e){
            throw new SQLException(e.getMessage());
        }

    }

}
