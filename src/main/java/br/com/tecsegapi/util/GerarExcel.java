package br.com.tecsegapi.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


import br.com.tecsegapi.model.Funcionario;

public class GerarExcel {
	
	public void excelSalutar(List<Funcionario> lista) {
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet firstSheet = workbook.createSheet("Fomrulario_Funcionarios");
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(new File("c:\\logs\\Formulario Funcionarios.xls"));
			int i = 0;
			HSSFRow row = firstSheet.createRow(i);
			i++;
			row.createCell(0).setCellValue("Cod.Unid");
			row.createCell(1).setCellValue("Nome Unidade");
			row.createCell(2).setCellValue("Nome Setor");
			row.createCell(3).setCellValue("Nome Cargo");
			row.createCell(4).setCellValue("Nome Funcionários");
			row.createCell(5).setCellValue("Dt.Nascimento");
			row.createCell(6).setCellValue("Sexo");
			row.createCell(7).setCellValue("Situação");
			row.createCell(8).setCellValue("Dt.Admissão");
			row.createCell(9).setCellValue("Pis/Pasep");
			row.createCell(10).setCellValue("Contrtação");
			row.createCell(11).setCellValue("Rg");
			row.createCell(12).setCellValue("UF-RG");
			row.createCell(13).setCellValue("CPF");
			row.createCell(14).setCellValue("CTPS");
			row.createCell(15).setCellValue("CBO");
			row.createCell(16).setCellValue("Dt.Emissão.Cart.Prof");
			row.createCell(17).setCellValue("Séri CTPS");
			row.createCell(18).setCellValue("Estado Cobrança Unidade");
			row.createCell(19).setCellValue("Cep Cobrança unidade");
			row.createCell(20).setCellValue("Caomplemento Endereço Cobrança Unidade");
			row.createCell(21).setCellValue("Remuneração Mensal (R$)");
			row.createCell(22).setCellValue("Telefone Comercial");
			row.createCell(23).setCellValue("Telefone Celular");
			row.createCell(24).setCellValue("Data Emissão RG");
			row.createCell(25).setCellValue("Código País do Nascimento");
			row.createCell(26).setCellValue("Origem Descrição Detalhada");
			row.createCell(27).setCellValue("Escolaridade");
			row.createCell(28).setCellValue("Código Categoria(eSocial)");
			row.createCell(29).setCellValue("Matrícula RH");
			row.createCell(30).setCellValue("Gênero");
			row.createCell(31).setCellValue("Nome Social");
			row.createCell(32).setCellValue("Tipo Admissão");
			row.createCell(33).setCellValue("Nome do Pai do Funcionário");
			row.createCell(34).setCellValue("Tipo de Vínculo");
			row.createCell(35).setCellValue("Nome do Turno");
			i++;
			Conversor c = new Conversor();
			
			  for (Funcionario f : lista) { row = firstSheet.createRow(i);
			  	row.createCell(0).setCellValue(f.getLoja().getCodigosalutar());
				row.createCell(1).setCellValue(f.getLoja().getNome());
				row.createCell(2).setCellValue(f.getSetor().getNome());
				row.createCell(3).setCellValue(f.getFuncao().getNome());
				row.createCell(4).setCellValue(f.getNome());
				if (f.getDatanascimento()!=null) {
					row.createCell(5).setCellValue(c.ConvercaoDataBR(f.getDatanascimento()));
				} else row.createCell(5).setCellValue("");
				row.createCell(6).setCellValue(f.getSexo());
				row.createCell(7).setCellValue(f.getSituacao());
				if (f.getDataadmissao()!=null) {
					row.createCell(8).setCellValue(c.ConvercaoDataBR(f.getDataadmissao()));
				}else row.createCell(8).setCellValue("");
				row.createCell(9).setCellValue(f.getPis());
				row.createCell(10).setCellValue("NÃO SEI");
				row.createCell(11).setCellValue(f.getRg());
				row.createCell(12).setCellValue(f.getUf());
				row.createCell(13).setCellValue(f.getCpf());
				row.createCell(14).setCellValue(f.getCtps());
				row.createCell(15).setCellValue(f.getFuncao().getCbo());
				row.createCell(16).setCellValue("Dt.Emissão.Cart.Prof");
				row.createCell(17).setCellValue("Séri CTPS");
				row.createCell(18).setCellValue("Estado Cobrança Unidade");
				row.createCell(19).setCellValue("Cep Cobrança unidade");
				row.createCell(20).setCellValue("Caomplemento Endereço Cobrança Unidade");
				row.createCell(21).setCellValue("Remuneração Mensal (R$)");
				row.createCell(22).setCellValue("Telefone Comercial");
				row.createCell(23).setCellValue("Telefone Celular");
				row.createCell(24).setCellValue("Data Emissão RG");
				row.createCell(25).setCellValue("Código País do Nascimento");
				row.createCell(26).setCellValue("Origem Descrição Detalhada");
				row.createCell(27).setCellValue("Escolaridade");
				row.createCell(28).setCellValue("Código Categoria(eSocial)");
				row.createCell(29).setCellValue(f.getMatricula());
				row.createCell(30).setCellValue("Gênero");
				row.createCell(31).setCellValue("Nome Social");
				row.createCell(32).setCellValue("Tipo Admissão");
				row.createCell(33).setCellValue("Nome do Pai do Funcionário");
				row.createCell(34).setCellValue("Tipo de Vínculo");
				row.createCell(35).setCellValue("Nome do Turno");
			  
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

}
