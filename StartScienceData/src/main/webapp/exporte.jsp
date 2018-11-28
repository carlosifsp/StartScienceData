<%@page import="ifsp.StartScienceData.modelo.animal.Animal"%>
<%@page import="ifsp.StartScienceData.modelo.universidade.Universidade"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ifsp.StartScienceData.modelo.projeto.Projeto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
	import="java.util.List"
	import="java.io.IOException"
   import="java.io.File" 
   import="java.io.Writer"
   import="java.io.OutputStream"
  	import="java.io.FileOutputStream"
   import="java.io.OutputStreamWriter"
   import="java.io.BufferedWriter" 
   import="java.io.InputStream"
   import="java.io.FileInputStream"
   import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exporte</title>
</head>
<body>
	
		<div> 
	<%
		String idExportacao = (String) request.getParameter("idProjeto");
		//getValue("idProjeto");
		int idshow = Integer.parseInt(idExportacao);
		
		
		
 		ArrayList<Projeto> listaProjeto = (ArrayList<Projeto>) session.getAttribute("projetos");
 		
 		ArrayList<Universidade> listauniversidade = (ArrayList<Universidade>) session.getAttribute("listaUni");
 		
 		ArrayList<Animal> listaAnimal = (ArrayList<Animal>)session.getAttribute("listaAnimal");
		
		
		File arquivo = new File("dados.csv");
		OutputStream teste = new FileOutputStream(arquivo);
		Writer osw = new OutputStreamWriter(teste);
		BufferedWriter bw = new BufferedWriter(osw);

		for (Projeto p : listaProjeto) {
			
			
			
			if(p.getId()==idshow){
				bw.write("--Dados De Projeto--");
				bw.newLine();
				bw.write("Titulo: " + p.getTitulo());
				bw.newLine();
				bw.write("Ano: " + p.getAno());
				bw.newLine();
				bw.write("Cômite: " + p.getComite());
				bw.newLine();
				
				for(Animal a : listaAnimal){
					if(a.getId()==p.getIdAnimal()){
						bw.write("--Dados Do Animal--");
						bw.newLine();
						bw.write("Apelido: " + a.getApelido());
						bw.newLine();
						bw.write("Especie: " + a.getEspecie());
						bw.newLine();
						String genero = "Macho";
						if(a.getGenero()==2){
							genero = "Femea";
						}
						bw.write("Genero: " + genero);
						bw.newLine();
						bw.write("Idade: " + a.getIdade() + " Meses");
						bw.newLine();
						break;
					}
				}
				
				for(Universidade u : listauniversidade){
					if(u.getIdUniversidade()==p.getUniversidade()){
						bw.newLine();
						bw.write("Projeto em análise na universidade: " + u.getNomeUniversidade());
						bw.newLine();
						break;
					}
				}
				
				
				
				break;
			}
		}
		
		bw.close();
		
		response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=" + arquivo);
        
        InputStream in = new FileInputStream(arquivo);
        PrintWriter output = response.getWriter();
        
        int bit = 256;
        try {
            while ((bit) > 0) {
                bit = in.read();
                if (bit!=-1)
                	output.write(bit);
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        output.flush();
        output.close();
        in.close();
		
		
 	%>
 	
	</div>
	
	
	
</body>
</html>