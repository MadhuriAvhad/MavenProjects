package testData;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Login_Details {
	
	public String userCorrectEmail;
	public String userCorrectPassword;
	public String userIncorrectEmail;
	public String userIncorrectPassword;
	public String userName;
	public String userMobileNum;
	public String userNewPassword;
	
	public void fetching_Login_Details() throws EncryptedDocumentException, IOException
	{
		FileInputStream excelPath = new FileInputStream("C:\\Users\\MADHURI AVHAD\\eclipse-workspace\\SeleniumByMKT\\testData\\dataFile.xlsx");
		Workbook openExcel = WorkbookFactory.create(excelPath);
		userCorrectEmail = openExcel.getSheet("firstSheet").getRow(1).getCell(5).getStringCellValue();
		userCorrectPassword = openExcel.getSheet("firstSheet").getRow(1).getCell(3).getStringCellValue();
	}
	
	public void fecting_incorrect_email() throws EncryptedDocumentException, IOException
	{
		userIncorrectEmail = "madhurichetan@gmail.com";
	}
	
	public void fetching_incorrect_password() throws EncryptedDocumentException, IOException
	{
		userIncorrectPassword ="chetanMadhuri";
	}
	
	public void fetching_registration_details()
	{
		userName = "Madhuri Chetan";
		userMobileNum = "1234567890";
		userNewPassword = "madhurichetan";
	}

}
