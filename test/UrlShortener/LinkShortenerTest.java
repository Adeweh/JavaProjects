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
        String shortURL = converter.getShortURL("https://stackoverflow.com/questions/28920705/intellij-doesnt-work-correctly-with-cloning-project-from-github");

        assertEquals("https://stackoverflow.com/questions/28920705/intellij-doesnt-work-correctly-with-cloning-project-from-github", converter.getUrl(shortURL));

    }
    @Test
    void testThatKeysCanBeConverted(){
        converter.addURL(234,"https://stackoverflow.com/questions/28920705/intellij-doesnt-work-correctly-with-cloning-project-from-github");

        assertEquals("dW", converter.getConvertedKey(234));

    }
    @Test
    void testThatConvertedKeysCanGenerateShortLinks(){
        String shortURL = converter.getShortURL("https://stackoverflow.com/questions/28920705/intellij-doesnt-work-correctly-with-cloning-project-from-github");
        int key = converter.getKey(shortURL);
        String convertedKey = converter.getConvertedKey(key);
        assertEquals("https://newURL.com/" + convertedKey, shortURL);
    }

    @Test
    void testThatOriginURLCanBeRetrieved(){
        converter.addURL(234,"https://stackoverflow.com/questions/28920705/intellij-doesnt-work-correctly-with-cloning-project-from-github");
        String convertedKey = converter.getConvertedKey(234);

        assertEquals(234, converter.getKey(convertedKey));

    }


}