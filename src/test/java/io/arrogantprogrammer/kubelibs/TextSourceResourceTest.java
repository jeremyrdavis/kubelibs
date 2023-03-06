package io.arrogantprogrammer.kubelibs;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.arrogantprogrammer.kubelibs.domain.TextSourceService;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import java.net.MalformedURLException;
import java.net.URL;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@QuarkusTest
public class TextSourceResourceTest {

    static ObjectMapper objectMapper;

    @Inject
    TextSourceService textSourceService;

    static String text = """
        My dear Watson, you know how bored I have been since we locked up Colonel Carruthers. My mind is like a racing engine, tearing itself to pieces because it is not connected up with the work for which it was built. Life is commonplace, the papers are sterile; audacity and romance seem to have passed forever from the criminal world. Can you ask me, then, whether I am ready to look into any new problem, however trivial it may prove? But here, unless I am mistaken, is our client.”
        A measured step was heard upon the stairs, and a moment later a stout, tall, grey-whiskered and solemnly respectable person was ushered into the room. His life history was written in his heavy features and pompous manner. From his spats to his gold-rimmed spectacles he was a Conservative, a churchman, a good citizen, orthodox and conventional to the last degree. But some amazing experience had disturbed his native composure and left its traces in his bristling hair, his flushed, angry cheeks, and his flurried, excited manner. He plunged instantly into his business.
        """;

    static String author = "Sir Arthur Conan Doyle";

    static URL url;
    @Test
    public void testAddingTextSource() {

        TextSourceDTO textSource = new TextSourceDTO(null, text, author, url);

        assertEquals(text, textSource.text());
        assertEquals(author, textSource.author());
        assertEquals(url, textSource.url());

        with().header("Content-Type", MediaType.APPLICATION_JSON).body(textSource).when().post("/textsource").then().statusCode(201);

        assertEquals(1, textSourceService.allSources().size());
    }

    @BeforeAll
    static void setUp() {
        try {
            url =  new URL("https://www.gutenberg.org/files/2350/2350-h/2350-h.htm");
        } catch (MalformedURLException e) {
            assertNull(e);
        }

    }
}
