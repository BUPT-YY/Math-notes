import java.util.*;


class YyAlgorithm {
	public static int upperBound(long[] a, long key) {
        return upperBound0(a, 0, a.length, key);
    }
	public static int lowerBound(long[] a, long key) {
        return lowerBound0(a, 0, a.length, key);
    }

	public static int upperBound(long[] a, int fromIndex, int toIndex,
									long key) {
        rangeCheck(a.length, fromIndex, toIndex);
        return upperBound0(a, fromIndex, toIndex, key);
    }
	public static int lowerBound(long[] a, int fromIndex, int toIndex,
									long key) {
        rangeCheck(a.length, fromIndex, toIndex);
        return lowerBound0(a, fromIndex, toIndex, key);
    }

	public static int upperBound(short[] a, short key) {
        return upperBound0(a, 0, a.length, key);
    }
	public static int lowerBound(short[] a, short key) {
        return lowerBound0(a, 0, a.length, key);
    }

	public static int upperBound(short[] a, int fromIndex, int toIndex,
									short key) {
        rangeCheck(a.length, fromIndex, toIndex);
        return upperBound0(a, fromIndex, toIndex, key);
    }
	public static int lowerBound(short[] a, int fromIndex, int toIndex,
									short key) {
        rangeCheck(a.length, fromIndex, toIndex);
        return lowerBound0(a, fromIndex, toIndex, key);
    }	

	public static int upperBound(char[] a, char key) {
        return upperBound0(a, 0, a.length, key);
    }
	public static int lowerBound(char[] a, char key) {
        return lowerBound0(a, 0, a.length, key);
    }

	public static int upperBound(char[] a, int fromIndex, int toIndex,
									char key) {
        rangeCheck(a.length, fromIndex, toIndex);
        return upperBound0(a, fromIndex, toIndex, key);
    }
	public static int lowerBound(char[] a, int fromIndex, int toIndex,
									char key) {
        rangeCheck(a.length, fromIndex, toIndex);
        return lowerBound0(a, fromIndex, toIndex, key);
    }	

	public static int upperBound(byte[] a, byte key) {
        return upperBound0(a, 0, a.length, key);
    }
	public static int lowerBound(byte[] a, byte key) {
        return lowerBound0(a, 0, a.length, key);
    }

	public static int upperBound(byte[] a, int fromIndex, int toIndex,
									byte key) {
        rangeCheck(a.length, fromIndex, toIndex);
        return upperBound0(a, fromIndex, toIndex, key);
    }
	public static int lowerBound(byte[] a, int fromIndex, int toIndex,
									byte key) {
        rangeCheck(a.length, fromIndex, toIndex);
        return lowerBound0(a, fromIndex, toIndex, key);
    }

	public static int upperBound(int[] a, int key) {
        return upperBound0(a, 0, a.length, key);
    }
	public static int lowerBound(int[] a, int key) {
        return lowerBound0(a, 0, a.length, key);
    }

	public static int upperBound(int[] a, int fromIndex, int toIndex,
                                   int key) {
        rangeCheck(a.length, fromIndex, toIndex);
        return upperBound0(a, fromIndex, toIndex, key);
    }
	public static int lowerBound(int[] a, int fromIndex, int toIndex,
                                   int key) {
        rangeCheck(a.length, fromIndex, toIndex);
        return lowerBound0(a, fromIndex, toIndex, key);
    }

	public static int upperBound(double[] a, double key) {
        return upperBound0(a, 0, a.length, key);
    }
	public static int lowerBound(double[] a, double key) {
        return lowerBound0(a, 0, a.length, key);
    }

	public static int upperBound(double[] a, int fromIndex, int toIndex,
								double key) {
        rangeCheck(a.length, fromIndex, toIndex);
        return upperBound0(a, fromIndex, toIndex, key);
    }
	public static int lowerBound(double[] a, int fromIndex, int toIndex,
								double key) {
        rangeCheck(a.length, fromIndex, toIndex);
        return lowerBound0(a, fromIndex, toIndex, key);
    }

