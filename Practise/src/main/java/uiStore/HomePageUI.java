package uiStore;

import org.openqa.selenium.By;

public class HomePageUI {
	public By searchicon=By.xpath("//*[@id=\"togglesearch\"]");
	public By searchbox = By.xpath("//*[@id=\"srch\"]");
	public By searchButton = By.xpath("//*[@id=\"submit_search\"]");
	public By close=By.xpath("//*[@id=\"popupmsgID\"]/tbody/tr/td[1]/a");
	public By aboutus=By.xpath("//*[@id=\"navcss\"]/li[2]/a");
	public By corporte=By.xpath("//a[@target='_self'][contains(text(),'Corporate Mission')]");

}
