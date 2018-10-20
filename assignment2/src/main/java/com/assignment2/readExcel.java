package com.assignment2;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class readExcel {

    private static final String FILE_NAME = "D:\\chessResultsList.xls";
    private static final String TABLE_FORMAT = "+-----+--------------------------------------------+-------+---------+---------+-------------------------+";
    ArrayList<student> Studentlist = new ArrayList<student>();
    ArrayList<first> firstList = new ArrayList<first>();
    ArrayList<last> lastList = new ArrayList<last>();

    public List<first> readFirstData() {
        try {
            System.out.println("\n");
            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(FILE_NAME));
            HSSFSheet sheet = workbook.getSheetAt(0);//Sheet Index


            for (int b = 0; b <= 3; b++) {
                //Tittle is at Row number 2 and index is number 1
                HSSFRow word = sheet.getRow(b);
                System.out.println(word.getCell(0).getStringCellValue());
                //list.add(word.getCell(0).getStringCellValue());
                firstList.add(new first(word.getCell(0).getStringCellValue()));
            }
            return firstList;

        } catch (Exception e) {
            return null;
        }
    }//End firstRead

        public List <student> readStudent(){
            try {
                System.out.println("\n");
                HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(FILE_NAME));
                HSSFSheet sheet = workbook.getSheetAt(0);//Sheet Index


                System.out.println(TABLE_FORMAT);
                System.out.format("%5s%30s%23s%5s%9s%21s%11s%n", "| id  |", " Name", "| FideID|", "FED", "| RTG", "|  Club or City ", "|");
                System.out.println(TABLE_FORMAT);

                //Start From Row No.5
                for (int a = 5; a <= 154; a++) {
                    int b = a - 4;
                    HSSFRow row = sheet.getRow(a);
                    System.out.printf("| %3d", b);
                    //Name
                    System.out.printf(" | %42s", row.getCell(2).getStringCellValue());
                    //FideID
                    System.out.printf(" | %5s", row.getCell(3).getStringCellValue());
                    //FED
                    System.out.printf(" | %7s", row.getCell(4).getStringCellValue());
                    //RTG
                    System.out.printf(" | %7s", row.getCell(5).getNumericCellValue());
                    //Club or City
                    System.out.printf(" | %23s | %n", row.getCell(6).getStringCellValue());

                    int index = b;
                    String name = row.getCell(2).getStringCellValue();
                    String fideId = row.getCell(3).getStringCellValue();
                    String fed = row.getCell(4).getStringCellValue();
                    double rtg = row.getCell(5).getNumericCellValue();
                    String cc = row.getCell(6).getStringCellValue();


                    //Add data to Array
                    Studentlist.add(new student(b, name, fideId, fed, rtg, cc));

                }//End For

                System.out.println(TABLE_FORMAT);

                return Studentlist;
            }catch (Exception e){
                return null;
            }
        }//End of ReadStudent

            /*
             *
             * END OF TABLE
             *
             */

            //Content after the Table
        public List <last> readLastExcel() {
            try {
                System.out.println("\n");
                HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(FILE_NAME));
                HSSFSheet sheet = workbook.getSheetAt(0);//Sheet Index
                for (int c = 156; c <= 157; c++) {
                    //Tittle is at Row number 2 and index is number 1
                    HSSFRow word1 = sheet.getRow(c);
                    System.out.printf("%70s%n", word1.getCell(0).getStringCellValue());
                    lastList.add(new last(word1.getCell(0).getStringCellValue()));
                }
                return lastList;
            } catch (Exception e) {
                return null;
            }
        }// End ReadLast

}//end This CLASS
