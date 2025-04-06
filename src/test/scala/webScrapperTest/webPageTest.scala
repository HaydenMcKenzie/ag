package scala.webScrapperTest

import webscrapper.commodityPrice._
import org.scalatest.funsuite.AnyFunSuite

class webPageTest extends AnyFunSuite {

  test("Returning correct 3 decimal price") {
    val result = commodityPriceScanner(
      "https://www.tradingview.com/symbols/CME-LE1!/",
      "div.details-i4FV5Ith",
      "3"
    )

    assert(result.matches(commodityPriceScanner("https://www.tradingview.com/symbols/CME-LE1!/", "div.details-i4FV5Ith", "3")), result)
  }

  test("Returning correct ' price") {
    val result = commodityPriceScanner(
      "https://www.tradingview.com/symbols/CBOT-ZW1!/",
      "div.details-i4FV5Ith",
      "'"
    )

    assert(result.matches(commodityPriceScanner("https://www.tradingview.com/symbols/CBOT-ZW1!/", "div.details-i4FV5Ith", "'")), result)
  }

  test("Returning correct 2 decimal price") {
    val result = commodityPriceScanner(
      "https://www.tradingview.com/symbols/ICEUS-SB1!/",
      "div.details-i4FV5Ith",
      "2"
    )

    assert(result.matches(commodityPriceScanner("https://www.tradingview.com/symbols/ICEUS-SB1!/", "div.details-i4FV5Ith", "2")), result)
  }
}
