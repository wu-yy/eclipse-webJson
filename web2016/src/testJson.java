
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * ʹ��json-lib����ͽ���Json����
 * 
 * @author wuyy
 * @date 2016/7/4
 *
 */
public class testJson {

    /**
     * ����Json����
     * 
     * @return
     */
    public static String BuildJson() {

        // JSON��ʽ���ݽ�������
        JSONObject jo = new JSONObject();

        // ���湹������map��һ��list��һ��Employee����
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("name", "Alexia");
        map1.put("sex", "female");
        map1.put("age", "23");

        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("name", "Edward");
        map2.put("sex", "male");
        map2.put("age", "24");

        List<Map> list = new ArrayList<Map>();
        list.add(map1);
        list.add(map2);

        /*
        Employee employee = new Employee();
        employee.setName("wjl");
        employee.setSex("female");
        employee.setAge(24);
		*/
        // ��Mapת��ΪJSONArray����
        JSONArray ja1 = JSONArray.fromObject(map1);
        // ��Listת��ΪJSONArray����
        JSONArray ja2 = JSONArray.fromObject(list);
        // ��Beanת��ΪJSONArray����
       // JSONArray ja3 = JSONArray.fromObject(employee);

        System.out.println("JSONArray�������ݸ�ʽ��");
        System.out.println(ja1.toString());
        System.out.println(ja2.toString());
       // System.out.println(ja3.toString());

        // ����Json���ݣ�����һ��map��һ��Employee����
        jo.put("map", ja1);
        jo.put("employee", ja2);
        System.out.println("\n���չ����JSON���ݸ�ʽ��");
        System.out.println(jo.toString());

        return jo.toString();

    }

    /**
     * ����Json����
     * 
     * @param jsonString Json�����ַ���
     */
    public static void ParseJson(String jsonString) {

        // ��employeeΪ��������map����
        JSONObject jb = JSONObject.fromObject(jsonString);
        JSONArray ja = jb.getJSONArray("employee");

        List<Map> empList = new ArrayList<Map>();

        // ѭ�����Employee���󣨿����ж����
        for (int i = 0; i < ja.size(); i++) {
        	 Map<String, String> map1 = new HashMap<String, String>();
        	 map1.put("name", ja.getJSONObject(i).getString("name"));
        	 map1.put("sex", ja.getJSONObject(i).getString("sex"));
        	 map1.put("age", ja.getJSONObject(i).getString("age"));
        	 empList.add(map1);
        }

       
        System.out.println("\n��Json����ת��ΪEmployee����");
        for (int i = 0; i < empList.size(); i++) {
            Map<String,String> emp = empList.get(i);
            System.out.println("name: " + emp.get("name") + " sex: "
                    + emp.get("sex") + " age: " + emp.get("age"));
        }
        

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        ParseJson(BuildJson());
    }

}