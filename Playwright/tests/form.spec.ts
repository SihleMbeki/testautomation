import { resolve } from "node:path";
import { pathToFileURL } from "node:url";
import { expect, test } from "@playwright/test";
import { resolveWithFallback } from "./locators";

const formUrl = pathToFileURL(resolve(__dirname, "../../html/index.html")).href;

const formCases = [
  { name: "Alex Example", age: "Yes", interest: "games", notRobot: true },
  { name: "Jordan Example", age: "No", interest: "sport", notRobot: false },
  { name: "Taylor Example", age: "Yes", interest: "movie", notRobot: true },
];

test.describe("User form", () => {
  for (const formCase of formCases) {
    test(`submits ${formCase.name} to a new tab`, async ({ page }) => {
      await page.goto(formUrl);
      const nameInput = await resolveWithFallback(page, "name input", [
        page.getByLabel("Name:"),
        page.locator("#name"),
      ]);
      await nameInput.fill(formCase.name);
      await page.getByLabel(formCase.age, { exact: true }).check();
      await page.getByLabel("Interest:").selectOption(formCase.interest);
      if (formCase.notRobot) {
        await page.getByLabel("Not a robot").check();
      }

      const resultsPagePromise = page.context().waitForEvent("page");
      await page.getByRole("button", { name: "Submit" }).click();
      const resultsPage = await resultsPagePromise;
      await resultsPage.waitForLoadState("domcontentloaded");

      const resultsUrl = new URL(resultsPage.url());
      expect(resultsUrl.pathname).toMatch(/page2\.html$/);
      expect(resultsUrl.searchParams.get("name")).toBe(formCase.name);
      expect(resultsUrl.searchParams.get("above18")).toBe(formCase.age);
      expect(resultsUrl.searchParams.get("interest")).toBe(formCase.interest);
      expect(resultsUrl.searchParams.get("notRobot")).toBe(formCase.notRobot ? "Yes" : null);
      await expect(resultsPage.locator("#results")).toContainText(formCase.name);
      await expect(resultsPage.locator("#results")).toContainText(formCase.interest);
      await resultsPage.close();
    });
  }

  test("alerts and stays on the form when age is not selected", async ({ page }) => {
    await page.goto(formUrl);
    const dialogPromise = page.waitForEvent("dialog").then(async (dialog) => {
      expect(dialog.type()).toBe("alert");
      expect(dialog.message()).toBe("Please select Yes or No for the above 18 question.");
      await dialog.accept();
    });
    await page.getByRole("button", { name: "Submit" }).click();
    await dialogPromise;
    await expect(page).toHaveURL(/index\.html$/);
  });
});
