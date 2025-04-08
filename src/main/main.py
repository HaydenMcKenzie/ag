from input.InputHandling import *

tickerInput = input("Enter ticker:")
print(f"{tickerInput}'s close:", inputToPrice(inputToTicker(tickerInput)))
print(f"{tickerInput}'s yesterday close:", inputToYesterdayPrice(inputToTicker(tickerInput)))
