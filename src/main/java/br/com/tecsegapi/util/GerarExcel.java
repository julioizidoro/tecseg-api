package br.com.tecsegapi.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


import br.com.tecsegapi.model.Funcionario;

public class GerarExcel {
	
	private File file;
	
	
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public void excelSalutar(List<Funcionario> lista) {
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet firstSheet = workbook.createSheet("Fomrulario_Funcionarios");
		FileOutputStream fos = null;
		
		try {
			file = new File("Formulario Funcionarios.xls");
			fos = new FileOutputStream(file);
			int i = 0;
			HSSFRow row = firstSheet.createRow(i);
			row.createCell(0).setCellValue("Cod.Unid");
			row.createCell(1).setCellValue("Nome Unidade");
			row.createCell(2).setCellValue("Cod. Setor");
			row.createCell(3).setCellValue("Nome Setor");
			row.createCell(4).setCellValue("Nome Cargo");
			row.createCell(5).setCellValue("Cod. Fun");
			row.createCell(6).setCellValue("Nome Funcionários");
			row.createCell(7).setCellValue("Dt.Nascimento");
			row.createCell(8).setCellValue("Sexo");
			row.createCell(9).setCellValue("Situação");
			row.createCell(10).setCellValue("Dt.Admissão");
			row.createCell(11).setCellValue("Pis/Pasep");
			row.createCell(12).setCellValue("Contrtação");
			row.createCell(13).setCellValue("Rg");
			row.createCell(14).setCellValue("UF-RG");
			row.createCell(15).setCellValue("CPF");
			row.createCell(16).setCellValue("CTPS");
			row.createCell(17).setCellValue("CBO");
			row.createCell(18).setCellValue("Dt.Emissão.Cart.Prof");
			row.createCell(19).setCellValue("Séri CTPS");
			row.createCell(20).setCellValue("Estado Cobrança Unidade");
			row.createCell(21).setCellValue("Cep Cobrança unidade");
			row.createCell(22).setCellValue("Caomplemento Endereço Cobrança Unidade");
			row.createCell(23).setCellValue("Remuneração Mensal (R$)");
			row.createCell(24).setCellValue("Telefone Comercial");
			row.createCell(25).setCellValue("Telefone Celular");
			row.createCell(26).setCellValue("Data Emissão RG");
			row.createCell(27).setCellValue("Código País do Nascimento");
			row.createCell(28).setCellValue("Origem Descrição Detalhada");
			row.createCell(29).setCellValue("Escolaridade");
			row.createCell(30).setCellValue("Código Categoria(eSocial)");
			row.createCell(31).setCellValue("Matrícula RH");
			row.createCell(32).setCellValue("Gênero");
			row.createCell(33).setCellValue("Nome Social");
			row.createCell(34).setCellValue("Tipo Admissão");
			row.createCell(35).setCellValue("Nome do Pai do Funcionário");
			row.createCell(36).setCellValue("Tipo de Vínculo");
			row.createCell(37).setCellValue("Nome do Turno");
			i++;
			Conversor c = new Conversor();
			
			  for (Funcionario f : lista) { row = firstSheet.createRow(i);
			  	row.createCell(0).setCellValue(f.getLoja().getCodigosalutar());
				row.createCell(1).setCellValue(f.getLoja().getNome());
				row.createCell(2).setCellValue(f.getSetor().getIdsetor());
				row.createCell(3).setCellValue(f.getSetor().getNome());
				row.createCell(4).setCellValue(f.getFuncao().getNome());
				row.createCell(5).setCellValue(f.getIdfuncionario());
				row.createCell(6).setCellValue(f.getNome());
				if (f.getDatanascimento()!=null) {
					row.createCell(7).setCellValue(c.ConvercaoDataBR(f.getDatanascimento()));
				} else row.createCell(7).setCellValue("");
				row.createCell(8).setCellValue(f.getSexo());
				row.createCell(9).setCellValue(codgioSituacao(f.getSituacao()));
				if (f.getDataadmissao()!=null) {
					row.createCell(10).setCellValue(c.ConvercaoDataBR(f.getDataadmissao()));
				}else row.createCell(10).setCellValue("");
				row.createCell(11).setCellValue(f.getPis());
				row.createCell(12).setCellValue("1");
				row.createCell(13).setCellValue(f.getRg());
				row.createCell(14).setCellValue(f.getUf());
				row.createCell(15).setCellValue(f.getCpf());
				row.createCell(16).setCellValue(f.getCtps());
				row.createCell(17).setCellValue(f.getFuncao().getCbo());
				row.createCell(18).setCellValue("");
				row.createCell(19).setCellValue(f.getSerie());
				row.createCell(20).setCellValue("");
				row.createCell(21).setCellValue("");
				row.createCell(22).setCellValue("");
				row.createCell(23).setCellValue("");
				row.createCell(24).setCellValue("");
				row.createCell(25).setCellValue("");
				row.createCell(26).setCellValue("");
				row.createCell(27).setCellValue("");
				row.createCell(28).setCellValue("");
				row.createCell(29).setCellValue("");
				row.createCell(30).setCellValue("");
				row.createCell(31).setCellValue(f.getMatricula());
				row.createCell(32).setCellValue(f.getSexo());
				row.createCell(33).setCellValue("");
				row.createCell(34).setCellValue("");
				row.createCell(35).setCellValue("");
				row.createCell(36).setCellValue("");
				row.createCell(37).setCellValue("");
			  
			  i++; }
			 
			workbook.write(fos);

		}catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			fos.flush();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public String codgioSituacao(String situacao) {
		if (situacao.equalsIgnoreCase("Inativo")) {
			return "N";
		} else if (situacao.equalsIgnoreCase("Afastado")) {
			return "A";
		}else return "S";
	}

}
