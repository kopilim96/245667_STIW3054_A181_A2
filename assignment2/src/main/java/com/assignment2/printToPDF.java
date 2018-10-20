package com.assignment2;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.FontSelector;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class printToPDF {

    public void printPdf(){
        readExcel read = new readExcel();
        try{
            Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document,
                    new FileOutputStream("studentList.pdf"));
            document.open();


            int a = 0;
            for(first first1: read.readFirstData()) {
                FontSelector selector = new FontSelector();
                Font f1 = FontFactory.getFont(FontFactory.TIMES_ITALIC,11);
                f1.setColor(BaseColor.BLUE);
                String text = read.firstList.get(a).getFirstWord();
                selector.addFont(f1);
                Phrase phrase = selector.process(text);
                document.add(new Paragraph(phrase));
                a++;
            }


            //Table
            PdfPTable table = new PdfPTable(6);// 6 column
            table.setWidthPercentage(100);
            table.setSpacingAfter(10f);
            table.setSpacingBefore(10f);

            float[] columnWidth = {2f, 15f, 4f, 4f, 5f, 12f};
            table.setWidths(columnWidth);
            PdfPCell c1 = new PdfPCell(new Paragraph("No."));
            PdfPCell c2 = new PdfPCell(new Paragraph("Name"));
            PdfPCell c3 = new PdfPCell(new Paragraph("FideID"));
            PdfPCell c4 = new PdfPCell(new Paragraph("FED"));
            PdfPCell c5 = new PdfPCell(new Paragraph("RTG"));
            PdfPCell c6 = new PdfPCell(new Paragraph("Club/City"));

            table.addCell(c1);
            table.addCell(c2);
            table.addCell(c3);
            table.addCell(c4);
            table.addCell(c5);
            table.addCell(c6);

            int b = 0;
            for(student student1: read.readStudent()){
                PdfPCell data1 = new PdfPCell(new Paragraph(String.valueOf(read.Studentlist.get(b).getNum())));
                PdfPCell data2 = new PdfPCell(new Paragraph(read.Studentlist.get(b).getName()));
                PdfPCell data3 = new PdfPCell(new Paragraph(String.valueOf(read.Studentlist.get(b).getFieldId())));
                PdfPCell data4 = new PdfPCell(new Paragraph(String.valueOf(read.Studentlist.get(b).getFed())));
                PdfPCell data5 = new PdfPCell(new Paragraph(String.valueOf(read.Studentlist.get(b).getRtg())));
                PdfPCell data6 = new PdfPCell(new Paragraph(String.valueOf(read.Studentlist.get(b).getClub())));

                table.addCell(data1);
                table.addCell(data2);
                table.addCell(data3);
                table.addCell(data4);
                table.addCell(data5);
                table.addCell(data6);

                /*
                document.add(new Paragraph(String.valueOf(read.Studentlist.get(b).getNum())));
                document.add(new Paragraph(read.Studentlist.get(b).getName()));
                document.add(new Paragraph(String.valueOf(read.Studentlist.get(b).getFieldId())));
                document.add(new Paragraph(read.Studentlist.get(b).getFed()));
                document.add(new Paragraph(String.valueOf(read.Studentlist.get(b).getRtg())));
                document.add(new Paragraph(read.Studentlist.get(b).getClub()));
                */
                b++;
            }
            document.add(table);


            int c = 0;
            for(last last1: read.readLastExcel()){
                String text1 = read.lastList.get(c).getLastWord();
                FontSelector selector1 = new FontSelector();
                Font f2 = FontFactory.getFont(FontFactory.COURIER_BOLD,9);
                f2.setColor(BaseColor.MAGENTA);
                selector1.addFont(f2);
                Phrase phrase2 = selector1.process(text1);
                document.add(new Paragraph(phrase2));
                c++;
            }

            document.close();
            writer.close();

        }catch(DocumentException e){
            e.getStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }//End of OpenPDF


}
