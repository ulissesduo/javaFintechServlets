package br.com.fiap.fintech.Servlets;

import br.com.fiap.fintech.DAO.InvestimentoDAO;
import br.com.fiap.fintech.Entities.Investimento;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet("/insertInvestimento")
public class InvestimentoServlet extends HttpServlet {

    private InvestimentoDAO investimentoDAO = new InvestimentoDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            double valor = Double.parseDouble(req.getParameter("valor"));
            Timestamp dataInicio = Timestamp.valueOf(req.getParameter("dataInicio") + " 00:00:00");
            Timestamp dataResgate = Timestamp.valueOf(req.getParameter("dataResgate") + " 00:00:00");
            int usuarioId = Integer.parseInt(req.getParameter("usuarioId"));
            Investimento investimento = new Investimento( valor, dataInicio, dataResgate, usuarioId);

            investimentoDAO.save(investimento);

            resp.sendRedirect("success.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", "Error inserting investment: " + e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Investimento> investimentos = investimentoDAO.findAll();
            req.setAttribute("investimentos", investimentos);
            req.getRequestDispatcher("investimentos.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", "Error retrieving investments: " + e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }


}