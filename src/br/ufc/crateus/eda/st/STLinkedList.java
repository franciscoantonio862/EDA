package br.ufc.crateus.eda.st;

import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class STLinkedList<K, V> implements ST<K, V> {
	
	private List<STEntry<K, V>> list = new LinkedList<>();
	
	private STEntry<K, V> getEntry(K key) {
		for (STEntry<K, V> e : list)
			if (e.getKey().equals(key))
				return e;
		return null;
	}

	@Override
	public V get(K key) {
		STEntry<K, V> e = getEntry(key);
		return (e != null)? e.getValue() : null;
	}
	

	@Override
	public void put(K key, V value) {
		STEntry<K, V> e = getEntry(key); 
		if (value != null) {
			if (e == null) {
				e = new STEntry<>(key, value);
				list.add(e);
			}
			else e.setValue(value);
		}
		else {
			if (e != null) list.remove(e);
		}
	}

	@Override
	public void delete(K key) {
		put(key, null);
	}

	@Override
	public boolean contains(K key) {
		return get(key) != null;
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public Iterable<K> keys() {
		List<K> keys = new LinkedList<>();
		for (Entry<K, V> e : list) 
			keys.add(e.getKey());		
		return keys;
	}
	
	public static void main(String[] args) {
		ST<String, Integer> st = new STLinkedList<String, Integer>();
//		Scanner in = Scanner
		String s = "SEARCH EXAMPLE EXAMPLE SEARCH EXAMPLE";
		for (String a : s.split(" ")) {
			if (!st.contains(a)) st.put(a, 1);
			else st.put(a, st.get(a) + 1);
		}
		
		String max = "";
		st.put(max, 0);
		for (String a: st.keys()) {
			if (st.get(a) > st.get(max))
				max = a;
		}
		
		System.out.println("Palavra com frequencia maior = " + max);
		
//		String s = "SEARCHEXAMPLE";
//		for (int i = 0; i < s.length(); i++) {
//			String c = String.valueOf(s.charAt(i));
//			st.put(c, i);
//		}
//		
//		st.delete("A");
//		st.delete("H");
//		st.delete("S");
//		
//		for (String key : st.keys())
//			System.out.println(key);
//		
	}
}
