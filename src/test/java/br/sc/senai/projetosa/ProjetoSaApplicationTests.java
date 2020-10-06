package br.sc.senai.projetosa;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URLDecoder;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;

@SpringBootTest
class ProjetoSaApplicationTests {
	
	@Test
	void contextLoads() {
	}
	
	@Test
    public void givenIP_whenFetchingCity_thenReturnsCityData() throws IOException, GeoIp2Exception {
        
        ClassLoader classLoader = getClass().getClassLoader();
        File database = new File(URLDecoder.decode(classLoader.getResource("GeoLite2-City.mmdb").getFile(),"UTF-8"));
        DatabaseReader dbReader = new DatabaseReader.Builder(database).build();

        InetAddress ipAddress = InetAddress.getByName("google.com");
        CityResponse response = dbReader.city(ipAddress);

        String countryName = response.getCountry().getName();
        String cityName = response.getCity().getName();
        String postal = response.getPostal().getCode();
        String state = response.getLeastSpecificSubdivision().getName();

    }
	
	

}
