package br.com.fiap.fintech.Servlets;

import br.com.fiap.fintech.DAO.InvestimentoTDAO;
import br.com.fiap.fintech.Entities.Investimento;
import br.com.fiap.fintech.Entities.InvestimentoT;
import br.com.fiap.fintech.Entities.InvestmentType;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
public class InvestimentoTServlet extends HttpServlet {

    private InvestimentoTDAO investimentoDAO;

    @Override
    public void init() throws ServletException {
        // Initialize the DAO to avoid null pointer issues
        investimentoDAO = new InvestimentoTDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve all investment types for dropdown list
            List<InvestmentType> investmentTypes = investimentoDAO.getAllInvestmentTypes();
            request.setAttribute("investmentTypes", investmentTypes);
            RequestDispatcher dispatcher = request.getRequestDispatcher("create_investimento.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Error retrieving investment types", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve form parameters and parse them
            Integer investmentTypeId = Integer.parseInt(request.getParameter("tipo_investimento"));
            Double valorInvestido = Double.parseDouble(request.getParameter("valor_investido"));
            Timestamp dataInicio = Timestamp.valueOf(request.getParameter("data_inicio") + " 00:00:00");
            Timestamp dataResgate = Timestamp.valueOf(request.getParameter("data_resgate") + " 00:00:00");
            Integer usuarioId = Integer.parseInt(request.getParameter("usuario_id"));

            // Create and populate InvestimentoT object
            InvestimentoT investimento = new InvestimentoT(investmentTypeId, valorInvestido, dataInicio, dataResgate, usuarioId);

            // Save InvestimentoT object to database
            investimentoDAO.save(investimento);
            response.sendRedirect("success.jsp");

        } catch (SQLException e) {
            throw new ServletException("Error saving investment", e);
        } catch (NumberFormatException e) {
            throw new ServletException("Invalid input format", e);
        }
    }
}