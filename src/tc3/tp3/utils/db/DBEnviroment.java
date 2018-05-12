package tc3.tp3.utils.db;

import java.lang.IllegalArgumentException;

public class DBEnviroment {
    public static final String K_PASSWORD = "password";
    public static final String K_USERNAME = "username";
    public static final String K_DATABASE = "database";
    public static final String K_PORT = "port";
    public static final String K_SERVER = "server";
    public static final String K_DRIVER = "driver";
    private static final String K_ENVIROMENT = "enviromentName";
    private static final String CONN_STRING_TEMPLATE = "jdbc:%s://%s;database=%s:%s;user=%s;password=%s";
    private static final String ERR_INVALID_ATTRIBUTE = "Nombre de atributo inválido";
    private static final String ERR_INVALID_ATTR_VALUE = "Valor inválido para el atributo %s ('%s')";
    private static final String UNDEFINED = "[UNDEFINED]";
    private String enviromentName;
    private String driver;
    private String server;
    private String port;
    private String database;
    private String username;
    private String password;

    private String whiteSpaceRegex = "\\s*";

    public DBEnviroment(String enviromentName) {
        setValues(enviromentName, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED);
    }

    public DBEnviroment(String enviromentName, String driver, String server, String port, String database, String username, String password) {
        setValues(enviromentName, driver, server, port, database, username, password);
    }

    public String getEnviromentName() {
        return enviromentName;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getURL() {
        return null;
    }

    public void setValueOf(String a, String b) {
    }

    protected void setValues(String enviromentName, String driver, String server, String port, String database, String username, String password) {
        try {
            setEnviromentName(validateValue(enviromentName));
            setDriver(validateValue(driver));
            setServer(validateValue(server));
            setPort(validateValue(port));
            setDatabase(validateValue(database));
            setUsername(validateUserAndPass(username));
            setPassword(validateUserAndPass(password));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    private void setEnviromentName(String name) {
        enviromentName = name;
    }

    private void checkValue(String a, String b) {

    }

    private String validateValue(String value) throws IllegalArgumentException {
        if (value == null || value.matches(whiteSpaceRegex)) {
            throw new IllegalArgumentException("The value cannot be null or empty");
        } else {
            return value;
        }
    }

    private String validateUserAndPass(String value) {
        String data = value;

        if (data.matches(whiteSpaceRegex) || data == null) {
            data = UNDEFINED;
        }

        return data;
    }

    public static void main(String[] args) {
        DBEnviroment db = new DBEnviroment("");
        //DBEnviroment db1 = new DBEnviroment("   ");
        //DBEnviroment db2 = new DBEnviroment(null);

        System.out.println(db.getEnviromentName());
        //System.out.println(db1.getEnviromentName());
        //System.out.println(db2.getEnviromentName());

    }

}
