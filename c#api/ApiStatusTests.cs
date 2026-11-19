using System.Net;
using NUnit.Framework;

namespace ApiTests;

public sealed class ApiStatusTests
{
    [Test]
    public async Task HttpCat100_ReturnsAnImage()
    {
        using var client = new HttpClient { Timeout = TimeSpan.FromSeconds(30) };
        using var response = await client.GetAsync("https://http.cat/100");

        Assert.That(response.StatusCode, Is.EqualTo(HttpStatusCode.OK));
        Assert.That(response.Content.Headers.ContentType?.MediaType, Does.StartWith("image/"));

        var image = await response.Content.ReadAsByteArrayAsync();
        Assert.That(image, Is.Not.Empty);
    }
}
