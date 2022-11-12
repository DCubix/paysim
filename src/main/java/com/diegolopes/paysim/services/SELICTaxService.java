package com.diegolopes.paysim.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.diegolopes.paysim.Util;
import com.diegolopes.paysim.model.SELICTax;

public class SELICTaxService {
    
    private static final String template =
        "https://api.bcb.gov.br/dados/serie/bcdata.sgs.11/dados?formato=json&dataInicial=%s&dataFinal=%s";
    private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static SELICTax current() {
        final Date date = Calendar.getInstance().getTime();
        final String url = String.format(template, dateFormat.format(date), dateFormat.format(date));
        final Util.Response<List<Map<String, Object>>> dat = Util.httpGetJSON(url);
        if (dat != null && dat.getCode() == 200 && dat.getData().size() > 0) {
            final String valStr = (String) dat.getData().get(0).get("valor");
            return new SELICTax((String) dat.getData().get(0).get("data"), Double.parseDouble(valStr));
        }
        return null;
    }

    public static double accumulated30Days() {
        final Calendar now = Calendar.getInstance();

        final Calendar from = Calendar.getInstance();
        from.set(
            now.get(Calendar.YEAR),
            now.get(Calendar.MONTH),
            1
        );

        final Calendar to = Calendar.getInstance();
        to.set(
            now.get(Calendar.YEAR),
            now.get(Calendar.MONTH),
            now.getActualMaximum(Calendar.DAY_OF_MONTH)
        );

        final String url = String.format(template, dateFormat.format(from.getTime()), dateFormat.format(to.getTime()));
        final Util.Response<List<Map<String, Object>>> dat = Util.httpGetJSON(url);
        if (dat != null && dat.getCode() == 200) {
            double accum = 0.0;
            for (Map<String, Object> entry : dat.getData()) {
                final String valStr = (String) entry.get("valor");
                accum += Double.parseDouble(valStr);
                return accum;
            }
        }
        return 0.0;
    }

}
