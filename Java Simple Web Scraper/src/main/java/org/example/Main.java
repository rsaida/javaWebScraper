package org.example;

import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.util.List;


//sk-proj-aLKuU02t0BPQSQJDu1CqT3BlbkFJgch9jkpcRjOCOeRGfYRl
public class Main {
    public static void main(String[] args) throws IOException {
        FromWeb fromWeb = new FromWeb();

        List<String[]> download = fromWeb.download();

        CreateExcel.createFromList(download, "uzb2");
//        CreateExcel.readFromFile();
//        CreateExcel.createExcelFile(CreateExcel.getInput(),"uzb");
        // String input = CreateExcel.getInput();
        //System.out.println(input);
//        String a ="1234 Salom, qalaysiz?\n1234Salom, qalaysiz?";
//        String res = Translator.translateText(a,"en");
//        System.out.println(res);
////        String res = "1234 dsfg\n123 dfg";
//        CreateExcel.createExcelFile(res, "en");
    }
}