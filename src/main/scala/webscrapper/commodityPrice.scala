package scala.webscrapper
import org.jsoup.Jsoup

object commodityPrice {
  def commodityPriceScanner(url: String, css: String, dec: String): String = {
    // Fetch and parse the HTML
    val doc = Jsoup.connect(url).get()

    // Select all html and turn it into text
    val value = doc.select(css).text()

    // Depending on input returns the commodities price.
    if (dec == "3") {
      // Returns commodities with 3 decimals
      val price = value.split(" ").find(_.matches("\\d+\\.\\d{3}")).getOrElse("Price not found")
      price
    } else if (dec == "'") {
      // Extract value like 529'0 using regex, converts to a decimal (e.g., 529'0 → 5.290)
      // rawPrice finds price
      // parts removes the ' from the price
      // decimalPrice turns parts into a 3 decimal digit
      val rawPrice = value.split(" ").find(_.matches("\\d+'\\d")).getOrElse("0'0")
      val parts = rawPrice.split("'")
      val decimalPrice = f"${parts(0).toInt / 100.0 + parts(1).toInt / 1000.0}%.3f"

      decimalPrice
    } else {
      // Returns commodities with 2 decimals
      val price = value.split(" ").find(_.matches("\\d+\\.\\d{2}")).getOrElse("Price not found")
      price
    }}
}
