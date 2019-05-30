/**
 * "@author Arul JayaSingh
 */
package com.amg.exchange.bean;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.logging.Logger;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.context.FacesContext;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@ManagedBean

public class GoogleMapGenerator implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String address;
	private final static Logger log = Logger.getLogger(GoogleMapGenerator.class.getName()); 
    private static final String GEO_CODE_SERVER = "http://maps.googleapis.com/maps/api/geocode/json?";
    
    private Marker marker;
    private MapModel simpleModel;
    
    /**
     * for get map model
     * @return
     */
    public MapModel getSimpleModel() {
        return simpleModel;
    }
    
    
    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Selected", marker.getTitle()));
    }
      
    public Marker getMarker() {
        return marker;
    }
 
    /**
	 * @return the address
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}


	/**
	 * For getting Latitude & Longitude
	 * @return
	 */
	public String gmap(){
		simpleModel = new DefaultMapModel();
		
		String code = getAddress();
		String pos="";
        String response = getLocation(code);

        String[] result = parseLocation(response);
        
      

        log.info("Latitude: " + result[0]);
        log.info("Longitude: " + result[1]);
        if(result[0]!=null&&result[1]!=null){
        	pos=result[0] +", "+result[1];
        LatLng coord1 = new LatLng(Double.parseDouble(result[0]),Double.parseDouble(result[1]));
        simpleModel.addOverlay(new Marker(coord1, getAddress()));
        }
        else{
        	pos="29.3270885, 48.0679507";
        	 LatLng coord2 = new LatLng(29.3270885,48.0679507);
             simpleModel.addOverlay(new Marker(coord2, "AlMulla Exchange, Block 10, Kuwait"));
        }
        
        System.out.println("Gmap  :"+pos);
        	
        return pos;
	}

	/**
	 * get location
	 * @param code
	 * @return
	 */
    private static String getLocation(String code)
    {
        String address = buildUrl(code);

        String content = null;

        try
        {
            URL url = new URL(address);

            InputStream stream = url.openStream();

            try
            {
                int available = stream.available();

                byte[] bytes = new byte[available];

                stream.read(bytes);

                content = new String(bytes);
            }
            finally
            {
                stream.close();
            }

            return (String) content.toString();
        }catch(UnknownHostException ue){
        	log.info("connection Not found");
        	throw new RuntimeException(ue);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * create service url 
     * @param code
     * @return
     */

    private static String buildUrl(String code)
    {
        StringBuilder builder = new StringBuilder();

        builder.append(GEO_CODE_SERVER);

        builder.append("address=");
        if(code==null)
        code="Block 10, Kuwait";
        builder.append(code.replaceAll(" ", "+"));
      
        builder.append("&sensor=false");

        return builder.toString();
    }
    /**
     * Parse url get location
     * @param response
     * @return
     */
    private static String[] parseLocation(String response)
    {
        // Look for location using brute force.
        // There are much nicer ways to do this, e.g. with Google's JSON library: Gson
        //     https://sites.google.com/site/gson/gson-user-guide

        String[] lines = response.split("\n");

        String lat = null;
        String lng = null;

        for (int i = 0; i < lines.length; i++)
        {
            if ("\"location\" : {".equals(lines[i].trim()))
            {
                lat = getOrdinate(lines[i+1]);
                lng = getOrdinate(lines[i+2]);
                break;
            }
        }

        return new String[] {lat, lng};
    }
    /**
     * split address
     * @param address
     * @return
     */
    private static String getOrdinate(String address)
    {
        String[] split = address.trim().split(" ");

        if (split.length < 1)
        {
            return null;
        }

        String ord = split[split.length - 1];

        if (ord.endsWith(","))
        {
            ord = ord.substring(0, ord.length() - 1);
        }

        // Check that the result is a valid double
        Double.parseDouble(ord);

        return ord;
    }
    
    
	
}
