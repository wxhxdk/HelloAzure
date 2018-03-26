package org.apache.oltu.oauth2.client.demo.configuration;

import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.Proxy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Configuration
@Component
@PropertySource("classpath:application.properties" )
public class AppConfigurations {

    @Value("${proxy.flag}")
    private String proxyFlag;
    @Value("${proxy.host}")
    private String proxyHost;
    @Value("${proxy.port}")
    private String proxyPort;
    @Value("${proxy.user}")
    private String proxyUser;
    @Value("${proxy.password}")
    private String proxyPassword;
    
    @Bean  
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {  
        return new PropertySourcesPlaceholderConfigurer();  
    }
    
    @Bean
    public Proxy getProxy() {
    	Proxy proxy = null;
	
		if ("1".equals(this.getProxyFlag())) {
			if (!StringUtils.isEmpty(this.getProxyUser())) {
				Authenticator.setDefault(new BasicAuthenticator(this.getProxyUser(), this.getProxyPassword())); 
			}
			proxy = new Proxy(Proxy.Type.DIRECT.HTTP, new InetSocketAddress(this.getProxyHost(), Integer.parseInt(this.getProxyPort())));
		}
	
	    return proxy;
    }
        
	public String getProxyFlag() {
		return proxyFlag;
	}
	public void setProxyFlag(String proxyFlag) {
		this.proxyFlag = proxyFlag;
	}
	public String getProxyHost() {
		return proxyHost;
	}
	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}
	public String getProxyPort() {
		return proxyPort;
	}
	public void setProxyPort(String proxyPort) {
		this.proxyPort = proxyPort;
	}
	public String getProxyUser() {
		return proxyUser;
	}
	public void setProxyUser(String proxyUser) {
		this.proxyUser = proxyUser;
	}
	public String getProxyPassword() {
		return proxyPassword;
	}
	public void setProxyPassword(String proxyPassword) {
		this.proxyPassword = proxyPassword;
	}  

}
