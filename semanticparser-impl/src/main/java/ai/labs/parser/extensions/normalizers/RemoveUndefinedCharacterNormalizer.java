package ai.labs.parser.extensions.normalizers;

import ai.labs.utilities.CharacterUtilities;

public class RemoveUndefinedCharacterNormalizer implements INormalizer {
    private static final String DEFAULT_ALLOWED_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz 1234567890!?:;.,";

    @Override
    public String normalize(String input) {
        return CharacterUtilities.deleteUndefinedChars(input, DEFAULT_ALLOWED_CHARS);
    }
}
