package com.agenda.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet({"/","/cadastrar/atestado"})
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UsuarioServlet() { }
    
    private byte[] bytes;
    private static final String FOLDER = "C:\\Users\\Desenvolvedor\\Desktop\\Declaracoes\\";
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = request.getRequestURI();
		
		if(uri.equals("/"))
			request.getRequestDispatcher("/upload.jsp").forward(request, response);
		
		else{		
			Part uploadFile = request.getPart("doc");
			String coloborador = request.getParameter("colaborador");
			String dataEvento = request.getParameter("dataEvento");

			if(uploadFile != null && coloborador != null && !coloborador.isEmpty() && dataEvento != null && !dataEvento.isEmpty()){
				bytes = new byte[(int) uploadFile.getSize()];

				File folder = new File(FOLDER);

				if(!folder.exists())
					folder.mkdir();

				String nomeDocUpload = coloborador.replace(" ", "") + dataEvento.replace("-", "") + uploadFile.getSubmittedFileName().substring(uploadFile.getSubmittedFileName().indexOf("."));
				
				File folderColaborador = new File(FOLDER + "\\" + coloborador.trim().replace(" ", "") + "\\");
				
				if(!folderColaborador.exists())
					folderColaborador.mkdir();

				File arquivoToSave = new File(FOLDER + "\\" + coloborador.trim().replace(" ", "") + "\\" + nomeDocUpload);

				if(!arquivoToSave.exists()){
					uploadFile.getInputStream().read(bytes);
					OutputStream os =  new FileOutputStream(arquivoToSave);
					os.write(bytes);
					os.flush();
					os.close();

					request.setAttribute("status", "O arquivo foi carregado com sucesso!");
					request.getRequestDispatcher("/upload.jsp").forward(request, response);
				}
				else{
					request.setAttribute("error", "O arquivo: " + uploadFile.getSubmittedFileName() + " já existe! Obrigado!");
					request.getRequestDispatcher("/upload.jsp").forward(request, response);
				}
			}
			else{
				request.setAttribute("error", "Favor preencher os dados!");
				request.getRequestDispatcher("/upload.jsp").forward(request, response);
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
