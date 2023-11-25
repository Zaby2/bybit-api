# bybit-api

During this projects our team need to create a wrapper around standard ByBit api https://bybit-exchange.github.io/docs/v5/intro

For now we created a ByBit Socket that takes responses from PUBLIC ByBit information, but there r some difficulties /w private account info.
So for now, by using this socket u can only get tickers that r public.

TODO
1. Need to refactor code and make it look like wrapper
2. Add annotations that will control what type of market we would like to see
3. Create parser that will parse the response and add to file or smth
4. Private information need to be supported
   
