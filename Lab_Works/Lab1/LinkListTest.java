public class LinkedListTest{
	public static void main(String[] args) {
		LinkedList obj1 = new LinkedList();


		obj1.addFirst(1);
		obj1.addLast(2);
		obj1.addLast(3);

		// System.out.println(obj1.size());
		assert(obj1.isEmpty() == false);
		assert(obj1.size() == 3);
		assert(obj1.first() == 1);
		assert(obj1.last() == 3);
		assert(obj1.removeFirst() == 1);
		assert(obj1.size() == 2);
		assert(obj1.first() == 2);
		System.out.println("All Test Cases Passed");
	}
}