from input.InputHandling import *
from input.HistoricalData import *

tickerInput = input("Enter ticker:")
# p = TickerInfo(tickerInput, inputToTicker(tickerInput), inputToPrice(inputToTicker(tickerInput)), inputToYesterdayPrice(inputToTicker(tickerInput)))
# print(p.name)
# print(p.ticker)
# print(p.current)
# print(p.yesterday)


print(get_historical_price(inputToTicker(tickerInput), "1wk"))
print(get_historical_price(inputToTicker(tickerInput), "1mo"))
print(get_historical_price(inputToTicker(tickerInput), "1y"))
print(get_price_on_date(inputToTicker(tickerInput), "2025-04-01"))