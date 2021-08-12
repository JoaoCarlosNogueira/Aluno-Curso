
	import java.util.List;

	import java.util.ArrayList;

	public class Curso<T> {

	  private List<T> itemList;

	  public Curso() {

	    this.itemList = new ArrayList<T>();

	  }

	  public List<T> getItemList() {

	    return this.itemList;

	  }

	  public void add(T item) {

	    this.itemList.add(item);

	  }

	  public void remove(T item) {

	    this.itemList.remove(item);

	  }

	  public String toString() {

	    String result = "";

	    for (T item : getItemList()) {

	      result += "\n" + item.toString();

	    }

	    return result;

	  }
}
