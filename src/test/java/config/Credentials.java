package config;

import org.aeonbits.owner.Config;


@Config.Sources("classpath: config/credentials.properties")
public interface Credentials extends Config {

	@Key("login")
	String getLogin();


	@Key("password")
	String getPassword();


	@Key("remoteHost")
	String getRemoteHost();

	@Key("appUrl")
	String getAppUrl();
}
