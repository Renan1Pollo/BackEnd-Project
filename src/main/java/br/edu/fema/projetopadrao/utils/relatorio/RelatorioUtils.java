package br.edu.fema.projetopadrao.utils.relatorio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * 
 * Classe responsável pela geração de
 * relatório em Jasper <br>
 * 
 * O caminho que os relatórios estarão salvos
 * deve corresponder ao atributo {@code PATH_RELATORIO} 
 * presente nesta classe
 * 
 * @author Paulo Romano - paulo-romano_133@hotmail.com
 * @author CEPEIN - cepeinfema@gmail.com
 * 
 * @since 20/05/2022
 * @version 1.0
 *
 */
public final class RelatorioUtils {
	
	/**
	 * Caminho que os relatórios deverão
	 * estar localizados
	 */
	private static final String PATH_RELATORIO = "src\\main\\resources\\relatorios\\";

	
	/**
	 * Método responsável pela geração
	 * de relatório
	 * 
	 * @param nomeArquivo - {@code String}: O nome
	 * não deve conter a extensão do arquivo (.jrxml) e
	 * o mesmo precisará estar localizado de acordo com
	 * o caminho definido nesta classe
	 * @param parametrosRelatorio - {@code Map<String, Object>}
	 * @return {@code ResponseEntity<byte[]>}
	 */
	public static ResponseEntity<byte[]> gerarRelatorioEmPDF(String nomeArquivo, Map<String, Object> parametrosRelatorio) {
		try {
			File arquivo = ResourceUtils.getFile(PATH_RELATORIO + nomeArquivo + ".jrxml");
			
			JasperReport jasperReport = JasperCompileManager.compileReport(arquivo.getAbsolutePath());
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametrosRelatorio, new JREmptyDataSource());
			
			byte[] relatorio = JasperExportManager.exportReportToPdf(jasperPrint);
			
			return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE).body(relatorio);
		} 
		catch (FileNotFoundException | JRException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
