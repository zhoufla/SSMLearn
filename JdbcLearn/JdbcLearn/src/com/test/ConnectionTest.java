package com.test;

public class ConnectionTest {
	public static void main(String[] args) {
		/*try {
			Connection conn=  DbUtil.getConnection();
			System.out.println(conn==null);
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		/*Map<String,String> map = new HashMap<>();
		map.put("V2", "sdsdsd");
		map.put("V4", "sdsdsd");
		map.put("V5", "sdsdsd");
		map.put("V1", "sdsdsd");
		map.put("V33", "sdsdsd");
		
		Collection<String> keys =map.keySet();
		List<Integer> list = new ArrayList<>();
		for (String key : keys) {
			key = key.replace("V", "");
			list.add(Integer.parseInt(key));
		}
		
		int lenth = list.size();
		Object[] version = new Object[] {list.size()};
		version = (Object[]) list.toArray();
		System.out.println("排序前："+Arrays.toString(version));
		Arrays.sort(version);
		System.out.println("排序后："+Arrays.toString(version));
		int max = Integer.parseInt(version[lenth-1].toString().replace("V", ""));
		System.out.println(max);*/
		
		for (int i=10;i>0;i--)
			System.out.println(i);
	}
}
