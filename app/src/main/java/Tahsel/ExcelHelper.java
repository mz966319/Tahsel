package Tahsel;

import Tahsel.Objects.Parent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {

//    private static String pathToInput="C:\\Users\\sunrise-beta\\Desktop\\testinput.xlsx";
//    private static String pathToOutput="C:\\Users\\sunrise-beta\\Desktop\\testoutput.xlsx";
    public static void writeParentsToSheet(ArrayList<Parent> parents, String pathToOutput) {
        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Data");
        Row row0 = sheet.createRow(0);
        Cell cell0 = row0.createCell(0);
        cell0.setCellValue((String) "#");
        cell0 = row0.createCell(1);
        cell0.setCellValue((String) "—ﬁ„ Ê·Ì «·«„—");
        cell0 = row0.createCell(2);
        cell0.setCellValue((String) "«”„ Ê·Ì «·«„—");
        cell0 = row0.createCell(3);
        cell0.setCellValue((String) "⁄œœ «·«»‰«¡");
        cell0 = row0.createCell(4);
        cell0.setCellValue((String) "«”„«¡ «·«»‰«¡");

        cell0 = row0.createCell(5);
        cell0.setCellValue((String) "«·’›Ê›");
        cell0 = row0.createCell(6);
        cell0.setCellValue((String) " «—ÌŒ «Œ— ”œ«œ");
        cell0 = row0.createCell(7);
        cell0.setCellValue((String) "„·»€ «Œ— ”œ«œ");
        cell0 = row0.createCell(8);
        cell0.setCellValue((String) "«Ã„«·Ì «·„” Õﬁ");
        cell0 = row0.createCell(9);
        cell0.setCellValue((String) "’«›Ì «·„ »ﬁÌ");

        int rownum = 1;
        for (Parent parent : parents) {
            //create a row of excelsheet
            Row row = sheet.createRow(rownum++);
            Cell cell;

            cell = row.createCell(0);
            cell.setCellValue((Integer) rownum);
            cell = row.createCell(1);
            cell.setCellValue((Integer) parent.getParentID());
            cell = row.createCell(2);
            cell.setCellValue((String) parent.getParentName());
            cell = row.createCell(3);
            cell.setCellValue((Integer) parent.getNumberOfChildren());

            cell = row.createCell(4);
            cell.setCellValue((String) parent.getChildrensNames());

            cell = row.createCell(5);
            cell.setCellValue((String) parent.getGrades());

            CellStyle cellStyle = workbook.createCellStyle();
            CreationHelper createHelper = workbook.getCreationHelper();
            cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("d-mmm-yy"));
            cell.setCellStyle(cellStyle);
            cell = row.createCell(6);
            cell.setCellValue((Date) parent.getLastPaidDate());

            cell = row.createCell(7);
            cell.setCellValue((Double) parent.getLastPaidMoney());
            cell = row.createCell(8);
            cell.setCellValue((Double) parent.getTotalOwed());
            cell = row.createCell(9);
            cell.setCellValue((Double) parent.getRemaining());

        }
        try {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File(pathToOutput));
            workbook.write(out);
            out.close();
            System.out.println("xlsx written successfully on disk.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Parent> getParentsFromSheet(String pathToInput) throws FileNotFoundException, IOException, ParseException {
        ArrayList<Parent> parents = new ArrayList<>();
        int count = 0;

            FileInputStream file = new FileInputStream(new File(pathToInput));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next();
            while (count < 1000000000) //            while (rowIterator.hasNext())
            {
                if (!rowIterator.hasNext()) {
                    break;
                }
                count++;
                Row row = rowIterator.next();
                String childName = row.getCell(1).getStringCellValue().split(" ", 2)[0];
                int parentID = (int) row.getCell(2).getNumericCellValue();
                String parentName = row.getCell(3).getStringCellValue();
                
                String grades = row.getCell(4).getStringCellValue();
                Date lastPaidDate;
                if (row.getCell(5).getCellType() == Cell.CELL_TYPE_STRING) {
                    String string = "9/9/1999";
                    DateFormat format = new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH);
                    lastPaidDate = format.parse(string);
                } else {lastPaidDate = row.getCell(5).getDateCellValue();}
                double lastPaidMoney = row.getCell(6).getNumericCellValue();
                double remaining = row.getCell(7).getNumericCellValue();
                double remainingOldFees = row.getCell(8).getNumericCellValue();
                double totalOwed = row.getCell(9).getNumericCellValue();

                Parent parent = new Parent(parentID, parentName, grades, childName, lastPaidDate, lastPaidMoney, totalOwed, remaining,remainingOldFees);
                if (parents.isEmpty() || !parents.contains(parent)) {
                    parents.add(parent);
                } else {
                    int index = parents.indexOf(parent);

                    if (lastPaidDate.compareTo(parents.get(index).getLastPaidDate()) == 0) {
                        parents.get(index).setLastPaidMoney(parents.get(index).getLastPaidMoney() + lastPaidMoney);
                    } else if (lastPaidDate.compareTo(parents.get(index).getLastPaidDate()) > 0) {
                        parents.get(index).setLastPaidDate(lastPaidDate);
                        parents.get(index).setLastPaidMoney(lastPaidMoney);
                    }
                    parents.get(index).increaseNumberOfChildrenByOne();
                    parents.get(index).setChildrensNames(parents.get(index).getChildrensNames() + ", " + childName);
                    parents.get(index).setGrades(parents.get(index).getGrades() + ", " + grades);
                    parents.get(index).setTotalOwed(parents.get(index).getTotalOwed() + totalOwed);
                    parents.get(index).setRemaining(parents.get(index).getRemaining() + remaining);
                    parents.get(index).setTotalPaied(parents.get(index).getTotalPaied()+ parent.getTotalPaied());

                }

            }
            System.out.println(parents.size());

            file.close();
        

        return parents;
    }

}
