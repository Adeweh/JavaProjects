package UrlShortener;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkShortenerTest {
    LinkShortener converter;

    @BeforeEach
    void setUp() {
        converter = new LinkShortener();
    }
    @Test
    void testThatWeCanEnterLongURLAndSave(){
        converter.addURL(0, "https://www.webfx.com/digital-marketing/learn/long-domain-name-vs-short/");
        converter.addURL(1,"https://stackoverflow.com/questions/28920705/intellij-doesnt-work-correctly-with-cloning-project-from-github");
        assertEquals(2, converter.size());
    }

    @Test
    void  testThatSavedURLCanBeGotten(){
        converter.addURL(0, "https://www.webfx.com/digital-marketing/learn/long-domain-name-vs-short/");
        converter.addURL(1,"https://stackoverflow.com/questions/28920705/intellij-doesnt-work-correctly-with-cloning-project-from-github");

        assertEquals("https://stackoverflow.com/questions/28920705/intellij-doesnt-work-correctly-with-cloning-project-from-github", converter.getUrl(1));

    }
    @Test
    void testThatKeysCanBeConverted(){
        converter.addURL(234,"https://stackoverflow.com/questions/28920705/intellij-doesnt-work-correctly-with-cloning-project-from-github");

        assertEquals("dW", converter.getConvertedKey(234));

    }
    @Test
    void testThatConvertedKeysCanGenerateShortLinks(){
        converter.addURL(1,"https://stackoverflow.com/questions/28920705/intellij-doesnt-work-correctly-with-cloning-project-from-github");
        assertEquals("https://newURL.com/dW", converter.getShortURL("dW"));
    }

    @Test
    void testThatOriginURLCanBeRetrieved(){
        converter.addURL(234,"https://stackoverflow.com/questions/28920705/intellij-doesnt-work-correctly-with-cloning-project-from-github");
        String convertedKey = converter.getConvertedKey(234);

        assertEquals(234, converter.getKey(convertedKey));

    }


}