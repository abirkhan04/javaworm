
package com.javaworm;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.18
 * 2018-04-15T13:13:03.931+06:00
 * Generated source version: 2.7.18
 * 
 */
public final class CodeFirstService_CodeFirstServicePort_Client {

    private static final QName SERVICE_NAME = new QName("http://javaworm.com/", "CodeFirstServiceService");

    private CodeFirstService_CodeFirstServicePort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = CodeFirstServiceService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        CodeFirstServiceService ss = new CodeFirstServiceService(wsdlURL, SERVICE_NAME);
        CodeFirstService port = ss.getCodeFirstServicePort();  
        
        {
        System.out.println("Invoking showPersonDetail...");
        java.lang.String _showPersonDetail_arg0 = "";
        java.lang.Integer _showPersonDetail_arg1 = null;
        java.lang.String _showPersonDetail__return = port.showPersonDetail(_showPersonDetail_arg0, _showPersonDetail_arg1);
        System.out.println("showPersonDetail.result=" + _showPersonDetail__return);


        }

        System.exit(0);
    }

}
