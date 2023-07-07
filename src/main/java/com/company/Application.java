package com.company;


import java.util.*;

public class Application {
    public char findFirstUniqueCharWorksCorrectly(String text) {
        String[] textForAnalysis = text.split(" ");
        ArrayList<String> listStings = new ArrayList<>();
        Collections.addAll(listStings, textForAnalysis);

        LinkedHashMap<Character, Integer> allCharsFromText = new LinkedHashMap<>();
        LinkedList<Character> charsForSimpleAnalysis = new LinkedList<>();
        LinkedHashMap<Character, Integer> linkedHashMapForFirstUniqueChar = new LinkedHashMap<>();
        char firstUniqueChar = 0;

        for (int j = 0; j < listStings.size(); ) {
            char[] charArray = listStings.get(j).toCharArray();

            for (char c : charArray) {
                int count = allCharsFromText.getOrDefault(c, 0);
                allCharsFromText.put(c, count + 1);
            }

            for (Map.Entry<Character, Integer> characterIntegerEntry : allCharsFromText.entrySet()) {
                if (characterIntegerEntry.getValue() == 1) {
                    charsForSimpleAnalysis.add(characterIntegerEntry.getKey());
                    break;
                }
            }
            allCharsFromText.clear();
            j++;
        }

        for (Character forSimpleAnalysis : charsForSimpleAnalysis) {
            int count = linkedHashMapForFirstUniqueChar.getOrDefault(forSimpleAnalysis, 0);
            linkedHashMapForFirstUniqueChar.put(forSimpleAnalysis, count + 1);
        }

        for (Map.Entry<Character, Integer> characterIntegerEntry : linkedHashMapForFirstUniqueChar.entrySet()) {
            if (characterIntegerEntry.getValue() <= 2) {
                firstUniqueChar = characterIntegerEntry.getKey();
                break;
            }
        }
        return firstUniqueChar;
    }

    public static void main(String[] args) {
        System.out.println(new Application().findFirstUniqueCharWorksCorrectly(
                "C makes it easy for you to shoot yourself in the foot. C++ makes that harder, " +
                        "but when you do, it blows away your whole leg. (c) Bjarne Stroustrup"));
    }
}
