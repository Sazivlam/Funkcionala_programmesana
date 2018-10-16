
object RTUSet {
/**
* We define a set by its characteristic function
*/
type Set = Int => Boolean

/**
* If  a set contains an element.
*/
def contains(s: Set, elem: Int): Boolean = s(elem)

/**
* Singleton set from one element
*/
def singletonSet(elem: Int): Set = (x: Int) => x == elem

/**
* Union of the two sets
*/
def union(s: Set, t: Set): Set = (x : Int) => (contains(s, x) || contains(t, x))

/**
* Intersection of the two sets
*/
def intersect(s: Set, t: Set): Set = (x : Int) => (contains(s, x) && contains(t, x))

/**
* Difference of two given sets
*/
def diff(s: Set, t: Set): Set = (x : Int) => (contains(s, x) && !contains(t, x))

/**
* Filter
*/
def filter(s: Set, p: Int => Boolean): Set = (x: Int) => contains(s, x) && p(x)
}