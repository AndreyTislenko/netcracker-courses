package com.netcracker.controller;

import com.google.gson.Gson;
import com.netcracker.model.Table;
import com.netcracker.model.TableReader;
import com.netcracker.model.TableSorter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
class RestWebController {

    private TableReader tableReader = new TableReader();

    @GetMapping("/table")
    public String getTable() {
        Table table = null;
        Table defaultTable;
        String gsonTable = null;
        try {
            /*defaultTable = Table.createDefaultTable();
            tableReader.saveTableInJson(defaultTable);*/
            //table = tableReader.readJsonTable();
            //System.out.println("get request here!");

            BufferedReader bufferedReader = new BufferedReader(new FileReader("table.json"));
            gsonTable = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(Arrays.toString(table.getColumnNames()));
        return gsonTable;
    }

    @PostMapping("/save")
    public int saveTable(@RequestBody String gsonTable) {
        try {
            Table table = tableReader.readJsonTable(gsonTable);
            tableReader.saveTableInJson(table);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 200;
    }

    @PostMapping("/sort")
    public String sortTable(@RequestBody String gsonTableSorter) {
        TableSorter tableSorter = new Gson().fromJson(gsonTableSorter, TableSorter.class);
        Table table = tableSorter.sortTable();
        return tableReader.convertTableToJSon(table);
    }
}