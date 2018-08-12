package persistence;

public class App {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
//		
		CmdOperate<String> cmd = (list) -> {
			return 0;
		};
		
		DelOperate<String> del = (list) -> {
			return 2;
		};
		modify(del);
		modify(cmd);

	}

	public static void modify(DelOperate<String> cmd) {
		try {
			System.out.println(cmd.operate(null));
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
}
