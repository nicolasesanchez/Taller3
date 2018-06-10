package tc3.tp3.utils.db;

import java.lang.reflect.InvocationTargetException;

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

    public DBEnviroment(String enviromentName) throws IllegalArgumentException {
        this(enviromentName, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED);
    }

    public DBEnviroment(String enviromentName, String driver, String server, String port, String database, String username, String password) throws IllegalArgumentException {
        setValues(enviromentName, driver, server, port, database, username, password);
    }

    public String getEnviromentName() {
        return enviromentName;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        checkValue(driver, K_DRIVER);
        this.driver = driver;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        checkValue(server, K_SERVER);
        this.server = server;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        checkValue(port, K_PORT);
        this.port = port;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        checkValue(database, K_DATABASE);
        this.database = database;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        checkValue(username, K_USERNAME);
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        checkValue(password, K_PASSWORD);
        this.password = password;
    }

    public String getURL() {
        return String.format(CONN_STRING_TEMPLATE, driver, server, port, database, username, password);
    }

    public void setValueOf(String attribute, String value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        attribute = attribute.toLowerCase().trim();
        attribute = attribute.substring(0, 1).toUpperCase() + attribute.substring(1);
        this.getClass()
                .getMethod("set" + attribute, String.class)
                .invoke(this, value);
    }

    protected void setValues(String enviromentName, String driver, String server, String port, String database, String username, String password) throws IllegalArgumentException {
        setEnviromentName(enviromentName);
        setDriver(driver);
        setServer(server);
        setPort(port);
        setDatabase(database);
        setUsername(username);
        setPassword(password);
    }

    private void setEnviromentName(String name) {
        checkValue(name, K_ENVIROMENT);
        enviromentName = name;
    }

    private void checkValue(String fieldValue, String fieldName) throws IllegalArgumentException {
        if (!fieldName.equals(K_PASSWORD) || !fieldName.equals(K_USERNAME)) {
            if (fieldValue == null || fieldValue.matches(whiteSpaceRegex)) {
                throw new IllegalArgumentException();
            }
        }
        fieldValue = UNDEFINED;
    }


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        DBEnviroment db = new DBEnviroment("ambiente");
        //DBEnviroment db1 = new DBEnviroment("   ");
        //DBEnviroment db2 = new DBEnviroment(null);
        db.setValueOf("driver", "asldñka");
        System.out.println(db.getURL());

        System.out.println(db.getEnviromentName());
        //System.out.println(db1.getEnviromentName());
        //System.out.println(db2.getEnviromentName());

    }

}
