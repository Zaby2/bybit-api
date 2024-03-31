# ByBit API Wrapper

The **bybit-api** project aims to provide a convenient wrapper around the standard ByBit API, accessible at [ByBit API Documentation](https://bybit-exchange.github.io/docs/v5/intro).

At its current stage, the project offers a ByBit Socket module that retrieves responses from the public ByBit information. However, integrating private account information poses some challenges, and as a result, the socket currently only supports fetching public tickers.

## TODO
1. Refactor the codebase to adopt a cleaner and more organized structure, resembling a proper wrapper.
2. Implement annotations to control the types of markets users wish to access.
3. Develop a parser to effectively parse the API responses and store them in a file or another suitable format.
4. Enhance the functionality to support retrieval and handling of private account information.

These improvements will make the ByBit API wrapper more versatile and user-friendly, facilitating seamless integration with various applications and trading strategies.

Contributions and feedback are highly encouraged as we work towards enhancing the capabilities and usability of the ByBit API wrapper.

Happy coding! 🚀
