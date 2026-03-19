package br.ufc.crateus.eda.st.ordered;

import br.ufc.crateus.eda.st.ST;

public interface OrderedST <K extends Comparable<K>, V> extends ST<K, V> {
	K min();
	K max();
	void deleteMin();
	void deleteMax();
	K floor (K key);
	K ceiling (K key);
	K select (int i);
	int rank(K key);
	int size(K lo, K hi);
	Iterable<K> keys(K lo, K hi);
}
