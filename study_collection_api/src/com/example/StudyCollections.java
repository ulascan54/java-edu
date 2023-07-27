package com.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class StudyCollections {

	public static void main(String[] args) {
		// 1. List: Duplicates, Sortable
		List<String> names = new ArrayList<>();
		// there are two implementations: arraylist, linkedlist
		// ArrayList -> Array
		int[] numbers = { 4, 8, 15, 16, 23, 42 };
		System.out.println(numbers.length);
		System.out.println(numbers[3]);
		// LinkedList-> [4] -> [8] -> [17] ->[15]
		// /\ | /\ |
		// |______| |______|
		names.add("jack");
		names.add("kate");
		names.add("james");
		names.add("ben");
		names.add("kate");
		names.add("jin");
		names.add("sun");
		names.add("kate");
		System.out.println(names.get(0));
		System.out.println(names.get(2));
		System.out.println(names);
		names.sort(String::compareTo);// since java se 8
		System.out.println(names);
		// before java se8: Collections.sort(names);

		// 2. Set: Distinct, Unordered
		Set<String> set = new HashSet<>();
		set.add("jack");
		set.add("kate");
		set.add("james");
		set.add("ben");
		set.add("kate");
		set.add("jin");
		set.add("sun");
		set.add("kate");
		System.out.println(set);
		System.out.println(set.contains("jack"));
		// set is unordered -> you can not ask for indexed elements
		// System.out.println(set.get(2));
		// set does not have sort method:set.sort()
		// linkedHashSet
		Set<String> set2 = new LinkedHashSet<>();
		set2.add("jack");
		set2.add("kate");
		set2.add("james");
		set2.add("ben");
		set2.add("kate");
		set2.add("jin");
		set2.add("sun");
		set2.add("kate");
		System.out.println(set2);
		// treeset
		// Comparator<String> dictionaryOrderDesc= (u,v) -> v.compareTo(u);// sıralamayı
		// tersine çevirdim
		// Comparator<String> dictionaryOrderDesc= (u,v) ->
		// ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE,Integer.MAX_VALUE);//
		// rastgele değerler döner
		Comparator<String> dictionaryOrderDesc = (u, v) -> 0;
		Set<String> set3 = new TreeSet<>(dictionaryOrderDesc);
		set3.add("jack");
		set3.add("kate");
		set3.add("james");
		set3.add("ben");
		set3.add("kate");
		set3.add("jin");
		set3.add("sun");
		set3.add("kate");
		System.out.println("set3:" + set3);

		// 3. Map
		Map<String, Integer> areaCodes = new HashMap<>();
		Map<Integer, String> codeAreas = new HashMap<>();
		Map<String, List<Integer>> areaMultiCodes= new HashMap<>();
		areaMultiCodes.put("ankara", List.of(312));
		areaMultiCodes.put("istanbul", List.of(212,216));
		areaCodes.put("ankara", 312);
		areaCodes.put("istanbul-anadolu", 212);
		areaCodes.put("ankara-avrupa", 216);
		codeAreas.put(312, "ankara");
		codeAreas.put(212, "istanbul-anadolu");
		codeAreas.put(216, "ankara-avrupa");
		System.out.println(areaCodes.get("istanbul-anadolu"));
		System.out.println(codeAreas.get(212));
		for (var entry : areaCodes.entrySet())
			if (entry.getValue() == 312)
				System.out.println(entry.getKey());
		
		System.out.println(areaMultiCodes.get("istanbul"));


	}

}
