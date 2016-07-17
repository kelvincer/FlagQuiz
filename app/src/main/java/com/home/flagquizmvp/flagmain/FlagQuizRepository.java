package com.home.flagquizmvp.flagmain;

import com.home.flagquizmvp.entitites.Flag;

/**
 * Created by Kelvin on 5/07/2016.
 */
public interface FlagQuizRepository {

    public static final String[] codes = new String[]{"AR", "BO", "BR", "CL", "CO", "EC", "FK", "GF", "GY", "PY",
                                                        "PE", "SR", "UY", "VE"};

    public static final String[] countries = new String[]{"Argentina", "Bolivia", "Brasil", "Chile", "Colombia", "Ecuador",
                                                "Falkland Islands", "French Guiana", "Guyana", "Paraguay", "Perú", "Suriname",
                                                "Uruguay", "Venezuela"};

    String url = "http://www.geognos.com/api/en/countries/flag/%s.png";

    void getNextFlag();
}
