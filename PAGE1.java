import java.util.ArrayList;
import org.openqa.selenium.*;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Cookie;


public class PAGE1 {

   	public static void main(String... krishna) {
    
    WebDriver pointer=new ChromeDriver();
    pointer.get("http://10.0.1.86/tatoc");
    pointer.findElement(By.linkText("Basic Course")).click();
    pointer.findElement(By.className("greenbox")).click();
    pointer.switchTo().frame(pointer.findElement(By.id("main")));
    String Colorbox1 = pointer.findElement(By.id("answer")).getAttribute("class");
    pointer.switchTo().frame(pointer.findElement(By.id("child")));
    String Colorbox2 = pointer.findElement(By.id("answer")).getAttribute("class");
    pointer.switchTo().defaultContent();
    
    while(Colorbox1.equals(Colorbox2)!=true) {
    	pointer.switchTo().frame(pointer.findElement(By.id("main")));
    	pointer.findElement(By.linkText("Repaint Box 2")).click();
    	pointer.switchTo().frame(pointer.findElement(By.id("child")));
    	Colorbox2 = pointer.findElement(By.id("answer")).getAttribute("class");
    	pointer.switchTo().defaultContent();
    	
    }
    pointer.switchTo().defaultContent();
    pointer.switchTo().frame(pointer.findElement(By.id("main")));
    pointer.findElement(By.linkText("Proceed")).click();
    
    
    
    WebElement dragfrom = pointer.findElement(By.id("dragbox"));
    WebElement To =pointer.findElement(By.id("dropbox"));
    Actions act=new Actions(pointer);	
    act.dragAndDrop(dragfrom, To).build().perform();
    pointer.findElement(By.linkText("Proceed")).click();
    
    
    pointer.findElement(By.linkText("Launch Popup Window")).click();
    ArrayList windowlist = new ArrayList(pointer.getWindowHandles());
    String window1=((String)windowlist.get(1));
    pointer.switchTo().window(window1);
    pointer.findElement(By.id("name")).sendKeys("KrishnaChauhan");
    pointer.findElement(By.id("submit")).click();
    String window2=((String)windowlist.get(0));
    pointer.switchTo().window(window2);
    pointer.findElement(By.linkText("Proceed")).click();
    
    
    pointer.findElement(By.linkText("Generate Token")).click();
    String token = pointer.findElement(By.id("token")).getText();
    String tokenid= token.substring(7, token.length());
    Cookie cookie = new Cookie("Token",tokenid);
    pointer.manage().addCookie(cookie);
    pointer.findElement(By.linkText("Proceed")).click();
    
    
    
    
}
}
