import java.util.Iterator;

/**
 * Object-oriented design for a circular array.
 * 
 * @author Gillis Werrebrouck
 */

public class Circular_Array {
    public static void main(final String args[]) {
        CircularArray<Integer> cArray = new CircularArray(5);
        cArray.add(0, 1);
        cArray.add(1, 2);
        cArray.add(2, 3);
        cArray.add(3, 4);
        cArray.add(4, 5);
        System.out.println(cArray.get(0));
        System.out.println(cArray.get(1));
        System.out.println(cArray.get(2));
        System.out.println(cArray.get(3));
        System.out.println(cArray.get(4));
        cArray.rotate(2);
        
        System.out.println("---");
        
        System.out.println(cArray.get(0));

        System.out.println("---");

        for (Integer i : cArray) {
            System.out.println(i);
        }
    }
}

class CircularArray<T> implements Iterable<T> {
    private T[] data;
    private int size;
    private int pointer = 0;

    public CircularArray(int size) {
        this.size = size;
        this.data = (T[]) new Object[size];
    }

    public int convertIndex(int i) {
        if (i < 0) {
            i += this.size;
        }
        i += this.pointer;
        return i % this.size;
    }

    public void add(int index, T item) {
        index = this.convertIndex(index);
        this.data[index] = item;
    }

    public T get(int i) {
        if (0 <= i && i < this.size) {
            i = this.convertIndex(i);
            return this.data[i];
        }
        throw new IndexOutOfBoundsException();
    }

    // shift right
    public void rotate(int positions) {
        this.pointer = this.convertIndex(positions);
    }
	
	public Iterator<T> iterator() {
        return new CircularArrayIterator<T>(this);
    }

    private class CircularArrayIterator<TI> implements Iterator<TI> {
        private int index = -1;
        private TI[] data;
		
		public CircularArrayIterator(CircularArray<TI> cArray) {
            this.data = cArray.data;
        }
		
		@Override
		public boolean hasNext() {
			return this.index < (this.data.length - 1);
		}
		
		@Override
		public TI next() {
            this.index++;
            TI item = data[convertIndex(this.index)];
			return item;
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException("not supported");
		}
	}
}
