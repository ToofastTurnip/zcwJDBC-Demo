package com.zipcodewilmington.jdbc.tools.database.dbseed;


import com.zipcodewilmington.jdbc.tools.database.MigrationsTable;
import com.zipcodewilmington.jdbc.tools.database.connection.StatementExecutor;

import java.io.IOException;
import java.sql.Connection;

public class WilhemDatabaseSeeder {
    private final Connection connection;

    public WilhemDatabaseSeeder(Connection connection) {
        this.connection = connection;
    }

    public boolean run() {
        MigrationsTable migrationsTable = new MigrationsTable(connection);
        try {
            migrationsTable.importFilesFromResources();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void createSchema() {
        String sqlStatement2 = "CREATE SCHEMA IF NOT EXISTS pokemon;";
        new StatementExecutor(this.connection).execute(sqlStatement2);
    }
}
