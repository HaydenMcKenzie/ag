import webscrapper.commodityPrice._

object Main extends App {
    println(commodityPriceScanner("https://www.tradingview.com/symbols/CME-LE1!/", "div.details-i4FV5Ith", "3"))
    println(commodityPriceScanner("https://www.tradingview.com/symbols/CME-GF1!/", "div.details-i4FV5Ith", "3"))
    println(commodityPriceScanner("https://www.tradingview.com/symbols/CBOT-ZW1!/", "div.details-i4FV5Ith", "'"))
    println(commodityPriceScanner("https://www.tradingview.com/symbols/CBOT-ZC1!/", "div.details-i4FV5Ith", "'"))
    println(commodityPriceScanner("https://www.tradingview.com/symbols/ICEUS-SB1!/", "div.details-i4FV5Ith", "2"))



}