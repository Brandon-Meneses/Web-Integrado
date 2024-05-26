package com.utp.webintegrado.ollama;

public class OllamaRequest {
    private String model_SQL = "duckdb-nsql:7b-q5_K_M";
    private String model_Chat = "openchat:7b-v3.5-1210-q2_K";
    private String system = "Aquí está el esquema de la base de datos en el que se ejecutará la consulta SQL: CREATE TABLE `adquisicion` ( `id_adquisicion` int NOT NULL AUTO_INCREMENT PRIMARY KEY, `cantidad` int NOT NULL, `fecha` date NOT NULL, `id_libro` int NOT NULL, `id_sucursal` int NOT NULL, CONSTRAINT `FK_adquisicion_libro` FOREIGN KEY (`id_libro`) REFERENCES `libro` (`id_libro`), CONSTRAINT `FK_adquisicion_sucursal` FOREIGN KEY (`id_sucursal`) REFERENCES `sucursal` (`id_sucursal`) ); CREATE TABLE `libro` ( `id_libro` int NOT NULL AUTO_INCREMENT PRIMARY KEY, `anio_publicacion` int NOT NULL, `autor` varchar(255) NOT NULL, `descripcion` varchar(255) DEFAULT NULL, `editorial` varchar(255) NOT NULL, `isbn` varchar(255) NOT NULL UNIQUE, `stock_total` int NOT NULL DEFAULT '0', `titulo` varchar(255) NOT NULL ); CREATE TABLE `stock_sucursal` ( `id_libro` int NOT NULL, `id_sucursal` int NOT NULL, `stock` int NOT NULL, PRIMARY KEY (`id_libro`, `id_sucursal`), CONSTRAINT `FK_stock_libro` FOREIGN KEY (`id_libro`) REFERENCES `libro` (`id_libro`), CONSTRAINT `FK_stock_sucursal` FOREIGN KEY (`id_sucursal`) REFERENCES `sucursal` (`id_sucursal`) ); CREATE TABLE `sucursal` ( `id_sucursal` int NOT NULL AUTO_INCREMENT PRIMARY KEY, `ciudad` varchar(255) NOT NULL, `direccion` varchar(255) NOT NULL, `nombre` varchar(255) NOT NULL ); CREATE TABLE `transferencia` ( `id_transferencia` int NOT NULL AUTO_INCREMENT PRIMARY KEY, `cantidad` int NOT NULL, `fecha` date NOT NULL, `id_libro` int NOT NULL, `id_sucursal_destino` int NOT NULL, `id_sucursal_origen` int NOT NULL, CONSTRAINT `FK_transferencia_libro` FOREIGN KEY (`id_libro`) REFERENCES `libro` (`id_libro`), CONSTRAINT `FK_transferencia_sucursal_destino` FOREIGN KEY (`id_sucursal_destino`) REFERENCES `sucursal` (`id_sucursal`), CONSTRAINT `FK_transferencia_sucursal_origen` FOREIGN KEY (`id_sucursal_origen`) REFERENCES `sucursal` (`id_sucursal`) ); CREATE TABLE `usuario` ( `id_usuario` int NOT NULL AUTO_INCREMENT PRIMARY KEY, `contrasena` varchar(255) NOT NULL UNIQUE, `email` varchar(255) NOT NULL, `nombre` varchar(255) NOT NULL, `rol` varchar(255) NOT NULL, `id_sucursal` int DEFAULT NULL, CONSTRAINT `FK_usuario_sucursal` FOREIGN KEY (`id_sucursal`) REFERENCES `sucursal` (`id_sucursal`) );";
    private String prompt;
    private String response_SQL;
    private String explanation;

    public String getModel_SQL() {
        return model_SQL;
    }

    public void setModel_SQL(String model_SQL) {
        this.model_SQL = model_SQL;
    }

    public String getModel_Chat() {
        return model_Chat;
    }

    public void setModel_Chat(String model_Chat) {
        this.model_Chat = model_Chat;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getResponse_SQL() {
        return response_SQL;
    }

    public void setResponse_SQL(String response_SQL) {
        this.response_SQL = response_SQL;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
