# API smoke test — C# and NUnit

One end-to-end HTTP smoke test calls the public `https://http.cat/100` endpoint
and checks its HTTP response and image payload. It uses `HttpClient` directly
and disposes the client and response after the test.

## Prerequisites and run

- .NET 10 SDK
- Network access to `http.cat`

From this folder:

```powershell
dotnet test
```

Treat this as a connectivity and contract smoke test, not a substitute for
testing an API you control. The public endpoint and network may be unavailable.
