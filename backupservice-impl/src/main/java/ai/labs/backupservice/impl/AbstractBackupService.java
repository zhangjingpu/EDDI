package ai.labs.backupservice.impl;

import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author ginccc
 */
abstract class AbstractBackupService {
    static final String BOT_EXT = "bot";
    static final String PACKAGE_EXT = "package";
    static final String DICTIONARY_EXT = "regulardictionary";
    static final String BEHAVIOR_EXT = "behavior";
    static final String OUTPUT_EXT = "output";
    static final Pattern DICTIONARY_URI_PATTERN =
            Pattern.compile("\"eddi://ai.labs.regulardictionary/regulardictionarystore/regulardictionaries/.*?\"");
    static final Pattern BEHAVIOR_URI_PATTERN =
            Pattern.compile("\"eddi://ai.labs.behavior/behaviorstore/behaviorsets/.*?\"");
    static final Pattern OUTPUT_URI_PATTERN =
            Pattern.compile("\"eddi://ai.labs.output/outputstore/outputsets/.*?\"");

    List<URI> extractResourcesUris(String resourceConfigString, Pattern uriPattern) throws CallbackMatcher.CallbackMatcherException {
        List<URI> ret = new LinkedList<>();

        CallbackMatcher callbackMatcher = new CallbackMatcher(uriPattern);
        callbackMatcher.replaceMatches(resourceConfigString, matchResult -> {
            String match = matchResult.group();
            String uri = match.substring(1, match.length() - 1);
            ret.add(URI.create(uri));
            return null;
        });
        return ret;
    }
}
