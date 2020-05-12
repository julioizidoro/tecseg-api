package br.com.tecsegapi.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.tecsegapi.model.Asocontrole;




public class Conversor {
	
	public Date ConvercaoStringData(String data) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dataFormatada = null;
        try {
            dataFormatada = df.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(Conversor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataFormatada;
    }
	
	public Date SomarDiasData(Date data, int dias) {
        Calendar c = new GregorianCalendar();
        c.setTime(data);
        if (dias != 0) {
            c.add(Calendar.DAY_OF_MONTH, dias);
        }
        return (c.getTime());
    }
	
	public String ConvercaoData(Date data) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dataFormatada = df.format(data);
        return dataFormatada;
    }
	
	
	public String ConvercaoDataBR(Date data) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = df.format(data);
        return dataFormatada;
    }
	
	
	public String verficarSituacaoAtestado(Asocontrole asoControle) {
		String data = ConvercaoData(new Date());
		if (!asoControle.isAgendado()) {
			Date dataHoje = ConvercaoStringData(data);
			// vencida
			if (asoControle.getDatavencimento().before(dataHoje)) {
				return "https://tecseg-img.s3.us-east-2.amazonaws.com/atestadovencido.png";
			} else {
				// vencer 30 dias
				Date data30 = SomarDiasData(dataHoje, 30);
				data30 = ConvercaoStringData(ConvercaoData(data30));
				if (asoControle.getDatavencimento().before(data30)) {
					return "https://tecseg-img.s3.us-east-2.amazonaws.com/atestadovencer1.png";
				} else {
					Date data45 = SomarDiasData(dataHoje, 45);
					data45 = ConvercaoStringData(ConvercaoData(data45));
					if (asoControle.getDatavencimento().before(data45)) {
						return "https://tecseg-img.s3.us-east-2.amazonaws.com/atestadovencer2.png";
					}
				}
			}
			return "https://tecseg-img.s3.us-east-2.amazonaws.com/atestadodia.png";
		} else {
			return "https://tecseg-img.s3.us-east-2.amazonaws.com/agendado.png";
		}
	}
	
	public String getMesAno(Date data) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setGregorianChange(data);
		int ano = calendar.get(GregorianCalendar.YEAR);
		int mes = calendar.get(GregorianCalendar.MONTH) + 1;
		String mesAno;
		if (mes<10) {
			mesAno = '0' + String.valueOf(mes) + "/" + String.valueOf(ano);
		}else mesAno = String.valueOf(mes) + "/" + String.valueOf(ano);
		return mesAno;
	}
	
	public int getRestoMes(int mes) {
		if ((mes==1) || (mes==3) || (mes==5) || (mes==7) || (mes==8) || (mes==10) || (mes==12)) {
			return 31;
		} else if ((mes==4) || (mes==6) || (mes==9) || (mes==11)) {
			return 30;
		} else return 28;
	}

}


/*
 * spring.datasource.url=jdbc:mysql://tmmysql.cxjytqucztmb.us-east-1.rds.
 * amazonaws.com:3306/tecseg?Timezone=true&serverTimezone=UTC
 * spring.datasource.username=master spring.datasource.password=Travel2018#
 * spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQLDialect
 */
