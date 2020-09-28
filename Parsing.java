import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parsing {
    public static void main(String[] args) throws Exception {
        Document document = Jsoup.connect("https://www.winelab.ru/").get();
        Elements elements = document.getElementsByAttributeValue("class", "product_card js-product-click");
        for (Element element : elements)
        {
            Element firstTag = element.select("a").first();
            String linkHref = "https://winelab.ru/" + firstTag.attr("href");
            Document landing = Jsoup.connect(linkHref).get();
            Elements description = landing.getElementsByAttributeValue("class", "description");
            Elements filters = landing.getElementsByAttributeValue("class", "filters");
            Elements prices = landing.getElementsByAttributeValue("class", "prices_main");
            System.out.println(description);
            System.out.println(filters);
            System.out.println(prices);
        }
    }

}
