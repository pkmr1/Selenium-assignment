import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import com.sun.java.util.jar.pack.Package.File;

public class assignment_top_1 {
	
	public static void main(String[] args) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		 
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		
		//launch the URL
		
		driver.get("http://10.207.182.108:81/opencart/");
		
		//Click here to Launch
		
		 driver.findElement(By.xpath("//a[@href=\"http://spezicoe.wipro.com:81/opencart1/\"]")).click();
		 
		 //Click on MyAccount icon
		 Thread.sleep(5000);
		 ArrayList<String>windowHandles=new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(windowHandles.get(1));
		 driver.findElement(By.xpath("//span[@class='caret']")).click();
		 
		 //Click on Login
		  Thread.sleep(5000);
		 driver.findElement(By.xpath("//a[text()=\"Login\"]")).click();
		 
		 //Enter email-address and password by reading the data from excel
		
		 File src=new File("Book1.xlsx");
		 
		 FileInputStream fis = new FileInputStream(src);
		 
		 XSSFWorkbook wb=new XSSFWorkbook(fis);
		 
		 XSSFSheet s1=wb.getSheetAt(0);
		/* Row row=s1.getRow(0);
		Cell cell=row.getCell(0);
		 String cell1=cell.toString();
		 System.out.println(cell1);
		 System.out.println(s1.getRow(0).getCell(0));*/
	String	data=s1.getRow(0).getCell(0).getStringCellValue();
	String data1=s1.getRow(1).getCell(0).getStringCellValue();
		 driver.findElement(By.xpath("//input[@id=\"input-email\"]")).sendKeys(data);
		driver.findElement(By.xpath("//input[@id=\"input-password\"]")).sendKeys(data1);
		 Thread.sleep(5000);
		 //close the tab
		 
		 driver.close();
		
		 ArrayList<String>windowHandles1=new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(windowHandles1.get(0));
		 driver.close();
		 
	}

	
}
