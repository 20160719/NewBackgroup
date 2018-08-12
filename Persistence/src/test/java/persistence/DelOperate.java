package persistence;

import java.util.List;

public interface DelOperate<K> {
	
	public int operate(List<K> list) throws Exception;

}
