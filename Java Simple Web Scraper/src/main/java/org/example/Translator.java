package org.example;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

public class Translator {
        public static String translateText(String input, String targetLanguage) {
                Translate translate = TranslateOptions.getDefaultInstance().getService();
                Translation translation = translate.translate(input, Translate.TranslateOption.targetLanguage(targetLanguage));
                return translation.getTranslatedText();
        }
}
