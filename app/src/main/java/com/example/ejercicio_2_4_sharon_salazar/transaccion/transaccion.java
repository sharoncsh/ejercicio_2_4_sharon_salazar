package com.example.ejercicio_2_4_sharon_salazar.transaccion;

public class transaccion {

    public static final String tabla_signaturess = "tabla_signaturess";

    public static final String id = "id";
    public static final String dfirma = "dfirma";
    public static final String descripcion = "descripcion";

    public static final String CreateTableSignaturess= "CREATE TABLE tabla_signaturess" +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "dfirma BLOB, " +
            "descripcion TEXT)";

    public static final String DropTableSignaturess= "DROP TABLE IF EXISTS tabla_signaturess";


    public static final String NameDataBase = "DBCapturaFirma";

}
