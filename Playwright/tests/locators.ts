import type { Locator, Page } from "@playwright/test";

export async function resolveWithFallback(
  page: Page,
  description: string,
  candidates: Locator[],
): Promise<Locator> {
  for (const [index, locator] of candidates.entries()) {
    const count = await locator.count();
    if (count > 1) {
      throw new Error(`Ambiguous locator for ${description}: found ${count} elements`);
    }
    if (count === 1) {
      if (index > 0) {
        console.warn(`Primary locator failed for ${description}; using fallback ${index + 1}`);
      }
      return locator;
    }
  }

  throw new Error(`No locator matched for ${description}`);
}
