package com.example.BTL.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GenerateExcelReport {

	public static ByteArrayInputStream usersToExcel(List<TTNCNDTO> list) {
		final String[] COLUMs = { "ID", "Tên", "Ma sô thuê", "Đối tượng thu thuế", "Ngày sinh", "Địa chỉ",
				"Tổng thu nhập", "Thu nhập tính thuế", "Thuế thu nhập cá nhân" };
		try {
			Workbook workbook = new XSSFWorkbook();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			Sheet sheet = workbook.createSheet("TTNCN");

			Font headerFont = workbook.createFont();
			headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
			headerFont.setColor(IndexedColors.BLUE.getIndex());

			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);

			Row headerRow = sheet.createRow(0);

			for (int col = 0; col < COLUMs.length; col++) {
				Cell headerCell = headerRow.createCell(col);
				headerCell.setCellValue(COLUMs[col]);
				headerCell.setCellStyle(headerCellStyle);
			}

			int rowIdx = 1;

			for (TTNCNDTO t : list) {
				Row row = sheet.createRow(rowIdx++);
				row.createCell(0).setCellValue(t.getId());
				row.createCell(1).setCellValue(t.getName());
				row.createCell(2).setCellValue(t.getMathue().getMaST());
				row.createCell(3).setCellValue(t.getTaxerDTO().getName());
				row.createCell(4).setCellValue(t.getBirdth());
				row.createCell(5).setCellValue(t.getAddress());
				row.createCell(6).setCellValue(t.getTongthunhap());
				row.createCell(7).setCellValue(t.getThunhaptinhthue());
				row.createCell(8).setCellValue(t.getThuetncn());
			}

			sheet.autoSizeColumn(0);
			sheet.autoSizeColumn(1);
			sheet.autoSizeColumn(2);
			sheet.autoSizeColumn(3);
			sheet.autoSizeColumn(4);
			sheet.autoSizeColumn(5);
			sheet.autoSizeColumn(6);
			sheet.autoSizeColumn(7);
			sheet.autoSizeColumn(8);

			workbook.write(out);

			return new ByteArrayInputStream(out.toByteArray());

		} catch (Exception e) {
			System.out.print("generateExcellReport: " + e);
		}
		return new ByteArrayInputStream(null);
	}
}
