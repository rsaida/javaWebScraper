package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CreateExcel {
//sk-proj-aLKuU02t0BPQSQJDu1CqT3BlbkFJgch9jkpcRjOCOeRGfYRl
        private static final String filePath = "C:\\Users\\Asus\\Desktop\\test.txt";
        private static String input = "";
        private static final String err = "Oldingi";
        public static String getInput() {
            return input;
        }

    public static void readFromFile(){
            try {
                input = new String(Files.readAllBytes(Paths.get(filePath)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


      public static void createExcelFile(String input, String name){
          List<String[]> resultList = new ArrayList<>();
          String[] lines = input.split("\n");

          for (String line : lines) {
              if(!(line.charAt(0)=='(' || line.substring(0,err.length()).equals(err))) {
                  int firstSpaceIndex = line.indexOf(' ');
                  if (firstSpaceIndex != -1) {
                      String firstPart = line.substring(0, firstSpaceIndex);
                      String restOfLine = line.substring(firstSpaceIndex + 1);
                      resultList.add(new String[]{firstPart, restOfLine});
                  } else {
                      resultList.add(new String[]{line, ""});
                  }
              }
          }

          try (Workbook workbook = new XSSFWorkbook()) {
              Sheet sheet = workbook.createSheet("Sample Sheet");

              Row headerRow = sheet.createRow(0);
              Cell headerCell0 = headerRow.createCell(0);
              headerCell0.setCellValue("ID");
              Cell headerCell1 = headerRow.createCell(1);
              headerCell1.setCellValue("Desc");

              for (int i = 0; i < resultList.size(); i++) {
                  Row row = sheet.createRow(i + 1);
                  Cell cell0 = row.createCell(0);
                  cell0.setCellValue(resultList.get(i)[0]);
                  Cell cell1 = row.createCell(1);
                  cell1.setCellValue(resultList.get(i)[1]);
              }
              try (FileOutputStream fileOut = new FileOutputStream(name + ".xlsx")) {
                  workbook.write(fileOut);
              } catch (IOException e) {
                  e.printStackTrace();
              }
          } catch (IOException e) {
              e.printStackTrace();
          }
      }

      public static void createFromList(List<String[]> resultList, String name){
          try (Workbook workbook = new XSSFWorkbook()) {
              Sheet sheet = workbook.createSheet("Sample Sheet");

              Row headerRow = sheet.createRow(0);
              Cell headerCell0 = headerRow.createCell(0);
              headerCell0.setCellValue("ID");
              Cell headerCell1 = headerRow.createCell(1);
              headerCell1.setCellValue("Desc");

              for (int i = 0; i < resultList.size(); i++) {
                  Row row = sheet.createRow(i + 1);
                  Cell cell0 = row.createCell(0);
                  cell0.setCellValue(resultList.get(i)[0]);
                  Cell cell1 = row.createCell(1);
                  cell1.setCellValue(resultList.get(i)[1]);
              }
              try (FileOutputStream fileOut = new FileOutputStream(name + ".xlsx")) {
                  workbook.write(fileOut);
              } catch (IOException e) {
                  e.printStackTrace();
              }
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
    }