	public static int upperBound(float[] a, float key) {
        return upperBound0(a, 0, a.length, key);
    }
	public static int lowerBound(float[] a, float key) {
        return lowerBound0(a, 0, a.length, key);
    }

	public static int upperBound(float[] a, int fromIndex, int toIndex,
								float key) {
        rangeCheck(a.length, fromIndex, toIndex);
        return upperBound0(a, fromIndex, toIndex, key);
    }
	public static int lowerBound(float[] a, int fromIndex, int toIndex,
								float key) {
        rangeCheck(a.length, fromIndex, toIndex);
        return lowerBound0(a, fromIndex, toIndex, key);
    }


    public static int upperBound(Object[] a, Object key) {
        return upperBound0(a, 0, a.length, key);
    }
	public static int lowerBound(Object[] a, Object key) {
        return lowerBound0(a, 0, a.length, key);
    }

	public static int upperBound(Object[] a, int fromIndex, int toIndex,
                                   Object key) {
        rangeCheck(a.length, fromIndex, toIndex);
        return upperBound0(a, fromIndex, toIndex, key);
    }
	public static int lowerBound(Object[] a, int fromIndex, int toIndex,
                                   Object key) {
        rangeCheck(a.length, fromIndex, toIndex);
        return lowerBound0(a, fromIndex, toIndex, key);
    }

	//find in [0, a.length)
	public static <T> int upperBound(T[] a, T key, Comparator<? super T> c) {
        return upperBound0(a, 0, a.length, key, c);
    }
	public static <T> int lowerBound(T[] a, T key, Comparator<? super T> c) {
        return lowerBound0(a, 0, a.length, key, c);
    }

	//find in [fromIndex, toIndex)
	public static <T> int upperBound(T[] a, int fromIndex, int toIndex, T key, Comparator<? super T> c) {
		rangeCheck(a.length, fromIndex, toIndex);
		return upperBound0(a, fromIndex, toIndex, key, c);
	}
	public static <T> int lowerBound(T[] a, int fromIndex, int toIndex, T key, Comparator<? super T> c) {
		rangeCheck(a.length, fromIndex, toIndex);
		return lowerBound0(a, fromIndex, toIndex, key, c);
	}

	// Like public version, but without range checks.
	private static int upperBound0(long[] a, int fromIndex, int toIndex, long key) {
		int len = toIndex - fromIndex;
		while(len > 0) {
			int half = len >>> 1;
			int middle = fromIndex + half;
			long midVal = a[middle];
			if(key < midVal) {
				len = half;
			} else {
				fromIndex = middle;
				++fromIndex;
				len -= (half + 1);
			}
		}
		return fromIndex;
	}

	// Like public version, but without range checks.
	private static int upperBound0(int[] a, int fromIndex, int toIndex, int key) {
		int len = toIndex - fromIndex;
		while(len > 0) {
			int half = len >>> 1;
			int middle = fromIndex + half;
			int midVal = a[middle];
			if(key < midVal) {
				len = half;
			} else {
				fromIndex = middle;
				++fromIndex;
				len -= (half + 1);
			}
		}
		return fromIndex;
	}

	// Like public version, but without range checks.
	private static int lowerBound0(int[] a, int fromIndex, int toIndex, int key) {
		int len = toIndex - fromIndex;
		while(len > 0) {
			int half = len >>> 1;
			int middle = fromIndex + half;
			int midVal = a[middle];
			if(midVal < key) {
				fromIndex = middle;
				++fromIndex;
				len -= (half + 1);
			} else {
				len = half;
			}
		}
		return fromIndex;
	}

	// Like public version, but without range checks.
	private static int upperBound0(short[] a, int fromIndex, int toIndex, short key) {
		int len = toIndex - fromIndex;
		while(len > 0) {
			int half = len >>> 1;
			int middle = fromIndex + half;
			short midVal = a[middle];
			if(key < midVal) {
				len = half;
			} else {
				fromIndex = middle;
				++fromIndex;
				len -= (half + 1);
			}
		}
		return fromIndex;
	}

