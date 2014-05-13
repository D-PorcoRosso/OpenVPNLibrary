package de.blinkt.openvpn.activities;

/**
 * Created by FL on 29.04.14.
 */
public class CreateProfile {
    private String st_client = "client"; // client config
    private String st_remote = "remote"; //определяет удаленный конец туннеля. Могут использоваться записи IP и DNS.
    private String st_local = "local"; //определяет локальный ip или имя хоста, на котором будет работать OpenVPN. Актуально, если на локальной машине несколько адресов.
    private String st_dev = "dev"; // определяет какой использовать тип устройства tun или tap. Например: dev tun или dev tap
    private String st_port = "port"; //указывает на каком порту будет работать OpenVPN (локально и удаленно).
    private String st_porto = "proto"; //какой протокол будет использоваться. Возможные значения: udp, tcp, tcp-client, tcp-server.
    private String st_remote_random = "remote-random"; // если указана данная опция и в random перечисленно несколько удаленных хостов, то OpenVPN в случайном порядке будет к ним подключаться. Применяется для балансировки нагрузки.
    private String st_float = "float"; //позволяет удаленному хосту изменять IP во время работы туннеля. Соединение при этом не разрывается.
    private String st_ipchange  = "ipchange"; // выполняет скрипт или команду указанную в < cmd >, если IP сменился. Пример: ipchange script-ip.sh
    private String st_connect_retry = "connect-retry";//пробует переподключиться через указанное время в секундах, если соединение было разорвано.
    private String st_connect_retry_max = "connect-retry-max"; //максимальное количество повторов если соединение было разорвано
    private String st_resolv_retry = "resolv-retry"; //если OpenVPN не удалось узнать имя удаленного хоста по DNS, то через указанное количество секунд попытаться переподключиться.
    private String st_lport = "lport"; //указывает на локальный порт для использования OpenVPN
    private String st_rport = "rport"; // аналогично для удаленного порта. Пример: rport 8000 - OpenVPN будет пытаться подключится к удаленному порту 8000
    private String st_nobind = "nobind"; // использовать динамический порт для подключения (только для клиента)
    private String st_shaper = "shaper"; // указывает скорость передачи данных в байтах для исходящего трафика (только для клиента)
    private String st_tun_mtu  = "tun-mtu"; //устанавливает максимальный размер MTU. По умолчанию tun-mtu равен 1500. Использование:tun-mtu 1200
    private String st_dev_node  = "dev-node"; //устанавливает имя виртуального интерфейса. Например: dev-node openvpn1
    private String st_ifconfig = "ifconfig"; //устанавливает локальный IP и маску подсети для туннельного интерфейса. Например:ifconfig 10.3.0.1 255.255.255.0
    private String st_server = "server"; // server < network > < mask > - автоматически присваивает адреса всем клиентам (DHCP) в указанном диапазоне с маской сети. Данная опция заменяет ifconfig и может работаеть только с TLS-клиентами в режиме TUN, соответственно использование сертификатов обязательно. Например:server 10.3.0.0 255.255.255.0 Подключившиеся клиенты получат адреса в диапазоне между 10.3.0.1 и 10.3.0.254.
    private String st_server_bridge  = "server-bridge"; //сервер в режиме моста для TAP устройств. Пример:  server bridge 10.3.0.1 255.255.255.0 10.3.0.128 10.3.0.254 Клиентам будут выданы адреса в диапазоне 10.3.0.128 - 10.3.0.254, в качестве шлюза будет указан 10.3.0.1.
    private String st_mode_server  = "mode server"; //переключает OpenVPN в режим сервера (начиная с 2-й версии)
    private String st_mode_p2p  = "mode p2p"; //данная опция идет по умолчанию.
    private String st_comp_lzo = "comp-lzo"; //параметр сжатия трафика, идущего через виртуальный туннель. Может принимать значения yes, no, adaptive. Последнее используется по умолчанию.Например: comp-lzo yes - принудительно включить сжатие comp-lzo no - принудительно отключить сжатие comp-lzo adaptive - адаптивный режим.
    private String st_cipher = "cipher"; //указываем алгоритм шифрования. Например:cipher AES-256-CBC Рекомендуется использование шифров в режиме CBC (Cipher Block Chaining).
    private String st_keysize = "keysize"; // размер ключа в битах. Например: keysize 128
    private String st_auth = "auth"; //алгоритм хэширования. Пример: auth SHA1
    private String st_df = "df"; //файл с ключем Диффи-Хелмана
    private String st_ca = "ca"; //файл сертификата для CA
    private String st_cert = "cert"; //сертификат локальной машины
    private String st_key = "key"; //локальный ключ машины
    private String st_tls_server = "tls-server"; //явно указывает, что данный хост является tls-server
    private String st_tls_client = "tls-client"; //соответственно tls-client
    private String st_pkcs12 = "pkcs12"; //указываем файл (PKCS12), который содержит в себе сертификат, ключ и CA в одном файле. Пример:pkcs12 /file
    private String st_crl_verify = "crl-verify"; //список отозванных сертификатов, т.е. blacklist.
    private String st_no_replay = "no-replay"; // отключает защиту OpenVPN от атаки повторного воспроизведения (replay attack). Крайне не рекомендуется отключать!
    private String st_no_iv = "no-iv"; // отключает использование вектора инициализации шифра (IV). Крайне не рекомендуется отключать!
    private String st_secret = ""; //включает режим шифрования и аутентификации на статических ключах. В качестве параметра использует заранее сгенерированный, командой --genkey, файл. Например:secret key.txt
    private String st_route = "route"; // устанавливает указанную маршрутизацию на VPN-хосте, после успешного запуска туннеля. Пример:route 10.0.10.0 255.255.255.252
    private String st_route_gateway = "route-gateway"; //  устанавливает шлюз на VPN-хосте. Пример: route-gateway 192.168.0.22 После успешного запуска виртуального туннеля клиенту будет задан шлюз 192.168.0.22
    private String st_route_delay  = "route-delay"; //указывает подождать n-секунд перед установкой маршрутов. Пример: route-delay 5
    private String st_route_up = "route-up"; //выполнить скрипт или программу < cmd > после установки маршрутов. Пример: route-up /script.sh
    private String st_redirect_gateway = "redirect-gateway"; //установить шлюзом по умолчанию удаленный сервер. Т.е. когда удаленный пользователь подключается к нашему серверу, то ему будет задан шлюз по умолчанию на наш сервер.
    private String st_ping = "ping"; //указывает отсылать ping на удаленный конец тунеля после указанных n-секунд, если по туннелю не передавался никакой трафик. Пример: ping 10
    private String st_ping_restart = "ping-restart"; //если за указанное время не было получено ни одного пакета с удаленной стороны, то перезапускать туннель. Пример: ping-restart 60 - если в течении 60 секунд не было получено ни одного пакета, то туннель будет перезапущен.
    private String st_ping_timer_rem  = "ping-timer-rem"; //позволяет перезапускать туннель, только когда указан удаленный адрес.
    private String st_persist_tun = "persist-tun"; //данная опция оставляет без изменения устройства tun/tap при перезапуске OpenVPN.
    private String st_persist_key = "persist-key"; //указывает не перечитавать файлы ключей при перезапуске туннеля
    private String st_resolv_retry_sec = "resolv-retry"; //resolv-retry < seconds > - устанавливает время в секундах для запроса об удаленном имени хоста. Актуально только если используется DNS-имя удаленного хоста. Пример: resolv-retry 86400
    private String st_inactive = "inactive"; //после n-секунд неактивности устройство TUN/TAP автоматически отключется. Пример: inactive 120
    private String st_ping_exit = "ping-exit"; //если за указанные n-секунд не было получено ни одного пакета, то отключать OpenVPN. Пример: ping-exit 120
    private String st_keepalive = "keepalive"; //является совмещением сразу двух команд - ping и ping-restart. Использует сразу два параметра в секундах, перечисленных через пробел. Пример: keepalive 10 180 Означает следующее: каждые 10 секунд посылать ping на удаленный хост, и, если за 180 секунд не было получено ни одного пакета - то перезапускать туннель.
    private String st_persist_local_ip  = "persist-local-ip"; //оставлять неизменными локальный IP адрес и номер порт, если туннель был перезапущен.
    private String st_persist_remote_ip  = "persist-remote-ip"; // оставлять неизменными удаленный IP адрес и номер порт, если туннель был перезапущен. persist-remote-ip 192.168.50.1
    private String st_auth_user_pass_verify  = "auth-user-pass-verify"; // указывается только на серверной стороне. < script > - путь к скрипту, который будет производить авторизацию. Скрипт должен возвращать 0 если авторизация успешна, и соответственно, 1 если авторизация не успешна. < method > - метод авторизации, может быть двух типов: via-env и via-file
    private String st_auth_user_pass  = "auth-user-pass"; // указывается на клиентской стороне. Параметр  не обязателен, если он отсутствует то будет предложено ввести пару логин/пароль. должен содержать имя пользователя и пароль в двух строчках: username password
    private String st_client_cert_not_required  = "client-cert-not-required "; //отключает авторизацию по сертификатам
    private String st_http_proxy = "http-proxy"; //указываем адрес и порт прокси-сервера.  http-proxy 192.168.0.12 8080
    private String st_http_proxy_retry  = "http-proxy-retry"; // переподключаться, если соединение было разорвано
    private String st_http_proxy_timeout  = "http-proxy-timeout"; // считать соеденение с прокси-сервером разорванным после n-секунд неактивности. Например: http-proxy-timeout 5
    private String st_socks_proxy  = "socks-proxy"; // указываем сокс-прокси сервер. Пример: socks-proxy 192.168.0.12 8080
    private String st_socks_proxy_retry  = "socks-proxy-retry"; // переподключаться, если соединение было разорвано
    private String st_auto_proxy = "auto-proxy"; // автоматически определять прокси-сервер. Требуется версия OpenVPN 2.1 и выше
    private String st_pull = "pull"; //принимать команды push от сервера.то есть позволять переконфигурировать клиента
    private String st_fast_io = "fast-io "; //(Experimental) Optimize TUN/TAP/UDP I/O writes by avoiding a call to poll/epoll/select prior to the write operation. The purpose of such a call would normally be to block until the device or socket is ready to accept the write. Such blocking is unnecessary on some platforms which don't support write blocking on UDP sockets or TUN/TAP devices. In such cases, one can optimize the event loop by avoiding the poll/epoll/select call, improving CPU efficiency by 5% to 10%
    private String st_ca_start = "<ca>\n-----BEGIN CERTIFICATE-----"; // start of ca certificate
    private String st_ca_end = "\n-----END CERTIFICATE-----\n</ca>"; //end of ca certificate
    private String st_cert_start = "<cert>\n-----BEGIN CERTIFICATE-----"; // start of cert certificate
    private String st_cert_end = "\n-----END CERTIFICATE-----\n</cert>"; //end of cert certificate
    private String st_RSA_PRIVATE_KEY_start = "<key>\n-----BEGIN RSA PRIVATE KEY-----"; //
    private String st_RSA_PRIVATE_KEY_end = "\n-----END RSA PRIVATE KEY-----\n</key>"; //
    private String finalConfig =st_client;



