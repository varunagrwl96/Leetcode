class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
		Queue<Pair<Character, Integer>> pq = new PriorityQueue<>((c1, c2) -> (c2.getValue() - c1.getValue()));
		
		if (a>0)
			pq.add(new Pair<Character, Integer>('a', a));
		if (b>0)
			pq.add(new Pair<Character, Integer>('b', b));
		if (c>0)
			pq.add(new Pair<Character, Integer>('c', c));
		
		while (!pq.isEmpty()) {
			Pair<Character, Integer> first = pq.poll();
			if (sb.length()!=0 && sb.charAt(sb.length()-1) == first.getKey()) {
				if (pq.isEmpty())
					return sb.toString();
				Pair<Character, Integer> second = pq.poll();
				sb.append(second.getKey());
				if (second.getValue()-1>0) {
					pq.add(new Pair<Character, Integer>(second.getKey(), second.getValue()-1));
				}
				pq.add(first);				
			} else {
				int limit = Math.min(2, first.getValue());
				int counter = 0;
				while (counter++<limit) {
					sb.append(first.getKey());
				}
				if (first.getValue()-limit>0)
					pq.add(new Pair<Character, Integer>(first.getKey(), first.getValue()-limit));				
			}
		}	
		return sb.toString();
    }
}