	// Like public version, but without range checks.
	private static int upperBound0(char[] a, int fromIndex, int toIndex, char key) {
		int len = toIndex - fromIndex;
		while(len > 0) {
			int half = len >>> 1;
			int middle = fromIndex + half;
			char midVal = a[middle];
			if(key < midVal) {
				len = half;
			} else {
				fromIndex = middle;
				++fromIndex;
				len -= (half + 1);
			}
		}
		return fromIndex;
	}

	// Like public version, but without range checks.
	private static int upperBound0(byte[] a, int fromIndex, int toIndex, byte key) {
		int len = toIndex - fromIndex;
		while(len > 0) {
			int half = len >>> 1;
			int middle = fromIndex + half;
			byte midVal = a[middle];
			if(key < midVal) {
				len = half;
			} else {
				fromIndex = middle;
				++fromIndex;
				len -= (half + 1);
			}
		}
		return fromIndex;
	}

	// Like public version, but without range checks.
	private static int upperBound0(double[] a, int fromIndex, int toIndex, double key) {
		int len = toIndex - fromIndex;
		while(len > 0) {
			int half = len >>> 1;
			int middle = fromIndex + half;
			double midVal = a[middle];
			if(key < midVal) {
				len = half;
			} else if(key > midVal){
				fromIndex = middle;
				++fromIndex;
				len -= (half + 1);
			} else {
				long midBits = Double.doubleToLongBits(midVal);
				long keyBits = Double.doubleToLongBits(key);
				if(midBits < keyBits)
					len = half;
				else {
					fromIndex = middle;
					++fromIndex;
					len -= (half + 1);
				}
			}
		}
		return fromIndex;
	}

	// Like public version, but without range checks.
	private static int upperBound0(float[] a, int fromIndex, int toIndex, float key) {
		int len = toIndex - fromIndex;
		while(len > 0) {
			int half = len >>> 1;
			int middle = fromIndex + half;
			float midVal = a[middle];
			if(key < midVal) {
				len = half;
			} else if(key > midVal){
				fromIndex = middle;
				++fromIndex;
				len -= (half + 1);
			} else {
				int midBits = Float.floatToIntBits(midVal);
				int keyBits = Float.floatToIntBits(key);
				if(midBits < keyBits)
					len = half;
				else {
					fromIndex = middle;
					++fromIndex;
					len -= (half + 1);
				}
			}
		}
		return fromIndex;
	}

	// Like public version, but without range checks.
	private static <T> int upperBound0(T[] a, int fromIndex, int toIndex, T key, Comparator<? super T> c) {
		int len = toIndex - fromIndex;
		while(len > 0) {
			int half = len >>> 1;
			int middle = fromIndex + half;
			T midVal = a[middle];
			int cmp = c.compare(key, midVal);
			if(cmp < 0) {
				len = half;
			} else {
				fromIndex = middle;
				++fromIndex;
				len -= (half + 1);
			}
		}
		return fromIndex;
	}


	// Like public version, but without range checks.
    private static int upperBound0(Object[] a, int fromIndex, int toIndex,
                                     Object key) {
        int len = toIndex - fromIndex;
		while(len > 0) {
			int half = len >>> 1;
			int middle = fromIndex + half;
			@SuppressWarnings("rawtypes")
			Comparable midVal = (Comparable)a[middle];
			@SuppressWarnings("unchecked")
			int cmp = midVal.compareTo(key);
			if(cmp < 0) {
				len = half;
			} else {
				fromIndex = middle;
				++fromIndex;
				len -= (half + 1);
			}
		}
		return fromIndex;
    }


	static void rangeCheck(int arrayLength, int fromIndex, int toIndex) {
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException(
                "fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
        }
        if (fromIndex < 0)
            throw new ArrayIndexOutOfBoundsException(fromIndex);
        if (toIndex > arrayLength)
            throw new ArrayIndexOutOfBoundsException(toIndex);
    }

}


public class Test {

    

	public static void main(String[] args) {
		double[] a = new double[] {1,2,3,4,5,6,7,8,9.0,9,9.0000000000000001,9.000002,9.000003,10};
		int K = YyAlgorithm.upperBound(a, 9);
		System.out.println(K);
	}
	
	
}