    public String clearFinalConfig(){
        finalConfig = st_client;
        return finalConfig;
    };
    public String setRemote(String v_remote){
        String temp = st_remote + " " + v_remote;
        return temp;
    };
    public String setLocal(String v_local){
        String temp = st_local + " " + v_local;
        return temp;
    };
    public String setDev(String v_dev){
        String temp = st_dev + " " + v_dev;
        return temp;
    };
    public String setPort(String v_port){
        String temp = st_port + " " + v_port;
        return temp;
    };
    public String setProto(String v_porto){
        String temp = st_porto + " " + v_porto;
        return temp;
    };
    public String setRemote_random(String v_remote_random){
        String temp = st_remote_random + " " + v_remote_random;
        return temp;
    };
    public String setFloat(String v_float){
        String temp = st_float + " " + v_float;
        return temp;
    };
    public String setIpchange(String v_ipchange){
        String temp = st_ipchange + " " + v_ipchange;
        return temp;
    };
    public String setConnect_retry(String v_connect_retry){
        String temp = st_connect_retry + " " + v_connect_retry;
        return temp;
    };
    public String setConnect_retry_max(String v_connect_retry_max){
        String temp = st_connect_retry_max + " " + v_connect_retry_max;
        return temp;
    };
    public String setResolv_retry(String v_resolv_retry){
        String temp = st_resolv_retry + " " + v_resolv_retry;
        return temp;
    };
    public String setlport(String v_lport){
        String temp = st_lport + " " + v_lport;
        return temp;
    };
    public String setRport(String v_rport){
        String temp = st_rport + " " + v_rport;
        return temp;
    };
    public String setNobind(String v_nobind){
        String temp = st_nobind + " " + v_nobind;
        return temp;
    };
    public String setShaper(String v_shaper){
        String temp = st_shaper + " " + v_shaper;
        return temp;
    };
    public String setTun_mtu(String v_tun_mtu){
        String temp = st_tun_mtu + " " + v_tun_mtu;
        return temp;
    };
    public String setDev_node(String v_dev_node){
        String temp = st_dev_node + " " + v_dev_node;
        return temp;
    };
    public String setIfconfig(String v_ifconfig){
        String temp = st_ifconfig + " " + v_ifconfig;
        return temp;
    };
    public String setServer(String v_server){
        String temp = st_server + " " + v_server;
        return temp;
    };
    public String setServer_bridge(String v_server_bridge){
        String temp = st_server_bridge + " " + v_server_bridge;
        return temp;
    };
    public String setMode_server(String v_mode_server){
        String temp = st_mode_server + " " + v_mode_server;
        return temp;
    };
    public String setMode_p2p(String v_mode_p2p){
        String temp = st_mode_p2p + " " + v_mode_p2p;
        return temp;
    };
    public String setComp_lzo(String v_comp_lzo){
        String temp = st_comp_lzo + " " + v_comp_lzo;
        return temp;
    };
    public String setCipher(String v_cipher){
        String temp = st_cipher + " " + v_cipher;
        return temp;
    };
    public String setKeysize(String v_keysize){
        String temp = st_keysize + " " + v_keysize;
        return temp;
    };
    public String setAuth(String v_auth){
        String temp = st_auth + " " + v_auth;
        return temp;
    };

