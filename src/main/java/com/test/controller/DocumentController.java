package com.test.controller;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.pdf.PdfWriter;
import com.test.config.JwtTokenUtil;
import com.test.model.BasicResponse;
import com.test.model.DocumentGenerateRequest;
import com.test.model.JwtResponse;
import com.test.model.LoginRequest;
import com.test.model.TokenValidationRequest;
import com.test.service.JwtUserDetailsService;

@RestController
@CrossOrigin
public class DocumentController {

	@RequestMapping(value = "/generatedoc", method = RequestMethod.POST)
	public ResponseEntity<?> generateDoc(@RequestBody DocumentGenerateRequest request) throws Exception {
		
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("pdfdoc.pdf"));

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);

        List list = new List(false);
        list.add(new ListItem("First Name : " + request.getFirstname()));
        list.add(new ListItem("Last Name : " + request.getLastname()));
        list.add(new ListItem("Date of Birth : " + request.getDateofbirth()));
        list.add(new ListItem("Gender : " + request.getGender()));
        list.add(new ListItem("Email : " + request.getEmail()));
        list.add(new ListItem("Mobile no : " + request.getMobileno()));
        list.add(new ListItem("Address : " + request.getAddress()));
        list.add(new ListItem("City : " + request.getCity()));
        list.add(new ListItem("State : " + request.getState()));
        list.add(new ListItem("Country : " + request.getCountry()));
        list.add(new ListItem("Pin : " + request.getPin()));
        document.add(list);
        document.close();

        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("User");
        sheet.setDefaultColumnWidth(60);
        sheet.autoSizeColumn(0);
        sheet.setDefaultColumnWidth(60);
        sheet.autoSizeColumn(1);
        sheet.setDefaultColumnWidth(60);
        sheet.autoSizeColumn(2);
        sheet.setDefaultColumnWidth(60);
        sheet.autoSizeColumn(3);
        sheet.setDefaultColumnWidth(60);
        sheet.autoSizeColumn(4);
        sheet.setDefaultColumnWidth(60);
        sheet.autoSizeColumn(5);
        sheet.setDefaultColumnWidth(60);
        sheet.autoSizeColumn(6);
        sheet.setDefaultColumnWidth(60);
        sheet.autoSizeColumn(7);
        sheet.setDefaultColumnWidth(60);
        sheet.autoSizeColumn(8);
        sheet.setDefaultColumnWidth(60);
        sheet.autoSizeColumn(9);
        sheet.setDefaultColumnWidth(60);
        sheet.autoSizeColumn(10);

        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont xlsfont = ((XSSFWorkbook) workbook).createFont();
        xlsfont.setFontName("Arial");
        xlsfont.setFontHeightInPoints((short) 16);
        xlsfont.setBold(true);
        style.setFont(xlsfont);

        Row rowFirstname = sheet.createRow(0);
        Row rowLastname = sheet.createRow(1);
        Row rowDateofbirth = sheet.createRow(2);
        Row rowGender = sheet.createRow(3);
        Row rowEmail = sheet.createRow(4);
        Row rowMobileno = sheet.createRow(5);
        Row rowAddress = sheet.createRow(6);
        Row rowCity = sheet.createRow(7);
        Row rowState = sheet.createRow(8);
        Row rowCountry = sheet.createRow(9);
        Row rowPin = sheet.createRow(10);
        

        Cell cellFirstname = rowFirstname.createCell(0);
        cellFirstname.setCellValue("Firstname");
        cellFirstname.setCellStyle(style);
        Cell cellFirstnameVal = rowFirstname.createCell(1);
        cellFirstnameVal.setCellValue(request.getFirstname());
        cellFirstnameVal.setCellStyle(style);

        Cell cellLastname = rowLastname.createCell(0);
        cellLastname.setCellValue("Lastname");
        cellLastname.setCellStyle(style);
        Cell cellLastnameVal = rowLastname.createCell(1);
        cellLastnameVal.setCellValue(request.getLastname());
        cellLastnameVal.setCellStyle(style);

        Cell cellDateofbirth = rowDateofbirth.createCell(0);
        cellDateofbirth.setCellValue("Dateofbirth");
        cellDateofbirth.setCellStyle(style);
        Cell cellDateofbirthVal = rowDateofbirth.createCell(1);
        cellDateofbirthVal.setCellValue(request.getDateofbirth());
        cellDateofbirthVal.setCellStyle(style);

        Cell cellGender = rowGender.createCell(0);
        cellGender.setCellValue("Gender");
        cellGender.setCellStyle(style);
        Cell cellGenderVal = rowGender.createCell(1);
        cellGenderVal.setCellValue(request.getGender());
        cellGenderVal.setCellStyle(style);

        Cell cellEmail = rowEmail.createCell(0);
        cellEmail.setCellValue("Email");
        cellEmail.setCellStyle(style);
        Cell cellEmailVal = rowEmail.createCell(1);
        cellEmailVal.setCellValue(request.getEmail());
        cellEmailVal.setCellStyle(style);

        Cell cellMobileno = rowMobileno.createCell(0);
        cellMobileno.setCellValue("Mobileno");
        cellMobileno.setCellStyle(style);
        Cell cellMobilenoVal = rowMobileno.createCell(1);
        cellMobilenoVal.setCellValue(request.getMobileno());
        cellMobilenoVal.setCellStyle(style);

        Cell cellAddress = rowAddress.createCell(0);
        cellAddress.setCellValue("Address");
        cellAddress.setCellStyle(style);
        Cell cellAddressVal = rowAddress.createCell(1);
        cellAddressVal.setCellValue(request.getAddress());
        cellAddressVal.setCellStyle(style);

        Cell cellCity = rowCity.createCell(0);
        cellCity.setCellValue("City");
        cellCity.setCellStyle(style);
        Cell cellCityVal = rowCity.createCell(1);
        cellCityVal.setCellValue(request.getCity());
        cellCityVal.setCellStyle(style);

        Cell cellState = rowState.createCell(0);
        cellState.setCellValue("State");
        cellState.setCellStyle(style);
        Cell cellStateVal = rowState.createCell(1);
        cellStateVal.setCellValue(request.getState());
        cellStateVal.setCellStyle(style);

        Cell cellCountry = rowCountry.createCell(0);
        cellCountry.setCellValue("Country");
        cellCountry.setCellStyle(style);
        Cell cellCountryVal = rowCountry.createCell(1);
        cellCountryVal.setCellValue(request.getCountry());
        cellCountryVal.setCellStyle(style);

        Cell cellPin = rowPin.createCell(0);
        cellPin.setCellValue("Pin");
        cellPin.setCellStyle(style);
        Cell cellPinVal = rowPin.createCell(1);
        cellPinVal.setCellValue(request.getPin());
        cellPinVal.setCellStyle(style);

        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        String fileLocation = path.substring(0, path.length() - 1) + "exceldoc.xlsx";

        FileOutputStream outputStream = new FileOutputStream(fileLocation);
        workbook.write(outputStream);
        workbook.close();

		return ResponseEntity.ok(new BasicResponse(true, "Documents successfully generated"));
	}
}