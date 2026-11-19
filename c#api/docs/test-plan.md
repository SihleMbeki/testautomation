# API test plan

## Objective

Quickly check that the public HTTP Cats status endpoint responds with its image.

## Scenario

| ID | Priority | Given | When | Then |
|---|---|---|---|---|
| API-001 | High | The public endpoint is reachable | Send `GET https://http.cat/100` | Receive HTTP 200, an `image/*` content type, and a non-empty body |

## Risks and boundaries

- Public service outages, rate limits, DNS, TLS, or local network restrictions can
  fail the test independently of this code.
- The endpoint is not a controlled mock and this single test does not cover API
  error contracts, authentication, or application-specific behavior.
