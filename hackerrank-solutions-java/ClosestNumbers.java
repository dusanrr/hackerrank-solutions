public static void closestNumbers(List<Integer> numbers) {
	// Write your code here
	Collections.sort(numbers);
	
	TreeMap<Integer, List<String>> treeMap = new TreeMap<>();
	
	for (int i = 1; i < numbers.size(); i++) 
	{
		int tmp = Math.abs(numbers.get(i)-numbers.get(i-1));
		treeMap.putIfAbsent(tmp, new ArrayList<>());
		treeMap.get(tmp).add(numbers.get(i-1)+ " "+ numbers.get(i));
	}
	
	List<String> res = treeMap.firstEntry().getValue();
	for (String each : res) 
	{
		System.out.println(each);
	}
}