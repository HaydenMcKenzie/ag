import yfinance as yf

def inputToPrice(x):
    ticker = yf.Ticker(x)
    hist = ticker.history(period="5d")
    today_price = hist["Close"].iloc[-1]
    price = round(today_price, 2)
    return price

def inputToYesterdayPrice(x):
    ticker = yf.Ticker(x)
    hist = ticker.history(period="5d")
    today_price = hist["Close"].iloc[-2]
    price = round(today_price, 2)
    return price

def inputToTicker(x):
    z = x.lower()
    match z:
        case "corn":
            return "ZC=F"
        case "wheat":
            return "ZW=F"

class TickerInfo:
    def __init__(self, name, ticker, current, yesterday):
        self.name = name
        self.ticker = ticker
        self.current = current
        self.yesterday = yesterday
