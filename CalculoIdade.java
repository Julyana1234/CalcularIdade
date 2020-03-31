package ProgramacaoWeb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

@WebServlet("/CalculoIdade")
public class CalculoIdade extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ValidarData = null;
	int validar;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Calendar cal = Calendar.getInstance();
		int diaAtual = cal.get(Calendar.DAY_OF_MONTH);
		int mesAtual = cal.get(Calendar.MONTH);
		int anoAtual = cal.get(Calendar.YEAR);
		Integer diaNasc = Integer.parseInt(request.getParameter("dia"));
		Integer mesNasc = Integer.parseInt(request.getParameter("mes"));
		Integer anoNasc = Integer.parseInt(request.getParameter("ano"));
		int idade = anoAtual - anoNasc;
		String resultado = null;
		if ((anoNasc > anoAtual) || (anoNasc < 1900) || (anoNasc < 0)) {
			validar = 1;
		} else if (mesNasc > 12) {
			validar = 2;
		} else if (mesNasc < 0) {
			validar = 3;
		} else if (diaNasc > 31) {
			validar = 4;
		} else if (diaNasc < 0) {
			validar = 5;
		} else if ((mesNasc == 4) || (mesNasc == 6) || (mesNasc == 9) || (mesNasc == 11) && (diaNasc > 30)) {
			validar = 6;
		} else if ((mesNasc == 2) && (diaNasc > 29)) {
			validar = 7;
		}

		if (validar == 1) {
			resultado = resultado + "NAO EH POSSIVEL CALCULAR UM ANO MENOR QUE 1900";
		} else if (validar == 2) {
			resultado = resultado + "NAO EXISTE UM MES MAIOR QUE 12";
		} else if (validar == 3) {
			resultado = resultado + "NAO EXISTE UM MES MENOR QUE 0";
		} else if (validar == 4) {
			resultado = resultado + "NENHUM MES POSSUI MAIS DO QUE 31 DIAS";
		} else if (validar == 5) {
			resultado = resultado + "NENHUM MES POSSUI MENOS QUE 0 DIAS";
		} else if (validar == 6) {
			resultado = resultado + "ESSE MES POSSUI APENAS 30 DIAS";
		} else if (validar == 7) {
			resultado = resultado + "FEVEREIRO POSSUI APENAS 29 DIAS";
		}

		if (validar != 0) {
			request.setAttribute("resultado", resultado);
			request.getRequestDispatcher("ReceberDados.jsp").forward(request, response);
		} else if (validar == 0) {
			if (mesAtual < mesNasc) {
				idade--;
			} else if (mesAtual == mesNasc) {
				if (diaAtual > diaNasc) {
					idade--;
				}
			}

			request.setAttribute("idade", idade);
			request.getRequestDispatcher("ReceberDados.jsp").forward(request, response);
		}

	}

}
