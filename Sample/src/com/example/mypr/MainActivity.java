package com.example.mypr;

import ru.drivepixels.openvpn.OpenVPNHelper;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	String text;
	Activity act;
 
	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test);

		act = this;
		text = "client\n"
				+ "dev tun2\n"
				+ "proto udp\n"
				+ "remote 93.115.84.195 25000\n"
				+ "resolv-retry infinite\n"
				+ "nobind\n"
				+ "persist-key\n"
				+ "persist-tun\n"
				+ "auth-user-pass\n"
				+ "comp-lzo\n"
				+ "verb 3\n"
				+ "cipher AES-128-CBC\n"
				+ "fast-io\n"
				+ "pull\n"
				+ "route-delay 2\n"
				+ "redirect-gateway\n"
				+ "<ca>\n"
				+ "-----BEGIN CERTIFICATE-----\n"
				+ "MIIDyzCCAzSgAwIBAgIJAKRtpjsIvek1MA0GCSqGSIb3DQEBBQUAMIGgMQswCQYD\n"
				+ "VQQGEwJDSDEPMA0GA1UECBMGWnVyaWNoMQ8wDQYDVQQHEwZadXJpY2gxFDASBgNV\n"
				+ "BAoTC3ZwbmJvb2suY29tMQswCQYDVQQLEwJJVDEUMBIGA1UEAxMLdnBuYm9vay5j\n"
				+ "b20xFDASBgNVBCkTC3ZwbmJvb2suY29tMSAwHgYJKoZIhvcNAQkBFhFhZG1pbkB2\n"
				+ "cG5ib29rLmNvbTAeFw0xMzA0MjQwNDA3NDhaFw0yMzA0MjIwNDA3NDhaMIGgMQsw\n"
				+ "CQYDVQQGEwJDSDEPMA0GA1UECBMGWnVyaWNoMQ8wDQYDVQQHEwZadXJpY2gxFDAS\n"
				+ "BgNVBAoTC3ZwbmJvb2suY29tMQswCQYDVQQLEwJJVDEUMBIGA1UEAxMLdnBuYm9v\n"
				+ "ay5jb20xFDASBgNVBCkTC3ZwbmJvb2suY29tMSAwHgYJKoZIhvcNAQkBFhFhZG1p\n"
				+ "bkB2cG5ib29rLmNvbTCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEAyNwZEYs6\n"
				+ "WN+j1zXYLEwiQMShc1mHmY9f9cx18hF/rENG+TBgaS5RVx9zU+7a9X1P3r2OyLXi\n"
				+ "WzqvEMmZIEhij8MtCxbZGEEUHktkbZqLAryIo8ubUigqke25+QyVLDIBuqIXjpw3\n"
				+ "hJQMXIgMic1u7TGsvgEUahU/5qbLIGPNDlUCAwEAAaOCAQkwggEFMB0GA1UdDgQW\n"
				+ "BBRZ4KGhnll1W+K/KJVFl/C2+KM+JjCB1QYDVR0jBIHNMIHKgBRZ4KGhnll1W+K/\n"
				+ "KJVFl/C2+KM+JqGBpqSBozCBoDELMAkGA1UEBhMCQ0gxDzANBgNVBAgTBlp1cmlj\n"
				+ "aDEPMA0GA1UEBxMGWnVyaWNoMRQwEgYDVQQKEwt2cG5ib29rLmNvbTELMAkGA1UE\n"
				+ "CxMCSVQxFDASBgNVBAMTC3ZwbmJvb2suY29tMRQwEgYDVQQpEwt2cG5ib29rLmNv\n"
				+ "bTEgMB4GCSqGSIb3DQEJARYRYWRtaW5AdnBuYm9vay5jb22CCQCkbaY7CL3pNTAM\n"
				+ "BgNVHRMEBTADAQH/MA0GCSqGSIb3DQEBBQUAA4GBAKaoCEWk2pitKjbhChjl1rLj\n"
				+ "6FwAZ74bcX/YwXM4X4st6k2+Fgve3xzwUWTXinBIyz/WDapQmX8DHk1N3Y5FuRkv\n"
				+ "wOgathAN44PrxLAI8kkxkngxby1xrG7LtMmpATxY7fYLOQ9yHge7RRZKDieJcX3j\n"
				+ "+ogTneOl2w6P0xP6lyI6\n"
				+ "-----END CERTIFICATE-----\n"
				+ "</ca>\n"
				+ "<cert>\n"
				+ "-----BEGIN CERTIFICATE-----\n"
				+ "MIID6DCCA1GgAwIBAgIBATANBgkqhkiG9w0BAQUFADCBoDELMAkGA1UEBhMCQ0gx\n"
				+ "DzANBgNVBAgTBlp1cmljaDEPMA0GA1UEBxMGWnVyaWNoMRQwEgYDVQQKEwt2cG5i\n"
				+ "b29rLmNvbTELMAkGA1UECxMCSVQxFDASBgNVBAMTC3ZwbmJvb2suY29tMRQwEgYD\n"
				+ "VQQpEwt2cG5ib29rLmNvbTEgMB4GCSqGSIb3DQEJARYRYWRtaW5AdnBuYm9vay5j\n"
				+ "b20wHhcNMTMwNTA2MDMyMTIxWhcNMjMwNTA0MDMyMTIxWjB4MQswCQYDVQQGEwJD\n"
				+ "SDEPMA0GA1UECBMGWnVyaWNoMQ8wDQYDVQQHEwZadXJpY2gxFDASBgNVBAoTC3Zw\n"
				+ "bmJvb2suY29tMQ8wDQYDVQQDEwZjbGllbnQxIDAeBgkqhkiG9w0BCQEWEWFkbWlu\n"
				+ "QHZwbmJvb2suY29tMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCkTM/8E+JH\n"
				+ "CjskqMIwgYDrNCBTWZLa+qKkJjZ/rliJomTfVYwKwv1AHYYU6RHpCxS1qFp3BEKL\n"
				+ "vQlASuzycSv1FGnNiLmg94fqzzWdmjs1XWosnLqbOwxx2Ye/1WoakSHia0pItoZk\n"
				+ "xK7/fllm42+Qujri/ERGga5Cb/TfiP6pUQIDAQABo4IBVzCCAVMwCQYDVR0TBAIw\n"
				+ "ADAtBglghkgBhvhCAQ0EIBYeRWFzeS1SU0EgR2VuZXJhdGVkIENlcnRpZmljYXRl\n"
				+ "MB0GA1UdDgQWBBTDr4BCNSdOEh+Lx6+4RRK11x8XcDCB1QYDVR0jBIHNMIHKgBRZ\n"
				+ "4KGhnll1W+K/KJVFl/C2+KM+JqGBpqSBozCBoDELMAkGA1UEBhMCQ0gxDzANBgNV\n"
				+ "BAgTBlp1cmljaDEPMA0GA1UEBxMGWnVyaWNoMRQwEgYDVQQKEwt2cG5ib29rLmNv\n"
				+ "bTELMAkGA1UECxMCSVQxFDASBgNVBAMTC3ZwbmJvb2suY29tMRQwEgYDVQQpEwt2\n"
				+ "cG5ib29rLmNvbTEgMB4GCSqGSIb3DQEJARYRYWRtaW5AdnBuYm9vay5jb22CCQCk\n"
				+ "baY7CL3pNTATBgNVHSUEDDAKBggrBgEFBQcDAjALBgNVHQ8EBAMCB4AwDQYJKoZI\n"
				+ "hvcNAQEFBQADgYEAoDgD8mpVPnHUh7RhQziwhp8APC8K3jToZ0Dv4MYXQnzyXziH\n"
				+ "QbewJZABCcOKYS0VRB/6zYX/9dIBogA/ieLgLrXESIeOp1SfP3xt+gGXSiJaohyA\n"
				+ "/NLsTi/Am8OP211IFLyDLvPqZuqlh/+/GOLcMCeCrMj4RYxWstNxtguGQFc=\n"
				+ "-----END CERTIFICATE-----\n"
				+ "</cert>\n"
				+ "<key>\n"
				+ "-----BEGIN RSA PRIVATE KEY-----\n"
				+ "MIICXAIBAAKBgQCkTM/8E+JHCjskqMIwgYDrNCBTWZLa+qKkJjZ/rliJomTfVYwK\n"
				+ "wv1AHYYU6RHpCxS1qFp3BEKLvQlASuzycSv1FGnNiLmg94fqzzWdmjs1XWosnLqb\n"
				+ "Owxx2Ye/1WoakSHia0pItoZkxK7/fllm42+Qujri/ERGga5Cb/TfiP6pUQIDAQAB\n"
				+ "AoGANX508WQf9nVUUFlJ8LUZnnr4U2sEr5uPPNbcQ7ImTZm8MiMOV6qo/ikesMw5\n"
				+ "8qCS+5p26e1PJWRFENPUVhOW9c07z+nRMyHBQzFnNAFD7TiayjNk1gz1oIXarceR\n"
				+ "edNGFDdWCwXh+nJJ6whbQn9ioyTg9aqScrcATmHQxTit0GECQQDR5FmwC7g0eGwZ\n"
				+ "VHgSc/bZzo0q3VjNGakrA2zSXWUWrE0ybBm2wJNBYKAeskzWxoc6/gJa8mKEU+Vv\n"
				+ "ugGb+J/tAkEAyGSEmWROUf4WX5DLl6nkjShdyv4LAQpByhiwLjmiZL7F4/irY4fo\n"
				+ "ct2Ii5uMzwERRvHjJ7yzJJic8gkEca2adQJABxjZj4JV8DBCN3kLtlQFfMfnLhPd\n"
				+ "9NFxTusGuvY9fM7GrXXKSMuqLwO9ZkxRHNIJsIz2N20Kt76+e1CmzUdS4QJAVvbQ\n"
				+ "WKUgHBMRcI2s3PecuOmQspxG+D+UR3kpVBYs9F2aEZIEBuCfLuIW9Mcfd2I2NjyY\n"
				+ "4NDSSYp1adAh/pdhVQJBANDrlnodYDu6A+a4YO9otjd+296/T8JpePI/KNxk7N0A\n"
				+ "gm7SAhk379I6hr5NXdBbvTedlb1ULrhWV8lpwZ9HW2k=\n"
				+ "-----END RSA PRIVATE KEY-----\n" + "</key>";

		final OpenVPNHelper helper = new OpenVPNHelper(act, text);

		Button end = (Button) findViewById(R.id.end);
		end.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				helper.disconnectVPN();
			}
		});

		Button go = (Button) findViewById(R.id.go);

		go.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				helper.startVpn();
			}
		});
	}
}