    public String setDf(String v_df){
        String temp = st_df + " " + v_df;
        return temp;
    };
    public String setCa(String v_ca){
        String temp = st_ca + " " + v_ca;
        return temp;
    };
    public String setCert(String v_cert){
        String temp = st_cert + " " + v_cert;
        return temp;
    };

    public String setKey(String v_key){
        String temp = st_key + " " + v_key;
        return temp;
    };

    public String setTls_server(String v_tls_server){
        String temp = st_tls_server + " " + v_tls_server;
        return temp;
    };
    public String setTls_client(String v_tls_client){
        String temp = st_tls_client + " " + v_tls_client;
        return temp;
    };
    public String setPkcs12(String v_pkcs12){
        String temp = st_pkcs12 + " " + v_pkcs12;
        return temp;
    };

    public String setCrl_verify(String v_crl_verify){
        String temp = st_crl_verify + " " + v_crl_verify;
        return temp;
    };
    public String setNo_reply(String v_no_replay){
        String temp = st_no_replay + " " + v_no_replay;
        return temp;
    };
    public String setNo_iv(String v_no_iv){
        String temp = st_no_iv + " " + v_no_iv;
        return temp;
    };
    public String setSecret(String v_secret){
        String temp = st_secret + " " + v_secret;
        return temp;
    };
    public String setRoute(String v_route){
        String temp = st_route + " " + v_route;
        return temp;
    };
    public String setRoute_gateway(String v_route_gateway){
        String temp = st_route_gateway + " " + v_route_gateway;
        return temp;
    };
    public String setRoute_delay(String v_route_delay){
        String temp = st_route_delay + " " + v_route_delay;
        return temp;
    };
    public String setRoute_up(String v_route_up){
        String temp = st_route_up + " " + v_route_up;
        return temp;
    };
    public String setRedirect_gateway(String v_redirect_gateway){
        String temp = st_redirect_gateway + " " + v_redirect_gateway;
        return temp;
    };
    public String setPing(String v_ping){
        String temp = st_ping + " " + v_ping;
        return temp;
    };
    public String setPing_restart(String v_ping_restart){
        String temp = st_ping_restart + " " + v_ping_restart;
        return temp;
    };
    public String setPing_timer_rem(String v_ping_timer_rem){
        String temp = st_ping_timer_rem + " " + v_ping_timer_rem;
        return temp;
    };
    public String setPersist_tun(String v_persist_tun){
        String temp = st_persist_tun + " " + v_persist_tun;
        return temp;
    };
    public String setPersist_key(String v_persist_key){
        String temp = st_persist_key + " " + v_persist_key;
        return temp;
    };
    public String setResolv_retry_sec(String v_resolv_retry_sec){
        String temp = st_resolv_retry_sec + " " + v_resolv_retry_sec;
        return temp;
    };
    public String setInactive(String v_inactive){
        String temp = st_inactive + " " + v_inactive;
        return temp;
    };
    public String setPing_exit(String v_ping_exit){
        String temp = st_ping_exit + " " + v_ping_exit;
        return temp;
    };
    public String setKeeparlive(String v_keepalive){
        String temp = st_keepalive + " " + v_keepalive;
        return temp;
    };
    public String setPersist_local_ip(String v_persist_local_ip){
        String temp = st_persist_local_ip + " " + v_persist_local_ip;
        return temp;
    };
    public String setPersist_remote_ip(String v_persist_remote_ip){
        String temp = st_persist_remote_ip + " " + v_persist_remote_ip;
        return temp;
    };
    public String setAuth_user_pass_verify(String v_auth_user_pass_verify){
        String temp = st_auth_user_pass_verify + " " + v_auth_user_pass_verify;
        return temp;
    };
    public String setAuth_user_pass(String v_auth_user_pass){
        String temp = st_auth_user_pass + " " + v_auth_user_pass;
        return temp;
    };
    public String setClient_cert_not_required(String v_client_cert_not_required){
        String temp = st_client_cert_not_required + " " + v_client_cert_not_required;
        return temp;
    };
    public String setHttp_proxy(String v_http_proxy){
        String temp = st_http_proxy + " " + v_http_proxy;
        return temp;
    };

