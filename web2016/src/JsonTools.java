import net.sf.json.JSONObject;

public class JsonTools {

	public JsonTools() {

	}

	public static String createJsonString(String key, Object value) {
		String jsonString = null;

		JSONObject jsonObject = new JSONObject();
		jsonObject.put(key, value);
		jsonString = jsonObject.toString();
		return jsonString;
	}

}
