class BackupThread extends Thread {
    @Test
    public void coreTest() {
        String[][] unstemmedStemmedCases = new String[][] { { POS.NOUN.name(), "dogs", "dog" }, { POS.NOUN.name(), "geese", "goose", "geese" }, { POS.NOUN.name(), "handfuls", "handful" }, { POS.NOUN.name(), "villas", "Villa", "villa" }, { POS.NOUN.name(), "Villa", "Villa", "villa" }, { POS.NOUN.name(), "br", "Br", "BR" }, { POS.NOUN.name(), "heiresses", "heiress" }, { POS.NOUN.name(), "heiress", "heiress" }, { POS.NOUN.name(), "George W. \t\tBush", "George W. Bush" }, { POS.NOUN.name(), "george w. bush", "George W. Bush" }, { POS.NOUN.name(), "mice", "mouse", "mice" }, { POS.NOUN.name(), "internal-combustion engine", "internal-combustion engine" }, { POS.NOUN.name(), "internal combustion engine", "internal-combustion engine" }, { POS.NOUN.name(), "internal combustion engines", "internal-combustion engine" }, { POS.NOUN.name(), "hangers-on", "hanger-on", "hangers-on" }, { POS.NOUN.name(), "hangers on", "hanger-on" }, { POS.NOUN.name(), "letter bombs", "letter bomb" }, { POS.NOUN.name(), "letter-bomb", "letter bomb" }, { POS.NOUN.name(), "I ran", null }, { POS.NOUN.name(), "be an", null }, { POS.NOUN.name(), "are a", null }, { POS.NOUN.name(), " Americans", "American" }, { POS.NOUN.name(), "_slovaks_", "Slovak" }, { POS.NOUN.name(), "superheroes", "superhero", "superheroes" }, { POS.NOUN.name(), "businessmen", "businessman", "businessmen" }, { POS.NOUN.name(), "_", null }, { POS.NOUN.name(), "\n", null }, { POS.NOUN.name(), "\ndog", null }, { POS.NOUN.name(), "dog\n", null }, { POS.NOUN.name(), "\n''", null }, { POS.NOUN.name(), "''\n", null }, { POS.NOUN.name(), "-", null }, { POS.NOUN.name(), "--", null }, { POS.NOUN.name(), "__", null }, { POS.NOUN.name(), "  ", null }, { POS.NOUN.name(), " ", null }, { POS.NOUN.name(), "-_", null }, { POS.NOUN.name(), "_-", null }, { POS.NOUN.name(), " -", null }, { POS.NOUN.name(), "- ", null }, { POS.NOUN.name(), "armful", "armful" }, { POS.NOUN.name(), "attorneys general", "attorney general", "Attorney General" }, { POS.NOUN.name(), "axes", "axis", "ax", "axes", "Axis" }, { POS.NOUN.name(), "bases", "basis", "base", "bases" }, { POS.NOUN.name(), "boxesful", "boxful" }, { POS.NOUN.name(), "Bachelor of Sciences in Engineering", "Bachelor of Science in Engineering" }, { POS.NOUN.name(), "cd", "Cd", "cd", "CD" }, { POS.NOUN.name(), "lines of business", "line of business" }, { POS.NOUN.name(), "SS", "SS" }, { POS.NOUN.name(), "mamma's boy", "mamma's boy" }, { POS.NOUN.name(), "15_minutes", "15 minutes" }, { POS.NOUN.name(), "talks", "talk", "talks" }, { POS.NOUN.name(), "talk", "talk" }, { POS.NOUN.name(), "values", "value", "values" }, { POS.NOUN.name(), "value", "value" }, { POS.NOUN.name(), "wounded", "wounded" }, { POS.NOUN.name(), "yourselves", "yourself", "yourselves" }, { POS.NOUN.name(), "wounding", "wounding" }, { POS.NOUN.name(), "'s Gravenhage", "'s Gravenhage" }, { POS.NOUN.name(), "parts of speech", "part of speech" }, { POS.NOUN.name(), "read/write memory", "read/write memory" }, { POS.NOUN.name(), "roma", "rom", "roma", "Roma" }, { POS.NOUN.name(), "rom", "ROM" }, { POS.ADJ.name(), "KO'd", "KO'd" }, { POS.VERB.name(), "KO'd", "ko", "ko'd" }, { POS.VERB.name(), "booby-trapped", "booby-trap", "booby-trapped" }, { POS.VERB.name(), "bird-dogged", "bird-dog", "bird-dogged" }, { POS.VERB.name(), "wounded", "wound" }, { POS.VERB.name(), "wound", "wind", "wound" }, { POS.ADJ.name(), "wounded", "wounded" }, { POS.VERB.name(), "dogs", "dog" }, { POS.VERB.name(), "abided by", "abide by" }, { POS.VERB.name(), "gave a damn", "give a damn" }, { POS.VERB.name(), "asking for it", "ask for it" }, { POS.VERB.name(), "asked for it", "ask for it" }, { POS.VERB.name(), "accounting for", "account for" }, { POS.VERB.name(), "was", "be", "was" }, { POS.VERB.name(), "founded", "found" }, { POS.VERB.name(), "founder", "founder" }, { POS.VERB.name(), "found", "find", "found" }, { POS.VERB.name(), "names of", null }, { POS.VERB.name(), "names of association football", null }, { POS.ADJ.name(), "founder", "founder" }, { POS.NOUN.name(), "was", "WA" }, { POS.VERB.name(), "cannonball along", "cannonball along" }, { POS.VERB.name(), "accesses", "access" }, { POS.VERB.name(), "went", "go", "went" }, { POS.VERB.name(), "bloging", "blog" }, { POS.VERB.name(), "shook hands", "shake hands", "shook hands" }, { POS.VERB.name(), "Americanize", "Americanize" }, { POS.VERB.name(), "saw", "see", "saw" }, { POS.VERB.name(), "let the cats out of the bag", "let the cat out of the bag" }, { POS.ADJ.name(), "onliner", "online" }, { POS.ADJ.name(), "redder", "red" }, { POS.ADJ.name(), "Middle Eastern", "Middle Eastern" }, { POS.ADJ.name(), "Latin-American", "Latin-American" }, { POS.ADJ.name(), "low-pitched", "low-pitched" } };
        for (final String[] testElements : unstemmedStemmedCases) {
            final POS pos = POS.valueOf(testElements[0]);
            final String unstemmed = testElements[1];
            final String stemmed = testElements[2];
            final List<String> goldStems = new ArrayList<String>();
            for (int i = 2; i < testElements.length; ++i) {
                goldStems.add(testElements[i]);
            }
            assertTrue("goldStems: " + goldStems, areUnique(goldStems));
            final List<String> baseForms = stem(unstemmed, pos);
            String msg = "unstemmed: \"" + unstemmed + "\" " + pos + " gold: \"" + stemmed + "\" output: " + baseForms;
            assertTrue(msg, baseForms.contains(stemmed) || (stemmed == null && baseForms.isEmpty()));
            assertFalse("baseForms: " + baseForms, baseFormContainsUnderScore(baseForms));
            if (baseForms.size() >= 2 && !goldStems.equals(baseForms)) {
                System.err.println("extra variants for \"" + unstemmed + "\": " + baseForms + " goldStems: " + goldStems);
            }
            assertTrue(areUnique(baseForms));
            final List<String> upperBaseForms = stem(unstemmed.toUpperCase(), pos);
            msg = "UPPER unstemmed: \"" + unstemmed + "\" " + pos + " gold: \"" + stemmed + "\" output: " + upperBaseForms;
            assertTrue(msg, upperBaseForms.contains(stemmed) || (stemmed == null && upperBaseForms.isEmpty()));
        }
    }
}
