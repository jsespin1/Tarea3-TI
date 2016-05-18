/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosClient;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import net.webservicex.Airport;
import net.webservicex.AirportSoap;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;


/**
 *
 * @author jsespinosa
 */
@WebService(serviceName = "getCitiesAndAirports")
public class getCitiesAndAirports {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "getValues")
    public String[] getCitiesAndAirports(@WebParam(name = "pais") String pais) {
        
        String[] resultado = new String[2] ;
        GlobalWeather gw;
        gw = new GlobalWeather();
        
        GlobalWeatherSoap gwSoap;
        gwSoap = gw.getGlobalWeatherSoap();
        resultado[0] = gwSoap.getCitiesByCountry(pais);
        
        Airport ai = new Airport();
        AirportSoap aisoap = ai.getAirportSoap();
        resultado[1] = aisoap.getAirportInformationByCountry(pais);
        
        return resultado;
        

    }
}
