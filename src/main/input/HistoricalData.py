import yfinance as yf
import datetime

def get_historical_price(ticker_symbol: str, timeframe: str = "1wk"):
    ticker = yf.Ticker(ticker_symbol)

    # Mapping timeframes to yfinance period values
    period_map = {
        "1wk": "7d",
        "1mo": "1mo",
        "1y": "1y"
    }

    # Fallback to '7d' if unknown timeframe
    period = period_map.get(timeframe, "7d")

    # Get historical data
    hist = ticker.history(period=period)

    if hist.empty:
        return None  # Return None if data isn't available

    # Grab the first close price in the period
    price = hist["Close"].iloc[0]
    return round(price, 2)


def get_price_on_date(ticker_symbol: str, date: str):
    ticker = yf.Ticker(ticker_symbol)

    # Convert date string to datetime and add +1 day for range
    date_obj = datetime.datetime.strptime(date, "%Y-%m-%d")
    next_day = date_obj + datetime.timedelta(days=1)

    # Get history for just that day
    hist = ticker.history(start=date, end=next_day.strftime("%Y-%m-%d"))

    if hist.empty:
        return f"No trading data for {date} (weekend/holiday?)"

    price = hist["Close"].iloc[0]
    return round(price, 2)