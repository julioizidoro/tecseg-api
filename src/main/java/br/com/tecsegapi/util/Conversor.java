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
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
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
	
	
	public String verficarSituacaoAtestado(Asocontrole asoControle) {
		String data = ConvercaoData(new Date());
		
		Date dataHoje = ConvercaoStringData(data);
		//vencida
		if (asoControle.getDatavencimento().before(dataHoje)) {
			return "../../tecseg/assets/img/atestadovencido.png";
		}else {
			//vencer 30 dias
			Date data30 = SomarDiasData(dataHoje, 30);
			data30 = ConvercaoStringData(ConvercaoData(data30));
			if (asoControle.getDatavencimento().before(data30)) {
				return "../../tecseg/assets/img/atestadovencer1.png";
			}else {
				Date data45 = SomarDiasData(dataHoje, 45);
				data45 = ConvercaoStringData(ConvercaoData(data45));
				if (asoControle.getDatavencimento().before(data45)) {
					return "../../tecseg/assets/img/atestadovencer2.png";
				}
			}
		}
		return "../../tecseg/assets/img/atestadodia.png";
	}

}


/*
 * spring.datasource.url=jdbc:mysql://tmmysql.cxjytqucztmb.us-east-1.rds.
 * amazonaws.com:3306/tecseg?Timezone=true&serverTimezone=UTC
 * spring.datasource.username=master spring.datasource.password=Travel2018#
 * spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQLDialect
 */