    public String setHttp_proxy_retry(String v_http_proxy_retry){
        String temp = st_http_proxy_retry + " " + v_http_proxy_retry;
        return temp;
    };

    public String setHttp_proxy_timeout(String v_http_proxy_timeout){
        String temp = st_http_proxy_timeout + " " + v_http_proxy_timeout;
        return temp;
    };

    public String setSocks_proxy(String v_socks_proxy){
        String temp = st_socks_proxy + " " + v_socks_proxy;
        return temp;
    };

    public String setSocks_proxy_retry(String v_socks_proxy_retry){
        String temp = st_socks_proxy_retry + " " + v_socks_proxy_retry;
        return temp;
    };

    public String setAuth_proxy(String v_auto_proxy){
        String temp = st_auto_proxy + " " + v_auto_proxy;
        return temp;
    };

    public String setPull(String v_pull){
        String temp = st_pull + " " + v_pull;
        return temp;
    };

    public String setFast_io(String v_fast_io){
        String temp = st_fast_io + " " + v_fast_io;
        return temp;
    };

    public String setCa_ser(String v_ca_ser){
        String temp = st_ca_start + "\n" + v_ca_ser + st_ca_end;
        return temp;
    };
    public String setCert_ser(String v_cert_ser){
        String temp = st_cert_start + "\n" + v_cert_ser + st_cert_end;
        return temp;
    };
    public String setRSA_PRIVATE_KEY(String v_RSA_PRIVATE_KEY){
        String temp = st_RSA_PRIVATE_KEY_start + "\n" + v_RSA_PRIVATE_KEY + st_RSA_PRIVATE_KEY_end;
        return temp;
    };
    public String setCuston(String v_custorm){
        return v_custorm;
    };

    public void addToConfig(String add){
        finalConfig += "\n" + add;

    }
    public String getFinalConfig(){
        return finalConfig;
    }

}
