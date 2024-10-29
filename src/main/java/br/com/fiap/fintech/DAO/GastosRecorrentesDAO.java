package br.com.fiap.fintech.DAO;

import br.com.fiap.fintech.Entities.GastosRecorrentes;
import br.com.fiap.fintech.Factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GastosRecorrentesDAO {
    private Connection connection;

    public void insertGastosRecorrentes(GastosRecorrentes gastos) throws SQLException {
        // Insert into DespesasT
        String insertDespesaSQL = "INSERT INTO DespesasT (ID_DESPESA, DESCRICAO, VALOR, DATA_PAGAMENTO, STATUS_PAGAMENTO, CATEGORIA, USUARIO_ID) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = ConnectionFactory.getConnection()) {
            PreparedStatement statement = con.prepareStatement(insertDespesaSQL);
            statement.setLong(1, gastos.getId_despesa());
            statement.setString(2, gastos.getDescricao());
            statement.setDouble(3, gastos.getValor());
            statement.setTimestamp(4, gastos.getData_pagamento());
            statement.setString(5, String.valueOf(gastos.getStatus_pagamento()));
            statement.setString(6, gastos.getCategoria());
            statement.setLong(7, gastos.getUsuario_id());
            statement.executeUpdate();
        }

        // Insert into Gastos_RecorrentesT
        //PRIVAVELMENTE O ID_DESPESA NAO PODE SER ADICIONADO EXPLICITAMENTE
        String insertGastosSQL = "INSERT INTO Gastos_RecorrentesT (ID_DESPESA, END_DATE, NEXT_PAYMENT_DATE, AUTO_PAY, RECURRING_NOTE, IS_CANCELED, FREQUENCIA) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = ConnectionFactory.getConnection()) {
            PreparedStatement statement = con.prepareStatement(insertGastosSQL);
            statement.setLong(1, gastos.getId_despesa());
            statement.setTimestamp(2, gastos.getEndDate());
            statement.setTimestamp(3, gastos.getNextPaymentDate());
            statement.setInt(4, gastos.getAutoPay());
            statement.setString(5, gastos.getRecurringNote());
            statement.setInt(6, gastos.getIsCanceled());
            statement.setString(7, gastos.getFrequencia());
            statement.executeUpdate();
        }
    }
}